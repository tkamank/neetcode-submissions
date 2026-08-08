class ListNode {
    int val = -1;
    ListNode next = null;

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        this.head = new ListNode(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        ListNode curr = this.head.next;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.val;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head.next;
        this.head.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new ListNode(val);
        this.tail = this.tail.next;

    }

    public boolean remove(int index) {
        ListNode curr = this.head; //Point to ref before desired node
        int i = 0;
        while (i < index && curr != null) {
            i++;
            curr = curr.next;
        }

        //Does the current and next node exist?
        if (curr != null && curr.next != null) {
            if (curr.next == this.tail) {
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ListNode curr = this.head.next;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }
        return arr;
    }
}
