package com.JavaPractice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test3 {

    @Test
    public void test() {
        String expression = "100-200-300-500+20";
        long result = 60420;
        assertEquals(solution(expression), result);
    }

    public long solution(String expression) {

        // 경우의수 *+-, *-+, +*-, +-*, -*+, -+*
        String[][] combines = {{"*","+","-"},{"*","-","+"},{"+","*","-"},{"+","-","*"},{"-","*","+"},{"-","+","*"}};
        List<Integer> answer = new ArrayList<Integer>();

        for (String[] combine :combines) {
            ArrayList<String> operator = new ArrayList<String>();
            ArrayList<Integer> operand  = new ArrayList<Integer>();
            String eachNum = "";

            for (int i = 0; i < expression.length(); i++) {
                if (Character.toString(expression.charAt(i)).equals("+") || Character.toString(expression.charAt(i)).equals("-") || Character.toString(expression.charAt(i)).equals("*")) {
                    operand .add(Integer.valueOf(eachNum));
                    operator.add(Character.toString(expression.charAt(i)));
                    eachNum = "";
                } else {
                    eachNum += Character.toString(expression.charAt(i));
                }

                if(i == expression.length()-1){
                    operand.add(Integer.valueOf(eachNum));
                    eachNum = "";
                }
            }

            for(String comb: combine){
                while(operator.contains(comb)){
                    int index = operator.indexOf(comb);
                    if(comb.equals("+")){
                        operand.set(index,operand.get(index) + operand.get(index+1));
                    }else if(comb.equals("-")){
                        operand.set(index,operand.get(index) - operand.get(index+1));
                    }else if(comb.equals("*")){
                        operand.set(index,operand.get(index) * operand.get(index+1));
                    }
                    operand.remove(index+1);
                    operator.remove(index);
                }
            }
            answer.add(Math.abs(operand.get(0)));
        }

        return Collections.max(answer);
    }
}
