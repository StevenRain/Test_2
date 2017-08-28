package pack3;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Collection {

    private static List<Integer> getEmptyList() {
        return Lists.newArrayList();
    }

    public static void main(String[] args) {
        List<Integer> parentList = Lists.newArrayList(1, 2, 3, 4, 5);
        parentList.forEach(System.out::print);
        System.out.println();

        List<Integer> subList = parentList.subList(0, 2);
        subList.forEach(System.out::print);
        System.out.println();

        List<Integer> emptyList = getEmptyList();
        emptyList.add(1);
        emptyList.forEach(System.out::println);

        Integer[] numbers = emptyList.toArray(new Integer[0]);
        System.out.println(numbers[0]);
    }
}
