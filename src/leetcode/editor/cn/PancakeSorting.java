//给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。 
//
// 一次煎饼翻转的执行过程如下： 
//
// 
// 选择一个整数 k ，1 <= k <= arr.length 
// 反转子数组 arr[0...k-1]（下标从 0 开始） 
// 
//
// 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。 
//
// 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断
//为正确。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,4,1]
//输出：[4,2,4,3]
//解释：
//我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
//初始状态 arr = [3, 2, 4, 1]
//第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
//第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
//第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
//第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。 
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3]
//输出：[]
//解释：
//输入已经排序，因此不需要翻转任何内容。
//请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= arr.length 
// arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列） 
// 
// Related Topics 贪心 数组 双指针 排序 
// 👍 111 👎 0


package leetcode.editor.cn;
//[969]煎饼排序

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void printArr(int[] indArr) {
            System.out.println(Arrays.toString(indArr));
        }


        public List<Integer> pancakeSort(int[] arr) {
            int[] indArr = new int[arr.length + 1];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                indArr[arr[i]] = i;
            }
            for (int i = arr.length; i > 0; i--) {
                int k = indArr[i];
//                if (k == i-1) {
//                    continue;
//                }
                if (indArr[i] + 1 != 1) {
                    res.add(k + 1);
                    reverse(arr, indArr[i] + 1, indArr);
                }
                if (i != 1) {
                    res.add(i);
                    reverse(arr, i, indArr);
                }
//                printArr(arr);
            }

            return res;
        }

        private void reverse(int[] arr, int k, int[] indArr) {
            for (int i = 0, j = k - 1; i < j; i++, j--) {
                swap(arr, i, j);
                indArr[arr[i]] = i;
                indArr[arr[j]] = j;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new PancakeSorting().doMain();
    }

    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        int[] data = {9,8,4,1,3,2,6,5,7};

        List<Integer> integers = solution.pancakeSort(data);
        System.out.println(integers);


    }


}

