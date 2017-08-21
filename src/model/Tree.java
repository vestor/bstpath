package model;

import java.util.*;

/**
 * Created by manish on 18/08/17.
 */
public class Tree {

    private Node rootNode;
    private List<Node> path = new ArrayList<>();
    private boolean areBothFound = false;


    public void printPath(int sourceNode, int destinationNode) {
        if(pathBetweenNodes(this.rootNode, sourceNode, destinationNode)) {
            System.out.println(path);
        } else {
            System.out.println("No path exists");
        }
    }

    private boolean pathBetweenNodes(Node root, int sourceNode, int destinationNode) {
        if(root == null) {
            return false;
        }

        if (sourceNode == root.getData() || destinationNode == root.getData()) {
            path.add(root);
            if(!areBothFound) {
                areBothFound = findDown(root, root.getData() == sourceNode ? destinationNode : sourceNode);
            }
            return true;
        }
        if(!areBothFound) {
            boolean foundInLeft = pathBetweenNodes(root.getLeft(), sourceNode, destinationNode);
            if(foundInLeft) {
                path.add(root);
            }
            boolean foundInRight = pathBetweenNodes(root.getRight(), sourceNode, destinationNode);
            if(foundInRight) {
                path.add(root);
            }
            return foundInLeft || foundInRight;
        } else {
            return true;
        }
    }

    private boolean findDown(Node root, int data) {
        if(root == null) {
            return false;
        }
        if(root.getData() == data) {
            path.add(root);
            return true;
        }
        boolean foundInLeft = findDown(root.getLeft(), data);
        if(foundInLeft) {
            path.add(root);
            return true;
        }
        boolean foundInRight = findDown(root.getRight(), data);
        if(foundInRight) {
            path.add(root);
            return true;
        }
        return false;
    }

    public Tree(Integer integerList[]) {
        this.rootNode = new Node(integerList[0]);
        Queue<Node>  queue = new LinkedList<>();
        queue.add(rootNode);
        constructTree(queue, integerList);
    }

    private void constructTree(Queue<Node> queue, Integer integers[]) {
        int counter = 1;
        while(!queue.isEmpty() && counter < integers.length) {
            Node node = queue.peek();

            if (node.getLeft() == null ) {
                Node left = new Node(integers[counter]);
                node.setLeft(left);
                queue.add(left);
            } else {
                Node right = new Node(integers[counter]);
                node.setRight(right);
                queue.add(right);
                queue.remove(node);
            }
            counter++;
        }
    }
}
