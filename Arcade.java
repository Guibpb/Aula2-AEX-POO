import java.util.*;
import java.util.stream.*;

/** 35 minigames curtos para praticar lógica, strings, arrays e algoritmos. */
public final class Arcade {
    private Arcade() { }

    public static void menu() {
        while (true) {
            MegaProjetoJava.header("ARCADE — 35 MINIGAMES");
            String[] names = {
                "Math Rush", "Adivinhe o número", "Pedra Papel Tesoura", "Palavra embaralhada",
                "Memória", "Reação", "Forca", "Jogo da Velha", "Binário", "Code Breaker",
                "Typing", "Batalha de Dados", "Caçador de Primos", "Bug Hunter", "Quiz Java",
                "Array Arena", "Labirinto", "Blackjack", "Sequência", "Terminal Hacker",
                "Wordle", "Connect Four", "Campo Minado", "Cifra de César", "Conversor de Bases",
                "Sorting Race", "Stack Challenge", "Queue Challenge", "Factorial Race", "Fibonacci Race",
                "Roman Numerals", "Divisibility", "Anagram Duel", "Checksum", "Pattern Matrix"
            };
            for (int i = 0; i < names.length; i++) System.out.printf("[%02d] %s%n", i + 1, names[i]);
            System.out.println("[00] Voltar");
            int op = MegaProjetoJava.askInt("Escolha: ", 0, names.length);
            if (op == 0) return;
            play(op);
        }
    }

    private static void play(int op) {
        switch (op) {
            case 1 -> mathRush(); case 2 -> guess(); case 3 -> rps(); case 4 -> scramble();
            case 5 -> memory(); case 6 -> reaction(); case 7 -> hangman(); case 8 -> ticTacToe();
            case 9 -> binary(); case 10 -> codeBreaker(); case 11 -> typing(); case 12 -> dice();
            case 13 -> primeHunter(); case 14 -> bugHunter(); case 15 -> quiz(); case 16 -> arrayArena();
            case 17 -> maze(); case 18 -> blackjack(); case 19 -> sequence(); case 20 -> hacker();
            case 21 -> wordle(); case 22 -> connectFour(); case 23 -> minesweeper(); case 24 -> caesar();
            case 25 -> baseConverter(); case 26 -> sortingRace(); case 27 -> stackChallenge();
            case 28 -> queueChallenge(); case 29 -> factorialRace(); case 30 -> fibonacciRace();
            case 31 -> roman(); case 32 -> divisibility(); case 33 -> anagramDuel(); case 34 -> checksum();
            case 35 -> patternMatrix();
        }
        SaveSystem.save(MegaProjetoJava.PLAYER);
    }

    private static void win(int xp, int coins) { MegaProjetoJava.PLAYER.win(xp, coins); }
    private static void lose() { MegaProjetoJava.PLAYER.lose(); }

    private static void mathRush() {
        MegaProjetoJava.header("MATH RUSH"); int score = 0;
        for (int i = 0; i < 7; i++) {
            int a = 1 + MegaProjetoJava.RNG.nextInt(20), b = 1 + MegaProjetoJava.RNG.nextInt(20);
            int op = MegaProjetoJava.RNG.nextInt(3);
            int expected = op == 0 ? a + b : op == 1 ? a - b : a * b;
            String symbol = op == 0 ? "+" : op == 1 ? "-" : "*";
            int answer = MegaProjetoJava.askInt(a + " " + symbol + " " + b + " = ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (answer == expected) { score++; System.out.println(MegaProjetoJava.GREEN + "OK" + MegaProjetoJava.RESET); }
        }
        if (score >= 5) win(50, 20); else lose();
        System.out.println("Score: " + score + "/7"); MegaProjetoJava.pause();
    }

    private static void guess() {
        MegaProjetoJava.header("ADIVINHE"); int max = 100; int secret = 1 + MegaProjetoJava.RNG.nextInt(max);
        for (int i = 1; i <= 8; i++) {
            int g = MegaProjetoJava.askInt("Tentativa " + i + "/8: ", 1, max);
            if (g == secret) { win(45, 18); System.out.println("Acertou!"); MegaProjetoJava.pause(); return; }
            System.out.println(g < secret ? "Mais alto." : "Mais baixo.");
        }
        lose(); System.out.println("Era " + secret + "."); MegaProjetoJava.pause();
    }

    private static void rps() {
        MegaProjetoJava.header("PEDRA PAPEL TESOURA"); String[] m = {"pedra", "papel", "tesoura"};
        String u = MegaProjetoJava.ask("Sua jogada: ").trim().toLowerCase(Locale.ROOT); String c = m[MegaProjetoJava.RNG.nextInt(3)];
        System.out.println("CPU: " + c);
        if (!Arrays.asList(m).contains(u)) { System.out.println("Inválida."); MegaProjetoJava.pause(); return; }
        if (u.equals(c)) System.out.println("Empate.");
        else if ((u.equals("pedra")&&c.equals("tesoura"))||(u.equals("papel")&&c.equals("pedra"))||(u.equals("tesoura")&&c.equals("papel"))) { win(25,10); System.out.println("Vitória!"); }
        else { lose(); System.out.println("Derrota."); }
        MegaProjetoJava.pause();
    }

    private static void scramble() {
        MegaProjetoJava.header("PALAVRA EMBARALHADA"); String[] words = {"classe","objeto","metodo","array","stream","lambda","heranca","algoritmo","excecao","debug"};
        String w = words[MegaProjetoJava.RNG.nextInt(words.length)]; List<Character> cs = new ArrayList<>(); for (char c : w.toCharArray()) cs.add(c); Collections.shuffle(cs);
        StringBuilder mix = new StringBuilder(); for (char c : cs) mix.append(c);
        System.out.println("Embaralhada: " + mix); String a = MegaProjetoJava.ask("Resposta: ").trim().toLowerCase(Locale.ROOT);
        if (a.equals(w)) { win(35, 15); System.out.println("Correto!"); } else { lose(); System.out.println("Era " + w); } MegaProjetoJava.pause();
    }

    private static void memory() {
        MegaProjetoJava.header("MEMÓRIA"); StringBuilder seq = new StringBuilder();
        for (int i = 0; i < 6; i++) seq.append(MegaProjetoJava.RNG.nextInt(10));
        System.out.println("Observe: " + seq); MegaProjetoJava.ask("Pressione ENTER quando memorizar: ");
        String answer = MegaProjetoJava.ask("Digite: ").trim();
        if (answer.equals(seq.toString())) { win(45,18); System.out.println("Perfeito!"); } else { lose(); System.out.println("Era " + seq); } MegaProjetoJava.pause();
    }

    private static void reaction() {
        MegaProjetoJava.header("REAÇÃO"); System.out.println("Prepare..."); sleep(700 + MegaProjetoJava.RNG.nextInt(1200)); System.out.println("GO!");
        long start = System.nanoTime(); MegaProjetoJava.SC.nextLine(); long ms = (System.nanoTime()-start)/1_000_000;
        System.out.println(ms + " ms"); if (ms < 500) win(50,20); else lose(); MegaProjetoJava.pause();
    }

    private static void hangman() {
        MegaProjetoJava.header("FORCA"); String word = "programacao"; Set<Character> used = new HashSet<>(); int errors=0;
        while (errors < 7) {
            StringBuilder mask = new StringBuilder(); boolean done=true;
            for (char c: word.toCharArray()) { if (used.contains(c)) mask.append(c); else { mask.append('_'); done=false; } mask.append(' '); }
            System.out.println(mask); System.out.println("Usadas: " + used); String s = MegaProjetoJava.ask("Letra: ").trim().toLowerCase(Locale.ROOT);
            if (s.length()!=1) continue; char c=s.charAt(0); if (!used.add(c)) continue; if (word.indexOf(c)<0) errors++;
            if (done) { win(45,20); MegaProjetoJava.pause(); return; }
            boolean solved=true; for(char x:word.toCharArray()) if(!used.contains(x)) solved=false;
            if(solved){ win(45,20); System.out.println("Venceu!"); MegaProjetoJava.pause(); return; }
        }
        lose(); System.out.println("Palavra: " + word); MegaProjetoJava.pause();
    }

    private static void ticTacToe() {
        MegaProjetoJava.header("JOGO DA VELHA"); char[] b={'1','2','3','4','5','6','7','8','9'};
        for(int turn=0;turn<9;turn++){
            board(b); if(turn%2==0){int p=MegaProjetoJava.askInt("Casa: ",1,9)-1; if(b[p]=='X'||b[p]=='O'){turn--;continue;} b[p]='X';}
            else {List<Integer> f=new ArrayList<>(); for(int i=0;i<9;i++) if(b[i]!='X'&&b[i]!='O') f.add(i); if(f.isEmpty()) break; b[f.get(MegaProjetoJava.RNG.nextInt(f.size()))]='O';}
            if(winner(b,'X')){board(b);win(60,25);System.out.println("Você venceu!");MegaProjetoJava.pause();return;}
            if(winner(b,'O')){board(b);lose();System.out.println("CPU venceu.");MegaProjetoJava.pause();return;}
        }
        board(b);System.out.println("Empate.");MegaProjetoJava.pause();
    }

    private static void binary() {
        MegaProjetoJava.header("BINÁRIO"); int n=MegaProjetoJava.RNG.nextInt(256); String expected=Integer.toBinaryString(n);
        String a=MegaProjetoJava.ask("Binário de " + n + ": ").trim(); if(a.equals(expected)){win(40,16);System.out.println("Correto!");}else{lose();System.out.println(expected);}MegaProjetoJava.pause();
    }

    private static void codeBreaker() {
        MegaProjetoJava.header("CODE BREAKER"); String secret=String.format("%04d",MegaProjetoJava.RNG.nextInt(10000));
        for(int i=0;i<8;i++){String g=MegaProjetoJava.ask("Código " + (i+1) + "/8: ").trim(); if(!g.matches("\\d{4}")){i--;continue;} if(g.equals(secret)){win(70,30);System.out.println("QUEBROU!");MegaProjetoJava.pause();return;} System.out.println("Pistas exatas: " + exact(g,secret));}
        lose();System.out.println("Era " + secret);MegaProjetoJava.pause();
    }

    private static void typing() {
        MegaProjetoJava.header("TYPING"); String text="public static void main"; System.out.println(text); long s=System.nanoTime(); String a=MegaProjetoJava.ask("> "); long ms=(System.nanoTime()-s)/1_000_000;
        if(a.equals(text)){win(40,15);System.out.println("Tempo: "+ms+" ms");}else lose();MegaProjetoJava.pause();
    }

    private static void dice() {
        MegaProjetoJava.header("DADOS"); int p=0,c=0; for(int i=0;i<5;i++){int a=1+MegaProjetoJava.RNG.nextInt(6),b=1+MegaProjetoJava.RNG.nextInt(6);p+=a;c+=b;System.out.println(a+" x "+b);} if(p>c){win(35,15);}else if(p<c){lose();}System.out.println("Você="+p+" CPU="+c);MegaProjetoJava.pause();
    }

    private static void primeHunter() {
        MegaProjetoJava.header("PRIMOS"); int score=0; for(int i=0;i<8;i++){int n=2+MegaProjetoJava.RNG.nextInt(100);boolean a=MegaProjetoJava.askYesNo(n+" é primo? ");if(a==AlgorithmLab.isPrime(n))score++;} if(score>=6)win(50,18);else lose();System.out.println(score+"/8");MegaProjetoJava.pause();
    }

    private static void bugHunter() {
        MegaProjetoJava.header("BUG HUNTER"); String[] bugs={"int x=10/0;","String s=null; s.length();","int[] a=new int[2]; a[2]=5;","if(x=5){}"}; String bug=bugs[MegaProjetoJava.RNG.nextInt(bugs.length)];
        System.out.println(bug); String a=MegaProjetoJava.ask("Qual é o problema? ").toLowerCase(Locale.ROOT); boolean ok=a.contains("div")||a.contains("null")||a.contains("índ")||a.contains("index")||a.contains("=="); if(ok){win(50,20);System.out.println("Boa!");}else lose();MegaProjetoJava.pause();
    }

    private static void quiz() {
        MegaProjetoJava.header("QUIZ JAVA"); record Q(String q,String[] o,int c){}
        List<Q> qs=List.of(new Q("Qual cria um objeto?",new String[]{"new","class","void","this"},0),new Q("Qual evita duplicatas?",new String[]{"List","Set","Map","Queue"},1),new Q("Qual representa chave/valor?",new String[]{"Set","Map","List","Deque"},1),new Q("Herança de classe?",new String[]{"implements","extends","uses","with"},1)); int s=0;
        for(Q q:qs){System.out.println(q.q());for(int i=0;i<q.o().length;i++)System.out.println((i+1)+") "+q.o()[i]);if(MegaProjetoJava.askInt("Resposta: ",1,4)-1==q.c())s++;} if(s>=3)win(60,25);else lose();System.out.println(s+"/4");MegaProjetoJava.pause();
    }

    private static void arrayArena() {
        MegaProjetoJava.header("ARRAY ARENA"); int[] a=new int[8];for(int i=0;i<a.length;i++)a[i]=MegaProjetoJava.RNG.nextInt(20);System.out.println(Arrays.toString(a));int e=Arrays.stream(a).max().orElse(0);int x=MegaProjetoJava.askInt("Maior: ",Integer.MIN_VALUE,Integer.MAX_VALUE);if(x==e)win(35,14);else lose();System.out.println("Correto="+e);MegaProjetoJava.pause();
    }

    private static void maze() {
        MegaProjetoJava.header("LABIRINTO"); int x=0,y=0,gx=4,gy=4;for(int m=0;m<20;m++){System.out.println("@ posição "+x+","+y+" | saída "+gx+","+gy);if(x==gx&&y==gy){win(60,25);MegaProjetoJava.pause();return;}String s=MegaProjetoJava.ask("WASD: ").trim().toLowerCase(Locale.ROOT);if(s.equals("w"))y--;if(s.equals("s"))y++;if(s.equals("a"))x--;if(s.equals("d"))x++;x=Math.max(0,Math.min(4,x));y=Math.max(0,Math.min(4,y));}lose();System.out.println("Fim.");MegaProjetoJava.pause();
    }

    private static void blackjack() {
        MegaProjetoJava.header("BLACKJACK"); int p=draw()+draw(),d=draw()+draw();while(p<21&&MegaProjetoJava.ask("Comprar h ou parar s: ").equalsIgnoreCase("h"))p+=draw();while(d<17)d+=draw();System.out.println("Você="+p+" Dealer="+d);if(p<=21&&(d>21||p>d))win(60,25);else if(p>d&&p>21)lose();else if(p<d)lose();MegaProjetoJava.pause();
    }

    private static void sequence() {
        MegaProjetoJava.header("SEQUÊNCIA"); int a=2+MegaProjetoJava.RNG.nextInt(5),d=1+MegaProjetoJava.RNG.nextInt(5);for(int i=0;i<6;i++)System.out.print((a+i*d)+" ");int ans=MegaProjetoJava.askInt("\nPróximo: ",Integer.MIN_VALUE,Integer.MAX_VALUE);if(ans==a+6*d)win(45,18);else lose();MegaProjetoJava.pause();
    }

    private static void hacker() {
        MegaProjetoJava.header("TERMINAL HACKER — SIMULAÇÃO"); String[] cmds={"scan","decode","verify","compile","connect"};int s=0;for(String c:cmds){String a=MegaProjetoJava.ask("$"+c+" > ").trim();if(a.equals(c))s++;}if(s==cmds.length)win(80,35);else lose();System.out.println("Progresso "+s+"/"+cmds.length);MegaProjetoJava.pause();
    }

    private static void wordle() {
        MegaProjetoJava.header("WORDLE JAVA"); String secret="classe";for(int t=0;t<6;t++){String g=MegaProjetoJava.ask("Tentativa: ").trim().toLowerCase(Locale.ROOT);if(g.equals(secret)){win(70,30);System.out.println("Acertou!");MegaProjetoJava.pause();return;}System.out.println("Letras corretas na posição: "+same(g,secret));}lose();System.out.println("Palavra: "+secret);MegaProjetoJava.pause();
    }

    private static void connectFour() {
        MegaProjetoJava.header("CONNECT FOUR MINI"); char[][] b=new char[4][4];for(char[] r:b)Arrays.fill(r,'.');for(int t=0;t<8;t++){print(b);if(t%2==0){int c=MegaProjetoJava.askInt("Coluna 1-4: ",1,4)-1;int r=drop(b,c,'X');if(r<0){t--;continue;}}else{int c=MegaProjetoJava.RNG.nextInt(4);drop(b,c,'O');}if(four(b,'X')){print(b);win(75,30);MegaProjetoJava.pause();return;}if(four(b,'O')){print(b);lose();MegaProjetoJava.pause();return;}}print(b);System.out.println("Empate.");MegaProjetoJava.pause();
    }

    private static void minesweeper() {
        MegaProjetoJava.header("CAMPO MINADO MINI"); int mine=1+MegaProjetoJava.RNG.nextInt(9), safe=0;while(safe<5){int p=MegaProjetoJava.askInt("Escolha célula 1-9: ",1,9);if(p==mine){lose();System.out.println("BOOM! Mina="+mine);MegaProjetoJava.pause();return;}safe++;System.out.println("Seguro!");}win(75,30);System.out.println("Campo limpo!");MegaProjetoJava.pause();
    }

    private static void caesar() {
        MegaProjetoJava.header("CIFRA DE CÉSAR"); String text="JAVA";int shift=3;String enc=caesarText(text,shift);System.out.println("Codificado: "+enc);String a=MegaProjetoJava.ask("Decodifique: ").trim().toUpperCase(Locale.ROOT);if(a.equals(text)){win(50,20);}else lose();MegaProjetoJava.pause();
    }

    private static void baseConverter() {
        MegaProjetoJava.header("CONVERSOR DE BASES");int n=MegaProjetoJava.askInt("Decimal: ",0,65535);int base=MegaProjetoJava.askInt("Base 2-16: ",2,16);String out=Integer.toString(n,base).toUpperCase(Locale.ROOT);String a=MegaProjetoJava.ask("Resultado: ").trim().toUpperCase(Locale.ROOT);if(a.equals(out)){win(45,18);}else lose();System.out.println("Esperado: "+out);MegaProjetoJava.pause();
    }

    private static void sortingRace() {
        MegaProjetoJava.header("SORTING RACE");List<Integer> a=new ArrayList<>();for(int i=0;i<7;i++)a.add(MegaProjetoJava.RNG.nextInt(50));System.out.println(a);String[] parts=MegaProjetoJava.ask("Ordene com espaços: ").trim().split("\\s+");List<Integer> parsed=new ArrayList<>();try{for(String p:parts)parsed.add(Integer.parseInt(p));}catch(NumberFormatException e){parsed.clear();}List<Integer> expected=new ArrayList<>(a);Collections.sort(expected);if(parsed.equals(expected))win(55,22);else lose();System.out.println("Esperado: "+expected);MegaProjetoJava.pause();
    }

    private static void stackChallenge() {
        MegaProjetoJava.header("STACK CHALLENGE");Deque<Integer> stack=new ArrayDeque<>();for(int i=1;i<=5;i++)stack.push(i);System.out.println("Pilha: "+stack);int top=MegaProjetoJava.askInt("Topo: ",0,10);if(top==5)win(35,14);else lose();MegaProjetoJava.pause();
    }

    private static void queueChallenge() {
        MegaProjetoJava.header("QUEUE CHALLENGE");Queue<String> q=new ArrayDeque<>();q.add("A");q.add("B");q.add("C");System.out.println(q);String first=MegaProjetoJava.ask("Primeiro da fila: ").trim();if(first.equals("A"))win(35,14);else lose();MegaProjetoJava.pause();
    }

    private static void factorialRace() {
        MegaProjetoJava.header("FACTORIAL RACE");int n=MegaProjetoJava.askInt("n (0-12): ",0,12);long f=1;for(int i=2;i<=n;i++)f*=i;long a=Long.parseLong(MegaProjetoJava.ask("Fatorial: ").trim());if(a==f)win(50,20);else lose();System.out.println("Esperado="+f);MegaProjetoJava.pause();
    }

    private static void fibonacciRace() {
        MegaProjetoJava.header("FIBONACCI RACE");int n=MegaProjetoJava.askInt("n (0-20): ",0,20);long a=AlgorithmLabResult.fib(n);long u=Long.parseLong(MegaProjetoJava.ask("Resultado: ").trim());if(u==a)win(50,20);else lose();System.out.println("Esperado="+a);MegaProjetoJava.pause();
    }

    private static void roman() {
        MegaProjetoJava.header("ROMAN NUMERALS");int n=MegaProjetoJava.askInt("1-3999: ",1,3999);String r=romanOf(n);String a=MegaProjetoJava.ask("Romano: ").trim().toUpperCase(Locale.ROOT);if(a.equals(r))win(50,20);else lose();System.out.println("Esperado="+r);MegaProjetoJava.pause();
    }

    private static void divisibility() {
        MegaProjetoJava.header("DIVISIBILITY");int n=1+MegaProjetoJava.RNG.nextInt(100);int d=2+MegaProjetoJava.RNG.nextInt(9);boolean a=MegaProjetoJava.askYesNo(n+" é divisível por "+d+"? ");if(a==(n%d==0))win(35,14);else lose();MegaProjetoJava.pause();
    }

    private static void anagramDuel() {
        MegaProjetoJava.header("ANAGRAM DUEL");String a="STREAM", b=new StringBuilder(a).reverse().toString();System.out.println("Alvo: "+b);String u=MegaProjetoJava.ask("Anagrama: ").trim().toUpperCase(Locale.ROOT);if(sortString(u).equals(sortString(a)))win(45,18);else lose();MegaProjetoJava.pause();
    }

    private static void checksum() {
        MegaProjetoJava.header("CHECKSUM");String s="JAVA";int sum=0;for(char c:s.toCharArray())sum+=c;int u=MegaProjetoJava.askInt("Checksum ASCII de JAVA: ",0,1000);if(u==sum)win(45,18);else lose();System.out.println("Esperado="+sum);MegaProjetoJava.pause();
    }

    private static void patternMatrix() {
        MegaProjetoJava.header("PATTERN MATRIX");int n=MegaProjetoJava.askInt("n (2-7): ",2,7);int expected=n*n;int count=0;for(int r=0;r<n;r++){for(int c=0;c<n;c++){System.out.print("# ");count++;}System.out.println();}int u=MegaProjetoJava.askInt("Quantos #?: ",0,100);if(u==expected&&count==expected)win(45,18);else lose();MegaProjetoJava.pause();
    }

    private static int exact(String a,String b){int n=0;for(int i=0;i<4;i++)if(a.charAt(i)==b.charAt(i))n++;return n;}
    private static void board(char[] b){System.out.println(b[0]+"|"+b[1]+"|"+b[2]);System.out.println("-+-+-");System.out.println(b[3]+"|"+b[4]+"|"+b[5]);System.out.println("-+-+-");System.out.println(b[6]+"|"+b[7]+"|"+b[8]);}
    private static boolean winner(char[] b,char c){int[][] w={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};for(int[] a:w)if(b[a[0]]==c&&b[a[1]]==c&&b[a[2]]==c)return true;return false;}
    private static void sleep(long ms){try{Thread.sleep(ms);}catch(InterruptedException e){Thread.currentThread().interrupt();}}
    private static int draw(){return 1+MegaProjetoJava.RNG.nextInt(10);}
    private static int same(String a,String b){int n=0;for(int i=0;i<Math.min(a.length(),b.length());i++)if(a.charAt(i)==b.charAt(i))n++;return n;}
    private static String caesarText(String s,int shift){StringBuilder o=new StringBuilder();for(char c:s.toCharArray()){int x=c-'A';o.append((char)('A'+(x+shift+26)%26));}return o.toString();}
    private static String romanOf(int n){int[] v={1000,900,500,400,100,90,50,40,10,9,5,4,1};String[] r={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};StringBuilder s=new StringBuilder();for(int i=0;i<v.length;i++)while(n>=v[i]){n-=v[i];s.append(r[i]);}return s.toString();}
    private static String sortString(String s){char[] a=s.toCharArray();Arrays.sort(a);return new String(a);}
    private static int drop(char[][] b,int col,char token){for(int r=b.length-1;r>=0;r--)if(b[r][col]=='.'){b[r][col]=token;return r;}return -1;}
    private static boolean four(char[][] b,char c){for(int r=0;r<b.length;r++)for(int col=0;col<b[r].length-3;col++)if(b[r][col]==c&&b[r][col+1]==c&&b[r][col+2]==c&&b[r][col+3]==c)return true;for(int col=0;col<b[0].length;col++)for(int r=0;r<b.length-3;r++)if(b[r][col]==c&&b[r+1][col]==c&&b[r+2][col]==c&&b[r+3][col]==c)return true;return false;}
    private static void print(char[][] b){for(char[] row:b)System.out.println(new String(row));}

    private static final class AlgorithmLabResult {
        static long fib(int n){long a=0,b=1;for(int i=0;i<n;i++){long t=a+b;a=b;b=t;}return a;}
    }
}
