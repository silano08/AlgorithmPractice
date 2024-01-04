package com.JavaPractice.sort;

import java.util.*;

public class sort42746 {


    public static void main(String[] args) {
        // 1. 단순 숫자 array정렬
        // 2. 숫자 array reverse정렬
        int[] numbers = {0,2,0}; // 힙을 써볼까

        Integer[] arr = {5, 3, 8, 2, 1, 4};
        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(Collections.reverseOrder());

        Arrays.sort(arr, (a, b) -> {
            return b - a;
        });

        // 2-1. 2차원배열 정렬
        // 3. compareTo
        // 4. 문자열 정렬

        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        int[][] arr1 = {{3, 2}, {1, 5}, {4, 1}};
        Arrays.sort(arr1, (a, b) -> Integer.compare(b[0], a[0]));


    }

    public static String solution(int[] numbers) {


        Integer[] integerNumbers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            integerNumbers[i] = numbers[i];
        }

        Arrays.sort(integerNumbers, (a, b) -> {
            String numA = Integer.toString(a);
            String numB = Integer.toString(b);
            return (numB+numA).compareTo(numA+numB);
        });

        StringBuilder result = new StringBuilder();
        for (int num : integerNumbers) {
            result.append(num);
        }



        if(result.toString().charAt(0) == '0'){
            return "0";
        }

        return result.toString();
    }

}
