import java.util.*;
import java.util.stream.*;

/** Motor da Academia Java. */
public final class StudyEngine {
    private static final List<Runnable> LESSONS = LessonRegistry.build();
    private StudyEngine() { }

    public static int lessonCount() { return LESSONS.size(); }

    public static void menu() {
        while (true) {
            MegaProjetoJava.header("ACADEMIA JAVA — " + lessonCount() + " LIÇÕES");
            System.out.println("[1] Lição aleatória");
            System.out.println("[2] Lição por número");
            System.out.println("[3] Trilha por tópico");
            System.out.println("[4] Maratona de 5 lições");
            System.out.println("[5] Revisão inteligente");
            System.out.println("[6] Estatísticas de estudo");
            System.out.println("[0] Voltar");
            int op = MegaProjetoJava.askInt("Escolha: ", 0, 6);
            if (op == 0) return;
            switch (op) {
                case 1 -> runRandom();
                case 2 -> runById();
                case 3 -> topicMenu();
                case 4 -> marathon();
                case 5 -> smartReview();
                case 6 -> stats();
            }
        }
    }

    public static void run(int id) {
        if (id < 1 || id > LESSONS.size()) {
            System.out.println(MegaProjetoJava.RED + "Lição inexistente." + MegaProjetoJava.RESET);
            MegaProjetoJava.pause();
            return;
        }
        LESSONS.get(id - 1).run();
        MegaProjetoJava.PLAYER.lessonReward(15, 5);
        SaveSystem.save(MegaProjetoJava.PLAYER);
    }

    private static void runRandom() { run(1 + MegaProjetoJava.RNG.nextInt(LESSONS.size())); }

    private static void runById() { run(MegaProjetoJava.askInt("Número da lição: ", 1, LESSONS.size())); }

    private static void topicMenu() {
        MegaProjetoJava.header("TRILHAS");
        for (int i = 0; i < LessonRegistry.TOPICS.length; i++) {
            System.out.printf("%2d - %s%n", i + 1, LessonRegistry.TOPICS[i]);
        }
        int topic = MegaProjetoJava.askInt("Tópico: ", 1, LessonRegistry.TOPICS.length) - 1;
        int start = topic * 100 + 1;
        int id = start + MegaProjetoJava.RNG.nextInt(100);
        run(id);
    }

    private static void marathon() {
        for (int i = 0; i < 5; i++) runRandom();
    }

    private static void smartReview() {
        int base = Math.max(1, MegaProjetoJava.PLAYER.getLessons() % LESSONS.size());
        for (int i = 0; i < 3; i++) run(((base + i * 137) % LESSONS.size()) + 1);
    }

    private static void stats() {
        MegaProjetoJava.header("ESTATÍSTICAS DE ESTUDO");
        System.out.println("Total de lições disponíveis: " + LESSONS.size());
        System.out.println("Lições concluídas: " + MegaProjetoJava.PLAYER.getLessons());
        System.out.println("Pontos de estudo: " + MegaProjetoJava.PLAYER.getStudyPoints());
        System.out.println("Progresso aproximado: " +
                (100.0 * MegaProjetoJava.PLAYER.getLessons() / LESSONS.size()) + "%");
        MegaProjetoJava.pause();
    }
}
