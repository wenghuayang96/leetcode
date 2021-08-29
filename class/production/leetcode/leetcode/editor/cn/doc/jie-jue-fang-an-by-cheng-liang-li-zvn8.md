class Solution {
    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        res[0] = 1;
        int p3=0, p5=0, p7=0;
        while(--k > 0) {
            int p3Val = 3 * res[p3];
            int p5Val = 5 * res[p5];
            int p7Val = 7 * res[p7];

            int min = p3Val;
            if (min >= p5Val) {
                min = p5Val;
                p5++;
            }
            if (min >= p7Val) {
                min = p7Val;
                p7++;
            }
            if(min == p3Val) {
                p3++;
            }
            res[res.length - k]= min;
        }
        return res[res.length - 1];
    }
}![leet.png](https://pic.leetcode-cn.com/1625294637-cbFeOb-leet.png)
