package lab5;
//Используя Collection Framework (соответствующий интерфейс и Stream API):
//Написать программу, осуществляющую сжатие английского текста.
// Построить для каждого слова в тексте оптимальный префиксный код по алгоритму Хаффмена.
// Использовать класс PriorityQueue.
// Вывести на экран коды для каждого слова и закодированный текст.

import java.io.*;
import java.util.PriorityQueue;

import java.util.*;

class Node {
    String word;
    int frequency;
    Node left;
    Node right;

    public Node(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
}

public class Main {
    public static void main(String[] args) {
        String text = "Peek shook leak";

        // Заполните wordFrequency частотами слов
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = text.split(" ");
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node combined = new Node(left.word + right.word, left.frequency + right.frequency);
            combined.left = left;
            combined.right = right;
            pq.offer(combined);
        }

        Node root = pq.poll();
        Map<String, String> wordToCode = new HashMap<>();
        generateCodes(root, "", wordToCode);

        // Замените слова в тексте их кодами
        String encodedText = encodeText(text, wordToCode);
        System.out.println("Закодированный текст: " + encodedText);
    }

    private static void generateCodes(Node node, String code, Map<String, String> wordToCode) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            wordToCode.put(node.word, code);
            return;
        }
        generateCodes(node.left, code + "0", wordToCode);
        generateCodes(node.right, code + "1", wordToCode);
    }

    private static String encodeText(String text, Map<String, String> wordToCode) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split("\\s+");
        for (String word : words) {
            result.append(wordToCode.getOrDefault(word, word)).append(" ");
        }
        return result.toString().trim();
    }
}

