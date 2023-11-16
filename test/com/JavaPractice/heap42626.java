package com.JavaPractice;

import java.util.PriorityQueue;

/*
* 1. 아이디어
* - while문 사용, scoville를 heap으로 만들고
* - 현재 스코빌 지수 = scoville에서 빼냄 + (scoville에서 빼냄*2)
* - scoville에 현재스코빌지수 추가
*
* 2. 시간복잡도
* - O(NlogN) < 2억 , 이때 N = 1,000,000,000 (가능)
*
* 3.자료구조
* - 스코빌 리스트 = Priority Queue -> 오름차순 정렬
* - 섞은 횟수 = int (100만번 섞어도 100만개니까)
* - 현재 스코빌 지수 = int
* */
public class heap42626 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int result = solution(scoville, K);
        System.out.println(result); // 출력 결과: 2
    }

    public static int solution(int[] scoville, int K) {
        // 스코빌 지수 힙으로 치환
        PriorityQueue<Integer> scovilleHeap = new PriorityQueue<>();
        for (int s : scoville) {
            scovilleHeap.add(s);
        }

        int count = 0;
        int nowScoville = 0;

        while (true){
            if(nowScoville >= K){
                break;
            }else {
                nowScoville = scovilleHeap.poll() + (scovilleHeap.poll()*2);
                scovilleHeap.add(nowScoville);
                count+= 1;
            }
        }

        return count;
    }
}
