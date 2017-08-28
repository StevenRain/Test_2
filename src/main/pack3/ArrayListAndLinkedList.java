package pack3;

import com.google.common.collect.Lists;

import java.util.LinkedList;

public class ArrayListAndLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = Lists.newLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.forEach(System.out::println);
    }
}
