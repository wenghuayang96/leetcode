//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 字典树 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
// 👍 354 👎 0


package leetcode.editor.cn;
//[692]前K个高频单词

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counterMap = new HashMap<>(words.length / 3);
        for (String word : words) {
            counterMap.put(word, counterMap.getOrDefault(word,0) + 1);
        }
        Set<Map.Entry<String, Integer>> entries = counterMap.entrySet();
        PriorityQueue<Map.Entry<String, Integer>> smallTop = new PriorityQueue<>(k, (e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return e2.getKey().compareTo(e1.getKey());
            }
            return e1.getValue() - e2.getValue();
        });
        for (Map.Entry<String, Integer> entry : entries) {
            if (smallTop.size() < k) {
                smallTop.offer(entry);
                continue;
            }
            if (smallTop.peek().getValue() < entry.getValue() || (smallTop.peek().getValue().equals(entry.getValue()) && smallTop.peek().getKey().compareTo(entry.getKey()) > 0)) {
                smallTop.offer(entry);
                smallTop.poll();
            }
        }

//        System.out.println(counterMap);
        return new ArrayList<>(smallTop).stream().sorted(getEntryComparator()).map(Map.Entry::getKey).collect(Collectors.toList());
    }

        private Comparator<Map.Entry<String, Integer>> getEntryComparator() {
            return (e1, e2) -> {
                if (e1.getValue().equals(e2.getValue())) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                return e2.getValue() - e1.getValue();
            };
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new TopKFrequentWords().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST

        String[] data = {"a", "aa", "aaa"};
        System.out.println(solution.topKFrequent(data, 2));


    }
   

}

