/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aula1cursojava;

import java.util.Random;
import java.util.Scanner;

public class Grupo3AULA1Rafael {

    // ==========================================
    // CORES DO TERMINAL
    // ==========================================
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
    static Random aleatorio = new Random();

    // ==========================================
    // MAIN
    // ==========================================
    public static void main(String[] args) throws Exception {

        limparTela();

        iniciarSistema();

        menuPrincipal();
    }

    // ==========================================
    // INICIALIZAÇÃO
    // ==========================================
    static void iniciarSistema() throws Exception {

        System.out.println(CIANO + NEGRITO);
        System.out.println("======================================================");
        System.out.println("              N E X U S   T E R M I N A L            ");
        System.out.println("                  VERSAO 2.0                          ");
        System.out.println("======================================================");
        System.out.println(RESET);

        Thread.sleep(500);

        escrever("Inicializando sistema...", 30);
        barraCarregamento("Carregando modulos", 20);

        escrever("Verificando memoria...", 30);
        barraCarregamento("Preparando interface", 20);

        escrever("Conectando ao nucleo principal...", 30);
        barraCarregamento("Iniciando terminal", 20);

        System.out.println();

        System.out.println(
                VERDE + NEGRITO +
                "[ OK ] SISTEMA INICIADO COM SUCESSO!" +
                RESET
        );

        Thread.sleep(700);

        limparTela();

        System.out.println(VERDE + NEGRITO);
        System.out.println("======================================================");
        System.out.println("             ACESSO AO NEXUS CONCEDIDO               ");
        System.out.println("======================================================");
        System.out.println(RESET);

        System.out.println();

        escrever("Bem-vindo ao terminal, operador Rafael.", 35);

        System.out.println();
        System.out.println(
                AMARELO +
                "Pressione ENTER para continuar..." +
                RESET
        );

        teclado.nextLine();

        limparTela();
    }

    // ==========================================
    // MENU PRINCIPAL
    // ==========================================
    static void menuPrincipal() throws Exception {

        int opcao = -1;

        do {

            System.out.println(CIANO + NEGRITO);
            System.out.println("======================================================");
            System.out.println("                  NEXUS TERMINAL                     ");
            System.out.println("======================================================");
            System.out.println(RESET);

            System.out.println(CIANO + "[1]" + RESET + " Painel do sistema");
            System.out.println(CIANO + "[2]" + RESET + " Scanner de rede");
            System.out.println(CIANO + "[3]" + RESET + " Gerador de codigo");
            System.out.println(CIANO + "[4]" + RESET + " Desafio secreto");
            System.out.println(CIANO + "[5]" + RESET + " BATALHA NEON");
            System.out.println(CIANO + "[6]" + RESET + " Sobre o sistema");
            System.out.println(CIANO + "[0]" + RESET + " Desligar");

            System.out.println();

            System.out.print(
                    AMARELO +
                    "NEXUS > Escolha uma opcao: " +
                    RESET
            );

            opcao = lerInteiro();

            limparTela();

            switch (opcao) {

                case 1:
                    painelSistema();
                    break;

                case 2:
                    scannerRede();
                    break;

                case 3:
                    geradorCodigo();
                    break;

                case 4:
                    desafioSecreto();
                    break;

                case 5:
                    batalhaNeon();
                    break;

                case 6:
                    sobreSistema();
                    break;

                case 0:
                    desligar();
                    break;

                default:

                    System.out.println(
                            VERMELHO +
                            "[ERRO] Opcao invalida!" +
                            RESET
                    );

                    Thread.sleep(1000);
                    limparTela();
            }

        } while (opcao != 0);
    }

    // ==========================================
    // PAINEL DO SISTEMA
    // ==========================================
    static void painelSistema() throws Exception {

        int processador = aleatorio.nextInt(71) + 20;
        int memoria = aleatorio.nextInt(61) + 20;
        int temperatura = aleatorio.nextInt(21) + 40;
        int processos = aleatorio.nextInt(180) + 50;

        System.out.println(ROXO + NEGRITO);
        System.out.println("======================================================");
        System.out.println("                 PAINEL DO SISTEMA                   ");
        System.out.println("======================================================");
        System.out.println(RESET);

        System.out.println();

        System.out.println(CIANO + "PROCESSADOR" + RESET);
        mostrarBarra(processador);

        System.out.println();

        System.out.println(CIANO + "MEMORIA" + RESET);
        mostrarBarra(memoria);

        System.out.println();

        System.out.println(CIANO + "TEMPERATURA" + RESET);
        System.out.println(
                VERDE +
                "Temperatura atual: " +
                temperatura +
                " graus C" +
                RESET
        );

        System.out.println();

        System.out.println(CIANO + "PROCESSOS ATIVOS" + RESET);
        System.out.println(
                VERDE +
                processos +
                " processos em execucao." +
                RESET
        );

        System.out.println();

        System.out.println(VERDE + "[ONLINE] Nucleo" + RESET);
        System.out.println(VERDE + "[ONLINE] Seguranca" + RESET);
        System.out.println(VERDE + "[ONLINE] Rede" + RESET);
        System.out.println(VERDE + "[ONLINE] Sistema" + RESET);

        voltar();
    }

    // ==========================================
    // SCANNER DE REDE
    // ==========================================
    static void scannerRede() throws Exception {

        System.out.println(AZUL + NEGRITO);
        System.out.println("======================================================");
        System.out.println("                    SCANNER DE REDE                  ");
        System.out.println("======================================================");
        System.out.println(RESET);

        System.out.println();

        escrever("Procurando dispositivos...", 30);

        Thread.sleep(500);

        String[] dispositivos = {
            "ROTEADOR-PRINCIPAL",
            "CELULAR-01",
            "NOTEBOOK-02",
            "SERVIDOR-NEXUS",
            "IMPRESSORA-REDE",
            "DISPOSITIVO-DESCONHECIDO"
        };

        for (int i = 0; i < dispositivos.length; i++) {

            int ping = aleatorio.nextInt(60) + 10;

            System.out.println(
                    VERDE +
                    "[ONLINE] " +
                    RESET +
                    String.format(
                            "%-28s",
                            dispositivos[i]
                    ) +
                    CIANO +
                    "PING: " +
                    ping +
                    "ms" +
                    RESET
            );

            Thread.sleep(250);
        }

        System.out.println();

        System.out.println(
                AMARELO +
                "[!] Varredura concluida." +
                RESET
        );

        System.out.println(
                "6 dispositivos encontrados."
        );

        voltar();
    }

    // ==========================================
    // GERADOR DE CODIGO
    // ==========================================
    static void geradorCodigo() throws Exception {

        System.out.println(VERDE + NEGRITO);
        System.out.println("======================================================");
        System.out.println("                  GERADOR DE CODIGO                  ");
        System.out.println("======================================================");
        System.out.println(RESET);

        System.out.println();

        escrever(
                "Gerando sequencia criptografica...",
                30
        );

        Thread.sleep(500);

        String caracteres =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String codigo = "";

        for (int i = 0; i < 20; i++) {

            int indice =
                    aleatorio.nextInt(
                            caracteres.length()
                    );

            codigo =
                    codigo +
                    caracteres.charAt(indice);

            if (i == 4 || i == 9 || i == 14) {

                codigo = codigo + "-";
            }
        }

        System.out.println();

        System.out.println(
                CIANO + NEGRITO +
                "CODIGO GERADO:" +
                RESET
        );

        System.out.println();

        System.out.println(
                AMARELO +
                ">>> " +
                codigo +
                " <<<" +
                RESET
        );

        System.out.println();

        System.out.println(
                VERDE +
                "[OK] Codigo criado com sucesso!" +
                RESET
        );

        voltar();
    }

    // ==========================================
    // DESAFIO SECRETO
    // ==========================================
    static void desafioSecreto() throws Exception {

        System.out.println(VERMELHO + NEGRITO);
        System.out.println("======================================================");
        System.out.println("                  DESAFIO SECRETO                    ");
        System.out.println("======================================================");
        System.out.println(RESET);

        System.out.println();

        escrever(
                "O sistema escolheu um numero entre 1 e 10...",
                30
        );

        int numeroSecreto =
                aleatorio.nextInt(10) + 1;

        System.out.println();

        System.out.print(
                AMARELO +
                "Digite seu palpite: " +
                RESET
        );

        int palpite = lerInteiro();

        System.out.println();

        if (palpite == numeroSecreto) {

            System.out.println(
                    VERDE + NEGRITO +
                    "!!! ABSURDO! VOCE ACERTOU !!!" +
                    RESET
            );

        } else {

            System.out.println(
                    VERMELHO +
                    "Voce errou!" +
                    RESET
            );
        }

        System.out.println(
                "O numero secreto era: " +
                numeroSecreto
        );

        voltar();
    }

    // ==========================================
    // BATALHA NEON - MINIGAME
    // ==========================================
    static void batalhaNeon() throws Exception {

        String[] inimigos = {
            "DRONE-X",
            "GUARDIAO NEXUS",
            "ROBO TITAN",
            "CYBER FERA",
            "ANDROIDE 404"
        };

        String inimigo =
                inimigos[
                        aleatorio.nextInt(
                                inimigos.length
                        )
                ];

        int vidaJogador = 100;
        int vidaInimigo = 100;
        int pocoes = 3;
        int pontos = 0;

        System.out.println(ROXO + NEGRITO);
        System.out.println("======================================================");
        System.out.println("                 B A T A L H A   N E O N            ");
        System.out.println("======================================================");
        System.out.println(RESET);

        System.out.println();

        escrever(
                "O inimigo detectou sua presenca...",
                35
        );

        Thread.sleep(700);

        escrever(
                "INIMIGO: " + inimigo,
                40
        );

        Thread.sleep(700);

        System.out.println();

        while (vidaJogador > 0 && vidaInimigo > 0) {

            System.out.println(CIANO + NEGRITO);
            System.out.println("---------------- STATUS ----------------");
            System.out.println(RESET);

            System.out.println(
                    VERDE +
                    "Sua vida: " +
                    vidaJogador +
                    "/100" +
                    RESET
            );

            System.out.println(
                    VERMELHO +
                    "Vida do inimigo: " +
                    vidaInimigo +
                    "/100" +
                    RESET
            );

            System.out.println(
                    AMARELO +
                    "Pocoes restantes: " +
                    pocoes +
                    RESET
            );

            System.out.println();

            System.out.println("1 - ATACAR");
            System.out.println("2 - CURAR");
            System.out.println("3 - DEFENDER");

            System.out.println();

            System.out.print(
                    AMARELO +
                    "NEXUS > Sua acao: " +
                    RESET
            );

            int acao = lerInteiro();

            boolean defendendo = false;

            System.out.println();

            // --------------------------------------
            // ATACAR
            // --------------------------------------

            if (acao == 1) {

                int dano =
                        aleatorio.nextInt(16) + 10;

                int critico =
                        aleatorio.nextInt(100);

                if (critico < 20) {

                    dano = dano * 2;

                    System.out.println(
                            AMARELO + NEGRITO +
                            "!!! ATAQUE CRITICO !!!" +
                            RESET
                    );
                }

                vidaInimigo =
                        vidaInimigo - dano;

                if (vidaInimigo < 0) {
                    vidaInimigo = 0;
                }

                pontos = pontos + dano;

                System.out.println(
                        CIANO +
                        "Voce causou " +
                        dano +
                        " de dano!" +
                        RESET
                );
            }

            // --------------------------------------
            // CURAR
            // --------------------------------------

            else if (acao == 2) {

                if (pocoes > 0) {

                    int cura =
                            aleatorio.nextInt(16) + 15;

                    vidaJogador =
                            vidaJogador + cura;

                    if (vidaJogador > 100) {
                        vidaJogador = 100;
                    }

                    pocoes--;

                    System.out.println(
                            VERDE +
                            "Voce recuperou " +
                            cura +
                            " de vida!" +
                            RESET
                    );

                } else {

                    System.out.println(
                            VERMELHO +
                            "Voce nao possui mais pocoes!" +
                            RESET
                    );
                }
            }

            // --------------------------------------
            // DEFENDER
            // --------------------------------------

            else if (acao == 3) {

                defendendo = true;

                System.out.println(
                        AZUL +
                        "Voce assumiu uma posicao defensiva!" +
                        RESET
                );
            }

            else {

                System.out.println(
                        VERMELHO +
                        "Acao invalida! Voce perdeu sua vez." +
                        RESET
                );
            }

            // --------------------------------------
            // INIMIGO ATACA
            // --------------------------------------

            if (vidaInimigo > 0) {

                Thread.sleep(500);

                int danoInimigo =
                        aleatorio.nextInt(13) + 8;

                if (defendendo) {

                    danoInimigo =
                            danoInimigo / 2;

                    System.out.println(
                            AZUL +
                            "Sua defesa reduziu o ataque!" +
                            RESET
                    );
                }

                vidaJogador =
                        vidaJogador - danoInimigo;

                if (vidaJogador < 0) {
                    vidaJogador = 0;
                }

                System.out.println(
                        VERMELHO +
                        inimigo +
                        " causou " +
                        danoInimigo +
                        " de dano!" +
                        RESET
                );
            }

            System.out.println();

            Thread.sleep(500);
        }

        // ==========================================
        // RESULTADO
        // ==========================================

        System.out.println();
        System.out.println(CIANO + NEGRITO);
        System.out.println("======================================================");
        System.out.println("                    RESULTADO                        ");
        System.out.println("======================================================");
        System.out.println(RESET);

        if (vidaJogador > 0) {

            pontos = pontos + vidaJogador + 100;

            System.out.println(
                    VERDE + NEGRITO +
                    "        VITORIA!!!" +
                    RESET
            );

            System.out.println();

            System.out.println(
                    "O inimigo " +
                    inimigo +
                    " foi derrotado!"
            );

            System.out.println(
                    AMARELO +
                    "PONTUACAO: " +
                    pontos +
                    RESET
            );

        } else {

            System.out.println(
                    VERMELHO + NEGRITO +
                    "        DERROTA..." +
                    RESET
            );

            System.out.println();

            System.out.println(
                    "O inimigo " +
                    inimigo +
                    " venceu."
            );

            System.out.println(
                    AMARELO +
                    "Pontuacao: " +
                    pontos +
                    RESET
            );
        }

        voltar();
    }

    // ==========================================
    // SOBRE
    // ==========================================
    static void sobreSistema() throws Exception {

        System.out.println(ROXO + NEGRITO);
        System.out.println("======================================================");
        System.out.println("                     SOBRE                            ");
        System.out.println("======================================================");
        System.out.println(RESET);

        System.out.println();

        System.out.println(
                CIANO + NEGRITO +
                "NEXUS TERMINAL" +
                RESET
        );

        System.out.println();

        System.out.println(
                "Sistema desenvolvido em Java."
        );

        System.out.println(
                "Interface totalmente baseada em terminal."
        );

        System.out.println(
                "Possui painel, scanner, gerador, desafios e minigame."
        );

        System.out.println();

        System.out.println(
                VERDE +
                "Desenvolvedor: Rafael" +
                RESET
        );

        System.out.println();

        voltar();
    }

    // ==========================================
    // DESLIGAMENTO
    // ==========================================
    static void desligar() throws Exception {

        System.out.println(
                VERMELHO + NEGRITO +
                "Encerrando sistema..." +
                RESET
        );

        System.out.println();

        barraCarregamento(
                "Desconectando modulos",
                25
        );

        System.out.println();

        System.out.println(
                VERMELHO + NEGRITO +
                "======================================================"
        );

        System.out.println(
                "               NEXUS TERMINAL OFFLINE                "
        );

        System.out.println(
                "======================================================" +
                RESET
        );

        System.out.println();

        Thread.sleep(1200);
    }

    // ==========================================
    // BARRA DE CARREGAMENTO
    // ==========================================
    static void barraCarregamento(
            String texto,
            int velocidade
    ) throws Exception {

        for (int i = 0; i <= 30; i++) {

            int porcentagem =
                    (i * 100) / 30;

            System.out.print("\r");

            System.out.print(
                    CIANO +
                    texto +
                    " [" +
                    RESET
            );

            for (int j = 0; j < 30; j++) {

                if (j < i) {

                    System.out.print(
                            VERDE + "#" + RESET
                    );

                } else {

                    System.out.print("-");
                }
            }

            System.out.print(
                    "] " +
                    porcentagem +
                    "%"
            );

            Thread.sleep(velocidade);
        }

        System.out.println();
    }

    // ==========================================
    // BARRA DO SISTEMA
    // ==========================================
    static void mostrarBarra(int porcentagem) {

        int tamanho = 30;

        int preenchido =
                (porcentagem * tamanho) / 100;

        System.out.print(
                VERDE +
                "[" +
                RESET
        );

        for (int i = 0; i < tamanho; i++) {

            if (i < preenchido) {

                System.out.print(
                        VERDE + "#" + RESET
                );

            } else {

                System.out.print("-");
            }
        }

        System.out.println(
                "] " +
                porcentagem +
                "%"
        );
    }

    // ==========================================
    // EFEITO DE DIGITACAO
    // ==========================================
    static void escrever(
            String texto,
            int velocidade
    ) throws Exception {

        for (int i = 0; i < texto.length(); i++) {

            System.out.print(
                    texto.charAt(i)
            );

            System.out.flush();

            Thread.sleep(velocidade);
        }

        System.out.println();
    }

    // ==========================================
    // LER NUMERO
    // ==========================================
    static int lerInteiro() {

        try {

            return Integer.parseInt(
                    teclado.nextLine()
            );

        } catch (Exception e) {

            return -1;
        }
    }

    // ==========================================
    // VOLTAR
    // ==========================================
    static void voltar() {

        System.out.println();

        System.out.println(
                AMARELO +
                "Pressione ENTER para voltar..." +
                RESET
        );

        teclado.nextLine();

        limparTela();
    }

    // ==========================================
    // LIMPAR TERMINAL
    // ==========================================
    static void limparTela() {

        System.out.print(
                "\033[H\033[2J"
        );

        System.out.flush();

        // Ajuda em terminais que nao suportam ANSI
        for (int i = 0; i < 8; i++) {

            System.out.println();
        }
    }
}