package com.bernard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeWithLevelOrderTraversal<T extends Comparable<T>> {
    private Node root;
    public Integer numberOfSwaps = 0;
    final List<Node> list = new ArrayList<>();

    private class Node {
        T data;
        Node left;
        Node right;

        private Node(T data) {
            this.data = data;
        }
    }

    private Node doInsert(T data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        int result = data.compareTo(node.data);

        if (result < 0) {
            node.left = doInsert(data, node.left);
        } else if (result > 0) {
            node.right = doInsert(data, node.right);
        }

        return node;
    }

    public void insert(T data) {
        root = doInsert(data, root);
    }


    //For the main(); enter data as array in order to populate the insert()
    public void collector(T[] argsArr) {
        for (T data : argsArr) {
            insert(data);
        }
    }

    //For the first while statement in doLevelOrderTraversal method, to compare list with the desired output.
    public List<T> getDataFromNode(List<Node> list) {
        List<T> listOfData = new ArrayList<>();
        for (Node node : list) {
            listOfData.add(node.data);
        }
        return listOfData;
    }

    private List<T> doLevelOrderTraversal(Node root) {
        final Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int noOfElementsAtThisLevel = queue.size();
            for (int index = 0; index < noOfElementsAtThisLevel; index++) {
                Node tmp = queue.poll();
                if (list.size() == 0) {
                    list.add(tmp);
                } else {
                    if (list.get(list.size() - 1).data.compareTo(tmp.data) > 0) {
                        numberOfSwaps++;
                        Node temp = list.get(list.size() - 1);
                        Node newData = tmp;
                        list.set(list.size() - 1, newData);
                        list.add(temp);
                    } else {
                        list.add(tmp);
                    }
                }

                //System.out.println(tmp.data + " ");
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            //System.out.println();
        }
        //System.out.println(getDataFromNode(list));
        return getDataFromNode(list);
    }


    /*Useful to clear reference memory.
     **Avoids creating more than an instance whenever levelOrderTraversal() is called.
     */
    public void clearListAndRoot() {
        list.clear();
        root = null;
    }

    public List<T> levelOrderTraversal() {
        return doLevelOrderTraversal(root);
    }

    public boolean compareListAndArray(List list, Integer[] arr) {
        boolean comp = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == arr[i]) {
                comp = comp && true;
            } else {
                comp = comp && false;
            }
        }
        return comp;
    }
}
