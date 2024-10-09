package src.com.huahua.LeetCode;

public class LCR25 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(Solution.addTwoNumbers(l1, l2));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l1head = reverseList(l1);
            ListNode l2head = reverseList(l2);
            ListNode head = new ListNode();
            ListNode p1 = l1head;
            ListNode p2 = l2head;
            int CF = 0;
            while (p1 != null && p2 != null) {
                int a = p1 == null ? 0 : p1.val;
                int b = p2 == null ? 0 : p2.val;
                int n = (CF + a + b) % 10;
                CF = (CF + a + b) / 10;
                ListNode temp = new ListNode(n, head);
                head = temp;

                p1 = p1.next;
                p2 = p2.next;
            }
            if (CF != 0) {
                ListNode temp = new ListNode(CF, head);
                head = temp;
            }
            return head;
        }

        private static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
}
