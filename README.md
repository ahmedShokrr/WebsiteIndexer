# WebsiteIndexerAVL

## Overview

This project is part of the CSE111 Data Structures course at Al Alamein International University. It implements an indexing system for popular websites and their IP addresses using an AVL Tree. The project demonstrates the practical use of the binary search tree ADT and AVL Tree for efficient data storage and retrieval.

## Features

- **Index Websites**:
  - Process a file with URLs and IP addresses.
  - Create an AVL tree index based on the website names.
  - Handle multiple IP addresses for a single website.

- **Functionalities**:
  - Display the full index of websites.
  - Search for a URL and retrieve all associated IP addresses.
  - Search for an IP address and find the associated URL.

## Requirements

- Java Development Kit (JDK) 8 or later
- Eclipse IDE or any other Java IDE


## Usage

1. **Open the project in your IDE**:
    - Open Eclipse or your preferred IDE.
    - Import the project.

2. **Run the program**:
    - Locate the `Main.java` file in your IDE.
    - Run the `Main.java` file to execute the program.

3. **Interact with the program**:
    - Provide the input file name as a command line argument.
    - Follow the menu options to display the index, search for URLs, or search for IP addresses.

## Code Structure

- `Main.java`: Contains the main method to initiate the program and handle user interactions.
- `AVLTree.java`: Implements the AVL Tree data structure.
  - **Methods**:
    - `insert(String websiteName, SingleLinkedList ips)`: Inserts or updates a node in the tree.
    - `search(String key)`: Searches for a URL and displays associated IP addresses.
    - `searchforip(String ip)`: Searches for an IP address and finds the associated URL.
    - `inorder()`: Displays the AVL tree in alphabetical order.
    - `breadth_first()`: Displays the AVL tree level by level.
    - `read_data_from_file(String fileName)`: Reads data from a file and constructs the AVL tree.

- `AVLTreeNode.java`: Represents a node in the AVL tree.
  - Contains the website name, a linked list of IP addresses, and pointers to left and right children.

- `SingleLinkedList.java`: Implements a singly linked list to store IP addresses for each website.
  - **Methods**:
    - `addNode(String ipAddress)`: Adds an IP address to the list.
    - `display()`: Displays all IP addresses in the list.



## License

This project is licensed under the MIT License.
