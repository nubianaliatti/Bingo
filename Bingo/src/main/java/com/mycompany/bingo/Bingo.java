/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.bingo;

/**
 *
 * @author NOTE
 */
import java.util.*;
public class Bingo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo!");
        System.out.println("Digite quantos jogadores irao jogar:");
        int qtdJogadores = sc.nextInt();
        System.out.println("Digite qual sera o tipo de jogo: 1 para linha/coluna ou 2 para cruz:");
        int tipoJogo = sc.nextInt();
        Jogo jogo = new Jogo(qtdJogadores,tipoJogo);
        jogo.Jogar();
        
     
    }
}
