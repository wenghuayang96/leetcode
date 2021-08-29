```C++ []
class Solution {
public:
    bool buddyStrings(string a, string b) {
        //pos1 2 分别记录两次不同得位置下标 cnt数组存储每个字母出现的次数
        int pos1 = -1, pos2 = -1, cnt[26] = {0};
        //op用来判断是否有字符出现了两次及以上
        bool op = false;
        //长度不等返回false
        if(a.length() != b.length())
            return false;

        for(int i = 0; i < a.length(); i ++){
            //次数+1
            ++ cnt[a[i] - 'a'];
            //次数 >=2
            if(!op && cnt[a[i] - 'a'] >= 2)
                op = true;
            //相同直接continue
            if(a[i] == b[i])
                continue;
            
            if(pos1 == -1){ //遇到第一个不同的位置
                pos1 = i;
            }else if(pos2 == -1){   //遇到第二个不同位置
                //判断交换是否相等
                if(a[pos1] != b[i] || b[pos1] != a[i])
                    return false;
                //记录第二次位置
                pos2 = i;
            }else
                return false;
        }
        //true ：要么交换了两次字符串相等 要么原本字符串就相同但是有字母出现了两次，可以交换这两个相同的字母位置
        return (pos1 != -1 && pos2 != -1) || (op && pos1 == -1 && pos2 == -1);
    }
};
```