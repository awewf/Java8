package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ForEach
 * @Description 使用Lambda表达式对列表进行迭代
 * @Author GuanLS
 * @Date 2019/8/21 11:12
 * @Version 1.0
 **/

public class ForEach {
    public static void main(String[] args){
        List<String>  features = Arrays.asList("a","b","c","d");

        //Java8之前的写法：
        for(String temp : features){
            System.out.println(temp);
        }

        //Java8写法：
        features.forEach(System.out::println);
    }
}
