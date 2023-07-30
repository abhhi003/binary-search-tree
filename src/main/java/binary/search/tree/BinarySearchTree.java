package binary.search.tree;


public class BinarySearchTree {
    public static class Node{
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public BinarySearchTree(){}

    public int height(Node node){
        if(node == null)
            return -1;
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null)return;

        System.out.println(details + node.value);
        display(node.left, "Left child of "+node.value+" : ");
        display(node.right, "Right child of "+node.value+" : ");
    }

    public  void populate(int[] nums){
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length-1);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start >= end)return;
        
        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }
    public void insert(int value){
        root = insert(value, root);
    }

    private Node insert(int value, Node node){
        //If node is empty/null, new node is created and returned
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }
        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        //If node is not null, same node is returned
        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null)return true;

        //Checking balance of current level nodes                   //recursively checking for right subtree and left subtree
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.right) && balanced(node.left);
    }
}
