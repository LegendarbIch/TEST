package testexpresion;

import java.util.*;

public class abc {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("BB");
        list.add("A");

        Map<String, Integer> result = countWords(list);
        System.out.println(result);

    }
    public static Map<String, Integer> countWords(List<String> input) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String value: input) {
            int count = countMap.getOrDefault(value, 0);
            count++;
            countMap.put(value, count);
        }
        return countMap;
    }
}
