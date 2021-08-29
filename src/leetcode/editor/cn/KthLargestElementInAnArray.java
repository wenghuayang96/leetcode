//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1161 👎 0


package leetcode.editor.cn;
//[215]数组中的第K个最大元素

import java.util.PriorityQueue;

public class KthLargestElementInAnArray{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> smallTop = new PriorityQueue<>();
        for (int num : nums) {
            smallTop.offer(num);
            if (smallTop.size() > k) {
                smallTop.poll();
            }
        }
        return smallTop.peek();
    }

    private void offer(int num) {


    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new KthLargestElementInAnArray().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        
    
    }
   

}

