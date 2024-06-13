import java.util.Stack;

class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class Node {

    Person person;
    Node right;
    Node left;

    public Node(Person person) {
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

            if (deleteAge < curr.person.age) {
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

    public static void main(String[] args) {

         BinarySearchTree b1 = new BinarySearchTree();

        
        b1.insert(new Person("ahmad", 53));
        b1.insert(new Person("mohammed", 23));
        b1.insert(new Person("maha", 21));
        b1.insert(new Person("abeer", 28));
        b1.insert(new Person("rashed", 34));
        b1.insert(new Person("fahad", 30));
        b1.insert(new Person("hanouf", 44));
        b1.insert(new Person("fatima", 32));
        b1.insert(new Person("ali", 29));
        
        
       b1.print();

    }

}
