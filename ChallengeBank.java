import java.util.*;

/** Banco textual de desafios para transformar estudo em prática. */
public final class ChallengeBank {
    private static final List<String> ALL = List.of(
        "Crie um programa que leia três inteiros e mostre o maior.",
        "Leia uma palavra e conte quantas vogais aparecem nela.",
        "Receba dez números e calcule a média.",
        "Crie uma função que retorne true quando um número for primo.",
        "Implemente busca binária em um array ordenado.",
        "Modele uma classe Produto com validação de preço.",
        "Crie uma hierarquia Animal -> Cachorro -> Gato.",
        "Modele uma interface Pagavel e implemente duas classes.",
        "Use HashMap para contar frequência de palavras.",
        "Use Stream para filtrar números pares e somá-los.",
        "Leia um arquivo e conte suas linhas.",
        "Crie um menu usando switch e enum.",
        "Implemente uma pilha usando Deque.",
        "Implemente uma fila usando ArrayDeque.",
        "Compare busca linear e busca binária com contadores.",
        "Escreva um método recursivo para calcular potência.",
        "Implemente seleção ou inserção e compare com Arrays.sort.",
        "Crie um sistema simples de cadastro usando ArrayList.",
        "Crie exceção própria para uma regra de negócio.",
        "Use LocalDate para calcular idade aproximada em anos.",
        "Crie um contador thread-safe com AtomicInteger.",
        "Use ExecutorService para executar três tarefas.",
        "Escreva testes de casos de borda para seu algoritmo.",
        "Refatore um método grande em três responsabilidades.",
        "Explique em comentários por que um algoritmo é O(n²)."
    );

    private ChallengeBank() { }

    public static String random() { return ALL.get(MegaProjetoJava.RNG.nextInt(ALL.size())); }

    public static String get(int option) {
        return switch (option) {
            case 1 -> random();
            case 2 -> "Escolha um tema e escreva um exercício próprio antes de programar.";
            case 3 -> "Leia nome, idade e nota; valide a entrada e mostre um resumo.";
            case 4 -> "Receba um array, encontre mínimo, máximo, soma e média.";
            case 5 -> "Modele uma classe Personagem com atributos privados e um método atacar().";
            case 6 -> "Crie um catálogo usando List, Set e Map e justifique cada escolha.";
            case 7 -> "Implemente e compare duas soluções para o mesmo problema.";
            default -> null;
        };
    }
}
