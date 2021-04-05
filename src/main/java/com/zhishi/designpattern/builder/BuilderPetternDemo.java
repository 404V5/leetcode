package com.zhishi.designpattern.builder;

public class BuilderPetternDemo {

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.build("值1","值2","值3");
        System.out.println(product);
        /**
         * 好处1：通过Builder接口将复杂构建步骤拆分成了多个部分，代码逻辑清晰，可维护性和扩展性都很好
         * 好处2：将对象构建的过程，封装在director里面，director来给予Builder进行构建，构建逻辑修改，不需要修改
         * 好处3：相对于工厂，又一个很好的抽象设计，director和Builder
         */
    }

    public interface Builder {
        void field1(String value);

        void field2(String value);

        void field3(String value);

        Product create();
    }

    public static class ConcreteBuilder implements Builder {
        private Product product = new Product();

        public void field1(String value) {
            System.out.println("在设置field1之前进行复杂的校验逻辑");
            product.setField1(value);
        }

        public void field2(String value) {
            System.out.println("在设置field2之前进行复杂的数据格式转换逻辑");
            product.setField2(value);
        }

        public void field3(String value) {
            System.out.println("在设置field1直线进行复杂的数据处理逻辑，跟其他对象的数据进行关联");
            product.setField3(value);
        }

        public Product create() {
            return product;
        }
    }

    /**
     * Director是面向builder的接口来编程的
     * Director可以负责控制构建的一个步骤，具体的每个步骤的逻辑封装在具体的builder类中
     * 如果我们此事要更换一整套构建步骤，可以再搞一个全新的builder类就行
     * 但是我们的整个构建步骤是没有改变的
     *
     * 如果整个构建步骤有变化，但是对构建的逻辑是没有影响的
     */
    public static class Director {
        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Product build(String field1, String field2, String field3) {
            builder.field1(field1);
            builder.field2(field1);
            builder.field3(field1);
            return builder.create();
        }

    }


    public static class Product {
        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        @Override
        public String toString() {
            return "Product{field1='" + field1 + "', field2='" + field2 + "', field3='" + field3 + "'}";
        }
    }
}
