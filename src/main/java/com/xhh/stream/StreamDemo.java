package com.xhh.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@AllArgsConstructor
@NoArgsConstructor
@Data
class User {
    private Integer id;
    private String name;
    private int age;
}

public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 22);
        User u2 = new User(12, "b", 23);
        User u3 = new User(13, "c", 24);
        User u4 = new User(14, "d", 25);
        User u5 = new User(16, "e", 26);
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        //select username from student where id = and age>24 and

        list.stream().filter(user -> {
            return  user.getId() % 2 == 0;
        }).filter(user -> {
            return user.getAge()>24;
        }).map(user -> {
            return user.getName().toUpperCase();
        }).sorted(((o1, o2) -> {
            return o2.compareTo(o1);
        })).limit(1).forEach(System.out::println);


        //==============
        /*
        Function<String,Integer> function = s -> {
            return s.length();
        };
        System.out.println(function.apply("132"));

        Predicate<String> predicate = s -> {
            return s.isEmpty();
        };
        System.out.println(predicate.test(""));

        Consumer<String> consumer = s -> {
            System.out.println("Consumer"+s);
        };
        consumer.accept("s");

        Supplier<String> supplier = () -> {
            return "s";
        };
        System.out.println(supplier.get());
        */

    }

}
