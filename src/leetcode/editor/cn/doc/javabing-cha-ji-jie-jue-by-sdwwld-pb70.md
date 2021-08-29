
在两个pair中，如果有相同的数字，我们可以认为他们是一阵营的，比如[0,1]和[1,2]。

**举个例子**
s="abcdefg"
[[0,2],[1,3],[2,5],[4,6],[3,4]]
![image.png](https://pic.leetcode-cn.com/1610335465-giOkHK-image.png)



```
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int length = s.length();
        //记录每个值的父节点值，初始状态默认每个值的父节点值都是他自己，祖宗节点也是他自己
        int[] parent = new int[length];
        for (int i = 0; i < length; i++)
            parent[i] = i;

        //pair中指向的两个值是可以自由交换的，所以他们是一阵营的，也就是祖宗是同一个。
        for (List<Integer> pair : pairs) {
            int ancestry0 = find(pair.get(0), parent);
            int ancestry1 = find(pair.get(1), parent);
            //ancestry0和ancestry1用哪一个成为他们的祖宗都是可以的
            parent[ancestry1] = ancestry0;
        }

        Map<Integer, Queue<Character>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            //具有同一祖宗的，说明他们是一阵营的，把他们放到同一队列中
            int ancestry = find(i, parent);
            map.computeIfAbsent(ancestry, k -> new PriorityQueue<>()).offer(s.charAt(i));
        }

        //最后在进行合并
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            //找到i所在的队列，然后元素出队（这里的队列使用的是PriorityQueue，
            //其实就是个最小堆，每次出来的都是队列中最小的值）
            Queue queue = map.get(find(i, parent));
            stringBuilder.append(queue.poll());
        }
        return stringBuilder.toString();
    }

    //查找祖宗节点，只有当前的值等于他父节点值的时候才是祖宗节点。
    private int find(int i, int[] parent) {
        if (parent[i] != i) {
            //如果不是祖宗节点就继续往上查找
            parent[i] = find(parent[i], parent);
        }
        return parent[i];
    }
```




<br>

>如果觉得有用就给个赞吧，还可以关注我的[LeetCode主页](https://leetcode-cn.com/u/sdwwld/)查看更多的详细题解
