package Data_Structures;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class tree_top_view {
    static int maxCount = -3000;
    static int minCount = 3000;
    static class NodeAndHigh{
        int data ;
        int high;
        NodeAndHigh(int data, int high){
            this.data = data;
            this.high = high;
        }
    }
    public static void hd(Node root, int count, NodeAndHigh[] aCount, int high ){
       maxCount = Math.max(count, maxCount);
       minCount = Math.min(count, minCount);
       if (aCount[count] == null || aCount[count].high > high) {
           aCount[count] = new NodeAndHigh(root.data, high);
       }
       if (root.left != null) hd(root.left, count - 1, aCount, high + 1);
       if (root.right != null) hd(root.right, count + 1, aCount, high + 1);
    }
    public static void topView(Node root) {
        if (root != null) {
            NodeAndHigh[] bb = new NodeAndHigh[2000];
            hd(root, 1000, bb, 1);
            for (int i = minCount; i <= maxCount; i++)
                System.out.print(bb[i].data + " ");
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}
