package com.zhishi.designpattern.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Proxy proxy = new Proxy(subject);
        proxy.request();
    }
    public interface Subject {
        void request();
    }

    public static class ConcreteSubject implements Subject {
        public void request() {
            System.out.println("执行请求");
        }
    }

    public static class Proxy implements Subject {
        private Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        public void request() {
            //
            System.out.println("执行额外的条件判断，考虑是否要调用Subject的request方法");
            boolean invoke = true;
            if (invoke) {
                subject.request();
            }

        }
    }
}
