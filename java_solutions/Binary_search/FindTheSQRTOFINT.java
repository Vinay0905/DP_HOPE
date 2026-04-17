package java_solutions.Binary_search;

public class FindTheSQRTOFINT {
    public static int mysqrt(int n) {
        int l = 1, h = n;
        while (l <= h) {
            int m = (l + h) / 2;
            if (m * m == n)
                return m;
            else if (m * m > n)
                h = m - 1;
            else
                l = m + 1;

        }
        return h;

    }

    public static double multiplier(double numb, int n) {
        double ans = 1.0;
        for (int i = 0; i < n; i++) {
            ans *= numb;
        }
        return ans;

    }

    public static int nthroot(int n, int k) {
        double l = 1, h = n, eps = 1e-6;
        while ((l - h) > eps) {
            double m = (l + h) / 2.0;
            if (multiplier(m, n) < k) {
                l = m;
            } else {
                h = m;
            }
        }
        return (int) l;

    }

    public static void main(String[] args) {
        int n = 28;
        int ans = mysqrt(n);
        System.out.print(ans);

    }
}
