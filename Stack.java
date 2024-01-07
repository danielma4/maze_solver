public class Stack
{
    Node top;

    public void push(int p) {
        Node n = new Node(p);
        n.next = top;
        top = n;
    }

    public Integer peek() {
        if (top == null) return null;
        return top.value;
    }

    public Integer pop() {
        if (top == null) return null;
        Node oldtop = top;
        top = top.next;
        oldtop.next = null;
        return oldtop.value;
    }

    public class Node
    {
        int value;
        Node next;

        public Node(int x) {
            value = x;
        }
    }
}