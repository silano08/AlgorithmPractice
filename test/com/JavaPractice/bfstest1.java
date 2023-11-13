package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/*
* 문제 https://www.acmicpc.net/problem/1926

1. 아이디어
- 2중 for => 값 1 && 방문X => BFS
- BFS 돌면서 그림 개수 +1, 최대값을 갱신

2. 시간복잡도
- BFS : O(V+E)
- V : 500 * 500
- E : 4 * 500 * 500
- V+E : 5 * 250000 = 100만 < 2억 >> 가능!

3. 자료구조
- 그래프 전체 지도 : int[][]
- 방문 : bool[][]
- Queue(BFS)
* */

public class bfstest1 {


    @Test
    public void testFindLargestPicture() {
        // Given a grid as per the problem statement
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 1, 1, 1}
        };

        // Expected values: number of pictures and the area of the largest picture
        int expectedNumberOfPictures = 4;
        int expectedLargestPictureArea = 9;

        // Call the method under test
        PictureAnalysisResult result = solution(grid, 6, 5);

        // Check that the results are as expected
        assertEquals(expectedNumberOfPictures, result.numberOfPictures);
        assertEquals(expectedLargestPictureArea, result.largestPictureArea);
    }

    // This class is used to return the results of the analysis
    class PictureAnalysisResult {
        int numberOfPictures;
        int largestPictureArea;

        public PictureAnalysisResult(int count, int maxValue) {
            this.numberOfPictures = count;
            this.largestPictureArea = maxValue;
        }
    }

    public PictureAnalysisResult solution(int[][] map, int n, int m) { // n이 세로, m이 가로

        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(check[i], false); // 모든 값을 false로 초기화
        }


        int count = 0; // 그림 갯수
        int maxValue = 0; // 그림끼리 1이 얼마나 이어져있는지 = 그림면적

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (map[j][i] == 1 && check[j][i] == false) { // 탐색 시작 조건
                    check[j][i] = true;
                    count += 1;
                    maxValue = Math.max(maxValue, BFS(j, i, n, m, map, check));
                }
            }
        }

        return new PictureAnalysisResult(count, maxValue);
    }

    public int BFS(int y, int x, int n, int m, int[][] map, boolean[][] check) {


        // 배열탐색 01 , 10 , 0-1, -10 -> 상우하좌
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        int area = 1; // 최대 면적

        // 훑은 부분을 트래킹하기위해 Deque사용, 노드 재방문X하도록
        Deque<Point> q = new LinkedList<>();
        q.add(new Point(y, x)); // 현재 위치를 큐에 추가

        while (!q.isEmpty()) {
            Point current = q.poll(); // 덱에서 탐색 대상을 꺼냄
            int ey = current.y;
            int ex = current.x;

            // 해당 탐색 대상을 사방으로 조사함 1인지 이미 체크한 노드인지
            for (int i = 0; i < 4; i++) {
                int ny = ey + dy[i];
                int nx = ex + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] == 1 && !check[ny][nx]) {
                    // 1. 탐색 대상인 y,x가 0을 넘고 2. 탐색 범위를 벗어나지않고 3. map상에서 1이며 4.체크하지 않은 대상일때
                    area += 1; // 최대면적 +1
                    check[ny][nx] = true; // 방문 표시
                    q.add(new Point(ny, nx));
                }
            }
        }

        return area;
    }

}
