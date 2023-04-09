package testLinkedLists;

public class SinglyLinkedList<E> {
     static class Node<E>  {

         public Node(E value, Node<E> next) {
             this.value = value;
             this.next = next;
         }

        final E value;
        Node<E> next;
    }

    Node<E> first;
    Node<E> last;
    int size;

    public static void main(String[] args) {
        final SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.print();
        list.remove(0);
        list.addLast("1");
        list.print();
        list.remove(1);
        list.print();
    }

    private void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (size == 1) {
            first = null;
            last = null;
            size--;
            return;
        }

        if (index == 0) {
            this.first = this.first.next;
            return;
        }

        //size > 1
        Node<E> prev = this.first;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;

        //last
        if (prev.next == null) {
            last = prev;
        }
    }

    private void print() {
        Node<E> cur = this.first;
        while (cur != null) {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        System.out.println();
    }

    private void addLast(E value) {
        final Node<E> node = new Node<>(value, null);
        if (size == 0) {
            size++;
            first = node;
            last = node;
            return;
        }
        size++;
        last.next = node;
        last = node;

    }


}
