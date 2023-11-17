package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class homeNumber {



    @Test
    public void test(){
        int total = 7;
        int [][] danzi = {{0,1,1,0,1,0,0},
                            {0,1,1,0,1,0,1},
                            {1,1,1,0,1,0,1},
                            {0,0,0,0,1,1,1},
                            {0,1,0,0,0,0,0},
                            {0,1,1,1,1,1,0},
                            {0,1,1,1,0,0,0}};
        int [] result = {3,7,8,9};

        assertArrayEquals(solution(total,danzi),result);
    }

    // 1트.. 뭔가 런타임 에러가 났음 시간복잡도에서 실패한듯ㅎㅎ..음이따 다시풀어봐야징
    public int[] solution(int total, int[][] square) {

        List<Integer> groupInfo = new ArrayList<Integer>();

        int x_ = 0;
        int y_ = 0;
        int groupCount = 0;

        // array에서 0=빈자리, 1=있는자리, 2=체크완료한자리로 취급
        while(true){

            if(x_==total-1){
                x_ = 0;
            }else if(x_==total-1 && y_==total-1){
                break;
            }

            if(square[x_+1][y_] == 1){
                groupCount+= 1;
                square[x_+1][y_] = 2;
            }else if(square[x_][y_+1] == 1){
                groupCount+= 1;
                square[x_][y_+1] = 2;
            }else if(square[x_+1][y_] ==0 && square[x_][y_+1]==0){
                groupInfo.add((Integer) groupCount);
                groupCount = 0;
            }

            // 좌표 이동
            if(x_ == 0){ // x축을 다 훑은 경우엔 y+=1s
                y_ += 1;
            }else{
                x_ +=1 ;
            }

        }

        int[] result = new int[groupInfo.size()];

        for(int i=0; i<result.length; i++){
            result[i] = groupInfo.get(i);
        }

        return result;

    }
}
