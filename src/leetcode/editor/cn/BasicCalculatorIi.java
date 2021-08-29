//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 406 👎 0


package leetcode.editor.cn;
//[227]基本计算器 II

import java.util.*;

public class BasicCalculatorIi{
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        List<String> operatorList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();

        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    operatorList.add(c + "");
                    numberList.add(Integer.parseInt(tmp));
                    tmp = "";
                    break;
                default:
                    if (c >= '0' && c <= '9' ) {
                        tmp += c;
                    } else {
                        continue;
                    }

            }
        }
        numberList.add(Integer.parseInt(tmp));
        operatorList.add("");
//        System.out.println(operatorList);
//        System.out.println(numberList);


        Map<String, Integer> priorityMap = new HashMap<>();
        priorityMap.put("", 1);
        priorityMap.put("*", 2);
        priorityMap.put("/", 2);
        priorityMap.put("+", 1);
        priorityMap.put("-", 1);
        Stack<String> operatorStack = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        operatorStack.push(operatorList.remove(0));
        numberStack.push(numberList.remove(0));
        for (String operator : operatorList) {
//            System.out.println(numberList.get(0) + "size" + numberList.size());
            numberStack.push(numberList.remove(0));
            while (!operatorStack.isEmpty() && priorityMap.get(operatorStack.peek()) >= priorityMap.get(operator)) {
                int pop1 = numberStack.pop();
                int pop2 = numberStack.pop();
                String popOpe = operatorStack.pop();
                int res = 0;
                switch (popOpe) {
                    case "+":
                        res = pop2 + pop1;break;
                    case "-":
                        res = pop2 - pop1;break;
                    case "*":
                        res = pop2 * pop1;break;
                    case "/":
                        res = pop2 / pop1;break;
                    default:
                        break;
                }
                numberStack.push(res);
            }
            operatorStack.push(operator);
        }
//        while (!numberStack.isEmpty()) {
//            System.out.println("num" + numberStack.pop());
//        }

        return numberStack.pop();

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}

