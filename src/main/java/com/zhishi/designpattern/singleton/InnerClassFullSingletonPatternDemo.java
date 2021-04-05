package com.zhishi.designpattern.singleton;

/**
 * 这才是我们实际开发中，最最常用的单例模式，内部类的实现
 */
public class InnerClassFullSingletonPatternDemo {
    /**
     * 可以做到饱汉模式
     * 内部类，只要没有被使用，就不会初始化，Singleton的实例就不会创建
     * 在第一次有人调用getInstance方法的时候，内部类就会初始化，创建一个Singleton的实例
     * 然后java能确保的一点是，类静态初始化的过程，一定只会执行一次
     */
    public static class Singleton {

        private Singleton() {

        }

        private static class InnerHolder{
            public static final Singleton instance = new Singleton();
        }

        public static Singleton getInstance() {
            return InnerHolder.instance;
        }
    }
}
