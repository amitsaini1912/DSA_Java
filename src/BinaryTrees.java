import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static  int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }


    //TREE TRAVERSAL: LEVEL UP TRAVERSAL [BFS]
    public static void levelUptraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode==null){
                System.out.println();
                if (q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
        }
    }


    //BINARY TREES: HEIGHT OF A TREES
    public static int maxHeight(Node root){
        //Base case
        if (root==null)
            return 0;
        //Recursion
        int leftH = maxHeight(root.left);
        int rightH = maxHeight(root.right);
        //Backtacking :- height returning step
        return Math.max(leftH,rightH)+1;
    }


    //BINARY TREES: SUM OF NODES OF A TREES
    public static int sumOfNodes(Node root){
        //Base case
        if (root==null)
            return 0;
        //Recursion
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        //Backtacking :- height returning step
        return leftSum+rightSum+root.data;
    }


    //BINARY TREES: COUNT OF NODES OF A TREES
    public static int countOfNodes(Node root){
        //Base case
        if (root==null)
            return 0;
        //Recursion
        int leftN = countOfNodes(root.left);
        int rightN = countOfNodes(root.right);
        //Backtacking :- height returning step
        return leftN+rightN+1;
    }


    //BINARY TREES: DIAMETER OF A TREE APPROACH 1 => O(n2)
    public static int diameter1(Node root){
        if (root==null){
            return 0;
        }

        int leftD = diameter1(root.left);
        int leftH = maxHeight(root.left);
        int rightD = diameter1(root.right);
        int rightH = maxHeight(root.right);

        return Math.max(leftD,Math.max(rightD,leftH+rightH+1));
    }





    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        /*
                     1
                    / \
                   2   3
                  / \   \
                 4   5   7
         */
        System.out.println(diameter1(root));
    }
}