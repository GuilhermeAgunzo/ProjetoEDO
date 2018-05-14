/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoedo;

import projetoedo.RungeKutta4;
import projetoedo.Result;

/**
 *
 * @author guilh
 */
public class ProjetoEDO {

    public static final float N = 20.0f, A = -1.0f, B=1.0f, H=(B-A) / N; 
    
    // u' = v, com u(0) = 1
    // v' = v^2 + u*x^2, com v(0) = 0
    
    public static void main(String[] args) {
        //double n = 20.0, a = -1.0, b = 1.0;
        //double h = (b-a)/n;
        
        float x,u,v;
        float[] vetX = new float[20];
        float[] vetU = new float[20];
        Result result = new Result(0.0f,1.0f,0.0f);
        RungeKutta4 rK = new RungeKutta4();
        
        System.out.println("------ TABELA DE VALORES RUNGE KUTTA 4 ------");
        
        for(int i=0;i<N;i++){
            
            result = rK.RungeKutta4(result.getX(),result.getU(),result.getV(),H);
            
            x = result.getX();
            u = result.getU();
            v = result.getV();
            
            // Preenchimento dos vetores X e U para utilização na regra de trapézios
            vetX[i] = x;
            vetU[i] = u;
            
            // Atribuindo novo valor a x,u e v
            result.setX(x);
            result.setU(u);
            result.setV(v);
            
            System.out.println("X: " + result.getX() + ", U: " + result.getU() + ", V: " + result.getV());
            
        }
        
        System.out.println("---------------------------------------------");
        System.out.println("------ VALORES PARA REGRA DE TRAPÉZIO ------");
        
        float h = vetX[1] - vetX[0];
        float soma = 0.0f;
        
        for(int i=0;i<N;i++){
            soma += (2*vetU[i]);
            soma -= (vetU[0] - vetU[i]);
            
            float resultado = (h/2) * soma;
            System.out.println(resultado);
        }
        
        System.out.println("--------------------------------------------");
        
    }
    
}
