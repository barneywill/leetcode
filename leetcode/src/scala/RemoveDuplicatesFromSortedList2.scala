object RemoveDuplicatesFromSortedList2 {
  def main(args: Array[String]): Unit = {
    val root = new ListNode(1, new ListNode(1, new ListNode(2)))
    deleteDuplicates(root).print()
  }
  def deleteDuplicates(head: ListNode): ListNode = {
    var tmp = head
    while (tmp != null) {
      if (tmp.next != null && tmp.x == tmp.next.x) tmp.next = tmp.next.next
      else tmp = tmp.next
    }
    head
  }
}
