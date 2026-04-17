package SlidingWindowMode;

import java.io.*;
import java.util.*;

public class Main {

    // TreeSet keeps pairs ordered by (-frequency, value)
    static TreeSet<int[]> freqSet = new TreeSet<>((a, b) -> {
        if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
        return Integer.compare(a[1], b[1]);
    });

    static HashMap<Integer, Integer> freqMap = new HashMap<>();

    static void add(int v) {
        int freq = freqMap.getOrDefault(v, 0);

        if (freq > 0) {
            freqSet.remove(new int[]{-freq, v});
        }

        freqMap.put(v, freq + 1);
        freqSet.add(new int[]{-(freq + 1), v});
    }

    static void remove(int v) {
        int freq = freqMap.get(v);

        freqSet.remove(new int[]{-freq, v});

        if (freq > 1) {
            freqSet.add(new int[]{-(freq - 1), v});
        }

        if (freq == 1) freqMap.remove(v);
        else freqMap.put(v, freq - 1);
    }

    static int get() {
        return freqSet.first()[1];
    }

    // Fast IO for large input
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
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        int k = fs.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fs.nextInt();

        // build first window
        for (int i = 0; i < k; i++) add(arr[i]);

        out.print(get());
        out.print(' ');

        for (int i = k; i < n; i++) {
            remove(arr[i - k]);
            add(arr[i]);
            out.print(get());
            out.print(' ');
        }

        out.flush();
    }
}
