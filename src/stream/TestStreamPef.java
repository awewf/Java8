package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName TestStreamPef
 * @Description 测试Stream与parallelStream的性能差异
 * @Author GuanLS
 * @Date 2019/8/28 11:15
 * @Version 1.0
 **/

// stream()创建串行流；
// parallelStream()创建并行流(通过默认的ForkJoinPool 实现并发，将一个列表分成多个块，并行执行)
public class TestStreamPef {

    @Test
    public void testStreamPef(){
        List<Integer> list = getNumbers();
        Long start1 = System.currentTimeMillis();
        list.stream().forEach((t)->doSome());
        System.out.println("Stream执行时间："+(System.currentTimeMillis()-start1)+"ms");

        Long start2 = System.currentTimeMillis();
        list.parallelStream().forEach((t)->doSome());
        System.out.println("parallelStream执行时间："+(System.currentTimeMillis()-start2)+"ms");
    }

    private static void doSome(){
        try {
            Thread.sleep(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取一个随机的list
    private List<Integer> getNumbers(){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i=1;i<=5000000;i++){
            list.add(random.nextInt(500)+1);
        }
        return list;
    }

}
