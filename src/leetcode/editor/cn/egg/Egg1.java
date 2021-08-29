package leetcode.editor.cn.egg;

/**
 * 10万以内快乐数总和
 */
public class Egg1 {

    public static void main(String[] args) {
        System.out.println(new Egg1().solution());

    }

    public int solution() {
        int n = 100000;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            if (isHappy(i)) {
                res += i;
            }
        }
        return res;
    }

    public boolean isHappy(int n) {
        // Write your code here
        if(n==1){
            return true;
        }
        if(n<1){
            return false;
        }
        int count=0;
        while(n!=1){
            String s=n+"";
            char []arr=s.toCharArray();
            int sum=0;
            for(int i=0;i<arr.length;i++){
                sum+=Integer.parseInt(arr[i]+"")*Integer.parseInt(arr[i]+"");
            }
            n=sum;
            count++;
            if(count>1000){
                return false;
            }
        }
        return true;
    }

}
