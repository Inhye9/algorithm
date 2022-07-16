package algorithm.programmers;

import java.util.HashSet;

public class ColoringBook {
    public static void main(String[] args) {
        int[][] p={{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] answer=solution(6,4, p);
        System.out.println(answer[0]+","+answer[1]);
    }

    static boolean[][] v;
    static int maxSize;

    static int nums;
    //static HashSet<Integer> nums; //숫자의 종류 개수로 착각. -> 문제를 잘 읽자!

    static public int[] solution(int m, int n, int[][] p){
        v=new boolean[m][n];
        maxSize=0;
        //nums=new HashSet<>();
        nums=0;

        for(int x=0; x<m; x++){
            for(int y=0; y<n; y++){
                if(!v[x][y] && p[x][y]!=0){
                    //nums.add(p[x][y]);
                    dfs(p, x, y);
                    nums++;
                    maxSize=Math.max(maxSize, size);
                    size=0;
                }
            }
        }

        return new int[]{nums, maxSize};
    }

    static int size;
    static int[] dx={-1, 1, 0, 0};
    static int[] dy={0, 0, -1, 1};


    public static void dfs(int[][] p, int x, int y){
        if(v[x][y]) return;

        size++;
        v[x][y]=true;

        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || nx>p.length-1 || ny<0 || ny>p[1].length-1){
                continue;
            }

            if(p[x][y]==p[nx][ny]){
                dfs(p, nx, ny);
            }
        }
    }

}


