package binary.search.tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] nums = {5,3,4,7,8,9,0};
        tree.populate(nums);
        tree.display();
    }
}
