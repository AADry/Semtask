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
public class QGon extends NGon implements Serializable{
    @Override
    public double square(){
        double l1,l2,l3,l4,sum;
        Segment s2 = new Segment(p[0],p[1]);
        Segment s3 = new Segment(p[2],p[3]);
        double[] arrayax = new double[2];
        arrayax[0] = p[0].x[0];
                arrayax[1] = p[1].x[1];
        Point2D point2d = new Point2D(arrayax);
        Segment s1 = new Segment(p[0],point2d);
        l1 = s2.length();
        l2 = s3.length();
        l3 = s1.length();
        sum = l1*l2*l3;
        return sum;
    }

    public QGon(Point2D[] p) {
        super(p);
        n = 4;
    }
    public QGon(){
        this.n = 4;
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D();
        Point2D p3 = new Point2D();
        Point2D p4 = new Point2D();
        Point2D[] array = new Point2D[4];
        array[0]=p1;
        array[1]=p2;
        array[2]=p3;
        array[3]=p4;
        this.p = array;
    }
    
}
