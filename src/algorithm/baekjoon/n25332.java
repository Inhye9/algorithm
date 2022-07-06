package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n25332 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s1=br.readLine().split(" ");
        String[] s2=br.readLine().split(" ");
        int[] A=new int[N+1];
        int[] B=new int[N+1];

        for(int i=1; i<N+1; i++){
            A[i]=Integer.parseInt(s1[i-1]);
            B[i]=Integer.parseInt(s2[i-1]);
        }

        //solution1 - 메모리초과
        /*int[][] dp1=new int[N+1][N+1]; //x,y
        int[][] dp2=new int[N+1][N+1]; //x,y

        int cnt=0;
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(i<=j){
                    dp1[i][j]=dp1[i][j-1]+A[j];
                    dp2[i][j]=dp2[i][j-1]+B[j];

                    if(dp1[i][j]==dp2[i][j]) cnt++;
                }
            }
        }*/

        //solution2 - 매모리초과
        /*int[][][] dp=new int[N+1][N+1][2]; //0:A, 1:B

        int cnt=0;
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(i<=j){
                    dp[i][j][0]=dp[i][j-1][0]+A[j];
                    dp[i][j][1]=dp[i][j-1][1]+B[j];

                    if(dp[i][j][0]==dp[i][j][1]) cnt++;
                }
            }
        }*/

        //solution3 - 시간초과 4.27sec
        /*int cnt=0;
        int sumA, sumB;
        for(int i=1; i<N+1; i++){
            sumA=0; sumB=0;
            for(int j=i; j<N+1; j++){
                sumA+=A[j];
                sumB+=B[j];
                if(sumA==sumB)cnt++;
            }
        }*/


        //solution4 - 시간초과 4.25sec
        /*int cnt=0;
        int[] sumAL=new int[N+1];
        int[] sumBL=new int[N+1];

        for(int i=1; i<N+1; i++){
            for(int j=i; j<N+1; j++) {
                if(i==1) {
                    sumAL[j] = sumAL[j - 1] + A[j];
                    sumBL[j] = sumBL[j - 1] + B[j];
                }else{
                    sumAL[j]-=A[j];
                    sumBL[j]-=B[j];
                }

                if (sumAL[j] == sumBL[j]) cnt++;
            }
        }*/

        //solution 5 -시간초과 4.23sec
        /*int cnt=0;
        int[] sumAL=new int[N+1];
        int[] sumBL=new int[N+1];

        int str=1, end=1;
        for(;;) {
            if (end > N) {
                str++;
                end = str;

                if(str==N+1) break;
            }

            if (str == 1) {
                sumAL[end] = sumAL[end - 1] + A[end];
                sumBL[end] = sumBL[end - 1] + B[end];
            } else {
                sumAL[end] -= A[str-1];
                sumBL[end] -= B[str-1];
            }

            if (end>0 && sumAL[end] == sumBL[end]) cnt++;
            end++;

        }*/

        //System.out.println(cnt);

    }
}
