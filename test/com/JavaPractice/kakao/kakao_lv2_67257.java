package com.JavaPractice.kakao;

import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class kakao_lv2_67257 {



    @Test
    public void test() {
        assertEquals(solution("100-200*300-500+20"), 60420);

        assertEquals(solution("50-50-4"), 4);
        assertEquals(solution("200-300-500-600*40+500+500"), 1248000);
    }


    public long solution(String expression) {
        // 1. *+- 의 순서도 우선순위 경우의 수 테이블을 만들어 모든 경우의수 계산
        // 2. *+-, *-+, +*-, +-* , -+*, -*+해시테이블 생성
        Hashtable<String,Integer> caseTable = new Hashtable<>();
        caseTable.put("*+-",0);
        caseTable.put("*-+,,",0);
        caseTable.put("+*-",0);
        caseTable.put("+-*",0);
        caseTable.put("-+*",0);
        caseTable.put("-*+",0);

        // 3. expression들을 linkedlist에 나눠서 넣기
        LinkedList<String> expressionList = new LinkedList<>();
        StringBuilder num = new StringBuilder();

        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) != '+'
                    && expression.charAt(i) != '-'
                    && expression.charAt(i) != '*' ){
                num.append(expression.charAt(i));
            }else{
                if(num.length() > 0){
                    expressionList.add(num.toString());
                    num = new StringBuilder();
                }
                expressionList.add(expression.substring(i,i+1));
            }
        }

        // 마지막 숫자
        expressionList.add(num.toString());

        // 4. 연산자 순위별로 계산, expressionList
        for (String key : caseTable.keySet()) {
            LinkedList<String> temp = new LinkedList<>();
            // 각 객체를 깊은 복사
            temp.addAll(expressionList);

            int j = 0;
            String rank1 = key.substring(0,1);
            String rank2 = key.substring(1,2);
            String rank3 = key.substring(2,3);

            while(true){
                if(temp.contains(rank1)){
                    // 1번째 우선순위 연산자가 1개라도 남아있다면 이 로직만 타도록
                    if(temp.get(j).equals(rank1)){
                        // j-1과 j+1을 해당 연산자로 계산 한 뒤 j-1,j,j+1을 pop
                        temp.set(j-1,caculate(temp.get(j-1),temp.get(j+1),temp.get(j)));
                        temp.remove(j);
                        temp.remove(j);
                    }
                }else if(temp.contains(rank2)){
                    if(temp.get(j).equals(rank2)){
                        temp.set(j-1,caculate(temp.get(j-1),temp.get(j+1),temp.get(j)));
                        temp.remove(j);
                        temp.remove(j);
                    }
                }else if(temp.contains(rank3)){
                    if(temp.get(j).equals(rank3)){
                        temp.set(j-1,caculate(temp.get(j-1),temp.get(j+1),temp.get(j)));
                        temp.remove(j);
                        temp.remove(j);
                    }
                }

                if(temp.size() == 1){
                    // 탈출조건
                    break;
                }

                j++;

                if(j >= temp.size()){
                    // while문안에서 인덱싱을 위해
                    j = 0;
                }

            }

            // temp의 첫번째값(계산값)을 key의 value값으로 할당
            caseTable.replace(key,Integer.parseInt(temp.get(0)));
        }

        // 초기 최대 값을 최소로 설정
        int maxValue = Integer.MIN_VALUE;

        // 5. 값을 순회하며 최대 값을 찾음
        for (Enumeration<Integer> e = caseTable.elements(); e.hasMoreElements();) {
            int value = Math.abs(e.nextElement());
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }

    private String caculate(String num1, String num2, String ope){
        int result = 0;
        if(ope.equals("+")){
            result= Integer.parseInt(num1) + Integer.parseInt(num2);
        }else if(ope.equals("-")){
            result= Integer.parseInt(num1) - Integer.parseInt(num2);
        }else if(ope.equals("*")){
            result= Integer.parseInt(num1) * Integer.parseInt(num2);
        }

        return Integer.toString(result);
    }
}
