package com.study.example.sync;

import com.study.anno.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

@NotThreadSafe
public class VectorExample2 {

    //java.util.ConcurrentModificationException 不要在遍历过程中对更新集合，可以做个标识，在遍历完成后在更新
    private static void test1(Vector<Integer> vector) {//foreach
        for (Integer i : vector) {
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> vector) {//iterator
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(3)) {
                vector.remove(next);
            }
        }
    }

    private static void test3(Vector<Integer> vector) {//for
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equals(3)) {
                vector.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector=new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }

}
