package com.JavaPractice.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class heap42627 {
    @Test
    public void test(){
        int[][] a = {{0, 3}, {1, 9}, {2, 6}};
        solution(a);
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> que = new PriorityQueue<>((arr1, arr2)
                -> Integer.compare(arr1[1], arr2[1]));
        que.add(jobs[0]); //첫번째 탐색 대상 넣기

        int waiting = 0;
        int nowtime = 0;
        int index = 1;
        // 작업이 요청되는 시점, 작업의 소요시간
        while(!que.isEmpty()){
            int[] nowTarget = que.poll();

            if(nowtime <= nowTarget[0]){
                nowtime += nowTarget[1];
            }else{
                waiting += nowtime - nowTarget[0];
                nowtime += nowTarget[1];
            }

            System.out.println("nowtime :"+nowtime);

            if(index != jobs.length-1){
                for(int i=index; i<jobs.length; i++){
                    if(jobs[i][0] <= nowtime){
                        System.out.println("i :"+i);
                        System.out.println("index :"+index);
                        System.out.println("jobs[i][0] :"+jobs[i][0]);
                        index = i;
                        que.add(jobs[i]);
                    }
                }
            }
        }

        // for(int[] nowjob : jobs){
        //     if(nowtime <= nowjob[0]){
        //         nowtime += nowjob[1];
        //     }else if(nowtime > nowjob[0]){
        //         System.out.println(nowtime);
        //         System.out.println("nowjob"+nowjob[1]);
        //         waiting += (nowtime - nowjob[1]);
        //         nowtime += nowjob[1];
        //     }
        // }

        return waiting;
    }
}
