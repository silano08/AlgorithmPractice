package com.JavaPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
문제번호 : https://www.acmicpc.net/problem/2667
* 1. 아이디어
- 2중 for문, 값1 && 방문 X -> DFS
- DFS를 통해 찾은 값을 저장 후 정렬 해서 출력
*
2. 시간복잡고
*
* 3. 자료구조
* - 그래프 저장 : int [][]
* - 방문 여부 : bool[][]
* - 결과값 : int[]
*
* */
public class dfs2667 {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int each;
    static int[] dy = {0, 1, 0, -1}; //우하좌상
    static int[] dx = {1, 0, -1, 0};
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine(); // 입력 버퍼 지우기

        map = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 2중 for문 작성
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && check[i][j] == false) { //map에서 1이며 탐색하지 않은 노트
                    // 방문체크 표시
                    check[i][j] = true;
                    // DFS로 크기 구하기 -> 리턴값을 받아오는 구조가 아닌 전역변수를 사용하는쪽으로
                    each = 0;
                    DFS(i, j);
                    result.add(each);
                    // 크기를 결과 리스트에 넣기
                }
            }
        }

        System.out.println(result.size());
        for (int i : result) {
            System.out.println(i);
        }

    }

    // map, check, each
    private static void DFS(int y, int x) { // 행 -> 열 순으로 처리
        each += 1;
        for (int i = 0; i < 4; i++) { // 사방으로 탐색
            int targetY = y + dy[i];
            int targetX = x + dx[i];
            if (targetY >= 0 && targetY < N && targetX >= 0 && targetX < N) { // 범위를 벗어나지 않는지 체크
                if (map[targetY][targetX] == 1 && check[targetY][targetX] == false) {
                    check[targetY][targetX] = true;
                    DFS(targetY, targetX);
                }
            }
        }
    }
}
