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
public class Result {
    
    private float x,u,v;

    public Result() {
    }

    public Result(float x, float u, float v) {
        this.u = u;
        this.v = v;
        this.x = x;
    }

    
    // GETTERS
    
    public float getU() {
        return u;
    }

    public float getV() {
        return v;
    }

    public float getX() {
        return x;
    }
    
    // SETTERS

    public void setU(float u) {
        this.u = u;
    }

    public void setV(float v) {
        this.v = v;
    }

    public void setX(float x) {
        this.x = x;
    }
    
    
    
}
