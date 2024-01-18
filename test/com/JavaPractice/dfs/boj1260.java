package com.JavaPractice.dfs;

import java.util.*;

public class boj1260 {
    static int N; // 정점 개수
    static int M; // 간선 개수
    static int V; // 탐색 시작
    static int[][] nodes;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        visited = new boolean[N + 1];  // 노드 번호가 1부터 시작하므로 N + 1

        nodes = new int[M][2];  // 간선 정보를 저장할 배열

        for (int i = 0; i < M; i++) {  // M번 반복
            nodes[i][0] = sc.nextInt();
            nodes[i][1] = sc.nextInt();
        }

        // nodes를 탐색할때 값이 작은것부터 탐색해야하니 nodes 두번째 값을 기준으로 정렬해야함
        Arrays.sort(nodes,(a,b) -> {
            if(a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

//        System.out.println("-- dfs --");
        dfs(V);
        sb.append("\n");

        visited = new boolean[N + 1];
//        System.out.println("-- bfs --");
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int target){
        visited[target] = true;
//        System.out.println("visit node"+target);
        sb.append(target + " ");
        for (int[] node : nodes) {
            if (node[0] == target && !visited[node[1]]) { // 현재 노드와 연결되어 있고 아직 방문하지 않은 노드일 경우
                dfs(node[1]);
            }
            else if (node[1] == target && !visited[node[0]]) { // 간선의 다른 방향도 확인
                dfs(node[0]);
            }
        }
    }

    private static void bfs(int target){
        Queue<Integer> q = new LinkedList<>();
        q.add(target);
        visited[target] = true;

        while (!q.isEmpty()){
            int current = q.poll();
//            System.out.println("visit node"+ current);
            sb.append(current + " ");

            for (int[] node : nodes) {
                if (node[0] == current && !visited[node[1]]) { // 현재 노드와 연결되어 있고 아직 방문하지 않은 노드일 경우
                    visited[node[1]] = true;
                    q.add(node[1]);

                }else if (node[1] == current && !visited[node[0]]) { // 간선의 다른 방향도 확인
                    visited[node[0]] = true;
                    q.add(node[0]);
                }
            }

        }
    }
}
