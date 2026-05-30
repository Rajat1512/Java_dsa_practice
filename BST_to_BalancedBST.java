import java.util.*;
public class BST_to_BalancedBST {
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

    public static void get_inorder(Node root, ArrayList <Integer> inorder){
        if(root == null){
            return;
        }

        get_inorder(root.left, inorder);
        inorder.add(root.data);
        get_inorder(root.right, inorder);
    }

    public static Node create_BST(ArrayList <Integer> inorder, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = create_BST(inorder, start, mid-1);
        root.right = create_BST(inorder, mid+1, end);

        return root;
    }

    public static Node BBST(Node root){
        //inoreder seq
        ArrayList <Integer> inorder = new ArrayList<>();
        get_inorder(root, inorder);

        //sorted seq or sorted array -> balanced BST
        root = create_BST(inorder, 0, inorder.size()-1);
        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]){
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.right.right.right = new Node(12);
        
        preorder(root); //unbalanced BST
        System.out.println();
        root = BBST(root);
        preorder(root); //balanced BST
    }
}
