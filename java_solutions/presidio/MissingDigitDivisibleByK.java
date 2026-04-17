package java_solutions.presidio;

public class MissingDigitDivisibleByK {

    public static String[] fillQuestionMark(String s, int k) {
        int qIndex = s.indexOf('?');
        if (qIndex == -1) {
            // no '?', just check once
            long val = Long.parseLong(s);
            return (val % k == 0) ? new String[] { s } : new String[0];
        }

        java.util.List<String> result = new java.util.ArrayList<>();

        for (int d = 0; d <= 9; d++) {
            char c = (char) ('0' + d);
            String candidate = s.substring(0, qIndex) + c + s.substring(qIndex + 1);
            // avoid leading zero if you don't want numbers like "05"
            if (candidate.length() > 1 && candidate.charAt(0) == '0') {
                continue;
            }
            long val = Long.parseLong(candidate);
            if (val % k == 0) {
                result.add(candidate);
            }
        }

        return result.toArray(new String[0]);

    }

    public static void main(String[] args) {
        String[] res1 = fillQuestionMark("?5", 5);
        System.out.println("k=5, s=\"?5\":");
        for (String x : res1) {
            System.out.println(x);
        }

        String[] res2 = fillQuestionMark("1?0", 30);
        System.out.println("k=30, s=\"1?0\":");
        for (String x : res2) {
            System.out.println(x);
        }
    }
}