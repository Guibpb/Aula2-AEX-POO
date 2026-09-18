package com.mycompany.aula1cursojava;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Grupo3AULA1Rafael {

    // ===============================================================
    // NEXUS JAVA ACADEMY - MEGA EDITION
    // Um unico arquivo | Estudos | Desafios | Minigames | PC | GUI
    // ===============================================================

    static final Scanner teclado = new Scanner(System.in);
    static final Random random = new Random();

    static final String RESET = "\u001B[0m";
    static final String VERDE = "\u001B[32m";
    static final String CIANO = "\u001B[36m";
    static final String AZUL = "\u001B[34m";
    static final String ROXO = "\u001B[35m";
    static final String VERMELHO = "\u001B[31m";
    static final String AMARELO = "\u001B[33m";
    static final String BRANCO = "\u001B[37m";
    static final String NEGRITO = "\u001B[1m";

    static int nivel = 1;
    static int xp = 0;
    static int pontos = 0;
    static int acertos = 0;
    static int erros = 0;
    static int partidas = 0;
    static int vitorias = 0;
    static int moedas = 0;
    static int combo = 0;
    static int maiorCombo = 0;
    static int modulosConcluidos = 0;
    static int questoesRespondidas = 0;

    public static void main(String[] args) {
        limparTela();
        intro();
        menuPrincipal();
    }

    static void intro() {
        titulo("NEXUS JAVA ACADEMY - MEGA EDITION");
        System.out.println(CIANO + "CENTRAL DE ESTUDOS, DESAFIOS E MINIGAMES" + RESET);
        System.out.println();
        System.out.println("Java em um unico arquivo, sem bibliotecas externas.");
        System.out.println("Foco: aprender praticando.");
        escrever("Carregando motor de estudos...", 3);
        escrever("Carregando banco de perguntas...", 3);
        escrever("Carregando arcade...", 3);
        escrever("Carregando simuladores...", 3);
        escrever("Carregando interface Swing...", 3);
        barra("Inicializando NEXUS", 4);
        sucesso("NEXUS ONLINE");
        System.out.println();
        System.out.print(AMARELO + "Pressione ENTER para entrar..." + RESET);
        teclado.nextLine();
        limparTela();
    }

    static void menuPrincipal() {
        int opcao;
        do {
            cabecalho("NEXUS CENTRAL");
            System.out.println(CIANO + "[1]" + RESET + " Academia de Estudos");
            System.out.println(CIANO + "[2]" + RESET + " Mega Biblioteca (500 modulos)");
            System.out.println(CIANO + "[3]" + RESET + " Desafios Praticos");
            System.out.println(ROXO + "[4]" + RESET + " Mega Arcade (20+ minigames)");
            System.out.println(CIANO + "[5]" + RESET + " PC Command Center");
            System.out.println(CIANO + "[6]" + RESET + " Interface Grafica");
            System.out.println(CIANO + "[7]" + RESET + " Perfil e Progresso");
            System.out.println(CIANO + "[8]" + RESET + " Conquistas");
            System.out.println(CIANO + "[9]" + RESET + " Modo Treino Livre");
            System.out.println(VERMELHO + "[0]" + RESET + " Sair");
            separador();
            System.out.print(AMARELO + "NEXUS > " + RESET);
            opcao = lerInteiro();
            limparTela();
            switch(opcao) {
                case 1: menuAcademia(); break;
                case 2: megaBiblioteca(); break;
                case 3: menuDesafios(); break;
                case 4: menuMinigames(); break;
                case 5: centroPC(); break;
                case 6: interfaceGrafica(); break;
                case 7: perfil(); break;
                case 8: conquistas(); break;
                case 9: treinoLivre(); break;
                case 0: desligar(); break;
                default: erro("Opcao invalida."); pausar(); limparTela();
            }
        } while(opcao != 0);
    }

    static void menuAcademia() {
        int opcao;
        do {
            titulo("ACADEMIA JAVA");
            System.out.println("[1] Variaveis e tipos");
            System.out.println("[2] Condicoes");
            System.out.println("[3] For / While / Do While");
            System.out.println("[4] Metodos");
            System.out.println("[5] Arrays e StringBuilder");
            System.out.println("[6] Classes e Objetos");
            System.out.println("[7] Swing e JFrame");
            System.out.println("[8] Quiz Geral");
            System.out.println("[0] Voltar");
            System.out.print("Aula > ");
            opcao=lerInteiro();
            limparTela();
            switch(opcao){
                case 1: aulaVariaveis(); break;
                case 2: aulaCondicoes(); break;
                case 3: aulaLoops(); break;
                case 4: aulaMetodos(); break;
                case 5: aulaArrays(); break;
                case 6: aulaClasses(); break;
                case 7: aulaJFrame(); break;
                case 8: quizGeral(); break;
                case 0: break;
                default: erro("Aula invalida."); pausar(); limparTela();
            }
        } while(opcao!=0);
    }

    static void aulaVariaveis() {
        titulo("AULA VARIAVEIS");
        categoria("CONCEITO");
        System.out.println("int guarda numeros inteiros.");
        System.out.println("double guarda numeros com casas decimais.");
        System.out.println("String guarda texto.");
        System.out.println("boolean guarda true ou false.");
        categoria("EXEMPLO");
        System.out.println("int vida = 100;");
        System.out.println("double preco = 19.90;");
        System.out.println("String nome = \"Rafael\";");
        System.out.println("boolean online = true;");
        categoria("DESAFIO");
        System.out.println("Qual tipo guarda true ou false?");
        System.out.println("1 - int");
        System.out.println("2 - boolean");
        System.out.println("3 - String");
        System.out.print("Resposta: ");
        if (lerInteiro() == 2) { sucesso("Correto!"); ganharXP(25); } else { erro("Resposta incorreta."); perderCombo(); }
        pausar();
        limparTela();
    }

    static void aulaCondicoes() {
        titulo("AULA CONDICOES");
        categoria("CONCEITO");
        System.out.println("if / else toma decisoes.");
        System.out.println("Operadores comuns: > < == != >= <=.");
        System.out.println("switch organiza escolhas fixas.");
        categoria("EXEMPLO");
        System.out.println("if (vida > 0) {");
        System.out.println("    System.out.println(\"Vivo\");");
        System.out.println("} else {");
        System.out.println("    System.out.println(\"Game Over\");");
        System.out.println("}");
        categoria("DESAFIO");
        System.out.println("Qual operador testa igualdade?");
        System.out.println("1 - =");
        System.out.println("2 - ==");
        System.out.println("3 - =>");
        System.out.print("Resposta: ");
        if (lerInteiro() == 2) { sucesso("Correto!"); ganharXP(25); } else { erro("Resposta incorreta."); perderCombo(); }
        pausar();
        limparTela();
    }

    static void aulaLoops() {
        titulo("AULA LOOPS");
        categoria("CONCEITO");
        System.out.println("for repete usando contador.");
        System.out.println("while repete enquanto a condicao for verdadeira.");
        System.out.println("do while executa antes de testar.");
        categoria("EXEMPLO");
        System.out.println("for (int i=0; i<5; i++) { }");
        System.out.println("while (energia > 0) { energia--; }");
        System.out.println("do { System.out.println(\"Oi\"); } while (ok);");
        categoria("DESAFIO");
        System.out.println("Quantas vezes for (int i=0; i<4; i++) roda?");
        System.out.println("1 - 3");
        System.out.println("2 - 4");
        System.out.println("3 - 5");
        System.out.print("Resposta: ");
        if (lerInteiro() == 2) { sucesso("Correto!"); ganharXP(25); } else { erro("Resposta incorreta."); perderCombo(); }
        pausar();
        limparTela();
    }

    static void aulaMetodos() {
        titulo("AULA METODOS");
        categoria("CONCEITO");
        System.out.println("Metodos organizam o programa.");
        System.out.println("Parametros recebem dados.");
        System.out.println("return devolve um valor.");
        categoria("EXEMPLO");
        System.out.println("static int somar(int a,int b) {");
        System.out.println("    return a+b;");
        System.out.println("}");
        categoria("DESAFIO");
        System.out.println("Qual palavra devolve um valor?");
        System.out.println("1 - return");
        System.out.println("2 - print");
        System.out.println("3 - break");
        System.out.print("Resposta: ");
        if (lerInteiro() == 1) { sucesso("Correto!"); ganharXP(25); } else { erro("Resposta incorreta."); perderCombo(); }
        pausar();
        limparTela();
    }

    static void aulaArrays() {
        titulo("AULA ARRAYS");
        categoria("CONCEITO");
        System.out.println("Arrays guardam varios valores.");
        System.out.println("O primeiro indice e 0.");
        System.out.println("length mostra o tamanho.");
        categoria("EXEMPLO");
        System.out.println("int[] notas={7,8,9};");
        System.out.println("System.out.println(notas[0]);");
        System.out.println("System.out.println(notas.length);");
        categoria("DESAFIO");
        System.out.println("Qual e o primeiro indice?");
        System.out.println("1 - 0");
        System.out.println("2 - 1");
        System.out.println("3 - -1");
        System.out.print("Resposta: ");
        if (lerInteiro() == 1) { sucesso("Correto!"); ganharXP(25); } else { erro("Resposta incorreta."); perderCombo(); }
        pausar();
        limparTela();
    }

    static void aulaClasses() {
        titulo("AULA CLASSES");
        categoria("CONCEITO");
        System.out.println("Classe e um molde.");
        System.out.println("Objeto e uma instancia.");
        System.out.println("this representa o objeto atual.");
        categoria("EXEMPLO");
        System.out.println("class Jogador { int vida; }");
        System.out.println("Jogador j = new Jogador();");
        System.out.println("this.vida = 100;");
        categoria("DESAFIO");
        System.out.println("Qual palavra cria um objeto?");
        System.out.println("1 - new");
        System.out.println("2 - make");
        System.out.println("3 - create");
        System.out.print("Resposta: ");
        if (lerInteiro() == 1) { sucesso("Correto!"); ganharXP(25); } else { erro("Resposta incorreta."); perderCombo(); }
        pausar();
        limparTela();
    }

    static void quizGeral() {
        titulo("QUIZ GERAL DE JAVA");
        String[][] questoes = {
            {"Qual tipo guarda true ou false?", "int", "boolean", "String", "2"},
            {"Qual e o primeiro indice de um array?", "1", "0", "-1", "2"},
            {"Qual palavra cria um objeto?", "new", "make", "create", "1"},
            {"Qual estrutura e usada para repeticao?", "for", "label", "case", "1"},
            {"Qual palavra retorna um valor?", "return", "send", "back", "1"},
            {"Qual classe representa uma janela Swing?", "JFrame", "JBox", "WindowJava", "1"}
        };

        for (int i = 0; i < questoes.length; i++) {
            categoria("QUESTAO " + (i + 1));
            System.out.println(questoes[i][0]);
            System.out.println("1 - " + questoes[i][1]);
            System.out.println("2 - " + questoes[i][2]);
            System.out.println("3 - " + questoes[i][3]);
            System.out.print("Resposta: ");
            int resposta = lerInteiro();
            questoesRespondidas++;
            if (resposta == Integer.parseInt(questoes[i][4])) {
                acertos++;
                sucesso("Correto!");
                ganharXP(15);
            } else {
                erros++;
                erro("Resposta incorreta.");
                combo = 0;
            }
        }

        categoria("RESULTADO");
        System.out.println("Acertos: " + acertos + "/" + questoes.length);
        pausar();
        limparTela();
    }

    static void aulaJFrame() {
        titulo("AULA JFRAME");
        categoria("CONCEITO");
        System.out.println("JFrame cria uma janela Swing.");
        System.out.println("JPanel agrupa componentes.");
        System.out.println("JButton cria botoes.");
        System.out.println("JLabel mostra textos.");
        categoria("EXEMPLO");
        System.out.println("JFrame janela=new JFrame(\"Nexus\");");
        System.out.println("janela.setSize(500,300);");
        System.out.println("janela.setVisible(true);");
        categoria("DESAFIO");
        System.out.println("Qual metodo deixa a janela visivel?");
        System.out.println("1 - setSize");
        System.out.println("2 - setVisible");
        System.out.println("3 - setWindow");
        System.out.print("Resposta: ");
        if (lerInteiro() == 2) { sucesso("Correto!"); ganharXP(25); } else { erro("Resposta incorreta."); perderCombo(); }
        pausar();
        limparTela();
    }

    static void menuDesafios() {
        int opcao;
        do {
            titulo("DESAFIOS PRATICOS");
            System.out.println("[1] Preveja a saida");
            System.out.println("[2] Encontre o bug");
            System.out.println("[3] Complete o codigo");
            System.out.println("[4] Desafio de array");
            System.out.println("[5] Desafio de metodo");
            System.out.println("[6] Desafio de logica");
            System.out.println("[7] Desafio de objetos");
            System.out.println("[8] Boss final");
            System.out.println("[0] Voltar");
            System.out.print("Desafio > ");
            opcao=lerInteiro();
            limparTela();
            switch(opcao){
                case 1: desafioSaida(); break;
                case 2: desafioBug(); break;
                case 3: desafioCompletar(); break;
                case 4: desafioArray(); break;
                case 5: desafioMetodo(); break;
                case 6: desafioLogica(); break;
                case 7: desafioObjeto(); break;
                case 8: bossFinal(); break;
                case 0: break;
                default: erro("Desafio invalido."); pausar(); limparTela();
            }
        } while(opcao!=0);
    }

    static void desafioSaida() {
        titulo("DESAFIO - SAIDA");
        System.out.println("int x=3;");
        System.out.println("for(int i=0;i<2;i++){ x++; }");
        System.out.println("System.out.println(x);");
        System.out.println("Qual valor sai?");
        categoria("RESPOSTAS");
        System.out.println("1 - 3");
        System.out.println("2 - 4");
        System.out.println("3 - 5");
        System.out.print("Resposta: ");
        if(lerInteiro()==2){sucesso("Correto!");ganharXP(40);}else{erro("Resposta errada.");perderCombo();}
        pausar(); limparTela();
    }

    static void desafioBug() {
        titulo("DESAFIO - BUG");
        System.out.println("int i=0;");
        System.out.println("while(i<5){");
        System.out.println("    System.out.println(i);");
        System.out.println("}");
        System.out.println("Qual e o problema?");
        categoria("RESPOSTAS");
        System.out.println("1 - falta i++");
        System.out.println("2 - falta while");
        System.out.println("3 - falta int");
        System.out.print("Resposta: ");
        if(lerInteiro()==1){sucesso("Correto!");ganharXP(40);}else{erro("Resposta errada.");perderCombo();}
        pausar(); limparTela();
    }

    static void desafioCompletar() {
        titulo("DESAFIO - COMPLETAR");
        System.out.println("static int soma(int a,int b){");
        System.out.println("    ______ a+b;");
        System.out.println("}");
        categoria("RESPOSTAS");
        System.out.println("1 - return");
        System.out.println("2 - print");
        System.out.println("3 - break");
        System.out.print("Resposta: ");
        if(lerInteiro()==1){sucesso("Correto!");ganharXP(40);}else{erro("Resposta errada.");perderCombo();}
        pausar(); limparTela();
    }

    static void desafioArray() {
        titulo("DESAFIO - ARRAY");
        System.out.println("int[] a={10,20,30};");
        System.out.println("Qual e a[2]?");
        categoria("RESPOSTAS");
        System.out.println("1 - 10");
        System.out.println("2 - 20");
        System.out.println("3 - 30");
        System.out.print("Resposta: ");
        if(lerInteiro()==3){sucesso("Correto!");ganharXP(40);}else{erro("Resposta errada.");perderCombo();}
        pausar(); limparTela();
    }

    static void desafioMetodo() {
        titulo("DESAFIO - METODO");
        System.out.println("Qual palavra devolve valor?");
        categoria("RESPOSTAS");
        System.out.println("1 - return");
        System.out.println("2 - break");
        System.out.println("3 - continue");
        System.out.print("Resposta: ");
        if(lerInteiro()==1){sucesso("Correto!");ganharXP(40);}else{erro("Resposta errada.");perderCombo();}
        pausar(); limparTela();
    }

    static void desafioLogica() {
        titulo("DESAFIO - LOGICA");
        System.out.println("Se a=5 e b=3, quanto vale a+b?");
        categoria("RESPOSTAS");
        System.out.println("1 - 6");
        System.out.println("2 - 8");
        System.out.println("3 - 15");
        System.out.print("Resposta: ");
        if(lerInteiro()==2){sucesso("Correto!");ganharXP(40);}else{erro("Resposta errada.");perderCombo();}
        pausar(); limparTela();
    }

    static void desafioObjeto() {
        titulo("DESAFIO - OBJETO");
        System.out.println("Jogador j = new Jogador();");
        System.out.println("O que j representa?");
        categoria("RESPOSTAS");
        System.out.println("1 - Uma classe");
        System.out.println("2 - Um objeto");
        System.out.println("3 - Um pacote");
        System.out.print("Resposta: ");
        if(lerInteiro()==2){sucesso("Correto!");ganharXP(40);}else{erro("Resposta errada.");perderCombo();}
        pausar(); limparTela();
    }

    static void bossFinal() {
        titulo("BOSS FINAL - PROVA DE JAVA");
        int score=0;
        System.out.println("Qual tipo guarda true/false?");
        System.out.println("1-int");
        System.out.println("2-boolean");
        if(lerInteiro()==2){score++;acertos++;}else{erros++;}
        System.out.println("Primeiro indice de array?");
        System.out.println("1-0");
        System.out.println("2-1");
        if(lerInteiro()==1){score++;acertos++;}else{erros++;}
        System.out.println("Palavra que cria objeto?");
        System.out.println("1-new");
        System.out.println("2-make");
        if(lerInteiro()==1){score++;acertos++;}else{erros++;}
        System.out.println("Estrutura de repeticao por contador?");
        System.out.println("1-for");
        System.out.println("2-label");
        if(lerInteiro()==1){score++;acertos++;}else{erros++;}
        System.out.println("Palavra de retorno?");
        System.out.println("1-return");
        System.out.println("2-send");
        if(lerInteiro()==1){score++;acertos++;}else{erros++;}
        System.out.println("Classe de janela Swing?");
        System.out.println("1-JFrame");
        System.out.println("2-JWindowBox");
        if(lerInteiro()==1){score++;acertos++;}else{erros++;}
        categoria("RESULTADO");
        System.out.println("Acertos: "+score+"/6");
        if(score>=5){sucesso("BOSS DERROTADO!");ganharXP(150);vitorias++;}else{erro("Reprovado no boss. Estude e tente novamente.");}
        pausar(); limparTela();
    }

    static void menuMinigames() {
        int opcao;
        do {
            titulo("MEGA ARCADE");
            System.out.println("[1] Adivinhe o Numero");
            System.out.println("[2] Math Sprint");
            System.out.println("[3] Memoria");
            System.out.println("[4] Code Breaker");
            System.out.println("[5] Palavra Embaralhada");
            System.out.println("[6] Teste de Reflexo");
            System.out.println("[7] Terminal Typing");
            System.out.println("[8] Bug Hunter");
            System.out.println("[9] Batalha Neon");
            System.out.println("[10] Caca ao Tesouro");
            System.out.println("[11] Robo Arena");
            System.out.println("[12] Quiz Relampago");
            System.out.println("[13] Soma Relampago");
            System.out.println("[14] Codigo Binario");
            System.out.println("[15] Labirinto Textual");
            System.out.println("[16] Hacker Puzzle");
            System.out.println("[17] Pares e Impares");
            System.out.println("[18] Senha Mestra");
            System.out.println("[19] Alvo Numerico");
            System.out.println("[20] Sequencia Crescente");
            System.out.println("[0] Voltar");
            System.out.print("GAME > ");
            opcao=lerInteiro();
            limparTela();
            switch(opcao){
                case 1: jogoNumero(); break;
                case 2: mathSprint(); break;
                case 3: jogoMemoria(); break;
                case 4: codeBreaker(); break;
                case 5: palavra(); break;
                case 6: reflexo(); break;
                case 7: typing(); break;
                case 8: bugHunter(); break;
                case 9: batalhaNeon(); break;
                case 10: tesouro(); break;
                case 11: roboArena(); break;
                case 12: quizRelampago(); break;
                case 13: somaRelampago(); break;
                case 14: binario(); break;
                case 15: labirinto(); break;
                case 16: hackerPuzzle(); break;
                case 17: paresImpares(); break;
                case 18: senhaMestra(); break;
                case 19: alvoNumerico(); break;
                case 20: sequenciaCrescente(); break;
                case 0: break;
                default: erro("Jogo inexistente."); pausar(); limparTela();
            }
        } while(opcao!=0);
    }

    static void jogoNumero(){
        titulo("ADIVINHE O NUMERO");
        partidas++;
        int segredo=random.nextInt(100)+1;
        for(int i=1;i<=7;i++){System.out.print("Tentativa "+i+": ");int p=lerInteiro();if(p==segredo){sucesso("ACERTOU!");vitorias++;ganharXP(70);pausar();limparTela();return;}if(p<segredo)System.out.println("Maior.");else System.out.println("Menor.");}
        erro("Fim. Numero: "+segredo);
        pausar(); limparTela();
    }

    static void mathSprint(){
        titulo("MATH SPRINT"); partidas++; int certo=0; long ini=System.currentTimeMillis();
        for(int i=0;i<8;i++){int x=random.nextInt(20)+1;int y=random.nextInt(20)+1;int r=x+y;System.out.print(x+" + "+y+" = ");if(lerInteiro()==r){certo++;sucesso("OK");}else erro("Era "+r);}
        long tempo=System.currentTimeMillis()-ini;System.out.println("Acertos: "+certo+"/8");System.out.println("Tempo: "+tempo+" ms");ganharXP(certo*12);pausar();limparTela();
    }

    static void jogoMemoria(){
        titulo("MEMORIA"); partidas++; int[] s=new int[6];
        for(int i=0;i<s.length;i++){s[i]=random.nextInt(10);System.out.print(s[i]+" ");dormir(350);}
        dormir(600); limparTela(); titulo("REPITA A SEQUENCIA"); boolean ok=true;
        for(int i=0;i<s.length;i++){System.out.print("Pos "+(i+1)+": ");if(lerInteiro()!=s[i])ok=false;}
        if(ok){sucesso("Memoria perfeita!");vitorias++;ganharXP(90);}else{erro("Sequencia errada.");}
        pausar(); limparTela();
    }

    static void codeBreaker(){
        titulo("CODE BREAKER"); partidas++; int codigo=random.nextInt(9000)+1000;
        for(int i=1;i<=8;i++){System.out.print("Tentativa "+i+": ");int p=lerInteiro();if(p==codigo){sucesso("ACESSO CONCEDIDO");vitorias++;ganharXP(100);pausar();limparTela();return;}if(p<codigo)System.out.println("Maior");else System.out.println("Menor");}
        erro("Codigo era "+codigo);pausar();limparTela();
    }

    static void palavra(){
        titulo("PALAVRA EMBARALHADA"); partidas++; String[] p={"JAVA","BOOLEAN","ARRAY","FRAME","METODO","CLASSE","OBJETO","SWING","STRING","RANDOM"}; String alvo=p[random.nextInt(p.length)];
        System.out.println("Descubra: "+embaralhar(alvo));System.out.print("Resposta: ");String r=teclado.nextLine();if(r.equalsIgnoreCase(alvo)){sucesso("Acertou");ganharXP(70);}else erro("Era "+alvo);pausar();limparTela();
    }

    static void reflexo(){
        titulo("TESTE DE REFLEXO");partidas++;System.out.println("Aguarde...");dormir(random.nextInt(2500)+1200);long ini=System.currentTimeMillis();System.out.println(VERDE+"GO!"+RESET);teclado.nextLine();long t=System.currentTimeMillis()-ini;System.out.println("Tempo: "+t+" ms");if(t<300){sucesso("ABSURDO");ganharXP(110);}else if(t<600){sucesso("Excelente");ganharXP(70);}else ganarXPSeguro(25);pausar();limparTela();
    }

    static void typing(){
        titulo("TERMINAL TYPING");partidas++;String[] f={"for while boolean","Nexus Java Academy","Programar e praticar","JFrame Swing Java","Aprender Java todo dia","Codigo limpo e organizado"};String alvo=f[random.nextInt(f.length)];System.out.println(alvo);long ini=System.currentTimeMillis();String r=teclado.nextLine();long t=System.currentTimeMillis()-ini;if(r.equals(alvo)){sucesso("Perfeito");System.out.println("Tempo: "+t+" ms");ganharXP(80);}else erro("Texto incorreto.");pausar();limparTela();
    }

    static void bugHunter(){
        titulo("BUG HUNTER");partidas++;System.out.println("int i=0;");System.out.println("while(i<10){");System.out.println("    System.out.println(i);");System.out.println("}");System.out.println("1-falta i++  2-falta while  3-falta println");if(lerInteiro()==1){sucesso("Bug localizado");ganharXP(75);}else{erro("Era falta de i++");}pausar();limparTela();
    }

    static void batalhaNeon(){
        titulo("BATALHA NEON");partidas++;int hp=100;int enemy=100;String[] n={"DRONE-X","ROBO TITAN","ANDROID 404","GUARDIAO JAVA","CYBER WOLF"};String nome=n[random.nextInt(n.length)];
        while(hp>0&&enemy>0){System.out.println("HP "+hp+" | "+nome+" "+enemy);System.out.println("1-Atacar 2-Defender 3-Skill");int ac=lerInteiro();if(ac==1){int d=random.nextInt(18)+8;if(random.nextInt(100)<20){d*=2;System.out.println(AMARELO+"CRITICO!"+RESET);}enemy-=d;System.out.println("Dano "+d);}else if(ac==2){int d=random.nextInt(6)+2;hp-=d;System.out.println("Defendeu. Dano "+d);continue;}else if(ac==3){int d=random.nextInt(30)+20;enemy-=d;System.out.println("NEON BURST "+d);}else{erro("Acao invalida");continue;}if(enemy>0){int d=random.nextInt(14)+6;hp-=d;System.out.println(nome+" causou "+d);}}if(hp>0){sucesso("VITORIA");vitorias++;ganharXP(120);}else erro("DERROTA");pausar();limparTela();
    }

    static void tesouro(){
        titulo("CACA AO TESOURO");partidas++;int tx=random.nextInt(6),ty=random.nextInt(6);for(int i=1;i<=7;i++){System.out.print("X 0-5: ");int x=lerInteiro();System.out.print("Y 0-5: ");int y=lerInteiro();if(x==tx&&y==ty){sucesso("TESOURO ENCONTRADO");vitorias++;ganharXP(100);pausar();limparTela();return;}System.out.println("Vazio.");}erro("Tesouro estava em "+tx+","+ty);pausar();limparTela();
    }

    static void roboArena(){
        titulo("ROBO ARENA");partidas++;int energia=60;int score=0;for(int i=1;i<=10&&energia>0;i++){int alvo=random.nextInt(3)+1;System.out.println("Rodada "+i+" | Alvo secreto: "+alvo);System.out.print("Escolha 1-3: ");int r=lerInteiro();if(r==alvo){score+=15;sucesso("Alvo destruido");}else{energia-=7;erro("Falha");}}System.out.println("Score "+score+" | Energia "+energia);ganharXP(score);pausar();limparTela();
    }

    static void quizRelampago(){
        titulo("QUIZ RELAMPAGO");partidas++;int ac=0;String[] q={"tipo true/false","palavra de objeto","primeiro indice","janela Swing","palavra de retorno"};int[] c={2,1,1,1,1};for(int i=0;i<q.length;i++){System.out.println((i+1)+") "+q[i]);System.out.println("1-A 2-B 3-C");if(lerInteiro()==c[i]){ac++;sucesso("OK");}else erro("ERRO");}System.out.println("Acertos "+ac+"/5");ganharXP(ac*20);pausar();limparTela();
    }

    static void somaRelampago(){
        titulo("SOMA RELAMPAGO");partidas++;int ac=0;for(int i=0;i<12;i++){int x=random.nextInt(50),y=random.nextInt(50);System.out.print(x+" + "+y+" = ");if(lerInteiro()==x+y){ac++;}else{} }System.out.println("Acertos "+ac+"/12");ganharXP(ac*8);pausar();limparTela();
    }

    static void binario(){
        titulo("CODIGO BINARIO");partidas++;int n=random.nextInt(32);String b=Integer.toBinaryString(n);System.out.println("Converta: "+b+" para decimal.");if(lerInteiro()==n){sucesso("Decodificado");ganharXP(75);}else erro("Era "+n);pausar();limparTela();
    }

    static void labirinto(){
        titulo("LABIRINTO TEXTUAL");partidas++;int pos=0;for(int i=0;i<8;i++){System.out.println("Posicao "+pos+" de 5");System.out.println("1-esquerda 2-direita");int r=lerInteiro();if(r==1)pos--;if(r==2)pos++;if(pos<0)pos=0;if(pos>=5){sucesso("SAIDA ENCONTRADA");ganharXP(90);pausar();limparTela();return;}}erro("Voce ficou preso.");pausar();limparTela();
    }

    static void hackerPuzzle(){
        titulo("HACKER PUZZLE - SIMULACAO");partidas++;int a=random.nextInt(9)+1;int b=random.nextInt(9)+1;System.out.println("NODE-A="+a);System.out.println("NODE-B="+b);System.out.println("Chave = A*B + A");if(lerInteiro()==a*b+a){sucesso("Puzzle resolvido");ganharXP(100);}else erro("Chave era "+(a*b+a));pausar();limparTela();
    }

    static void paresImpares(){
        titulo("PARES E IMPARES");partidas++;int n=random.nextInt(50)+1;System.out.println("Numero: "+n);System.out.println("1-par 2-impar");int r=lerInteiro();boolean par=n%2==0;if((par&&r==1)||(!par&&r==2)){sucesso("Correto");ganharXP(45);}else erro("Errado");pausar();limparTela();
    }

    static void senhaMestra(){
        titulo("SENHA MESTRA");partidas++;int codigo=random.nextInt(900)+100;System.out.println("Descubra o codigo de 3 digitos.");for(int i=0;i<5;i++){System.out.print("Tentativa: ");if(lerInteiro()==codigo){sucesso("Senha correta");ganharXP(100);pausar();limparTela();return;}System.out.println("Nao.");}erro("Codigo era "+codigo);pausar();limparTela();
    }

    static void alvoNumerico(){
        titulo("ALVO NUMERICO");partidas++;int alvo=random.nextInt(40)+10;System.out.println("Chegue exatamente a "+alvo+" usando +5 ou +3.");int atual=0;for(int i=0;i<10&&atual<alvo;i++){System.out.println("Atual "+atual+" | 1:+5 2:+3");int r=lerInteiro();if(r==1)atual+=5;else if(r==2)atual+=3;else erro("Comando");}if(atual==alvo){sucesso("Alvo atingido");ganharXP(90);}else erro("Voce terminou em "+atual);pausar();limparTela();
    }

    static void sequenciaCrescente(){
        titulo("SEQUENCIA CRESCENTE");partidas++;int a=random.nextInt(5)+1;int d=random.nextInt(4)+1;System.out.println(a+"  "+(a+d)+"  "+(a+2*d)+"  ?");int r=lerInteiro();if(r==a+3*d){sucesso("Perfeito");ganharXP(65);}else erro("Era "+(a+3*d));pausar();limparTela();
    }

    static void ganarXPSeguro(int q){ganharXP(q);}

    static void centroPC(){
        titulo("PC COMMAND CENTER");
        System.out.println("Sistema: " + System.getProperty("os.name"));
        System.out.println("Versao: " + System.getProperty("os.version"));
        System.out.println("Arquitetura: " + System.getProperty("os.arch"));
        System.out.println("Java: " + System.getProperty("java.version"));
        System.out.println("Nucleos logicos: " + String.valueOf(Runtime.getRuntime().availableProcessors()));
        System.out.println("Memoria maxima JVM: " + formatarMB(Runtime.getRuntime().maxMemory()));
        System.out.println("Memoria reservada JVM: " + formatarMB(Runtime.getRuntime().totalMemory()));
        System.out.println("Memoria livre JVM: " + formatarMB(Runtime.getRuntime().freeMemory()));
        categoria("MONITOR VISUAL");
        mostrarBarra("CPU",random.nextInt(80)+10);
        mostrarBarra("GPU",random.nextInt(70)+20);
        mostrarBarra("RAM",random.nextInt(75)+15);
        File[] roots=File.listRoots();
        if(roots!=null){for(File root:roots){System.out.println("Disco "+root.getPath()+" | Total "+formatarMB(root.getTotalSpace())+" | Livre "+formatarMB(root.getFreeSpace()));}}
        categoria("NOTA");
        System.out.println("CPU/GPU acima sao simulacoes visuais. Dados de sistema/JVM sao reais.");
        pausar(); limparTela();
    }

    static void interfaceGrafica(){
        JFrame janela=new JFrame("Nexus Java Academy Mega GUI");
        janela.setSize(850,500);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        JLabel topo=new JLabel("NEXUS JAVA ACADEMY",SwingConstants.CENTER);
        JLabel status=new JLabel("Nivel "+nivel+" | XP "+xp+"/100 | Pontos "+pontos,SwingConstants.CENTER);
        JButton estudos=new JButton("Estudos");
        JButton jogos=new JButton("Minigames");
        JButton pc=new JButton("PC Info");
        JButton progresso=new JButton("Progresso");
        estudos.addActionListener(e->JOptionPane.showMessageDialog(janela,"Use o terminal para acessar a biblioteca e as aulas."));
        jogos.addActionListener(e->JOptionPane.showMessageDialog(janela,"Mais de 20 minigames estao no Mega Arcade."));
        pc.addActionListener(e->JOptionPane.showMessageDialog(janela,"Sistema: "+System.getProperty("os.name")+"\nJava: "+System.getProperty("java.version")+"\nNucleos: "+Runtime.getRuntime().availableProcessors()));
        progresso.addActionListener(e->JOptionPane.showMessageDialog(janela,"Nivel "+nivel+"\nXP "+xp+"/100\nPontos "+pontos+"\nAcertos "+acertos));
        JPanel painel=new JPanel(new GridLayout(2,2,12,12));
        painel.add(estudos);painel.add(jogos);painel.add(pc);painel.add(progresso);
        janela.add(topo,BorderLayout.NORTH);
        janela.add(painel,BorderLayout.CENTER);
        janela.add(status,BorderLayout.SOUTH);
        janela.setVisible(true);
        ganharXP(5);
    }

    static void perfil(){
        titulo("PERFIL DO OPERADOR");
        System.out.println("Operador: Rafael");
        System.out.println("Nivel: "+nivel);
        System.out.println("XP: "+xp+"/100");
        System.out.println("Pontos: "+pontos);
        System.out.println("Moedas: "+moedas);
        System.out.println("Acertos: "+acertos);
        System.out.println("Erros: "+erros);
        System.out.println("Partidas: "+partidas);
        System.out.println("Vitorias: "+vitorias);
        System.out.println("Maior combo: "+maiorCombo);
        System.out.println("Modulos concluidos: "+modulosConcluidos);
        mostrarBarra("XP",xp);
        categoria("RANK");
        if(nivel>=15)System.out.println(ROXO+"JAVA LEGEND"+RESET);else if(nivel>=10)System.out.println(ROXO+"JAVA MASTER"+RESET);else if(nivel>=5)System.out.println(CIANO+"JAVA EXPLORER"+RESET);else System.out.println(AMARELO+"APRENDIZ"+RESET);
        pausar();limparTela();
    }

    static void conquistas(){
        titulo("CONQUISTAS");
        System.out.println((acertos>=1?VERDE+"[X] ":VERMELHO+"[ ] ")+"Primeiro acerto"+RESET);
        System.out.println((acertos>=10?VERDE+"[X] ":VERMELHO+"[ ] ")+"10 acertos"+RESET);
        System.out.println((vitorias>=1?VERDE+"[X] ":VERMELHO+"[ ] ")+"Primeira vitoria"+RESET);
        System.out.println((pontos>=500?VERDE+"[X] ":VERMELHO+"[ ] ")+"500 pontos"+RESET);
        System.out.println((nivel>=5?VERDE+"[X] ":VERMELHO+"[ ] ")+"Nivel 5"+RESET);
        System.out.println((partidas>=20?VERDE+"[X] ":VERMELHO+"[ ] ")+"20 partidas"+RESET);
        System.out.println((moedas>=100?VERDE+"[X] ":VERMELHO+"[ ] ")+"100 moedas"+RESET);
        System.out.println((maiorCombo>=10?VERDE+"[X] ":VERMELHO+"[ ] ")+"Combo 10"+RESET);
        System.out.println((modulosConcluidos>=50?VERDE+"[X] ":VERMELHO+"[ ] ")+"50 modulos"+RESET);
        pausar();limparTela();
    }

    static void treinoLivre(){
        titulo("TREINO LIVRE");
        System.out.println("Digite 1 para gerar um exercicio aleatorio.");
        System.out.println("Digite 0 para voltar.");
        int r=lerInteiro();
        if(r==1){
            int tipo=random.nextInt(4);
            if(tipo==0)desafioSaida();else if(tipo==1)desafioBug();else if(tipo==2)desafioArray();else desafioLogica();
        }
        limparTela();
    }

    static void megaBiblioteca(){
        int n;
        do{
            titulo("MEGA BIBLIOTECA - 500 MODULOS");
            System.out.println("Digite um numero de 1 a 500. Digite 0 para sair.");
            System.out.print("Modulo > ");
            n=lerInteiro();
            limparTela();
            if(n==0)break;
            if(n<1||n>500){erro("Modulo invalido.");pausar();limparTela();continue;}
            abrirModulo(n);
        }while(n!=0);
        limparTela();
    }

    static void abrirModulo(int n){
        switch(n){
            case 1: modulo001(); break;
            case 2: modulo002(); break;
            case 3: modulo003(); break;
            case 4: modulo004(); break;
            case 5: modulo005(); break;
            case 6: modulo006(); break;
            case 7: modulo007(); break;
            case 8: modulo008(); break;
            case 9: modulo009(); break;
            case 10: modulo010(); break;
            case 11: modulo011(); break;
            case 12: modulo012(); break;
            case 13: modulo013(); break;
            case 14: modulo014(); break;
            case 15: modulo015(); break;
            case 16: modulo016(); break;
            case 17: modulo017(); break;
            case 18: modulo018(); break;
            case 19: modulo019(); break;
            case 20: modulo020(); break;
            case 21: modulo021(); break;
            case 22: modulo022(); break;
            case 23: modulo023(); break;
            case 24: modulo024(); break;
            case 25: modulo025(); break;
            case 26: modulo026(); break;
            case 27: modulo027(); break;
            case 28: modulo028(); break;
            case 29: modulo029(); break;
            case 30: modulo030(); break;
            case 31: modulo031(); break;
            case 32: modulo032(); break;
            case 33: modulo033(); break;
            case 34: modulo034(); break;
            case 35: modulo035(); break;
            case 36: modulo036(); break;
            case 37: modulo037(); break;
            case 38: modulo038(); break;
            case 39: modulo039(); break;
            case 40: modulo040(); break;
            case 41: modulo041(); break;
            case 42: modulo042(); break;
            case 43: modulo043(); break;
            case 44: modulo044(); break;
            case 45: modulo045(); break;
            case 46: modulo046(); break;
            case 47: modulo047(); break;
            case 48: modulo048(); break;
            case 49: modulo049(); break;
            case 50: modulo050(); break;
            case 51: modulo051(); break;
            case 52: modulo052(); break;
            case 53: modulo053(); break;
            case 54: modulo054(); break;
            case 55: modulo055(); break;
            case 56: modulo056(); break;
            case 57: modulo057(); break;
            case 58: modulo058(); break;
            case 59: modulo059(); break;
            case 60: modulo060(); break;
            case 61: modulo061(); break;
            case 62: modulo062(); break;
            case 63: modulo063(); break;
            case 64: modulo064(); break;
            case 65: modulo065(); break;
            case 66: modulo066(); break;
            case 67: modulo067(); break;
            case 68: modulo068(); break;
            case 69: modulo069(); break;
            case 70: modulo070(); break;
            case 71: modulo071(); break;
            case 72: modulo072(); break;
            case 73: modulo073(); break;
            case 74: modulo074(); break;
            case 75: modulo075(); break;
            case 76: modulo076(); break;
            case 77: modulo077(); break;
            case 78: modulo078(); break;
            case 79: modulo079(); break;
            case 80: modulo080(); break;
            case 81: modulo081(); break;
            case 82: modulo082(); break;
            case 83: modulo083(); break;
            case 84: modulo084(); break;
            case 85: modulo085(); break;
            case 86: modulo086(); break;
            case 87: modulo087(); break;
            case 88: modulo088(); break;
            case 89: modulo089(); break;
            case 90: modulo090(); break;
            case 91: modulo091(); break;
            case 92: modulo092(); break;
            case 93: modulo093(); break;
            case 94: modulo094(); break;
            case 95: modulo095(); break;
            case 96: modulo096(); break;
            case 97: modulo097(); break;
            case 98: modulo098(); break;
            case 99: modulo099(); break;
            case 100: modulo100(); break;
            case 101: modulo101(); break;
            case 102: modulo102(); break;
            case 103: modulo103(); break;
            case 104: modulo104(); break;
            case 105: modulo105(); break;
            case 106: modulo106(); break;
            case 107: modulo107(); break;
            case 108: modulo108(); break;
            case 109: modulo109(); break;
            case 110: modulo110(); break;
            case 111: modulo111(); break;
            case 112: modulo112(); break;
            case 113: modulo113(); break;
            case 114: modulo114(); break;
            case 115: modulo115(); break;
            case 116: modulo116(); break;
            case 117: modulo117(); break;
            case 118: modulo118(); break;
            case 119: modulo119(); break;
            case 120: modulo120(); break;
            case 121: modulo121(); break;
            case 122: modulo122(); break;
            case 123: modulo123(); break;
            case 124: modulo124(); break;
            case 125: modulo125(); break;
            case 126: modulo126(); break;
            case 127: modulo127(); break;
            case 128: modulo128(); break;
            case 129: modulo129(); break;
            case 130: modulo130(); break;
            case 131: modulo131(); break;
            case 132: modulo132(); break;
            case 133: modulo133(); break;
            case 134: modulo134(); break;
            case 135: modulo135(); break;
            case 136: modulo136(); break;
            case 137: modulo137(); break;
            case 138: modulo138(); break;
            case 139: modulo139(); break;
            case 140: modulo140(); break;
            case 141: modulo141(); break;
            case 142: modulo142(); break;
            case 143: modulo143(); break;
            case 144: modulo144(); break;
            case 145: modulo145(); break;
            case 146: modulo146(); break;
            case 147: modulo147(); break;
            case 148: modulo148(); break;
            case 149: modulo149(); break;
            case 150: modulo150(); break;
            case 151: modulo151(); break;
            case 152: modulo152(); break;
            case 153: modulo153(); break;
            case 154: modulo154(); break;
            case 155: modulo155(); break;
            case 156: modulo156(); break;
            case 157: modulo157(); break;
            case 158: modulo158(); break;
            case 159: modulo159(); break;
            case 160: modulo160(); break;
            case 161: modulo161(); break;
            case 162: modulo162(); break;
            case 163: modulo163(); break;
            case 164: modulo164(); break;
            case 165: modulo165(); break;
            case 166: modulo166(); break;
            case 167: modulo167(); break;
            case 168: modulo168(); break;
            case 169: modulo169(); break;
            case 170: modulo170(); break;
            case 171: modulo171(); break;
            case 172: modulo172(); break;
            case 173: modulo173(); break;
            case 174: modulo174(); break;
            case 175: modulo175(); break;
            case 176: modulo176(); break;
            case 177: modulo177(); break;
            case 178: modulo178(); break;
            case 179: modulo179(); break;
            case 180: modulo180(); break;
            case 181: modulo181(); break;
            case 182: modulo182(); break;
            case 183: modulo183(); break;
            case 184: modulo184(); break;
            case 185: modulo185(); break;
            case 186: modulo186(); break;
            case 187: modulo187(); break;
            case 188: modulo188(); break;
            case 189: modulo189(); break;
            case 190: modulo190(); break;
            case 191: modulo191(); break;
            case 192: modulo192(); break;
            case 193: modulo193(); break;
            case 194: modulo194(); break;
            case 195: modulo195(); break;
            case 196: modulo196(); break;
            case 197: modulo197(); break;
            case 198: modulo198(); break;
            case 199: modulo199(); break;
            case 200: modulo200(); break;
            case 201: modulo201(); break;
            case 202: modulo202(); break;
            case 203: modulo203(); break;
            case 204: modulo204(); break;
            case 205: modulo205(); break;
            case 206: modulo206(); break;
            case 207: modulo207(); break;
            case 208: modulo208(); break;
            case 209: modulo209(); break;
            case 210: modulo210(); break;
            case 211: modulo211(); break;
            case 212: modulo212(); break;
            case 213: modulo213(); break;
            case 214: modulo214(); break;
            case 215: modulo215(); break;
            case 216: modulo216(); break;
            case 217: modulo217(); break;
            case 218: modulo218(); break;
            case 219: modulo219(); break;
            case 220: modulo220(); break;
            case 221: modulo221(); break;
            case 222: modulo222(); break;
            case 223: modulo223(); break;
            case 224: modulo224(); break;
            case 225: modulo225(); break;
            case 226: modulo226(); break;
            case 227: modulo227(); break;
            case 228: modulo228(); break;
            case 229: modulo229(); break;
            case 230: modulo230(); break;
            case 231: modulo231(); break;
            case 232: modulo232(); break;
            case 233: modulo233(); break;
            case 234: modulo234(); break;
            case 235: modulo235(); break;
            case 236: modulo236(); break;
            case 237: modulo237(); break;
            case 238: modulo238(); break;
            case 239: modulo239(); break;
            case 240: modulo240(); break;
            case 241: modulo241(); break;
            case 242: modulo242(); break;
            case 243: modulo243(); break;
            case 244: modulo244(); break;
            case 245: modulo245(); break;
            case 246: modulo246(); break;
            case 247: modulo247(); break;
            case 248: modulo248(); break;
            case 249: modulo249(); break;
            case 250: modulo250(); break;
            case 251: modulo251(); break;
            case 252: modulo252(); break;
            case 253: modulo253(); break;
            case 254: modulo254(); break;
            case 255: modulo255(); break;
            case 256: modulo256(); break;
            case 257: modulo257(); break;
            case 258: modulo258(); break;
            case 259: modulo259(); break;
            case 260: modulo260(); break;
            case 261: modulo261(); break;
            case 262: modulo262(); break;
            case 263: modulo263(); break;
            case 264: modulo264(); break;
            case 265: modulo265(); break;
            case 266: modulo266(); break;
            case 267: modulo267(); break;
            case 268: modulo268(); break;
            case 269: modulo269(); break;
            case 270: modulo270(); break;
            case 271: modulo271(); break;
            case 272: modulo272(); break;
            case 273: modulo273(); break;
            case 274: modulo274(); break;
            case 275: modulo275(); break;
            case 276: modulo276(); break;
            case 277: modulo277(); break;
            case 278: modulo278(); break;
            case 279: modulo279(); break;
            case 280: modulo280(); break;
            case 281: modulo281(); break;
            case 282: modulo282(); break;
            case 283: modulo283(); break;
            case 284: modulo284(); break;
            case 285: modulo285(); break;
            case 286: modulo286(); break;
            case 287: modulo287(); break;
            case 288: modulo288(); break;
            case 289: modulo289(); break;
            case 290: modulo290(); break;
            case 291: modulo291(); break;
            case 292: modulo292(); break;
            case 293: modulo293(); break;
            case 294: modulo294(); break;
            case 295: modulo295(); break;
            case 296: modulo296(); break;
            case 297: modulo297(); break;
            case 298: modulo298(); break;
            case 299: modulo299(); break;
            case 300: modulo300(); break;
            case 301: modulo301(); break;
            case 302: modulo302(); break;
            case 303: modulo303(); break;
            case 304: modulo304(); break;
            case 305: modulo305(); break;
            case 306: modulo306(); break;
            case 307: modulo307(); break;
            case 308: modulo308(); break;
            case 309: modulo309(); break;
            case 310: modulo310(); break;
            case 311: modulo311(); break;
            case 312: modulo312(); break;
            case 313: modulo313(); break;
            case 314: modulo314(); break;
            case 315: modulo315(); break;
            case 316: modulo316(); break;
            case 317: modulo317(); break;
            case 318: modulo318(); break;
            case 319: modulo319(); break;
            case 320: modulo320(); break;
            case 321: modulo321(); break;
            case 322: modulo322(); break;
            case 323: modulo323(); break;
            case 324: modulo324(); break;
            case 325: modulo325(); break;
            case 326: modulo326(); break;
            case 327: modulo327(); break;
            case 328: modulo328(); break;
            case 329: modulo329(); break;
            case 330: modulo330(); break;
            case 331: modulo331(); break;
            case 332: modulo332(); break;
            case 333: modulo333(); break;
            case 334: modulo334(); break;
            case 335: modulo335(); break;
            case 336: modulo336(); break;
            case 337: modulo337(); break;
            case 338: modulo338(); break;
            case 339: modulo339(); break;
            case 340: modulo340(); break;
            case 341: modulo341(); break;
            case 342: modulo342(); break;
            case 343: modulo343(); break;
            case 344: modulo344(); break;
            case 345: modulo345(); break;
            case 346: modulo346(); break;
            case 347: modulo347(); break;
            case 348: modulo348(); break;
            case 349: modulo349(); break;
            case 350: modulo350(); break;
            case 351: modulo351(); break;
            case 352: modulo352(); break;
            case 353: modulo353(); break;
            case 354: modulo354(); break;
            case 355: modulo355(); break;
            case 356: modulo356(); break;
            case 357: modulo357(); break;
            case 358: modulo358(); break;
            case 359: modulo359(); break;
            case 360: modulo360(); break;
            case 361: modulo361(); break;
            case 362: modulo362(); break;
            case 363: modulo363(); break;
            case 364: modulo364(); break;
            case 365: modulo365(); break;
            case 366: modulo366(); break;
            case 367: modulo367(); break;
            case 368: modulo368(); break;
            case 369: modulo369(); break;
            case 370: modulo370(); break;
            case 371: modulo371(); break;
            case 372: modulo372(); break;
            case 373: modulo373(); break;
            case 374: modulo374(); break;
            case 375: modulo375(); break;
            case 376: modulo376(); break;
            case 377: modulo377(); break;
            case 378: modulo378(); break;
            case 379: modulo379(); break;
            case 380: modulo380(); break;
            case 381: modulo381(); break;
            case 382: modulo382(); break;
            case 383: modulo383(); break;
            case 384: modulo384(); break;
            case 385: modulo385(); break;
            case 386: modulo386(); break;
            case 387: modulo387(); break;
            case 388: modulo388(); break;
            case 389: modulo389(); break;
            case 390: modulo390(); break;
            case 391: modulo391(); break;
            case 392: modulo392(); break;
            case 393: modulo393(); break;
            case 394: modulo394(); break;
            case 395: modulo395(); break;
            case 396: modulo396(); break;
            case 397: modulo397(); break;
            case 398: modulo398(); break;
            case 399: modulo399(); break;
            case 400: modulo400(); break;
            case 401: modulo401(); break;
            case 402: modulo402(); break;
            case 403: modulo403(); break;
            case 404: modulo404(); break;
            case 405: modulo405(); break;
            case 406: modulo406(); break;
            case 407: modulo407(); break;
            case 408: modulo408(); break;
            case 409: modulo409(); break;
            case 410: modulo410(); break;
            case 411: modulo411(); break;
            case 412: modulo412(); break;
            case 413: modulo413(); break;
            case 414: modulo414(); break;
            case 415: modulo415(); break;
            case 416: modulo416(); break;
            case 417: modulo417(); break;
            case 418: modulo418(); break;
            case 419: modulo419(); break;
            case 420: modulo420(); break;
            case 421: modulo421(); break;
            case 422: modulo422(); break;
            case 423: modulo423(); break;
            case 424: modulo424(); break;
            case 425: modulo425(); break;
            case 426: modulo426(); break;
            case 427: modulo427(); break;
            case 428: modulo428(); break;
            case 429: modulo429(); break;
            case 430: modulo430(); break;
            case 431: modulo431(); break;
            case 432: modulo432(); break;
            case 433: modulo433(); break;
            case 434: modulo434(); break;
            case 435: modulo435(); break;
            case 436: modulo436(); break;
            case 437: modulo437(); break;
            case 438: modulo438(); break;
            case 439: modulo439(); break;
            case 440: modulo440(); break;
            case 441: modulo441(); break;
            case 442: modulo442(); break;
            case 443: modulo443(); break;
            case 444: modulo444(); break;
            case 445: modulo445(); break;
            case 446: modulo446(); break;
            case 447: modulo447(); break;
            case 448: modulo448(); break;
            case 449: modulo449(); break;
            case 450: modulo450(); break;
            case 451: modulo451(); break;
            case 452: modulo452(); break;
            case 453: modulo453(); break;
            case 454: modulo454(); break;
            case 455: modulo455(); break;
            case 456: modulo456(); break;
            case 457: modulo457(); break;
            case 458: modulo458(); break;
            case 459: modulo459(); break;
            case 460: modulo460(); break;
            case 461: modulo461(); break;
            case 462: modulo462(); break;
            case 463: modulo463(); break;
            case 464: modulo464(); break;
            case 465: modulo465(); break;
            case 466: modulo466(); break;
            case 467: modulo467(); break;
            case 468: modulo468(); break;
            case 469: modulo469(); break;
            case 470: modulo470(); break;
            case 471: modulo471(); break;
            case 472: modulo472(); break;
            case 473: modulo473(); break;
            case 474: modulo474(); break;
            case 475: modulo475(); break;
            case 476: modulo476(); break;
            case 477: modulo477(); break;
            case 478: modulo478(); break;
            case 479: modulo479(); break;
            case 480: modulo480(); break;
            case 481: modulo481(); break;
            case 482: modulo482(); break;
            case 483: modulo483(); break;
            case 484: modulo484(); break;
            case 485: modulo485(); break;
            case 486: modulo486(); break;
            case 487: modulo487(); break;
            case 488: modulo488(); break;
            case 489: modulo489(); break;
            case 490: modulo490(); break;
            case 491: modulo491(); break;
            case 492: modulo492(); break;
            case 493: modulo493(); break;
            case 494: modulo494(); break;
            case 495: modulo495(); break;
            case 496: modulo496(); break;
            case 497: modulo497(); break;
            case 498: modulo498(); break;
            case 499: modulo499(); break;
            case 500: modulo500(); break;
            default: break;
        }
        modulosConcluidos++;
    }

    static void modulo001(){
        titulo("MODULO 001 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 001: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo002(){
        titulo("MODULO 002 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 002: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo003(){
        titulo("MODULO 003 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 003: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo004(){
        titulo("MODULO 004 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 004: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo005(){
        titulo("MODULO 005 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 005: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo006(){
        titulo("MODULO 006 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 006: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo007(){
        titulo("MODULO 007 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 007: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo008(){
        titulo("MODULO 008 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 008: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo009(){
        titulo("MODULO 009 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 009: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo010(){
        titulo("MODULO 010 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 010: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo011(){
        titulo("MODULO 011 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 011: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo012(){
        titulo("MODULO 012 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 012: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo013(){
        titulo("MODULO 013 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 013: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo014(){
        titulo("MODULO 014 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 014: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo015(){
        titulo("MODULO 015 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 015: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo016(){
        titulo("MODULO 016 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 016: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo017(){
        titulo("MODULO 017 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 017: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo018(){
        titulo("MODULO 018 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 018: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo019(){
        titulo("MODULO 019 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 019: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo020(){
        titulo("MODULO 020 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 020: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo021(){
        titulo("MODULO 021 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 021: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo022(){
        titulo("MODULO 022 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 022: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo023(){
        titulo("MODULO 023 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 023: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo024(){
        titulo("MODULO 024 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 024: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo025(){
        titulo("MODULO 025 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 025: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo026(){
        titulo("MODULO 026 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 026: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo027(){
        titulo("MODULO 027 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 027: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo028(){
        titulo("MODULO 028 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 028: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo029(){
        titulo("MODULO 029 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 029: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo030(){
        titulo("MODULO 030 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 030: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo031(){
        titulo("MODULO 031 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 031: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo032(){
        titulo("MODULO 032 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 032: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo033(){
        titulo("MODULO 033 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 033: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo034(){
        titulo("MODULO 034 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 034: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo035(){
        titulo("MODULO 035 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 035: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo036(){
        titulo("MODULO 036 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 036: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo037(){
        titulo("MODULO 037 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 037: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo038(){
        titulo("MODULO 038 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 038: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo039(){
        titulo("MODULO 039 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 039: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo040(){
        titulo("MODULO 040 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 040: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo041(){
        titulo("MODULO 041 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 041: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo042(){
        titulo("MODULO 042 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 042: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo043(){
        titulo("MODULO 043 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 043: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo044(){
        titulo("MODULO 044 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 044: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo045(){
        titulo("MODULO 045 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 045: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo046(){
        titulo("MODULO 046 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 046: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo047(){
        titulo("MODULO 047 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 047: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo048(){
        titulo("MODULO 048 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 048: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo049(){
        titulo("MODULO 049 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 049: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo050(){
        titulo("MODULO 050 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 050: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo051(){
        titulo("MODULO 051 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 051: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo052(){
        titulo("MODULO 052 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 052: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo053(){
        titulo("MODULO 053 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 053: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo054(){
        titulo("MODULO 054 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 054: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo055(){
        titulo("MODULO 055 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 055: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo056(){
        titulo("MODULO 056 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 056: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo057(){
        titulo("MODULO 057 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 057: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo058(){
        titulo("MODULO 058 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 058: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo059(){
        titulo("MODULO 059 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 059: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo060(){
        titulo("MODULO 060 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 060: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo061(){
        titulo("MODULO 061 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 061: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo062(){
        titulo("MODULO 062 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 062: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo063(){
        titulo("MODULO 063 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 063: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo064(){
        titulo("MODULO 064 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 064: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo065(){
        titulo("MODULO 065 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 065: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo066(){
        titulo("MODULO 066 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 066: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo067(){
        titulo("MODULO 067 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 067: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo068(){
        titulo("MODULO 068 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 068: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo069(){
        titulo("MODULO 069 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 069: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo070(){
        titulo("MODULO 070 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 070: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo071(){
        titulo("MODULO 071 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 071: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo072(){
        titulo("MODULO 072 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 072: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo073(){
        titulo("MODULO 073 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 073: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo074(){
        titulo("MODULO 074 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 074: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo075(){
        titulo("MODULO 075 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 075: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo076(){
        titulo("MODULO 076 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 076: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo077(){
        titulo("MODULO 077 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 077: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo078(){
        titulo("MODULO 078 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 078: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo079(){
        titulo("MODULO 079 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 079: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo080(){
        titulo("MODULO 080 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 080: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo081(){
        titulo("MODULO 081 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 081: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo082(){
        titulo("MODULO 082 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 082: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo083(){
        titulo("MODULO 083 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 083: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo084(){
        titulo("MODULO 084 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 084: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo085(){
        titulo("MODULO 085 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 085: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo086(){
        titulo("MODULO 086 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 086: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo087(){
        titulo("MODULO 087 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 087: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo088(){
        titulo("MODULO 088 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 088: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo089(){
        titulo("MODULO 089 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 089: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo090(){
        titulo("MODULO 090 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 090: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo091(){
        titulo("MODULO 091 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 091: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo092(){
        titulo("MODULO 092 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 092: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo093(){
        titulo("MODULO 093 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 093: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo094(){
        titulo("MODULO 094 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 094: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo095(){
        titulo("MODULO 095 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 095: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo096(){
        titulo("MODULO 096 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 096: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo097(){
        titulo("MODULO 097 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 097: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo098(){
        titulo("MODULO 098 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 098: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo099(){
        titulo("MODULO 099 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 099: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo100(){
        titulo("MODULO 100 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 100: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo101(){
        titulo("MODULO 101 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 101: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo102(){
        titulo("MODULO 102 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 102: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo103(){
        titulo("MODULO 103 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 103: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo104(){
        titulo("MODULO 104 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 104: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo105(){
        titulo("MODULO 105 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 105: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo106(){
        titulo("MODULO 106 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 106: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo107(){
        titulo("MODULO 107 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 107: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo108(){
        titulo("MODULO 108 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 108: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo109(){
        titulo("MODULO 109 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 109: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo110(){
        titulo("MODULO 110 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 110: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo111(){
        titulo("MODULO 111 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 111: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo112(){
        titulo("MODULO 112 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 112: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo113(){
        titulo("MODULO 113 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 113: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo114(){
        titulo("MODULO 114 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 114: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo115(){
        titulo("MODULO 115 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 115: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo116(){
        titulo("MODULO 116 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 116: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo117(){
        titulo("MODULO 117 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 117: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo118(){
        titulo("MODULO 118 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 118: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo119(){
        titulo("MODULO 119 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 119: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo120(){
        titulo("MODULO 120 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 120: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo121(){
        titulo("MODULO 121 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 121: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo122(){
        titulo("MODULO 122 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 122: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo123(){
        titulo("MODULO 123 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 123: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo124(){
        titulo("MODULO 124 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 124: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo125(){
        titulo("MODULO 125 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 125: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo126(){
        titulo("MODULO 126 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 126: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo127(){
        titulo("MODULO 127 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 127: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo128(){
        titulo("MODULO 128 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 128: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo129(){
        titulo("MODULO 129 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 129: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo130(){
        titulo("MODULO 130 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 130: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo131(){
        titulo("MODULO 131 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 131: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo132(){
        titulo("MODULO 132 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 132: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo133(){
        titulo("MODULO 133 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 133: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo134(){
        titulo("MODULO 134 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 134: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo135(){
        titulo("MODULO 135 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 135: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo136(){
        titulo("MODULO 136 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 136: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo137(){
        titulo("MODULO 137 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 137: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo138(){
        titulo("MODULO 138 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 138: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo139(){
        titulo("MODULO 139 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 139: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo140(){
        titulo("MODULO 140 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 140: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo141(){
        titulo("MODULO 141 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 141: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo142(){
        titulo("MODULO 142 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 142: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo143(){
        titulo("MODULO 143 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 143: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo144(){
        titulo("MODULO 144 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 144: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo145(){
        titulo("MODULO 145 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 145: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo146(){
        titulo("MODULO 146 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 146: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo147(){
        titulo("MODULO 147 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 147: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo148(){
        titulo("MODULO 148 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 148: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo149(){
        titulo("MODULO 149 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 149: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo150(){
        titulo("MODULO 150 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 150: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo151(){
        titulo("MODULO 151 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 151: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo152(){
        titulo("MODULO 152 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 152: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo153(){
        titulo("MODULO 153 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 153: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo154(){
        titulo("MODULO 154 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 154: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo155(){
        titulo("MODULO 155 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 155: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo156(){
        titulo("MODULO 156 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 156: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo157(){
        titulo("MODULO 157 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 157: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo158(){
        titulo("MODULO 158 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 158: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo159(){
        titulo("MODULO 159 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 159: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo160(){
        titulo("MODULO 160 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 160: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo161(){
        titulo("MODULO 161 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 161: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo162(){
        titulo("MODULO 162 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 162: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo163(){
        titulo("MODULO 163 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 163: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo164(){
        titulo("MODULO 164 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 164: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo165(){
        titulo("MODULO 165 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 165: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo166(){
        titulo("MODULO 166 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 166: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo167(){
        titulo("MODULO 167 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 167: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo168(){
        titulo("MODULO 168 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 168: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo169(){
        titulo("MODULO 169 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 169: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo170(){
        titulo("MODULO 170 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 170: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo171(){
        titulo("MODULO 171 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 171: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo172(){
        titulo("MODULO 172 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 172: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo173(){
        titulo("MODULO 173 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 173: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo174(){
        titulo("MODULO 174 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 174: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo175(){
        titulo("MODULO 175 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 175: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo176(){
        titulo("MODULO 176 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 176: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo177(){
        titulo("MODULO 177 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 177: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo178(){
        titulo("MODULO 178 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 178: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo179(){
        titulo("MODULO 179 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 179: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo180(){
        titulo("MODULO 180 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 180: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo181(){
        titulo("MODULO 181 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 181: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo182(){
        titulo("MODULO 182 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 182: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo183(){
        titulo("MODULO 183 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 183: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo184(){
        titulo("MODULO 184 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 184: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo185(){
        titulo("MODULO 185 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 185: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo186(){
        titulo("MODULO 186 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 186: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo187(){
        titulo("MODULO 187 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 187: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo188(){
        titulo("MODULO 188 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 188: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo189(){
        titulo("MODULO 189 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 189: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo190(){
        titulo("MODULO 190 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 190: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo191(){
        titulo("MODULO 191 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 191: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo192(){
        titulo("MODULO 192 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 192: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo193(){
        titulo("MODULO 193 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 193: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo194(){
        titulo("MODULO 194 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 194: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo195(){
        titulo("MODULO 195 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 195: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo196(){
        titulo("MODULO 196 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 196: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo197(){
        titulo("MODULO 197 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 197: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo198(){
        titulo("MODULO 198 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 198: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo199(){
        titulo("MODULO 199 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 199: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo200(){
        titulo("MODULO 200 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 200: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo201(){
        titulo("MODULO 201 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 201: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo202(){
        titulo("MODULO 202 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 202: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo203(){
        titulo("MODULO 203 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 203: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo204(){
        titulo("MODULO 204 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 204: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo205(){
        titulo("MODULO 205 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 205: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo206(){
        titulo("MODULO 206 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 206: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo207(){
        titulo("MODULO 207 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 207: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo208(){
        titulo("MODULO 208 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 208: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo209(){
        titulo("MODULO 209 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 209: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo210(){
        titulo("MODULO 210 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 210: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo211(){
        titulo("MODULO 211 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 211: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo212(){
        titulo("MODULO 212 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 212: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo213(){
        titulo("MODULO 213 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 213: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo214(){
        titulo("MODULO 214 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 214: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo215(){
        titulo("MODULO 215 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 215: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo216(){
        titulo("MODULO 216 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 216: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo217(){
        titulo("MODULO 217 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 217: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo218(){
        titulo("MODULO 218 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 218: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo219(){
        titulo("MODULO 219 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 219: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo220(){
        titulo("MODULO 220 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 220: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo221(){
        titulo("MODULO 221 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 221: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo222(){
        titulo("MODULO 222 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 222: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo223(){
        titulo("MODULO 223 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 223: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo224(){
        titulo("MODULO 224 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 224: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo225(){
        titulo("MODULO 225 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 225: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo226(){
        titulo("MODULO 226 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 226: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo227(){
        titulo("MODULO 227 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 227: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo228(){
        titulo("MODULO 228 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 228: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo229(){
        titulo("MODULO 229 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 229: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo230(){
        titulo("MODULO 230 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 230: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo231(){
        titulo("MODULO 231 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 231: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo232(){
        titulo("MODULO 232 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 232: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo233(){
        titulo("MODULO 233 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 233: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo234(){
        titulo("MODULO 234 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 234: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo235(){
        titulo("MODULO 235 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 235: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo236(){
        titulo("MODULO 236 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 236: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo237(){
        titulo("MODULO 237 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 237: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo238(){
        titulo("MODULO 238 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 238: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo239(){
        titulo("MODULO 239 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 239: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo240(){
        titulo("MODULO 240 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 240: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo241(){
        titulo("MODULO 241 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 241: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo242(){
        titulo("MODULO 242 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 242: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo243(){
        titulo("MODULO 243 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 243: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo244(){
        titulo("MODULO 244 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 244: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo245(){
        titulo("MODULO 245 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 245: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo246(){
        titulo("MODULO 246 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 246: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo247(){
        titulo("MODULO 247 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 247: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo248(){
        titulo("MODULO 248 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 248: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo249(){
        titulo("MODULO 249 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 249: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo250(){
        titulo("MODULO 250 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 250: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo251(){
        titulo("MODULO 251 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 251: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo252(){
        titulo("MODULO 252 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 252: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo253(){
        titulo("MODULO 253 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 253: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo254(){
        titulo("MODULO 254 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 254: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo255(){
        titulo("MODULO 255 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 255: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo256(){
        titulo("MODULO 256 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 256: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo257(){
        titulo("MODULO 257 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 257: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo258(){
        titulo("MODULO 258 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 258: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo259(){
        titulo("MODULO 259 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 259: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo260(){
        titulo("MODULO 260 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 260: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo261(){
        titulo("MODULO 261 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 261: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo262(){
        titulo("MODULO 262 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 262: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo263(){
        titulo("MODULO 263 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 263: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo264(){
        titulo("MODULO 264 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 264: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo265(){
        titulo("MODULO 265 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 265: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo266(){
        titulo("MODULO 266 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 266: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo267(){
        titulo("MODULO 267 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 267: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo268(){
        titulo("MODULO 268 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 268: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo269(){
        titulo("MODULO 269 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 269: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo270(){
        titulo("MODULO 270 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 270: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo271(){
        titulo("MODULO 271 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 271: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo272(){
        titulo("MODULO 272 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 272: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo273(){
        titulo("MODULO 273 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 273: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo274(){
        titulo("MODULO 274 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 274: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo275(){
        titulo("MODULO 275 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 275: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo276(){
        titulo("MODULO 276 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 276: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo277(){
        titulo("MODULO 277 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 277: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo278(){
        titulo("MODULO 278 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 278: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo279(){
        titulo("MODULO 279 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 279: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo280(){
        titulo("MODULO 280 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 280: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo281(){
        titulo("MODULO 281 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 281: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo282(){
        titulo("MODULO 282 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 282: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo283(){
        titulo("MODULO 283 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 283: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo284(){
        titulo("MODULO 284 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 284: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo285(){
        titulo("MODULO 285 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 285: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo286(){
        titulo("MODULO 286 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 286: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo287(){
        titulo("MODULO 287 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 287: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo288(){
        titulo("MODULO 288 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 288: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo289(){
        titulo("MODULO 289 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 289: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo290(){
        titulo("MODULO 290 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 290: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo291(){
        titulo("MODULO 291 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 291: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo292(){
        titulo("MODULO 292 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 292: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo293(){
        titulo("MODULO 293 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 293: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo294(){
        titulo("MODULO 294 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 294: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo295(){
        titulo("MODULO 295 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 295: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo296(){
        titulo("MODULO 296 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 296: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo297(){
        titulo("MODULO 297 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 297: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo298(){
        titulo("MODULO 298 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 298: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo299(){
        titulo("MODULO 299 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 299: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo300(){
        titulo("MODULO 300 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 300: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo301(){
        titulo("MODULO 301 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 301: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo302(){
        titulo("MODULO 302 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 302: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo303(){
        titulo("MODULO 303 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 303: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo304(){
        titulo("MODULO 304 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 304: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo305(){
        titulo("MODULO 305 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 305: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo306(){
        titulo("MODULO 306 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 306: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo307(){
        titulo("MODULO 307 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 307: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo308(){
        titulo("MODULO 308 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 308: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo309(){
        titulo("MODULO 309 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 309: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo310(){
        titulo("MODULO 310 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 310: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo311(){
        titulo("MODULO 311 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 311: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo312(){
        titulo("MODULO 312 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 312: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo313(){
        titulo("MODULO 313 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 313: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo314(){
        titulo("MODULO 314 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 314: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo315(){
        titulo("MODULO 315 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 315: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo316(){
        titulo("MODULO 316 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 316: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo317(){
        titulo("MODULO 317 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 317: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo318(){
        titulo("MODULO 318 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 318: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo319(){
        titulo("MODULO 319 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 319: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo320(){
        titulo("MODULO 320 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 320: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo321(){
        titulo("MODULO 321 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 321: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo322(){
        titulo("MODULO 322 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 322: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo323(){
        titulo("MODULO 323 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 323: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo324(){
        titulo("MODULO 324 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 324: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo325(){
        titulo("MODULO 325 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 325: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo326(){
        titulo("MODULO 326 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 326: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo327(){
        titulo("MODULO 327 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 327: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo328(){
        titulo("MODULO 328 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 328: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo329(){
        titulo("MODULO 329 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 329: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo330(){
        titulo("MODULO 330 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 330: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo331(){
        titulo("MODULO 331 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 331: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo332(){
        titulo("MODULO 332 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 332: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo333(){
        titulo("MODULO 333 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 333: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo334(){
        titulo("MODULO 334 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 334: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo335(){
        titulo("MODULO 335 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 335: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo336(){
        titulo("MODULO 336 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 336: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo337(){
        titulo("MODULO 337 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 337: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo338(){
        titulo("MODULO 338 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 338: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo339(){
        titulo("MODULO 339 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 339: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo340(){
        titulo("MODULO 340 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 340: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo341(){
        titulo("MODULO 341 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 341: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo342(){
        titulo("MODULO 342 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 342: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo343(){
        titulo("MODULO 343 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 343: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo344(){
        titulo("MODULO 344 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 344: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo345(){
        titulo("MODULO 345 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 345: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo346(){
        titulo("MODULO 346 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 346: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo347(){
        titulo("MODULO 347 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 347: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo348(){
        titulo("MODULO 348 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 348: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo349(){
        titulo("MODULO 349 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 349: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo350(){
        titulo("MODULO 350 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 350: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo351(){
        titulo("MODULO 351 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 351: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo352(){
        titulo("MODULO 352 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 352: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo353(){
        titulo("MODULO 353 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 353: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo354(){
        titulo("MODULO 354 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 354: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo355(){
        titulo("MODULO 355 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 355: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo356(){
        titulo("MODULO 356 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 356: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo357(){
        titulo("MODULO 357 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 357: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo358(){
        titulo("MODULO 358 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 358: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo359(){
        titulo("MODULO 359 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 359: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo360(){
        titulo("MODULO 360 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 360: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo361(){
        titulo("MODULO 361 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 361: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo362(){
        titulo("MODULO 362 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 362: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo363(){
        titulo("MODULO 363 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 363: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo364(){
        titulo("MODULO 364 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 364: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo365(){
        titulo("MODULO 365 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 365: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo366(){
        titulo("MODULO 366 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 366: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo367(){
        titulo("MODULO 367 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 367: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo368(){
        titulo("MODULO 368 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 368: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo369(){
        titulo("MODULO 369 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 369: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo370(){
        titulo("MODULO 370 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 370: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo371(){
        titulo("MODULO 371 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 371: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo372(){
        titulo("MODULO 372 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 372: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo373(){
        titulo("MODULO 373 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 373: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo374(){
        titulo("MODULO 374 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 374: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo375(){
        titulo("MODULO 375 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 375: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo376(){
        titulo("MODULO 376 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 376: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo377(){
        titulo("MODULO 377 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 377: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo378(){
        titulo("MODULO 378 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 378: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo379(){
        titulo("MODULO 379 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 379: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo380(){
        titulo("MODULO 380 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 380: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo381(){
        titulo("MODULO 381 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 381: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo382(){
        titulo("MODULO 382 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 382: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo383(){
        titulo("MODULO 383 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 383: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo384(){
        titulo("MODULO 384 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 384: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo385(){
        titulo("MODULO 385 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 385: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo386(){
        titulo("MODULO 386 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 386: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo387(){
        titulo("MODULO 387 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 387: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo388(){
        titulo("MODULO 388 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 388: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo389(){
        titulo("MODULO 389 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 389: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo390(){
        titulo("MODULO 390 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 390: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo391(){
        titulo("MODULO 391 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 391: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo392(){
        titulo("MODULO 392 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 392: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo393(){
        titulo("MODULO 393 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 393: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo394(){
        titulo("MODULO 394 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 394: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo395(){
        titulo("MODULO 395 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 395: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo396(){
        titulo("MODULO 396 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 396: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo397(){
        titulo("MODULO 397 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 397: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo398(){
        titulo("MODULO 398 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 398: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo399(){
        titulo("MODULO 399 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 399: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo400(){
        titulo("MODULO 400 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 400: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo401(){
        titulo("MODULO 401 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 401: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo402(){
        titulo("MODULO 402 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 402: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo403(){
        titulo("MODULO 403 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 403: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo404(){
        titulo("MODULO 404 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 404: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo405(){
        titulo("MODULO 405 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 405: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo406(){
        titulo("MODULO 406 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 406: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo407(){
        titulo("MODULO 407 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 407: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo408(){
        titulo("MODULO 408 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 408: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo409(){
        titulo("MODULO 409 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 409: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo410(){
        titulo("MODULO 410 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 410: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo411(){
        titulo("MODULO 411 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 411: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo412(){
        titulo("MODULO 412 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 412: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo413(){
        titulo("MODULO 413 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 413: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo414(){
        titulo("MODULO 414 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 414: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo415(){
        titulo("MODULO 415 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 415: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo416(){
        titulo("MODULO 416 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 416: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo417(){
        titulo("MODULO 417 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 417: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo418(){
        titulo("MODULO 418 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 418: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo419(){
        titulo("MODULO 419 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 419: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo420(){
        titulo("MODULO 420 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 420: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo421(){
        titulo("MODULO 421 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 421: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo422(){
        titulo("MODULO 422 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 422: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo423(){
        titulo("MODULO 423 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 423: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo424(){
        titulo("MODULO 424 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 424: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo425(){
        titulo("MODULO 425 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 425: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo426(){
        titulo("MODULO 426 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 426: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo427(){
        titulo("MODULO 427 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 427: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo428(){
        titulo("MODULO 428 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 428: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo429(){
        titulo("MODULO 429 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 429: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo430(){
        titulo("MODULO 430 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 430: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo431(){
        titulo("MODULO 431 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 431: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo432(){
        titulo("MODULO 432 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 432: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo433(){
        titulo("MODULO 433 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 433: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo434(){
        titulo("MODULO 434 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 434: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo435(){
        titulo("MODULO 435 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 435: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo436(){
        titulo("MODULO 436 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 436: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo437(){
        titulo("MODULO 437 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 437: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo438(){
        titulo("MODULO 438 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 438: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo439(){
        titulo("MODULO 439 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 439: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo440(){
        titulo("MODULO 440 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 440: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo441(){
        titulo("MODULO 441 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 441: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo442(){
        titulo("MODULO 442 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 442: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo443(){
        titulo("MODULO 443 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 443: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo444(){
        titulo("MODULO 444 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 444: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo445(){
        titulo("MODULO 445 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 445: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo446(){
        titulo("MODULO 446 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 446: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo447(){
        titulo("MODULO 447 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 447: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo448(){
        titulo("MODULO 448 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 448: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo449(){
        titulo("MODULO 449 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 449: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo450(){
        titulo("MODULO 450 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 450: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo451(){
        titulo("MODULO 451 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 451: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo452(){
        titulo("MODULO 452 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 452: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo453(){
        titulo("MODULO 453 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 453: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo454(){
        titulo("MODULO 454 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 454: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo455(){
        titulo("MODULO 455 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 455: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo456(){
        titulo("MODULO 456 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 456: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo457(){
        titulo("MODULO 457 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 457: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo458(){
        titulo("MODULO 458 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 458: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo459(){
        titulo("MODULO 459 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 459: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo460(){
        titulo("MODULO 460 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 460: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo461(){
        titulo("MODULO 461 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 461: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo462(){
        titulo("MODULO 462 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 462: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo463(){
        titulo("MODULO 463 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 463: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo464(){
        titulo("MODULO 464 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 464: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo465(){
        titulo("MODULO 465 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 465: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo466(){
        titulo("MODULO 466 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 466: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo467(){
        titulo("MODULO 467 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 467: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo468(){
        titulo("MODULO 468 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 468: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo469(){
        titulo("MODULO 469 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 469: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo470(){
        titulo("MODULO 470 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 470: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo471(){
        titulo("MODULO 471 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 471: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo472(){
        titulo("MODULO 472 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 472: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo473(){
        titulo("MODULO 473 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 473: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo474(){
        titulo("MODULO 474 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 474: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo475(){
        titulo("MODULO 475 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 475: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo476(){
        titulo("MODULO 476 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 476: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo477(){
        titulo("MODULO 477 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 477: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo478(){
        titulo("MODULO 478 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 478: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo479(){
        titulo("MODULO 479 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 479: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo480(){
        titulo("MODULO 480 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 480: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo481(){
        titulo("MODULO 481 - VARIAVEIS");
        System.out.println("Tema: int");
        System.out.println("Resumo: Guarda numeros inteiros.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de int e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 481: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo482(){
        titulo("MODULO 482 - TIPOS");
        System.out.println("Tema: double");
        System.out.println("Resumo: Guarda numeros com casas decimais.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de double e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 482: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo483(){
        titulo("MODULO 483 - TEXTO");
        System.out.println("Tema: String");
        System.out.println("Resumo: Guarda sequencias de caracteres.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de String e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 483: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo484(){
        titulo("MODULO 484 - LOGICA");
        System.out.println("Tema: boolean");
        System.out.println("Resumo: Guarda true ou false.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de boolean e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 484: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo485(){
        titulo("MODULO 485 - CONDICOES");
        System.out.println("Tema: if");
        System.out.println("Resumo: Executa um bloco quando a condicao e verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de if e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 485: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo486(){
        titulo("MODULO 486 - ESCOLHAS");
        System.out.println("Tema: switch");
        System.out.println("Resumo: Seleciona entre casos.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de switch e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 486: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo487(){
        titulo("MODULO 487 - LOOP");
        System.out.println("Tema: for");
        System.out.println("Resumo: Repete com contador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de for e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 487: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo488(){
        titulo("MODULO 488 - LOOP");
        System.out.println("Tema: while");
        System.out.println("Resumo: Repete enquanto a condicao for verdadeira.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de while e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 488: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo489(){
        titulo("MODULO 489 - METODOS");
        System.out.println("Tema: return");
        System.out.println("Resumo: Devolve um valor ao chamador.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de return e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 489: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo490(){
        titulo("MODULO 490 - PARAMETROS");
        System.out.println("Tema: parametro");
        System.out.println("Resumo: Recebe dados no metodo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de parametro e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 490: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo491(){
        titulo("MODULO 491 - ARRAY");
        System.out.println("Tema: array");
        System.out.println("Resumo: Agrupa valores do mesmo tipo.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de array e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 491: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo492(){
        titulo("MODULO 492 - OBJETOS");
        System.out.println("Tema: new");
        System.out.println("Resumo: Cria uma instancia.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de new e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 492: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo493(){
        titulo("MODULO 493 - CLASSE");
        System.out.println("Tema: class");
        System.out.println("Resumo: Define um molde.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de class e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 493: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo494(){
        titulo("MODULO 494 - SWING");
        System.out.println("Tema: JFrame");
        System.out.println("Resumo: Cria uma janela.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JFrame e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 494: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo495(){
        titulo("MODULO 495 - SWING");
        System.out.println("Tema: JPanel");
        System.out.println("Resumo: Agrupa componentes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JPanel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 495: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo496(){
        titulo("MODULO 496 - SWING");
        System.out.println("Tema: JButton");
        System.out.println("Resumo: Cria um botao.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JButton e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 496: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo497(){
        titulo("MODULO 497 - SWING");
        System.out.println("Tema: JLabel");
        System.out.println("Resumo: Mostra um texto.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de JLabel e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 497: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo498(){
        titulo("MODULO 498 - RANDOM");
        System.out.println("Tema: Random");
        System.out.println("Resumo: Gera valores pseudoaleatorios.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Random e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 498: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo499(){
        titulo("MODULO 499 - ENTRADA");
        System.out.println("Tema: Scanner");
        System.out.println("Resumo: Le dados do terminal.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de Scanner e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 499: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void modulo500(){
        titulo("MODULO 500 - ORGANIZACAO");
        System.out.println("Tema: metodo");
        System.out.println("Resumo: Divide o problema em partes.");
        categoria("IDEIA PRINCIPAL");
        System.out.println("Estude o comportamento de metodo e teste pequenos exemplos.");
        categoria("EXEMPLO");
        System.out.println("Exemplo: transforme a ideia acima em um programa de 3 a 10 linhas.");
        System.out.println("Depois explique com suas palavras o que cada linha faz.");
        categoria("EXERCICIO");
        System.out.println("Modulo 500: crie uma variavel, teste uma condicao e mostre o resultado.");
        System.out.println("Dica: use System.out.println para observar os valores.");
        System.out.println("Dica: erre de proposito e observe a mensagem do compilador.");
        categoria("DESAFIO");
        System.out.println("1 - Entendi e consigo explicar");
        System.out.println("2 - Preciso revisar");
        System.out.print("Resposta: ");
        int resposta=lerInteiro();
        if(resposta==1){sucesso("Modulo concluido!");ganharXP(8);}else{System.out.println(AMARELO+"Revise e tente novamente depois."+RESET);ganharXP(2);}
        pausar();
        limparTela();
    }

    static void categoria(String texto){
        System.out.println();
                System.out.println(ROXO+NEGRITO+"******************** "+texto+" ********************"+RESET);
                System.out.println();
    }

    static void separador(){
        System.out.println(AZUL+"----------------------------------------------------------------------"+RESET);
    }

    static void sucesso(String texto){
        System.out.println(VERDE+"[ OK ] "+texto+RESET);
    }

    static void erro(String texto){
        System.out.println(VERMELHO+"[ ERRO ] "+texto+RESET);
    }

    static void titulo(String texto){
        System.out.println();
        System.out.println(CIANO+NEGRITO+"======================================================================"+RESET);
        System.out.println(CIANO+NEGRITO+"                    "+texto+RESET);
        System.out.println(CIANO+NEGRITO+"======================================================================"+RESET);
        System.out.println();
    }

    static void cabecalho(String texto){
        titulo(texto);
        System.out.println("Nivel: "+AMARELO+nivel+RESET+" | XP: "+VERDE+xp+"/100"+RESET+" | Pontos: "+ROXO+pontos+RESET+" | Combo: "+combo);
        separador();
    }

    static int lerInteiro(){
        while(true){
            String entrada=teclado.nextLine().trim();
            try{return Integer.parseInt(entrada);}catch(NumberFormatException e){System.out.print(AMARELO+"Digite um numero valido: "+RESET);}
        }
    }

    static void pausar(){
        System.out.println();
        System.out.print(AMARELO+"Pressione ENTER para continuar..."+RESET);
        teclado.nextLine();
    }

    static void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void escrever(String texto,int velocidade){
        for(int i=0;i<texto.length();i++){System.out.print(texto.charAt(i));System.out.flush();dormir(velocidade);}
        System.out.println();
    }

    static void barra(String texto,int velocidade){
        for(int i=0;i<=20;i++){System.out.print("\r"+texto+" [");for(int j=0;j<20;j++)System.out.print(j<i?"#":"-");System.out.print("] "+(i*5)+"%");System.out.flush();dormir(velocidade);}System.out.println();
    }

    static void mostrarBarra(String nome,int valor){
        int p=Math.max(0,Math.min(100,valor));int t=25;int c=(p*t)/100;System.out.print(String.format("%-8s [",nome));for(int i=0;i<t;i++)System.out.print(i<c?"#":"-");System.out.println("] "+p+"%");
    }

    static void ganharXP(int quantidade){
        if(quantidade<=0)return;
        xp+=quantidade;
        pontos+=quantidade;
        moedas+=Math.max(1,quantidade/10);
        combo++;
        if(combo>maiorCombo)maiorCombo=combo;
        while(xp>=100){xp-=100;nivel++;sucesso("LEVEL UP! Nivel "+nivel);}
    }

    static void perderCombo(){
        erros++;
        combo=0;
    }

    static String embaralhar(String palavra){
        char[] c=palavra.toCharArray();
        for(int i=c.length-1;i>0;i--){int j=random.nextInt(i+1);char t=c[i];c[i]=c[j];c[j]=t;}
        String r=new String(c);
        if(r.equals(palavra)&&c.length>1){char t=c[0];c[0]=c[1];c[1]=t;}
        return new String(c);
    }

    static String formatarMB(long bytes){
        return String.format("%.2f MB",bytes/(1024.0*1024.0));
    }

    static void dormir(long ms){
        try{Thread.sleep(ms);}catch(InterruptedException e){Thread.currentThread().interrupt();}
    }

    static void desligar(){
        titulo("NEXUS OFFLINE");
        barra("Encerrando modulos",8);
        System.out.println(VERMELHO+NEGRITO+"ATE A PROXIMA, OPERADOR!"+RESET);
    }

}
