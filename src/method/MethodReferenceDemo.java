package method;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @ClassName MethodReferenceDemo
 * @Description jdk8方法的引用Demo
 * @Author GuanLS
 * @Date 2019/8/26 16:24
 * @Version 1.0
 **/

public class MethodReferenceDemo {

    public static class Car{

        //Supplier接口产生一个给定类型的结果
        public static  Car create(final Supplier<Car> supplier){
            return supplier.get();//new Car();
        }

        public static void collide(final Car car){
            System.out.println("Collided" + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }

    }

    public static void main(String[] args) {
        //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        Car car = Car.create(Car::new);
        Car car1 = Car.create(Car::new);
        Car car2 = Car.create(Car::new);
        Car car3 = new Car();
        List<Car> carList = Arrays.asList(car,car1,car2,car3);
        System.out.println("===================构造器引用========================");
        //静态方法引用：它的语法是Class::static_method，实例如下：
        carList.forEach(Car::collide);
        System.out.println("===================静态方法引用========================");
        //特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        carList.forEach(Car::repair);
        System.out.println("==============特定类的任意对象的方法引用================");
        //特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create(Car::new);
        carList.forEach(police::follow);
        System.out.println("===================特定对象的方法引用===================");
    }
}
