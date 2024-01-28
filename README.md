# Binary search tree project  

### Objective
In this project, our objective is to understand how to build the binary search tree. 

### Problem
Create a binary search tree that stores persons based on their ages.

We will build the below binary search tree:

Figuer 1   
<img width="910" alt="BST" src="https://github.com/SAFCSP-Team/binary-search-tree-project/blob/main/data-structures-and-algorithms%20-%20BST%20project.jpg">



### Implementation   

We will use three classes: 
1. `Person` class
2. `Node` class
3. `BinarySearhTree` class

Using Java programming language: 

- `Person` class is already implemented and added to the BinarySearchTree java file as the below:
```java
class Person {

    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    
}

```


- `Node` class is already implemented and added to the BinarySearchTree java file as the below:
```java
class Node {

    Person person;
    Node right;
    Node left;

    public Node(Person person){
        this.person = person;
        this.right = null;
        this.left = null;
    }
    
}
```

- `BinarySearchTree` class is already implemented and added to the BinarySearchTree java file as the below:
```java

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void print() {

        if (this.root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();

            System.out.print(" " + currentNode.person.age);

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

        }

        System.out.println();
        return;
    }

    public void insert(Person newPerson) {
        Node newNode = new Node(newPerson);

        if (root == null) {
            root = newNode;
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (true) {
            stack.push(curr);

            if (newNode.person.age == curr.person.age) {
                return;
            } else if (newNode.person.age < curr.person.age) {
                if (curr.left == null) {
                    curr.left = newNode;
                    return;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = newNode;
                    return;
                }
                curr = curr.right;
            }
        }
    }

    public boolean delete(int deleteAge) {
        if (this.root == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = this.root;
        Node prev = null;
        boolean isLeftChild = false;

        // Search for the taget (curr) and it's parent (prev)
        while (curr != null) {
            stack.push(curr);

            if (deleteAge == curr.person.age) {
                break;
            }

            prev = curr;

            if ( deleteAge < curr.person.age) {
                curr = curr.left;
                isLeftChild = true;
            } else {
                curr = curr.right;
                isLeftChild = false;
            }
        }

        // Case: the target was not found
        if (curr == null) {
            System.out.println("The target was not found");
            return false;
        }

        // Case: the target has no children (leaf node)
        if (curr.left == null && curr.right == null) {
            if (curr == root) {
                root = null;
            } else if (isLeftChild) {
                prev.left = null;
            } else {
                prev.right = null;
            }
        // Case: the target is not a leaf node    
        } else {
            System.out.println("The target { " + deleteAge + " } is not a leaf node");
            return false;
        }

        return true;
    }


    public boolean search(int age) {
        if (this.root == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(this.root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (current.person.age == age) {
                return true;
            }

            if (age < current.person.age && current.left != null) {
                stack.push(current.left);
            } else if (age > current.person.age && current.right != null) {
                stack.push(current.right);
            }
        }

        return false;
    }
    
}


```  
  
In `main` function perform the following actions:

1. Create a BinarySearchTree object.   
2. Call insert function to build/add the tree in figuer 1.   
3. Call print function to print the tree values.   
4. Output should be the same as below:    
```
print tree values:
 53 23 21 28 34 30 29 32 41
```

```java

 
    public static void main(String[] args) {

     /* Add your code here */

        // 1 - Create a BinarySearchTree object.

        // 2 - Call insert function to build/add the tree in figuer 1.
        
        // 3 - Call print function to print the tree values.
       
        
        

    }


```
