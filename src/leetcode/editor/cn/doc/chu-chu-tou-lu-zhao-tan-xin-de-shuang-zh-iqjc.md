两个贪心：
容器的容积取决于 底 * 高
所以我们的贪心就有两个方向，更长的底和更高的高

1. 更长的底： 数组的两端最长，所以我们弄 `left` `right` 分别为数组的 0位 和 length - 1位。这是可以获得的最长底，但不一定是容积最大的底，所以我们在尽可能保证 底 长的条
件下来满足我们的第二个贪心

2. 更高的高：根据木桶效应，决定整个容器容积最大值的板子，是最短的板子，所以鉴于我们最开始为了选择最高的底，我们采用了数组的两端作为高，那自然会有小的一边，我们需要做的就是贪求更高的高，所以我们移动较小的一边，并且不停的计算容积，保存一个最大值。

代码：
```java
class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        
        while(left < right)
        {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            
            if(height[left] <= height[right])
                left++;
            else
                right--;
        }
        
        return ans;

    }
}
```
