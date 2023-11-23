package com.JavaPractice;

public class kakao_lv2_81302 {

    public int[] solution(String[][] places) {
        int[] result = {1,1,1,1,1};


        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};


        int[] dy2 = {0, 2, 0, -2, 1, 1, -1, -1}; // 맨해튼 거리가 2인 경우의 방향 벡터
        int[] dx2 = {2, 0, -2, 0, 1, -1, 1, -1};

        // 맨해튼 거리 |r1 - r2| + |c1 - c2| < 2
        // P=응시자, 0=빈테이블, X=파티션
        // places를 3차원 벡터 취급

        for(int i=0; i<5; i++){ //3차원
            if(result[i] != 0){ //탐색 대상의 열에 이미 0이면 더이상 탐색할 필요 없음
                String[] searchTarget = places[i];
                for(int j=0; j<5; j++){ //한개의 방
                    for(int k=0; k<5; k++){ //열 -> 0의 K를 전부 탐색하고 그 다음 행을 탐색해야함
                        boolean[][] checked = new boolean[5][5]; // 이미 탐색했는지 검사
                        int ey = j;
                        int ex = k;

                        // P인 경우 탐색 시작
                        if(searchTarget[ey].charAt(ex) == 'P' && checked[ey][ex] == false){
                            checked[ey][ex] = true;

                            for (int z = 0; z < 4; z++) {
                                // 맨해튼 거리가 1인 경우 먼저 조사하고
                                int ny = ey + dy[z];
                                int nx = ex + dx[z];
                                if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                                    if(searchTarget[ny].charAt(nx) == 'P'){
                                        result[i] = 0;
                                        break;
                                    }
                                }
                            }
                            for (int p=0; p<8; p++){
                                // 그다음 거리가 2 인경우 조사
                                int ny = ey + dy2[p];
                                int nx = ex + dx2[p];
                                if (0 <= ny && ny < 5 && 0 <= nx && nx < 5) {
                                    if(searchTarget[ny].charAt(nx) == 'P'){
                                        // 대각선인 경우
                                        if(Math.abs(dy2[p]) == 1 && Math.abs(dx2[p]) == 1){
                                            if (searchTarget[j].charAt(nx) != 'X' || searchTarget[ny].charAt(k) != 'X') {
                                                result[i] = 0;
                                                break;
                                            }
                                        }else if((dy2[p] == 0 && searchTarget[j].charAt((k + nx) / 2) != 'X') ||
                                                (dx2[p] == 0 && searchTarget[(j + ny) / 2].charAt(k) != 'X')){
                                            // 직선 방향인 경우
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
