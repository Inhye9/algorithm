package algorithm.baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class n10819 {

    static int max;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();

        arr=new int[N];
        max=0;

        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0; i<N; i++){
            boolean[] visited=new boolean[N];
            visited[i]=true;
            dfs(-1, i, visited, 0, 0, new ArrayList<Integer>());
            visited[i]=false;
        }

        System.out.println(max);

    }

    public static void dfs(int pre, int cur, boolean[] visited, int vCnt, int sum, List<Integer> list){
        if(pre!=-1){
//            visited[cur]=true;
            sum+=Math.abs(arr[pre]-arr[cur]);
        }

        list.add(arr[cur]);
        //visited[cur]=true;
        vCnt++;

        if(vCnt==arr.length){
            max=Math.max(max,sum);
            for(int A : list){
                System.out.print(A+", ");

            }
            System.out.println("sum:" + sum);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(visited[i]) continue;
            visited[i]=true;
            dfs(cur, i, visited, vCnt, sum, list);
            visited[i]=false;
        }

        visited[cur]=false;
    }

}
