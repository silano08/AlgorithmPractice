package com.JavaPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class pccp1_no1 {
    // https://school.programmers.co.kr/learn/courses/15008/lessons/121683

    public String solution(String input_string) {
        Set<String> checkedSet = new HashSet<>(); // 체크중인 알파벳, 외톨이 검증용
        ArrayList<String> lonelyList = new ArrayList<>(); // 외톨이 알파벳

        String pre = "";
        for(int i=0; i< input_string.length(); i++){
            String target = input_string.substring(i,i+1);

            if(checkedSet.contains(target) && !pre.equals(target)){
                if(!lonelyList.contains(target)){
                    lonelyList.add(target);
                }
            }

            checkedSet.add(target);
            pre = target;
        }

        if(lonelyList.size() == 0){
            return "N";
        }

        Collections.sort(lonelyList);
        StringBuilder answer = new StringBuilder();
        for(String l :lonelyList){
            answer.append(l);
        }

        return answer.toString();


    }
}
