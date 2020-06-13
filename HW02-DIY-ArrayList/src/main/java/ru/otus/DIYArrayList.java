package ru.otus;

import java.util.*;

public class DIYArrayList<T> implements List<T> {

    private Object[] array;
    private final int buffer = 20;
    private int size = 0;
    private int lastPoint = -1;

    public DIYArrayList(int size) {
        array = new Object[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object object) {
        for (Object element : array) {
            if (object.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new DIYIterator();
    }

    @Override
    public Object[] toArray() {
        return (T[]) array;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[]) array, 0, size, c);
    }

    @Override
    public boolean add(T element) {
        lastPoint++;
        if (lastPoint >= array.length) {
            array = Arrays.copyOf(array, array.length + buffer);
        }
        array[lastPoint] = element;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
        return (T) array[index];
    }

    @Override
    public T set(int index, T obj) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is not correct");
        }
        array[index] = obj;
        return obj;
    }

    private T element(int index) {
        return (T)array[index];
    }

    @Override
    public void add(int i, T t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(obj)) {
                return i;
            }
        }
        return 1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new DIYListIterator<>(this);
    }

    class DIYListIterator<E> implements ListIterator<E> {

        private DIYArrayList<E> list;
        private  int pointer = 0;

        public DIYListIterator(DIYArrayList<E> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E next() {
            E res = list.get(pointer);
            pointer++;
            return  res;
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            list.set(pointer-1, e);
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

    private class DIYIterator implements Iterator<T>{
        int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer != size();
        }

        @Override
        public T next() {
            if (pointer > size()) {
                throw new NoSuchElementException();
            }
            T element = element(pointer);
            pointer++;
            return element;
        }
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException();
    }
}
