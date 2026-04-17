package java_solutions.String;

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s,String t){
        if(s.length()!=t.length())return false;
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1 );

        }
        for (char c:t.toCharArray()){
            if(!map.containsKey(c))return false;
            map.put(c,map.get(c)-1);
            if(map.get(c)==0) map.remove(c);
        }
        return map.isEmpty();

    }
    public static void main(String[] args) {
        String Str1 = "INTEGER";  // Example string to check
        String Str2 = "TEGERNI";  // Example string to check
        System.out.println(isAnagram(Str1, Str2));
        
    }
}
