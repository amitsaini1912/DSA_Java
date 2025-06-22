public class BinarySearchTrees {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int value){
        if (root==null){
            root= new Node(value);
            return root;
        }
        if (root.data>value){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void inorderTraversal(Node root){
        if (root==null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }


    //BINARY SEARCH TREES: SEARCH IN A NODE IN BST
    public static boolean searchNode(Node root, int k){
        if (root==null) return false;
        if (root.data==k) return true;
        if (root.data>k)
            return searchNode(root.left, k);
        else
            return searchNode(root.right, k);

    }


    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root,values[i]);
        }
        System.out.println(searchNode(root,4));
    }
}
