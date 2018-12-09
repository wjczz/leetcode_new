package game;


public class BulbSwitcher {

    public static void main(String[] args){
        //初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。
        //第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。
        //对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。

        /**
         * 总结:
         * 素数肯定为关的状态
         * 非质数的话，如果其数的因子是奇数，则为开，偶数为关。
         * 而只有平方数的总因子数为奇数个
         */
        System.out.println(bulbSwitch(9999999));
    }

    public static int bulbSwitch(int n){

        return (int) Math.sqrt(n);
//        int[] status = new int[n + 1];
//        System.out.println(System.currentTimeMillis());
//
//
//        //0: 为关闭状态  1：为打开状态
//        Arrays.fill(status, 0);
//        for(int i = 1; i <= n; i++){
//            if(i == 1){
//                Arrays.fill(status, 1);
//            }
//            else {
//                //最简单的做法，比较蠢
//                for(int j = i; j <= n; j+=i){
//                    if(status[j] == 1){
//                        status[j] = 0;
//                    } else {
//                        status[j] = 1;
//                    }
//                }
//
//            }
//        }
//        System.out.println(System.currentTimeMillis());
//        int sum = 0;
//        for(int i = 1; i <= n; i++){
//            if(status[i] == 1){
//                sum++;
//            }
//        }
//        return sum;
    }

}
