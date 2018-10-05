package linkedlist;

import base.ListNode;

import java.util.Arrays;


public class LinkedListComponents {

    /**
     * 求G 数组能够把链表分成几块。 按链表数据连续性来划分
     * @param head
     * @param G
     * @return
     */
    public static int numComponents(ListNode head, int[] G) {
        Arrays.sort(G);
        //0 表示没有用过，1 表示已经用过
        int[] flag = new int[G.length];
        Arrays.fill(flag, 0);
        //先判断head结点 在 G中是否存在，存在的话，flag打标记,并判断是否有连续模块。
        //如果有，则继续循环。如果没有，则重新找。
        int result = 0;
        while(head != null){
            int val = head.val;
            boolean hasComponent = false;
            while(containInt(G, flag, val)){
                //看下一个结点是否连续
                hasComponent = true;
                head = head.next;
                if(head == null){
                    break;
                }
                val = head.val;
            }
            if(hasComponent){
                result++;
            }
            if(head != null){
                head = head.next;
            }
        }
        return result;
    }

    /**
     * 全局遍历 && 二分法
     * @param array
     * @param flag
     * @param target
     * @return
     */
    public static boolean containInt(int[] array, int[] flag, int target){
//        for(int i = 0, imax = array.length; i < imax; i++){
//            if(array[i] == target && flag[i] == 0){
//                flag[i] = 1;
//                return true;
//            }
//        }
        //---------以下为 二分查找法
        int start = 0;
        int end = array.length -1;
        while(start <= end){
            int mid = (end - start) / 2 + start;
            if(array[mid] > target){
                end = mid-1;
            } else if(array[mid] < target){
                start = mid+1;
            } else if(flag[mid] == 0){
                flag[mid] = 1;
                return true;
            }
        }


        return false;
    }


    public static void main(String[] arg){
        ListNode node = new ListNode(0);
        ListNode node1 = node;
        for(int i = 1; i < 5; i++){
            ListNode n = new ListNode(i);
            node1.next = n;
            node1 = node1.next;

        }

        int[] g = new int[]{0,3,2,4};
        System.out.println(numComponents(node, g));
    }
}
