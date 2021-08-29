**思路：**
本题使用topk的经典解法。利用优先级队列PriorityQueue，构造大小为K的大根堆。
1、堆没有放满的情况下，直接往堆里面添加，直到添加到K的大小。
2、堆的大小等于K之后，每次存放数对的时候，和堆顶比较，如果堆顶的元素大于当前的数对，那么出队。然后添加当前数对。
3、直到遍历完两个数组。
**注意点：**
1、遍历两个数组的时候，大小要和k取最小值。防止这种情况：num1:[1]  num2:[1,2,3]
2、取结果的时候注意，一定要判断队列此时空不空，队列虽然大小是k，但是有可能放不满k个。
**代码：**
```
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2)->{
            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
        });
        //取最小值是为了防止两个数组一个比较少的时候【1】  【1,2,3】
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            for(int j = 0; j < Math.min(nums2.length, k); j++){
                if(queue.size() < k) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums1[i]);
                    pair.add(nums2[j]);
                    queue.add(pair);
                }else {
                    int top = queue.peek().get(0) + queue.peek().get(1);
                    //大于K就出队列 
                    if(top > nums1[i]+nums2[j]){
                        List<Integer> pair = new ArrayList<>();
                        queue.poll();
                        pair.add(nums1[i]);
                        pair.add(nums2[j]);
                        queue.add(pair);
                    }
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for(int i =0; i < k && !queue.isEmpty(); i++){
            res.add(queue.poll());
        }
        return res;
    }
}
```
看懂点个赞，不足留言评论，进行完善。感谢铁铁们。手动笔芯！！！

