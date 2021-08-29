//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 229 👎 0


package leetcode.editor.cn;
//[662]二叉树最大宽度

import leetcode.editor.entity.TreeNode;

import java.util.*;

public class MaximumWidthOfBinaryTree{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class IndexNodePair {
        public int index;
        public TreeNode node;

        public IndexNodePair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<IndexNodePair> queue = new LinkedList<>();
        int max = 0;
        IndexNodePair nodePair = new IndexNodePair(0, root);
        queue.add(nodePair);
        while (!queue.isEmpty()) {


//            System.out.println("queue size" + queue.size());
            IndexNodePair first = queue.peekFirst();
            IndexNodePair last = queue.peekLast();
//            System.out.println(last.index + "-" + first.index);
            max = Math.max(max, last.index - first.index + 1);

//            String tmp = "";
            LinkedList<IndexNodePair> tmpQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                IndexNodePair poll = queue.poll();
//                System.out.println("nowsize" + queue.size());
                int index = poll.index;
                TreeNode left = poll.node.left;
                TreeNode right = poll.node.right;
                if (Objects.nonNull(left)) {
//                    tmp += left.val;
                    tmpQueue.offer(new IndexNodePair(index*2, left));
                }
                if (Objects.nonNull(right)) {
//                    tmp += right.val;
                    tmpQueue.offer(new IndexNodePair(index*2 + 1, right));
                }
            }
//            System.out.println(tmp);
            queue.addAll(tmpQueue);

        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new MaximumWidthOfBinaryTree().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        
    
    }
   

}

