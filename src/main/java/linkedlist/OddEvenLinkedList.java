package linkedlist;

import base.ListNode;

public class OddEvenLinkedList {

    /**
     *  奇偶节点重排交换 时间复杂度应为 O(节点总数)
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        //首先要找到 尾节点 的位置
        ListNode tail = head;
        int sum = 1;
        while(tail.next != null){
            tail = tail.next;
            sum++;
        }
        //记录节点的起始位置
        ListNode result = head;
        int index = 1;
        while(index < sum){
            if(index % 2 == 1){
                //下一个节点为偶数节点,需要断开，并连接到最后的节点
                ListNode odd = head.next;
                if(odd.next != null){
                    head.next = odd.next;
                    odd.next = null;
                    tail.next = odd;
                    tail = odd;
                }
                index+=2;
            } else {
                index++;
            }
            head = head.next;
        }
        return result;
    }

    public static void main(String[] arg){
        ListNode node = new ListNode(0);
        ListNode node1 = node;
        for(int i = 1; i < 1; i++){
            ListNode n = new ListNode(i);
            node1.next = n;
            node1 = node1.next;

        }


        ListNode result = oddEvenList(node);
        while(result != null){
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
