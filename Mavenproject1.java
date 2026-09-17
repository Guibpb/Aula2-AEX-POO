/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author israe
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        int dinheiro = 100;
        Scanner entrada = new Scanner(System.in); 
        
        while (true) {
            System.out.println("\n=== Bem vindo ao meu restaurante! ===");
            System.out.println("Você tem atualmente " + dinheiro + " Reais.");
            System.out.println("Você quer trabalhar, comprar algo ou deseja sair? (Escreva: trabalhar / comprar / sair)");
            
            String escolha = entrada.nextLine().trim().toLowerCase();
            
            if (escolha.equals("trabalhar")) {
                System.out.println("Certo, você deve digitar exatamente TRABALHO agora:");
                String trabalho = entrada.nextLine();
                
                if (trabalho.equals("TRABALHO")) {
                    System.out.println("Boa! Seu prêmio será 10 R$!!");
                    dinheiro += 10;
                } else {
                    System.out.println("Oops, Você errou... Tente escrever exatamente trabalho com letras maiúsculas (TRABALHO).");
                }
            } 
            else if (escolha.equals("comprar")) { // Adicionada a chave de abertura aqui
                System.out.println("Certo, o cardápio é: lanche (25R$), bebida (10R$) ou o combo (55R$).");
                String qualPedido = entrada.nextLine().trim().toLowerCase();
                
                if (qualPedido.equals("lanche")) {
                    System.out.println("ok, qual o lanche?");
                    String lanche = entrada.nextLine();
                    System.out.println("Certo, saindo um/uma " + lanche + ", o preço é de 25 R$.");
                    dinheiro -= 25;
                } 
                else if (qualPedido.equals("bebida")) {
                    System.out.println("Perfeito, qual bebida você quer?");
                    String bebida = entrada.nextLine();
                    System.out.println("Ok, saindo agora um/uma " + bebida + ", que vai custar 10 R$.");
                    dinheiro -= 10;
                } 
                else if (qualPedido.equals("combo")) {
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
                }
            } 
            else if (escolha.equals("sair")) { // Agora testa a variável correta no menu principal
                System.out.println("Fim de jogo! Jogo finalizado com total de dinheiro: " + dinheiro + " R$!");
                break; 
            } else {
                System.out.println("Opção inválida! Escolha entre trabalhar, comprar ou sair.");
            }
        }
        
        entrada.close();
    }
    }

