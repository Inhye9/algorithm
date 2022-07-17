package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 1. 세그먼트 트리(segment tree)
 */
public class n10868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N=Integer.parseInt(in[0]);
        int M=Integer.parseInt(in[1]);

        int[] arr=new int[N+1];
        for(int i=1; i<N+1; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        SegmentTree stree=new SegmentTree(N);
        stree.init(arr, 1, 1, N);

        for(int i=0; i<M; i++){

            String[] s=br.readLine().split(" ");
            long A= stree.query(1,1,N,Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            System.out.println(i+" "+A);
        }

    }

}

class SegmentTree{
    long[] tree;
    int treeSize;
    /*
      트리의 높이 h=log2(arrSize)의 올림
      트리의 노드 수 treeSize=2^(h+1)-1;
     */
    SegmentTree(int arrSize){
        int h=(int)Math.ceil(Math.log(arrSize)/Math.log(2));
        this.treeSize=(int)Math.pow(2,h+1);
        tree=new long[treeSize];
    }

    long init(int[] arr, int node, int str, int end){
        if(str==end) return tree[node]=arr[str];
        return tree[node]=Math.min(init(arr, node*2, str, (str+end)/2), init(arr, node*2+1, (str+end)/2+1, end));
    }

    long query(int node, int str, int end, int from, int to){
        if(end<from||str>to) return Integer.MAX_VALUE;
        if(from<=str&&end<=to) return tree[node];
        return Math.min(query(2*node, str, (str+end)/2, from, to), query(2*node+1, (str+end)/2+1, end , from, to));
    }
}
