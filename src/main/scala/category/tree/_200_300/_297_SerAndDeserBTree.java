package category.tree._200_300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import category.tree.TreeNode;

/**
 * 297. Serialize and Deserialize Binary Tree
 */
public class _297_SerAndDeserBTree {
    private static final String spliter = ",";
    private static final String NN      = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) { return null; } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    //
    //public String serialize(TreeNode root) {
    //    if (root == null) { return ""; }
    //    Queue<TreeNode> q = new LinkedList<>();
    //    StringBuilder sb = new StringBuilder();
    //    q.add(root);
    //    while (!q.isEmpty()) {
    //        TreeNode head = q.remove();
    //        if (head == null) {
    //            sb.append("null" + ",");
    //        } else {
    //            q.add(head.left);
    //            q.add(head.right);
    //            sb.append(head.val + ",");
    //        }
    //    }
    //    while (sb.length() >= 5 && sb.substring(sb.length() - 5, sb.length()).equals("null,")) { sb.delete(sb.length() - 5, sb.length()
    //    ); }
    //    return sb.deleteCharAt(sb.length() - 1).toString();
    //}
    //
    //public TreeNode deserialize(String data) {
    //    if (data == null || data.isEmpty()) { return null; }
    //    Queue<TreeNode> nodeQueue = new LinkedList<>();
    //    String[] groups = data.split(",");
    //    TreeNode root = new TreeNode(Integer.parseInt(groups[0]));
    //    nodeQueue.add(root);
    //    int index = 1;
    //    while (!nodeQueue.isEmpty()) {
    //        TreeNode head = nodeQueue.remove();
    //        if (index == groups.length) { break; }
    //        String item = groups[index++];
    //        if (!"null".equals(item)) {
    //            TreeNode left = new TreeNode(Integer.parseInt(item));
    //            head.left = left;
    //            nodeQueue.add(left);
    //        }
    //        if (index == groups.length) {
    //            break;
    //        }
    //        item = groups[index++];
    //        if (!"null".equals(item)) {
    //            TreeNode right = new TreeNode(Integer.parseInt(item));
    //            head.right = right;
    //            nodeQueue.add(right);
    //        }
    //    }
    //    return root;
    //}
}