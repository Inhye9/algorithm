package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N-Queen 문제
public class n9663 {
    static int N;
    static int cnt;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //solution1 - 통과. 메모리 15632KB, 시간 5204MS 
        int[][] q=new int[N+1][2]; //[0]: x, [1]: y
        dfs(q, 1, 0);

        System.out.println(cnt);
    }

    public static void dfs (int[][] q, int row, int qCnt){
        if(row>N){
            if(qCnt==N){
                cnt++;
            }
            return;
        }
        boolean isQueen;
        for(int y=1; y<N+1; y++){
            isQueen=true;
            for(int i=1; i<qCnt+1; i++){
                if(y==q[i][1] || y==q[i][1]+row-i || y==q[i][1]-row+i ){
                    isQueen=false;
                    break;
                }
            }

            if(isQueen){
                q[row][0]=row;
                q[row][1]=y;
                dfs(q, row+1, qCnt+1);
            }
        }
    }
}
