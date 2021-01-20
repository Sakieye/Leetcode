package blind.curated75;

public class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    if (next == null) {
      return String.format("%s", val);
    } else {
      return String.format("%s, %s", val, next);
    }
  }
}
