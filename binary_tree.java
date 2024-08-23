import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class binary_tree {
      static class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                  this.data = data;
                  this.left = null;
                  this.right = null;
            }
      }

      // returns root node of the tree
      static class BinaryTree {
            static int index = -1;

            public static Node BuildTree(int nodes[]) {
                  index++;
                  if (nodes[index] == -1) {
                        return null;
                  }
                  Node newnode = new Node(nodes[index]);
                  newnode.left = BuildTree(nodes);
                  newnode.right = BuildTree(nodes);

                  return newnode;
            }

            // preorder(root->left->right)
            public static void preorder(Node root) {
                  if (root == null) {
                        return;
                  }
                  System.out.println(root.data + " ");
                  preorder(root.left);
                  preorder(root.right);
            }

            // inorder(left->root->right)
            public static void inorder(Node root) {
                  if (root == null) {
                        return;
                  }
                  inorder(root.left);
                  System.out.println(root.data + " ");
                  inorder(root.right);
            }

            // postorder(left->root->right)
            public static void postorder(Node root) {
                  if (root == null) {
                        return;
                  }
                  postorder(root.left);
                  postorder(root.right);
                  System.out.println(root.data + " ");
            }

            public static void levelOrder(Node root) {
                  if (root == null) {
                        return;
                  }
                  Queue<Node> q = new LinkedList<>();
                  q.add(root);
                  q.add(null);
                  while (!q.isEmpty()) {
                        Node curNode = q.remove();
                        if (curNode == null) {
                              System.out.println();
                              if (q.isEmpty()) {
                                    break;
                              } else {
                                    q.add(null);
                              }
                        } else {
                              System.out.print(curNode.data + " ");
                              if (curNode.left != null) {
                                    q.add(curNode.left);
                              }
                              if (curNode.right != null) {
                                    q.add(curNode.right);
                              }
                        }
                  }
            }

            public static int countNodes(Node root) {
                  if (root == null) {
                        return 0;
                  }
                  int leftNode = countNodes(root.left);
                  int rightNode = countNodes(root.right);
                  return leftNode + rightNode + 1;
            }

            public static int sumNode(Node root) {
                  if (root == null) {
                        return 0;
                  }
                  int leftSum = sumNode(root.left);
                  int rightSum = sumNode(root.right);
                  return leftSum + rightSum + root.data;
            }

            public static int height(Node root) {
                  if (root == null) {
                        return 0;
                  }
                  int leftHeight = height(root.left);
                  int rightHeight = height(root.right);
                  return Math.max(leftHeight, rightHeight) + 1;
            }

      }

      public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            Node root = tree.BuildTree(nodes);
            System.out.println("pre order :");
            tree.preorder(root);// O(n)-time complexity
            System.out.println("in order :");
            tree.inorder(root);
            System.out.println("post order :");
            tree.postorder(root);
            System.out.println("level order :");
            tree.levelOrder(root);
            System.out.println("number of nodes are: " + tree.countNodes(root));
            System.out.println("sum of nodes are: " + tree.sumNode(root));
            System.out.println("height of nodes are: " + tree.height(root));

      }

}

// output

// pre order :
// 1
// 2
// 4
// 5
// 3
// 6
// in order :
// 4
// 2
// 5
// 1
// 3
// 6
// post order :
// 4
// 5
// 2
// 6
// 3
// 1
// level order :
// 1
// 2 3
// 4 5 6
// number of nodes are: 6
// sum of nodes are: 21
// height of nodes are: 3
