### 本篇用于轻松记忆+彻底理解二叉树的前中后序遍历之迭代法
二叉树的遍历有递归、迭代、Morris 遍历三种方法，其中递归非常简单，而Morris遍历相对复杂，因此，面试中常考察的是手写**迭代法**，现将二叉树的前中后序遍历的迭代法放在一起，便于理解比较和记忆。

迭代法的**核心**是： 借助**栈**结构，模拟递归的过程，需要注意何时出栈入栈，何时访问结点

以下是前中后序遍历的具体实现方式：

**前序**遍历：
```
public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                list.add(root.val);//根
                stack.push(root);
                root=root.left;//左
            }
            root = stack.pop();
            root = root.right;//右
  
        }
        return list;
    }
```

**中序**遍历：
```
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;//左
            }
            root = stack.pop();
            list.add(root);//根
            root = root.right;//右
        }  
        return list;
    }
```

到这里，会发现，前序和中序遍历的迭代写法仅仅**略有不同**：
- 前序遍历需要每次向左走之前就访问根结点
- 而中序遍历先压栈，在出栈的时候才访问


**后序**遍历：

后序遍历有一个便于记忆的技巧方法：
我们发现，前序遍历的顺序是**根左右**，那么只需要将前序的左右顺序互换即变成了**根右左**，这时候考虑多用一个栈或者用双端队列，反过来，这时候就变成了后序的**左右根**

```
    //技巧法：
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> queue = new LinkedList<>();
    
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                queue.offerFirst(root.val);//逆序加入 根
                stack.push(root);
                root=root.right;//右
            }
            root = stack.pop();
            root = root.left;//左
        }        
        return new ArrayList<Integer>(queue);//左右根
     }
```

但有些人觉得上述技巧并非“真正”的后序遍历

那么，如果不允许用上述技巧，需要 "真正"的后序遍历，也很简单，重点在于：
- 如果右子树为空或者已经访问过了才访问根结点
- 否则，需要将该结点**再次**压回栈中，去访问其右子树
```
    //常规法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;//用于记录前一个访问的结点
        
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(root.right==null || root.right==pre){
                list.add(root.val);//访问
                pre = root;//更新
                root = null;//使得下一次循环直接出栈下一个
            }else{
                stack.push(root);//再次压回栈
                root = root.right;//访问右子树
            }     
        }
        return list;
    }
```

