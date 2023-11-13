package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DividePowerGrid {

    @Test
    public void test() {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int result = 4000;
        assertEquals(solution(n,wires), result);
    }

    public int solution(int n, int[][] wires) {
        int answer = -1;
        return answer;
    }

    private int nodeRecursive(int targetNode, int[][] wires, int childNodeNum, Map nodeList){

        return childNodeNum;
    }

}
