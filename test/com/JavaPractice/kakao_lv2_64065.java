package com.JavaPractice;

import java.util.HashMap;
import java.util.Map;

public class kakao_lv2_64065 {
    /* 문제 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/64065
    * 문제 아이디어 : 주어진 string에서 특정값이 몇번 나오는지 hashTable로 가지고있다가 값이 다 정해지고나면 값을 기준으로 역 hashtable생성
    * */


    public int[] solution(String s) {

        HashMap<String,Integer> sMap = new HashMap<>();
        StringBuilder a = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '{'
                    && s.charAt(i) != '}'
                    && s.charAt(i) != ','){
                a.append(s.charAt(i));
            }
            else{
                String b = a.toString();
                if(sMap.get(b) != null){
                    sMap.put(b,sMap.get(b)+1);
                }else{
                    sMap.put(b,1);
                }
                // System.out.println(b);
                a = new StringBuilder();
            }

            // System.out.println("s:"+s.charAt(i));
        }

        // 값을 기준으로 정렬된 역 인덱스 생성
        Map<Integer, String> reverseIndex = new HashMap<>();
        for (Map.Entry<String, Integer> entry : sMap.entrySet()) {
            reverseIndex.put(entry.getValue(), entry.getKey());
        }

        int[] result = new int[reverseIndex.size()-1];
        int j=reverseIndex.size()-2;
        for (Map.Entry<Integer, String> entry : reverseIndex.entrySet()){
            // System.out.println("entry:"+entry.getValue());
            if(!entry.getValue().isEmpty()){
                result[j] = Integer.parseInt(entry.getValue());
                j--;
            }
        }

        return result;
    }
}
