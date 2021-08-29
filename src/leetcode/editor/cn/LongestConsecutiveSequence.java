package leetcode.editor.cn;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 828 👎 0


import java.util.HashMap;
import java.util.Map;

/**[128]最长连续序列**/

public class LongestConsecutiveSequence{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> idxMap = new HashMap<>(nums.length * 2);
        UnionFind unionFind = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            idxMap.putIfAbsent(nums[i], i);
            if (idxMap.containsKey(nums[i] - 1)) {
                unionFind.union(idxMap.get(nums[i]), idxMap.get(nums[i] - 1));
            }
            if (idxMap.containsKey(nums[i] + 1)) {
                unionFind.union(idxMap.get(nums[i]), idxMap.get(nums[i] + 1));
            }

        }
        int res = 0;
        for (int i : unionFind.getSz()) {
            res = Math.max(res ,i);
        }
        return res;
    }

        public class UnionFind {
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
        new LongestConsecutiveSequence().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        int[] ints = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(ints));


    }
   

}

