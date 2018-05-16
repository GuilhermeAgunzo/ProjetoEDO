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
        Result result = new Result(0.0f,1.0f,0.0f);
        RungeKutta4 rK = new RungeKutta4();
        
        System.out.println("------ TABELA DE VALORES RUNGE KUTTA 4 ------");
        
        for(int i=0;i<=N;i++){
            
            result = rK.RungeKutta4(result.getX(),result.getU(),result.getV(),H);

            // Preenchimento dos vetores X e U para utilização na regra de trapézios
            vetX[i] = result.getX();
            vetU[i] = result.getU();

            System.out.println("X: " + result.getX() + ", U: " + result.getU() + ", V: " + result.getV());
            
        }
        
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
