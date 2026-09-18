import java.time.*;
import java.util.*;

public final class DailyMission {
    private static LocalDate lastDate;
    private DailyMission() { }

    public static void play() {
        MegaProjetoJava.header("MISSÃO DIÁRIA");
        LocalDate today = LocalDate.now();
        if (today.equals(lastDate)) {
            System.out.println(MegaProjetoJava.YELLOW + "Você já completou a missão nesta execução." + MegaProjetoJava.RESET);
            MegaProjetoJava.pause();
            return;
        }
        int a = 2 + MegaProjetoJava.RNG.nextInt(20);
        int b = 2 + MegaProjetoJava.RNG.nextInt(20);
        int expected = a * b + a + b;
        int answer = MegaProjetoJava.askInt("Quanto vale a expressão " + a + " * " + b + " + " + a + " + " + b + "? ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (answer == expected) {
            lastDate = today;
            MegaProjetoJava.PLAYER.win(80, 40);
            SaveSystem.save(MegaProjetoJava.PLAYER);
            System.out.println(MegaProjetoJava.GREEN + "Missão completa!" + MegaProjetoJava.RESET);
        } else {
            MegaProjetoJava.PLAYER.lose();
            System.out.println(MegaProjetoJava.RED + "Resposta: " + expected + MegaProjetoJava.RESET);
        }
        MegaProjetoJava.pause();
    }
}
