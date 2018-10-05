package linkedlist;

import base.ListNode;

import java.util.Arrays;

public class SplitLinkedListinParts {

    /**
     * 把一个链表平均分成k份。 允许任意2个部分的结点数相差不大于1。
     * @param root
     * @param k
     * @return
     */
    public static ListNode[] splitListToParts(ListNode root, int k) {
        //1.求出平均每份需要的结点数是多少
        //2.再操作root进行划分
        int size = getSize(root);
        int[] kszie = new int[k];
        int avg = size / k;
        Arrays.fill(kszie, avg);
        size %= k;
        for(int i = 0; i < k && size > 0; i++){
            kszie[i]++;
            size--;
        }

        ListNode[] result = new ListNode[k];
        int index = 0;
        for(int i = 0; i < k; i++){
            ListNode node = root;
            ListNode head = root;
            for(int j = 1; j < kszie[i] && node != null; j++){
                node = node.next;
            }
            if(node != null){
                root = node.next;
                node.next = null;
            }
            result[index++] = head;
        }
        return result;
    }

    public static int getSize(ListNode node){
        int size = 0;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }


    public static void main(String[] arg){
        ListNode node = new ListNode(0);
        ListNode node1 = node;
        for(int i = 1; i < 3; i++){
            ListNode n = new ListNode(i);
            node1.next = n;
            node1 = node1.next;

        }
        ListNode[] result = splitListToParts(node, 5);
        for(ListNode l:result){
            if(l == null){
                System.out.print("null");
            } else {
                while(l != null) {
                    System.out.print(l.val + "->");
                    l = l.next;
                }
            }
            System.out.println();
        }
    }
}
