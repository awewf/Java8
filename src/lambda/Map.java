package lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Map
 * @Description Java8中使用lambda表达式的Map
 * @Author GuanLS
 * @Date 2019/8/21 15:32
 * @Version 1.0
 **/

public class Map {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(100,200,300,400);
        double total = 0;

        //Java8之前的写法
        for(Integer temp : list){
            double price = temp + .12*temp;
            total = total + price;
            System.out.println("price = " + price);
        }
        System.out.println(total);

        //Java8写法
        //list.stream().map((c)->c+.12*c).forEach(System.out::println);
        double bill = list.stream().map((c)->c+.12*c).reduce((b,c)->b+c).get();
        System.out.println(bill);

        //对列表中的每个元素应用函数
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String g7Countries = G7.stream().map(a->a.toUpperCase()).collect(Collectors.joining(","));
        System.out.println("g7Countries="+g7Countries);

        //赋值不同的值，创建一个子列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().distinct().map((a)->a*a).collect(Collectors.toList());
        System.out.println("distinct = " + distinct);

        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt(a->a).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }
}
