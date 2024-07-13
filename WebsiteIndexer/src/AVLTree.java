import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AVLTree implements AVLTreeInterface {
    AVLTreeNode root = null;

    /**
     * no args constructor
     */
    public AVLTree() {

    }

    /**
     * function to Insert a String  at the BST by recursion method.
     * @param websiteName
     * @param ips
     */
    public void insert(String websiteName, SingleLinkedList ips) {
        AVLTreeNode newWebsite = new AVLTreeNode(websiteName);

        for(int i = 0; i < ips.getSize(); ++i) {
            newWebsite.IPs.addNode(ips.get(i));
        }

        this.root = this.insert_recursive(this.root, newWebsite);
    }

    /**
     * Recursive fucntion to insert new Node
     * @param currentRoot
     * @param newWebsite
     * @return
     */
    private AVLTreeNode insert_recursive(AVLTreeNode currentRoot, AVLTreeNode newWebsite) {
        if (currentRoot == null) {
            return newWebsite;
        } else {
            if (this.compareStrings(currentRoot.key, newWebsite.key) == -1) {
                currentRoot.left = this.insert_recursive(currentRoot.left, newWebsite);
            } else if (this.compareStrings(currentRoot.key, newWebsite.key) == 1) {
                currentRoot.right = this.insert_recursive(currentRoot.right, newWebsite);
            }

            return currentRoot;
        }
    }

    /**
     * Function to Search for URL Name
     * @param key
     */
    public void search(String key) {
        AVLTreeNode currentRoot = this.root;
        currentRoot = this.searchRecursive(currentRoot, key);
        if (currentRoot != null) {
            System.out.print("ip addresses for " + key + " : ");
            currentRoot.IPs.display();
        } else {
            System.out.println(key + " is not found");
        }

    }

   /**
   * Recursive function for search
    * @param currentRoot
    * @param key
    * @return
   */
    private AVLTreeNode searchRecursive (AVLTreeNode currentRoot, String key){

        if (currentRoot==null||currentRoot.key.equals(key))
            return currentRoot;
        if (compareStrings(currentRoot.key,key) == -1)
            return searchRecursive(currentRoot.left,key);
        else if(compareStrings(currentRoot.key,key) == 1)
            return searchRecursive(currentRoot.right,key);
        else
            return null;
    }

    /**
     * inorder traversal function
     */
    public void inorder() {
        this.inorderRecursive(this.root);
        System.out.println();
    }

    /**
     * inorder_traversal_recursive function
     * @param root
     */
    private void inorderRecursive(AVLTreeNode root) {
        if (root != null) {
            this.inorderRecursive(root.left);
            System.out.print(root.key + "  ");
            root.IPs.display();
            this.inorderRecursive(root.right);
        }

    }
    /**
     * Function to read the data from Extrenal file
     * @param fileName
     */
    public void read_data_from_file(String fileName) {
        try {
            Scanner reader = new Scanner(new File(fileName));

            while(reader.hasNext()) {
                String line = reader.nextLine();
                String[] Info = line.split(" > ");
                SingleLinkedList ip_addresses = new SingleLinkedList();

                for(int i = 1; i < Info.length; ++i) {
                    ip_addresses.addNode(Info[i]);
                }

                this.insert(Info[0], ip_addresses);
            }

            reader.close();
            System.out.println("Your file has been loaded, the index has been created!");
        } catch (FileNotFoundException var7) {
            var7.getStackTrace();
        }
    }
    /**
     * Search for UML by IP Address
     * @param ip
     */

    public void searchforip(String ip) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            ipSearchRecursive(root, i, ip);
        }
    }

    /**
     * function to print by Breadth first Style
     */
    public void breadth_first() {
        int h = height(this.root);

        for(int i = 1; i <= h; ++i) {
            printCurrentLevel(this.root, i);
        }

    }

    /**
     * function to print Current level
     * @param root
     * @param level
     */

    private void printCurrentLevel(AVLTreeNode root, int level) {
        if (root != null) {
            if (level == 1) {
                System.out.print(root.key + " ");
            } else if (level > 1) {
                printCurrentLevel(root.left, level - 1);
                printCurrentLevel(root.right, level - 1);
            }

        }
    }

    /**
     * Function to cal the Height of the tree
     * @param root
     * @return
     */
    private int height(AVLTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = this.height(root.left);
            int rheight = this.height(root.right);
            return lheight > rheight ? lheight + 1 : rheight + 1;
        }
    }

    /**
     * Function to compare between two Strings BY ASCII
     * @param s1
     * @param s2
     * @return
     */
    private int compareStrings(String s1, String s2) {
        int c1 = 0;
        int c2 = 0;

        for(int i = 0; i < s1.length() && i < s2.length(); ++i) {
            c1 += s1.toLowerCase().charAt(i);
            c2 += s2.toLowerCase().charAt(i);
        }

        if (c1 > c2) {
            return 1;
        } else {
            return c1 < c2 ? -1 : 0;
        }
    }



    /**
     * function to looping in the linked list
     * @param root
     * @param level
     * @param IP
     */

    private  void ipSearchRecursive(AVLTreeNode root , int level , String IP) {
        if (root == null)
            return;
        if (level == 1) {
            if(IPSearch(IP,root.IPs) == true){
                System.out.println("Its belongs to "+root.key);
            }
        } else if (level > 1) {
            ipSearchRecursive(root.left, level - 1, IP);
            ipSearchRecursive(root.right, level - 1, IP);
        }
    }

    /**
     * function to search in the BSTNode single linked list for the ip address
     * @param IP
     * @param l1
     * @return
     */
    private boolean IPSearch(String IP , SingleLinkedList l1){
        Node current = l1.head;
        while (current != null){
            if(current.data.equals(IP)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }


}