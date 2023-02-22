/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bingo;

/**
 *
 * @author NOTE
 */
import java.util.*;
public class Jogo {
    private boolean ganhou = false;
    private List<Cartela> cartelas = new ArrayList<Cartela>();
    private int qtdJogadores = 0;
    private int modoJogo;
    private List<Integer> numerosSorteados = new ArrayList<Integer>();
    private List<Integer> ganhadores = new ArrayList<Integer>();
    
    public Jogo(int qtdJogadores, int modoJogo){
        this.modoJogo = modoJogo;
        this.qtdJogadores = qtdJogadores;
        for(int i = 0; i < this.qtdJogadores; i++){
            cartelas.add(new Cartela());
        }
    }
    
    private boolean procuraNumero(int valor){
        for(int numero : numerosSorteados){
            if(numero == valor)
                return true;
        }
        return false;
    }
    
    public boolean getGanhou(){
        return this.ganhou;
    }
    
    private void checarCartelas(int valor){
        int marcou = 0;
        for(Cartela cartela : cartelas){
            if(cartela.procurarValor(valor)){
                System.out.println("Jogador " + cartela.getIndice() + " marcou");
                marcou = 1;
            }
        }
        if(marcou == 0)
            System.out.println("Ninguem marcou nessa rodada");
    }
    
    private int gerarNumeroAleatorio(){
        Random gerador = new Random();
        int numSorteado = gerador.nextInt(75)+ 1; 
        while(procuraNumero(numSorteado)){
            numSorteado = gerador.nextInt(75)+ 1;
        }
        this.numerosSorteados.add(numSorteado);
        return numSorteado;
    }
    
    public void Jogar(){
        char continuar;
        do {
            int numSorteado = gerarNumeroAleatorio();
            System.out.println("Deseja continuar? (S/N)");
            Scanner sc = new Scanner(System.in);
            continuar = sc.next().charAt(0);
            if(continuar == 's' || continuar == 'S'){
                System.out.println("O numero sorteado foi: " + numSorteado);
                checarCartelas(numSorteado);
            } 
            for (Cartela cartela : cartelas) {
                System.out.println("Cartela " + cartela.getIndice());
                cartela.imprime();
                if(cartela.verSeGanhou(this.modoJogo)){
                    this.ganhou = true;
                    this.ganhadores.add(cartela.getIndice());
                }
            }
        } while(!ganhou && continuar != 'n' && continuar != 'N');
        if(ganhou){
            System.out.print("Fim de jogo! Vitoria da(s) cartela(s) : ");
            for(int i : ganhadores){
                System.out.println(i);
            }
        }
    }
}
