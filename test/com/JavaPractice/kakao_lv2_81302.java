package com.JavaPractice;

public class kakao_lv2_81302 {

    public int[] solution(String[][] places) {
        int[] result = {1,1,1,1,1};

        // 배열탐색 01 , 10 , 0-1, -10 -> 상우하좌
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        // 맨해튼 거리 |r1 - r2| + |c1 - c2| < 2
        // P=응시자, 0=빈테이블, X=파티션
        // places를 3차원 벡터 취급

        for(int i=0; i<5; i++){
            if(result[i] != 0){
                String[] searchTarget = places[i];
                for(int j=0; j<5; j++){ //한개의 방
                    for(int k=0; k<5; k++){ //열 -> 0의 K를 전부 탐색하고 그 다음 행을 탐색해야함
                        //탐색 대상의 열에 이미 1이면 더이상 탐색할 필요 없음
                        boolean[][] checked = new boolean[5][5]; // 이미 탐색했는지 검사
                        int ey = j;
                        int ex = k;

                        // P인 경우 탐색 시작
                        if(searchTarget[ey].charAt(ex) == 'P' && checked[ey][ex] == false){
                            for (int z = 0; z < 4; z++) {
                                checked[ey][ex] = true;
                                // 맨해튼 거리가 1인 경우 먼저 조사하고
                                int ny = ey + dy[z];
                                int nx = ex + dx[z];
                                if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                                    if(searchTarget[ny].charAt(nx) == 'P'){
                                        // System.out.println("현재 탐색중인 방:"+i);
                                        // System.out.println("내위치:"+ey+","+ex+","+searchTarget[ey].charAt(ex));
                                        // System.out.println("남위치:"+ny+","+nx+","+searchTarget[ny].charAt(nx));
                                        result[i] = 0;
                                        break;
                                    }
                                }
                                // 그다음 거리가 2 인경우 조사


                                ny = ey + dy[z]*2;
                                nx = ex + dx[z]*2;
                                if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                                    if(searchTarget[ny].charAt(nx) == 'P'){
                                        // 행과 열이 다른 경우
                                        if(ex != nx && ey != ny &&
                                                (searchTarget[ey+dy[z]].charAt(ex) == '0'
                                                        || searchTarget[ey].charAt(ex+dx[z]) == '0')){
                                            result[i] = 0;
                                            break;
                                        }else if(ey != ny && searchTarget[ey+dy[z]].charAt(ex) == '0' ){
                                            // 열이 다른 경우
                                            result[i] = 0;
                                            break;
                                        }else if(ex != nx && searchTarget[ey].charAt(ex+dx[z]) == '0' ){
                                            // 행이 다른 경우
                                            result[i] = 0;
                                            break;
                                            }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }

        return result;
    }
}
