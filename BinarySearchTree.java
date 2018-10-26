package com.codingblocks;

import java.util.LinkedList;

public class BinarySearchTree {
    private Node root;
    public void populate(int [] data)
    {
        populate(data,this.root);
    }

    private void populate(int[] data, Node node) {/////code to insert the elements from  given sorted array
        for(int i=0;i<data.length;i++)
        {
            this.insert(data[i]);
        }
    }

    public void populateWithSorted(int [] data)//////if inorder traversal is given then also we use the technique and take the mid and do the recursion in left root right manner ie it is inorder
    {
        populateWithSorted(data,0,data.length);
    }

    private void populateWithSorted(int[] data, int start,int end) {

        int mid=(start+end)/2;
        insert(data[mid]);
        populateWithSorted(data,0,mid);
        populateWithSorted(data,mid+1,end);
    }


    public boolean isEmpty()
    {
        return this.root==null;
    }
    public void  insert(int value)
    {
        this.root = insert(value,this.root);
    }

    private Node insert(int value, Node node) {///whenever the left or right pointer of present node in null then it creates the new node and inserts the value then returns the pointer to its previous node
        if(node==null)
        {
            node=new Node(value);
            return node;
        }
        if(node.value>value)
        {
           node.left= insert(value,node.left);
        }
        if(node.value<value)
        {
            node.right=insert(value,node.right);
        }
        //update the height


        return node;
    }

    public void display()
    {
        display(this.root,"root node is  ");
    }

    private void display(Node node,String details) {
        if(node==null)
        {
            return;
        }
        System.out.println(details+node.value);
        display(node.left,"Left child of  ");
        display(node.right,"right child of  ");
    }

    public void displayPre()
    {
        displayPre(this.root);
    }

    private void displayPre(Node node) {
        if(node==null)
        {
            return;
        }
        displayPre(node.left);
        System.out.println(node.value);
        displayPre(node.right);
    }
    public void displayIn()
    {
        displayIn(this.root," root node");
    }

    private void displayIn(Node node,String details) {
        if(node==null)
        {
            return;
        }
        displayIn(node.left,"left child of"+node.value);
        System.out.println(details+node.value);
        displayIn(node.right,"right child of"+node.value);
    }

    public void between(int start,int end)
    {
        between(start,end,this.root);
    }

    private void between(int start, int end, Node node) {
        if(node==null)
        {
            return;
        }
        if(node.value>=start&&node.value<=end)
        {
        System.out.println(node.value);
        }
        if(node.value>=start){
        between(start,end,node.left);}
        if(node.value<=end)
        {
        between(start,end,node.right);}
    }

    public LinkedList<Node> sortedList()
    {
        LinkedList<Node> nodes=new LinkedList<>();
        return nodes=sortedList(this.root,nodes);
    }

    private LinkedList<Node> sortedList(Node node, LinkedList<Node> nodes) {
        if(node==null)
        {
            return nodes;
        }
        sortedList(node.left,nodes);
        nodes.add(node);
        sortedList(node.right,nodes);
        return nodes;
    }
    public


    public class Node
    {
        private int height;
        private Node left;
        private int value;
        private Node right;
        public Node(int value){
            this.value=value;
            this.height=0;
        }
    }
}
