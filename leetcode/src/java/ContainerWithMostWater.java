import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater instance = new ContainerWithMostWater();
        System.out.println(instance.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(instance.maxArea(new int[]{1,1}));
    }
    public int maxArea(int[] height) {
        int result = 0;
        int startIndex = 0;
        int endIndex = height.length - 1;
        int previousHeight = -1;
        int currentHeight = 0;
        while (startIndex < endIndex) {
            if (previousHeight == -1) {
                previousHeight = Math.min(height[startIndex], height[endIndex]);
                result = previousHeight * (endIndex - startIndex);
                if (height[startIndex] <= height[endIndex]) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            } else {
                if (height[startIndex] <= previousHeight) {
                    startIndex++;
                    continue;
                } else if (height[endIndex] <= previousHeight) {
                    endIndex--;
                    continue;
                } else {
                    previousHeight = Math.min(height[startIndex], height[endIndex]);
                    int area = previousHeight * (endIndex - startIndex);
                    if (area > result) {
                        result = area;
                    }
                }
            }
        }
        return result;
    }
}
