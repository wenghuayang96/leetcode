### 解题思路
此处撰写解题思路

### 代码

```java
class Solution {
    public int[] smallestK(int[] arr, int k) {
         int n = arr.length;
         return quick_sort(arr, 0, n - 1, k);
    }
    public static int[] quick_sort(int[] a, int l, int r,  int k){
        if(l >= r) return new int[]{};
        int i = l - 1, j = r + 1;
        int x = a[l];

        while(i < j)
        {
            do i ++; while( x > a[i]);
            do j --; while( x < a[j]);
            if(i < j)
            {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        if(j + 1 < k) quick_sort(a, j + 1, r, k);
        if(j + 1 > k) quick_sort(a, l, j, k);
        return Arrays.copyOf(a, k);
    }
}
```