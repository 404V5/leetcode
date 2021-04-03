package com.zhishi.designpattern.iterator;

import java.util.HashMap;
import java.util.Map;

/**
 * 不用设计模式
 */

public class WithoutPatternDemo {
    public static void main(String[] args) {
        Student student1= new Student("晓明");
        Student student2= new Student("小王");
        /**
         * 老实现
         */
//        Student[] students = new Student[2];
//        students[0]=student1;
//        students[1]=student2;
        /**
         * 需要换实现
         */
        Map<String,Student> students = new HashMap<String, Student>();
        students.put(student1.getName(),student1);
        students.put(student2.getName(),student2);

        Classroom classroom = new Classroom();
        classroom.setStudents(students);

        /**
         * 老实现
         */
//        Student[] studentsArray= classroom.getStudents();
//        for (Student student :studentsArray ){
//            System.out.println(student);
//        }
        /**
         * 需要换实现
         */
        Map<String,Student> studentsMap= classroom.getStudents();
        for (Student student :studentsMap.values()){
            System.out.println(student);
        }
        /**
         * 如果不用设计模式，直接去遍历类中的集合
         * 一旦这个类对集合的使用改版，比如从数组->map,还有别的可能
         * 一迭代了这个代码，就要改动
         * 如果说代码和业务逻辑很复杂，同事集合类的实现和遍历代码的实现是两个人开发的
         * 成本就很高了，大家又要协调，又要改动
         * 简单来说，这种代码，可扩展性，可维护性，很差
         */
    }

    /**
     * 学生类
     */
    public static class Student {
        private String name;

        public Student(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * 老实现
     */
//    public static class Classroom  {
//        private Student[] students;
//
//        public Student[] getStudents() {
//            return students;
//        }
//
//        public void setStudents(Student[] students) {
//            this.students = students;
//        }
//    }

    /**
     * 换了一个实现
     */
    public static class Classroom  {
        private Map<String,Student> students;

        public Map<String, Student> getStudents() {
            return students;
        }

        public void setStudents(Map<String, Student> students) {
            this.students = students;
        }
    }
}
