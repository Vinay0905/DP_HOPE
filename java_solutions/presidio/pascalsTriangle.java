package java_solutions.presidio;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        
        for (int i = 0; i <= rowIndex; i++) {
            row.add((int) val);
            val = val * (rowIndex - i) / (i + 1);
        }
        
        return row;
    }

    public static void main(String[] args) {
        int rowIndex=3;
        System.out.println(getRow(rowIndex));

    }
}
