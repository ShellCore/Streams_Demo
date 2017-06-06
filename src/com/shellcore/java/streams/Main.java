package com.shellcore.java.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Cesar. 06/06/2017.
 */
public class Main {

    public static final int MAX_VALUE = 255;
    public static final int MAX_NUMBER_SIZE = 20;
    public static final int MIN_FILTER_VALUE = 150;


    public static void main(String[] args) {

        // Sorting demo
        Main mainInstance = new Main();
        mainInstance.oldSort();
        mainInstance.lambdaSort();

        // Filtering demo
        mainInstance.oldFilter();
        mainInstance.lambdaFilter();
    }

    public List<Integer> generateRandomList() {
        List<Integer> numberList = new ArrayList<>();
        Random generator = new Random();

        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            numberList.add(generator.nextInt(MAX_VALUE));
        }

        return numberList;
    }

    public void oldSort() {
        System.out.println("Ordering the old way");
        List<Integer> unorderedList = generateRandomList();
        System.out.println(unorderedList);

        // Sorting in the old way
        Collections.sort(unorderedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        // Print the list already ordered
        System.out.println(unorderedList);
        System.out.println();
    }

    public void lambdaSort() {
        System.out.println("Ordering the Lambda way");
        List<Integer> unorderedList = generateRandomList();
        System.out.println(unorderedList);

        unorderedList.sort((x, y) -> x.compareTo(y));

        // Print the list already ordered
        System.out.println(unorderedList);
        System.out.println();
    }

    public void oldFilter() {
        System.out.println("Filtering the old way");
        List<Integer> CompleteList = generateRandomList();
        System.out.println(CompleteList);

        List<Integer> filteredList = new ArrayList<>();

        for (Integer value : CompleteList) {
            if (value > MIN_FILTER_VALUE) {
                filteredList.add(value);
            }
        }

        // Print the filtered list
        System.out.println(filteredList);
        System.out.println();
    }

    public void lambdaFilter() {
        System.out.println("Filtering the Lambda way");
        List<Integer> completeList = generateRandomList();
        System.out.println(completeList);

        List<Integer> filteredList = completeList.stream()
                .filter(x -> x > MIN_FILTER_VALUE)
                .collect(Collectors.toList());

        // Print the filtered list
        System.out.println(filteredList);
        System.out.println();
    }
}
