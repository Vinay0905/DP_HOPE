package SlidingWindowSum;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long[] window = new long[k];


        long sum = 0;
        long xor = 0;

        long current = x;

        // build first window
        for (int i = 0; i < k; i++) {
            window[i] = current;
            sum += current;
            current = (a * current + b) % c;
        }

        xor ^= sum;

        int idx = 0; // element to remove next
        for (int i = k; i < n; i++) {

            long remove = window[idx];

            // generate next value already stored in 'current'
            long add = current;

            // sliding window update
            sum += add - remove;

            window[idx] = add;
            idx++;
            if (idx == k) idx = 0;

            xor ^= sum;

            // generate next number
            current = (a * current + b) % c;
        }

        System.out.println(xor);
    }    
}
