### 解题思路
一开始用Manacher算法，36ms，看了[@糖丶7](https://leetcode-cn.com/u/tang-zhu-7/)的[4ms解法](https://leetcode-cn.com/problems/longest-palindromic-substring/comments/59461)。虽然用的是优化版的暴力解法，却非常快。仔细阅读学习之后，发现核心在于：当字符串中有连续的相同字符时，可以跳跃快速移动当前的回文串中心。因此，借鉴ta的思路，在Mancher算法开始前，先对整个字符串扫一遍（O(n)），获得所有连续相同字符的串的中心以及这个串的半径。然后在这些半径的基础上再做Manacher，总复杂度还是O(n)。

后来进一步发现，在预处理好的字符串求解时，会获得很多特殊性质，进一步利用这些性质，才能获得4ms的成绩，下面给出的代码就是多次优化后的版本。其中采用的性质有如下这些（还有很多可以挖掘）：
1. Manacher算法中，当前求解中心只需取预处理时得到的那些中心；
2. 在一个连续相同字符的串中，只需求解以其中心为中心的回文串；
3. 对于两个连续串的中间的分隔符，无需以其为中心求解，直接忽略即可；
4. Manacher算法不一定要显示地插入分隔符，在算法中隐式使用就好，具体过程较复杂，可以参考以下代码；
5. 在扩展一个回文子串时，可以直接扩展左右两个连续串中最短的那个（这点代码中未采用）；
6. 。。。

总之，折腾了一天，累了，想再利用其他特性就需要深入修改算法，不想再搞了。有兴趣可以参考下面的代码（估计也没人看）。

### 代码

```java
public class Solution {

    public String longestPalindrome(String s) {

        final char[] chars = s.toCharArray();

        final int sLen = chars.length;
        final int keyLen = 2 * chars.length;
        int plen[] = new int[keyLen]; // 在对原串插入分隔符后的字符串中，以第i个字符为中心的最大回文串的半径
        int jump[] = new int[keyLen]; // 预处理得到的中心集合，即Manacher中移动中心时的快速跳转表
        int jLen = 0; // 跳转表长度

        // 预处理
        for (int i = 0; i < sLen; ) {
            final char charL = chars[i];
            final int j = i;

            do { ++i; } while (i < sLen && charL == chars[i]);

            final int d = i + j;

            jump[jLen++] = d;
            plen[d] = d - 2 * j;
        }

        int rmost = 0; // 能覆盖到的最右边的位置
        int curCentral = 0; // rmost对应的那个圆心
        int maxCentral = 0; // 最大回文串的圆心

        for (int _i = 0; _i < jLen; ++_i) {
            final int i = jump[_i];

//        for (int i = jump[0]; i < keyLen; i = jump[i]) { 上面两行的作用和这行一样

            final int tmp2 = rmost - i;
            if (plen[i] < tmp2) {
                final int tmp1 = plen[2 * curCentral - i];
                if (tmp1 < tmp2) {
                    plen[i] = tmp1;
                    continue;
                } else {
                    plen[i] = tmp2;
                }
            }

//            for (int whiteL = (i - plen[i] - 1 - 1) / 2, whiteR = (i + plen[i] + 1 - 1) / 2; whiteL >= 0 && whiteR < sLen; --whiteL, ++whiteR) { 下面一行的原本的样子
            for (int whiteL = (i - plen[i] - 2) / 2, whiteR = (i + plen[i]) / 2; whiteL >= 0 && whiteR < sLen; --whiteL, ++whiteR) {
                if (chars[whiteL] != chars[whiteR]) break;

                plen[i] += 2;
            } // 扩展回文子串

            if (plen[i] == tmp2) continue; // 无法扩展到超过rmost，跳转到下一个中心继续求解

            maxCentral = plen[i] > plen[maxCentral] ? i : maxCentral;

            rmost = i + plen[i];
            curCentral = i;
        }

        int l = maxCentral - plen[maxCentral];
        int r = maxCentral + plen[maxCentral];

        return s.substring(l / 2, r / 2);
    }

}

```