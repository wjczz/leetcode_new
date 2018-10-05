package game;

public class CanWinNim {

    public static void main(String[] args){
        //博弈论
        //你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。
        //拿掉最后一块石头的人就是获胜者。你作为先手。
        System.out.println(canWinNim(8));
    }

    public static boolean canWinNim(int n) {
        //只要保证最后剩下4个，然后由对手先拿，就能保证我们先赢
        if( n % 4 == 0) return false;
        return true;
    }
}
