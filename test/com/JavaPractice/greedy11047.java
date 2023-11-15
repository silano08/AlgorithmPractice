package com.JavaPractice;

import java.util.Collections;
import java.util.Scanner;

/* 문제: https://www.acmicpc.net/problem/11047
풀이개선 참조 : https://github.com/ChangguHan/codingtestbasic/blob/master/BJ11047.py
* 1. 아이디어
* - 거꾸로 for문 큰수부터 더해서 비교
* - while문으로 목표금액보다 크거나 같기 전까지 더함
*
* 2. 시간복잡도
* - O(N) = 1억 < 2억
*
* 3. 변수
* - N 동전개수,K 목표금액 = int
* - coinList = int[]
* - money 목표금액 = int
* - coinNum 현재 얼마까지 채웠는지 = int
*
* */
public class greedy11047 {
    static int N;
    static int K;
    static int[] coinList;
    static int money;
    static int coinNum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        coinList = new int[N];
        for (int i = 0; i < N; i++) {
            coinList[i] = scanner.nextInt();
        }
        scanner.close();

        coinCount();
        System.out.println(coinNum);
    }

    private static void coinCount(){

        for (int i = N-1; i >= 0; i--) {
            // while말고 몫과 나머지로 추가하는법도있음..
            while (true){
                if(money + coinList[i] > K){
                    break;
                }else {
                    money += coinList[i];
                    coinNum += 1;
                }
            }
        }
    }
}
