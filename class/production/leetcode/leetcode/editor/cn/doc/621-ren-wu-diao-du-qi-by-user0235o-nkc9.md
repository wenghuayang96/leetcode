### 解题思路
将任务数组进行分组，每组中不能有重复的任务，每组任务数量>=n+1,以满足冷却时间的要求.
示例1：A A A A A B B B C C  n=2
    A B C
    A B C
    A B -
    A - -
    A
示例2：A A A A B B B B C C  n=2
    A B C
    A B C
    A B -
    A B
示例3：A A A B B B C C C D D  n=2
    A B C D
    A B C D
    A B C 

观察可知，最终的结果与重复次数最高的任务决定。
示例1，因A出现5次，所以分为5组，前四组每组需要3个单位时间，最后一组只要执行完A就可以，因此需要1个单位时间；
示例2：因A,B均出现4次，所以分为4组，前三组每组需要3个单位时间，最后一组只需要把A'B执行完就可以，因此需要两个单位时间；
示例3：重复任务出现的最高次数为3，总任务数量为11，冷却时间为2，因为3<=11/3，所以不需要增加待命状态，完成任务所需的最短时间即为总任务数量。


### 代码

```java
class Solution {
 public int leastInterval(char[] tasks, int n) {
        int result = tasks.length;
        if(n==0){
            return result;
        }
        //记录每个字符出现的次数
        int [] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        int maxTimes = 0;//重复次数最高的字符出现的次数
        int maxCount = 0;//重复次数最高的字符有几个
        for (int i : count) {
            if(i>maxTimes){
                maxTimes=i;
                maxCount =1;
            }
            else if(i==maxTimes){
                maxCount++;
            }
        }
        int group = tasks.length/(n+1);
        if(maxTimes>group){
            result = (maxTimes-1)*(n+1)+maxCount;
            result = Math.max(result, tasks.length);
        }
        return result;
    }

}
```