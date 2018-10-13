package cn.itcast.demo.tree;

public class SearchTree {
    private Node root;


    public void insertNode(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Node temp = root;
        while (true) {
            if (data >= temp.getData()) {
                if (temp.getRight() != null) {
                    temp = temp.getRight();
                    continue;
                }
                temp.setRight(newNode);
                return;
            } else {
                if (temp.getLeft() != null) {
                    temp = temp.getLeft();
                    continue;
                }
                temp.setLeft(newNode);
                return;
            }
        }
    }

    public void buildTree(int... data) {
        for (int n : data) {
            insertNode(n);
        }
    }

    private void beforePrint(Node tree) {
        if (tree != null) {
            System.out.print(tree.getData() + " ");
            beforePrint(tree.getLeft());
            beforePrint(tree.getRight());
        }
    }


    private void midPrint(Node tree) {
        if (tree != null) {
            midPrint(tree.getLeft());
            System.out.print(tree.getData() + " ");
            midPrint(tree.getRight());
        }
    }

    private void afterPrint(Node tree) {
        if (tree != null) {
            afterPrint(tree.getLeft());
            afterPrint(tree.getRight());
            System.out.print(tree.getData() + " ");
        }
    }


    public void beforePrint() {
        this.beforePrint(this.root);
    }

    public void midPrint() {
        this.midPrint(this.root);
    }

    private void afterPrint() {
        this.afterPrint(this.root);
    }



    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();
        searchTree.buildTree(10,8,13,5,6,9,12,14);

    }


}
