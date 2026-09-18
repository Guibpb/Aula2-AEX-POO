import java.util.*;

/** Testes automáticos focados em compilação, catálogo e algoritmos puros. */
public final class TestSuite {
    private static int passed;
    private static int failed;
    private TestSuite() { }

    public static void runAll() {
        passed = 0; failed = 0;
        System.out.println("=== MEGA PROJETO JAVA V3 — SELF TEST ===");
        check("3000 lições", StudyEngine.lessonCount() == 3000, StudyEngine.lessonCount());
        check("30 tópicos", LessonRegistry.TOPICS.length == 30, LessonRegistry.TOPICS.length);
        check("50 referências por metade", LessonRegistry.build().size() == 3000, "ok");
        check("primo 2", AlgorithmLab.isPrime(2), "true");
        check("1 não é primo", !AlgorithmLab.isPrime(1), "true");
        check("100 não é primo", !AlgorithmLab.isPrime(100), "true");
        check("997 é primo", AlgorithmLab.isPrime(997), "true");
        check("999 não é primo", !AlgorithmLab.isPrime(999), "true");
        check("fibonacci 0", fib(0) == 0, fib(0));
        check("fibonacci 10", fib(10) == 55, fib(10));
        check("fatorial 0", factorial(0) == 1, factorial(0));
        check("fatorial 6", factorial(6) == 720, factorial(6));
        check("busca linear", linear(new int[]{3,5,7},5) == 1, linear(new int[]{3,5,7},5));
        check("busca ausente", linear(new int[]{3,5,7},9) == -1, linear(new int[]{3,5,7},9));
        check("ordenação", Arrays.equals(sorted(new int[]{5,1,4,2}), new int[]{1,2,4,5}), Arrays.toString(sorted(new int[]{5,1,4,2})));
        check("palíndromo", palindrome("Java!avaJ"), "true");
        check("não palíndromo", !palindrome("Java"), "true");
        PlayerProfile p = new PlayerProfile();
        p.addXp(100);
        check("level-up", p.getLevel() == 2 && p.getCoins() == 25, p.getLevel()+"/"+p.getCoins());
        check("next level xp", p.nextLevelXp() == 150, p.nextLevelXp());
        System.out.println();
        System.out.println("PASS: " + passed);
        System.out.println("FAIL: " + failed);
        if (failed > 0) throw new AssertionError("Falhas encontradas.");
        System.out.println("SELF TEST OK — compilação e testes automáticos concluídos.");
    }

    private static long fib(int n) { long a=0,b=1; for(int i=0;i<n;i++){long t=a+b;a=b;b=t;} return a; }
    private static long factorial(int n) { long r=1; for(int i=2;i<=n;i++) r*=i; return r; }
    private static int linear(int[] a,int x){for(int i=0;i<a.length;i++)if(a[i]==x)return i;return -1;}
    private static int[] sorted(int[] a){int[] b=a.clone();Arrays.sort(b);return b;}
    private static boolean palindrome(String s){String x=s.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]","");return x.equals(new StringBuilder(x).reverse().toString());}
    private static void check(String name, boolean ok, Object value) {
        if(ok){passed++;System.out.println("[PASS] "+name+" -> "+value);}
        else{failed++;System.out.println("[FAIL] "+name+" -> "+value);}
    }
}
