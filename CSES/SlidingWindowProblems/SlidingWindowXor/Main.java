package SlidingWindowXor;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long[] window = new long[k]; // circular buffer

        long current = x;
        long windowXor = 0;
        long answerXor = 0;

        // build first window
        for (int i = 0; i < k; i++) {
            window[i] = current;
            windowXor ^= current;
            current = (a * current + b) % c;
        }

        answerXor ^= windowXor;

        int idx = 0; // index to remove next

        // slide window
        for (int i = k; i < n; i++) {

            long remove = window[idx];
            long add = current;

            // XOR update: remove old, add new
            windowXor ^= remove;
            windowXor ^= add;

            window[idx] = add;
            idx++;
            if (idx == k) idx = 0;

            answerXor ^= windowXor;

            current = (a * current + b) % c;
        }

        System.out.println(answerXor);
    }
}
