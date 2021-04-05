package com.zhishi.designpattern.factory;

/**
 * 我们在项目中，大量的用spring ioc这块功能，其实本身就是在实践工厂模式
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        Product product = ProductFactory.create();
        product.execute();
        /**
         * 如果此时用100个地方都需要获取Product实例
         * 但是此时Product实现类改了
         * 我们只要修改一个地方即可，就是ProductFactory中
         */
    }

    public interface Product {
        void execute();
    }

    //废弃
//    public static class ProductImpl1 implements Product {
//        public void execute() {
//            System.out.println("产品1的功能实现");
//        }
//    }

    public static class ProductImpl2 implements Product {
        public void execute() {
            System.out.println("产品1的功能实现");
        }
    }

    public static class ProductFactory {
        public static Product create() {
            //ProductImpl1废弃，只需要改这里
//            return new ProductImpl1();
            return new ProductImpl2();
        }
    }
}
