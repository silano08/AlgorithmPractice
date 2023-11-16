package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class heap42627 {
    @Test
    public void test1() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int expected = 9;
        int result = solution(jobs);
        assertEquals(expected, result);
    }

    @Test
    public void test2() {
        int[][] jobs = {{0, 5}, {5, 2}, {5, 5}, {15, 1}};
        int expected = 11;
        int result = solution(jobs);
        assertEquals(expected, result);
    }

    @Test
    public void test3() {
        int[][] jobs = {{0, 10}, {4, 5}, {15, 3}, {20, 6}};
        int expected = 15;
        int result = solution(jobs);
        assertEquals(expected, result);
    }

//    public int solution(int[][] jobs) {
//        // jobs -> [작업이 요청되는 시점, 작업의 소요시간]
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>();
//        for (int[] s : jobs) {
//            minHeap.add(s);
//        }
//
//        int answer = 0;
//        return answer;
//    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 작업을 요청 시간에 따라 정렬
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // 소요 시간이 짧은 순으로 처리하기 위한 힙
        int time = 0; // 현재 시간
        int totalTime = 0; // 총 소요 시간

        int i = 0; // jobs 배열을 탐색하기 위한 인덱스
        while (i < jobs.length || !minHeap.isEmpty()) {
            while (i < jobs.length && jobs[i][0] <= time) { // 현재 시간 이전에 들어온 작업을 힙에 추가
                minHeap.add(jobs[i]);
                i++;
            }

            if (!minHeap.isEmpty()) { // 작업을 처리할 수 있는 경우
                int[] job = minHeap.poll();
                time += job[1]; // 현재 시간 업데이트
                totalTime += time - job[0]; // 총 소요 시간 업데이트
            } else { // 대기 중인 작업이 없는 경우
                time = jobs[i][0]; // 대기 중인 작업이 없으므로 현재 시간을 다음 작업의 요청 시간으로 업데이트
            }
        }

        return totalTime / jobs.length; // 평균 소요 시간을 계산하여 반환
    }
}
