public class AVLTree {
    
    public class Node {
        int data;
        Node left;
        Node right;
      
        int height;
      
        public Node(int data) {
          this.data = data;
        }
      }

      private Node rotateRight(Node node) {
        Node leftChild = node.left;
      
        node.left = leftChild.right;
        leftChild.right = node;
      
        updateHeight(node);
        updateHeight(leftChild);
      
        return leftChild;
      }

      private Node rotateLeft(Node node) {
        Node rightChild = node.right;
      
        node.right = rightChild.left;
        rightChild.left = node;
      
        updateHeight(node);
        updateHeight(rightChild);
      
        return rightChild;
      }

      private Node rebalance(Node node) {
        int balanceFactor = balanceFactor(node);
      
        // Left-heavy?
        if (balanceFactor < -1) {
          if (balanceFactor(node.left) <= 0) {    // Case 1
            // Rotate right
            node = rotateRight(node);
          } else {                                // Case 2
            // Rotate left-right
            node.left = rotateLeft(node.left);
            node = rotateRight(node);
          }
        }
      
        // Right-heavy?
        if (balanceFactor > 1) {
          if (balanceFactor(node.right) >= 0) {    // Case 3
            // Rotate left
            node = rotateLeft(node);
          } else {                                 // Case 4
            // Rotate right-left
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
          }
        }
      
        return node;
      }

      

}
