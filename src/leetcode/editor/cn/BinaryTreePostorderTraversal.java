//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树
// 👍 607 👎 0


package leetcode.editor.cn;
//[145]二叉树的后序遍历

import leetcode.editor.entity.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal{



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



        public List<Integer> postorderTraversal(TreeNode root) {
            if (Objects.isNull(root)) {
                return Collections.emptyList();
            }
            return postScanWithStack(root);
        }

        public List<Integer> postScanWithStack(TreeNode root) {
            Stack<TreeNode> pStack = new Stack<>();
            Stack<Integer> sStack = new Stack<>();

            ArrayList<Integer> result = new ArrayList<>();
            pStack.push(root);
            sStack.push(0);
            while (!pStack.isEmpty()) {
                TreeNode peek = pStack.peek();
                Integer status = sStack.pop();
                switch (status) {
                    case 0 : {
                        sStack.push(1);
                        if (Objects.nonNull(peek.left)) {
                            sStack.push(0);
                            pStack.push(peek.left);
                        }
                    }
                    case 1 : {
                        sStack.push(2);
                        if (Objects.nonNull(peek.right)) {
                            sStack.push(0);
                            pStack.push(peek.right);
                        }
                    }
                    case 2 : {
                        TreeNode pop = pStack.pop();
                        result.add(pop.val);
                    }
                }

            }
            return result;
        }

        public List<Integer> postScan(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();
            if (Objects.nonNull(root.left)) {
                leftList = postScan(root.left);
            }
            if (Objects.nonNull(root.right)) {
                rightList = postScan(root.right);
            }
            list.addAll(leftList);
            list.addAll(rightList);
            list.add(root.val);
            return list;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


}

