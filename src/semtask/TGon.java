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
public class TGon extends NGon implements Serializable{

    public TGon(Point2D[] p) {
        super(p);
        n = 3;
        
    }
    public TGon(){
        this.n = 3;
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D();
        Point2D p3 = new Point2D();
        Point2D[] array = new Point2D[]{p1,p2,p3};
        this.p = array;
    }
    @Override
    public double square(){
        double l1,l2,l3,sum,semi;
        Segment s1 = new Segment(p[1],p[0]);
        Segment s2 = new Segment(p[2],p[1]);
        Segment s3 = new Segment(p[2],p[0]);
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        semi = (l1+l2+l3)/2;
        sum = Math.sqrt(semi*(semi-l1)*(semi-l2)*(semi-l3));
        return sum;
    }
    @Override
    public double length(){
        double l1,l2,l3,sum,semi;
        Segment s1 = new Segment(p[0],p[1]);
        Segment s2 = new Segment(p[1],p[2]);
        Segment s3 = new Segment(p[2],p[0]);
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        return l1+l2+l3;
        
    }
}
