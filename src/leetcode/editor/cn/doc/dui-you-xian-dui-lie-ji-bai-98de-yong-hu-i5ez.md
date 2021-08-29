### 原理
- 让A数组中所有元素和B数组中的第一个元素B[0]配对，注意这里我们加入的二元组是数组的索引，形成A.length对二元组，分别将其放入极小堆中
- 从极小堆中取出一个元素`(i,j)`（也就是最小的二元组），放入结果数组中，然后得到这个元组在B数组中的索引位置并加一，得到新的二元组`（i,j+1）`，将其放入极小堆中。

### 代码
```java
class Solution {
    class Node {
        public int i;
        public int j;

        public Node(int a, int b) {
            i = a;
            j = b;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] A, int[] B, int k) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || k <= 0) {
            return new ArrayList<>();
        }
        final int N = A.length;
        final int M = B.length;

        // 小根堆
        Queue<Node> Q = new PriorityQueue<>((v1, v2) -> A[v1.i] + B[v1.j] - A[v2.i] - B[v2.j]);

        for (int i = 0; i < N; i++) {
            Q.add(new Node(i, 0));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k && !Q.isEmpty(); i++) {
            Node p = Q.poll();
            ans.add(Arrays.asList(A[p.i], B[p.j]));
            if (p.j + 1 < M) {
                Q.add(new Node(p.i, p.j + 1));
            }
        }

        return ans;
    }
}