//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 265 👎 0


package leetcode.editor.cn;
//[剑指 Offer 40]最小的k个数

import java.util.*;

public class ZuiXiaoDeKgeShuLcof{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> bth = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i : arr) {
            if (bth.size() < k) {
                bth.offer(i);
                continue;
            }
            if (bth.peek() > i) {
                bth.poll();
                bth.offer(i);
            }
        }
        return bth.stream().mapToInt(i -> i).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new ZuiXiaoDeKgeShuLcof().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        PriorityQueue<Integer> bigTop = new PriorityQueue<>((o1, o2) -> o2 - o1);
        bigTop.add(1);
        bigTop.add(2);
        bigTop.add(0);
        System.out.println(bigTop.peek());
        
    
    }
   

}

