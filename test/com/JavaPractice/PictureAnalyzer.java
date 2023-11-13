package com.JavaPractice;

import java.awt.Point;
import java.util.*;

public class PictureAnalyzer {
//
//    // BFS 함수 정의
//    public int bfs1(int y, int x, int n, int m, int[][] map, boolean[][] chk) {
//        int rs = 1;
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{x, y});
//
//        // 네 방향 탐색을 위한 배열 (상, 우, 하, 좌)
//        int[] dy = {0, 1, 0, -1};
//        int[] dx = {1, 0, -1, 0};
//
//        while (!q.isEmpty()) {
//            int[] current = q.poll();
//            int ey = current[0];
//            int ex = current[1];
//
//            for (int k = 0; k < 4; k++) {
//                int ny = ey + dy[k];
//                int nx = ex + dx[k];
//
//                if (0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] == 1 && !chk[ny][nx]) {
//                    rs++;
//                    chk[ny][nx] = true;
//                    q.add(new int[]{nx, ny});
//                }
//            }
//        }
//        return rs;
//    }
//
//    // 메인 메서드 또는 다른 메서드에서 사용
//    public void analyzePicture(int n, int m, int[][] map) {
//        boolean[][] chk = new boolean[n][m];
//        int cnt = 0;
//        int maxv = 0;
//
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < m; i++) {
//                if (map[j][i] == 1 && !chk[j][i]) {
//                    chk[j][i] = true;
//                    cnt++;
//                    maxv = Math.max(maxv, bfs1(j, i, n, m, map, chk));
//                }
//            }
//        }
//
//        System.out.println(cnt);
//        System.out.println(maxv);
//    }

    // 테스트를 위한 메인 메서드
//    public static void main(String[] args) {
//        PictureAnalyzer analyzer = new PictureAnalyzer();
//        int n = 6; // 행의 개수
//        int m = 5; // 열의 개수
//        int[][] map = {
//                {1, 1, 0, 1, 1},
//                {0, 1, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {1, 0, 1, 1, 1},
//                {0, 0, 1, 1, 1},
//                {0, 0, 1, 1, 1}
//        };
//
//        analyzer.analyzePicture(n, m, map);
//    }


    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int count = 0;
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};


    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nowX = arr[0];
            int nowY = arr[1];

            for (int i = 0; i < pos.length; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && !visited[nx][ny]) {
                    count++;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        boolean zero = true;
        List<Integer> answer = new ArrayList<>();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) {
                    zero = false;
                }
            }
        }

        if (zero == true) {
            System.out.println("0");
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0;
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        System.out.println(answer.get(answer.size() - 1));
    }
}
