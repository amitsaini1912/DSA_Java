import java.util.*;

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


    //BINARY TREES: DIAMETER OF A TREE APPROACH 2 => O(n)
    static class Info{
        int ht;
        int dia;
        public Info(int h, int d){
            this.ht = h;
            this.dia = d;
        }
    }
    public static Info diameter2(Node root){
        if(root==null)
           return new Info(0,0);

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int dia = Math.max( Math.max( ((Info) leftInfo).dia, ((Info) rightInfo).dia ), (((Info) leftInfo).ht+ ((Info) rightInfo).ht + 1));
        int ht = Math.max(((Info) leftInfo).ht,((Info) rightInfo).ht) + 1;
        return new Info(ht,dia);
    }


    public static boolean isIdentical(Node root, Node subRoot){
        if(root==null && subRoot==null)
            return true;
        else if(root==null || subRoot==null || root.data!=subRoot.data)
            return false;
        if(!isIdentical(root.right, subRoot.right))
            return false;
        if (!isIdentical(root.left, subRoot.left))
            return false;
        return true;
    }
    //BINARY TREES: SUBTREE OF ANOTHER TREE
    public static boolean isSubtree(Node root, Node subRoot){
         if (root == null)
             return false;
         if(root.data==subRoot.data){
             if(isIdentical(root, subRoot))
                 return true;
         }
         return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    //BINARY TREES: TOP VIEW OF A TREE
    static class Inf{
        Node node;
        int hd;
        public Inf(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        Queue <Inf> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Inf(root, 0));
        q.add(null);
        while (!q.isEmpty()){
            Inf currInfo = q.remove();
            //check for null => queue is empty-> break
            if(currInfo==null){
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }else {
                //Key contains in map or not
                if(!map.containsKey(currInfo.hd))
                    map.put(currInfo.hd, currInfo.node);

                //Add left & right child recursively in queue=
                if(currInfo.node.left!=null){
                    q.add(new Inf(currInfo.node.left, currInfo.hd-1));
                    min = Math.min(min, currInfo.hd-1);
                }
                if(currInfo.node.right!=null){
                    q.add(new Inf(currInfo.node.right, currInfo.hd+1));
                    max = Math.max(max, currInfo.hd+1);
                }
            }
        }
        for (int i=min; i<=max; i++) {
            if (map.containsKey(i)) {
                System.out.print(map.get(i).data + " ");
            }
        }
        System.out.println(" ");
    }


    //BINARY TREES: Kth LEVEL OF A TREE
    public static void kLevel(Node root, int level, int k){
        if(root==null)
           return;

        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }


    //BINARY TREES: LOWEST COMMON ANCESTOR (Approach-1) => TC - O(n) SC - O(n)
    public static boolean getPath(Node root, int n, ArrayList<Node>path){
        if (root==null)
            return false;

        path.add(root);

        if (root.data==n)
           return true;

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft||foundRight)
            return true;

        path.remove(path.size()-1); //current root is not part of path
        return false;
    }
    public static int lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        int i = 0;
        for (; i<path1.size() && i<path2.size(); i++) {
            if (path1.get(i)!=path2.get(i))
                break;
        }
        return path1.get(i-1).data;
    }


    public static void main(String args[]){
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right = new Node(3);
        root1.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        /*
                     1                   2
                    / \                 / \
                   2   3               4   5
                  / \   \
                 4   5   7
         */
        System.out.println(lca(root1,4,7));
    }
}