package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streamm {
    public static void main(String[] args) {

       List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 1000));
        }

        List<String> filtered = numbers.stream()
                .filter( num -> num % 5 == 0 )
                .map( integer ->  Math.pow(integer, 2))
                .map(str -> "Kvadrat: " + str)
                .collect(Collectors.toList());

        List<User> users = new ArrayList<>();
        users.add(new User("Anton", 50));
        users.add(new User("Andrew", 55));

        long count = users.stream()
                .filter(user -> user.getAge() < 40)
                .count();

        System.out.println(count);

    }

    private static List<String> map(List<Integer> numbers){
        List<String> result = new ArrayList<>();
        for (int i: numbers) {
            result.add("Number: " + i);
        }
        return result;
    }

    private static List<Integer> filter(List<Integer> list, Predicatee predicatee) {
        List<Integer> result = new ArrayList<>();
        for (int i : list) {
            if (predicatee.test(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
