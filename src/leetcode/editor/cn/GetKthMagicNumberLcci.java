//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 62 👎 0


package leetcode.editor.cn;
//[面试题 17.09]第 k 个数

public class GetKthMagicNumberLcci{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        int[] ps = {0,0,0};
        int[] res = new int[k];
        res[0] = 1;
        for (int i = 1; i < k; i++) {
            int rest = Math.min(Math.min(res[ps[0]] * 3, res[ps[1]] * 5), res[ps[2]] * 7);
            res[i] = rest;
            if (res[ps[0]] * 3 == rest) {
                ps[0]++;
            }
            if (res[ps[1]] * 5 == rest) {
                ps[1]++;
            }
            if (res[ps[2]] * 7 == rest) {
                ps[2]++;
            }
        }
        return res[k - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new GetKthMagicNumberLcci().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        
    
    }
   

}

