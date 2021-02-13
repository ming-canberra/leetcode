package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class MiddleOfTheLinkedList876 {
    public static void main(String[] args) {
        MiddleOfTheLinkedList876 thisClass = new MiddleOfTheLinkedList876();
        ListNode a = thisClass.middleNode(null);
            System.out.println(a);
    }
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int counter = 1;
        while (current.next != null){
            counter++;
            current = current.next;
        }
        int middleIndex = counter / 2 + 1;
        counter = 1;
        current = head;
        while (current.next != null && counter != middleIndex){
            counter++;
            current = current.next;
        }
        return current;
    }
}