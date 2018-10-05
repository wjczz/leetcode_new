package linkedlist;

import base.ListNode;

import java.util.Stack;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        getStack(l1, s1);
        getStack(l2, s2);
        ListNode head = null;
        int bit = 0;
        while(!s1.empty() && !s2.empty()){
            int i = s1.pop();
            int j = s2.pop();
            int mid = i + j + bit;
            bit = mid / 10;
            mid %= 10;
            ListNode n = new ListNode(mid);
            if(head == null){
                head = n;
            } else {
                n.next = head;
                head = n;
            }
        }
        if(s1.isEmpty() && s2.isEmpty() && bit != 0){
            ListNode node = new ListNode(bit);
            node.next = head;
            head = node;
        }
        if(!s1.isEmpty()){
            head = getResult(head, s1, bit);
        }
        if(!s2.isEmpty()){
            head = getResult(head, s2, bit);
        }
        return head;
    }

    public static void getStack(ListNode node, Stack<Integer> stack){
        while(node != null){
            stack.add(node.val);
            node = node.next;
        }
    }

    public static ListNode getResult(ListNode head, Stack<Integer> stack, int bit){
        while(!stack.isEmpty()){
            int val = stack.pop();
            val += bit;
            bit = val / 10;
            ListNode node = new ListNode(val%10);
            node.next = head;
            head = node;
        }
        if(bit != 0){
            ListNode node = new ListNode(bit);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static void main(String[] arg){
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        // 7->2->4->3

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
        node5.next = node6;
        node6.next = node7;
        //5->6->4

        ListNode result = addTwoNumbers(node1, node5);
        while(result != null){
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
}
