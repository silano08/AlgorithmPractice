package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class test2 {

    @Test
    public void test(){
        int [] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        int result = -1;
        assertEquals(solution(queue1,queue2),result);
    }


    public int solution(int[] queue1, int[] queue2) {
        long queueRsum = Arrays.stream(queue1).sum();
        long queueLsum = Arrays.stream(queue2).sum();
        int tryCount=0;
        long target = (queueRsum + queueLsum)/2;

        Queue<Integer> queueR = new LinkedList<Integer>(intToInteger(queue1));
        Queue<Integer> queueL = new LinkedList<Integer>(intToInteger(queue2));

        while (queueRsum > target || queueLsum > target){
            if(queueRsum > queueLsum){
                queueRsum -= queueR.peek();
                queueLsum += queueR.poll();
                tryCount += 1;
            }else if(queueRsum < queueLsum){
                queueLsum -= queueL.peek();
                queueRsum += queueL.poll();
                tryCount += 1;
            }
            if(tryCount > queueRsum + queueLsum){
                return -1;
            }
        }

        return tryCount;
    }

    private List<Integer> intToInteger(int[] arr){
        List<Integer> list = new LinkedList<Integer>();
        for (int currentInt : arr) {
            list.add(currentInt);
        }
        return list;
    }
}
