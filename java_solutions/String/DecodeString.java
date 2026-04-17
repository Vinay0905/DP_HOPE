package java_solutions.String;

public class DecodeString {
    public static void main(String[] args) {
        String s="q12b4c3";
        int n = s.length();
        char[] input = s.toCharArray();
        
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] >= '0' && input[i] <= '9') {
                maxLen = maxLen * 10 + (input[i] - '0');
            }
        }
        
        char[] result = new char[maxLen];
        int pos = 0;
        
        int i = 0;
        while (i < n) {
            char ch = input[i];
            i++;
            
            int count = 0;
            while (i < n && input[i] >= '0' && input[i] <= '9') {
                count = count * 10 + (input[i] - '0');
                i++;
            }
            
            for (int j = 0; j < count; j++) {
                result[pos++] = ch;
            }
        }
        
        System.out.println(new String(result, 0, pos));
        
    }
}