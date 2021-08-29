//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10000 
// 0 <= hours[i] <= 16 
// 
// Related Topics 栈 
// 👍 137 👎 0


package leetcode.editor.cn;
//[1124]表现良好的最长时间段

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval{

    public static void main(String[] args) {
        System.out.println(1);
        Solution solution = new Solution();
        // TO TEST
//        int[] arr = {6,9,9};
        int[] arr = {14,7,16,14,8,9,13,15,9,13,8,13,12,12,14,10,6,10,16,1,10,3,15,15,4,14,12,3,2,7,7,6,1,10,14,3,3,6,10,0,16,4,16,14,9,6,13,4,12,15,16,0,13,5,3,12,1,3,2,16,4,6,13,15,11,14,13,1,7,1,4,12,0,7,8,11,10,13,2,8,12,16,3,1,3,15,2,9,5,10,7,9,3,0,1,6,10,4,12,8,2,1,15,12,6,0,12,3,3,1,1,12,10,12,4,8,13,13,9,9,5,0,16,8,3,11,5,6,0,2,13,9,10,16,12,4,12,7,3,3,9,3,3,4,6,13,15,6,9,1,6,3,10,5,7,3,8,3,6,9,7,9,5,8,8,13,13,10,14,5,15,0,5,7,7,4,10,16,6,14,12,13,15,4,2,14,2,12,16,14,11,10,1,16,2,10,12,10,0,0,4,11,3,4,13,9,1,7,10,10,3,5,14,5,2,0,13,6,6,0,7,2,1,10,16,6,13,0,1,13,0,6,10,3,13,16,11,11,10,6,5,16,12,0,12,2,12,12,11,9,12,16,2,16,3,3,1,3,5,0,16,7,4,10,5,16,15,6,7,2,15,7,6,10,5,3,12,2,12,3,15,14,5,5,8,9,5,8,1,16,11,1,12,5,8,11,14,9,0,1,6,0,16,0,4,6,0,0,10,2,14,5,5,15,16,0,0,16,5,2,15,13,0,8,5,9,4,14,2,6,5,0,1,8,2,6,7,8,4,7,1,14,5,7,11,8,12,14,14,9,14,11,4,0,14,8,8,1,0,5,6,0,3,6,0,2,5,16,8,12,4,10,13,6,1,1,9,10,15,12,2,14,14,14,15,15,6,12,14,13,0,5,10,9,0,2,8,12,16,10,16,8,13,11,15,13,1,10,6,8,15,5,2,0,10,8,14,9,15,6,10,16,3,7,0,8,10,14,4,6,13,4,7,1,8,10,7,0,4,1,12,0,1,7,1,5,15,0,9,4,3,8,2,5,0,2,10,13,10,1,4,4,3,15,10,9,15,14,14,3,9,10,6,8,5,14,3,14,3,11,6,12,6,15,8,7,9,6,1,1,4,14,2,1,16,1,1,5,11,14,2,7,10,10,9,4,14,1,6,2,2,13,4,13,9,11,9,8,9,2,6,10,9,15,9,6,11,5,7,4,14,8,10,2,5,10,8,0,5,12,10,15,14,5,10,2,3,8,7,6,6,0,3,2,9,13,10,5,8,14,4,4,8,1,15,11,7,5,1,11,15,3,4,11,15,2,5,15,11,1,10,7,8,1,3,1,15,14,15,6,9,10,9,12,0,7,10,3,14,0,16,10,12,6,16,15,10,14,13,9,14,13,11,0,0,13,6,6,2,8,1,9,10,16,5,1,13,0,4,14,13,2,16,4,14,8,16,4,9,13,0,3,15,13,10,2,4,15,13,3,1,10,9,14,4,11,7,11,5,13,9,6,9,16,0,9,13,4,16,9,6,14,1,4,14,0,10,13,12,7,13,1,4,7,16,2,7,3,1,12,1,0,2,11,3,8,16,10,16,0,8,12,16,15,6,12,14,9,9,5,0,16,9,7,14,6,15,0,2,3,10,15,12,5,13,0,11,4,15,10,9,0,2,11,3,12,0,9,4,11,3,3,4,8,14,7,5,16,15,5,10,2,7,2,11,1,9,15,14,16,14,0,4,2,3,4,9,3,6,1,16,10,10,6,2,14,2,6,5,1,4,12,6,3,3,6,0,9,1,1,7,8,3,6,9,4,16,14,4,9,12,5,8,3,3,12,12,9,8,5,11,5,12,10,3,3,12,8,8,8,2,0,14,6,8,6,6,12,7,10,11,1,16,12,14,6,9,14,11,13,3,8,13,8,0,16,11,12,1,4,4,3,7,5,6,0,0,0,7,6,2,11,12,12,9,3,15,0,7,5,3,7,5,3,8,6,15,3,12,13,14,4,6,10,3,7,13,2,7,13,12,11,11,8,2,12,8,12,0,15,7,1,7,10,2,14,5,6,8,9,8,0,4,10,2,10,4,14,5,6,12,10,11,14,14,6,1,8,9,3,0,16,12,1,14,2,10,4,8,9,7,15,5,13,9,16,10,7,13,3,7,10,9,2,15,4,1,11,12,12,6,12,15,1,3,16,6,11,6,3,9,3,9,9,13,16,16,6,7,11,2,11,0,7,2,14,16,1,6,2,12,3,14,0,7,12,3,0,16,7,14,9,10,11,0,0,1,1,16,6,16,12,6,5,1,12,10,12,4,15,11,16,13,9,8,10,8,7,13,1,15,7,8,0,13,13,5,0,9,0,14,1,11,7,3,8,14,14,2,0,2,1,12,12,5,3,13,8,9,4,5,12,16,0,14,2,8,6,4,15,6,15,2,12,14,7,1,7,5,6,8,1,15,5,10,15,1,8,12,12,2,9,10,7,15,4,8,0,10,3,12,16,7,8,14,16,14,5,2,16,1,14,11,11,5,0,9,3,12,2,12,4,6,5,5,5,12,7,16,2,3,7,2,0,1,11,10,3,10,11,9,2,14,7,2,15,14,2,2,11,11,3,3,10,11,1,8,1,15,5,6,12,6,1,2,6,13,1,14,2,10,6,10,7,12,7,9,2,12,11,10,11,16,13,6,6,0,6,5,16,4,14,3,15,12,13,16,12,13,1,15,10,3,3,14,8,7,12,15,9,14,15,8,12,4,16,8,2,16,14,3,15,0,1,6,7,0,16,13,4,4,16,4,8,2,10,14,10,13,8,9,14,10,4,5,11,10,10,13,7,9,8,13,15,2,3,13,5,15,13,9,10,11,16,14,6,0,12,7,0,4,10,8,1,1,9,15,7,16,14,1,9,4,10,9,2,8,7,3,6,8,10,10,5,9,11,2,9,13,10,15,16,12,8,2,10,1,10,1,16,8,9,9,6,11,12,5,2,16,5,15,16,5,16,15,7,6,6,15,10,1,8,13,4,12,11,14,0,15,12,1,7,3,2,10,14,8,12,4,9,1,12,11,16,6,7,13,4,9,7,3,7,16,4,2,11,6,5,16,14,4,1,4,3,9,10,4,15,16,13,6,5,9,1,6,15,4,4,13,1,4,7,10,14,10,4,10,6,4,4,7,1,3,6,8,16,13,4,10,4,2,12,7,6,10,5,9,8,10,9,16,6,14,3,10,0,15,7,3,1,13,1,15,9,12,13,13,8,15,2,3,4,16,11,13,7,15,5,7,3,14,14,14,8,7,0,14,12,2,11,3,12,14,13,2,0,16,3,4,10,9,0,7,12,1,2,14,14,15,16,4,10,10,8,6,9,3,3,3,3,12,7,10,3,16,1,2,13,4,4,4,1,4,14,3,2,1,6,11,8,11,15,9,6,4,5,9,14,5,11,4,15,1,6,7,15,16,6,15,1,15,12,13,6,13,6,5,1,15,3,11,15,14,0,1,3,6,1,16,4,6,6,15,16,7,9,12,0,3,1,11,16,16,5,15,16,12,15,3,0,12,5,9,8,14,1,14,15,3,2,13,1,16,11,1,5,10,13,14,0,4,15,0,4,6,6,6,6,15,12,16,5,5,13,1,12,0,9,16,10,0,12,1,1,6,1,8,4,10,15,4,10,6,0,9,14,16,6,6,7,2,11,4,4,13,15,14,4,2,15,11,7,16,2,10,13,10,2,4,5,7,8,11,10,5,16,6,15,0,14,0,0,4,11,7,2,5,1,1,0,3,9,11,2,3,4,2,4,3,8,8,2,12,1,11,4,1,2,9,9,14,8,1,5,6,6,13,16,16,4,10,16,10,0,10,14,5,1,5,13,3,6,13,13,10,4,2,15,14,3,5,9,16,3,12,13,2,14,10,0,4,12,7,12,11,13,3,0,2,10,12,3,0,7,14,15,4,4,1,15,11,12,15,10,9,2,2,2,11,11,16,6,15,13,10,14,6,5,8,11,8,1,3,11,14,3,1,15,5,0,10,10,11,15,16,16,1,12,7,3,1,11,8,5,14,10,15,10,8,10,8,9,11,7,12,5,10,8,7,14,1,3,16,13,0,15,15,8,12,16,2,7,8,15,5,5,9,8,12,14,10,2,15,14,5,5,0,14,4,8,5,16,13,0,6,11,5,15,1,13,16,4,12,14,1,0,1,7,11,14,2,4,8,8,12,14,5,4,10,15,14,14,12,9,4,1,10,7,11,9,1,10,2,2,9,3,2,15,1,3,3,15,5,11,1,12,12,8,9,4,0,3,14,9,5,14,4,16,10,15,5,7,7,1,0,8,15,16,16,13,11,16,3,1,2,7,2,16,5,2,11,8,7,12,6,3,7,6,2,13,16,15,9,14,5,11,10,13,1,10,2,2,6,16,16,9,11,2,4,9,2,9,11,6,15,6,9,6,11,8,9,13,16,11,6,3,16,0,16,4,7,13,0,13,13,14,16,4,5,4,1,16,10,11,0,12,12,2,0,2,7,14,14,13,9,6,16,1,8,9,6,5,1,0,7,14,5,4,7,11,14,0,2,13,5,8,14,2,1,8,2,11,5,5,0,9,12,4,10,9,1,5,7,0,2,4,15,10,13,5,15,10,15,0,5,10,6,6,16,11,15,3,0,8,14,15,15,6,10,4,0,15,2,15,3,3,15,16,3,8,9,4,8,0,7,16,15,2,0,0,7,11,7,3,2,7,11,13,9,15,10,15,0,0,7,13,14,9,2,16,8,13,6,12,1,11,8,9,11,15,7,8,4,9,1,4,9,7,7,8,3,1,13,8,8,6,7,1,13,11,10,4,12,4,15,0,12,9,10,4,3,14,3,5,16,12,5,0,1,6,5,15,7,1,14,7,11,2,3,4,13,15,4,6,10,8,9,16,5,6,15,2,6,6,1,8,3,13,9,8,4,6,13,9,7,13,3,0,0,13,12,14,2,8,9,5,9,10,3,9,5,6,7,15,1,12,11,1,16,4,10,10,9,2,6,13,9,12,14,14,0,16,3,3,1,4,7,7,13,4,4,0,11,4,11,15,9,8,0,11,2,7,5,1,9,3,15,0,3,6,4,6,6,1,8,2,14,8,5,5,9,14,14,12,3,3,11,8,1,12,4,2,9,7,11,3,10,1,12,10,8,12,2,5,4,8,9,15,4,7,2,12,6,2,2,8,8,2,12,8,4,16,12,10,6,2,8,3,9,3,4,3,5,3,16,4,15,4,11,14,10,7,16,15,9,6,0,15,12,7,9,15,15,10,4,4,10,7,2,0,14,1,2,12,8,8,10,8,12,10,14,14,3,13,5,12,12,13,6,10,3,3,8,1,1,2,14,0,3,5,6,13,14,1,3,9,5,2,9,5,3,3,12,13,2,13,7,2,2,6,1,5,11,11,8,9,14,12,15,9,10,12,13,0,15,15,10,9,12,11,7,14,15,13,4,12,11,4,10,0,8,12,6,2,10,1,0,14,3,13,0,4,4,4,8,0,7,11,15,7,10,1,13,4,8,2,0,14,13,11,15,3,7,16,8,7,6,0,2,0,0,7,14,13,7,0,9,12,16,16,16,2,16,1,10,9,13,14,1,15,9,12,13,0,11,10,12,12,9,0,3,16,0,11,0,9,13,2,16,2,8,1,14,9,0,2,12,9,8,13,10,10,10,4,8,15,5,5,12,2,13,14,5,1,2,11,8,2,16,11,8,14,5,13,4,8,6,8,11,2,1,10,3,6,3,13,5,7,5,12,0,10,11,3,6,9,1,16,12,12,8,10,1,3,0,7,5,10,9,5,1,16,15,2,3,9,6,16,2,2,3,0,15,1,1,1,16,3,14,15,7,7,1,11,16,0,4,11,10,12,14,3,4,0,4,13,7,8,5,13,10,10,0,4,11,1,3,8,7,2,0,9,2,10,15,8,2,11,0,2,11,14,0,15,16,10,10,9,0,14,5,6,14,0,12,2,0,0,13,14,4,15,8,16,16,9,4,16,2,11,8,15,6,5,12,13,16,1,7,16,9,13,11,12,6,14,13,6,9,13,2,6,12,5,4,7,3,0,3,1,4,16,9,4,9,4,5,15,0,5,4,3,9,13,3,10,11,5,0,4,14,9,8,3,16,12,2,5,16,4,2,0,11,4,9,2,8,4,5,3,6,14,10,15,2,11,5,12,1,9,11,12,14,8,2,9,5,15,16,2,7,4,8,8,10,3,10,7,6,14,15,2,11,7,15,8,9,6,5,0,7,1,9,5,4,3,0,14,15,14,15,5,2,7,16,16,4,9,8,1,11,1,14,13,2,4,4,4,5,12,1,4,6,12,6,6,0,16,2,7,11,16,13,15,1,8,2,11,7,15,0,2,4,13,11,3,16,15,2,5,7,2,6,13,10,10,8,13,16,16,6,7,6,12,6,12,0,6,5,11,2,7,3,5,1,15,9,16,9,2,0,1,5,1,0,5,3,10,10,15,6,11,3,5,10,12,10,13,8,5,6,8,2,4,12,16,0,15,7,11,6,3,0,6,15,9,4,7,13,1,15,8,12,16,5,8,6,4,10,13,12,13,4,3,14,6,0,16,2,11,1,2,9,14,3,1,1,5,2,7,2,1,13,1,11,13,0,15,15,3,14,13,10,10,14,13,3,7,10,11,11,10,15,15,1,4,7,7,3,7,4,4,5,15,9,7,13,13,0,8,16,14,1,10,2,15,6,4,7,11,16,3,9,16,15,15,16,15,5,0,1,15,6,1,1,15,2,3,16,6,7,13,3,12,6,5,0,0,1,7,14,12,2,14,5,13,12,3,10,6,9,13,10,11,1,11,5,9,9,2,8,12,2,7,1,7,15,2,8,12,14,6,0,15,14,4,2,6,12,8,2,13,14,11,11,9,5,16,2,15,12,14,15,14,1,12,7,12,13,11,4,0,14,9,14,7,9,5,13,8,1,0,1,1,3,13,11,11,9,15,0,16,13,3,1,10,10,14,2,14,11,2,5,10,1,3,10,1,4,6,12,3,2,15,0,1,4,6,7,13,9,7,16,16,14,8,8,6,16,13,2,7,7,7,11,7,5,15,12,2,14,4,3,3,2,0,12,13,11,11,4,9,13,12,7,4,7,8,4,8,3,4,12,13,16,7,11,5,9,16,11,3,16,6,16,10,2,7,6,0,11,2,6,2,13,8,16,8,4,3,3,8,6,13,14,4,9,6,2,14,4,9,16,8,14,10,15,14,7,12,5,7,1,11,1,12,5,12,2,15,9,1,6,14,2,8,9,14,1,16,14,2,2,8,3,2,11,7,15,0,16,13,4,7,8,13,13,13,4,1,8,6,0,9,12,15,7,11,1,2,1,6,8,8,7,11,7,5,7,15,11,6,11,11,4,2,6,11,6,2,4,7,6,0,16,14,5,5,1,5,7,2,3,16,9,12,5,0,10,0,13,12,8,14,1,3,5,7,4,1,9,9,1,15,13,15,7,4,2,11,1,0,1,0,4,13,7,9,15,7,6,14,10,9,10,3,5,15,6,15,12,11,13,6,7,16,7,5,0,6,5,13,4,8,2,14,6,5,7,15,10,14,0,3,2,15,11,3,8,6,7,13,7,11,10,16,12,11,16,15,7,14,8,12,3,1,13,7,16,12,9,7,15,11,3,5,4,1,6,11,8,0,7,11,5,12,15,9,14,3,10,0,13,13,1,9,8,4,7,6,11,14,10,9,4,4,3,4,1,15,8,16,3,12,8,11,13,15,11,5,8,14,14,10,7,6,3,14,13,9,6,4,13,16,12,16,6,2,11,9,7,8,11,8,14,4,13,4,14,11,1,3,1,7,10,1,7,12,10,0,14,7,6,9,7,6,13,2,14,13,3,0,11,7,4,14,0,4,15,0,16,7,6,7,0,9,9,9,13,6,5,6,12,16,15,6,10,9,12,4,3,6,2,15,5,9,5,11,8,10,7,2,3,10,10,10,0,9,6,14,5,9,14,4,4,3,8,0,15,15,14,4,10,11,1,4,6,5,0,8,4,6,7,8,10,10,7,11,4,1,13,14,11,0,4,5,13,5,1,5,8,4,12,10,13,2,16,14,12,2,5,3,5,13,11,2,12,10,10,12,12,9,9,11,8,6,4,0,6,12,7,8,13,16,7,1,13,6,4,14,11,8,5,4,13,11,7,16,9,13,7,12,5,5,16,3,11,9,5,0,12,11,10,10,11,14,0,5,12,14,0,11,4,3,2,2,8,11,6,9,6,4,0,16,15,13,11,16,5,1,10,6,5,8,10,0,11,12,6,8,5,10,10,9,16,9,14,15,14,8,15,16,16,0,14,6,15,0,5,2,3,13,9,0,9,16,3,8,10,6,13,10,14,4,1,4,9,14,8,8,16,11,11,2,3,0,7,15,5,16,8,14,1,5,11,5,2,12,10,4,9,15,13,2,7,16,10,1,15,16,0,7,7,16,4,9,13,12,7,9,0,11,12,6,4,6,11,7,8,14,9,8,16,14,4,7,16,0,3,10,13,3,3,11,3,12,0,8,4,2,11,1,13,2,15,10,3,10,7,10,10,5,2,10,0,0,3,4,0,0,9,1,1,16,0,6,8,8,5,2,12,8,14,10,4,6,10,11,5,15,10,16,2,3,1,7,14,10,15,7,5,5,6,3,5,16,3,5,3,9,10,12,4,7,14,7,9,11,1,2,3,4,2,0,8,8,3,3,14,9,9,2,1,9,9,8,4,4,1,12,7,1,5,15,8,15,10,6,7,1,10,15,3,16,6,15,6,1,7,4,6,8,9,10,10,11,8,3,2,14,4,3,7,12,4,0,3,3,11,3,15,9,4,1,16,3,10,10,12,16,15,13,0,12,8,7,3,16,4,15,7,11,9,13,13,4,16,9,9,3,4,15,12,14,16,0,6,1,0,6,12,7,0,9,13,8,6,3,0,10,12,11,16,3,0,16,4,14,8,14,2,11,14,6,3,14,3,13,7,16,14,11,13,4,5,6,10,0,16,14,4,6,9,3,11,7,8,11,0,5,9,2,13,15,15,10,1,2,5,13,8,8,11,11,7,2,3,11,4,11,7,2,12,8,13,1,13,12,7,8,3,1,12,2,16,14,16,0,5,4,7,9,7,16,14,5,16,4,16,10,0,16,13,4,13,7,15,12,10,10,7,8,10,7,3,14,7,1,13,15,15,16,9,15,2,7,11,13,10,0,9,13,4,5,3,13,13,10,3,1,6,6,6,2,7,11,11,3,11,9,2,13,15,16,0,9,0,8,9,11,5,1,14,6,14,14,14,4,0,7,16,10,15,3,9,13,9,0,6,3,1};
        System.out.println("ans:" + solution.longestWPI(arr));
    }

}
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int longestWPI(int[] hours) {
//        int sum = 0;
//        int res = 0;
//        Map<Integer, Integer> sumToIndex = new HashMap<>();
//        for(int i = 0; i < hours.length; i++){
//            int temp = hours[i] > 8 ? 1 : -1;
//            sum += temp;
//            if(sum > 0)
//                res = i + 1;
//            else {
//                if(!sumToIndex.containsKey(sum))
//                    sumToIndex.put(sum, i);
//                if(sumToIndex.containsKey(sum - 1))
//                    res = Math.max(res, i - sumToIndex.get(sum - 1));
//            }
//        }
//        return res;
//    }
    public int longestWPI(int[] hours) {
        int now = 0;
        Map<Integer, Integer> preSumMinMap = new HashMap<>(hours.length);
//        Map<Integer, Integer> preSumMaxMap = new HashMap<>();

        preSumMinMap.put(0, -1);
        int[] preSum = new int[hours.length];
        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            int add = hours[i] > 8 ? 1 : -1;
            now += add;
            preSumMinMap.putIfAbsent(now, i);
//            preSumMaxMap.put(now, i);
//            preSum[i] = now;

            int j = find(preSumMinMap, now, i);
//            System.out.println("i:" + i + ",sum:" + preSum[i] + ",j:" + j);
            if (j == i) {
                continue;
            }
            int var = i - j;

//            System.out.printf(" i:" + i +" ,this:%s:%s ,j:%s, var:%s%n",  preSum[i], i, j, var);
            max = Math.max(max, var);

        }
//        System.out.println();
//        System.out.print("[");
//        for (int i : preSum) {
//            System.out.print(i + ",");
//        }
//        System.out.print("]");
//        System.out.println();
//        System.out.println("------preSumMinMap");
//        preSumMinMap.forEach((k, v) -> System.out.println(k + ":" + v));
//        System.out.println("------preSumMinMap");


//        for (int i = 0; i < preSum.length; i++) {
//            int j = find(preSumMinMap, preSum[i], i);
//            System.out.println("i:" + i + ",sum:" + preSum[i] + ",j:" + j);
//            if (j == i) {
//                continue;
//            }
//            int var = i - j;
//
//            System.out.printf(" i:" + i +" ,this:%s:%s ,j:%s, var:%s%n",  preSum[i], i, j, var);
//            max = Math.max(max, var);
//        }
//        System.out.println(111);
        return max;
    }

    private int find(Map<Integer, Integer> map, int key, int i) {
        if (key > 0) {
            return -1;
        }
        int j = i;
        if (map.containsKey(key - 1)) {
            j = map.get(key - 1);
        }
//        while (map.containsKey(--tmpKey) && map.get(tmpKey) < i ) {
//            j = Math.min(map.get(tmpKey), j);
//        }
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

