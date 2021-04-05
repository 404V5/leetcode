package com.zhishi.designpattern.facade;

public class FacadePatternDemo {

    public static void main(String[] args) {
        //假设是子系统2
        SystemFacade systemFacade = new SystemFacade();
        systemFacade.execute();
        /**
         * 好处1：子系统2不需要care太多的模块，只要care一个门面类的接口就可以了
         * 好处2：如果多个地方都要调用这段逻辑，那么如果这个逻辑变了，只需要门面类一个地方修改就可以了
         */
    }

    /**
     * 子系统1的门面类
     */
    public static class SystemFacade{
        public void execute(){
            //子系统1封装了自己的多个模块，ABC，基于自己多个模块的功能，对外统一暴露出去一个功能
            ModuleA moduleA = new ModuleAImpl();
            ModuleB moduleB = new ModuleBImpl();
            ModuleC moduleC = new ModuleCImpl();
            moduleA.execute();
            moduleB.execute();
            moduleC.execute();
            System.out.println("一段新增的逻辑");
        }
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
