public class Node {

    private Node pre; // предыдущий узел

    private Node next; // следующий узел

    private int data; // данные

    public Node(int data) {
        this.data = data;
    }

    public void append(Node node) {
        if (this.next == null) {
            this.next = node;
            node.pre = this;
        } else {
            this.next.append(node);
        }
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean hasPre() {
        return this.pre != null;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public int getData() {
        return data;
    }

}
