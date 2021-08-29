### 解题思路
使用快排分区思想：

使用基准数将一个区间分为两半，前一部分的值都小于基准数，后一部分的值都大于基准数

此时我们判断小于基准数的前半部分的区间长度与k的关系
- 如果前半部分区间长度小于等于k，则我们把前半部分区间的值存入结果集，然后让k减去区间长度，判断剩余k的大小
  - 如果k等于0则说明可以返回结果了
  - 如果大于0，说明还要找，那么剩下的k个需要到大于基准数的那部分去找，直接递归。
- 如果前半部分区间长度大于k，说明还需要分割，直接递归。

### 代码

```java
class Solution {
    int[] res = null;
    int index = 0;
    public int[] smallestK(int[] arr, int k) {
        if(arr.length == k){
            return arr;
        }
        res = new int[k];
        quickSort(arr,0 ,arr.length-1, k);
        return res;
    }
    public void quickSort(int[] arr, int l, int r, int k){
        if(r >= l){
            int i = l, j = r, pivot = arr[l];
            while(i < j){
                while(i < j && arr[j] > pivot){
                    j--;
                }
                if(j > i){
                    arr[i++] = arr[j];
                }
                while(i < j && arr[i] < pivot){
                    i++;
                }
                if(j > i){
                    arr[j--] = arr[i];
                }
            }
            arr[i] = pivot;
            //----    以上为快排分区 --------
            //判断从l ~ i+1的长度是否小于等于k
            int len = i + 1 - l;
            if(len <= k){
                //先把这前几个元素加入结果集
                for(j = l; j < i + 1; j++){
                    res[index++] = arr[j];
                }
                //如果这个区间长度比k小则，还需要到后半部分区间去寻找剩下的k个元素
                if(len < k){
                    quickSort(arr, i+1, r, k - len);
                }
            }else{
                //前部分区间比k大，区间还需要分割
                quickSort(arr, l, i-1, k);
            }
        }
    }
}
```