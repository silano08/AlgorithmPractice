package com.JavaPractice;

import java.util.Hashtable;

public class kakao_lv1_81301 {

    public int solution(String s) {
        Hashtable<String, String> stringDict = new Hashtable<>();
        stringDict.put("zero", "0");
        stringDict.put("one", "1");
        stringDict.put("two", "2");
        stringDict.put("three", "3");
        stringDict.put("four", "4");
        stringDict.put("five", "5");
        stringDict.put("six", "6");
        stringDict.put("seven", "7");
        stringDict.put("eight", "8");
        stringDict.put("nine", "9");

        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0' || s.charAt(i) == '1'
                    || s.charAt(i) == '2' || s.charAt(i) == '3'
                    || s.charAt(i) == '4' || s.charAt(i) == '5'
                    || s.charAt(i) == '6'|| s.charAt(i) == '7'
                    || s.charAt(i) == '8'|| s.charAt(i) == '9'){
                resultBuilder.append(s.charAt(i));
            }else{
                stringBuilder.append(s.charAt(i));
                if(stringBuilder.length()>=3){
                    System.out.println(stringBuilder.toString());
                    if(stringDict.get(stringBuilder.toString()) != null){
                        resultBuilder.append(stringDict.get(stringBuilder.toString()));
                        stringBuilder.setLength(0);
                    }
                }
            }
        }

        return Integer.parseInt(resultBuilder.toString());
    }
}
