package medium;

import easy.ListNode;

import java.math.BigInteger;
import java.util.Stack;

public class AddTwoNumbersII445 {
    public static void main(String[] args) {
        AddTwoNumbersII445 thisClass = new AddTwoNumbersII445();
        ListNode node7 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node4= new ListNode(4);
        ListNode node3= new ListNode(3);
        node7.next = node2;
        node2.next = node4;
        node4.next = node3;

        ListNode snode5 = new ListNode (5);
        ListNode snode6 = new ListNode (6);
        ListNode snode4 = new ListNode (4);
        snode5.next = snode6;
        snode6.next = snode4;

        System.out.println (thisClass.addTwoNumbers(node7, snode5));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while (l1 != null){
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.add(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode last = null;
        while (!s1.isEmpty()||!s2.isEmpty()||carry == 1 ){
            Integer int1 = 0;
            if (!s1.isEmpty()){
                int1 = s1.pop();
            }
            Integer int2 = 0;
            if (!s2.isEmpty()){
                int2 = s2.pop();
            }
            ListNode temp = new ListNode((carry + int1 + int2) % 10);
            temp.next = last;
            last = temp;

            if (carry + int1 + int2 >9){
                carry = 1;
            }
            else{
                carry = 0;
            }

        }

        return last;
    }
}