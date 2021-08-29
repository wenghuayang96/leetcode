package leetcode.editor.cn;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 822 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**[16]最接近的三数之和**/

public class ThreeSumClosest{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] numsOr, int target) {
        int[] nums = Arrays.stream(numsOr).sorted().toArray();

//        List<Integer> res = new ArrayList<>();
        int res = 0;
        int i,j;
        int close = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1])continue;;
            i = k + 1;
            j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (Math.abs(sum - target) < close) {
                    res = sum;
                }
                if (sum - target > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new ThreeSumClosest().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        
    
    }
   

}

