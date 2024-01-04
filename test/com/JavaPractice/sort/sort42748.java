package com.JavaPractice.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class sort42748 {
    @Test
    public void test(){
        int [] array = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = {5, 6, 3};

        assertArrayEquals(solution(array,commands),result);
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            ArrayList<Integer> sumArray = new ArrayList<>();
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                sumArray.add(array[j]);
            }

            sumArray.sort(null);
            answer[i] = sumArray.get(commands[i][2]-1);
        }
        return answer;
    }
}
