package com.JavaPractice;

public class Simulation_49993 {
    // https://school.programmers.co.kr/learn/courses/30/lessons/49993
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        // 아이디어 : skill -> linkedlist?, skill_trees의 각요소를 skill에 contains되어있는지 검사, 그리고 index를 통해 contain된 값이 올바른 위치에 있는지 검사
        for(String target : skill_trees){
            int index = 0;
            boolean yn = true;
            for(int i=0; i<target.length(); i++){
                if(skill.contains(target.subSequence(i,i+1))
                        && !target.substring(i,i+1).equals(skill.substring(index,index+1))){

                    // System.out.println("몇번째 스킬트리 :"+target);
                    // System.out.println("t :"+ target.subSequence(i,i+1));
                    // System.out.println("skill :"+ skill.subSequence(index,index+1));

                    yn = false;
                    break;
                }else if(skill.contains(target.subSequence(i,i+1))
                        && target.substring(i,i+1).equals(skill.substring(index,index+1))){
                    index += 1;
                }
            }

            index = 0;
            if(yn==true){
                answer+=1;
            }
        }


        return answer;
    }
}
