package com.JavaPractice;


import java.util.Scanner;

/*
문제링크 : https://www.acmicpc.net/problem/2559
* 1. 아이디어
* - 연달아있는 세개를 더한값과 그 다음값을 더하고 인덱스 1의 값을 뺀값이 같은지 비교하며 max값 갈아치우기
*
* 2. 시간복잡도
* - O(N) = 100,000 < 2억 (가능)
* 3. 변수
* - max값 : int
* - 온도리스트 : int[]
* - 앞 포인터의 합, 뒷포인터의 합
* */
public class twoPointer2559 {
    static int N;
    static int K;
    static int[] tempList;
    static int preSum = 0;
    static int nextSum;
    static int max;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        tempList = new int[N];
        for (int i = 0; i < N; i++) {
            tempList[i] = scanner.nextInt();
        }

        countMax();
        System.out.println(max);
    }

    private static void countMax(){
        for (int i = 0; i < K; i++) {
            preSum += tempList[i];
        }
        max = preSum;

        for (int i = 0; i < N-K; i++) {
            nextSum = preSum - tempList[i] + tempList[i+K];
            max = Math.max(preSum,nextSum);
            preSum = nextSum;
        }

    }
}
