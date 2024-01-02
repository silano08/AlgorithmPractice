package com.JavaPractice;

public class Substitution_12926 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/12926
    // 문자치환 문제 푸는중


    // 아이디어 1 : 미리 알파벳 리스트를 만들어두고 -> X, char이니까 아스키코드로 접근해야함
    // 생각해볼점 : s에 있는 알파벳 인덱스를 찾고 해당 인덱스에서 n만큼 뒤의 것을 return
    public String solution(String s, int n) {
        String answer = "";

        char[] ch = s.toCharArray();
        for(char c : ch){
            if(c>=65 && c<=90){
                if(c+n-90 >= 1){
                    // 범위를 넘어가면
                    c = (char)(65+c+n-90-1);
                    answer += c;
                }else{
                    c += n;
                    answer += c;
                }
            }else if(c>=97 && c<=122){
                if(c+n-122 >= 1){
                    // 범위를 넘어가면
                    c = (char)(97+c+n-122-1);
                    answer += c;
                }else{
                    c += n;
                    answer += c;
                }
            }else if(c == 32){
                answer += " ";
            }
        }

        return answer;
    }
}
