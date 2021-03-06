package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3830 👎 0


/**[5]最长回文子串**/

public class LongestPalindromicSubstring{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) return "";
            int l = 0, r = 0;
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandLength(s, i, i);
                int len2 = expandLength(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len- 1) / 2;
                    end = i + len / 2 ;
                }
            }
            return s.substring(start, end + 1);

        }

        private int expandLength(String s, int l, int r) {
            int L = l, R = r;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new LongestPalindromicSubstring().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("aaaa"));


    }
   

}

