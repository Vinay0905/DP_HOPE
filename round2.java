import java.util.*;

public class round2 {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        
        HashMap<String,ArrayList<String>> map=new HashMap<>();

        for (String word : strs) {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        for (ArrayList<String> group : map.values()) {
            System.out.println(group);
        }
    }
}



