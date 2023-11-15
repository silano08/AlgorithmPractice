package com.JavaPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
* 1. 아이디어
* - MST 기본문제, 외우기
* - 간선을 인접리스트에 집어넣기
* - 힙에 시작점 넣기
* - 힙이 빌때까지 다음의 작업을 반복
*   - 힙의 최소값 꺼내서, 해당 노드 방문 안했다면
*       - 방문표시, 해당 비용 추가, 연결된 간선들 힙에 넣어주기
*
* 2. 시간복잡도
* - MST : O(ElgE)
*
* 3. 자료구조
* - 간선 저장 되는 인접 리스트 : (무게,노드번호)
* - 힙 : (무게,노드번호)
* - 방문여부 : bool[]
* - MST 결과값 : int
* */
public class mst1197 {
    static int V;
    static int E;
    static List<List<int[]>> edge = new ArrayList<>(); // (가중치, 노드번호)
    static PriorityQueue<int[]> heap;
    static boolean[] check;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        check = new boolean[V+1];

        for (int i = 0; i <= V; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // 양방향 노드
            edge.get(a).add(new int[]{c, b});
            edge.get(b).add(new int[]{c, a}); // 가중치와 노드번호
        }

        mst();
        System.out.println(result);
        sc.close();

    }

    private static void mst(){
        heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        heap.add(new int[]{0, 1});

        while (!heap.isEmpty()){
            int[] eachHeap = heap.poll();
            int w = eachHeap[0];
            int eachNode = eachHeap[1];

            if(check[eachNode] == false){
                check[eachNode] = true;
                result += w;
                for (int[] next_edge:edge.get(eachNode)) {
                    int weight = next_edge[0];
                    int next_node = next_edge[1];
                    if( check[next_edge[1]] == false){
                        heap.add(new int[]{weight, next_node});
                    }
                }
            }


        }

    }
}
