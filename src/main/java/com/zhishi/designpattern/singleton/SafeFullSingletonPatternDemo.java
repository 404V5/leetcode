package com.zhishi.designpattern.singleton;

public class SafeFullSingletonPatternDemo {
    public static class Singleton {
        private static Singleton instance;

        private Singleton() {

        }

        /**
         * 不是完美了
         * 因为不同的JVM的编译器问题，可能导致说，这种情况下还是，线程不安全的
         *
         */
        public static Singleton getInstance() {

            /**
             * 1，如果线程1和线程2都执行到了这一步，然后此时线程1判断发现还是null
             * 3，线程2此时判断发现null == instance，也会进去
             */
            if (null == instance) {
                /**
                 * 2，线程1就会进来，此时线程1停止，切换到线程2
                 * 4，线程2也会进来，此时切换到线程1
                 *
                 * 5，线程1，发现这里需要加锁，在这里加锁，获取到了这个锁
                 * 7，线程2过来，线程2发现说，我也想要在这里加锁，发现这个锁被人加了，线程2挂起等待别人释放锁
                 * 11，此时切换成线程2，线程2发现索贝释放，然后在这里加锁
                 */
                synchronized (SafeFullSingletonPatternDemo.class) {
                    //6，线程1就进来，此时切换到线程2
                    //8，切换回线程1，线程1此时在这里，再次判断null == instance
                    //12，线程2就进来了，double check，如果这里没有null == instance这个判断，
                    //那么线程2就会再次创建一个实例，但是这里是双重检查，线程2又判断了一下null == instance？否，不是null
                    if (null == instance) {
                        //9，线程1就会进来，创建一个实例
                        instance = new Singleton();
                    }
                }
            }
            //10，这边出来以后，线程1就释放锁了
            //13，线程2跳出来，直接获取一个instance返回了，此时instance为县城创建的实例
            return instance;
        }
    }
}
