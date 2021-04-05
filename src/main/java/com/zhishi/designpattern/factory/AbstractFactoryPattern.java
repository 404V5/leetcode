package com.zhishi.designpattern.factory;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        //产品A1+产品B1 ->产品A1+产品B3
        ProductA firstProductA= Factory1.get().creatProductA();
        ProductB firstProductB= Factory1.get().creatProductB();
        firstProductA.execute();
        firstProductB.execute();
        //产品A2+产品B2
        ProductA secondProductA= Factory2.get().creatProductA();
        ProductB secondProductB= Factory2.get().creatProductB();
        secondProductA.execute();
        secondProductB.execute();
        //产品A3+产品B3
        ProductA thirdProductA= Factory3.get().creatProductA();
        ProductB thirdProductB= Factory3.get().creatProductB();
        thirdProductA.execute();
        thirdProductB.execute();
        /**
         * 哪怕你有100个地方定义了产品组合，要调整组合的逻辑，只要修改一个工厂就可以了
         */
    }

    public interface ProductA {
        void execute();
    }

    public static class ProductA1 implements ProductA {
        public void execute() {
            System.out.println("产品1的功能逻辑");
        }
    }

    public static class ProductA2 implements ProductA {
        public void execute() {
            System.out.println("产品2的功能逻辑");
        }
    }

    public static class ProductA3 implements ProductA {
        public void execute() {
            System.out.println("产品3的功能逻辑");
        }
    }

    public interface ProductB {
        void execute();
    }

    public static class ProductB1 implements ProductB {
        public void execute() {
            System.out.println("产品1的功能逻辑");
        }
    }

    public static class ProductB2 implements ProductB {
        public void execute() {
            System.out.println("产品2的功能逻辑");
        }
    }

    public static class ProductB3 implements ProductB {
        public void execute() {
            System.out.println("产品3的功能逻辑");
        }
    }

    public interface Factory {
        ProductA creatProductA();

        ProductB creatProductB();
    }

    public static class Factory1 implements Factory {
        private static final Factory1 instance = new Factory1();

        private Factory1() {

        }

        public static Factory get() {
            return instance;
        }

        public ProductA creatProductA() {
            return new ProductA1();
        }

        public ProductB creatProductB() {
//            return new ProductB1();
            return new ProductB3();
        }
    }

    public static class Factory2 implements Factory {
        private static final Factory2 instance = new Factory2();

        private Factory2() {

        }

        public static Factory get() {
            return instance;
        }

        public ProductA creatProductA() {
            return new ProductA2();
        }

        public ProductB creatProductB() {
            return new ProductB2();
        }
    }

    public static class Factory3 implements Factory {
        private static final Factory3 instance = new Factory3();

        private Factory3() {

        }

        public static Factory get() {
            return instance;
        }

        public ProductA creatProductA() {
            return new ProductA3();
        }

        public ProductB creatProductB() {
            return new ProductB3();
        }
    }

}
