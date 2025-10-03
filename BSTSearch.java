import java.util.Scanner;
class BinarySearchTree {
    // Node structure for BST
    class Node {
        int key;        // Value of the node
        Node left, right; // Left and right child references
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    Node root; // Root node of the BST
    // Constructor
    BinarySearchTree() {
        root = null;
    }
    // Public method to insert a key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }
    // Recursive method to insert a new key in BST
    Node insertRec(Node root, int key) {
        if (root == null) { // If tree/subtree is empty
            root = new Node(key);
            return root;
        }
        if (key < root.key) // Go to left subtree
            root.left = insertRec(root.left, key);
        else if (key > root.key) // Go to right subtree
            root.right = insertRec(root.right, key);
        return root;
    }
    // Public method to search for a key in BST
    boolean search(int key) {
        return searchRec(root, key);
    }
    // Recursive method to search a key
    boolean searchRec(Node root, int key) {
        if (root == null) // Key not found
            return false;
        if (root.key == key) // Key found
            return true;
        if (key < root.key) // Search left
            return searchRec(root.left, key);
        else // Search right
            return searchRec(root.right, key);
    }
    // Inorder Traversal (Left -> Root -> Right)
    void inorder() {
        inorderRec(root);
        System.out.println();
    }
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
    // Preorder Traversal (Root -> Left -> Right)
    void preorder() {
        preorderRec(root);
      System.out.println();
    }
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    // Postorder Traversal (Left -> Right -> Root)
    void postorder() {
        postorderRec(root);
        System.out.println();
    }
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        // Step 1: Get number of elements to insert
        System.out.print("Enter Number Of Elements To Insert: ");
        int n = sc.nextInt();
        // Step 2: Read elements and insert into BST
        System.out.println("Enter " + n + " Elements:");
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            bst.insert(value);
        }
        // Step 3: Display traversals
        System.out.print("Inorder Traversal   : ");
        bst.inorder();
        System.out.print("Preorder Traversal  : ");
        bst.preorder();
        System.out.print("Postorder Traversal : ");
        bst.postorder();
        // Step 4: Ask for element to search
        System.out.print("Enter Element To Search: ");
        int searchKey = sc.nextInt();
        // Step 5: Display search result
        if (bst.search(searchKey))
            System.out.println(searchKey + " Found in BST.");
        else
            System.out.println(searchKey + " Not Found in BST.");
        sc.close();
    }
}


