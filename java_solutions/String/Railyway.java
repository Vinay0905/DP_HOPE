package java_solutions.String;

import java.util.Scanner;

public class Railyway {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        int n = str.length();
        if(c[n-2]=='A' || c[n-2] =='a'){
            if(c[0]=='1' && c[1]=='2'){
                c[0] = '0';
                c[1] = '0';

            }
            else {
                if(!(c[0]=='1' && c[1]=='2')){
                    int t=(c[0]-'0')*10+(c[1]-'0');
                    t+=12;
                    c[0]=(char)(t/10+'0');
                    c[1]=(char)(t%10+'0');
                }
            }

        }
        System.out.println(new String(c, 0, n-2));
        sc.close();
    }
}
