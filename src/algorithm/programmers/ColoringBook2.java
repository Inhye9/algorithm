package algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook2 {
    public static void main(String[] args) {
        int[][] p={{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] answer=solution(6,4, p);
        System.out.println(answer[0]+","+answer[1]);
    }


    static boolean[][] v;
    static int maxSize;
    static int AreaNums;
    static public int[] solution(int m, int n, int[][] p){
        v=new boolean[m][n];
        maxSize=0; AreaNums=0;

        for(int x=0; x<m; x++){
            for(int y=0; y<n; y++){
                if(!v[x][y] && p[x][y]!=0){
                    bfs(p,x,y);
                    maxSize=Math.max(maxSize, size);
                    size=0;
                    AreaNums++;
                }
            }
        }

        return new int[]{AreaNums, maxSize};
    }

    static int size=0;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static public void bfs(int[][] p, int x, int y){
        size++;
        v[x][y]=true;
        Queue<Point> q=new LinkedList<>();
        q.offer(new Point(x, y));

        while(!q.isEmpty()){
            Point cur=q.poll();
            for(int i=0; i<4; i++){
                int nx=cur.x+dx[i];
                int ny=cur.y+dy[i];

                if(nx<0 || nx>p.length-1 || ny<0 || ny>p[0].length-1 || v[nx][ny]){
                    continue;
                }

                if(p[x][y]==p[nx][ny]){
                    size++;
                    q.offer(new Point(nx, ny));
                    v[nx][ny]=true;
                }
            }
        }


    }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
