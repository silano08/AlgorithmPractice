package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class supoza {


    @Test
    public void test(){
        int [] answers = {1,3,2,4,2};
        int [] result = {1,2,3};

        assertArrayEquals(solution(answers),result);
    }

    // 1트.. 뭔가 런타임 에러가 났음 시간복잡도에서 실패한듯ㅎㅎ..음이따 다시풀어봐야징
    public int[] solution(int[] answers) {
        Integer[] supo1 = {1,2,3,4,5};
        Integer[] supo2 = {2,1,2,3,2,4,2,5}; //8
        Integer[] supo3 = {3,3,1,1,2,2,4,4,5,5}; //10

        Integer[] score = {scoreArray(supo1,answers),scoreArray(supo2,answers),scoreArray(supo3,answers)};

        // max값을 가진게 몇개임?
        List<Integer> numbers = Arrays.asList(score);
        int max = Collections.max(numbers);
        int correct = Collections.frequency(numbers,max);

        int[] answer = new int[correct];

        if(correct > 1){
            for (int i = 0; i < correct; i++) {
                int index = numbers.indexOf(max);
                answer[i] = index+1;
                numbers.set(index,-1);
            }
        }else{
            int index = numbers.indexOf(max);
            answer[0] = index+1;

        }

        return answer;
    }

    public int scoreArray(Integer[] supo, int[] answers){

        for(int i=0; i<supo.length; i++){
            int index = i%5;
            if(supo[i] == answers[index]){
                supo[i]=1;
            }else{
                supo[i]=0;
            }
        }

        List<Integer> numbers = Arrays.asList(supo);
        int correct = Collections.frequency(numbers,1);
        int score = correct /supo.length;
        return score;
    }

}
