package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class n25330 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        String[] s3 = br.readLine().split(" ");

        int N=Integer.parseInt(s1[0]);
        int K=Integer.parseInt(s1[1]);

        List<Moncity> clist=new ArrayList<Moncity>();
        for(int i=0; i<N; i++){
            clist.add(new Moncity(Integer.parseInt(s2[i]), Integer.parseInt(s3[i])));
        }

        Collections.sort(clist, new Moncity());

        int[][] dp = new int[N+1][K+1];

        for(int i=1; i<N+1; i++){
            for(int j=1; j<K+1; j++){

            }
        }

    }
}

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
