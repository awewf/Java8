package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @ClassName PredicateDemo
 * @Description Lambda表达式使用Predicate
 * @Author GuanLS
 * @Date 2019/8/21 11:21
 * @Version 1.0
 **/

public class PredicateDemo {
    public static void main(String[] args){
        List<String> language = Arrays.asList("Java","Scala","C++","Lisp","Go");

        //Java8之前的写法
//        Predicate<String> predicate1 = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("J");
//            }
//        };
//        predicate1.test("Java");

        System.out.println("Languages which starts with J :");
        filter(language,(str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(language,(str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(language,(str) -> true);

        System.out.println("Print no language : ");
        filter(language,(str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(language,(str) ->str.length()>4);

        //可以用and()、or()和negate()逻辑函数来合并Predicate，
        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLengthLong = (n) -> n.length() == 4;
        language.stream()
                .filter(startWithJ.and(fourLengthLong))
                .forEach((n)->System.out.println("nName, which starts with 'J' and four letter long is :"+n));
    }

    public static void filter(List<String> list, Predicate<String> predicate){

//        for (String temp : list){
//            if (predicate.test(temp)){
//                System.out.println(temp);
//            }
//        }
        //Java8写法
        list.stream().filter(predicate::test).forEach(System.out::println);
    }

}
