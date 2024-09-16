/*
Time Complexity: O(N), N is the number of nodes in the given tree
Space Complexity: O(H), H is the height of the tree
Run on leetcode: Yes
Any difficulties: no

Approach: **Well Commented Code**
 */
public class BSTToDoublyCircularyLinkedList {
    public Node nextNode;
    public Node prevNode;

    public Node treeToDoublyList(Node root){
        if(root == null){
            return null;
        }

        this.nextNode = null;
        this.prevNode = null;

        inorderRecursion(root);

        nextNode.right = prevNode;
        prevNode.left = nextNode;

        return prevNode;
    }

    public void inorderRecursion(Node root){
        if(root == null){
            return;
        }
        // Left tree recursion
        inorderRecursion(root.left);

        // Processing root
            /*
            When we are trying to append the linked list, have to check first if
            dummyNext which is the next pointer should not be null, if that is not null
            then we can assign right of that to the root (means appending next node to
            in the right) and at the same time have to link root.left to the dummyNext
            in order to link it to the left,

            else when dummyNext is null, in that case we are supposed
            to assign dummyPrev to the root

            Now, in order to process root we should always assign our dummyNext to the
            root considering that as the next appending root
        */
        if(nextNode!= null){
            nextNode.right = root;
            root.left = nextNode;
        }else{
            prevNode = root;
        }

        nextNode = root;

        // Right tree recursion

        inorderRecursion(root.right);
    }

    public static void main(String[] args){
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println("Doubly linked list: ");

        BSTToDoublyCircularyLinkedList obj = new BSTToDoublyCircularyLinkedList();

        obj.treeToDoublyList(root);
            System.out.print(root.val+" \t");

    };
}
