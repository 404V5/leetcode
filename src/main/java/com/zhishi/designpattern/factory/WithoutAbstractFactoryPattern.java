package com.zhishi.designpattern.factory;

public class WithoutAbstractFactoryPattern {

    public static void main(String[] args) {
        //我们要创建产品A1+产品B1的组合
//        ProductA productA1= ProductA1Factory.creatProduct();
//        ProductB productB1= ProductB1Factory.creatProduct();
//
//        productA1.execute();
//        productB1.execute();

        //变成产品A1+产品B3的组合
        ProductA otherProductA1= ProductA1Factory.creatProduct();
        ProductB otherProductB1= ProductB1Factory.creatProduct();

        otherProductA1.execute();
        otherProductB1.execute();
        /**
         * 问题来了，调整产品组合的这个行为，如果你手动创建产品组合的代码，有100个地方，A1+B1
         * 一旦要调整，就要对100个地方的代码，手动一点一点的去修改，组合的逻辑
         * 不可维护，不可扩展
         */

        //要创建产品A2+产品B2的组合
        ProductA productA2= ProductA2Factory.creatProduct();
        ProductB productB2= ProductB2Factory.creatProduct();

        productA2.execute();
        productB2.execute();

        //要创建产品A3+产品B3的组合
        ProductA productA3= ProductA3Factory.creatProduct();
        ProductB productB3= ProductB3Factory.creatProduct();

        productA3.execute();
        productB3.execute();
    }

    public interface ProductA{
        void execute();
    }
    public static class ProductA1 implements ProductA {
        public void execute(){
            System.out.println("产品1的功能逻辑");
        }
    }
    public static class ProductA2 implements ProductA {
        public void execute(){
            System.out.println("产品2的功能逻辑");
        }
    }
    public static class ProductA3 implements ProductA {
        public void execute(){
            System.out.println("产品3的功能逻辑");
        }
    }

    public interface ProductB{
        void execute();
    }
    public static class ProductB1 implements ProductB {
        public void execute(){
            System.out.println("产品1的功能逻辑");
        }
    }
    public static class ProductB2 implements ProductB {
        public void execute(){
            System.out.println("产品2的功能逻辑");
        }
    }
    public static class ProductB3 implements ProductB {
        public void execute(){
            System.out.println("产品3的功能逻辑");
        }
    }

    public static class ProductA1Factory{
        public static ProductA1 creatProduct(){
            return new ProductA1();
        }
    }

    public static class ProductA2Factory{
        public static ProductA2 creatProduct(){
            return new ProductA2();
        }
    }

    public static class ProductA3Factory{
        public static ProductA3 creatProduct(){
            return new ProductA3();
        }
    }


    public static class ProductB1Factory{
        public static ProductB1 creatProduct(){
            return new ProductB1();
        }
    }

    public static class ProductB2Factory{
        public static ProductB2 creatProduct(){
            return new ProductB2();
        }
    }

    public static class ProductB3Factory{
        public static ProductB3 creatProduct(){
            return new ProductB3();
        }
    }
}
