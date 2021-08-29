### 解题思路
一道简单的优先级队列问题：
    原以为使用双重循环会超时，结果使用后没有超时!
    思路简单，就是维护一个大小为K的大顶堆，最后大顶堆里面内容就是要返回的结果。
### 代码

```cpp
class Solution{
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k){
        //优先级队列
        priority_queue<pair<int,vector<int>>>qpp;
        vector<vector<int>>res;
        for(int i=0;i<nums1.size();i++){
            for(int j=0;j<nums2.size();j++){
                if(qpp.size()<k){
                    qpp.push({nums1[i]+nums2[j],{nums1[i],nums2[j]}});
                }
                else{
                    if(qpp.top().first>nums1[i]+nums2[j]){
                        qpp.pop();
                        qpp.push({nums1[i]+nums2[j],{nums1[i],nums2[j]}});
                    }
                }
            }
        }
        //将优先级队列里面的内容转换形式进行输出
        while(!qpp.empty()){
            res.push_back(qpp.top().second);
            qpp.pop();
        }
        //返回结果
        return res;
    }
};
```