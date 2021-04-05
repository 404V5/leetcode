package com.zhishi.designpattern.Factory;

public class FactoryMethodPettern {

    public static void main(String[] args) {
        Product product1 = Product1Factory.get().createProduct();
        Product product2 = Product2Factory.get().createProduct();
        Product product3 = Product3Factory.get().createProduct();
        product1.execute();
        product2.execute();
        product3.execute();
    }

    public interface Product {
        void execute();
    }

    public static class Product1 implements Product {
        public void execute() {
            System.out.println("产品1的功能逻辑");
        }
    }

    public static class Product2 implements Product {
        public void execute() {
            System.out.println("产品2的功能逻辑");
        }
    }

    public static class Product3 implements Product {
        public void execute() {
            System.out.println("产品3的功能逻辑");
        }
    }

    public static abstract class AbstractProductFactory {
        public Product createProduct() {
            commonCreate();
            return specificCreate();
        }

        private void commonCreate() {
            System.out.println("生产产品的通用逻辑");
        }

        protected abstract Product specificCreate();
    }

    public static class Product1Factory extends AbstractProductFactory {
        private static final Product1Factory instance = new Product1Factory();

        public static Product1Factory get(){
            return instance;
        }

        private Product1Factory(){

        }
        public Product specificCreate() {
            System.out.println("生产产品1的特殊逻辑");
            return new Product1();
        }

    }

    public static class Product2Factory extends AbstractProductFactory {
        private static final Product2Factory instance = new Product2Factory();

        public static Product2Factory get(){
            return instance;
        }

        private Product2Factory(){

        }
        public Product specificCreate() {
            System.out.println("生产产品1的特殊逻辑");
            return new Product2();
        }
    }

    public static class Product3Factory extends AbstractProductFactory {
        private static final Product3Factory instance = new Product3Factory();

        public static Product3Factory get(){
            return instance;
        }

        private Product3Factory(){

        }
        public Product specificCreate() {
            System.out.println("生产产品1的特殊逻辑");
            return new Product3();
        }
    }
}
