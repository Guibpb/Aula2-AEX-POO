import java.util.*;
import java.util.stream.*;

public final class AlgorithmLab {
    private AlgorithmLab() { }

    public static void menu() {
        while (true) {
            MegaProjetoJava.header("LABORATÓRIO DE ALGORITMOS");
            System.out.println("[1] Gerar e ordenar");
            System.out.println("[2] Busca linear vs binária");
            System.out.println("[3] Contagem de frequência");
            System.out.println("[4] Filtro com Stream");
            System.out.println("[5] Fibonacci iterativo");
            System.out.println("[6] Fibonacci recursivo");
            System.out.println("[7] Primalidade");
            System.out.println("[8] Complexidade demonstrada");
            System.out.println("[0] Voltar");
            int op = MegaProjetoJava.askInt("Escolha: ", 0, 8);
            if (op == 0) return;
            switch (op) {
                case 1 -> sortingDemo();
                case 2 -> searchDemo();
                case 3 -> frequencyDemo();
                case 4 -> streamDemo();
                case 5 -> fibIterative();
                case 6 -> fibRecursive();
                case 7 -> primeDemo();
                case 8 -> complexityDemo();
            }
        }
    }

    private static void sortingDemo() {
        int n = 10;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = MegaProjetoJava.RNG.nextInt(100);
        System.out.println("Antes: " + Arrays.toString(data));
        Arrays.sort(data);
        System.out.println("Depois: " + Arrays.toString(data));
        MegaProjetoJava.pause();
    }

    private static void searchDemo() {
        int[] data = IntStream.range(0, 1000).map(i -> i * 2).toArray();
        int target = MegaProjetoJava.askInt("Alvo par: ", 0, 1998);
        int linear = linearSearch(data, target);
        int binary = Arrays.binarySearch(data, target);
        System.out.println("Linear índice: " + linear);
        System.out.println("Binária índice: " + binary);
        MegaProjetoJava.pause();
    }

    private static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) if (data[i] == target) return i;
        return -1;
    }

    private static void frequencyDemo() {
        List<String> words = List.of("java", "poo", "java", "array", "java", "poo");
        Map<String, Integer> freq = new TreeMap<>();
        for (String word : words) freq.merge(word, 1, Integer::sum);
        System.out.println(freq);
        MegaProjetoJava.pause();
    }

    private static void streamDemo() {
        List<Integer> values = IntStream.rangeClosed(1, 20).boxed().toList();
        List<Integer> result = values.stream().filter(v -> v % 2 == 0).map(v -> v * v).toList();
        System.out.println("Pares ao quadrado: " + result);
        MegaProjetoJava.pause();
    }

    private static void fibIterative() {
        int n = MegaProjetoJava.askInt("n (0-30): ", 0, 30);
        System.out.println("Fibonacci = " + fib(n));
        MegaProjetoJava.pause();
    }

    private static void fibRecursive() {
        int n = MegaProjetoJava.askInt("n (0-25): ", 0, 25);
        System.out.println("Fibonacci = " + fibRecursiveImpl(n));
        MegaProjetoJava.pause();
    }

    private static long fib(int n) {
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) { long next = a + b; a = b; b = next; }
        return a;
    }

    private static long fibRecursiveImpl(int n) {
        if (n <= 1) return n;
        return fibRecursiveImpl(n - 1) + fibRecursiveImpl(n - 2);
    }

    private static void primeDemo() {
        int n = MegaProjetoJava.askInt("Número: ", 0, 1000000);
        System.out.println(n + (isPrime(n) ? " é primo." : " não é primo."));
        MegaProjetoJava.pause();
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; (long) i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }

    private static void complexityDemo() {
        int n = MegaProjetoJava.askInt("n (1-2000): ", 1, 2000);
        long linear = n;
        long quadratic = (long) n * n;
        long logarithmic = 0;
        int x = n;
        while (x > 1) { x /= 2; logarithmic++; }
        System.out.println("Modelo O(1): 1");
        System.out.println("Modelo O(log n): " + logarithmic);
        System.out.println("Modelo O(n): " + linear);
        System.out.println("Modelo O(n²): " + quadratic);
        MegaProjetoJava.pause();
    }
}
