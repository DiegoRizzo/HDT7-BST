// Obtenido de GeeksForGeeks - Java Program to Construct a Binary Search Tree

public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    // Insertion operation
    void insert(Palabra palabra) {
        root = insertRec(root, palabra);
    }

    Node insertRec(Node root, Palabra palabra) {
        // If there is no root, the new node is the root
        if (root == null) {
            root = new Node(palabra);
            return root;
        }

        // If the new node is less than the root of the (sub)tree, it will be inserted to the left
        // Otherwise, it will be inserted to the right
        if (palabra.compareTo(root.palabra) < 0) {
            root.left = insertRec(root.left, palabra);
        } else if (palabra.compareTo(root.palabra) > 0) {
            root.right = insertRec(root.right, palabra);
        }

        return root;
    }

    // Deletion operation
    void delete(Palabra palabra) {
        root = deleteRec(root, palabra);
    }

    Node deleteRec(Node root, Palabra palabra) {
        if (root == null) {
            return root;
        }

        // If the node to be deleted is a leaf node, it will be removed
        // If the node to be deleted has just one child node, it will be replaced with the child node
        // If the node to be deleted has two child nodes, we find its inorder successor or predecessor
        if (palabra.compareTo(root.palabra) < 0) {
            root.left = deleteRec(root.left, palabra);
        } else if (palabra.compareTo(root.palabra) > 0) {
            root.right = deleteRec(root.right, palabra);
        } else {
            if (root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // We find the inorder successor (smallest in the right subtree) or predecessor (largest in the left subtree)
            root.palabra = minValue(root.right);
            root.right = deleteRec(root.right, root.palabra);
        }

        return root;
    }

    Palabra minValue(Node root) {
        // We traverse to the leaf all the way to the left of the (sub)tree to find the minimum value.
        Palabra minv = root.palabra;
        while(root.left != null) {
            minv = root.left.palabra;
            root = root.left;
        }

        return minv;
    }

    // Search operation
    boolean search(Palabra palabra) {
        return searchRec(root, palabra);
    }

    boolean searchRec(Node root, Palabra palabra) {
        // We start at the root and compare the target key with the current node key
        // If the target key is less than the current key, it will search the left subtree
        // If the target key is greater than the current key, it will search the right subtree
        // If the target key is equal to the current key, the node has been found
        // Otherwise, we reach the null node
        if (root == null) {
            return false;
        }
        if (root.palabra.compareTo(palabra) == 0) {
            return true;
        }
        if (root.palabra.compareTo(palabra) < 0) {
            return searchRec(root.right, palabra);
        }
        return searchRec(root.left, palabra);
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println("\n");
    }

    void inorderRec(Node root) {
        // Starting at the root, we traverse the left subtree, and once a leaf is reached, the content is printed out.
        // After the left subtree is printed, the root is printed.
        // Then, we traverse the right subtree, and once a leaf is reached, the content is printed out.
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.palabra + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preoder() {
        preorderRec(root);
        System.out.println("\n");
    }

    void preorderRec(Node root) {
        // Starting at the root, we print the content of the root node, and traverse the left subtree, printing the content of each node.
        // Once the entire left subtree is traversed, we traverse the right subtree, printing the content of each node.
        if (root != null) {
            System.out.println(root.palabra + " ");
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
        // Starting at the root, we traverse the left subtree until a leaf is reached.
        // We print the content of the left subtree, then traverse the right subtree until a leaf is reached.
        // We print the content of the right subtree, then finally print the content of the root.
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.palabra + " ");
        }
    }
    
}
