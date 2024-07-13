//Ahmed Mostafa Basssouny Shokr           ID:20100547
//Omar  mohamed Abd_ElMgeid El_hmrawy	  ID:20100357

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.read_data_from_file("C:\\Users\\Ahmed Shokr\\Desktop\\URLS Project2.txt");
        menu(tree);

    }

    /**
     * Menu function to Chosse what you want to do
     * @param tree
     */
    public static void menu(AVLTree tree) {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------- MENU --------------------");
        System.out.println();
        System.out.println("1) Display the full index. ");
        System.out.println("2) Search for a URL.");
        System.out.println("3) Search for an IP address.");
        System.out.println("4) Exit.");
        System.out.println();
        System.out.print("Enter Your Choice : ");
        String choice = input.next();


        if (choice.equals("1")) {
            System.out.println("-------------------- Display the full index --------------------");
            System.out.println();
            tree.inorder();
            System.out.println();
            menu(tree);
        } else if (choice.equals("2")) {
            System.out.println("-------------------- Search for a URL --------------------");
            System.out.println();
            System.out.print("Please enter the page:");
            tree.search(input.next());
            menu(tree);
        }else if(choice.equals("3")){
            System.out.println("-------------------- Search for an IP address --------------------");
            System.out.println();
            System.out.print("Please Enter The IP address: ");
            tree.searchforip(input.next());
            menu(tree);
        } else if (choice.equalsIgnoreCase("exit") || choice.equals("4")) {
            System.out.println("Thanks for using our program");
        } else {
            System.out.println("InValid Choice. ");
            menu(tree);
        }
    }
}