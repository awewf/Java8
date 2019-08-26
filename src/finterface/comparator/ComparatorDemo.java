package finterface.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName ComparatorDemo
 * @Description JDK8 Comparator（函数式接口）DEMO
 * @Author GuanLS
 * @Date 2019/8/26 14:56
 * @Version 1.0
 **/
//Comparator比较器从jdk2就有，从jdk8开始该接口变为函数式接口,并且对其进行了增强（增加了一些默认方法和静态方法）
public class ComparatorDemo {

    //对整数列表排序
    private static void test1(){
        List<Integer> list1 = Arrays.asList(5,8,2,10,3,8,9,0,6);
        //对整数列表排序（升序）
        list1.sort(Comparator.naturalOrder());
        //对整数列表排序（降序）
        //list1.sort(Comparator.reverseOrder());
        System.out.println(list1);
    }

    //根据对象属性进行排序
    private static void test2(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张飒",2));
        personList.add(new Person("李四",7));
        personList.add(new Person("王武",5));
        personList.add(new Person("赵生",9));

        //升序排
        personList.sort(Comparator.comparingInt(Person::getAge));
        //降序排
        //personList.sort(Comparator.comparingInt(Person::getAge).reversed());
        System.out.println(personList);
    }

    //根据对象进行排序（价格、速度），排序有先后顺序，不同的顺序将会得到不同的结果
    private static void test3(){
        List<Computer> computerList = new ArrayList<>();
        computerList.add(new Computer("联想",8000,11));
        computerList.add(new Computer("戴尔",9000,12));
        computerList.add(new Computer("惠普",8000,9));
        computerList.add(new Computer("神舟",7000,19));
        computerList.add(new Computer("炫龙",7000,14));

        //先按照价格升序，再按照速度升序
        //computerList.sort(Comparator.comparingInt(Computer::getPrice).thenComparingInt(Computer::getSpeed));
        //先按照价格降序，再按照速度升序
        //computerList.sort(Comparator.comparingInt(Computer::getPrice).reversed().thenComparingInt(Computer::getSpeed));
        //先按照价格降序，再按照速度降序
        //computerList.sort(Comparator.comparingInt(Computer::getPrice).thenComparingInt(Computer::getSpeed).reversed());
        //先按照价格升序，再按照速度降序？
        computerList.sort(Comparator.comparingInt(Computer::getPrice));
        computerList.sort(Comparator.comparingInt(Computer::getSpeed).reversed());

        System.out.println(computerList);
    }

    public static class Person{
        private String name;
        private Integer age;

        public Person(String name,Integer age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{"+
                    "name:"+ name +
                    " ;age:" + age +
                    "}";
        }
    }

    public static class Computer{
        private String name;
        private Integer price;
        private Integer speed;

        public Computer(String name,Integer price,Integer speed){
            this.name = name;
            this.price = price;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getSpeed() {
            return speed;
        }

        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "Computer{"+
                    "name:" + name +
                    " ;price:" + price +
                    " ;speed:" + speed +
                    "}";
        }
    }

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }
}
