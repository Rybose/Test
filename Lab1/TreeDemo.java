//Noah Riber
//CS 380
//Lab Assignment 1

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
        if (root == null)
            return;

        // print data of the node
        System.out.print(root.value + ", ");

        // recursion on the left subtree
        preOrderTraversal(root.left);

        // recursion on the right subtree
        preOrderTraversal(root.right);
    }


    /**
     *in-order traversal
     * Prints the value of every node inOrder
     * @param root node of binary tree
    */
    public void inOrderTraversal(Node root) {
        // if node doesn't exist, break out
        if (root == null)
            return;

        // recursion on the left child
        inOrderTraversal(root.left);

        // print data of node
        System.out.print(root.value + ", ");

        // recursion on right child
        inOrderTraversal(root.right);
    }




    /**
     * post-order traversal
     * Prints the value of every node postOrder
     * @param root node of binary tree
     */
    public void postOrderTraversal(Node root) {
        // if node empty, break from recurse
        if (root == null)
            return;

        // first recurse through left subtree
        postOrderTraversal(root.left);

        // then recurse through right subtree
        postOrderTraversal(root.right);

        // print the node
        System.out.print(root.value + " ");

    }


    /**
     * a method to find the node in the tree with a specific value
     * @param root node of binary tree, value user is looking for
     * @return boolean indicating key is in binary tree
     */
    public boolean find(Node root, int key) {
        // check if tree is empty
        if (root == null) {
            System.out.println("Tree is empty");
        }
        else {
            // if node matches key, return true
            if (root.value == key) {
                return true;
            }
            // search in left tree
            if (root.left != null) {
                find(root.left, key);
            }
            // search in right tree
            if (root.right != null) {
                find(root.right, key);
            }
        }
        // if tree doesn't contain key
        return false;
    }


    /**
     * a method to find the node in the tree with the smallest key
     * @param root node of binary tree
     * @return minimum value in binary tree
    */
    public int getMin(Node root) {
        // if tree is empty returns -1
        if (root == null) {
            return (-1);
        }
        else { //otherwise continue
            // sets current node
            Node current = root;

            // goes down left subtree until reaching null (minimum value)
            while (current.left != null) {
                current = current.left;
            }
            // returning value of minimum node
            return (current.value);
        }
    }


    /**
     * a method to find the node in the tree with the largest key
     * @param root node of binary tree
     * @return int containing value of max node in tree
    */
    public int getMax(Node root) {
        // if tree is empty returns -1
        if (root == null) {
            return (-1);
        } else { //otherwise continue
            // sets current node
            Node current = root;

            // goes down right subtree until reaching null (maximum value)
            while (current.right != null) {
                current = current.right;
            }
            // returning value of maximum node
            return (current.value);
        }
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
