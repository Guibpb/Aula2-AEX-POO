import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * MEGA PROJETO JAVA — V3 GITHUB EDITION
 *
 * Projeto educacional + arcade em múltiplos arquivos.
 * Java 17+
 *
 * Objetivos:
 *  - estudar Java por etapas;
 *  - praticar algoritmos e estruturas de dados;
 *  - jogar minigames para transformar conceitos em prática;
 *  - acompanhar XP, nível, moedas, streak e conquistas;
 *  - manter cada arquivo pequeno o bastante para ser navegável no GitHub.
 *
 * Autor: Rafael Almeida
 */
public class MegaProjetoJava {
    static final Scanner SC = new Scanner(System.in);
    static final Random RNG = new Random();
    static final PlayerProfile PLAYER = new PlayerProfile();
    static final String RESET = "\u001B[0m";
    static final String BOLD = "\u001B[1m";
    static final String CYAN = "\u001B[36m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String MAGENTA = "\u001B[35m";
    static final String RED = "\u001B[31m";
    static final String DIM = "\u001B[2m";

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("--test")) {
            TestSuite.runAll();
            return;
        }
        SaveSystem.load(PLAYER);
        splash();
        mainMenu();
        SaveSystem.save(PLAYER);
        clear();
        banner("ATÉ A PRÓXIMA!");
        System.out.println(GREEN + "Progresso salvo." + RESET);
    }

    static void splash() {
        clear();
        System.out.println(CYAN + "╔══════════════════════════════════════════════════════════════════╗" + RESET);
        System.out.println(CYAN + "║" + BOLD + "             MEGA PROJETO JAVA — V3                    " + CYAN + "║" + RESET);
        System.out.println(CYAN + "║" + RESET + "       ESTUDO + DESAFIOS + ARCADE + PROGRESSÃO         " + CYAN + "║" + RESET);
        System.out.println(CYAN + "╚══════════════════════════════════════════════════════════════════╝" + RESET);
        System.out.println();
        System.out.println("Boas-vindas, " + YELLOW + PLAYER.getName() + RESET + "!");
        System.out.println(DIM + "Use --test para executar a bateria automática de testes." + RESET);
        pause();
    }

    static void mainMenu() {
        while (true) {
            header("CENTRAL PRINCIPAL");
            System.out.println("[1] Academia Java");
            System.out.println("[2] Arcade — 35 minigames");
            System.out.println("[3] Desafios de programação");
            System.out.println("[4] Perfil e progresso");
            System.out.println("[5] Conquistas");
            System.out.println("[6] Loja");
            System.out.println("[7] Missão diária");
            System.out.println("[8] Laboratório de algoritmos");
            System.out.println("[9] Configurações");
            System.out.println("[0] Sair");
            int op = askInt("\nEscolha: ", 0, 9);
            switch (op) {
                case 1 -> StudyEngine.menu();
                case 2 -> Arcade.menu();
                case 3 -> challengeMenu();
                case 4 -> ProfileUI.show();
                case 5 -> ProfileUI.achievements();
                case 6 -> ShopUI.menu();
                case 7 -> DailyMission.play();
                case 8 -> AlgorithmLab.menu();
                case 9 -> settings();
                case 0 -> { return; }
                default -> { }
            }
        }
    }

    static void challengeMenu() {
        while (true) {
            header("DESAFIOS DE PROGRAMAÇÃO");
            System.out.println("[1] Desafio aleatório");
            System.out.println("[2] Desafio por categoria");
            System.out.println("[3] Desafio de entrada/saída");
            System.out.println("[4] Desafio de arrays");
            System.out.println("[5] Desafio de POO");
            System.out.println("[6] Desafio de coleções");
            System.out.println("[7] Desafio de algoritmos");
            System.out.println("[0] Voltar");
            int op = askInt("Escolha: ", 0, 7);
            if (op == 0) return;
            String c = ChallengeBank.get(op);
            if (c == null) c = ChallengeBank.random();
            System.out.println();
            System.out.println(BOLD + c + RESET);
            System.out.println();
            System.out.println("Escreva uma solução no NetBeans e teste com entradas diferentes.");
            PLAYER.lessonReward(10, 3);
            pause();
        }
    }

    static void settings() {
        header("CONFIGURAÇÕES");
        System.out.println("[1] Alterar nome");
        System.out.println("[2] Salvar agora");
        System.out.println("[3] Exportar relatório");
        System.out.println("[0] Voltar");
        int op = askInt("Escolha: ", 0, 3);
        if (op == 1) {
            String name = ask("Novo nome: ").trim();
            if (!name.isBlank()) PLAYER.setName(name);
            SaveSystem.save(PLAYER);
        } else if (op == 2) {
            SaveSystem.save(PLAYER);
            System.out.println(GREEN + "Salvo." + RESET);
            pause();
        } else if (op == 3) {
            SaveSystem.exportReport(PLAYER);
            pause();
        }
    }

    static void header(String title) {
        clear();
        System.out.println(CYAN + "══════════════════════════════════════════════════════════════" + RESET);
        System.out.println(BOLD + CYAN + "  " + title + RESET);
        System.out.println(CYAN + "══════════════════════════════════════════════════════════════" + RESET);
        System.out.println("Jogador: " + YELLOW + PLAYER.getName() + RESET
                + " | Nível " + GREEN + PLAYER.getLevel() + RESET
                + " | XP " + PLAYER.getXp() + "/" + PLAYER.nextLevelXp()
                + " | 💰 " + YELLOW + PLAYER.getCoins() + RESET);
        System.out.println(CYAN + "──────────────────────────────────────────────────────────────" + RESET);
    }

    static void banner(String title) {
        System.out.println(CYAN + "══════════════════════════════════════════════════════════════" + RESET);
        System.out.println(BOLD + "  " + title + RESET);
        System.out.println(CYAN + "══════════════════════════════════════════════════════════════" + RESET);
    }

    static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause() {
        System.out.print(YELLOW + "\nENTER para continuar..." + RESET);
        SC.nextLine();
    }

    static String ask(String prompt) {
        System.out.print(prompt);
        return SC.nextLine();
    }

    static int askInt(String prompt, int min, int max) {
        while (true) {
            String raw = ask(prompt).trim();
            try {
                int value = Integer.parseInt(raw);
                if (value >= min && value <= max) return value;
            } catch (NumberFormatException ignored) { }
            System.out.println(RED + "Digite um número entre " + min + " e " + max + "." + RESET);
        }
    }

    static boolean askYesNo(String prompt) {
        while (true) {
            String s = ask(prompt).trim().toLowerCase(Locale.ROOT);
            if (s.equals("s") || s.equals("sim")) return true;
            if (s.equals("n") || s.equals("nao") || s.equals("não")) return false;
            System.out.println("Digite S ou N.");
        }
    }
}
