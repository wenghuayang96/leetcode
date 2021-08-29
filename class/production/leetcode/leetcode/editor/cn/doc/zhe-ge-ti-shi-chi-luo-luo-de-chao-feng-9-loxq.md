### 解题思路
1. 先做前缀和，大于8小时的为1，小于等于的为-1，做一个prefixSum
2. 然后就针对prefixSum做单调栈算法

### 代码

```cpp
class Solution {
public:
    int longestWPI(vector<int>& hours) {

		int res = 0;
        int n = hours.size();
		vector<int> prefixSum;
        prefixSum.resize(n + 1, 0);
		//prefixSum[0] = 0;
		for (int i = 1; i < prefixSum.size(); ++i) {
            if (hours[i - 1] > 8)
			    prefixSum[i] = prefixSum[i - 1] + 1;
            else
                prefixSum[i] = prefixSum[i - 1] - 1;
		}
		stack<int> s;
		s.push(0);
		for (int i = 1; i < prefixSum.size(); ++i) {
			if (prefixSum[s.top()] > prefixSum[i]) {
				s.push(i);
			}
		}

		for (int i = prefixSum.size() - 1; i >= 0; --i) {
			while (!s.empty() && prefixSum[i] > prefixSum[s.top()]) {
				res = max(res, i - s.top());
				s.pop();
			}
			if (s.empty())
				break;
		}
		return res;
    }
};
```