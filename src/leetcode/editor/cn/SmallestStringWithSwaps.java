package leetcode.editor.cn;

//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 哈希表 字符串 
// 👍 230 👎 0


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**[1202]交换字符串中的元素**/

public class SmallestStringWithSwaps{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0){
            return s;
        }
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> pair : pairs){
            uf.union(pair.get(0),pair.get(1));
        }

        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int root = uf.find(i);
            if(map.containsKey(root)){
                map.get(root).offer(s.charAt(i));
            }else {
                PriorityQueue<Character> minHeap = new PriorityQueue<>();
                minHeap.offer(s.charAt(i));
                map.put(root,minHeap);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int root = uf.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();

    }

        class UnionFind {
            private int[] id;
            private int count;
            private int[] sz;

            public UnionFind(int N) {
                count = N;
                id = new int[N];
                sz = new int[N];
                for(int i = 0; i < N; i++) {
                    id[i] = i;
                    sz[i] = 1;
                }
            }

            public int[] getSz() {
                return this.sz;
            }

            public int getCount() {
                return count;
            }

            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }

            public int find(int p) {
                if (p != id[p]) id[p] = find(id[p]);
                return id[p];
            }

            public void union(int p, int q){
                int pRoot = find(p);
                int qRoot = find(q);

                if(pRoot == qRoot) return;

                if(sz[pRoot] < sz[qRoot]) { id[pRoot] = qRoot; sz[qRoot] += sz[pRoot]; }
                else                      { id[qRoot] = pRoot; sz[pRoot] += sz[qRoot]; }
                count--;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new SmallestStringWithSwaps().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        System.out.println(solution.smallestStringWithSwaps("dcab", pairs));

    }
   

}

