package com.zhishi.designpattern.adapter;

public class AdapterPatternDemo {

    public static void main(String[] args) {
        NewInterface oldInterface = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newInterface = new NewInterfaceImpl();
        oldInterface.newExecute();
        newInterface.newExecute();
        /**
         * 适配器模式
         * 就是你手上有新老两接口和一个老接口的实现类
         * 但是现在系统中面向新接口来开发，老接口的实现类就不能直接用了，不能直接面向老接口来开发
         * 就开发一个老接口到新接口的适配器
         * 适配器是实现了新接口的，但是适配器中持有老接口的实现类的引用
         * 适配器的新接口方法的实现，全部基于老接口实现类的老方法来实现即可
         * 对于调用方而言，只要使用适配器来开发即可，就可以通过面向新街口开发，底层是用老接口的实现类
         */

    }

    /**
     * 定义一个适配器类
     */
    public static class NewInterfaceAdapter implements NewInterface {
        private OldInterface oldInterface;

        public NewInterfaceAdapter(OldInterface oldInterface) {
            this.oldInterface = oldInterface;
        }

        public void newExecute() {
            oldInterface.oldExecute();
        }
    }

    /**
     * 老版本接口
     */
    public static interface OldInterface {
        void oldExecute();
    }

    public static class OldInterfaceImpl implements OldInterface {
        public void oldExecute() {
            System.out.println("老版本接实现的功能逻辑");
        }
    }

    /**
     * 新版本接口
     */
    public static interface NewInterface {
        void newExecute();
    }

    public static class NewInterfaceImpl implements NewInterface {
        public void newExecute() {
            System.out.println("新版本接实现的功能逻辑");
        }
    }
}
