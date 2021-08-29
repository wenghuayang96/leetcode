//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1091 👎 0


package leetcode.editor.cn;
//[105]从前序与中序遍历序列构造二叉树

import leetcode.editor.entity.TreeNode;

import java.util.Arrays;
import java.util.Stack;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{

    public static void main(String[] args) {
        new ConstructBinaryTreeFromPreorderAndInorderTraversal().doMain();
    }
    
    public void doMain() {
        Solution solution = new Solution();
        // TO TEST
        
    
    }
    
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
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        Stack<int[]> paramsStack = new Stack<>();
//        Stack<TreeNode> resStack = new Stack<>();
//        Stack<Integer> statusStack = new Stack<>();
//
//        paramsStack.push(new int[]{0, preorder.length - 1, 0, inorder.length - 1});
//        statusStack.push(0);
//
//        while (!statusStack.isEmpty()) {
//            Integer status = statusStack.pop();
//            int[] params = paramsStack.peek();
//            switch (status) {
//                case 0: {//计算位置
//                    int preStart = params[0];
//                    int preEnd = params[1];
//                    if (preEnd == preStart) {
//                        resStack.push(null);
//                        continue;
//                    }
//                    int root = preorder[0];
//                    int leftSize = 0;
//                    for (int i = 0; i < inorder.length; i++) {
//                        if (inorder[i] == root) {
//                            leftSize = i;
//                        }
//                    }
//                    TreeNode treeNode = new TreeNode();
//                    treeNode.val = root;
//                    int[] lpre = Arrays.stream(preorder).skip(1).limit(leftSize).toArray();
//                    int[] rpre = Arrays.stream(preorder).skip(leftSize + 1).toArray();
//                    int[] lin = Arrays.stream(inorder).limit(leftSize).toArray();
//                    int[] rin = Arrays.stream(inorder).skip(leftSize + 1).toArray();
//                }
//                case 1: {
//
//
//                }
//            }
//
//        }
//
//
//    }
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length == 0) {
//            return null;
//        }
//        int root = preorder[0];
//        int leftSize = 0;
//        for (int i = 0; i < inorder.length; i++) {
//            if (inorder[i] == root) {
//                leftSize = i;
//            }
//        }
//        TreeNode treeNode = new TreeNode();
//        treeNode.val = root;
//        int[] lpre = Arrays.stream(preorder).skip(1).limit(leftSize).toArray();
//        int[] rpre = Arrays.stream(preorder).skip(leftSize + 1).toArray();
//        int[] lin = Arrays.stream(inorder).limit(leftSize).toArray();
//        int[] rin = Arrays.stream(inorder).skip(leftSize + 1).toArray();
//        treeNode.left = buildTree(lpre, lin);
//        treeNode.right = buildTree(rpre, rin);
//        return treeNode;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


}

