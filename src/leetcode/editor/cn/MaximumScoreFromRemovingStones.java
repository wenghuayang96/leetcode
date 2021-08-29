//你正在玩一个单人游戏，面前放置着大小分别为 a、b 和 c 的 三堆 石子。 
//
// 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。 
//
// 给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。 
// 
//
// 示例 1： 
//
// 
//输入：a = 2, b = 4, c = 6    q
//输出：6
//解释：石子起始状态是 (2, 4, 6) ，最优的一组操作是：
//- 从第一和第三堆取，石子状态现在是 (1, 4, 5)
//- 从第一和第三堆取，石子状态现在是 (0, 4, 4)
//- 从第二和第三堆取，石子状态现在是 (0, 3, 3)
//- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
//- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
//- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
//总分：6 分 。
// 
//
// 示例 2： 
//
// 
//输入：a = 4, b = 4, c = 6
//输出：7
//解释：石子起始状态是 (4, 4, 6) ，最优的一组操作是：
//- 从第一和第二堆取，石子状态现在是 (3, 3, 6)
//- 从第一和第三堆取，石子状态现在是 (2, 3, 5)
//- 从第一和第三堆取，石子状态现在是 (1, 3, 4)
//- 从第一和第三堆取，石子状态现在是 (0, 3, 3)
//- 从第二和第三堆取，石子状态现在是 (0, 2, 2)
//- 从第二和第三堆取，石子状态现在是 (0, 1, 1)
//- 从第二和第三堆取，石子状态现在是 (0, 0, 0)
//总分：7 分 。
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = 8, c = 8
//输出：8
//解释：最优的一组操作是连续从第二和第三堆取 8 回合，直到将它们取空。
//注意，由于第二和第三堆已经空了，游戏结束，不能继续从第一堆中取石子。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b, c <= 105 
// 
// Related Topics 贪心 数学 堆（优先队列） 
// 👍 18 👎 0


package leetcode.editor.cn;
//[1753]移除石子的最大得分

public class MaximumScoreFromRemovingStones{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumScore(int a, int b, int c) {
        int tmp;
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
//        System.out.println(String.format("a:%s,b:%s,c:%s", a, b ,c));
        if (b > c) {
            tmp = c;
            c = b;
            b = tmp;
        }
//        System.out.println(String.format("a:%s,b:%s,c:%s", a, b ,c));
        if (a > c) {
            tmp = a;
            a = c;
            c = tmp;
        }
        int res = 0;
//        System.out.println(String.format("a:%s,b:%s,c:%s,res:%s", a, b ,c, res));

        int diff = c - b;
        if (diff > 0) {
            if (a > diff) {
                a -= diff;
                c -= diff;
                res += diff;
            } else {
                res += a;
                c -= a;
                a -= a;

            }
        }


//        System.out.println(String.format("a:%s,b:%s,c:%s,res:%s", a, b ,c, res));
        if (a > 0) {
            if (a % 2 == 1) {
                a--;
            }
            int chu = a / 2;
            b -= chu;
            c -= chu;
            res += a;
        }

        res += Math.min(b, c);


        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new MaximumScoreFromRemovingStones().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        
    
    }
   

}

