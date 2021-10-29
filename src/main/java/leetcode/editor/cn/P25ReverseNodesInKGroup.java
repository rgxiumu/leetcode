
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

package leetcode.editor.cn;
public class P25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        solution.reverseKGroup(l1, 2);
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);

            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }

            head = curr;
        }
        return head;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prev = res;
        ListNode end = res;

        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end.next == null) {
                    return res.next;
                }
                end = end.next;
            }
            ListNode nextStart = end.next;
            ListNode pre = null;
            ListNode first = prev.next;
            ListNode curr = prev.next;
            int i = 0;
            while (i<k) {
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
                i++;
            }

            prev.next = pre;
            first.next = nextStart;
            prev = first;
            end = first;
        }

        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

