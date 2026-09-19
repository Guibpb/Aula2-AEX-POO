package com.mycompany.mavenproject1;

//imports
import java.awt.FlowLayout;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Mavenproject1 {

    //Código V1 da lanchonete que roda no Terminal
    public static void lanchoneteTerminal() {
        int dinheiro = 100;
        Scanner entrada = new Scanner(System.in);
        //cria um Loop
        while (true) {
            
            
            System.out.println("\n=== Bem vindo ao meu restaurante! ===");
            System.out.println("Você tem atualmente " + dinheiro + " Reais.");
            System.out.println("Você quer trabalhar, comprar algo ou deseja sair? (Escreva: trabalhar / comprar / sair)");

            String escolha = entrada.nextLine().trim().toLowerCase();
            
            //Código do Trabalho
            if (escolha.equals("trabalhar")) {
                System.out.println("Certo, você deve digitar exatamente TRABALHO agora:");
                String trabalho = entrada.nextLine();

                if (trabalho.equals("TRABALHO")) {
                    System.out.println("Boa! Seu prêmio será 10 R$!!");
                    dinheiro += 10;
                } else {
                    System.out.println("Oops, Você errou... Tente escrever exatamente trabalho com letras maiúsculas (TRABALHO).");
                } //Fim do Código do Trabalho
                
            //Código de Compra    
            } else if (escolha.equals("comprar")) { // Adicionada a chave de abertura aqui
                System.out.println("Certo, o cardápio é: lanche (25R$), bebida (10R$) ou o combo (55R$).");
                String qualPedido = entrada.nextLine().trim().toLowerCase();

                if (qualPedido.equals("lanche")) {
                    System.out.println("ok, qual o lanche?");
                    String lanche = entrada.nextLine();
                    System.out.println("Certo, saindo um/uma " + lanche + ", o preço é de 25 R$.");
                    dinheiro -= 25;
                } else if (qualPedido.equals("bebida")) {
                    System.out.println("Perfeito, qual bebida você quer?");
                    String bebida = entrada.nextLine();
                    System.out.println("Ok, saindo agora um/uma " + bebida + ", que vai custar 10 R$.");
                    dinheiro -= 10;
                } else if (qualPedido.equals("combo")) {
                    System.out.println("Boa, escolha os itens");
                    System.out.println("qual lanche?");
                    String lanche = entrada.nextLine();
                    System.out.println("Ok, e agora a bebida?");
                    String bebida = entrada.nextLine();
                    System.out.println("Certo, e o acompanhamento?");
                    String acompanhamento = entrada.nextLine();

                    System.out.println("Beleza, vamos verificar seu pedido: " + lanche + ", " + bebida + " e " + acompanhamento + ", vai custar 55 R$.");
                    dinheiro -= 55;
                } else {
                    System.out.println("Opção de produto inválida.");
                } // Fim do Código de compra
                
            //Código de saída
            } else if (escolha.equals("sair")) { // Agora testa a variável correta no menu principal
                System.out.println("Fim de jogo! Jogo finalizado com total de dinheiro: " + dinheiro + " R$!");
                break; //Termina o loop
                //Fim do código de saída
                
            } else {
                System.out.println("Opção inválida! Escolha entre trabalhar, comprar ou sair.");
            }
        }

        entrada.close();
    } //FIM DO  MÉTODO  "lanchoneteTerminal"
    
    //Código V2 (em progresso) da lanchonete que roda em uma janela Pop-Up
    public static void lanchoneteVisual() {
            //Criação da janela
        JFrame janela = new JFrame ("Lanchonete");
        JLabel criacaoPersonagem = new JLabel ("Qual o seu nome?");
        JTextField caixaDeTexto1 = new JTextField (15);
        JButton cadastrarPersonagem = new JButton ("Cadastrar - Se!");
        
        //O que recebe o texto do botão
        cadastrarPersonagem.addActionListener(evento -> {
        String textoDigitado = caixaDeTexto1.getText();
        criacaoPersonagem.setText("Ok! Você foi cadastrado no jogo! seu nome é: " + textoDigitado);
        cadastrarPersonagem.setVisible(false);
        caixaDeTexto1.setVisible(false);
        JLabel escolha = new JLabel ("O que você quer fazer agora?");
        JButton botaoTrabalho = new JButton ("Trabalhar");
        botaoTrabalho.addActionListener(trabalhar -> { 
        criacaoPersonagem.setText("Ok. Agora, você deve Lavar a louça!");
        JLabel trabalho = new JLabel("Digite exatamente 'lavar pratos' agora");
        JTextField louca = new JTextField(12);
        JButton terminarTrabalho = new JButton("Finalizar Trabalho");
                    janela.add(trabalho);
                    janela.add(louca);
                    janela.add(terminarTrabalho);
            terminarTrabalho.addActionListener(fim -> {
            String textoDigitadoTrabalho = louca.getText().trim();
        JButton botaoComprar = new JButton ("Comprar");
        JButton botaoSair = new JButton ("Sair");
                    janela.add(escolha);
                    janela.add(botaoTrabalho);
                    janela.add(botaoComprar);
                    janela.add(botaoSair);
        });
        janela.setLayout(new FlowLayout());
    janela.add(criacaoPersonagem);  
    janela.add(caixaDeTexto1);
    janela.add(cadastrarPersonagem);
    janela.setSize(400, 200);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setLocationRelativeTo(null);
    janela.setVisible(true);
    });  
        });
                } // FIM DO MÉTODO "lanchineteVisual"
    
    //main
    public static void main(String[] args) {
        lanchoneteVisual();
    } // FIM DA MAIN
} // FIM DA CLASSE

