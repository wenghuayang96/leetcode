//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
// 4 
// / \ 
// 2 7 
// / \ / \ 
//1 3 6 9 
//镜像输出： 
//
// 4 
// / \ 
// 7 2 
// / \ / \ 
//9 6 3 1 
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 139 👎 0


package leetcode.editor.cn;
//[剑指 Offer 27]二叉树的镜像

import leetcode.editor.entity.TreeNode;

import java.util.Objects;

public class ErChaShuDeJingXiangLcof{

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }
        swap(root);
        mirrorTree(root.right);
        mirrorTree(root.left);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        new ErChaShuDeJingXiangLcof().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        
    
    }
   

}

