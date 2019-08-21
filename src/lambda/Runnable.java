package lambda;

/**
 * @ClassName Runnable
 * @Description 使用Lambda表达式实现Runnable接口
 * @Author GuanLS
 * @Date 2019/8/21 10:15
 * @Version 1.0
 **/

public class Runnable extends Thread{

    public static void main(String[] args){
        //Java8之前的写法
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名类实现Runnable接口");
            }
        }).start();

        //Java8写法
        new Thread(()->System.out.println("Lambda实现Runnable接口")).start();
    }

}
