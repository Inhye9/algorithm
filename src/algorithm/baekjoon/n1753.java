package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1753 {
    //배열
    static class Node{
        int idx, cost; //idx=다음 노드 인덱스, cost=다음 노드로 가는 비용.

        Node(int idx, int cost){
            this.idx=idx;
            this.cost=cost;
        }
    }

    public static void main(String[] args) throws IOException { //메모리:109988KB, 시간: 1220ms
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V=Integer.parseInt(st.nextToken()); //V:정점 개수
        int E=Integer.parseInt(st.nextToken()); //E:간선 개수
        int start=Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> graph=new ArrayList<ArrayList<Node>>();

        for(int i=0; i<V+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<E; i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
        }

        int[] dist=new int[V+1]; //dist: 최소 비용을 저장할 배열.
        for(int i=0; i<V+1; i++){
            dist[i]=Integer.MAX_VALUE;
        }


        PriorityQueue<Node> q= new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(start, 0));
        dist[start]=0;

        while(!q.isEmpty()){
            Node curNode= q.poll();

            if(dist[curNode.idx]<curNode.cost){
                continue;
            }

            for(int i=0; i<graph.get(curNode.idx).size(); i++){
                Node nxtNode=graph.get(curNode.idx).get(i);

                if(dist[nxtNode.idx]>curNode.cost+nxtNode.cost){
                    dist[nxtNode.idx]=curNode.cost+nxtNode.cost;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        for(int i=1; i<V+1; i++){
            System.out.println(dist[i]==Integer.MAX_VALUE?"INF":dist[i]);
        }
    }
}
