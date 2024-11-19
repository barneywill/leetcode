import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater instance = new TrappingRainWater();
        System.out.println(instance.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(instance.trap(new int[]{4,2,0,3,2,5}));
    }
    public int trap(int[] height) {
        int result = 0;
        if (height.length > 1) {
            int maxHeight = 0;
            int maxHeightStart = -1;
            int maxHeightEnd = -1;
            int minHeight = Integer.MAX_VALUE;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0) {
                    if (maxHeight < height[i]) {
                        maxHeight = height[i];
                        maxHeightStart = i;
                        maxHeightEnd = i;
                    } else if (maxHeight == height[i]) {
                        maxHeightEnd = i;
                    }
                    if (minHeight > height[i]) {
                        minHeight = height[i];
                    }
                }
            }
//            System.out.println("min : " + minHeight + ", max : " + maxHeight + ", " + maxHeightStart + "-" + maxHeightEnd);
            int[] sortHeight = new int[maxHeight - minHeight];
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0 && height[i] < maxHeight) {
                    sortHeight[height[i] - minHeight]++;
                }
            }
            result += getWater(maxHeightStart, maxHeightEnd, maxHeight, height);
//            System.out.println("result : " + result);
            if (maxHeightStart != 0 || maxHeightEnd != height.length - 1) {
                HeightState hs = new HeightState();
                hs.start = maxHeightStart;
                hs.end = maxHeightEnd;
                for (int i = sortHeight.length - 1; i >= 0; i--) {
                    if (sortHeight[i] > 0) {
                        hs.height = i + minHeight;
//                        System.out.println("start : " + hs.start + ", end : " + hs.end + ", " + hs.height);
                        result += expand(height, hs);
//                        System.out.println("result : " + result);
                        if (hs.start == 0 && hs.end == height.length - 1) {
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    private int getWater(int start, int end, int maxHeight, int[] height) {
        int result = 0;
        if (start + 1 < end) {
            for (int i = start + 1; i < end; i++) {
                result += (maxHeight - height[i]);
            }
        }
        return result;
    }
    private int expand(int[] height, HeightState hs) {
        int result = 0;
        int start = -1;
        int end = -1;
        boolean isEmpty = true;
        for (int i = 0; i < hs.start; i++) {
            if (height[i] > 0) {
                isEmpty = false;
            }
            if (height[i] == hs.height) {
                start = i;
                break;
            }
        }
        if (start != -1) {
            result += getWater(start, hs.start, hs.height, height);
            hs.start = start;
        } else if (isEmpty) {
            hs.start = 0;
        }
        isEmpty = true;
        for (int i = height.length - 1; i > hs.end; i--) {
            if (height[i] > 0) {
                isEmpty = false;
            }
            if (height[i] == hs.height) {
                end = i;
                break;
            }
        }
        if (end != -1) {
            result += getWater(hs.end, end, hs.height, height);
            hs.end = end;
        } else if (isEmpty) {
            hs.end = height.length - 1;
        }
        return result;
    }
    class HeightState {
        public int height = 0;
        public int start = 0;
        public int end = 0;
    }
}
