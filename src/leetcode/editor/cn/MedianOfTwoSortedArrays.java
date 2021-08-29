//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
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
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4232 👎 0


package leetcode.editor.cn;
//[4]寻找两个正序数组的中位数

import java.util.*;

public class MedianOfTwoSortedArrays{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length != 0) {
                if (nums2.length % 2 == 1) {
                    return nums2[nums2.length / 2 + 1];
                } else {
                    return (nums2[nums2.length / 2] + nums2[nums2.length / 2 + 1]) / 2d;
                }
            }
            if (nums1.length != 0 && nums2.length == 0) {
                if (nums1.length % 2 == 1) {
                    return nums1[nums1.length / 2 + 1];
                } else {
                    return (nums1[nums1.length / 2] + nums1[nums1.length / 2 + 1]) / 2d;
                }
            }
            int length = nums1.length + nums2.length;

            if (length % 2 == 1) {
                int k = length / 2 + 1;



            } else {

            }
            return 0d;


        }


    //todo 使用二分找第k小
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length == 0 && nums2.length == 0) {
//            return 0;
//        }
//        PriorityQueue<Integer> pq1big = new PriorityQueue<>((x, y) -> y - x);
//        PriorityQueue<Integer> pq2small = new PriorityQueue<>();
//
//        List<Integer> nums = new ArrayList<>(nums1.length + nums2.length);
//        for (int i : nums1) {
//            nums.add(i);
//        }
//        for (int i : nums2) {
//            nums.add(i);
//        }
//        int[] ints = nums.stream().mapToInt(i -> i).toArray();
//
//        pq1big.offer(ints[0]);
//        for (int i = 1; i < ints.length; i++) {
//            loop(ints[i], pq1big, pq2small);
//        }
//
//        if (pq2small.isEmpty()) {
//            return pq1big.peek();
//        }
//        if (pq2small.size() == pq1big.size()) {
//            return (pq2small.peek() + pq1big.peek()) / 2D;
//        }
//        return pq1big.peek();
//
//    }

        private void loop(int tmp1, PriorityQueue<Integer> pq1big, PriorityQueue<Integer> pq2small) {
            int tmp = tmp1;
            if (pq1big.peek() > tmp) {
                pq1big.offer(tmp);
            } else {
                pq2small.offer(tmp);
            }
            if (pq1big.size() > pq2small.size() + 1) {
                pq2small.offer(pq1big.poll());
            }
            if (pq2small.size() > pq1big.size()) {
                pq1big.offer(pq2small.poll());
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new MedianOfTwoSortedArrays().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));


    }
   

}

