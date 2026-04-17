package java_solutions.presidio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i)==2){
                list.add(i);
            }
        }
        return list;
    }
}
