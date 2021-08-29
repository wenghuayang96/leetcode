### 解题思路
其实就是找到四个位置分别是，第left个节点，第left节点之前的节点，第right节点，第right节点之后的节点
找到之后就可以单独对第left----right的节点位置进行单独反转。
然后返回一个节点数组，第一个是头结点，第二个尾结点，在进行链表的拼接
主要的是边界问题，这个也困扰了我很久
需要注意在头结点也是有可能发生改变的，所以需要构造一个虚拟的节点，初始化指向head节点，
这样就可以达到“以不变应万变的境界”

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
    //leecode 92 反转第left到right之间的链表
    //思想先构建一个虚拟节点，然后将这个虚拟节点指向head节点，因为头结点可能会发生变化，而造成污染
    //然后找到left的前一个节点，将这个pre.next=null
    //找到right节点的，将right.next=null
    //然后将left---right单独反转
    //之后在根据刚刚记录的进行拼接链表
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        if (left == right) {
            return head;
        }
        ListNode pre = dummy;
        ListNode pR = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;//此时pre就是第left个节点的前一个节点
            pR = pR.next;
        }
        for (int i = 0; i < right - left+1; i++) {
            pR = pR.next;//PR节点刚好是第right个节点
        }
        ListNode after = pR.next;//第right节点之后的第一个节点
        ListNode pL = pre.next;
        pre.next=null;
        pR.next = null;
        ListNode[] listNodes = reverList(pL);
        pre.next = listNodes[0];
        listNodes[1].next = after;
        return dummy.next;
    }

    ListNode[] reverList(ListNode head) {
        ListNode[] listNodes = new ListNode[2];
        ListNode pre = null;
        ListNode cur = head;
        listNodes[1] = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur=tmp;
        }
        listNodes[0] = pre;
        return listNodes;
    }


}
```