import java.util.*;

/** Estado do jogador e progressão. */
public class PlayerProfile {
    private String name = "Rafael";
    private int level = 1;
    private int xp = 0;
    private int coins = 0;
    private int games = 0;
    private int wins = 0;
    private int lessons = 0;
    private int streak = 0;
    private int bestStreak = 0;
    private int studyPoints = 0;
    private final Set<String> achievements = new LinkedHashSet<>();
    private final Set<String> inventory = new LinkedHashSet<>();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getLevel() { return level; }
    public int getXp() { return xp; }
    public int getCoins() { return coins; }
    public int getGames() { return games; }
    public int getWins() { return wins; }
    public int getLessons() { return lessons; }
    public int getStreak() { return streak; }
    public int getBestStreak() { return bestStreak; }
    public int getStudyPoints() { return studyPoints; }
    public Set<String> getAchievements() { return Collections.unmodifiableSet(achievements); }
    public Set<String> getInventory() { return Collections.unmodifiableSet(inventory); }

    public int nextLevelXp() { return 100 + (level - 1) * 50; }

    public void addXp(int amount) {
        if (amount <= 0) return;
        xp += amount;
        while (xp >= nextLevelXp()) {
            xp -= nextLevelXp();
            level++;
            coins += 25;
            System.out.println(MegaProjetoJava.GREEN + "★ NÍVEL " + level + "! +25 moedas" + MegaProjetoJava.RESET);
        }
        checkAchievements();
    }

    public void lessonReward(int xpAmount, int coinAmount) {
        lessons++;
        studyPoints++;
        addXp(xpAmount);
        coins += Math.max(0, coinAmount);
        checkAchievements();
    }

    public void gameStart() { games++; }

    public void win(int xpAmount, int coinAmount) {
        wins++;
        games++;
        streak++;
        bestStreak = Math.max(bestStreak, streak);
        addXp(xpAmount);
        coins += Math.max(0, coinAmount);
        checkAchievements();
    }

    public void lose() {
        games++;
        streak = 0;
        checkAchievements();
    }

    public boolean buy(String item, int price) {
        if (inventory.contains(item)) return false;
        if (coins < price) return false;
        coins -= price;
        inventory.add(item);
        checkAchievements();
        return true;
    }

    public void unlock(String achievement) { achievements.add(achievement); }

    public boolean hasAchievement(String achievement) { return achievements.contains(achievement); }

    public void checkAchievements() {
        unlockIf("Primeiro passo", games >= 1 || lessons >= 1);
        unlockIf("10 lições", lessons >= 10);
        unlockIf("50 lições", lessons >= 50);
        unlockIf("100 lições", lessons >= 100);
        unlockIf("500 lições", lessons >= 500);
        unlockIf("Nível 5", level >= 5);
        unlockIf("Nível 10", level >= 10);
        unlockIf("Nível 20", level >= 20);
        unlockIf("10 vitórias", wins >= 10);
        unlockIf("50 vitórias", wins >= 50);
        unlockIf("Streak 5", bestStreak >= 5);
        unlockIf("Streak 10", bestStreak >= 10);
        unlockIf("Primeiro item", !inventory.isEmpty());
        unlockIf("1000 moedas", coins >= 1000);
    }

    private void unlockIf(String name, boolean condition) {
        if (condition && achievements.add(name)) {
            System.out.println(MegaProjetoJava.MAGENTA + "🏆 CONQUISTA: " + name + MegaProjetoJava.RESET);
        }
    }
}
