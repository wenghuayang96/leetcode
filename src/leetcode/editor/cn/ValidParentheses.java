//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2440 👎 0


package leetcode.editor.cn;

//有效的括号

import java.util.Stack;

public class ValidParentheses {


//力扣代码

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Stack<Byte> stack = new Stack<Byte>();
    public boolean isValid(String s) {

        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                    stack.push((byte)1);
                    break;
                case ')':
                    if (stack.size() == 0 || stack.peek() != (byte)1) {
                        return false;
                    }
                    stack.pop();
                    break;
                case '[':
                    stack.push((byte)2);
                    break;
                case ']':
                    if (stack.size() == 0 || stack.peek() != (byte)2) {
                        return false;
                    }
                    stack.pop();
                    break;
                case '{':
                    stack.push((byte)3);
                    break;
                case '}':
                    if (stack.size() == 0 || stack.peek() != (byte)3) {
                        return false;
                    }
                    stack.pop();
                    break;
                default: break;
            }
        }

        return stack.size() == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
