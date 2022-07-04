package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n12865 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int N=Integer.parseInt(in[0]);
        int K=Integer.parseInt(in[1]);

        int[][] dp = new int[N+1][K+1];
        int w=0, v=0;
        for(int i=1; i<N+1; i++){
            in=br.readLine().split(" ");
            w=Integer.parseInt(in[0]);
            v=Integer.parseInt(in[1]);

            for(int j=1; j<K+1; j++) {
                if(j<w){
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j]);
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], v+dp[i-1][j-w]);
                    //v+dp[i][j-w](x) -> 자기 자신*2 경우 발생함.
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
