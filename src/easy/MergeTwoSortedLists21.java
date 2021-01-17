package easy;

  public class MergeTwoSortedLists21 {
      public static void main(String[] args) {
          MergeTwoSortedLists21 thisClass = new MergeTwoSortedLists21();

            ListNode input1 = new ListNode(2);
            /*{
                ListNode node2 = new ListNode(2);
                ListNode node4 = new ListNode(4);
                input1.next = node2;
                node2.next = node4;
            }*/
          ListNode input2 = new ListNode(1);
          /*{
              ListNode node3 = new ListNode(3);
              ListNode node4 = new ListNode(4);
              input2.next = node3;
              node3.next = node4;
          }*/

          System.out.println(
                  thisClass.mergeTwoLists(input1, input2)
          );
      }
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
