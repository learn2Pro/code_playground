#!/apollo/bin/env /apollo/env/AmazonAwsCli/bin/python
# -*- coding: utf-8 -*-
# vim: et ts=8 sts=4 sw=4 tw=0
from __future__ import absolute_import

import argparse
import distutils.spawn
import subprocess
import sys
from os import environ, pathsep
import os

operations_in_odin = {"register_host": "AddMSToHost", "unregister_host": "RemoveMaterialSetFromHostEntity",
                      "register_user": "AddPermission", "unregister_user": "RemovePermission"}


def abort(msg):
    print(msg)


def execute_script(command_list, success_message, error_message, abort_fn):
    try:
        output = subprocess.check_output(command_list, timeout=100, encoding="utf-8", shell=True)
    except subprocess.CalledProcessError as e:
        output = e.output  # Output generated before error
        code = e.returncode  # Return code
        abort_fn("%s. Output: %s Error: %s" % (error_message, output, code))
    return output


def call_brazil_path(command):
    # add some apollo-specific paths
    paths = pathsep.join([
        environ["PATH"],
        environ["HOME"] + '/.toolbox/bin',
        "/apollo/env/BrazilCLI/bin",
        "/apollo/env/SDETools/bin"
    ])
    # Check $PATH for the tool
    brazil_tool_path = distutils.spawn.find_executable("brazil-path", path=paths)
    if brazil_tool_path is None:
        raise FileNotFoundError("Failed to find brazil-path in any of " + paths)
    print("Using brazil-path located at " + brazil_tool_path + " for " + command)
    # defaults to locale.getpreferredencoding(False) by setting universal_newlines=True
    proc = subprocess.Popen(
        [brazil_tool_path, command],
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        # if universal_newlines=True is removed, the output will be in bytes rather than an encoded str.
        universal_newlines=True
    )
    (brazil_path_out, err) = proc.communicate()
    if proc.returncode != 0:
        print(
            "Error while determining the current workspace-root \
            from brazil-path \nOutput: %s \nError: %s"
            % (brazil_path_out, err)
        )
        return None
    else:
        return brazil_path_out.strip()


def current_workspace_root():
    return call_brazil_path("workspace-root")


def current_package():
    return call_brazil_path("package-name")


def current_host_class():
    return subprocess.check_output("/apollo/bin/getmyhostclass", timeout=100, encoding="utf-8")


def has_valid_kerberos_ticket():
    paths = pathsep.join([
        environ["PATH"],
        environ["HOME"] + "/.toolbox/bin",
        "/usr/kerberos/bin",
        "/usr/bin"
    ])
    klist_path = distutils.spawn.find_executable("klist", path=paths)
    if klist_path is None:
        raise FileNotFoundError("Failed to find klist in any of " + paths)
    print("using klist from " + str(klist_path))
    return True if subprocess.call([klist_path, "-s"]) == 0 else False


def fetch_all_odin_material_set(workspace_root, package):
    output = execute_script(
        ["echo `grep -r --include '*.cfg' 'odin' {}/src/{} |grep 'com.amazon.*'`".format(workspace_root, package)],
        "Succeed fetch all material set!", "Failed fetch all material set,pls check!",
        abort_fn=abort)
    parts = output.strip().strip('\n').split(";")
    material_dev_set, material_prod_set = set(), set()
    use_prod = use_dev = False
    for part in parts:
        if not part: continue
        material_key = part.split("=")[1].strip()[1:-1]
        if "prod" in material_key.lower():
            use_prod = True
            material_prod_set.add(material_key)
        if "dev" in material_key.lower():
            use_dev = True
            material_dev_set.add(material_key)
    if use_dev and use_prod and len(material_dev_set) == len(material_prod_set):
        return material_dev_set
    else:
        return material_prod_set


# odin adminapi AddMSToHost -n com.amazon.access.vdo-dfcs-beta-dynamo-1 -h DEV-DSK-TDERONG/HostClass
def register_all_odin_material_set(material_set, host_class, user_name):
    odin_operation_tool(host_class, material_set, "register", user_name)


def unregister_all_odin_material_set(material_set, host_class, user_name):
    odin_operation_tool(host_class, material_set, "unregister", user_name)


def odin_operation_tool(host_class, material_set, mode, user_name):
    command_for_host = operations_in_odin[mode + "_host"]
    command_for_user = operations_in_odin[mode + "_user"]
    for item in material_set:
        script0 = "odin adminapi {} -n '{}' -h '{}'".format(command_for_host, item, host_class)
        script1 = "odin adminapi {} -n '{}' -o Retrieve -u '{}'".format(command_for_user, item, user_name)
        print("host:[{}],user:[{}]".format(script0, script1))
        execute_script(script0,
                       "Succeed {} material set={}!".format(mode, item),
                       "Failed {} material set={},pls check!".format(mode, item), abort_fn=abort)
        execute_script(script1,
                       "Succeed {} material set={}!".format(mode, item),
                       "Failed {} material set={},pls check!".format(mode, item), abort_fn=abort)


def main(prog, *args):
    parser = argparse.ArgumentParser(description="scan and register odin material set")
    parser.add_argument(
        "-m",
        "--mode",
        help="[register,unregister]",
        required=True,
    )
    parser.set_defaults(enable_apollo_calls=False)

    args = vars(parser.parse_args())
    current_user = os.getlogin()
    if not has_valid_kerberos_ticket():
        abort(
            "There doesn't seem to be a valid kerberos ticket available.\
             Please run kinit -f and try again."
        )

    workspace_root = current_workspace_root()
    package = current_package()
    host_class = current_host_class()

    if workspace_root is None or package is None:
        abort(
            "Unable to determine the current workspace root/package. \
             Please confirm that you are in a valid brazil package path."
        )

    print("Current workspace root is: %s" % workspace_root)
    print("Current Package is : %s" % package)
    material_set = fetch_all_odin_material_set(workspace_root, package)
    if args["mode"] == "register":
        register_all_odin_material_set(material_set, host_class, current_user)
    elif args["mode"] == "unregister":
        unregister_all_odin_material_set(material_set, host_class, current_user)


# state directory would be $workspace_root/AAA/{PACKAGE}-{user}


if __name__ == "__main__":
    main(*sys.argv)
