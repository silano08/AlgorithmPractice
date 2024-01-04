package com.JavaPractice.data_structure;

import java.util.PriorityQueue;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
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

    @Test
    public void testSolution() {
        // Test Case 1
        int[] scoville1 = {1, 2, 3, 9, 10, 12};
        int K1 = 7;
        int expected1 = 2;
        assertEquals(expected1, solution(scoville1, K1));

        // Test Case 2
        int[] scoville2 = {1, 1, 1, 1};
        int K2 = 10;
        int expected2 = -1;
        assertEquals(expected2, solution(scoville2, K2));

        // Test Case 3
        int[] scoville3 = {1, 3, 9, 10, 12};
        int K3 = 7;
        int expected3 = 1;
        assertEquals(expected3, solution(scoville3, K3));

        // Test Case 4
        int[] scoville4 = {1, 2, 3, 4, 5};
        int K4 = 10;
        int expected4 = 2;
        assertEquals(expected4, solution(scoville4, K4));
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int result = solution(scoville, K);
        System.out.println(result); // 출력 결과: 2
    }

    public static int solution(int[] scoville, int K) {
        // 스코빌 지수 힙으로 치환
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int s : scoville) {
            minHeap.add(s);
        }

        int count = 0;
        int nowScoville = 0;

        while (minHeap.size() >= 2 && minHeap.peek() < K) { // 남은 음식이 2개 이상일때만 루프돌림
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            nowScoville = min1 + (min2 * 2);
            minHeap.add(nowScoville);
            count++;
        }

        if(minHeap.isEmpty() || minHeap.peek() < K){
            return -1;
        }

        return count;
    }
}
