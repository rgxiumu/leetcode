
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

package leetcode.editor.cn;

public class P24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution24 solution = new P24SwapNodesInPairs().new Solution24();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        solution.swapPairs(l1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution24 {
        public ListNode swapPairs(ListNode head) {
            if (null == head || head.next == null) {
                return head;
            }
            ListNode sec = head.next;
            head.next = swapPairs(sec.next);
            sec.next = head;

            return sec;
        }


        public ListNode swapPairs2(ListNode head) {
            if (null == head || head.next == null) {
                return head;
            }

            ListNode prev = new ListNode(-1);
            ListNode result = prev;
            while (null != head && null != head.next) {
                ListNode fir = head;
                ListNode sec = head.next;

                fir.next = sec.next;
                sec.next = fir;
                prev.next = sec;
                prev = fir;
                head = fir.next;

            }

            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

