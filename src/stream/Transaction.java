package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @ClassName Transaction
 * @Description 发现type为grocery的所有交易, 然后返回以交易值降序排序的交易ID集合
 * @Author GuanLS
 * @Date 2019/8/21 16:39
 * @Version 1.0
 **/

public class Transaction {
    private final int id;
    private final Integer value;
    private final Type type;

    public Transaction(int id,Integer value,Type type) {
        this.id = id ;
        this.value = value;
        this.type = type ;
    }

    public enum Type{//枚举变量
        A,B,C,D,GROCERY;
    }

    public int getId() { return id;}
    public Integer getValue () {return value;}
    public Type getType() {return type;}

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 10, Transaction.Type.GROCERY));
        transactions.add(new Transaction(3, 30, Transaction.Type.GROCERY));
        transactions.add(new Transaction(6, 60, Transaction.Type.GROCERY));
        transactions.add(new Transaction(5, 50, Transaction.Type.GROCERY));
        transactions.add(new Transaction(2, 20, Transaction.Type.A));
        transactions.add(new Transaction(4, 40, Transaction.Type.C));

        // JDK 7 发现type为grocery的所有交易
        List<Transaction> groceryTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getType() == Transaction.Type.GROCERY) {
                groceryTransactions.add(t);
            }
        }

//        List<Integer> listInt = new ArrayList<>();
//        //默认自然排序，即升序
//        Collections.sort(listInt);

        // Collections 集合工具类；Arrays数组工具类
        Collections.sort(groceryTransactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                //降序
                return o2.getValue().compareTo(o1.getValue());
                //升序
                //return o1.getValue().compareTo(o2.getValue());
            }
        });
        //将数据倒置，并非排序
        //Collections.reverse(groceryTransactions);

        // 交易ID 获取
        List<Integer> transactionIds = new ArrayList<>();
        for (Transaction t : groceryTransactions) {
            transactionIds.add(t.getId());
        }
        System.out.println(transactionIds);//[6, 5, 3, 1]

        // JDK 8 如果发现type为grocery的所有交易, 然后返回以交易值降序排序的交易ID集合
        List<Integer> transactionsIds = transactions.stream()
                .filter(t-> t.getType()==Type.GROCERY)//对流中数据进行过滤
                //.sorted(comparator.comparing(Transaction::getValue))//comparing默认升序排序
                .sorted(Comparator.comparing(Transaction::getValue).reversed())//先升序排，然后将数据倒置
                .map(Transaction::getId)       //用于需要对流中的值进行某中形式的转换
                .collect(Collectors.toList());//将流中的所有元素收集到List中
        System.out.println(transactionsIds);

    }
}
