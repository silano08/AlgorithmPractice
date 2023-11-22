package com.JavaPractice;

import java.util.HashMap;

public class kakao_lv1_118666 {

    public String solution(String[] survey, int[] choices) {
        // 매우 비동의 -> 네오3 , 매우 동의->어피치3
        // 성격 유형
        HashMap<Character,Integer> alphaSet = new HashMap<>();
        alphaSet.put('R',1);
        alphaSet.put('C',2);
        alphaSet.put('J',3);
        alphaSet.put('A',4);

        alphaSet.put('T',-1);
        alphaSet.put('F',-2);
        alphaSet.put('M',-3);
        alphaSet.put('N',-4);

        int[] scoreSet = new int[4];

        for(int i=0; i<survey.length; i++){
            int index = alphaSet.get(survey[i].charAt(1));
            if(index>0){
                scoreSet[index-1] += choices[i] - 4;
                System.out.println(scoreSet[index-1]);
            }else if(index<0){
                scoreSet[(-1*index)-1] += 4 - choices[i];
                System.out.println(scoreSet[(-1*index)-1]);
            }
            // alphaSet.get(survey[i].charAt(1));
            // if(survey[i].charAt(1) == )
        }


        char[] positiveSet = {'R','C','J','A'};
        char[] negativeSet = {'T','F','M','N'};
        StringBuilder result = new StringBuilder();

        // for(int a:scoreSet){
        //     System.out.println(a);
        // }

        for(int j=0; j<4; j++){
            if(scoreSet[j]>=0){
                result.append(positiveSet[j]);
            }else{
                result.append(negativeSet[j]);
            }
        }
        return result.toString();
    }
}
