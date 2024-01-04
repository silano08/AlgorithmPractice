package com.JavaPractice.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class kakao_lv2_1829 {
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        // m이 세로, n이 가로

        boolean[][] check = new boolean[m][n];
        int count = 0; // 영역 가짓수
        int maxValue = 0; // 최대 영역

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(check[i][j] == false && picture[i][j] != 0){
                    count+= 1; // 한번 탐색할때마다 영역 가짓수 늘림
                    int area = BFS(i,j,m,n,picture,check,picture[i][j]);
                    maxValue = Math.max(maxValue,area);
                }
            }
        }

        answer[0] = count;
        answer[1] = maxValue;

        return answer;
    }

    private int BFS(int y, int x ,int m, int n, int[][] map, boolean[][] isVisited, int targetColor){
        // 하나의 영역이 얼마나 이어져있는지 계산해서 돌려줘야함
        // 상하좌우 설정
        int[] dy = {0,1,0,-1};
        int[] dx = {1,0,-1,0};

        // 영역의 크기
        int area = 1;
        // 큐에 현재 탐색 시작점을 넣고
        Queue<int[]> queue = new LinkedList<>();
        int[] point = {y,x}; // 배열 생성
        queue.add(point); // queue에 배열 추가
        isVisited[y][x] = true;

        // 현재 탐색 시작점에서 상하좌우을 탐색, 큐가 다 빌때까지 계속해서 탐색
        while(!queue.isEmpty()){
            int[] nowPoint = queue.poll();
            int cy = nowPoint[0];
            int cx = nowPoint[1];

            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                // 영역들이 그림의 너비를 넘지않고, 타겟컬러이며, 방문하지 않았을때
                if(ny >= 0 && ny < m && nx >= 0 && nx < n && isVisited[ny][nx] == false && map[ny][nx] == targetColor){
                    area+= 1;
                    int[] newPoint = {ny,nx}; // 배열 생성
                    queue.add(newPoint);
                    isVisited[ny][nx] = true;
                }
            }
        }

        return area;
    }
}
