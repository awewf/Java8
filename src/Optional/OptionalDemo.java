package Optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName OptionalDemo
 * @Description jdk8 Optional Demo
 * @Author GuanLS
 * @Date 2019/8/26 17:15
 * @Version 1.0
 **/
//Optional类主要解决空指针异常(NullPointerException)
public class OptionalDemo {
    public static void main(String[] args) {

//        Optional<User> emptyOpt = Optional.empty();
//        emptyOpt.get();

        //User user = null;
        //如果明确对象不为null，使用of()
        //Optional<User> opt = Optional.of(user);
        //若对象不确定是否是null，使用ofNullable()
        //Optional<User> opt = Optional.ofNullable(user);

        User user1 = new User("张三","123");
        Optional<User> opt = Optional.ofNullable(user1);

    }


}
