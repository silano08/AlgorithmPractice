package com.JavaPractice.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfs1844 {

    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동서남북(y,x)
    static int n;
    static int m;
    static boolean[][] visited;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        return bfs(0, 0, maps);
    }

    private int bfs(int x, int y, int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨의 노드 개수
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int nowX = arr[0];
                int nowY = arr[1];

                if (nowX == n - 1 && nowY == m - 1) {
                    return count + 1; // 목적지에 도달하면 현재 count 반환
                }

                for (int[] direction : pos) {
                    int nx = nowX + direction[0];
                    int ny = nowY + direction[1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            count++; // 한 레벨의 모든 노드를 처리한 후 count 증가
        }
        return -1; // 목적지에 도달할 수 없는 경우
    }

}
