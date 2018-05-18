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
        
        // Organizar vetores
        
        float aux;
        
        for(int i = 0; i<=N; i++){
		for(int j = 0; j<=N-1; j++){
			if(vetX[j] > vetX[j + 1]){
				aux = vetX[j];
				vetX[j] = vetX[j+1];
				vetX[j+1] = aux;
                                
                                aux = vetU[j];
				vetU[j] = vetU[j+1];
				vetU[j+1] = aux;
                                
                                aux = vetV[j];
				vetV[j] = vetV[j+1];
				vetV[j+1] = aux;
			}
		}
	}
        
        for(int i = 0; i<=N; i++){
		System.out.println("X: " + vetX[i] + ", U: " + vetU[i] + ", V: " + vetV[i]);
	} 
        
        System.out.println("---------------------------------------------");
        System.out.println("------ VALORES PARA REGRA DE TRAPÉZIO ------");
        
        // Definição do passo h para a regra de trapézios h = x1 - x0
        
        float soma = 0.0f;
        
        for(int i=0;i<=N;i++){
            soma += vetU[i];
        }
            
        float resultado = (H/2) * (vetU[0] + (2*soma) + vetU[20]);
        System.out.println("--------------------------------------------");
        System.out.println("Resultado final: " + resultado);
        System.out.println("--------------------------------------------");
        
    }
    
}
