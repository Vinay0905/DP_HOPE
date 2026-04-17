package SlidingWindowOR;

import java.io.*;
import java.util.*;

public class Main {

    // aggregation function: bitwise OR
    static int aggFunc(int a, int b) {
        return a | b;
    }

    // Stack that keeps aggregated OR up to top
    static class AggStack {
        // each element: [value, aggregated OR]
        ArrayDeque<int[]> st = new ArrayDeque<>();

        void push(int x) {
            int cur = st.isEmpty() ? x : aggFunc(st.peek()[1], x);
            st.push(new int[]{x, cur});
        }

        void pop() {
            st.pop();
        }

        int agg() {
            return st.peek()[1];
        }

        boolean isEmpty() {
            return st.isEmpty();
        }
    }

    // Queue using two aggregation stacks
    static class AggQueue {
        AggStack in = new AggStack();
        AggStack out = new AggStack();

        void push(int x) {
            in.push(x);
        }

        void pop() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    int v = in.st.peek()[0];
                    in.pop();
                    out.push(v);
                }
            }
            out.pop();
        }

        int query() {
            if (in.isEmpty()) return out.agg();
            if (out.isEmpty()) return in.agg();
            return aggFunc(in.agg(), out.agg());
        }
    }

    // Fast input reader (important for CSES limits)
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

        int n = fs.nextInt();
        int k = fs.nextInt();

        int x = fs.nextInt();
        int a = fs.nextInt();
        int b = fs.nextInt();
        int c = fs.nextInt();

        AggQueue aggQueue = new AggQueue();

        // generator
        java.util.function.IntUnaryOperator next = (v) -> (int)(((long)a * v + b) % c);

        int l = x, r = x;
        aggQueue.push(r);

        for (int i = 1; i < k; i++) {
            r = next.applyAsInt(r);
            aggQueue.push(r);
        }

        long ans = aggQueue.query();

        for (int i = k; i < n; i++) {
            aggQueue.pop();
            l = next.applyAsInt(l);
            r = next.applyAsInt(r);
            aggQueue.push(r);
            ans ^= aggQueue.query();
        }

        System.out.println(ans);
    }
}
