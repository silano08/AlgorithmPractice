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
                room[nowPoint[0]][nowPoint[1]] = 2; // 청소한 곳은 2로 마킹
                cleanUpCount += 1;
            }

            boolean cleaned = false;
            int originalSide = side; // 현재 방향을 저장해둔다.

            // 사방으로 청소할 칸이 있는지 검사
            for (int i = 0; i < 4; i++) {
                side = (side + 3) % 4; // 왼쪽으로 회전
                int y = nowPoint[0] + dy[side];
                int x = nowPoint[1] + dx[side];

                if (y >= 0 && y < N && x >= 0 && x < M && room[y][x] == 0) {
                    nowPoint[0] = y;
                    nowPoint[1] = x;
                    cleaned = true;
                    break; // 청소하러 이동
                }
            }

            if (!cleaned) { // 사방에 청소할 칸이 없다면
                // 반대 방향을 계산하여 후진
                side = (originalSide + 2) % 4; // 반대 방향
                int y = nowPoint[0] + dy[side];
                int x = nowPoint[1] + dx[side];

                // 벽이 아니면 후진
                if (y >= 0 && y < N && x >= 0 && x < M && room[y][x] != 1) {
                    nowPoint[0] = y;
                    nowPoint[1] = x;
                } else {
                    stop = true; // 더 이상 후진할 수 없으므로 중지
                }
                side = originalSide; // 방향을 원래대로 돌려놓는다.
            }
        }
    }

}
