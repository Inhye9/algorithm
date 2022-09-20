package algorithm.baekjoon;

import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


//2503. 숫자 야구 게임 - 완전 탐색

public class n2503 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N=Integer.parseInt(sc.nextLine());

        BaseBall[] baseball = new BaseBall[N];
        for(int i=0; i<N; i++){
            int val=sc.nextInt();
            int strike=sc.nextInt();
            int ball=sc.nextInt();

            baseball[i]=new BaseBall(val, strike, ball);
        }

        int totalCnt=0;
        //List<Integer> res=new ArrayList<Integer>();

        for(int i=123; i<998; i++){
        //for(int i=320; i<330; i++){
            int inputCnt=0;
            char[] numArr=getCharArr(i);
            if(!checkValid(numArr)) continue;

            for(int j=0; j<N; j++){
                int strike=0, ball=0;
                BaseBall input=baseball[j];
                char[] inputArr=getCharArr(input.val);

                for(int s=0; s<3; s++){
                    for(int b=0; b<3; b++) {
                        if (inputArr[s] == numArr[b] && s == b) {
                            strike++;
                        }

                        if (inputArr[s] == numArr[b] && s != b) {
                            ball++;
                        }

                    }
                }

                if(strike==input.strike && ball==input.ball){
                    inputCnt++;
                }else{
                    break;
                }
            }

            if(inputCnt==N){
                totalCnt++;
                //res.add(i);
            }
        }
        System.out.println(totalCnt);
        /*for(int n: res){
            System.out.println(n);
        }*/

    }


    public static boolean checkValid(char[] valArr){
        if(valArr[0]=='0' || valArr[1]=='0' || valArr[2]=='0') return false;

        //if(valArr[0]==0 || valArr[1]==0 || valArr[2]==0) return false;

        if(valArr[0]==valArr[1]) return false;

        if(valArr[0]==valArr[2]) return false;

        if(valArr[1]==valArr[2]) return false;

        return true;
    }

    public static char[] getCharArr(int val){
        char[] valCharArray=new char[3];
        String str=Integer.toString(val);

        for(int i=0; i<3; i++){
            valCharArray[i]=str.charAt(i);
        }

        //1.toCharArray() 사용
        //valCharArray=Integer.toString(val).toCharArray();

        //0.870에서 예외 발견
        /*for(int i=0; i<3; i++){
            valCharArray[2-i]= (char)(val%10);
            val/=10;
        }*/
        return valCharArray;
    }

}

class BaseBall{
    int val;
    int strike;
    int ball;

    BaseBall(int val, int strike, int ball){
        this.val=val;
        this.strike=strike;
        this.ball=ball;
    }

}
