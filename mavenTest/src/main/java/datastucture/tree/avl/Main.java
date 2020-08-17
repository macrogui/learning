package datastucture.tree.avl;

import datastucture.set.FileOperation;
import datastucture.tree.bst.BST02;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("D:\\实习\\test\\mavenTest\\src\\main\\java\\datastucture\\set\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);
//
//            // Test BST
//            long startTime = System.nanoTime();
//
//            BST02<String, Integer> bst = new BST02<>();
//            for (String word : words) {
//                if (bst.contains(word))
//                    bst.set(word, bst.get(word) + 1);
//                else
//                    bst.add(word, 1);
//            }
//
//            for(String word: words)
//                bst.contains(word);
//
//            long endTime = System.nanoTime();
//
//            double time = (endTime - startTime) / 1000000000.0;
//            System.out.println("BST: " + time + " s");
//

            // Test AVL Tree
            long startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for(String word: words)
                avl.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
        }

        System.out.println();
    }
}
