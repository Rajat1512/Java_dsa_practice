public class Size_of_largestBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        boolean isBST;
        int size;
        int min; //minimum possible value in subtree
        int max;

        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int max_size = 0;

    public static Info size_BST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left_info = size_BST(root.left);
        Info right_info = size_BST(root.right);

        int size = left_info.size + right_info.size + 1;
        int min = Math.min(root.data, Math.min(left_info.min, right_info.min));
        int max = Math.max(root.data, Math.min(left_info.max, right_info.max));

        if(root.data <= left_info.max || root.data >= right_info.min){
            return new Info(false, size, min, max);
        }

        if(left_info.isBST && right_info.isBST){
            max_size = Math.max(max_size, size);//ye size tb update hoga jab right or left dono side se true ara hoga, mtlb valid BST h
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);

    }

    public static void main(String args[]){
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.right = new Node(20);
        root.left.left = new Node(5);
        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = size_BST(root);
        System.out.print("Size of largest BST : "+ max_size);

    }

}
