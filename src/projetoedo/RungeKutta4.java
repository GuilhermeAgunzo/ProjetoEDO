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

public class RungeKutta4 {
    
    // f(x)
    public float dudx (float x,float u,float v){
        return v;
    }
    
    // g(x)
    public float dvdx (float x, float u, float v){
        return (float) (Math.pow(v, 2) + (u * Math.pow(x,2)));
    }
    
    // Método de Runge Kutta de 4ª ordem
    public Result RungeKutta4(float x, float u, float v, float h) {
        
        Result result = new Result();
        float[] k = new float[4];
        float[] l = new float[4];
        float resultK, resultL;
        
        k[0] = h * dudx(x,u,v);
        l[0] = h * dvdx(x,u,v);
        
        k[1] = h * dudx(x+(h/2.0f), u+(k[0]/2.0f),v+(l[0]/2.0f));
        l[1] = h * dvdx(x+(h/2.0f), u+(k[0]/2.0f),v+(l[0]/2.0f));
        
        k[2] = h * dudx(x+(h/2.0f), u+(k[1]/2.0f),v+(l[1]/2.0f));
        l[2] = h * dvdx(x+(h/2.0f), u+(k[1]/2.0f),v+(l[1]/2.0f));
        
        k[3] = h * dudx(x+h, u+k[2], v+l[2]);
        l[3] = h * dvdx(x+h, u+k[2], v+l[2]);
        
        resultK = (1.0f/6.0f) *  (k[0]+ (2.0f*k[1]) + (2.0f*k[2]) + k[3]);
        resultL = (1.0f/6.0f) *  (l[0]+ (2.0f*l[1]) + (2.0f*l[2]) + l[3]);
        
        result.setX(x + h);
        result.setU(u + resultK);
        result.setV(v + resultL);
        
        return result;
    }
    
}
