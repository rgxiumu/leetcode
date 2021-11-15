
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治

package leetcode.editor.cn;
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {



        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = (l1 + l2 + 1)/2;

        int left = 0;
        int right = l1;

        while(left < right) {
            int i = left + (left + right + 1)/2;
            int j = total - i;

            if (nums1[i - 1] > nums2[j]) {
                left = i-1;
            }else {
                right = i;
            }
        }

        int i = left;
        int j = total - i;
        int lmax = i==0 ? Integer.MIN_VALUE:nums1[i - 1];
        int lmin = i==l1 ? Integer.MAX_VALUE:nums1[i];
        int rmax = j==0 ? Integer.MIN_VALUE:nums1[j - 1];
        int rmin = j==l2 ? Integer.MAX_VALUE:nums1[j];

        if ((l1 + l2) % 2 == 1) {
            return Math.max(lmax, rmax);
        } else {
            return ((double) (Math.max(lmax, rmax) + Math.max(lmin, rmin)))/2;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

