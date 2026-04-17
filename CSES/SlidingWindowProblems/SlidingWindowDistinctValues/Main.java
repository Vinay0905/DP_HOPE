package SlidingWindowDistinctValues;

import java.io.*;
import java.util.*;

public class Main {

    // frequency map
    static HashMap<Integer, Integer> freq = new HashMap<>();

    static void add(int v) {
        freq.put(v, freq.getOrDefault(v, 0) + 1);
    }

    static void remove(int v) {
        int f = freq.get(v) - 1;
        if (f == 0) freq.remove(v);
        else freq.put(v, f);
    }

    static int get() {
        return freq.size();
    }

    // Fast input reader (needed for large inputs)
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int n = fs.nextInt();
        int k = fs.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fs.nextInt();

        // build first window
        for (int i = 0; i < k; i++) add(arr[i]);

        out.append(get()).append(' ');

        // slide window
        for (int i = k; i < n; i++) {
            remove(arr[i - k]);
            add(arr[i]);
            out.append(get()).append(' ');
        }

        System.out.print(out.toString());
    }
}
