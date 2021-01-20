package blind.curated75;

public class RemoveNthNodeFromEndofList {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    var lo = head;
    var hi = head;

    while (n-- > 0) {
      hi = hi.next;
    }

    if (hi == null) {
      return head.next;
    }

    while (hi.next != null) {
      lo = lo.next;
      hi = hi.next;
    }

    lo.next = lo.next.next;
    return head;
  }

  public static void main(String[] args) {
    // The number of nodes in the list is sz.
    // 1 <= sz <= 30
    // 0 <= Node.val <= 100
    // 1 <= n <= sz

    var head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    var head2 = new ListNode(1);
    var head3 = new ListNode(1, new ListNode(2));
    int[] ns = {2, 1, 1};
    ListNode[] heads = {head1, head2, head3};

    for (int i = 0; i < heads.length; i++) {
      System.out.println(removeNthFromEnd(heads[i], ns[i]));
    }
    // [1,2,3,5]
    // []
    // [1]
  }
}
