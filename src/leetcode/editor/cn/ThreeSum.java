package leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3521 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**[15]三数之和**/

public class ThreeSum{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] numsr) {
        int[] nums = Arrays.stream(numsr).sorted().toArray();

        List<List<Integer>> res = new ArrayList<>();
        int i,j;
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1])continue;;
            i = k + 1;
            j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1])i++;
                    while (i < j && nums[j] == nums[j - 1])j--;
                    i++;
                    j--;
                } else if (sum > 0) {
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
        new ThreeSum().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));


    }
   

}

