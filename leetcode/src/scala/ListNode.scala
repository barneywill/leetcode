class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
  def print() : Unit = {
    println(x)
    var ite = next
    while (ite != null) {
      println(ite.x)
      ite = ite.next
    }
  }
}
