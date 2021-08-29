### 解题思路
一次遍历，分两种情况。
1. A 和 B 本身就相同，那么就看看A中是否有任意一个字符出现次数大于等于2，这样方便内部交换。
2. A 和 B 本身不同，就很简单容易理解了，看看两个字符不同的位置交换后是否相同。

### 代码

```cpp
class Solution {
public:
    bool buddyStrings(string A, string B) {
        if (A.length() != B.length()) return false;
        if (A == B) {
            vector<int> count(26, 0);
            for (char c : A) count[c - 'a']++;
            for (int i : count) if (i > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A[i] != B[i]) {
                    if (first == -1) first = i;
                    else if (second == -1) second = i;
                    else return false;
                }
            }
            return second == -1 ? false : A[first] == B[second] && A[second] == B[first];
        }
    }
};
```

```java
class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        if (a.equals(b)) {
            // 如果两个字符串相同， 就看看有没有一个字符出现了两次，方便进行交换
            int[] counter = new int[26];
            for (char c : a.toCharArray()) counter[c - 'a']++;
            for (int i = 0; i < 26; ++i) if (counter[i] >= 2) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < a.length(); ++i) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (second != -1) return false;
                    second = first;
                    first = i;
                }
            }
            return second == -1 ? false : a.charAt(first) == b.charAt(second) && a.charAt(second) == b.charAt(first);
        }
    }
}
```

