package com.JavaPractice;

import java.util.ArrayList;

public class Brute_Force_Search_42840 {
    // 문제번호 : https://school.programmers.co.kr/learn/courses/30/lessons/42840#


    public ArrayList<Integer> solution(int[] answers) {
        int[][] answerList = new int[3][];
        answerList[0] = new int[] {1,2,3,4,5};
        answerList[1] = new int[] {2,1,2,3,2,4,2,5};
        answerList[2] = new int[] {3,3,1,1,2,2,4,4,5,5};

        int[] scoreList = new int[3];

        // 이 부분에서 완전탐색이 들어갔어야할듯한.., 아 근데 만번돌수도있으니까
        for(int i=0; i<answers.length; i++){
            if(answers[i] == answerList[0][i%answerList[0].length]){
                scoreList[0] += 1;
            }

            if(answers[i] == answerList[1][i%answerList[1].length]){
                scoreList[1] += 1;
            }

            if(answers[i] == answerList[2][i%answerList[2].length]){
                scoreList[2] += 1;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int max = Math.max(scoreList[0], Math.max(scoreList[1], scoreList[2]));

        for (int j = 0; j < 3; j++) {
            if (scoreList[j] == max) {
                result.add(j + 1);
            }
        }


        return result;
    }
}
