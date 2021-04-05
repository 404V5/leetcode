package com.zhishi.designpattern.Factory;

public class WithoutFactoryMethodPettern {

    public static void main(String[] args) {
        Product1 prduct1 = Product1Factory.creatProduct();
        Product2 prduct2 = Product2Factory.creatProduct();
        Product3 prduct3 = Product3Factory.creatProduct();
        prduct1.execute();
        prduct2.execute();
        prduct3.execute();
        /**
         * 问题在哪？
         * 跟模板方法的问题一模一样
         * 就是多个工厂类中，有生产产品的相同的通用逻辑，没有抽取出来，直接复制粘贴放多个工厂里面了
         * 如果那段通用逻辑要修改
         * 就需要很麻烦到所有工厂中修改代码，可能忘记修改某个工厂代码
         */
    }

    public interface Product{
        void execute();
    }
    public static class Product1 implements Product{
        public void execute(){
            System.out.println("产品1的功能逻辑");
        }
    }
    public static class Product2 implements Product{
        public void execute(){
            System.out.println("产品2的功能逻辑");
        }
    }
    public static class Product3 implements Product{
        public void execute(){
            System.out.println("产品3的功能逻辑");
        }
    }

    public static class Product1Factory{
        public static Product1 creatProduct(){
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品1的特殊逻辑");
            return new Product1();
        }
    }

    public static class Product2Factory{
        public static Product2 creatProduct(){
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品2的特殊逻辑");
            return new Product2();
        }
    }

    public static class Product3Factory{
        public static Product3 creatProduct(){
            System.out.println("生产产品的通用逻辑");
            System.out.println("生产产品3的特殊逻辑");
            return new Product3();
        }
    }
}
