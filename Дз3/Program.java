/**
 * Необходимо реализовать метод разворота связного списка (двухсвязного или
 * односвязного на выбор).
 */
public class Program {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("Создать двусвязный список длиной 10");

        for (int i = 0; i < 10; i++) {
            int r = (int) (Math.random() * 100);
            Node node = new Node(r);
            if (i == 0) {
                list.head = node; // головной узел
            } else {
                list.head.append(node);
            }
            list.tail = node; // хвостовой узел
        }

        // Траверс
        System.out.println(list.toString());

        // инвертированный
        System.out.println(list.reverse());

    }

}