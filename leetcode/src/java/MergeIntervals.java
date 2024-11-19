import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals instance = new MergeIntervals();
        int[][] intervals = new int[][]{
                new int[]{1,3},
                new int[]{8,10},
                new int[]{2,6},
                new int[]{15,18}
        };
        int[][] result = instance.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0] + "," + result[i][1] + "; ");
        }
        System.out.println();

        intervals = new int[][]{
                new int[]{1,4},
                new int[]{5,8}
        };
        result = instance.merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0] + "," + result[i][1] + "; ");
        }
        System.out.println();
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<int[]>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][0] == end || intervals[i][1] > end) {
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][0]);
    }
}
