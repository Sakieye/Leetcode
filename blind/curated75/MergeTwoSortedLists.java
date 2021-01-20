package blind.curated75;

public class MergeTwoSortedLists {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // 若l1為null，則跟l2互換
    if (l1 == null || (l2 != null && l1.val > l2.val)) {
      var temp = l1;
      l1 = l2;
      l2 = temp;
    }

    // 若l1不為null，則繼續遞迴call並遞移l1
    if (l1 != null) {
      l1.next = mergeTwoLists(l1.next, l2);
    }

    // 若l1為null，即和l2互換後仍是null，則走到終點return
    return l1;
  }

  public static void main(String[] args) {
    System.out.println(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
        new ListNode(1, new ListNode(3, new ListNode(4)))));
    System.out.println(mergeTwoLists(new ListNode(), new ListNode()));
    System.out.println(mergeTwoLists(new ListNode(), new ListNode(0)));
    System.out.println(mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
        new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(99))))));
  }
}
