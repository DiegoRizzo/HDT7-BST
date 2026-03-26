// Obtenido de GeeksForGeeks - Java Program to Construct a Binary Search Tree

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insertion operation
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        // If there is no root, the new node is the root
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // If the new node is less than the root of the (sub)tree, it will be inserted to the left
        // Otherwise, it will be inserted to the right
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Deletion operation
    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        // If the node to be deleted is a leaf node, it will be removed
        // If the node to be deleted has just one child node, it will be replaced with the child node
        // If the node to be deleted has two child nodes, we find its inorder successor or predecessor
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while(root.left != null) {
            minv = root.left.key;
            root = root.left;
        }

        return minv;
    }

    // Search operation
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        // We start at the root and compare the target key with the current key
        // If the target key is less than the current key, it will search the left subtree
        // If the target key is greater than the current key, it will search the right subtree
        // If the target key is equal to the current key, the node has been found
        // Otherwise, we reach the null node
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        if (root.key < key) {
            return searchRec(root.right, key);
        }
        return searchRec(root.left, key);
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println("\n");
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preoder() {
        preorderRec(root);
        System.out.println("\n");
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.println(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    void postorder() {
        postorderRec(root);
        System.out.println("\n");
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.key + " ");
        }
    }
}
