### 解题思路
这个问题和之前的一刀简单题目[https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/]()相似，因为需要删除倒数第n个元素，我们需要的就是倒数第n+1个元素，然后删除即可。
难点就是特殊情况的考虑，我也进行了标注
###### 代码还有改进的空间，请多指教。^^_


### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null||n<1){
            return null;
        }//边界条件筛选guolv
        ListNode temp = head;
        ListNode fastPtr = head;
        while(n+1>0){
            if (fastPtr==null){
                return temp.next;
            }//￥￥￥当n和链表的长度相同时，fastPtr会等于null，这时候我们删除头结点即可￥￥￥
            fastPtr = fastPtr.next;
            n--;
        }
        while(fastPtr!=null){
            fastPtr = fastPtr.next;
            head = head.next;//这套的问题在于，当n等于链表的长度时，找不到目标
        }
        head.next = head.next.next;
        return temp;
    }
}
```