import java.util.*;

public final class ProfileUI {
    private static final String[] ACHIEVEMENTS = {
        "Primeiro passo", "10 lições", "50 lições", "100 lições", "500 lições",
        "Nível 5", "Nível 10", "Nível 20", "10 vitórias", "50 vitórias",
        "Streak 5", "Streak 10", "Primeiro item", "1000 moedas"
    };

    private ProfileUI() { }

    public static void show() {
        MegaProjetoJava.header("PERFIL");
        PlayerProfile p = MegaProjetoJava.PLAYER;
        System.out.println("Nome: " + p.getName());
        System.out.println("Nível: " + p.getLevel());
        System.out.println("XP: " + p.getXp() + "/" + p.nextLevelXp());
        System.out.println("Moedas: " + p.getCoins());
        System.out.println("Partidas: " + p.getGames());
        System.out.println("Vitórias: " + p.getWins());
        System.out.println("Lições: " + p.getLessons());
        System.out.println("Streak: " + p.getStreak());
        System.out.println("Melhor streak: " + p.getBestStreak());
        System.out.println("Pontos de estudo: " + p.getStudyPoints());
        System.out.println("Itens: " + p.getInventory());
        MegaProjetoJava.pause();
    }

    public static void achievements() {
        MegaProjetoJava.header("CONQUISTAS");
        PlayerProfile p = MegaProjetoJava.PLAYER;
        for (String a : ACHIEVEMENTS) {
            String mark = p.hasAchievement(a) ? MegaProjetoJava.GREEN + "✓" : MegaProjetoJava.DIM + "·";
            System.out.println(mark + MegaProjetoJava.RESET + " " + a);
        }
        MegaProjetoJava.pause();
    }
}
