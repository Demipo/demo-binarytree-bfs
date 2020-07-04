package com.bernard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        WordsToNumbers words = new WordsToNumbers();

        System.out.println("\n<========================================>\n");
        System.out.println("Enter the desired output");
        Integer[] output = words.output(scan.nextLine().toUpperCase());
        System.out.println("Enter the input");
        Integer[] input = words.input(scan.nextLine().toUpperCase());

        Integer treeCounter = 1;

        List<Integer> list = new ArrayList<>();
        final BinaryTreeWithLevelOrderTraversal<Integer> binaryTree = new BinaryTreeWithLevelOrderTraversal<>();

        Integer arr[] = input;
        binaryTree.collector(arr);
        list = binaryTree.levelOrderTraversal();
        binaryTree.clearListAndRoot();

        while (!binaryTree.compareListAndArray(list, output)) {
            treeCounter++;
            binaryTree.collector(list.toArray(new Integer[]{}));
            list = binaryTree.levelOrderTraversal();
            binaryTree.clearListAndRoot();
        }
        System.out.println("\n<========================================>\n");
        System.out.println(binaryTree.numberOfSwaps + " adjacent words were swapped.");
        System.out.println(treeCounter + " binary trees were formed.");
        System.out.println("The final order of the word " + list);
    }
}
