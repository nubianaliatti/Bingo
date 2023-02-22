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
public class Cartela{
    private String cartela[][] = new String[5][5];
    private static int totalCartelas = 0;
    private int indice;
    int [] numeros = new int[25];
    
    public Cartela(){
        this.indice = Cartela.getTotalCartelas() + 1;
        this.totalCartelas++;
        this.preencherVetor();
        this.preencherCartela();
        this.imprime();
    }
    
    public int getIndice(){
        return this.indice;
    }
    
    public static int getTotalCartelas(){
        return Cartela.totalCartelas;
    }
        
    private void preencherVetor(){
        Random gerador = new Random();
        for (int i = 0; i < 5; i++) {
            int numAleatorio = -1;
            do{
                numAleatorio = gerador.nextInt(15)+ 1;
            } while(procuraVetor(numAleatorio, 5));
            numeros[i] = numAleatorio;
        }
        for (int i = 5; i < 10; i++) {
            int numAleatorio = -1;
            do{
                numAleatorio = gerador.nextInt(14)+ 16;
            } while (procuraVetor(numAleatorio, 10));
            numeros[i] = numAleatorio;
        }
        for (int i = 10; i < 15; i++) {
            int numAleatorio = -1;
            do{
               numAleatorio = gerador.nextInt(14)+ 31;
            } while (procuraVetor(numAleatorio,15));
            numeros[i] = numAleatorio;
        }
        for (int i = 15; i < 20; i++) {
            int numAleatorio = -1;
            do{
                numAleatorio = gerador.nextInt(14)+ 46;
            }while (procuraVetor(numAleatorio,20));
            numeros[i] = numAleatorio;
        }
        for (int i = 20; i < 25; i++) {
            int numAleatorio = -1;
            do{
                numAleatorio = gerador.nextInt(14)+ 61;
            } while(procuraVetor(numAleatorio,25));
            numeros[i] = numAleatorio;
        }
        Arrays.sort(numeros);
    }
    
    private void preencherCartela(){
        int indice = 0;
        for(int i = 0; i < 5; i ++){
            for (int j = 0; j < 5; j++){
                if(numeros[indice]<10){
                    cartela[j][i] =  "[ ]" + "0" + Integer.toString(numeros[indice]);
                }
                else{
                    cartela[j][i] = "[ ]" + Integer.toString(numeros[indice]);
                }
                indice++;
            }
        }
        cartela[2][2] = "     ";
    }
    
    public void imprime(){
        System.out.println("  B      I      N      G      O");
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++)
                System.out.print(cartela[i][j] + "  ");
            System.out.println();
        }
        System.out.println();
    }
    
    public void marcarPosicao(int linha, int coluna){
        if(cartela[linha][coluna].charAt(0)!=' '){
            String nova = cartela[linha][coluna].replace(" ","x");
            cartela[linha][coluna] = nova;
        }
    }
    
    private boolean verSeGanhouColuna(int coluna){        
        for (int i = 0; i < 5; i++) {
            String aux = cartela[i][coluna];
            if (aux.charAt(1) != 'x' && aux.charAt(0)!= ' ') {
                return false;
            }
        }
        return true;
    }
    
    private boolean verSeGanhouLinha(int linha){
        for (int i = 0; i < 5; i++) {
            String aux = cartela[linha][i];
            if (aux.charAt(1) != 'x' && aux.charAt(0)!=' ') {
                return false;
            }
        }
        return true;
    }
    

    public boolean procurarValor(int valor){
        int linha, coluna;
        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j ++){
                if(i != 2 || j != 2){
                    String aux = cartela[i][j].substring(3);
                    if(Integer.parseInt(aux) == valor){
                        linha = i; 
                        coluna = j;
                        marcarPosicao(linha,coluna);
                        return true;
                    }  
                }             
            }
        }
        return false;
    }
    
    public boolean verSeGanhou(int tipoJogo){
        boolean ganhou = false;
        if(tipoJogo == 1){
            for(int i = 0; i < 5; i ++){
                if(verSeGanhouLinha(i)){
                    ganhou = true;
                    break;
                }
            }
            if(!ganhou){
                for(int i = 0; i < 5; i++){
                    if(verSeGanhouColuna(i)){
                        ganhou = true;
                        break;
                    }
                }
            }
        }
        else{
            if(verSeGanhouLinha(2) && verSeGanhouColuna(2)){
                ganhou = true;
            }
        }
        return ganhou;
    }
    
    private boolean procuraVetor(int valor, int fim){
        for(int i = 0; i < fim; i++){
            if(numeros[i] == valor)
                return true;
        }
        return false;
    }
  
}
