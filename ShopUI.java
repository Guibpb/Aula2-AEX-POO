import java.util.*;

public final class ShopUI {
    private record Item(String name, int price, String description) { }

    private static final List<Item> ITEMS = List.of(
        new Item("Tema Cyber", 50, "Item cosmético de perfil."),
        new Item("Título Aprendiz", 100, "Título desbloqueável para o perfil."),
        new Item("Título Debugger", 250, "Título para quem gosta de caçar bugs."),
        new Item("Modo Turbo", 300, "Item de coleção para eventos."),
        new Item("Badge Java", 500, "Insígnia especial de estudo.")
    );

    private ShopUI() { }

    public static void menu() {
        while (true) {
            MegaProjetoJava.header("LOJA");
            System.out.println("Moedas: " + MegaProjetoJava.PLAYER.getCoins());
            for (int i = 0; i < ITEMS.size(); i++) {
                Item item = ITEMS.get(i);
                System.out.printf("[%d] %-20s %4d — %s%n", i + 1, item.name(), item.price(), item.description());
            }
            System.out.println("[0] Voltar");
            int op = MegaProjetoJava.askInt("Comprar: ", 0, ITEMS.size());
            if (op == 0) return;
            Item item = ITEMS.get(op - 1);
            if (MegaProjetoJava.PLAYER.buy(item.name(), item.price())) {
                System.out.println(MegaProjetoJava.GREEN + "Comprado!" + MegaProjetoJava.RESET);
            } else {
                System.out.println(MegaProjetoJava.RED + "Saldo insuficiente ou item já adquirido." + MegaProjetoJava.RESET);
            }
            SaveSystem.save(MegaProjetoJava.PLAYER);
            MegaProjetoJava.pause();
        }
    }
}
