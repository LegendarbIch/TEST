package streamAPI;

import java.util.ArrayList;
import java.util.List;

public class Streamm {
    public static void main(String[] args) {
//        new Thread(
//            () -> System.out.println(1)).start();
//
//        Director director = new Director();
//        String result = director.working((int n)->{
//            for (int i = 0; i < n; i++) {
//                System.out.println("работаю");
//            }
//            return "normas";
//        }, 5);
//        System.out.println(result);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random()*1000));
        }
        List<Integer> filtered = filter(numbers, new Predicatee() {
            @Override
            public boolean test(int a) {
                return a % 5 == 0;
            }
        });
        for (int i:
             filtered) {
            System.out.println(i);
        }

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
