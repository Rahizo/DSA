/*
Explanation
Functionality:The function isSublist() checks if a linked list (subList) exists as a continuous sequence in another linked list (mainList).
It iterates through mainList and tries to match subList node by node.
If all nodes of subList are found sequentially, it returns true.
Otherwise, it continues scanning mainList.

Edge Cases: If subList is empty → Always returns true.
If mainList is empty but subList is not → Returns false.
Handles cases where sublist is found at beginning, middle, or end.
Time Complexity:

Worst-case: O(N * M) where N is the length of mainList and M is the length of subList.

*/
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SublistSearch {
    public static boolean isSublist(Node mainList, Node subList) {
        if (subList == null) return true;  // Empty sublist is always a match
        if (mainList == null) return false; // Non-empty sublist cannot be in an empty list

        Node currentMain = mainList;
        while (currentMain != null) {
            Node tempMain = currentMain;
            Node tempSub = subList;

            // Compare sublist with main list sequence
            while (tempMain != null && tempSub != null && tempMain.data == tempSub.data) {
                tempMain = tempMain.next;
                tempSub = tempSub.next;
            }

            // If we reached the end of sublist, it means match found
            if (tempSub == null) {
                return true;
            }

            currentMain = currentMain.next; // Move to next node in main list
        }
        return false;
    }

    // Helper function to create a linked list from an array
    public static Node createLinkedList(int[] values) {
        if (values.length == 0) return null;
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] mainListArr = {1, 2, 3, 4, 5, 6};
        int[] subListArr1 = {3, 4, 5};  // Present sublist
        int[] subListArr2 = {2, 5, 6};  // Not a sublist
        int[] subListArr3 = {1, 2, 3, 4, 5, 6};  // Exact match

        Node mainList = createLinkedList(mainListArr);
        Node subList1 = createLinkedList(subListArr1);
        Node subList2 = createLinkedList(subListArr2);
        Node subList3 = createLinkedList(subListArr3);

        // Test cases
        System.out.println("Sublist {3,4,5} present? " + isSublist(mainList, subList1)); // Expected: true
        System.out.println("Sublist {2,5,6} present? " + isSublist(mainList, subList2)); // Expected: false
        System.out.println("Sublist {1,2,3,4,5,6} present? " + isSublist(mainList, subList3)); // Expected: true
    }
}
