/**
 *  Copyright Jirina Kralovcova
 *
 *  This code is part of ALG subject.
 *  You can use it as you want to learn basics of Java.
 *  
 */

package kralovcova.p081.seznam;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Prvek<T> first;
    private Prvek<T> last;

    private static class Prvek<T> {
        T data;
        Prvek<T> dalsi;

        public Prvek(T data, Prvek<T> dalsi) {
            this.data = data;
            this.dalsi = dalsi;
        }
    }

    public MyLinkedList() {
        first = last = new Prvek<T>(null, null);
    }

    public void addFirst(T data) {
        first = new Prvek<T>(data, first);
    }

    public void addLast(T data) {
        Prvek<T> novy = new Prvek<T>(null, null);
        last.data = data;
        last.dalsi = novy;
        last = novy;
    }

    public T removeFirst() {
        if (first == last) {
            return null; // throw new NoSuchElementException("Seznam neobsahuje zadna data");
        }
        Prvek<T> p = first;
        first = first.dalsi;
        return p.data;
    }

    public T getFirst() {
         if (first == last) {
            return null; // throw new NoSuchElementException("Seznam neobsahuje zadna data");
        }
        return first.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private Prvek<T> next;

        public MyIterator() {
            next = first;
        }

        @Override
        public boolean hasNext() {
            return (next != last);
        }

        @Override
        public T next() {
            T data = next.data;
            next = next.dalsi;
            return data;
        }

        @Override
        public void remove() {
            if (next != last) {
                next.data = next.dalsi.data;
                next.dalsi = next.dalsi.dalsi;
            }
        }
    }
}
