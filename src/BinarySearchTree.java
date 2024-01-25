import java.util.Stack;

class Person {

    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    
}


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
        // } else if (curr.left == null) {
        //     if (curr == root) {
        //         root = curr.right;
        //     } else if (isLeftChild) {
        //         prev.left = curr.right;
        //     } else {
        //         prev.right = curr.right;
        //     }
        // } else if (curr.right == null) {
        //     if (curr == root) {
        //         root = curr.left;
        //     } else if (isLeftChild) {
        //         prev.left = curr.left;
        //     } else {
        //         prev.right = curr.left;
        //     }
        // } else {
        //     Node successor = findSuccessor(curr);
        //     curr.val = successor.val;
        //     if (isLeftChild) {
        //         prev.left = deleteNode(curr.left, successor);
        //     } else {
        //         prev.right = deleteNode(curr.right, successor);
        //     }
        // }

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


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(new Person("Ahmed", 53));
        bst.insert(new Person("Mohammed", 23));
        bst.insert(new Person("Abeer", 28));
        bst.insert(new Person("Rashed", 34));
        bst.insert(new Person("Fahad", 30));
        bst.insert(new Person("Maha", 21));
        bst.insert(new Person("Hanouf", 41));
        bst.insert(new Person("Fatima", 32));
        bst.insert(new Person("Ali", 29));


        System.out.println("\nprint tree values:");
        bst.print();

        int deleteTerget = 53;
        bst.delete(deleteTerget);

        System.out.println("\nAfter deletion of " + deleteTerget + ":");
        bst.print();

        int searchTarget = 14;
        System.out.println("\nWas the serach target: { " + searchTarget + " } found?" );
        System.out.println(bst.search(searchTarget));

        

    }
    
}