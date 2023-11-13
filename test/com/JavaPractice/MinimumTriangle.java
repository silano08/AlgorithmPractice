package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinimumTriangle {

    @Test
    public void test() {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = 4000;
        assertEquals(solution(sizes), result);
    }

    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        for (int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
            if (sizes[i][0] > width) { width= sizes[i][0];}
            if (sizes[i][1] > height) {height = sizes[i][1];}
        }

        return width*height;
    }
}
