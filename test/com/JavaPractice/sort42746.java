package com.JavaPractice;

import java.util.*;

public class sort42746 {


    public static void main(String[] args) {
        int[] numbers = {0,2,0}; // 힙을 써볼까

        System.out.println(solution(numbers));
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
