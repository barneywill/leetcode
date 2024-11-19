import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {

        } else if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        } else {
            List<Integer> list = new ArrayList<Integer>();
            int nums1Index = 0;
            int nums2Index = 0;
            while (true) {
                if (nums2Index == n && nums1Index == m) {
                    break;
                }
                if (nums2Index == n) {
                    list.add(nums1[nums1Index++]);
                } else if (nums1Index == m) {
                    list.add(nums2[nums2Index++]);
                } else if (nums1[nums1Index] <= nums2[nums2Index]) {
                    list.add(nums1[nums1Index++]);
                } else if (nums1[nums1Index] >= nums2[nums2Index]) {
                    list.add(nums2[nums2Index++]);
                }
            }
            for (int i = 0; i < list.size(); i++) {
                nums1[i] = list.get(i);
            }
        }
    }
}
