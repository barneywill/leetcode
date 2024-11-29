import scala.util.control.Breaks.{break, breakable}

object MergeTwoSortedLists2 {
  def main(args : Array[String]) : Unit = {
    val list1 = new ListNode(1, new ListNode(2, new ListNode(4)))
    val list2 = new ListNode(1, new ListNode(3, new ListNode(4)))
    mergeTwoLists(list1, list2).print()
  }
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    var result : ListNode = null
    if (list1 == null) result = list2
    else if (list2 == null) result = list1
    else {
      breakable {
        var ite1 = list1
        var ite2 = list2
        var ite = result
        while (ite1 != null || ite2 != null) {
          if (ite1 == null) {ite.next = ite2; break}
          else if (ite2 == null) {ite.next = ite1; break}
          else {
            var current : Int = 0
            if (ite1.x < ite2.x) {
              current = ite1.x
              ite1 = ite1.next
            } else {
              current = ite2.x
              ite2 = ite2.next
            }
            val newNode = new ListNode(current, null)
            if (result == null) {
              result = newNode
              ite = result
            } else {
              ite.next = newNode
              ite = ite.next
            }
          }
        }
      }
    }
    result
  }
}
