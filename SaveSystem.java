import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/** Persistência simples, deliberadamente legível para estudo. */
public final class SaveSystem {
    private static final Path SAVE = Paths.get(System.getProperty("user.home"), ".mega_java_v3.properties");
    private SaveSystem() { }

    public static void save(PlayerProfile p) {
        Properties props = new Properties();
        props.setProperty("name", p.getName());
        props.setProperty("level", Integer.toString(p.getLevel()));
        props.setProperty("xp", Integer.toString(p.getXp()));
        props.setProperty("coins", Integer.toString(p.getCoins()));
        props.setProperty("games", Integer.toString(p.getGames()));
        props.setProperty("wins", Integer.toString(p.getWins()));
        props.setProperty("lessons", Integer.toString(p.getLessons()));
        props.setProperty("streak", Integer.toString(p.getStreak()));
        props.setProperty("bestStreak", Integer.toString(p.getBestStreak()));
        props.setProperty("studyPoints", Integer.toString(p.getStudyPoints()));
        props.setProperty("achievements", String.join("|", p.getAchievements()));
        props.setProperty("inventory", String.join("|", p.getInventory()));
        try (OutputStream out = Files.newOutputStream(SAVE)) {
            props.store(out, "Mega Projeto Java V3");
        } catch (IOException ex) {
            System.out.println(MegaProjetoJava.RED + "Falha ao salvar: " + ex.getMessage() + MegaProjetoJava.RESET);
        }
    }

    public static void load(PlayerProfile p) {
        if (!Files.exists(SAVE)) return;
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(SAVE)) {
            props.load(in);
            p.setName(props.getProperty("name", "Rafael"));
            setPrivateState(p,
                    Integer.parseInt(props.getProperty("level", "1")),
                    Integer.parseInt(props.getProperty("xp", "0")),
                    Integer.parseInt(props.getProperty("coins", "0")),
                    Integer.parseInt(props.getProperty("games", "0")),
                    Integer.parseInt(props.getProperty("wins", "0")),
                    Integer.parseInt(props.getProperty("lessons", "0")),
                    Integer.parseInt(props.getProperty("streak", "0")),
                    Integer.parseInt(props.getProperty("bestStreak", "0")),
                    Integer.parseInt(props.getProperty("studyPoints", "0")));
            loadSet(props.getProperty("achievements", ""), p, true);
            loadSet(props.getProperty("inventory", ""), p, false);
            p.checkAchievements();
        } catch (Exception ex) {
            System.out.println(MegaProjetoJava.YELLOW + "Save incompatível; começando com padrão." + MegaProjetoJava.RESET);
        }
    }

    // Mantemos reflection confinada ao sistema de persistência para não poluir as lições.
    private static void setPrivateState(PlayerProfile p, int level, int xp, int coins,
                                        int games, int wins, int lessons, int streak,
                                        int bestStreak, int studyPoints) throws Exception {
        set(p, "level", level);
        set(p, "xp", xp);
        set(p, "coins", coins);
        set(p, "games", games);
        set(p, "wins", wins);
        set(p, "lessons", lessons);
        set(p, "streak", streak);
        set(p, "bestStreak", bestStreak);
        set(p, "studyPoints", studyPoints);
    }

    private static void set(Object obj, String field, int value) throws Exception {
        var f = obj.getClass().getDeclaredField(field);
        f.setAccessible(true);
        f.setInt(obj, value);
    }

    private static void loadSet(String raw, PlayerProfile p, boolean achievements) throws Exception {
        if (raw == null || raw.isBlank()) return;
        var fieldName = achievements ? "achievements" : "inventory";
        var f = p.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        @SuppressWarnings("unchecked") Set<String> set = (Set<String>) f.get(p);
        for (String item : raw.split("\\|")) {
            if (!item.isBlank()) set.add(item);
        }
    }

    public static void exportReport(PlayerProfile p) {
        Path report = Paths.get("relatorio_mega_projeto_java.txt");
        StringBuilder sb = new StringBuilder();
        sb.append("MEGA PROJETO JAVA V3\n");
        sb.append("Gerado em: ").append(java.time.LocalDateTime.now()).append('\n');
        sb.append("Jogador: ").append(p.getName()).append('\n');
        sb.append("Nível: ").append(p.getLevel()).append('\n');
        sb.append("XP: ").append(p.getXp()).append('/').append(p.nextLevelXp()).append('\n');
        sb.append("Moedas: ").append(p.getCoins()).append('\n');
        sb.append("Partidas: ").append(p.getGames()).append('\n');
        sb.append("Vitórias: ").append(p.getWins()).append('\n');
        sb.append("Lições: ").append(p.getLessons()).append('\n');
        sb.append("Melhor streak: ").append(p.getBestStreak()).append('\n');
        sb.append("Conquistas: ").append(p.getAchievements()).append('\n');
        sb.append("Inventário: ").append(p.getInventory()).append('\n');
        try {
            Files.writeString(report, sb.toString(), StandardCharsets.UTF_8);
            System.out.println(MegaProjetoJava.GREEN + "Relatório: " + report.toAbsolutePath() + MegaProjetoJava.RESET);
        } catch (IOException ex) {
            System.out.println(MegaProjetoJava.RED + "Falha: " + ex.getMessage() + MegaProjetoJava.RESET);
        }
    }
}
