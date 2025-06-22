import java.util.*;
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
    //BST: PreOrder Traversal
    public static void preOrderTraversal(Node root){
        if (root==null)
            return;

        System.out.print(root.data + " ");
        inorderTraversal(root.left);
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


    //BINARY SEARCH TREES: SEARCH & DELETE A NODE IN BST
    public static Node findInOrderSuccessor(Node root){
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static Node delete(Node root, int val){
        if (root.data<val)
            root.right = delete(root.right, val);
        else if (root.data>val)
            root.left = delete(root.left, val);
        else {//voila
            //Case1 - Leaf Node
            if (root.right==null && root.left==null){
                return null;
            }
            //Case2 - Single Child
            if (root.left==null)
                return root.right;
            if (root.right==null)
                return root.left;
            //Case3 - Two Child
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }


    //BINARY SEARCH TREES: PRINT NODES IN GIVEN RANGE IN BST
    public static void printInRange(Node root, int k1, int k2){
        if (root==null)
            return;
        if (root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data>k2) {
            printInRange(root.left, k1, k2);
        }else {
            printInRange(root.right, k1, k2);
        }
    }


    //BINARY SEARCH TREES: PRINT ROOT TO LEAF PATHS IN BST
    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+ " ");
        }
        System.out.println(" ");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if (root==null)
            return;

        path.add(root.data);
        if (root.left==null && root.right==null)
            printPath(path);

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);

        path.remove(path.size()-1);
    }


    //BINARY SEARCH TREES: VALIDATE BST (IS IT VALID BST OR NOT)
    public static boolean isValidBST(Node root, Node min, Node max){
        if (root==null)
            return true;

        if(min!=null && root.data<= min.data)
            return false;
        else if (max!=null && root.data>=max.data)
            return false;

        boolean RValid = isValidBST(root.right, root, max);
        boolean LValid = isValidBST(root.left, min, root);

        return RValid && LValid;
    }


    //BINARY SEARCH TREES: MIRROR A BST
    public static Node mirrorBST(Node root){
        if(root==null)
            return null;

        Node LM = mirrorBST(root.left);
        Node RM = mirrorBST(root.right);

        root.left = RM;
        root.right = LM;
        return root;
    }


    //BINARY SEARCH TREES: SORTED ARRAY TO BALANCED BST
    public static Node createBST(int arr[], int st, int end){
        if (st>end) return null;

        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);

        root.left = createBST(arr,st,mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }


    public static void main(String args[]){
        int values[] = {3,5,6,8,10,11,12};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root,values[i]);
        }
        Node newRoot = createBST(values, 0,6);
        preOrderTraversal(newRoot);
        System.out.println();
        System.out.println(isValidBST(newRoot, null,null));
    }
}
