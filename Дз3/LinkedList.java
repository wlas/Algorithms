public class LinkedList {

    Node head;
    Node tail;

    public void AddFirst(Node node) {
        if (head.getNext() == null) {
            head.setNext(node);
            node.setPre(head);
        } else {
            head.getNext().append(node);
        }
    }

    public String toString() {
        Node curr = head;
        StringBuilder sBuilder = new StringBuilder();
        while (curr != null) {
            sBuilder.append(curr.getData()).append(curr.hasNext() ? "->" : "");
            curr = curr.getNext();
        }
        return sBuilder.toString();
    }

    /**
     * Сверху вниз
     */
    public String reverse() {
        Node curr = head;
        Node newHead = null;
        Node newLast = null;
        while (curr != null) {
            Node pre = curr.getPre();
            Node next = curr.getNext();
            if (pre == null)
                newLast = curr; // Предыдущий узел пуст, как новый хвостовой узел
            if (next == null)
                newHead = curr; // Следующий узел пуст, как новый головной узел
            curr.setNext(pre); // Следующий узел текущего узла используется как предыдущий узел текущего узла
            curr.setPre(next); // Предыдущий узел текущего узла является следующим узлом текущего узла
            curr = curr.getPre(); // Продолжаем обработку следующего узла исходного узла связанного списка
        }
        head = newHead; // Устанавливаем головной узел
        tail = newLast; // Устанавливаем конечный узел
        return this.toString();
    }
}
