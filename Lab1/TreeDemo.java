class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

}

class BinarySearchTree {

    Node root;


    /*
    recursive insert method

    */
	   /*
	   inserts a node into the tree
	   */
    public void insert(int value) {
        //tree is empty
        if (root == null) {
            root = new Node(value);
            return;
        } else {
            Node current = root;
            Node parent = null;

            while (true) {
                parent = current;

                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new Node(value);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(value);
                        return;
                    }
                }

            }//closing while

        }//closing main if-else
    }

    /**
     * pre-order traversal
     * Prints the value of every node preorder
     * @param root node of binary tree
     */
    public void preOrderTraversal(Node root) {
        // if node is empty, break from current recurse
        if (node == null)
            return;

        // print data of the node
        System.out.print(node.key + ", ");

        // recursion on the left subtree
        preOrderTraversal(node.left);

        // recursion on the right subtree
        preOrderTraversal(node.right);
    }


    /**
     *in-order traversal
     * Prints the value of every node inOrder
     * @param root node of binary tree
    */
    public void inOrderTraversal(Node root) {
        // if node doesn't exist, break out
        if (node == null)
            return;

        // recursion on the left child
        inOrderTraversal(node.left);

        // print data of node
        System.out.print(node.value + ", ");

        // recursion on right child
        inOrderTraversal(node.right);
    }



	   /*
	   post-order traversal
	   */

    public void postOrderTraversal(Node root) {
        //implement in here

    }


    /*
    a method to find the node in the tree
    with a specific value
    */
    public boolean find(Node root, int key) {
        //implement in here
        return false;
    }


    /*
    a method to find the node in the tree
    with a smallest key
    */
    public int getMin(Node root) {
        //implement in here
        return 0;
    }


    /*
    a method to find the node in the tree
    with a largest key
    */
    public int getMax(Node root) {
        //implement in here
        return 0;
    }


    /*
    this method will not compile until getMax
    is implemented
    */
    public Node delete(Node root, int key) {

        if (root == null) {
            return root;
        } else if (key < root.value) {
            root.left = delete(root.left, key);
        } else if (key > root.value) {
            root.right = delete(root.right, key);
        } else {
            //node has been found
            if (root.left == null && root.right == null) {
                //case #1: leaf node
                root = null;
            } else if (root.right == null) {
                //case #2 : only left child
                root = root.left;
            } else if (root.left == null) {
                //case #2 : only right child
                root = root.right;
            } else {
                //case #3 : 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }


}


public class TreeDemo {
    public static void main(String[] args) {
        BinarySearchTree t1 = new BinarySearchTree();
        t1.insert(24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);

        System.out.print("in-order :   ");
        t1.inOrderTraversal(t1.root);
        System.out.println();


    }
}
