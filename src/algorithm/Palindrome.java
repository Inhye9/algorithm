package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		char[] arr=br.readLine().toCharArray();

//		char[] narr=new char[arr.length*2];
//		for(int i=0; i<arr.length; i++) {
//			narr[i]=arr[i];
//		}

        String in=br.readLine();
        //solution1(in);
        solution2(in);
        //solution3(in);
        //solution4(in);
    }

    //3. solution4
    public static void solution4(String in) {
        String str=in;
        int cnt=0;
        for(int i=0; i<in.length()-1; i++) {
            if(!isPalin4(str)) {
                str=in.substring(i);
                System.out.println(str);
            }else {
                System.out.println("before break:"+str);
                cnt=in.length()*2-str.length();
                break;
            }
        }
        System.out.println(cnt);

    }

    public static boolean isPalin4(String in) {

        int n=in.length()/2;
        for(int i=0; i<n; i++) {
            if(in.charAt(i)!=in.charAt(in.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    //2. solution3
    public static void solution3(String in) {
        int n=0;
        String str=in;
        String add="";
        while(n<in.length()) {
            System.out.println(str+"|"+isPalin(str));
            if(isPalin(str)) {
                System.out.println(str.length());
                break;
            }else {
                add=in.charAt(n)+add;
                str=in+add;
                n++;
            }
        }
    }

    public static boolean isPalin(String in) {
        int s=0, e=in.length()-1;
        while(s<=e) {
            if(in.charAt(s)!=in.charAt(e)) {
                return false;
            }else {
                s++; e--;
            }
        }
        return true;
    }

    //1. solution2
    public static void solution2(String in) {
        int e=in.length()-1;
        int s=0;
        int n=0;
        while(s<=e) {
            if(in.charAt(e)!=in.charAt(s)) {
                if(n<s+1)n=s+1;
                System.out.println("at(s):"+in.charAt(s)+" at(e):"+in.charAt(e)+ " n:"+n + " s:"+ s +" e:s"+ e);
                s++;
                e=in.length()-1;

            }else {
                s++;
                e--;
            }
        }
        System.out.println(in.length()+n);

    }



    //0. solution1
    public static void solution1(String in) {
        int s=0, e=in.length()-1;
        int cnt=0;
        int ans=0; //answer
        while(s<=e) {
            if(in.charAt(s)!=in.charAt(e)) {
                if(e!=in.length()-1) e++;
                ans+=cnt+1;
                cnt=0;
                s++;
            }else {
                cnt++;
                e--;
                s++;
            }
        }

        System.out.println(in.length()+ans);
    }

}
