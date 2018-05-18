/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoedo;

/**
 *
 * @author guilh
 */

public class ProjetoEDO {
    
    // Constantes informadas pelo exercicio, intervalo [A,B] dividido em subintervalos de N passos, H é o passo
    public static final int N = 20;
    public static final float A = -1.0f, B=1.0f, H=(B-A) / N; 
    
    // u' = v, com u(0) = 1
    // v' = v^2 + u*x^2, com v(0) = 0
    public static void main(String[] args) {
        
        float[] vetX = new float[21];
        float[] vetU = new float[21];
        float[] vetV = new float[21];
        Result result = new Result(0.0f,1.0f,0.0f);
        RungeKutta4 rK = new RungeKutta4();
        
        System.out.println("------ TABELA DE VALORES RUNGE KUTTA 4 ------");
        
        vetX[0] = result.getX();
        vetU[0] = result.getU();
        vetV[0] = result.getV();
        
        for(int i=1;i<=N/2;i++){
            
            result = rK.RungeKutta4(result.getX(),result.getU(),result.getV(),H);

            // Preenchimento dos vetores X e U para utilização na regra de trapézios
            vetX[i] = result.getX();
            vetU[i] = result.getU();
            vetV[i] = result.getV();
            
        }
        
        result = new Result(0.0f,1.0f,0.0f);
        
        for(int i=1;i<=N/2;i++){
            
            result = rK.RungeKutta4(result.getX(),result.getU(),result.getV(),H*-1);

            // Preenchimento dos vetores X e U para utilização na regra de trapézios
            vetX[i+10] = result.getX();
            vetU[i+10] = result.getU();
            vetV[i+10] = result.getV();
            
        }
        
        // Imprimir valores na ordem do intervalo
        
        System.out.println("X: " + vetX[20] + ", U: " + vetU[20] + ", V: " + vetV[20]);
        System.out.println("X: " + vetX[19] + ", U: " + vetU[19] + ", V: " + vetV[19]);
        System.out.println("X: " + vetX[18] + ", U: " + vetU[18] + ", V: " + vetV[18]);
        System.out.println("X: " + vetX[17] + ", U: " + vetU[17] + ", V: " + vetV[17]);
        System.out.println("X: " + vetX[16] + ", U: " + vetU[16] + ", V: " + vetV[16]);
        System.out.println("X: " + vetX[15] + ", U: " + vetU[15] + ", V: " + vetV[15]);
        System.out.println("X: " + vetX[14] + ", U: " + vetU[14] + ", V: " + vetV[14]);
        System.out.println("X: " + vetX[13] + ", U: " + vetU[13] + ", V: " + vetV[13]);
        System.out.println("X: " + vetX[12] + ", U: " + vetU[12] + ", V: " + vetV[12]);
        System.out.println("X: " + vetX[11] + ", U: " + vetU[11] + ", V: " + vetV[11]);
        System.out.println("X: " + vetX[0] + ", U: " + vetU[0] + ", V: " + vetV[0]);
        System.out.println("X: " + vetX[1] + ", U: " + vetU[1] + ", V: " + vetV[1]);
        System.out.println("X: " + vetX[2] + ", U: " + vetU[2] + ", V: " + vetV[2]);
        System.out.println("X: " + vetX[3] + ", U: " + vetU[3] + ", V: " + vetV[3]);
        System.out.println("X: " + vetX[4] + ", U: " + vetU[4] + ", V: " + vetV[4]);
        System.out.println("X: " + vetX[5] + ", U: " + vetU[5] + ", V: " + vetV[5]);
        System.out.println("X: " + vetX[6] + ", U: " + vetU[6] + ", V: " + vetV[6]);
        System.out.println("X: " + vetX[7] + ", U: " + vetU[7] + ", V: " + vetV[7]);
        System.out.println("X: " + vetX[8] + ", U: " + vetU[8] + ", V: " + vetV[8]);
        System.out.println("X: " + vetX[9] + ", U: " + vetU[9] + ", V: " + vetV[9]);
        System.out.println("X: " + vetX[10] + ", U: " + vetU[10] + ", V: " + vetV[10]);
        
        
        System.out.println("---------------------------------------------");
        System.out.println("------ VALORES PARA REGRA DE TRAPÉZIO ------");
        
        // Definição do passo h para a regra de trapézios h = x1 - x0
        float h = vetX[1] - vetX[0];
        float soma = 0.0f;
        
        for(int i=0;i<=N;i++){
            System.out.println(soma += (2*vetU[i]));
            
        }
        soma -= (vetU[0] + vetU[20]);
            
        float resultado = (h/2) * soma;
        System.out.println("--------------------------------------------");
        System.out.println("Resultado final: " + resultado);
        System.out.println("--------------------------------------------");
        
    }
    
}
