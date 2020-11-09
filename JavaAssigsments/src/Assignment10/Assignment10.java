package Assignment10;

class SingleListNode<E> {
    SingleListNode<E> next;
    E data;

    public SingleListNode(){
        next = null;
        data = null;
    }
}

public class Assignment10<E> {
    private SingleListNode<E> head;
    private SingleListNode<E> currentNode;

    Assignment10() {
        head = new SingleListNode<E>();
    }

    public boolean addData(E theData) {
        SingleListNode<E> newNode = new SingleListNode<E>();

        if(head.next == null) {
            head.next = newNode;
            newNode.data = theData;
            newNode.next = null;
            currentNode = newNode;
            return true;
        }
        currentNode.next = newNode;
        newNode.data = theData;
        newNode.next = null;
        currentNode = newNode;
        return true;
    }

    public void traverse(){
        SingleListNode<E> movingNode;

        if (head.next == null) {
            System.out.println(" List is Empty");
            return;
        }

        movingNode = head.next;

        while(movingNode != null) {
            System.out.println(movingNode.data);
            movingNode = movingNode.next;
        }
    }

    public int getSize(){
        int i = 0;
        SingleListNode<E> movingNode;

        if(head.next == null)
            return i;

        movingNode = head.next;

        while(movingNode != null) {
            movingNode = movingNode.next;
            i++;
        }
        return i;
    }

    public E validator(int index){
        int i = 0;

        if(index < 0 || index >= getSize())
            throw new IndexOutOfBoundsException();

        if(head.next == null)
            return null;

        return (E) "Valid";
    }

    public E get(int index) {
        int i = 0;
        SingleListNode<E> movingNode;

        E isValid = validator(index);

        if(isValid.equals("Valid") != true) return null;

        movingNode = head.next;

        while(movingNode != null){
            if(i == index - 1) return movingNode.data;
            movingNode = movingNode.next;
            i++;
        }

        return null;
    }

    public E remove(int index){
        int i = 0;
        SingleListNode<E> movingNode;

        E isValid = validator(index);

        if(isValid.equals("Valid") != true) return null;

        movingNode = head.next;

        while(movingNode != null){
            if(i == index - 2) {
                movingNode.next = movingNode.next.next;
                return null;
            }
            movingNode = movingNode.next;
            i++;
        }

        return null;
    }

    public E set(int index, E element){
        int i = 0;
        SingleListNode<E> movingNode;

        E isValid = validator(index);

        if(isValid.equals("Valid") != true) return null;
        if(element == null) throw new NullPointerException();

        movingNode = head.next;

        while(movingNode != null){
            if(i == index - 1) {
                movingNode.data = element;
                return null;
            }
            movingNode = movingNode.next;
            i++;
        }

        return null;
    }

    public void add(int index, E element) {
        int i = 0;
        SingleListNode<E> movingNode;

        E isValid = validator(index);

        if(isValid.equals("Valid") != true) return;
        if(element == null) throw new NullPointerException();

        movingNode = head.next;

        while(movingNode != null){
            if(i == index - 1) {
                SingleListNode<E> newNode = new SingleListNode<E>();
                newNode.data = element;
                newNode.next = movingNode.next;
                movingNode.next = newNode;
                return;

            }
            movingNode = movingNode.next;
            i++;
        }
    }

    public static void main(String[] args){
        Assignment10 myLL = new Assignment10();
        myLL.addData("Happy");
        myLL.addData("Puppy");
        myLL.addData("Tintu");
        myLL.addData("Mintu");
        myLL.addData("Boom");
        myLL.addData("Boom Boom");

        myLL.traverse();

        System.out.println("\nSize : " + myLL.getSize());
        System.out.println("\nGet indexOf 3 : " + myLL.get(3) + "\n");

        myLL.add(3, "Uday");
        myLL.traverse();
    }
}
