package Optional;

import org.junit.Assert;

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

        //1、创建Optional实例
        //访问 emptyOpt 变量的值会导致 NoSuchElementException。
        //Optional<User> emptyOpt = Optional.empty();
        //emptyOpt.get();

         User user = new User("张三","123");
        //如果明确对象不为null，使用of()
        //Optional<User> opt = Optional.of(user);
        //若对象不确定是否是null，使用ofNullable()
        Optional<User> opt = Optional.ofNullable(user);

        //2、访问Optional对象的值
        //Assert.assertTrue(opt.isPresent());//验证是否有值
        //Assert.assertEquals(user1.getUserName(),opt.get().getUserName());
        //验证是否有值的另外一种方式，该方式除了执行检查，还接受一个参数，如果对象不为空，就对执行传入的Lambda表达式
        opt.ifPresent(a -> Assert.assertEquals(a.getUserName(),user.getUserName()));

        //3、返回默认值
        //orElse()、orElseGet()区别：
        //1.当对象为空而返回默认对象时，行为并无差异；
        //2.两个Optional对象都包含非空值,两个方法都会返回对应的非空值.不过,orElse()方法仍然创建了User对象.与之相反,orElseGet()方法不创建User对象。
        User user1 = null;
        //(1)使用orElse()方法 (user1是null ,所以返回了作为默认值的user)
        User result = Optional.ofNullable(user1).orElse(user);
        Assert.assertEquals(result.getUserName(),user.getUserName());

        User user2 = new User("李四","233");
        //如果对象初始值不为空，则默认值会被忽略
        User result1 = Optional.ofNullable(user2).orElse(user);
        Assert.assertEquals(result1.getUserName(),"李四");

        //(2)、使用orElseGet()方法
        // 在有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果
        User result3 = Optional.ofNullable(user1).orElseGet(()->user);
        Assert.assertEquals(result3.getUserName(),"张三");

        //4、返回异常
        //除了orElse()和orElseGet()方法，Optional还定义了orElseThrow()API,它会在对象为空的时候抛出异常，而不是返回备选的值
//        User result4 = Optional.ofNullable(user1)
//                .orElseThrow(()->new IllegalArgumentException());

        //5、对Optional值进行转换
        //(1)、map()函数
        String userName = Optional.ofNullable(user1).map(u->u.getUserName()).orElse("王虎");
        Assert.assertEquals(userName,"王虎");

        //(2)、flatMap()
        user.setPosition("duoduo");
        String position = Optional.ofNullable(user).flatMap(u->u.getPosition()).orElse("123");
        Assert.assertEquals(position,"duoduo");

        //6、对Optional值进行过滤
        Optional<User> result5 = Optional.ofNullable(user).filter(u->u.getUserName()!=null && u.getUserName().contains("张三"));
        Assert.assertTrue(result5.isPresent());
    }



}
