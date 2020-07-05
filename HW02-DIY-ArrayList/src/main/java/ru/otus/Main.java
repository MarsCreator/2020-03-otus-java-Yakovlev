package ru.otus;

import java.util.Collections;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        DIYArrayList<Integer> diyList = new DIYArrayList<>(20);
        Integer[] addDiyList = IntStream.range(1, 100).boxed().toArray(Integer[]::new);
        Collections.addAll(diyList, addDiyList);

        System.out.println(" diyList output: ");
        diyList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        DIYArrayList<Integer> diySecondList = new DIYArrayList<>(20);
        Integer[] addDiySecondList = IntStream.range(101, 200).boxed().toArray(Integer[]::new);
        Collections.addAll(diySecondList, addDiySecondList);

        System.out.println(" diySecondList output: ");
        diySecondList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        Collections.copy(diyList, diySecondList);

        System.out.println(" diyList after copy: ");
        diyList.forEach(e -> System.out.print(e + " "));
        System.out.println();

        Collections.sort(diySecondList, (o1, o2) -> o2 - o1);

        System.out.println(" diySecondList after sort: ");
        diySecondList.forEach(e -> System.out.print(e + " "));
    }
}
