package com.zhishi.designpattern.facade;

public class WithoutFacadePatternDemo {

    public static void main(String[] args) {
        //假设我们这里是子系统2，要给予子系统1的3个模块的功能实现一个业务逻辑
        ModuleA moduleA = new ModuleAImpl();
        ModuleB moduleB = new ModuleBImpl();
        ModuleC moduleC = new ModuleCImpl();
        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
        /**
         * 有什么问题？
         * 问题一：对应子系统1来说，维护成本太高了，就是因为要care多个子系统2的模块，如果芝士3个模块还凑合，如果是20个模块呢？
         * 那子系统1对子系统2的各个模块的了解就要很多，维护成本很高
         * 问题二：就这个多个模块组成一个功能，如果在子系统1的多个地方都使用带了，那么这段代码就会在多个地方都有重复，复制粘贴的过程，
         * 一旦这段业务逻辑修改了比如还要加入一个模块D的功能，可能就要修改多个地方的代码，会能的很麻烦
         */
    }

    public interface ModuleA {
        void execute();
    }

    public static class ModuleAImpl implements ModuleA {
        public void execute() {
            System.out.println("实现子系统1模块A的功能");

        }
    }

    public interface ModuleB {
        void execute();
    }

    public static class ModuleBImpl implements ModuleB {
        public void execute() {
            System.out.println("实现子系统1模块B的功能");
        }
    }

    public interface ModuleC {
        void execute();
    }

    public static class ModuleCImpl implements ModuleC {
        public void execute() {
            System.out.println("实现子系统1模块C的功能");
        }
    }
}
