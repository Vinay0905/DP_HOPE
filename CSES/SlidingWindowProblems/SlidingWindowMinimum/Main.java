package SlidingWindowMinimum;


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
        Deque<Integer> dq = new ArrayDeque<>();

long xor = 0;
        long current = x;

        for (int i = 0; i < n; i++) {

            long value = current;
            window[i % k] = value;

            
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            
            while (!dq.isEmpty()
                    && window[dq.peekLast() % k] >= value)
                dq.pollLast();

            
            dq.addLast(i);

            
            if (i >= k - 1) {
                long minVal = window[dq.peekFirst() % k];
                xor ^= minVal;
            }

            
            current = (a * current + b) % c;
        }

        System.out.println(xor);
    }    
}

