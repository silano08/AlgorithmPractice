package com.JavaPractice.substitution_cipher;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Substitution_9046 {
    // https://www.acmicpc.net/problem/9046
    // 테스트케이스 다 맞는데 왜틀렸다고 뜨지..

    static int t;
    static ArrayList<String> cipherList = new ArrayList<>();;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<t; i++){
            String line = sc.nextLine();
            cipherList.add(i,line);
        }

        for (String cipher:cipherList) {
            cipherSolve(cipher);
        }

    }

    private static void cipherSolve(String cipher){
        // 아이디어 : 문자열중 어떤게 제일 빈번하게 나타나는지 count 하려면?
        // hashtable 1차적으로 각자 값이 몇개인지와 math의 값이 몇개인지 검사
        // 2차적으로 완성된 hashtable을 돌면서 max target을 찾음 만약 찾은 이후에 max값이 같아 max target이 변경되는 순간이 오면 ? return

        Hashtable<String,Integer> cipherTable = new Hashtable<>();
        int max = -1;

        for(int i=0; i<cipher.length(); i++){
            String target = cipher.substring(i,i+1);
            if(!target.equals(" ")){
                if(cipherTable.containsKey(target)){
                    cipherTable.put(target,cipherTable.get(target)+1);
                    max = Math.max(max,cipherTable.get(target));
                }else{
                    cipherTable.put(target,1);
                }
            }
        }

        int count = 0;
        String maxAlphabet = "";
        for (Map.Entry<String,Integer> entry: cipherTable.entrySet()) {
            if(entry.getValue() == max && count == 0){
                maxAlphabet = entry.getKey();
                count++;
            }else if(entry.getValue() == max && count > 0){
                count++;
            }
        }

        if(count==1){
            System.out.println(maxAlphabet);
        }else{
            System.out.println("?");
        }

    }
}
