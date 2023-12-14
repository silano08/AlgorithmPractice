package com.JavaPractice;

import java.util.LinkedList;

public class kakao_lv2_64064 {

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        int[] casenumber = new int[banned_id.length];

        LinkedList<String> banned_list = new LinkedList<>();

        for(String id:banned_id){
            banned_list.add(id);
        }

        for(int j=0; j<banned_id.length; j++){
            if(banned_list.contains(banned_id[j])){
                banned_list.remove(banned_id[j]); // 없는값으로 만들기

                for(int i=0; i<user_id.length; i++){
                    if(casenumber[j] == 0 & banned_list.contains(banned_id[j])){
                        // 만약 경우의수가 계산이 안됐고, banned_list에 이미 존재하는값이라면(이후에도 같은 아이디의 경우의수를 계산해야한다면)
                        if(user_id[i].length() == banned_id[j].length()){
                            // System.out.println("같은 아이디의 경우의수를 계산해야한다");
                            boolean pass = false;
                            for(int z=0; z < user_id[i].length(); z++){
                                if(banned_id[j].charAt(z) == '*' || user_id[i].charAt(z) == banned_id[j].charAt(z)){
                                }else{
                                    // System.out.println("같은거아님");
                                    pass = true;
                                }
                            }

                            if(pass == false){
                                casenumber[j]+= 1;
                            }
                        }

                        break;
                    }else if(casenumber[j] == 0 & !banned_list.contains(banned_id[j])){
                        // 만약 경우의수가 계산이 안됐고, 더이상 겹치는 banned_id가 없다면(마지막 아이디라면)
                        if(user_id[i].length() == banned_id[j].length()){
                            // System.out.println("마지막 아이디");
                            boolean pass = false;
                            for(int z=0; z < user_id[i].length(); z++){
                                if(banned_id[j].charAt(z) == '*' || user_id[i].charAt(z) == banned_id[j].charAt(z)){
                                }else{
                                    // System.out.println("같은거아님");
                                    pass = true;
                                }
                            }

                            if(pass == false){
                                casenumber[j]+= 1;
                            }
                        }
                    }
                }

            }
        }

        for(int a :casenumber){
            answer *= a;
            System.out.println(a);
        }
        // System.out.println(answer);

        return answer;
    }
}
