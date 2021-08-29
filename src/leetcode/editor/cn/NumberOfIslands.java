//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1227 👎 0


package leetcode.editor.cn;
//[200]岛屿数量

public class NumberOfIslands{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        UnionFind unionFind = new UnionFind(n * m );
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                int idx = fetchIdx(i, j);
                if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                    unionFind.union(idx, fetchIdx(i - 1, j));
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    unionFind.union(idx, fetchIdx(i, j - 1));
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                if (unionFind.find(fetchIdx(i, j)) == fetchIdx(i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private int fetchIdx(int i, int j) {
        return i * m + j;
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
        new NumberOfIslands().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        char[][] chars = {{'1'}, {'1'}};
        System.out.println(solution.numIslands(chars));
    }
   

}

