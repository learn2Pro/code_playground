package org.learn2pro.test;

public class SingletonOuter {
    private SingletonOuter(){}
    private static class SingletonInner{
        private static SingletonOuter INSTANCE = new SingletonOuter();
    }

    public static SingletonOuter getInstance(){
        return SingletonInner.INSTANCE;
    }

}
