package model;

/**
 * Created by manish on 18/08/17.
 */
public class Node {
    int data;
    Node left, right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    Node(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (data != node.data) return false;
        if (left != null ? !left.equals(node.left) : node.left != null) return false;
        return right != null ? right.equals(node.right) : node.right == null;

    }

    @Override
    public int hashCode() {
        int result = data;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(data);
        return sb.toString();
    }
}
