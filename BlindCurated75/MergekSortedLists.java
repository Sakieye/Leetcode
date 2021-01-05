package BlindCurated75;

import java.util.PriorityQueue;

public class MergekSortedLists {
  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    var queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);
    var head = new ListNode(0);
    var cur = head;

    for (ListNode list : lists) {
      if (list != null) {
        queue.add(list);
      }
    }

    while (!queue.isEmpty()) {
      // 將cur(dummy)的next接到poll出來的ListNode
      cur.next = queue.poll();
      // 指標前進
      cur = cur.next;
      // 若前進後的next為null則不放入，因前進之前，dummy的next已經接到最後一個有值的部分了
      if (cur.next != null) {
        queue.add(cur.next);
      }
    }

    return head.next;
  }

  public static void main(String[] args) {
    //  k == lists.length
    //  0 <= k <= 10^4
    //  0 <= lists[i].length <= 500
    //  -10^4 <= lists[i][j] <= 10^4
    //  lists[i] is sorted in ascending order.
    //  The sum of lists[i].length won't exceed 10^4.
    ListNode[] lists1 = {
      new ListNode(1, new ListNode(4, new ListNode(5))),
      new ListNode(1, new ListNode(3, new ListNode(4))),
      new ListNode(2, new ListNode(6))
    };
    ListNode[] lists2 = {};
    ListNode[] lists3 = {new ListNode()};
    ListNode[][] listArray = {lists1, lists2, lists3};
    for (ListNode[] lists : listArray) {
      System.out.println(mergeKLists(lists));
    }
  }
}
