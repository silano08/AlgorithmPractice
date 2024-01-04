package com.JavaPractice.backtracking;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제번호 : https://www.acmicpc.net/problem/15649
* 1. 아이디어
- 백트래킹 재귀함수안에서 for돌면서 숫자선택(방문여부확인)
- 재귀함수에서 M개 선택할 경우 print
*
2. 시간복잡도
* N! -> 최대 8까지
* 3. 자료구조
* - 방문 여부 : bool[][]
* - 결과값 : int[]
*
* */
public class backTracking15649 {
    static int N;
    static int M;
    static boolean[] check;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 입력 버퍼 지우기

        check = new boolean[N+1];

        recursion(0);
    }

    // 1~N까지, 중복없이 M개 고르는것 , ex) N=4, M=2
    private static void recursion(int num){
        if(num == M){
            for (int i = 0; i < M; i++) {
                System.out.print(result.get(i) + " ");
            }
            return;
        }else{
            for (int i = 1; i < N+1; i++) {
                if(check[i] == false){
                    check[i] = true;
                    result.add(i);
                    recursion(num+1);
                    // 위의 재귀가 실행되어 출력한 후로 다시 이줄로 돌아올테니 check, result 를 재사용하기위해 원복시키는 코드
                    result.remove(result.size() - 1);
                    check[i] = false;
                }

            }
        }

    }


    /* 모범답안*/



//    static int N, M;
//    static boolean[] chk;
//    static int[] rs;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        M = sc.nextInt();
//
//        rs = new int[M];
//        chk = new boolean[N + 1];
//
//        recur(0);
//
//        sc.close();
//    }
//
//    static void recur(int num) {
//        if (num == M) {
//            for (int i = 0; i < M; i++) {
//                System.out.print(rs[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            if (!chk[i]) {
//                chk[i] = true;
//                rs[num] = i;
//                recur(num + 1);
//                chk[i] = false;
//            }
//        }
//    }
}
