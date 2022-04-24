public class TrappingRainWater {

    public int trap(int[] height) {
        int result = 0;
        int[] sortHeight = new int[height.length];
        int maxHeight = 0;
        int maxHeightStart = -1;
        int maxHeightEnd = -1;
        for (int i = 0; i < height.length; i++) {
            sortHeight[i] = height[i];
            if (maxHeight < height[i]) {
                maxHeight = height[i];
                maxHeightStart = i;
                maxHeightEnd = i;
            } else (maxHeight == height[i]) {
                maxHeightEnd = i;
            }
        }
        Arrays.sort(sortHeight);
        if (maxHeightStart < maxHeightEnd) {
            result = (maxHeightEnd - maxHeightStart) * maxHeight;
        }
        HeightState hs = new HeightState();
        hs.start = maxHeightStart;
        hs.end = maxHeightEnd;
        if (maxHeightStart > 0 || maxHeightEnd < height.length - 1) {
            for (int i = sortHeight.length - 2; i >= 0; i++) {
                hs.height = sortHeight[i];
                result += expand(height, hs);
                if (hs.start == 0 && hs.end = height.length - 1) {
                    break;
                }
            }
        }
        return result;
    }
    private int expand(int[] height, HeightState hs) {
        int result = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < start; i++) {
            if (height[i] == hs.height) {
                start = i;
                break;
            }
        }
        for (int i = height.length - 1; i > end; i--) {
            if (height[i] == hs.height) {
                end = i;
                break;
            }
        }
        return result;
    }
    class HeightState (
            public int height = 0;
            public int start = 0;
            public int end = 0;
    )
}
