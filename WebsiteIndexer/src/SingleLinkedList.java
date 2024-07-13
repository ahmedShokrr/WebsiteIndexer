public class SingleLinkedList implements SingleLinkedListInterface {
    public Node head = null;
    public Node tail = null;
    private int size = 0;

    /**
     * no-args constructor
     */
    public SingleLinkedList() {
    }

    /**
     * function to add new node and access its Date in
     * @param data
     */
    public void addNode(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**
     * function to insert at first
     * @param data
     */
    public void insertFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * function to insert at specific index
     * @param data
     * @param index
     */
    public void insert(String data, int index) {
        if (index == 0) {
            insertFirst(data);
        } else {
            Node newNode = new Node(data);
            Node beforeIndex = head;

            for(int i = 0; i < index - 1; ++i) {
                beforeIndex = beforeIndex.next;
            }

            Node afterIndex = beforeIndex.next;
            beforeIndex.next = newNode;
            newNode.next = afterIndex;
            size++;
        }

    }

    /**
     * display function to print all nodes and There data
     */
    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            while(current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }

            System.out.println();
        }
    }

    /**
     * funtion to get the size of List
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * function to return data at specific index
     * @param index
     * @return
     */
    public String get(int index) {
        Node current = head;

        for(int i = 0; i < index; ++i) {
            current = current.next;
        }

        return current.data;
    }
}
