package com.zhishi.designpattern.builder;

public class WithoutBuilderPettern {
    public static void main(String[] args) {
        //构建这个复杂的product对象
        Product product = new Product();
        //设置field1属性
        System.out.println("在设置field1之前进行复杂的校验逻辑");
        product.setField1("值1");
        //设置field2属性
        System.out.println("在设置field2之前进行复杂的数据格式转换逻辑");
        product.setField2("值2");
        //设置field3属性
        System.out.println("在设置field1直线进行复杂的数据处理逻辑，跟其他对象的数据进行关联");
        product.setField3("值3");
        /**
         * 上面是简化的逻辑，其实对于一些有几十个字段，甚至是上百个字段的复杂对象的构建
         * 上面那段代码会极度膨胀，非常复杂
         * 一个就是卓，大量代码大量堆积在一起，维护性非常差，可读性非常差，依托代码，跟屎一样，读不懂，没法改
         * 另外一个，就是说，这段逻辑，如果在多个地方都有使用的话，一旦这段逻辑出现了一些变化，那么可能就需要
         * 在多个地方修改这一大坨跟shi一样的代码
         * 把不同的构造步骤，抽取成某一个方法
         */

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
    }
}
