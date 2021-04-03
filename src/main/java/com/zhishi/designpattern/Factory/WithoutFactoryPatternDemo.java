package com.zhishi.designpattern.Factory;

public class WithoutFactoryPatternDemo {

    public static void main(String[] args) {
        /**
         * 不再使用Product就会报错，只能修改
         */
//        Product product = new Product("测试产品");
//        System.out.println(product);
        Product2 product = new Product2("测试产品");
        System.out.println(product);
        /**
         * 有什么问题
         * 如果你直接面向一个类来编程，new来创建类的实现的话，你就是后面就会死的很惨
         * 我国如果对Product，要更换一个类，换一个类的实现
         * 此时就必须在创建这个类实例的地方，都要修改一下这个代码
         * 如果你有100个地方，都创建了product这个类的实例
         * 你需要在100个地方都去修改这个new Product()的这段代码
         * 代码可维护性，可扩展性之差，惨不忍睹
         */
    }

    /**
     * 不在使用
     */
//    public static class Product{
//        private String name;
//
//        public Product(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public String toString() {
//            return "Product{" + "name='" + name + '}';
//        }
//    }

    public static class Product2{
        private String name;

        public Product2(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" + "name='" + name + '}';
        }
    }
}
