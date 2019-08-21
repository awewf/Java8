package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MapAndReduce
 * @Description Java8中使用lambda表达式的Map和Reduce示例
 * @Author GuanLS
 * @Date 2019/8/21 15:32
 * @Version 1.0
 **/

public class MapAndReduce {
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
    }
}
