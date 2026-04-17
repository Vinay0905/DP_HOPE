package java_solutions.String;

public class IsomorphicString {
    public static boolean IsomorphicOrNot(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] hash = new int[256];
        boolean[] isMapped = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (hash[c1] == 0 && !isMapped[c2]) {
                hash[c1] = c2;
                isMapped[c2] = true;
            } else if (hash[c1] == 0 || hash[c1] != c2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(IsomorphicOrNot(s, t));
    }
}
