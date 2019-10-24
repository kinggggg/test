package com.zeek.java8.shengsiyuan.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * @ClassName MethodReferenceTest
 * @Description
 * @Author liweibo
 * @Date 2019/10/24 10:40 AM
 * @Version v1.0
 **/
public class MethodReferenceTest {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        students.sort((studentParam1, studentParam2) ->
                        Student.compareStudentByScore(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getScore()));

        // 静态方法引用
//        students.sort(Student::compareStudentByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        StudentComparator studentComparator = new StudentComparator();
//        students.sort((studentParam1, studentParam2) -> studentComparator.compareStudentByscore(studentParam1, studentParam2));
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort(studentComparator::compareStudentByscore);
//        students.forEach(student -> System.out.println(student.getScore()));

//        students.sort(Student::compareByScore);
//        students.forEach(student -> System.out.println(student.getScore()));

        List<String> cities = Arrays.asList("qingdao", "chongqing", "tianjin", "beijing");
//        Collections.sort(cities, (city1, city2) -> city1.compareTo(city2));
//        cities.forEach(city -> System.out.println(city));
        Collections.sort(cities, String::compareToIgnoreCase);
        cities.forEach(System.out::println);

    }
}
