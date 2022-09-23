/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semtask;

import java.io.Serializable;


/**
 *
 * @author Admin
 */

public class Circle implements IShape,Serializable {
    protected double r;
    protected Point2D p;
    public Circle(Point2D p, double r) {
    this.r = r;
    this.p = p;
    }
    
    public Circle() {
    this.r = 1;
    double[] array = new double[]{0 , 0};
       Point2D s = new Point2D(array);
       this.p = s;
    }
    
    public double square() {
    return Math.PI * Math.pow(r, 2);
    }
    public double length() {
    return 2 * Math.PI * r;

    }

    public double getR() {
        return r;
    }

    public Point2D getP() {
        return p;
    }

    public void setR(double r) {
       if(this.r <= 0){ 
           try {
               throw new AnotherException("Trying to set incorrect Circle radius");
           } catch (AnotherException ex) {
               ex.printStackTrace();
           }
    } else this.r = r;
    }
    public void setP(Point2D p) {
        this.p = p;
    }
    @Override
    public Circle shift(Point2D a){
        double[] arr = new double[2];
        arr[0] = this.p.x[0] + a.x[0];
        arr[1] = this.p.x[1] + a.x[1];
        Point2D k = new Point2D(arr);
      Circle c = new Circle(k,this.r);
      return c;
    }
    @Override
    public Circle rot(double phi){
        r = r;
        p.rot(p,phi);
        Circle k = new Circle(p,r);
        return k;
    }
    @Override
    public Circle symAxis(int i){
        r = r;
        Point.symAxis(p,i);
        Circle c = new Circle(p,r);
        return c;
    }
    //public boolean cross(IShape){
        
   // }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + ", p=" + p.x[0]+ "," + p.x[1] + '}';
    }
    @Override
    public boolean cross(IShape i){
        boolean cross = true;
        Circle circle = new Circle(p,r);
        if(i instanceof Segment){
            cross = i.cross(circle);
            return cross;
        }
        if(i instanceof Polyline){
            cross = i.cross(circle);
            return cross;
        }
        if(i instanceof Circle){
           Segment segment = new Segment(p,((Circle) i).p);
           cross = ((r + ((Circle) i).r) >= segment.length()); return cross;
        }
        if(i instanceof QGon){
          cross = i.cross(circle);
        }
        return cross;
    }
    
}