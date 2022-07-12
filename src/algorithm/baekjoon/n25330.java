package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class n25330 {
    //solution3, solution4
    static int N;
    //solution3, solution4
    static int K;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        String[] s3 = br.readLine().split(" ");

        //int N=Integer.parseInt(s1[0]);
        //int K=Integer.parseInt(s1[1]);

        N=Integer.parseInt(s1[0]);
        K=Integer.parseInt(s1[1]);

       /* List<Moncity> clist=new ArrayList<Moncity>();
        for(int i=0; i<N; i++){
            clist.add(new Moncity(Integer.parseInt(s2[i]), Integer.parseInt(s3[i])));
        }

        Collections.sort(clist, new Moncity());*/

        //solution1 - 틀렸습니다.
        /*int[][] dp = new int[N+1][K+1];

        for(int i=1; i<N+1; i++){
            for(int j=1; j<K+1; j++){
                if(j<clist.get(i-1).A){
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j]);
                }else{
                    if(clist.get(i-1).P+dp[i-1][j-clist.get(i-1).A]==dp[i-1][j]){
                        dp[i][j]=Math.max(clist.get(i-1).P+dp[i-1][j-clist.get(i-1).A], dp[i-1][j]);
                    }else{
                        dp[i][j]=Math.max(clist.get(i-1).P+dp[i-1][j-clist.get(i-1).A], dp[i-1][j]);
                    }

                }
            }
        }*/

        //solution2 - 틀렸습니다.
        /*int[][][] dp = new int[N+1][K+1][2]; //[0]:체력, [1]: 구한 주민의 수

        for(int i=1; i<N+1; i++){
            for(int j=1; j<K+1; j++) {
                if (j < clist.get(i - 1).A) {
                    dp[i][j][0] = dp[i - 1][j][1] > dp[i][j][1] ? dp[i - 1][j][0] : dp[i - 1][j][1] == dp[i][j][1] ? Math.min(dp[i - 1][j][0], dp[i][j][0]) : dp[i][j][0];
                    dp[i][j][1] = dp[i - 1][j][1] > dp[i][j][1] ? dp[i - 1][j][1] : dp[i][j][1];
                } else {
                    if (clist.get(i - 1).P + dp[i - 1][j - clist.get(i - 1).A][1] == dp[i - 1][j][1]) {
                        dp[i][j][0] = Math.min(clist.get(i - 1).A + dp[i - 1][j - clist.get(i - 1).A][0], dp[i - 1][j][0]);
                        dp[i][j][1] = dp[i - 1][j][1];
                    } else if (clist.get(i - 1).P + dp[i - 1][j - clist.get(i - 1).A][1] > dp[i - 1][j][1]) {
                        dp[i][j][0] = clist.get(i - 1).A + dp[i - 1][j - clist.get(i - 1).A][0];
                        dp[i][j][1] = clist.get(i - 1).P + dp[i - 1][j - clist.get(i - 1).A][1];
                    } else {
                        dp[i][j][0] = dp[i - 1][j][0];
                        dp[i][j][1] = dp[i - 1][j][1];
                    }

                }
                //System.out.println(dp[i][j][1]);
            }
        }*/

        //System.out.println(dp[N][K][1]);


        //solution3 - 통과. backtracking-dfs. 메모리:14324KB, 시간: 152ms
        /*Moncity[] moncities=new Moncity[N+1];
        for(int i=0; i<N; i++){
            moncities[i+1]=new Moncity(Integer.parseInt(s2[i]), Integer.parseInt(s3[i]));
        }

        boolean[] visitied=new boolean[N+1];
        for(int i=1; i<N+1; i++){
          dfs(moncities, visitied, 0, 0, 0);
        }
        */


        //solution4 - 통과. backtracking-dfs + arraylist. 메모리:15752KB, 시간: 200ms
        List<Moncity> moncities=new ArrayList<>();
        for(int i=0; i<N; i++){
            moncities.add(new Moncity(Integer.parseInt(s2[i]), Integer.parseInt(s3[i])));
        }

        for(int i=0; i<N; i++){
            dfsArrayList(moncities, 0, 0, 0);
        }
        System.out.println(maxP);

    }

    static int maxP=0;

    //solution4
    public static void dfsArrayList(List<Moncity> moncities, int savedP, int usedA, int eachA){
        if(usedA<=K){
            if(maxP<savedP) maxP=savedP;
        }else{
            return;
        }
        for(int i=0; i<moncities.size(); i++){
            Moncity mon = moncities.get(i);
            moncities.remove(i);
            dfsArrayList(moncities, savedP+mon.P, usedA+eachA+mon.A, eachA+mon.A);
            moncities.add(i, mon);
        }
    }


    //solution3
    /*public static void dfs(Moncity[] moncities, boolean[] visited, int savedP, int usedA, int eachA){
        if(usedA<=K){
            if(maxP<savedP) maxP=savedP;
        }else{
            return;
        }
        for(int i=1; i<N+1; i++){
            if(!visited[i]){
                visited[i]=true;
                eachA+=moncities[i].A;
                dfs(moncities, visited, savedP+moncities[i].P, usedA+eachA, eachA);
                visited[i]=false;
                eachA-=moncities[i].A;
            }
        }
    }*/

}

/*
class Moncity implements Comparator<Moncity> {
    int A;
    int P;

    Moncity(){}

    Moncity(int A, int P){
        this.A=A;
        this.P=P;
    }

    public int compare(Moncity o1, Moncity o2) {
        // TODO Auto-generated method stub
        if(o1.A>o2.A) {
            return 1;
        }else if(o1.A<o2.A) {
            return -1;
        }else if(o1.A==o2.A) {
            if(o1.P>o2.P) {
                return -1;
            }else if(o1.P>o2.P) {
                return 1;
            }
        }
        return 0;
    }
}
*/

class Moncity {
    int A;
    int P;

    Moncity(){}

    Moncity(int A, int P){
        this.A=A;
        this.P=P;
    }
}
