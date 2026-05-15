import java.util.*;
public class Binary_Search_Tree {
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

    public static Node Build_BST(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = Build_BST(root.left, val);
        }
        else{
            //right subtree
            root.right = Build_BST(root.right, val);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean BST_Search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }
        else if(root.data > key){
            return BST_Search(root.left, key);
        }
        else{
            return BST_Search(root.right, key);
        }
    }

    public static Node delete_node(Node root, int val){
        if(root == null){
            return null;
        }

        if(root.data > val){
            root.left = delete_node(root.left, val);
        }

        else if(root.data < val){
            root.right = delete_node(root.right, val);
        }

        else{
            //case 1
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2
            if(root.right == null){
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }

            //case 3
            else{
                Node IS = inorder_successor(root.right); //Inorder Successor in BST is left most node in right subtree
                root.data = IS.data;
                root.right = delete_node(root.right, IS.data);
            }
        }
        return root;
    }

    public static Node inorder_successor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void print_range(Node root, int k1, int k2){
        if(root == null){
            return;
        }

        if(root.data < k1){
            print_range(root.right, k1, k2);
        }

        if(root.data > k2){
            print_range(root.left, k1, k2);
        }

        if(root.data >= k1 && root.data <= k2){
            print_range(root.left, k1, k2);
            System.out.print(root.data + " ");
            print_range(root.right, k1, k2);
        }
    }

    public static void root_leaf_path(Node root, ArrayList <Integer> path){
        if(root == null){
           return;
        }
        
        path.add(root.data);

        if(root.left == null && root.right == null){
            for(int i = 0; i<path.size(); i++){
                System.out.print(path.get(i) + " ");
            }
            System.out.println(); 
        }

        root_leaf_path(root.left, path); 
        root_leaf_path(root.right, path);
        path.remove(path.size()-1);

    }

    public static boolean valid_BST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }

        if(min != null && root.data <= min.data){
            return false;
        }

        if(max != null && root.data >= max.data){
            return false;
        }

        return valid_BST(root.left, min, root) && valid_BST(root.right, root, max);
    }

    public static Node mirror_BST(Node root){
        if(root == null){
            return null;
        }

        Node leftSubtree = mirror_BST(root.left);
        Node rightSubtree = mirror_BST(root.right);

        root.left = rightSubtree;
        root.right = leftSubtree;

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
        int values[] = {8, 5, 3, 6, 10, 11};
        Node root = null;

        for(int i = 0; i < values.length; i++){
           root = Build_BST(root, values[i]);
        }
        
        // inorder(root);

        // System.out.println();
        // delete_node(root, 11);
        // inorder(root);
        // if(BST_Search(root, 9)){
        //     System.out.println("Key found! :) ");
        // }
        // else{
        //     System.out.println("Key not found! :(");
        // }

       // print_range(root, 10, 15);
       
    //    ArrayList <Integer> path = new ArrayList<>();
    //    root_leaf_path(root, path);

    // if(valid_BST(root, null, null)){
    //     System.out.println("valid");
    // }
    // else{
    //     System.out.println("invalid");
    // }

//    root = mirror_BST(root);
//     preorder(root);
   


        
    }
}
