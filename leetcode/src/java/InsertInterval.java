import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval instance = new InsertInterval();
        int[][] intervals = new int[][]{
                new int[]{1,3},
                new int[]{6,9}
        };
        int[][] result = instance.insert(intervals, new int[]{2,5});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0] + "," + result[i][1] + "; ");
        }
        System.out.println();

        intervals = new int[][]{
                new int[]{1,2},
                new int[]{3,5},
                new int[]{6,7},
                new int[]{8,10},
                new int[]{12,16}
        };
        result = instance.insert(intervals, new int[]{4,8});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0] + "," + result[i][1] + "; ");
        }
        System.out.println();

        intervals = new int[][]{
                new int[]{1,3},
                new int[]{6,9}
        };
        result = instance.insert(intervals, new int[]{4,5});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0] + "," + result[i][1] + "; ");
        }
        System.out.println();
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<int[]>();
        if (intervals.length == 0) {
            result.add(newInterval);
        } else if (intervals[0][0] > newInterval[1]) {
            result.add(newInterval);
            for (int[] interval : intervals) {
                result.add(interval);
            }
        } else if (intervals[intervals.length - 1][1] < newInterval[0]) {
            for (int[] interval : intervals) {
                result.add(interval);
            }
            result.add(newInterval);
        } else if (newInterval[0] <= intervals[0][0] && newInterval[1] >= intervals[intervals.length - 1][1]) {
            result.add(newInterval);
        } else {
            int start = -1;
            int end = -1;
            for (int i = 0; i < intervals.length; i++) {
                if (newInterval[1] < intervals[i][0] && intervals[i - 1][1] < newInterval[0]) {
                    result.add(newInterval);
                    result.add(intervals[i]);
                } else if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                    if (start != -1) {
                        result.add(new int[]{start, end});
                        start = -1;
                        end = -1;
                    }
                    result.add(intervals[i]);
                } else {
                    if (start == -1) {
                        start = Math.min(intervals[i][0], newInterval[0]);
                        end = Math.max(intervals[i][1], newInterval[1]);
                    } else {
                        if (end >= intervals[i][0] && end < intervals[i][1]) {
                            end = intervals[i][1];
                        }
                    }
                }
            }
            if (start != -1) {
                result.add(new int[]{start, end});
                start = -1;
                end = -1;
            }
        }
        return result.toArray(new int[0][0]);
    }
}
