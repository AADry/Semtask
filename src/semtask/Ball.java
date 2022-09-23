/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semtask;

/**
 *
 * @author Admin
 */
public class Ball implements IFigure {
    protected Point3D p;
    protected double r;

    public Ball(Point3D p, double r) {
        this.p = p;
        this.r = r;
    }

    public Point3D getP() {
        return p;
    }

    public void setP(Point3D p) {
        this.p = p;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        if(this.r <= 0){ 
           try {
               throw new AnotherException("Trying to set incorrect Ball radius");
           } catch (AnotherException ex) {
               ex.printStackTrace();
           }} else
        this.r = r;
    }
    @Override
    public double square(){
        double sq;
        sq = 4*r*Math.PI;
        return sq;
    }
    @Override
    public double volume(){
        double sq;
        sq = (4*(Math.PI*r*r*r)/3);
        return sq;
    }

    @Override
    public String toString() {
        return "Ball{" + "p=" + p + ", r=" + r + '}';
    }
    
}
