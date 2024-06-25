class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class LinkedList
{
    Node head;

    public void insert(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display()
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void delete(int data)
    {
        if (head == null)
        {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        if (head.data == data)
        {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.data != data)
        {
            previous = current;
            current = current.next;
        }

        if (current == null)
        {
            System.out.println("Value not found in the list.");
        } else
        {
            previous.next = current.next;
        }
    }

    public boolean search(int data)
    {
        Node current = head;
        while (current != null)
        {
            if (current.data == data)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Linked List:");
        list.display();

        System.out.println("\nSearching for 20 in the list:");
        System.out.println(list.search(20) ? "Found" : "Not Found");

        System.out.println("\nDeleting 20 from the list:");
        list.delete(20);
        list.display();

        System.out.println("\nSearching for 20 in the list:");
        System.out.println(list.search(20) ? "Found" : "Not Found");
    }
}
