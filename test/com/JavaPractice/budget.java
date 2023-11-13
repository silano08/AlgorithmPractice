package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class budget {
    @Test
    public void test() {
        int[] answers = {2, 2, 3, 3};
        int budget = 10;
        int result = 4;
        assertEquals(solution(answers, budget), result);
    }

    // 최대 몇개의 부서에 지원가능?
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        for (int a : d) {
            if (budget - a >= 0) {
                answer++;
                budget = budget - a;
            }
        }

        return answer;
    }
}
