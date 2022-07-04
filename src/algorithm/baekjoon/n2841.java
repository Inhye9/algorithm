package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class n2841 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int num = Integer.parseInt(in[0]);
        int P = Integer.parseInt(in[1]);

        int cnt=0;
        Stack<Integer>[] stack = new Stack[6];

        for(int i=0; i<6; i++) {
            stack[i]=new Stack<Integer>();
        }

        while(num>0) {
            String[] sp=br.readLine().split(" ");
            int s=Integer.parseInt(sp[0])-1;
            int p=Integer.parseInt(sp[1]);

            while(stack[s].size()>0) {
                if(stack[s].peek()>p) {
                    stack[s].pop();
                    cnt++;
                }else {
                    break;
                }
            }

            if(stack[s].isEmpty()||stack[s].peek()<p) {
                stack[s].push(p);
                cnt++;
            }
            num--;
        }

        System.out.println(cnt);

    }

}
