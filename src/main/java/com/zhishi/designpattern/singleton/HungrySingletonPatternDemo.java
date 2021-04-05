package com.zhishi.designpattern.singleton;

public class HungrySingletonPatternDemo {
    public static void main(String[] args) {
        Singleton singleton= Singleton.getInstance();
        singleton.execute();
    }
    public static class Singleton {
        /**
         * 第一步:直接就是讲这个类的实例在创建出来，赋予static final修饰的变量
         * statci:就是一个类的静态变量
         * final:这个变量的引用第一次初始化赋予之后，就再也不能修改引用
         */
        private static final Singleton instance = new Singleton();

        /**
         * 第二步:将构造函数搞成private私有的
         * 此时除了这个类自己本身，其他任何人都不能创建他的这个实例对象
         */
        private Singleton() {

        }

        /**
         * 第三步:给一个static静态方法，返回自己唯一的内部实例
         */
        public static Singleton getInstance() {
            return instance;
        }

        public void execute(){
            System.out.println("单例类的方法");
        }
    }
}
