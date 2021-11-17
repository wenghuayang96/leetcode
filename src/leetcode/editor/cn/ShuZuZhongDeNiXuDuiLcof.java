package leetcode.editor.cn;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 559 👎 0


/**
 * [剑指 Offer 51]数组中的逆序对
 **/

public class ShuZuZhongDeNiXuDuiLcof {

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reversePairs(int[] nums) {
            return countResult(nums, 0, nums.length - 1);
        }

        private int countResult(int[] nums, int l, int r) {
            if (l >= r) return 0;
            int ans = 0, mid = (r + l) >> 1;
            ans += countResult(nums, l, mid);
            ans += countResult(nums, mid + 1, r);
            int k = l, p1 = l, p2 = mid + 1;
            int[] temps = new int[r - l + 1];
            while (p1 <= mid || p2 <= r) {
                if (p2 > r || (p1 <= mid && nums[p1] <= nums[p2])) {
                    temps[k - l] = nums[p1++];
                } else {
                    temps[k - l] = nums[p2++];
                    ans += mid - p1 + 1;
                }
                k++;

            }
            for (int i = l; i <= r; i++) {
                nums[i] = temps[i - l];
            }

            return ans;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new ShuZuZhongDeNiXuDuiLcof().doMain();
    }

    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));


    }


}

