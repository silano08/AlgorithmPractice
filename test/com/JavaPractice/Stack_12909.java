package com.JavaPractice;

public class Stack_12909 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12909


    boolean solution(String s) {

        if(s.charAt(0) == ')'){
            return false;
        }

        // 아이디어 : s를 for문으로 돌면서
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.empty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        if(!stack.empty()){
            return false;
        }


        return answer;
    }
}
