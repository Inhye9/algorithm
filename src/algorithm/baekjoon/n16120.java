package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class n16120 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method


        //Scanner sc = new Scanner(System.in);
        //String in=sc.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        getAnswer2(in);
        //getAnswer1(in);
    }

    //1.getAnswer2
    public static void getAnswer2(String in) {

        char[] arrays=in.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int scnt=0;

        for(int i=0; i<arrays.length; i++) {
            //System.out.println(i+":"+arrays[i]);
            if(arrays[i]=='A') {
                if(i==arrays.length-1) {
                    System.out.println("NP");
                    return;
                }

                if(scnt>1&&arrays[i+1]=='P') {
                    stack.pop();
                    i++;
                    scnt--;
                }else {
                    System.out.println("NP");
                    return;
                }
            }else if(arrays[i]=='P') {
                stack.push(arrays[i]);
                scnt++;
            }
        }

        if(stack.size()==1&&stack.pop()=='P') {
            System.out.println("PPAP");
        }else {
            System.out.println("NP");
        }
        return;
    }


    //0.getAnswer1
    public static void getAnswer1(String in){
        char[] arrays=in.toCharArray();
        int acnt=0;

        for(char a : arrays) {
            if(a=='A') acnt++;
        }

        while(acnt>0) {
            in=in.replaceAll("PPAP", "P");
            acnt--;
        }

        if("P".equals(in)) {
            System.out.println("PPAP");
        }else {
            System.out.println("NP");
        }
    }


}
