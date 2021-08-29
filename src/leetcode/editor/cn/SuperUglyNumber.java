//编写一段程序来查找第 n 个超级丑数。 
//
// 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。 
//
// 示例: 
//
// 输入: n = 12, primes = [2,7,13,19]
//输出: 32 
//解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26
//,28,32] 。 
//
// 说明: 
//
// 
// 1 是任何给定 primes 的超级丑数。 
// 给定 primes 中的数字以升序排列。 
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。 
// 第 n 个超级丑数确保在 32 位有符整数范围内。 
// 
// Related Topics 数组 哈希表 数学 动态规划 堆（优先队列） 
// 👍 172 👎 0


package leetcode.editor.cn;
//[313]超级丑数

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SuperUglyNumber{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] points = new int[primes.length];
        int[] res = new int[n];
        res[0] = 1;
        int tmp = 0;
        for (int i = 1; i < n; i++) {
            tmp = res[points[0]] * primes[0];
//            System.out.println("tmp" + tmp);
            for (int j = 1; j < primes.length; j++) {
                tmp = Math.min(res[points[j]] * primes[j], tmp);
//                System.out.println("tmp" + tmp);
            }
//            System.out.println(tmp);
            for (int j2 = 0; j2 < primes.length; j2++) {
                if (res[points[j2]] * primes[j2] == tmp) {
                    points[j2]++;
                }
            }
            res[i] = tmp;
        }
//        System.out.println(Stream.of(res).map(i -> Arrays.toString(i) + "").collect(Collectors.joining(",")));
        return res[n - 1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new SuperUglyNumber().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        
    
    }
   

}

