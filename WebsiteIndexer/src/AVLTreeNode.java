public class AVLTreeNode {
    public SingleLinkedList IPs = new SingleLinkedList();
    public String key;
    public AVLTreeNode left;
    public AVLTreeNode right;

    public AVLTreeNode(String key) {
        this.key = key;
        this.right = null;
        this.left = null;
    }
}
