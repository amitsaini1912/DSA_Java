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


    //BINARY SEARCH TREES: CONVERT BST TO A BALANCED BST
    public static Node createBST2(ArrayList<Integer> AL, int st, int end){
        if (st>end) return null;

        int mid = (st+end)/2;
        Node root = new Node(AL.get(mid));

        root.left = createBST2(AL, st,mid-1);
        root.right = createBST2(AL, mid+1, end);

        return root;
    }
    public static ArrayList<Integer> findInOrderSec(Node root,ArrayList<Integer> inOrderSec){
        if (root==null) return null;

        findInOrderSec(root.left, inOrderSec);
        inOrderSec.add(root.data);
        findInOrderSec(root.right, inOrderSec);

        return inOrderSec;
    }
    public static Node balancedBST(Node root){
        ArrayList<Integer> inOrderSec = new ArrayList<>();
        inOrderSec = findInOrderSec(root, inOrderSec);
        return createBST2(inOrderSec, 0, inOrderSec.size()-1);
    }


    //BINARY SEARCH TREES: SIZE OF LARGEST BST IN BT
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if (root==null)
            return new Info(false, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Info leftInfo = largestBST(root.left);
        Info righInfo = largestBST(root.right);
        int size = leftInfo.size+righInfo.size+1;
        int min = Math.min(Math.min(leftInfo.min, righInfo.min), root.data);
        int max = Math.max(Math.max(leftInfo.max, righInfo.max), root.data);

        if(leftInfo.max<root.data || righInfo.min>=root.data)
            return new Info(false, size, min, max);

        if (leftInfo.isBST && righInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }


    //BINARY SEARCH TREES: MERGE 2 BST's IN BALANCED FORM
    public static Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        findInOrderSec(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        findInOrderSec(root2, arr2);

        //merge arr1 nd arr2
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i=0, j=0;
        while (i<arr1.size() && j<arr2.size()){
            if (arr1.get(i)<=arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        //create BST with finalArr (Sorted)
        return createBST2(finalArr, 0, finalArr.size()-1);
    }


    public static void main(String args[]){
//        int values[] = {1,2,4};
//        Node root = null;
//        for (int i = 0; i < values.length; i++) {
//            root = insert(root,values[i]);
//        }
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        /*       3
                / \
               1   4
               \    \
                2    9
                      \
                       12

         */

        Node newRoot = mergeBST(root1, root2);
        preOrderTraversal(newRoot);
    }
}
