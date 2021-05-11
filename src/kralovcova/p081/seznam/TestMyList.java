/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */

package kralovcova.p081.seznam;

import kralovcova.p081.seznam.MyLinkedList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TestMyList {

    public static void main(String[] args) {
        LinkedList ll;
        MyLinkedList<String> mll = new MyLinkedList<String>();

        mll.addFirst("ahoj");
        mll.addFirst("cau");
        mll.addFirst("nazdar");
        mll.addLast("nashle");
        mll.addLast("dobry");
        mll.addLast("kazdy");
        mll.addLast("den");

        for (String s : mll) {
            System.out.println(s);
        }
        System.out.println("");

        System.out.println(mll.removeFirst());
        System.out.println("");
        Iterator<String> iter = mll.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("");


        iter = mll.iterator();
        iter.next();
        iter.remove(); // odstrani druhy prvek

        for (String s : mll) {
            System.out.println(s);
        }
        System.out.println("");

    }
}
