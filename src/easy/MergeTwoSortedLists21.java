package easy;

  public class MergeTwoSortedLists21 {
      public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          if (l1==null && l2==null){
              return null;
          }
          else if (l1 == null){
              return l2;
          }
          else if (l2 == null){
              return l1;
          }
          else{
                if (l1.val <= l2.val){
                    return mergeAndReturnFirstAndSmaller(l1, l2);
                }
                else
                    return mergeAndReturnFirstAndSmaller(l2, l1);
          }
      }

      private ListNode mergeAndReturnFirstAndSmaller(ListNode l1, ListNode l2){

          ListNode l1Current = l1;
          ListNode l1CurrentNext;
          ListNode l2Current = l2;

          while(l1Current.next != null && l2Current != null){
              l1CurrentNext = l1Current.next;
              if (l1CurrentNext.val <= l2Current.val){
                  l1Current = l1CurrentNext;
              }
              else{
                  ListNode tempL2CurrentNext = l2Current.next;
                  l1Current.next = l2Current;
                  l2Current.next = l1CurrentNext;
                  l1Current = l2Current;
                  l2Current = tempL2CurrentNext;
              }
          }
          if(l2Current != null && l1Current.next == null){
              l1Current.next = l2Current;
          }

          return l1;
      }
  }
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null || l2 != null){
            if (l1 == null){
                cur.next = l2;
                break;
            }
            if (l2 == null){
                cur.next = l1;
                break;
            }
            if (l1.val < l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        return head.next;
    }
}

class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }
        else{
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }

        return head;
    }
}
