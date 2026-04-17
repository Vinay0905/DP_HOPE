package java_solutions.String;

import java.util.Scanner;
public class Langest_word_shrotestWOrd_String {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] c=str.toCharArray();
        int n=str.length();
        int max=0;
        int min=Integer.MAX_VALUE;
        String maxs="";
        String mins="";
        for(int i=0;i<n;i++){
            String s="";
            while (i<n && c[i]!=' ') {
                s+=c[i];
                i++;

            }
            if(s.length()>max){
                max=s.length();
                maxs=s;
            }
            if(s.length()<min){
                min=s.length();
                mins=s;
            }

        }
        System.out.println("Longest word: " + maxs);
        System.out.println("Shortest word: " + mins);
        System.err.println("Longest word length: " + max);
        System.err.println("Shortest word length: " + min);
        sc.close();
    }
}
