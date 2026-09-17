package com.mycompany.aula1cursojava;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Grupo3AULA1Rafael {

    // =========================================================
    // CORES
    // =========================================================

    static final String RESET = "\u001B[0m";
    static final String VERDE = "\u001B[32m";
    static final String CIANO = "\u001B[36m";
    static final String AZUL = "\u001B[34m";
    static final String ROXO = "\u001B[35m";
    static final String VERMELHO = "\u001B[31m";
    static final String AMARELO = "\u001B[33m";
    static final String BRANCO = "\u001B[37m";
    static final String NEGRITO = "\u001B[1m";

    static Scanner teclado = new Scanner(System.in);
    static Random random = new Random();

    // =========================================================
    // STATUS DO JOGADOR
    // =========================================================

    static int pontos = 0;
    static int nivel = 1;
    static int xp = 0;

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) throws Exception {

        limparTela();

        inicializar();

        menuPrincipal();
    }

    // =========================================================
    // INICIALIZACAO
    // =========================================================

    static void inicializar() throws Exception {

        titulo("NEXUS CYBER ACADEMY");

        System.out.println(
                VERDE +
                "Sistema de treinamento Java + Cyber Terminal" +
                RESET
        );

        System.out.println();

        escrever(
                "Inicializando kernel...",
                20
        );

        barra(
                "Carregando modulos",
                15
        );

        escrever(
                "Detectando hardware...",
                20
        );

        barra(
                "Preparando interface",
                15
        );

        escrever(
                "Carregando simulacoes cyber...",
                20
        );

        barra(
                "Inicializando NEXUS",
                15
        );

        System.out.println();

        System.out.println(
                VERDE + NEGRITO +
                "[ ONLINE ] NEXUS SYSTEM" +
                RESET
        );

        System.out.println();

        System.out.println(
                AMARELO +
                "Pressione ENTER para entrar..." +
                RESET
        );

        teclado.nextLine();

        limparTela();
    }

    // =========================================================
    // MENU PRINCIPAL
    // =========================================================

    static void menuPrincipal() throws Exception {

        int opcao;

        do {

            hud();

            System.out.println(
                    CIANO + "[1]" + RESET +
                    " Academia Java"
            );

            System.out.println(
                    CIANO + "[2]" + RESET +
                    " PC Command Center"
            );

            System.out.println(
                    ROXO + "[3]" + RESET +
                    " Cyber Lab"
            );

            System.out.println(
                    AZUL + "[4]" + RESET +
                    " Interface Grafica"
            );

            System.out.println(
                    AMARELO + "[5]" + RESET +
                    " Minigames"
            );

            System.out.println(
                    VERDE + "[6]" + RESET +
                    " Perfil / XP"
            );

            System.out.println(
                    VERMELHO + "[0]" + RESET +
                    " Desligar"
            );

            separador();

            System.out.print(
                    AMARELO +
                    "NEXUS > " +
                    RESET
            );

            opcao = lerInteiro();

            limparTela();

            switch (opcao) {

                case 1:
                    menuAcademia();
                    break;

                case 2:
                    pcCommandCenter();
                    break;

                case 3:
                    cyberLab();
                    break;

                case 4:
                    interfaceGrafica();
                    break;

                case 5:
                    menuMinigames();
                    break;

                case 6:
                    perfil();
                    break;

                case 0:
                    desligar();
                    break;

                default:

                    erro("Opcao invalida.");

                    pausar();
                    limparTela();
            }

        } while (opcao != 0);
    }

    // =========================================================
    // HUD
    // =========================================================

    static void hud() {

        titulo("NEXUS TERMINAL");

        System.out.println(
                CIANO +
                "OPERADOR: RAFAEL" +
                RESET
        );

        System.out.println(
                "NIVEL: " +
                AMARELO +
                nivel +
                RESET +
                "    XP: " +
                VERDE +
                xp +
                RESET +
                "    PONTOS: " +
                ROXO +
                pontos +
                RESET
        );

        separador();
    }

    // =========================================================
    // ACADEMIA
    // =========================================================

    static void menuAcademia() throws Exception {

        int opcao;

        do {

            titulo("ACADEMIA JAVA");

            System.out.println(
                    CIANO + "[1]" + RESET +
                    " Nivel 1 - Variaveis"
            );

            System.out.println(
                    CIANO + "[2]" + RESET +
                    " Nivel 2 - For / While"
            );

            System.out.println(
                    CIANO + "[3]" + RESET +
                    " Nivel 3 - Logica"
            );

            System.out.println(
                    CIANO + "[4]" + RESET +
                    " Nivel 4 - JFrame"
            );

            System.out.println(
                    VERMELHO + "[0]" + RESET +
                    " Voltar"
            );

            System.out.print(
                    AMARELO +
                    "Escolha: " +
                    RESET
            );

            opcao = lerInteiro();

            limparTela();

            switch (opcao) {

                case 1:
                    nivel1();
                    break;

                case 2:

                    if (nivel >= 2) {
                        nivel2();
                    } else {
                        bloqueado();
                    }

                    break;

                case 3:

                    if (nivel >= 3) {
                        nivel3();
                    } else {
                        bloqueado();
                    }

                    break;

                case 4:

                    if (nivel >= 4) {
                        nivel4();
                    } else {
                        bloqueado();
                    }

                    break;

                case 0:
                    break;

                default:
                    erro("Opcao invalida.");
                    pausar();
                    limparTela();
            }

        } while (opcao != 0);
    }

    // =========================================================
    // NIVEL 1
    // =========================================================

    static void nivel1() throws Exception {

        titulo("NIVEL 1 - FUNDAMENTOS");

        categoria("INT");

        System.out.println(
                "int guarda numeros inteiros."
        );

        int idade = 15;
        int energia = 100;

        System.out.println(
                "idade = " + idade
        );

        System.out.println(
                "energia = " + energia
        );

        categoria("BOOLEAN");

        System.out.println(
                "boolean guarda true ou false."
        );

        boolean sistemaOnline = true;

        System.out.println(
                "sistemaOnline = " +
                sistemaOnline
        );

        categoria("DESAFIO");

        System.out.println(
                "Qual deles e um boolean?"
        );

        System.out.println();

        System.out.println("1 - 42");
        System.out.println("2 - true");
        System.out.println("3 - 3.14");

        System.out.print("Resposta: ");

        int resposta = lerInteiro();

        if (resposta == 2) {

            sucesso("Correto! true e boolean.");
            ganhar(20);

        } else {

            erro("A resposta era 2.");
        }

        if (nivel < 2) {
            nivel = 2;
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // NIVEL 2
    // =========================================================

    static void nivel2() throws Exception {

        titulo("NIVEL 2 - REPETICAO");

        categoria("FOR");

        for (int i = 1; i <= 5; i++) {

            System.out.println(
                    "for -> " + i
            );
        }

        categoria("WHILE");

        int contador = 1;

        while (contador <= 3) {

            System.out.println(
                    "while -> " +
                    contador
            );

            contador++;
        }

        categoria("DESAFIO FOR");

        System.out.println(
                "Quantas vezes executa?"
        );

        System.out.println(
                "for (int i = 0; i < 4; i++)"
        );

        System.out.print(
                "Resposta: "
        );

        int resposta = lerInteiro();

        if (resposta == 4) {

            sucesso("Correto!");
            ganhar(25);

        } else {

            erro("Era 4.");
        }

        categoria("DESAFIO WHILE");

        System.out.println(
                "Qual comando aumenta o contador?"
        );

        System.out.println(
                "1 - contador++"
        );

        System.out.println(
                "2 - contador--"
        );

        System.out.println(
                "3 - contador = 0"
        );

        System.out.print(
                "Resposta: "
        );

        int resposta2 = lerInteiro();

        if (resposta2 == 1) {

            sucesso("Correto!");
            ganhar(25);

        } else {

            erro("Era contador++.");
        }

        if (nivel < 3) {
            nivel = 3;
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // NIVEL 3
    // =========================================================

    static void nivel3() throws Exception {

        titulo("NIVEL 3 - LOGICA");

        categoria("IF / ELSE");

        int numero = 10;

        if (numero > 5) {

            System.out.println(
                    "10 e maior que 5."
            );

        } else {

            System.out.println(
                    "10 nao e maior que 5."
            );
        }

        categoria("ARRAY");

        int[] valores = {
            10,
            20,
            30
        };

        System.out.println(
                "Primeiro valor: " +
                valores[0]
        );

        categoria("RANDOM");

        int sorteado =
                random.nextInt(10) + 1;

        System.out.println(
                "Numero aleatorio: " +
                sorteado
        );

        categoria("DESAFIO");

        System.out.println(
                "Se x = 10, qual aparece?"
        );

        System.out.println();

        System.out.println(
                "if (x > 5) -> A"
        );

        System.out.println(
                "else -> B"
        );

        System.out.print(
                "Resposta: "
        );

        String resposta =
                teclado.nextLine();

        if (
                resposta.equalsIgnoreCase("A")
        ) {

            sucesso("Correto!");
            ganhar(30);

        } else {

            erro("A resposta era A.");
        }

        if (nivel < 4) {
            nivel = 4;
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // NIVEL 4
    // =========================================================

    static void nivel4() throws Exception {

        titulo("NIVEL 4 - JFRAME");

        categoria("JFRAME");

        System.out.println(
                "JFrame cria uma janela grafica."
        );

        System.out.println();

        System.out.println(
                "JFrame janela = new JFrame();"
        );

        System.out.println(
                "janela.setSize(500, 250);"
        );

        System.out.println(
                "janela.setVisible(true);"
        );

        categoria("DESAFIO");

        System.out.println(
                "Qual comando mostra a janela?"
        );

        System.out.println();

        System.out.println(
                "1 - setSize()"
        );

        System.out.println(
                "2 - setVisible()"
        );

        System.out.println(
                "3 - setWindow()"
        );

        System.out.print(
                "Resposta: "
        );

        int resposta = lerInteiro();

        if (resposta == 2) {

            sucesso(
                    "Correto!"
            );

            ganhar(35);

        } else {

            erro(
                    "A resposta era 2."
            );
        }

        categoria("DEMONSTRACAO");

        abrirJFrame();

        pausar();
        limparTela();
    }

    // =========================================================
    // PC COMMAND CENTER
    // =========================================================

    static void pcCommandCenter() throws Exception {

        int opcao;

        do {

            titulo("PC COMMAND CENTER");

            System.out.println(
                    CIANO + "[1]" + RESET +
                    " Visao geral"
            );

            System.out.println(
                    CIANO + "[2]" + RESET +
                    " Memoria RAM"
            );

            System.out.println(
                    CIANO + "[3]" + RESET +
                    " Discos"
            );

            System.out.println(
                    CIANO + "[4]" + RESET +
                    " Processador"
            );

            System.out.println(
                    CIANO + "[5]" + RESET +
                    " Diagnostico completo"
            );

            System.out.println(
                    VERMELHO + "[0]" + RESET +
                    " Voltar"
            );

            System.out.print(
                    AMARELO +
                    "PC > " +
                    RESET
            );

            opcao = lerInteiro();

            limparTela();

            switch (opcao) {

                case 1:
                    pcGeral();
                    break;

                case 2:
                    pcRam();
                    break;

                case 3:
                    pcDiscos();
                    break;

                case 4:
                    pcCpu();
                    break;

                case 5:
                    diagnostico();
                    break;

                case 0:
                    break;

                default:
                    erro("Comando invalido.");
                    pausar();
                    limparTela();
            }

        } while (opcao != 0);
    }

    // =========================================================
    // PC GERAL
    // =========================================================

    static void pcGeral() throws Exception {

        titulo("PC - VISUALIZACAO GERAL");

        String sistema =
                System.getProperty(
                        "os.name"
                );

        String versao =
                System.getProperty(
                        "os.version"
                );

        String java =
                System.getProperty(
                        "java.version"
                );

        int nucleos =
                Runtime.getRuntime()
                        .availableProcessors();

        long memoriaMax =
                Runtime.getRuntime()
                        .maxMemory();

        System.out.println(
                "Sistema operacional: " +
                sistema
        );

        System.out.println(
                "Versao do sistema: " +
                versao
        );

        System.out.println(
                "Java: " +
                java
        );

        System.out.println(
                "Nucleos logicos: " +
                nucleos
        );

        System.out.println(
                "Memoria maxima Java: " +
                formatarGB(memoriaMax)
        );

        categoria("MONITOR DE SISTEMA");

        int cpu =
                random.nextInt(70) + 20;

        int temperatura =
                random.nextInt(25) + 40;

        int rede =
                random.nextInt(20) + 5;

        mostrarBarra(
                "CPU",
                cpu
        );

        mostrarBarra(
                "GPU",
                random.nextInt(60) + 25
        );

        mostrarBarra(
                "RAM",
                random.nextInt(70) + 20
        );

        System.out.println();

        System.out.println(
                "Temperatura simulada: " +
                temperatura +
                " C"
        );

        System.out.println(
                "Ping simulado: " +
                rede +
                " ms"
        );

        categoria(
                "OBSERVACAO"
        );

        System.out.println(
                "CPU/GPU, temperatura e ping acima sao " +
                "uma simulacao para o terminal."
        );

        System.out.println(
                "As informacoes de sistema, Java e CPU " +
                "sao obtidas pelo proprio Java."
        );

        pausar();
        limparTela();
    }

    // =========================================================
    // RAM
    // =========================================================

    static void pcRam() throws Exception {

        titulo("MONITOR DE MEMORIA");

        Runtime runtime =
                Runtime.getRuntime();

        long max =
                runtime.maxMemory();

        long total =
                runtime.totalMemory();

        long livre =
                runtime.freeMemory();

        long usada =
                total - livre;

        System.out.println(
                "Memoria Java maxima: " +
                formatarGB(max)
        );

        System.out.println(
                "Memoria reservada: " +
                formatarMB(total)
        );

        System.out.println(
                "Memoria livre: " +
                formatarMB(livre)
        );

        System.out.println(
                "Memoria utilizada: " +
                formatarMB(usada)
        );

        int porcentagem =
                total == 0
                ? 0
                : (int)
                ((usada * 100) / total);

        System.out.println();

        mostrarBarra(
                "USO",
                porcentagem
        );

        pausar();
        limparTela();
    }

    // =========================================================
    // DISCOS
    // =========================================================

    static void pcDiscos() throws Exception {

        titulo("MONITOR DE DISCOS");

        File[] discos =
                File.listRoots();

        if (discos != null) {

            for (File disco : discos) {

                long total =
                        disco.getTotalSpace();

                long livre =
                        disco.getFreeSpace();

                long usado =
                        total - livre;

                System.out.println();

                System.out.println(
                        CIANO +
                        "UNIDADE: " +
                        disco.getPath() +
                        RESET
                );

                System.out.println(
                        "Total: " +
                        formatarGB(total)
                );

                System.out.println(
                        "Livre: " +
                        formatarGB(livre)
                );

                System.out.println(
                        "Usado: " +
                        formatarGB(usado)
                );

                if (total > 0) {

                    int porcentagem =
                            (int)
                            ((usado * 100) / total);

                    mostrarBarra(
                            "DISCO",
                            porcentagem
                    );
                }
            }
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // CPU
    // =========================================================

    static void pcCpu() throws Exception {

        titulo("MONITOR DE PROCESSADOR");

        int cores =
                Runtime.getRuntime()
                        .availableProcessors();

        System.out.println(
                "Nucleos logicos detectados: " +
                cores
        );

        categoria(
                "MONITORAMENTO"
        );

        for (int i = 0; i < 5; i++) {

            int uso =
                    random.nextInt(75) + 10;

            System.out.println(
                    "Leitura " +
                    (i + 1) +
                    ": CPU " +
                    uso +
                    "%"
            );

            Thread.sleep(250);
        }

        System.out.println();

        System.out.println(
                "Modelo exato do processador " +
                "depende do sistema operacional."
        );

        pausar();
        limparTela();
    }

    // =========================================================
    // DIAGNOSTICO
    // =========================================================

    static void diagnostico() throws Exception {

        titulo("DIAGNOSTICO NEXUS");

        escrever(
                "Executando verificacoes...",
                20
        );

        verificar(
                "Sistema operacional",
                true
        );

        verificar(
                "Java Runtime",
                true
        );

        verificar(
                "Memoria",
                random.nextInt(100) > 10
        );

        verificar(
                "Disco",
                random.nextInt(100) > 5
        );

        verificar(
                "Interface",
                true
        );

        verificar(
                "Nucleo Java",
                true
        );

        verificar(
                "Cyber Lab",
                true
        );

        System.out.println();

        sucesso(
                "Diagnostico concluido."
        );

        ganhar(15);

        pausar();
        limparTela();
    }

    // =========================================================
    // CYBER LAB
    // =========================================================

    static void cyberLab() throws Exception {

        int opcao;

        do {

            titulo("NEXUS CYBER LAB");

            System.out.println(
                    ROXO +
                    "SIMULACAO EDUCATIVA" +
                    RESET
            );

            System.out.println();

            System.out.println(
                    CIANO + "[1]" + RESET +
                    " Scanner de portas ficticio"
            );

            System.out.println(
                    CIANO + "[2]" + RESET +
                    " Terminal de acesso"
            );

            System.out.println(
                    CIANO + "[3]" + RESET +
                    " Decodificador Caesar"
            );

            System.out.println(
                    CIANO + "[4]" + RESET +
                    " Analise de senha"
            );

            System.out.println(
                    CIANO + "[5]" + RESET +
                    " Monitor de pacotes"
            );

            System.out.println(
                    VERMELHO + "[0]" + RESET +
                    " Voltar"
            );

            System.out.print(
                    AMARELO +
                    "CYBER > " +
                    RESET
            );

            opcao = lerInteiro();

            limparTela();

            switch (opcao) {

                case 1:
                    scannerFicticio();
                    break;

                case 2:
                    terminalAcesso();
                    break;

                case 3:
                    caesarLab();
                    break;

                case 4:
                    analiseSenha();
                    break;

                case 5:
                    monitorPacotes();
                    break;

                case 0:
                    break;

                default:
                    erro("Comando invalido.");
                    pausar();
                    limparTela();
            }

        } while (opcao != 0);
    }

    // =========================================================
    // SCANNER FICTICIO
    // =========================================================

    static void scannerFicticio() throws Exception {

        titulo("PORT SCANNER - SIMULACAO");

        System.out.println(
                "Nenhuma rede real sera analisada."
        );

        System.out.println(
                "Os resultados abaixo sao gerados pelo jogo."
        );

        System.out.println();

        String[] portas = {
            "21 FTP",
            "22 SSH",
            "25 SMTP",
            "53 DNS",
            "80 HTTP",
            "110 POP3",
            "443 HTTPS",
            "8080 HTTP-ALT"
        };

        for (String porta : portas) {

            Thread.sleep(180);

            boolean aberta =
                    random.nextBoolean();

            if (aberta) {

                System.out.println(
                        VERDE +
                        "[OPEN] " +
                        porta +
                        RESET
                );

            } else {

                System.out.println(
                        VERMELHO +
                        "[CLOSED] " +
                        porta +
                        RESET
                );
            }
        }

        System.out.println();

        sucesso(
                "Varredura ficticia concluida."
        );

        ganhar(20);

        pausar();
        limparTela();
    }

    // =========================================================
    // TERMINAL DE ACESSO
    // =========================================================

    static void terminalAcesso() throws Exception {

        titulo("SECURE TERMINAL");

        String codigo =
                String.valueOf(
                        random.nextInt(900) + 100
                );

        System.out.println(
                "Sistema gerou um codigo de acesso."
        );

        System.out.println(
                "Voce possui 3 tentativas."
        );

        System.out.println();

        boolean acertou = false;

        for (int i = 1; i <= 3; i++) {

            String tentativa =
                    String.valueOf(
                            random.nextInt(900) + 100
                    );

            System.out.println(
                    "Hint: o codigo possui 3 digitos."
            );

            System.out.print(
                    "Tentativa " +
                    i +
                    ": "
            );

            String resposta =
                    teclado.nextLine();

            if (resposta.equals(codigo)) {

                acertou = true;

                break;
            }

            System.out.println(
                    VERMELHO +
                    "ACESSO NEGADO" +
                    RESET
            );
        }

        if (acertou) {

            sucesso(
                    "ACESSO CONCEDIDO!"
            );

            ganhar(50);

        } else {

            System.out.println();

            erro(
                    "Acesso negado."
            );

            System.out.println(
                    "Codigo ficticio: " +
                    codigo
            );
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // CAESAR
    // =========================================================

    static void caesarLab() throws Exception {

        titulo("CAESAR DECODER");

        String[] mensagens = {
            "FDGD",
            "MDYD",
            "QHAHV",
            "VHFXUH"
        };

        String[] respostas = {
            "CADA",
            "JAVA",
            "NEGES",
            "SECURE"
        };

        int index =
                random.nextInt(
                        mensagens.length
                );

        String mensagem =
                mensagens[index];

        System.out.println(
                "Mensagem criptografada:"
        );

        System.out.println();

        System.out.println(
                AMARELO +
                mensagem +
                RESET
        );

        System.out.println();

        System.out.println(
                "Dica: Caesar com deslocamento -3."
        );

        System.out.print(
                "Digite a palavra decodificada: "
        );

        String resposta =
                teclado.nextLine();

        if (
                resposta.equalsIgnoreCase(
                        respostas[index]
                )
        ) {

            sucesso(
                    "Mensagem decodificada!"
            );

            ganhar(40);

        } else {

            erro(
                    "Resposta incorreta."
            );

            System.out.println(
                    "Resposta: " +
                    respostas[index]
            );
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // ANALISE DE SENHA
    // =========================================================

    static void analiseSenha() throws Exception {

        titulo("PASSWORD ANALYZER");

        System.out.println(
                "Digite uma senha ficticia para analisar."
        );

        System.out.print(
                "Senha: "
        );

        String senha =
                teclado.nextLine();

        int score = 0;

        if (senha.length() >= 8) {
            score += 25;
        }

        if (possuiMaiuscula(senha)) {
            score += 25;
        }

        if (possuiNumero(senha)) {
            score += 25;
        }

        if (possuiSimbolo(senha)) {
            score += 25;
        }

        System.out.println();

        mostrarBarra(
                "FORCA",
                score
        );

        System.out.println();

        if (score == 100) {

            sucesso(
                    "Senha forte."
            );

            ganhar(40);

        } else if (score >= 50) {

            System.out.println(
                    AMARELO +
                    "Senha razoavel." +
                    RESET
            );

        } else {

            erro(
                    "Senha fraca."
            );
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // MONITOR DE PACOTES
    // =========================================================

    static void monitorPacotes() throws Exception {

        titulo("PACKET MONITOR - SIMULACAO");

        System.out.println(
                "Monitor ficticio de trafego."
        );

        System.out.println();

        String[] tipos = {
            "TCP",
            "UDP",
            "HTTP",
            "DNS",
            "TLS"
        };

        for (int i = 0; i < 15; i++) {

            String tipo =
                    tipos[
                            random.nextInt(
                                    tipos.length
                            )
                    ];

            int tamanho =
                    random.nextInt(1400) + 64;

            System.out.println(
                    CIANO +
                    "[PACKET] " +
                    RESET +
                    tipo +
                    "   " +
                    tamanho +
                    " bytes"
            );

            Thread.sleep(120);
        }

        System.out.println();

        sucesso(
                "Monitoramento encerrado."
        );

        ganhar(20);

        pausar();
        limparTela();
    }

    // =========================================================
    // MINIGAMES
    // =========================================================

    static void menuMinigames() throws Exception {

        int opcao;

        do {

            titulo("NEXUS MINIGAMES");

            System.out.println(
                    CIANO + "[1]" + RESET +
                    " Adivinhe o numero"
            );

            System.out.println(
                    CIANO + "[2]" + RESET +
                    " Quiz Java"
            );

            System.out.println(
                    CIANO + "[3]" + RESET +
                    " Batalha Neon"
            );

            System.out.println(
                    CIANO + "[4]" + RESET +
                    " Desafio matematico"
            );

            System.out.println(
                    CIANO + "[5]" + RESET +
                    " Sequencia hacker"
            );

            System.out.println(
                    CIANO + "[6]" + RESET +
                    " Teste de reflexo"
            );

            System.out.println(
                    CIANO + "[7]" + RESET +
                    " Terminal typing"
            );

            System.out.println(
                    VERMELHO + "[0]" + RESET +
                    " Voltar"
            );

            System.out.print(
                    AMARELO +
                    "GAME > " +
                    RESET
            );

            opcao = lerInteiro();

            limparTela();

            switch (opcao) {

                case 1:
                    jogoNumero();
                    break;

                case 2:
                    quizJava();
                    break;

                case 3:
                    batalhaNeon();
                    break;

                case 4:
                    desafioMatematico();
                    break;

                case 5:
                    sequenciaHacker();
                    break;

                case 6:
                    reflexo();
                    break;

                case 7:
                    typingGame();
                    break;

                case 0:
                    break;

                default:
                    erro("Opcao invalida.");
                    pausar();
                    limparTela();
            }

        } while (opcao != 0);
    }

    // =========================================================
    // JOGO NUMERO
    // =========================================================

    static void jogoNumero() throws Exception {

        titulo("ADIVINHE O NUMERO");

        int secreto =
                random.nextInt(50) + 1;

        int tentativas = 6;

        for (int i = 1; i <= tentativas; i++) {

            System.out.print(
                    "Tentativa " +
                    i +
                    ": "
            );

            int palpite =
                    lerInteiro();

            if (palpite == secreto) {

                sucesso(
                        "Voce acertou!"
                );

                ganhar(50);

                pausar();
                limparTela();

                return;
            }

            if (palpite < secreto) {

                System.out.println(
                        "O numero e MAIOR."
                );

            } else {

                System.out.println(
                        "O numero e MENOR."
                );
            }
        }

        erro(
                "Voce perdeu."
        );

        System.out.println(
                "Numero secreto: " +
                secreto
        );

        pausar();
        limparTela();
    }

    // =========================================================
    // QUIZ
    // =========================================================

    static void quizJava() throws Exception {

        titulo("QUIZ JAVA");

        int acertos = 0;

        categoria("PERGUNTA 1");

        System.out.println(
                "Qual tipo guarda true ou false?"
        );

        System.out.println(
                "1 - int"
        );

        System.out.println(
                "2 - boolean"
        );

        System.out.println(
                "3 - double"
        );

        System.out.print(
                "Resposta: "
        );

        if (lerInteiro() == 2) {
            acertos++;
        }

        categoria("PERGUNTA 2");

        System.out.println(
                "Qual estrutura repete codigo?"
        );

        System.out.println(
                "1 - for"
        );

        System.out.println(
                "2 - String"
        );

        System.out.println(
                "3 - JFrame"
        );

        System.out.print(
                "Resposta: "
        );

        if (lerInteiro() == 1) {
            acertos++;
        }

        categoria("PERGUNTA 3");

        System.out.println(
                "Qual palavra cria um objeto?"
        );

        System.out.println(
                "1 - make"
        );

        System.out.println(
                "2 - new"
        );

        System.out.println(
                "3 - object"
        );

        System.out.print(
                "Resposta: "
        );

        if (lerInteiro() == 2) {
            acertos++;
        }

        categoria("RESULTADO");

        System.out.println(
                "Acertos: " +
                acertos +
                "/3"
        );

        ganhar(
                acertos * 25
        );

        pausar();
        limparTela();
    }

    // =========================================================
    // BATALHA NEON
    // =========================================================

    static void batalhaNeon() throws Exception {

        titulo("BATALHA NEON");

        String[] inimigos = {
            "DRONE-X",
            "ROBO TITAN",
            "GUARDIAO JAVA",
            "ANDROID 404",
            "CYBER WOLF"
        };

        String inimigo =
                inimigos[
                        random.nextInt(
                                inimigos.length
                        )
                ];

        int jogador = 100;
        int inimigoVida = 100;

        System.out.println(
                "INIMIGO: " +
                VERMELHO +
                inimigo +
                RESET
        );

        while (
                jogador > 0 &&
                inimigoVida > 0
        ) {

            separador();

            System.out.println(
                    VERDE +
                    "HP JOGADOR: " +
                    jogador +
                    RESET
            );

            System.out.println(
                    VERMELHO +
                    "HP INIMIGO: " +
                    inimigoVida +
                    RESET
            );

            separador();

            System.out.println(
                    "1 - ATACAR"
            );

            System.out.println(
                    "2 - DEFENDER"
            );

            System.out.print(
                    "Acao: "
            );

            int acao =
                    lerInteiro();

            if (acao == 1) {

                int dano =
                        random.nextInt(20) + 10;

                if (
                        random.nextInt(100) < 20
                ) {

                    dano *= 2;

                    System.out.println(
                            AMARELO +
                            "CRITICO!" +
                            RESET
                    );
                }

                inimigoVida -= dano;

                System.out.println(
                        "Dano: " +
                        dano
                );

            } else if (acao == 2) {

                int dano =
                        random.nextInt(7) + 3;

                jogador -= dano;

                System.out.println(
                        "Defesa ativada."
                );

                System.out.println(
                        "Dano recebido: " +
                        dano
                );

                continue;

            } else {

                erro("Acao invalida.");

                continue;
            }

            if (inimigoVida > 0) {

                int dano =
                        random.nextInt(15) + 5;

                jogador -= dano;

                System.out.println(
                        inimigo +
                        " atacou por " +
                        dano
                );
            }
        }

        categoria("RESULTADO");

        if (jogador > 0) {

            sucesso(
                    "VITORIA!"
            );

            ganhar(75);

        } else {

            erro(
                    "DERROTA!"
            );
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // DESAFIO MATEMATICO
    // =========================================================

    static void desafioMatematico() throws Exception {

        titulo("DESAFIO MATEMATICO");

        int a =
                random.nextInt(20) + 1;

        int b =
                random.nextInt(20) + 1;

        int operacao =
                random.nextInt(3);

        int respostaCorreta;

        String simbolo;

        if (operacao == 0) {

            respostaCorreta = a + b;
            simbolo = "+";

        } else if (operacao == 1) {

            respostaCorreta = a - b;
            simbolo = "-";

        } else {

            respostaCorreta = a * b;
            simbolo = "*";
        }

        System.out.println(
                a +
                " " +
                simbolo +
                " " +
                b +
                " = ?"
        );

        System.out.print(
                "Resposta: "
        );

        int resposta =
                lerInteiro();

        if (
                resposta ==
                respostaCorreta
        ) {

            sucesso(
                    "Calculo correto!"
            );

            ganhar(30);

        } else {

            erro(
                    "Resposta: " +
                    respostaCorreta
            );
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // SEQUENCIA HACKER
    // =========================================================

    static void sequenciaHacker() throws Exception {

        titulo("SEQUENCIA HACKER");

        int tamanho = 4;

        int[] sequencia =
                new int[tamanho];

        System.out.println(
                "Memorize a sequencia:"
        );

        for (int i = 0; i < tamanho; i++) {

            sequencia[i] =
                    random.nextInt(9);

            System.out.print(
                    sequencia[i] +
                    " "
            );

            Thread.sleep(500);
        }

        Thread.sleep(700);

        limparTela();

        titulo("SEQUENCIA");

        System.out.println(
                "Digite os numeros na mesma ordem."
        );

        boolean venceu = true;

        for (int i = 0; i < tamanho; i++) {

            int resposta =
                    lerInteiro();

            if (
                    resposta !=
                    sequencia[i]
            ) {

                venceu = false;
            }
        }

        if (venceu) {

            sucesso(
                    "Memoria perfeita!"
            );

            ganhar(60);

        } else {

            erro(
                    "Sequencia incorreta."
            );

            System.out.print(
                    "Era: "
            );

            for (int valor : sequencia) {
                System.out.print(
                        valor +
                        " "
                );
            }

            System.out.println();
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // REFLEXO
    // =========================================================

    static void reflexo() throws Exception {

        titulo("TESTE DE REFLEXO");

        System.out.println(
                "Quando aparecer GO!, pressione ENTER."
        );

        System.out.println();

        Thread.sleep(
                random.nextInt(2500) + 1500
        );

        long inicio =
                System.currentTimeMillis();

        System.out.println(
                VERDE + NEGRITO +
                ">>> GO! <<<" +
                RESET
        );

        teclado.nextLine();

        long fim =
                System.currentTimeMillis();

        long tempo =
                fim - inicio;

        System.out.println();

        System.out.println(
                "Tempo: " +
                tempo +
                " ms"
        );

        if (tempo < 300) {

            sucesso(
                    "REFLEXO ABSURDO!"
            );

            ganhar(70);

        } else if (tempo < 600) {

            sucesso(
                    "Reflexo excelente!"
            );

            ganhar(45);

        } else {

            System.out.println(
                    AMARELO +
                    "Pode melhorar." +
                    RESET
            );

            ganhar(20);
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // TYPING GAME
    // =========================================================

    static void typingGame() throws Exception {

        titulo("TERMINAL TYPING");

        String[] frases = {
            "Java",
            "Nexus",
            "Cyber",
            "Programador",
            "Batalha Neon"
        };

        String frase =
                frases[
                        random.nextInt(
                                frases.length
                        )
                ];

        System.out.println(
                "Digite exatamente:"
        );

        System.out.println();

        System.out.println(
                AMARELO +
                frase +
                RESET
        );

        System.out.println();

        long inicio =
                System.currentTimeMillis();

        String resposta =
                teclado.nextLine();

        long fim =
                System.currentTimeMillis();

        if (resposta.equals(frase)) {

            long tempo =
                    fim - inicio;

            sucesso(
                    "Perfeito!"
            );

            System.out.println(
                    "Tempo: " +
                    tempo +
                    " ms"
            );

            ganhar(50);

        } else {

            erro(
                    "Texto incorreto."
            );
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // INTERFACE GRAFICA
    // =========================================================

    static void interfaceGrafica() throws Exception {

        titulo("NEXUS GUI");

        System.out.println(
                "Abrindo interface grafica..."
        );

        Thread.sleep(700);

        JFrame janela =
                new JFrame(
                        "NEXUS CYBER TERMINAL"
                );

        janela.setSize(
                700,
                400
        );

        janela.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        String texto =
                "<html>" +
                "<center>" +
                "<h1>NEXUS TERMINAL</h1>" +
                "<p>CYBER ACADEMY ONLINE</p>" +
                "<p>JAVA SYSTEM: OK</p>" +
                "<p>NETWORK: SIMULATION ONLINE</p>" +
                "</center>" +
                "</html>";

        JLabel label =
                new JLabel(
                        texto,
                        SwingConstants.CENTER
                );

        janela.add(label);

        janela.setLocationRelativeTo(null);

        janela.setVisible(true);

        ganhar(10);

        pausar();
        limparTela();
    }

    // =========================================================
    // PERFIL
    // =========================================================

    static void perfil() {

        titulo("PERFIL DO OPERADOR");

        System.out.println(
                "OPERADOR: RAFAEL"
        );

        System.out.println(
                "NIVEL: " +
                nivel
        );

        System.out.println(
                "XP: " +
                xp
        );

        System.out.println(
                "PONTOS: " +
                pontos
        );

        categoria(
                "PROGRESSO"
        );

        mostrarBarra(
                "XP",
                xp % 100
        );

        System.out.println();

        if (nivel >= 4) {

            System.out.println(
                    VERDE +
                    "STATUS: JAVA MASTER" +
                    RESET
            );

        } else if (nivel >= 2) {

            System.out.println(
                    CIANO +
                    "STATUS: EM TREINAMENTO" +
                    RESET
            );

        } else {

            System.out.println(
                    AMARELO +
                    "STATUS: INICIANTE" +
                    RESET
            );
        }

        pausar();
        limparTela();
    }

    // =========================================================
    // XP
    // =========================================================

    static void ganhar(
            int quantidade
    ) {

        if (quantidade <= 0) {
            return;
        }

        pontos += quantidade;

        xp += quantidade;

        while (xp >= 100) {

            xp -= 100;

            if (nivel < 10) {

                nivel++;

                System.out.println();

                sucesso(
                        "LEVEL UP! Nivel " +
                        nivel
                );
            }
        }

        System.out.println(
                VERDE +
                "+" +
                quantidade +
                " pontos!" +
                RESET
        );
    }

    // =========================================================
    // HELPERS
    // =========================================================

    static void titulo(
            String texto
    ) {

        System.out.println();

        System.out.println(
                CIANO +
                NEGRITO +
                "============================================================"
        );

        System.out.println(
                "                 " +
                texto
        );

        System.out.println(
                "============================================================" +
                RESET
        );

        System.out.println();
    }

    static void categoria(
            String texto
    ) {

        System.out.println();

        System.out.println(
                ROXO +
                NEGRITO +
                "************** " +
                texto +
                " **************" +
                RESET
        );

        System.out.println();
    }

    static void separador() {

        System.out.println(
                AZUL +
                "------------------------------------------------------------" +
                RESET
        );
    }

    static void sucesso(
            String texto
    ) {

        System.out.println(
                VERDE +
                "[ OK ] " +
                texto +
                RESET
        );
    }

    static void erro(
            String texto
    ) {

        System.out.println(
                VERMELHO +
                "[ ERRO ] " +
                texto +
                RESET
        );
    }

    static void verificar(
            String nome,
            boolean ok
    ) {

        if (ok) {

            System.out.println(
                    VERDE +
                    "[ OK ] " +
                    nome +
                    RESET
            );

        } else {

            System.out.println(
                    VERMELHO +
                    "[ FAIL ] " +
                    nome +
                    RESET
            );
        }
    }

    static void mostrarBarra(
            String nome,
            int porcentagem
    ) {

        if (porcentagem < 0) {
            porcentagem = 0;
        }

        if (porcentagem > 100) {
            porcentagem = 100;
        }

        int tamanho = 25;

        int preenchido =
                (porcentagem * tamanho) / 100;

        System.out.print(
                nome +
                " ["
        );

        for (int i = 0; i < tamanho; i++) {

            if (i < preenchido) {

                System.out.print(
                        "#"
                );

            } else {

                System.out.print(
                        "-"
                );
            }
        }

        System.out.println(
                "] " +
                porcentagem +
                "%"
        );
    }

    static void barra(
            String texto,
            int velocidade
    ) throws Exception {

        for (int i = 0; i <= 25; i++) {

            int porcentagem =
                    (i * 100) / 25;

            System.out.print(
                    "\r" +
                    texto +
                    " ["
            );

            for (int j = 0; j < 25; j++) {

                if (j < i) {
                    System.out.print("#");
                } else {
                    System.out.print("-");
                }
            }

            System.out.print(
                    "] " +
                    porcentagem +
                    "%"
            );

            Thread.sleep(
                    velocidade
            );
        }

        System.out.println();
    }

    static void escrever(
            String texto,
            int velocidade
    ) throws Exception {

        for (
                int i = 0;
                i < texto.length();
                i++
        ) {

            System.out.print(
                    texto.charAt(i)
            );

            System.out.flush();

            Thread.sleep(
                    velocidade
            );
        }

        System.out.println();
    }

    static int lerInteiro() {

        try {

            return Integer.parseInt(
                    teclado.nextLine()
            );

        } catch (Exception e) {

            return -1;
        }
    }

    static void pausar() {

        System.out.println();

        System.out.println(
                AMARELO +
                "Pressione ENTER para continuar..." +
                RESET
        );

        teclado.nextLine();
    }

    static void bloqueado() throws Exception {

        erro(
                "Nivel bloqueado."
        );

        System.out.println(
                "Complete os niveis anteriores."
        );

        pausar();
        limparTela();
    }

    static void desligar() throws Exception {

        titulo("DESLIGANDO NEXUS");

        escrever(
                "Encerrando processos...",
                20
        );

        escrever(
                "Desconectando Cyber Lab...",
                20
        );

        escrever(
                "Fechando terminal...",
                20
        );

        System.out.println();

        System.out.println(
                VERMELHO +
                NEGRITO +
                "NEXUS OFFLINE" +
                RESET
        );

        Thread.sleep(1000);
    }

    static void limparTela() {

        System.out.print(
                "\033[H\033[2J"
        );

        System.out.flush();

        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
    }

    static String formatarGB(
            long bytes
    ) {

        double gb =
                bytes /
                (1024.0 * 1024.0 * 1024.0);

        return String.format(
                "%.2f GB",
                gb
        );
    }

    static String formatarMB(
            long bytes
    ) {

        double mb =
                bytes /
                (1024.0 * 1024.0);

        return String.format(
                "%.0f MB",
                mb
        );
    }

    static boolean possuiMaiuscula(
            String texto
    ) {

        for (
                int i = 0;
                i < texto.length();
                i++
        ) {

            if (
                    Character.isUpperCase(
                            texto.charAt(i)
                    )
            ) {

                return true;
            }
        }

        return false;
    }

    static boolean possuiNumero(
            String texto
    ) {

        for (
                int i = 0;
                i < texto.length();
                i++
        ) {

            if (
                    Character.isDigit(
                            texto.charAt(i)
                    )
            ) {

                return true;
            }
        }

        return false;
    }

    static boolean possuiSimbolo(
            String texto
    ) {

        for (
                int i = 0;
                i < texto.length();
                i++
        ) {

            char c =
                    texto.charAt(i);

            if (
                    !Character.isLetterOrDigit(c)
                    && !Character.isWhitespace(c)
            ) {

                return true;
            }
        }

        return false;
    }
}