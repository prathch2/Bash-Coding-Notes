/****************************************************************************
 * BinSearchTree.java
 ****************************************************************************
 * This is a class that utilizes the Bridges API to create a Binary Search Tree that adds, removes, and traverses through
 * the tree to get specific values in a specific order. The BinTreeInterface implements the methods add, remove, GetRoot,
 * isEmpty, clear, search, inOrder, postOrder, and preOrder. In addition four other methods are added (height, isFullBST,
 * getNumberOfLeaves, getNumberOfNonLeaves) to analyze components of the tree. Overall, each method performs specific actions
 * that allow you to modify and traverse through the binary Search tree. Recursions methods were added to help solve complex
 * traversals and methods. Comments are shown for each recursion method.
 *_____________________________________________________
 * Pratham Choksi
 * 04/09/2021
 * CMSC 256-004
 ****************************************************************************/

package cmsc256;

import bridges.base.BinTreeElement;
import bridges.connect.Bridges;

public class BinSearchTree<E extends Comparable<E>> implements BinTreeInterface<E> {
    private BinTreeElement<E> root;
    private int size;

    public BinSearchTree() {
        clear();
    }

    public BinSearchTree(BinTreeElement<E> newNode) {
        root = newNode;
        size = 1;
    }


    @Override
    public BinTreeElement<E> getRoot() {
        return root;
    }

    @Override
    public boolean add(E element) {
        BinTreeElement<E> node = new BinTreeElement<>(element);
        boolean wasAdded = true;
        if (root == null) {
            root = node;
        } else {
            wasAdded = addToParent(root, node);
        } if (wasAdded) {
            size++;
        }
        return wasAdded;
    }

    //A recursion methods that adds a node to the parent node in a tree. This code is implements into the add method
    //in order to be able to add an element to the right place in the tree.
    private boolean addToParent(BinTreeElement<E> parentNode, BinTreeElement<E> addNode) {
        int compare = parentNode.getValue().compareTo(addNode.getValue());
        boolean wasAdded = false;
        if (compare > 0) {
            // if parent has no left node, add new node as left
            if (parentNode.getLeft() == null) {
                parentNode.setLeft(addNode);  // fill in this blank
                wasAdded = true;
            }
            else {
                // otherwise, add to parentNode's left (recursive)
                wasAdded = addToParent(parentNode.getLeft(), addNode);
            }
        }
        else if (compare < 0) {
            // if parent has no right node, add new node as right
            if (parentNode.getRight() == null) {
                parentNode.setRight(addNode);
                wasAdded = true;
            }
            else {
                // otherwise, add to parentNode's right (recursive)
                wasAdded = addToParent(parentNode.getRight(), addNode);
            }
        }
        return wasAdded;
    }

    @Override
    public boolean remove(E element) {
        if (root == null) {
            return false;
        }
        if (root.getValue().compareTo(element) == 0) {
            if (root.getLeft() == null) {
                root = root.getRight();
            }
            else if (root.getRight() == null) {
                root = root.getLeft();
            }
            else {
                BinTreeElement<E> formerRight = root.getRight();
                root = root.getLeft();
                addToParent(root, formerRight);
            }
            size--;
            return true;
        }
        return removeSubNode(root, element);
    }

    //A recursion methods that removes a node from the parent node in a tree. This code is implements into the remove method
    //in order to be able to remove an element and shift nodes to the right place in the tree.
    private boolean removeSubNode(BinTreeElement<E> parent, E removeValue) {
        int compareParent = parent.getValue().compareTo(removeValue);
        BinTreeElement<E> subTree = null;
        if (compareParent > 0) {
            subTree = parent.getLeft();
        } else {
            subTree = parent.getRight();
        }
        if (subTree == null) {
            return false;
        }
        if (subTree.getValue().compareTo(removeValue) == 0) {
            BinTreeElement<E> replacement;
            if (subTree.getLeft() == null) {
                replacement = subTree.getRight();
            }
            else if (subTree.getRight() == null) {
                replacement = subTree.getLeft();
            }
            else {
                BinTreeElement<E> formerRight = subTree.getRight();
                replacement = subTree.getLeft();
                addToParent(replacement, formerRight);
            }
            if (compareParent > 0) {
                parent.setLeft(replacement);
            }
            else {
                parent.setRight(replacement);
            }
            size--;
            return true;
        }
        return removeSubNode(subTree, removeValue);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(root == null) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean search(E target) {
        return findRecursive(root, target) == target;
    }

    //This methods is a recursive search methods that recursively goes through the tree. This method is then
    // implemented into the search method to help find a specific target in the tree.
    private Comparable<E> findRecursive(BinTreeElement<E> root, E element) {
        if(root == null) {
            return null;
        }
        if(root.getValue().compareTo(element) > 0) {
            return findRecursive(root.getLeft(), element);
        } else if (root.getValue().compareTo(element) == 0) {
            return root.getValue();
        } else return findRecursive(root.getRight(), element);
    }


    @Override
    public String inorder() {
        return inOrder(root);
    }

    //This a recursive search method, specifically that traverses from Left, Root, Right.
    // This method is implemented in the inorder method to return the the node elements in a unique order.
    private String inOrder(BinTreeElement<E> node) {
        StringBuilder result = new StringBuilder();
        if(node != null) {
            result.append(inOrder(node.getLeft()));
            result.append(node.getValue()).append("  ");
            result.append(inOrder(node.getRight()));
        }
        String string = result.toString();
        return string;
    }

    @Override
    public String postorder() {
        return postOrder(root);
    }

    //This a recursive search method, specifically that traverses from Root, Left, Right.
    // This method is implemented in the postorder method to return the the node elements in a unique order.
    private String postOrder(BinTreeElement<E> node) {
        StringBuilder result = new StringBuilder();
        if(node != null) {
            result.append(postOrder(node.getLeft()));
            result.append(postOrder(node.getRight()));
            result.append(node.getValue()).append("  ");
        }
        String string = result.toString();
        return string;
    }

    @Override
    public String preorder() {
       return preOrder(root);
    }

    //This a recursive search method, specifically that traverses from Left, Right, Root.
    // This method is implemented in the preorder method to return the the node elements in a unique order.
    private String preOrder(BinTreeElement<E> node) {
        StringBuilder result = new StringBuilder();
        if (node != null) {
            result.append(node.getValue()).append("  ");
            result.append(preOrder(node.getLeft()));
            result.append(preOrder(node.getRight()));
        }
        String string = result.toString();
        return string;
    }

    public int height() {
        if(isEmpty()){
            return -1;
        } else if (root.getLeft() == null && root.getRight() == null) {
            return 0;
        }
        else {
            return heightRecursive(root);
        }
    }

    //this recursive method find the heigh of the tree by recursively going through each node in the tree.
    //It is implemented into the height method to return the proper height of the BST.
    int heightRecursive(BinTreeElement<E> node) {
        if (node == null) {
            return -1;
        }
        if (heightRecursive(node.getLeft()) > heightRecursive(node.getRight())) {
            return heightRecursive(node.getLeft()) + 1;
        } else {
            return heightRecursive(node.getRight()) + 1;
        }
    }

    public boolean isFullBST() {
        return isFullRecursive(root);
    }

    //this recursive method finds whether the tree is full by recursively going through each node in the tree.
    //this method is implemented into isFullBST to help solve whether the tree is full in a faster and easier way.
    private boolean isFullRecursive(BinTreeElement<E>  node) {
        if(node == null) {
            return false;
        }
        if(node.getLeft() == null && node.getRight() == null) {
            return true;
        }
        if(node.getNumberOfChildren() == 1) {
            return false;
        }
        boolean result = isFullRecursive(root.getLeft());
        boolean result2 = isFullRecursive(root.getRight());

        return result && result2;
    }

    public int getNumberOfLeaves() {
        return getNumberOfLeavesRecursion(root);
    }

    //this recursive method finds the number of leaves in the tree by recursively going through each node in the tree.
    //this method is implemented into getNumberOfLeaves to help solve the number of leaves in a faster and easier way.
    private int getNumberOfLeavesRecursion(BinTreeElement<E> node) {
        if(node == null) {
            return 0;
        }

        if(node.getNumberOfChildren() == 0) {
            return 1;
        } else {
            return getNumberOfLeavesRecursion(node.getLeft()) + getNumberOfLeavesRecursion(node.getRight());
        }
    }

    public int getNumberOfNonLeaves() {
        return getNumberOfNonLeavesRecursion(root);
    }

    //this recursive method finds the number of non leaves in the tree by recursively going through each node in the tree.
    //this method is implemented into getNumberOfNonLeaves to help solve the number of non leaves in a faster and easier way.
    private int getNumberOfNonLeavesRecursion(BinTreeElement<E> node) {
        if(node == null) {
            return 0;
        }
        if(node.getLeft() != null || node.getRight() != null) {
            return 1 + getNumberOfNonLeavesRecursion(node.getLeft()) + getNumberOfNonLeavesRecursion(node.getRight());
        }
        return 0;
    }

    public static void main(String[] args) {
        Bridges bridges = new Bridges(4, "prathch2", "981657926324");
        BinSearchTree <String> names = new BinSearchTree<>();

        names.add("Frodo");

        names.add("Dori");

        names.add("Bilbo");

        names.add("Kili");

        names.add("Gandalf");

        names.add("Fili");

        names.add("Thorin");

        names.add("Nori ");

        System.out.println(names);

        bridges.setDataStructure(names.root);
        try {
            bridges.visualize();
        }
        catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
