package SDESheetChallenge_2026.June_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static List<List<Integer>> merge(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> mergedIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || interval[0] > mergedIntervals.get(mergedIntervals.size() - 1).get(1)) {
                mergedIntervals.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
            } else {
                List<Integer> lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
                lastInterval.set(1, Math.max(lastInterval.get(1), interval[1]));
            }
        }

        return mergedIntervals;
    }
    public static void main(String[] args) {
     
        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        List<List<Integer>> result = merge(intervals);

        for (List<Integer> interval : result) {
            System.out.print(
                "[" + interval.get(0) + "," + interval.get(1) + "] "
            );
        }
    }
}
