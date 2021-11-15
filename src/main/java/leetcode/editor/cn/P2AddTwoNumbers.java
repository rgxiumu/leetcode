
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package leetcode.editor.cn;
public class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode te = new ListNode(0);
       ListNode re = new ListNode(0);
       te.next = re;
       int temp = 0;
       while (l1 != null || l2 != null || temp > 0) {
           int num1 = l1 != null ? l1.val : 0;
           int num2 = l2 != null ? l2.val : 0;

           int sum = num1 + num2 + temp;
           temp = 0;
           int val = sum;
           if (sum > 9) {
               val = sum % 10;
               temp = 1;
           }
           re.next = new ListNode(val);
           re = re.next;
           l1 = l1 != null ? l1.next : null;
           l2 = l2 != null ? l2.next : null;
       }
       return te.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

