package com.JavaPractice;

public class Stack_76502 {
    // 스택 예제 https://school.programmers.co.kr/learn/courses/30/lessons/76502

    public int solution(String s) {
        int answer = 0;

        // 아이디어 : s가 홀수면 return 0,
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            boolean chk = true;

            for(int j=0; j<s.length(); j++){
                if((s.charAt(j) == '}' ||
                        s.charAt(j) == ')' ||
                        s.charAt(j) == ']') &&
                        stack.empty()){
                    chk = false;
                    // System.out.println("s1 :"+s);
                    // System.out.println("s2 :"+s.charAt(j));
                    break;
                }else if(!stack.empty() && s.charAt(j) == ']' && stack.peek() == '['){
                    stack.pop();
                }else if(!stack.empty() && s.charAt(j) == '}' && stack.peek() == '{'){
                    stack.pop();
                }else if(!stack.empty() && s.charAt(j) == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(s.charAt(j));
                }
            }

            if(chk == true && stack.empty()){
                answer+= 1;

                // System.out.println("s가 옳은 경우 :"+s);
            }

            // 한칸 회전
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
        }

        return answer;
    }
}
