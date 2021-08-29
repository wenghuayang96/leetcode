package leetcode.editor.cn;

//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 69 👎 0


import java.util.Arrays;

/**
 * [面试题 17.14]最小K个数
 **/

public class SmallestKLcci {

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestK(int[] arr, int k) {
            int n = arr.length;
            return quick_sort(arr, 0, n - 1, k);
        }
        public int[] quick_sort(int[] a, int l, int r,  int k){
            if(l >= r) return new int[]{};
            int i = l - 1, j = r + 1;
            int x = a[l];

            while(i < j)
            {
                do i ++; while( x > a[i]);
                do j --; while( x < a[j]);
                if(i < j)
                {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
            if(j + 1 < k) quick_sort(a, j + 1, r, k);
            if(j + 1 > k) quick_sort(a, l, j, k);
            return Arrays.copyOf(a, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new SmallestKLcci().doMain();
    }

    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.smallestK(new int[]{1, 3,11,4, 5,  9,2,  7, 8, 10,6}, 8)));


    }


}

