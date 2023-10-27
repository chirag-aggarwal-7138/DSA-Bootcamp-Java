public class LLMergeSort {
    public static void main(String[] args) {
            
    }

    static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    static ListNode merge(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode newHead = new ListNode();
        ListNode newTemp = newHead;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                newTemp.next = new ListNode(temp1.val);
                newTemp = newTemp.next;
                temp1 = temp1.next;
            } else {
                newTemp.next = new ListNode(temp2.val);
                newTemp = newTemp.next;
                temp2 = temp2.next;
            }
        }

        while (temp1 != null) {
            newTemp.next = new ListNode(temp1.val);
            newTemp = newTemp.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            newTemp.next = new ListNode(temp2.val);
            newTemp = newTemp.next;
            temp2 = temp2.next;
        }

        return newHead.next;
    }

    static ListNode middle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    /**
     * Sorts a linked list using bubble sort algorithm.
     * 
     * @param head the head of the linked list to be sorted
     * @return the head of the sorted linked list
     */
    static ListNode bubbleSort(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return head;
        }

        ListNode i = head;
        ListNode j = i.next;
        while (i.next != null) {
            while (j != null) {
                if (j.val < i.val) {
                    int tmp = i.val;
                    i.val = j.val;
                    j = tmp;
                }
                j = j.next;
            }
            i = i.next;
        }
        return head;
    }
}
