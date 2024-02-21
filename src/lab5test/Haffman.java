package lab5test;

import java.util.*;
import java.util.stream.*;

// Класс, представляющий узел дерева Хаффмена
class Node implements Comparable<Node> {
    char ch; // символ
    int freq; // частота
    Node left; // левый потомок
    Node right; // правый потомок

    // Конструктор для листового узла
    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    // Конструктор для внутреннего узла
    Node(Node left, Node right) {
        this.ch = '\0'; // пустой символ
        this.freq = left.freq + right.freq; // сумма частот потомков
        this.left = left;
        this.right = right;
    }

    // Сравнение узлов по частоте
    @Override
    public int compareTo(Node o) {
        return this.freq - o.freq;
    }
}

// Класс, реализующий алгоритм Хаффмена
class Huffman {

    // Метод, который строит дерево Хаффмена из текста
    public static Node buildTree(String text) {
        // Подсчитываем частоту каждого символа в тексте
        Map<Character, Integer> freqMap = text.chars()
                .mapToObj(c -> (char) c) // преобразуем int в char
                .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));

        // Создаем приоритетную очередь из узлов, сортируя их по частоте
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Пока в очереди больше одного узла, объединяем два узла с наименьшей частотой в один
        while (queue.size() > 1) {
            Node left = queue.poll(); // извлекаем узел с наименьшей частотой
            Node right = queue.poll(); // извлекаем следующий узел с наименьшей частотой
            queue.add(new Node(left, right)); // добавляем новый узел, который является их родителем
        }

        // Возвращаем корень дерева
        return queue.peek();
    }

    // Метод, который строит кодовую таблицу из дерева Хаффмена
    public static Map<Character, String> buildCodeTable(Node root) {
        Map<Character, String> codeTable = new HashMap<>();
        buildCodeTable(root, "", codeTable); // вызываем рекурсивный метод
        return codeTable;
    }

    // Рекурсивный метод, который обходит дерево Хаффмена и заполняет кодовую таблицу
    private static void buildCodeTable(Node node, String code, Map<Character, String> codeTable) {
        if (node == null) return; // базовый случай
        if (node.ch != '\0') { // если узел является листом, добавляем его код в таблицу
            codeTable.put(node.ch, code);
        } else { // если узел является внутренним, рекурсивно обходим его потомков
            buildCodeTable(node.left, code + "0", codeTable); // добавляем 0 к коду для левого потомка
            buildCodeTable(node.right, code + "1", codeTable); // добавляем 1 к коду для правого потомка
        }
    }

    // Метод, который сжимает текст, используя кодовую таблицу
    public static String compress(String text, Map<Character, String> codeTable) {
        // Преобразуем каждый символ текста в его код и объединяем их в одну строку
        return text.chars()
                .mapToObj(c -> codeTable.get((char) c)) // получаем код для каждого символа
                .collect(Collectors.joining()); // объединяем коды в одну строку
    }

    // Метод, который распаковывает текст, используя дерево Хаффмена
    public static String decompress(String compressed, Node root) {
        StringBuilder sb = new StringBuilder(); // буфер для хранения распакованного текста
        Node node = root; // текущий узел, начинаем с корня
        for (char ch : compressed.toCharArray()) { // для каждого символа сжатого текста
            if (ch == '0') { // если символ равен 0, переходим к левому потомку
                node = node.left;
            } else { // если символ равен 1, переходим к правому потомку
                node = node.right;
            }
            if (node.ch != '\0') { // если узел является листом, добавляем его символ к буферу
                sb.append(node.ch);
                node = root; // возвращаемся к корню
            }
        }
        return sb.toString(); // возвращаем распакованный текст
    }

    // Метод, который выводит на экран коды для каждого слова и закодированный текст
    public static void display(String text, Map<Character, String> codeTable, String compressed) {
        // Разбиваем текст на слова по пробелам
        String[] words = text.split(" ");
        // Для каждого слова выводим его код, составленный из кодов его символов
        for (String word : words) {
            System.out.print(word + ": ");
            for (char ch : word.toCharArray()) {
                System.out.print(codeTable.get(ch));
            }
            System.out.println();
        }
        // Выводим закодированный текст
        System.out.println("Compressed text: " + compressed);
    }

    // Главный метод, который запускает программу
    public static void main(String[] args) {
        // Тестовый текст
        String text = "this is an example of a huffman tree";
        // Строим дерево Хаффмена
        Node root = buildTree(text);
        // Строим кодовую таблицу
        Map<Character, String> codeTable = buildCodeTable(root);
        // Сжимаем текст
        String compressed = compress(text, codeTable);
        // Распаковываем текст
        String decompressed = decompress(compressed, root);
        // Выводим результаты
        display(text, codeTable, compressed);
        System.out.println("Decompressed text: " + decompressed);
    }
}
