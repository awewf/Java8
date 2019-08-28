package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Sort
 * @Description 测试Arrays.sort与Arrays.parallelSort执行效率
 * @Author GuanLS
 * @Date 2019/8/28 9:50
 * @Version 1.0
 **/

public class Sort {

    //生成一个随机数组
    private static int[] getNumbers(){
        int[] arr = new int[80000000];
        Random random = new Random();

        for (int i=0;i<arr.length;++i){
            arr[i] = random.nextInt(1000)+1;
        }
        return arr;
    }

    @Test
    public void testSort(){
        int[] arrs = getNumbers();
        Long start1 = System.currentTimeMillis();
        Arrays.sort(arrs);
        System.out.print("串行排序时间："+(System.currentTimeMillis()-start1)+"ms");
        Long start2 = System.currentTimeMillis();
        //Java8 新增parallelSort()并行排序
        Arrays.parallelSort(arrs);
        System.out.print("并行排序时间："+(System.currentTimeMillis()-start2)+"ms");

        //数据量越大parallelSort的优势越明显
    }
}
