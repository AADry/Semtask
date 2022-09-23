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
public class Trapeze extends QGon implements Serializable{

    public Trapeze(Point2D[] p) {
        super(p);
        n = 4;
    }
    @Override
    public double square(){
        double sq,semi,h;
        double[] j = new double[2];
        Segment s1 = new Segment(p[0],p[1]);
        Segment s2 = new Segment(p[2],p[3]);
        j[0] = p[0].x[0];
        j[1] = p[2].x[1];
        Point2D f = new Point2D(j);
        Segment s3 = new Segment(p[0],f);
        semi =(s1.length() + s2.length())/2;
        h = s3.length();
        sq = semi*h;
        return sq;  
    }
}
