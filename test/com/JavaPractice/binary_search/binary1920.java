package com.JavaPractice.binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class binary1920 {
    static int N;
    static ArrayList<Integer> nums = new ArrayList<>();
    static int M;
    static int[] targetList;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            nums.add(scanner.nextInt());
        }

        Collections.sort(nums);

        M = scanner.nextInt();

        targetList = new int[M];
        for (int i = 0; i < M; i++) {
            targetList[i] = scanner.nextInt();
        }

        scanner.close();

        for (int t:targetList) {
            binarySearch(0,N-1,t);
        }
    }

    private static void binarySearch(int st, int en, int target) {
        if (st == en) {
            if(nums.get(st) == target){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
            return;
        }

        int mid = (st + en) / 2;
        if (nums.get(mid) < target) {
            binarySearch(mid + 1, en, target);
        } else {
            binarySearch(st, mid, target);
        }
    }
}
