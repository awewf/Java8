package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName CreateStringList
 * @Description 通过过滤创建一个String列表
 * @Author GuanLS
 * @Date 2019/8/21 16:09
 * @Version 1.0
 **/

public class CreateStringList {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("abc","bcd","defg","as");

        List<String> newStrList = strList.stream().filter(a->a.length()>2).collect(Collectors.toList());
        System.out.println("newStrList = " + newStrList);
    }
}
