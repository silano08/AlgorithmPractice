package com.JavaPractice;

import java.util.Scanner;

public class simulation14503 {

    static int N;
    static int M;
    static int[][] room;
    static int[] nowPoint;
    static int side;

    static int[] dy = {-1, 0, 1, 0}; //우하좌상 동남서북 -> 북동남서0123
    static int[] dx = {0, 1, 0, -1};

    static int cleanUpCount;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 줄에서 N과 M을 읽어옵니다.
        N = scanner.nextInt();
        M = scanner.nextInt();

        // 둘째 줄에서 1번과 2번의 값을 nowPoint 배열에 할당하고
        // 3번의 값을 side 변수에 할당합니다.
        nowPoint = new int[2];
        nowPoint[0] = scanner.nextInt();
        nowPoint[1] = scanner.nextInt();
        side = scanner.nextInt();

        // 세 번째 줄부터 마지막 줄까지 room 배열을 읽어옵니다.
        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = scanner.nextInt();
            }
        }

        // 입력 값을 출력하여 확인할 수 있습니다.
        System.out.println("N: " + N + ", M: " + M);
        System.out.println("nowPoint: " + nowPoint[0] + " " + nowPoint[1]);
        System.out.println("side: " + side);
        System.out.println("room:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();


        cleanUp();

        System.out.println("cleanUpCount: " + cleanUpCount);
    }

    private static void cleanUp() {
        boolean stop = false;
        while (!stop) {
            if (room[nowPoint[0]][nowPoint[1]] == 0) {
                room[nowPoint[0]][nowPoint[1]] = 1;
                cleanUpCount += 1;
            }

            boolean sideChange = false;
            // 사방으로 청소할 칸이 있는지 검사
            for (int i = 0; i < 4; i++) {
                int y = nowPoint[0] + dy[i];
                int x = nowPoint[1] + dx[i];
                if (room[y][x] == 0) {
                    sideChange = true;
                }
            }

            if (sideChange = true) { // 사방에 청소할 칸이 있다면 해당 방향으로 전진
                int y = nowPoint[0] + dy[side];
                int x = nowPoint[1] + dx[side];

                if (y > 0 && y < N && x > 0 && y < M) { // 벽을 뚫고 나가지 않도록 범위 검사
                    if (room[y][x] == 0) { // 그리고 청소되지 않은 칸이라면 전진
                        nowPoint[0] = y;
                        nowPoint[1] = x;
                    }
                }
            } else {
                // 사방에 청소할 칸이 없다면 해당 방향으로 후진

                int y = nowPoint[0] - dy[side];
                int x = nowPoint[1] - dx[side];

                if (y > 0 && y < N && x > 0 && y < M) { // 벽을 뚫고 나가지 않도록 범위 검사
                    // 이때는 청소된 칸이어도 범위를 넘지않으면 후진
                    nowPoint[0] = y;
                    nowPoint[1] = x;
                }else{
                    stop = true;
                }
            }

        }

    }


}
