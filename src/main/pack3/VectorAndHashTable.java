package pack3;

import java.util.List;
import java.util.Vector;

public class VectorAndHashTable {

    public static void main(String[] args) {
        List<Integer> list = new Vector<>(3);
        long startTime = System.currentTimeMillis();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        list.add(4);
        System.out.println(System.currentTimeMillis() - startTime);
        list.forEach(System.out::println);
    }
}
