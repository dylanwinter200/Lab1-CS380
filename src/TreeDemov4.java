class Node{
    int value;
    Node left, right;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }

}

class BinarySearchTree{

    Node root;


    /*
    recursive insert method

    */
	   /*
	   inserts a node into the tree
	   */
    public void insert(int value){
        //tree is empty
        if(root == null){
            root = new Node(value);
            return;
        }else{
            Node current = root;
            Node parent = null;

            while(true){
                parent = current;

                if(value < current.value){
                    current = current.left;
                    if(current == null){
                        parent.left = new Node(value);
                        return;
                    }
                }else{
                    current = current.right;
                    if(current == null){
                        parent.right = new Node(value);
                        return;
                    }
                }

            }//closing while

        }//closing main if-else
    }

    /**
     * This method performs a pre-order traversal of a binary tree and prints out the value of each node.
     * In pre-order traversal, the nodes are recursively visited in the order: root-left-right.
     *
     * @param root The root node of the binary tree to start the traversal from.
     */
    public void preOrderTraversal(Node root) {
        if (root != null) {
            // Visit the root node (pre-order)
            System.out.print(root.value + " ");

            // Recursively traverse the left subtree
            preOrderTraversal(root.left);

            // Recursively traverse the right subtree
            preOrderTraversal(root.right);
        }
    }



    /**
     * This method performs an in-order traversal of a binary tree and prints out the value of each node.
     * In in-order traversal, the nodes are recursively visited in the order: left-root-right.
     *
     * @param root The root node of the binary tree to start the traversal from.
     */
    public void inOrderTraversal(Node root) {
        if (root != null) {
            // Recursively traverse the left subtree
            inOrderTraversal(root.left);

            // Visit the root node (in-order)
            System.out.print(root.value + " ");

            // Recursively traverse the right subtree
            inOrderTraversal(root.right);
        }
    }


    /**
     * This method performs a post-order traversal of a binary tree and prints out the value of each node.
     * In post-order traversal, the nodes are recursively visited in the order: left-right-root.
     *
     * @param root The root node of the binary tree to start the traversal from.
     */
    public void postOrderTraversal(Node root) {
        if (root != null) {
            // Recursively traverse the left subtree
            postOrderTraversal(root.left);

            // Recursively traverse the right subtree
            postOrderTraversal(root.right);

            // Visit the root node (post-order)
            System.out.print(root.value + " ");
        }
    }



    /**
     * This method searches for a node with a given key in a binary search tree and
     * returns true if the node is found, false otherwise.
     *
     * @param root The root node of the binary search tree to start the search from.
     * @param key  The value to search for.
     * @return     true if a node with the value is found, false otherwise.
     */
    public boolean find(Node root, int key) {
        // Base case: if the tree is empty or the key is at the root of the subtree
        if (root == null || root.value == key) {
            return root != null;
        }

        // If the key is smaller than the root's key, it must be in the left subtree
        if (key < root.value) {
            return find(root.left, key);
        }

        // If the key is larger than the root's key, it must be in the right subtree
        return find(root.right, key);
    }



    /*
    a method to find the node in the tree
    with a smallest key
    */
    public int getMin(Node root){
        //implement in here
        return 1;
    }



    /*
    a method to find the node in the tree
    with a largest key
    */
    public int getMax(Node root){
        //implement in here
        return 1;
    }



    /*
    this method will not compile until getMax
    is implemented
    */
    public Node delete(Node root, int key){

        if(root == null){
            return root;
        }else if(key < root.value){
            root.left = delete(root.left, key);
        }else if(key > root.value){
            root.right = delete(root.right, key);
        }else{
            //node has been found
            if(root.left==null && root.right==null){
                //case #1: leaf node
                root = null;
            }else if(root.right == null){
                //case #2 : only left child
                root = root.left;
            }else if(root.left == null){
                //case #2 : only right child
                root = root.right;
            }else{
                //case #3 : 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }



}

public class TreeDemov4 {
    public static void main(String[] args){
        BinarySearchTree t1  = new BinarySearchTree();
        t1.insert( 24);
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


