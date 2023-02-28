package ua.com.alevel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    private static final int SIZE = 1_000_000;
    private static final int ITERATION = 1_00;

    private final List<Integer> arrayList = new ArrayList<>();
    private final List<Integer> linkedList = new LinkedList<>();

    public void start() {
//        List list = new ArrayList();
//        list.add("string");
//
//        Object object = list.get(0);
//        String s = (String) object;

        add();
//        get();
//        update();
//        delete();
    }

    private void add() {
        for (int j = 0; j < ITERATION; j++) {
            System.out.println("j = " + j);
            long start = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                arrayList.add(i); // O(n)
            }
            long end = System.currentTimeMillis() - start;
            System.out.println("arrayList add end = " + end);

            start = System.currentTimeMillis();
            for (int i = 0; i < SIZE; i++) {
                linkedList.add(i); // O(n)
            }
            end = System.currentTimeMillis() - start;
            System.out.println("linkedList add end = " + end);
//            arrayList.clear();
//            linkedList.clear();
        }
    }

    private void get() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.get(i); // O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("arrayList get end = " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.get(i); // O(n)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("linkedList get end = " + end);
    }

    private void update() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.set(i, i + 1); // O(1)
//            arrayList.remove(i);
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("arrayList update end = " + end);

        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.set(i, i + 1); // O(n)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("linkedList update end = " + end);
    }

    private void delete() {
        Iterator<Integer> arrayListIterator = arrayList.iterator();
        long start = System.currentTimeMillis();
//        arrayList.clear();
        while (arrayListIterator.hasNext()) {
            arrayListIterator.next();
            arrayListIterator.remove(); // O(n)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("arrayList delete end = " + end);

        Iterator<Integer> linkedListIterator = linkedList.iterator();
        start = System.currentTimeMillis();
        while (linkedListIterator.hasNext()) {
            linkedListIterator.next();
            linkedListIterator.remove(); // O(1)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("linkedList delete end = " + end);
    }
}
