// Node class representing each element of the binary tree
class Node {
    int key;
    Node left, right;

    // Constructor to create a new node with a given key
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BinaryTree class for basic operations
public class BinaryTree {
    Node root;

    // Constructor to initialize an empty binary tree
    public BinaryTree() {
        root = null;
    }

    // Insert a new node into the binary tree (level-order insertion)
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive method to insert a new key into the binary tree
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

       
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // In-order traversal: Left -> Root -> Right
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order traversal: Root -> Left -> Right
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order traversal: Left -> Right -> Root
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    // Search for a value in the binary tree
    public boolean search(int key) {
        return searchRec(root, key) != null;
    }

    // Recursive method to search for a given key
    private Node searchRec(Node root, int key) {
        // Base case: root is null or key is present at root
        if (root == null || root.key == key) {
            return root;
        }

        // Key is greater than root's key
        if (root.key < key) {
            return searchRec(root.right, key);
        }

        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // Driver method for testing the binary tree implementation
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting nodes into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Printing different traversals
        System.out.println("In-order traversal:");
        tree.inOrder(); 

        System.out.println("\n\nPre-order traversal:");
        tree.preOrder();

        System.out.println("\n\nPost-order traversal:");
        tree.postOrder(); 

        // Searching for an element in the tree
        System.out.println("\n\nSearch for 60: " + tree.search(60)); 
        System.out.println("Search for 90: " + tree.search(90));
    }
}
