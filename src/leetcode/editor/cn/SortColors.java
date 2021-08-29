package leetcode.editor.cn;

//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 数组 双指针 排序 
// 👍 954 👎 0


import java.util.Arrays;
import java.util.Objects;

/**[75]颜色分类**/

public class SortColors{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return;
        }

        int lt = 0, i = 1, gt = nums.length;
        while (i < gt) {
            if (nums[i] == 0) {
                swap(nums, i, lt + 1);
                i++;
                lt++;
            } else if (nums[i] == 2) {
                swap(nums, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        if (nums[0] == 2) {
            swap(nums, gt - 1, 0);
        }
        if (nums[0] == 1) {
            swap(nums, 0, lt);
        }




    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new SortColors().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        int[] ints = {2,0,2,1,1,0};
        solution.sortColors(ints);
        System.out.println(Arrays.toString(ints));
        
    
    }
   

}

