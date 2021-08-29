# 方法(贪心算法)
容易想到的一种贪心策略为：先安排出现次数最多的任务，让这个任务两次执行的时间间隔正好为n。再在这个时间间隔内填充其他的任务。

例如：tasks = ["A","A","A","B","B","B"], n = 2

我们先安排出现次数最多的任务"A",并且让两次执行"A"的时间间隔为2。在这个时间间隔内，我们用其他任务类型去填充，又因为其他任务类型只有"B"一个，不够填充2的时间间隔，因此额外需要一个冷却时间间隔。具体安排如下图所示：

![621.png](https://pic.leetcode-cn.com/1607137838-cisnuO-621.png)


其中，maxTimes为出现次数最多的那个任务出现的次数。maxCount为一共有多少个任务和出现最多的那个任务出现次数一样。

图中一共占用的方格即为完成所有任务需要的时间，即：  
*(maxTimes - 1)*(n + 1) + maxCount*

此外，如果任务种类很多，在安排时无需冷却时间，只需要在一个任务的两次出现间填充其他任务，然后从左到右从上到下依次执行即可，由于每一个任务占用一个时间单位，我们又正正好好地使用了tasks中的所有任务，而且我们只使用tasks中的任务来占用方格（没用冷却时间）。因此这种情况下，所需要的时间即为tasks的长度。

由于这种情况时再用上述公式计算会得到一个不正确且偏小的结果，因此，我们只需把公式计算的结果和tasks的长度取最大即为最终结果。
# 代码
```java
public int leastInterval(char[] tasks, int n) {
    int[] buckets = new int[26];
    for(int i = 0; i < tasks.length; i++){
        buckets[tasks[i] - 'A']++;
    }
    Arrays.sort(buckets);
    int maxTimes = buckets[25];
    int maxCount = 1;
    for(int i = 25; i >= 1; i--){
        if(buckets[i] == buckets[i - 1])
            maxCount++;
        else
            break;
    }
    int res = (maxTimes - 1) * (n + 1) + maxCount;
    return Math.max(res, tasks.length);
}
```

若您觉得本题解对您有所帮助，欢迎关注[我的github仓库](https://github.com/wyh317/Leetcode)访问更多leetcode题解，期待和大家一起交流讨论！