package com.JavaPractice;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class test1 {

    @Test
    public void test(){
        int [] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] result = {0,2,2,0,1,0,0,0,0,0,0};
        int n = 5;
        assertEquals(solution(n,info),result);
    }

    static int[] res = { -1 };
    static int[] lion;
    static int max = -1000;

    public void dfs(int[] info, int cnt, int n) {
        if(cnt == n+1) {
            int apeach_point = 0;
            int lion_point = 0;
            for(int i = 0; i <= 10; i++)
            {
                if(info[i] != 0 || lion[i] != 0) {
                    if(info[i] < lion[i])
                        lion_point += 10 - i;
                    else
                        apeach_point += 10 - i;
                }
            }
            if(lion_point > apeach_point) {
                if(lion_point - apeach_point >= max)
                {
                    res = lion.clone();
                    max = lion_point - apeach_point;
                }
            }
            return ;
        }
        for(int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
            lion[j]++;
            dfs(info, cnt + 1, n);
            lion[j]--;
        }
    }

    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info,1,n);
        return res;
    }
}
