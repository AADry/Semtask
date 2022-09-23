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
public class Rectangle extends QGon implements Serializable {

    public Rectangle(Point2D[] p) {
        super(p);
    }
    public Rectangle(){
        this.n = 4;
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D();
        Point2D p3 = new Point2D();
        Point2D p4 = new Point2D();
        Point2D[] array = new Point2D[]{p1,p2,p3,p4};
        this.p = array;
    }
    @Override
    public double square(){
    double sum;
       Segment s1 = new Segment(p[0],p[1]);
       Segment s2 = new Segment(p[1],p[2]);
       Segment s3 = new Segment(p[2],p[3]);
       Segment s4 = new Segment(p[3],p[0]);
       sum = s1.length()*s2.length();
       return sum;
    }

    @Override
    public String toString() {
        return "Rectangle{"+p[0].toString()+","+ p[1].toString()+","+ p[2].toString()+","+ p[3].toString()+ '}';
    }
    
    
}
