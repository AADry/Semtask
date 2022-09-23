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
public class NGon implements IShape,Serializable {
    protected int n;
    protected Point2D[] p;

    public NGon(Point2D[] p) {
        this.p = p;
        n = p.length;
    }
    public NGon(){
        this.n = 5;
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D();
        Point2D p3 = new Point2D();
        Point2D p4 = new Point2D();
        Point2D p5 = new Point2D();
        Point2D[] array = new Point2D[]{p1,p2,p3,p4,p5};
        this.p = array;
    }

    public int getN() {
        return n;
    }

    public Point2D[] getP() {
        return p;
    }
    public Point2D[] getP(int i) {
        return p;
        
    }

    public void setP(Point2D[] p) {
        this.p = p;
    }

    public void setN(Point2D[] p, int i) {
        if(i != p.length){
            try {
                throw new AnotherException("i doesnt match length of Point2D[] p array");
            } catch (AnotherException ex) {
                ex.printStackTrace();
            }
        }
       else n = i;
        this.p = p;
    }
    @Override
    public double square(){
        double s,rv,ro;
        int l= getN();
        Segment a = new Segment(p[0],p[Math.round(5/2)]);
        ro = a.length();
        rv =ro*Math.cos(180/5);
        s = (rv*Math.PI)/2;
        return s;
    }
    @Override
    public double length(){
       double l =0;
       for(int j = 0;j < p.length-1; j++){
       Segment a = new Segment(p[j+1],p[j]);
        l += a.length();
       }
       Segment b = new Segment(p[n-1],p[0]);
       l += b.length();
        return l;
    }
    @Override
    public NGon shift(Point2D a){
        Point2D[] j = new Point2D[n];
        for(int i = 0;i < n;i++){
            j[i].add(p[i],a);
        }
        NGon c = new NGon(j);
        return c;
    }
    @Override
    public NGon rot(double phi){
        Point2D[] j = new Point2D[n];
        for(int i = 0;i < n;i++){
            j[i].rot(p[i], phi);
        }
        NGon c = new NGon(j);
        return c;
    }
    @Override
    public NGon symAxis(int i){
        Point2D[] j = new Point2D[n];
        for(int k = 0;i < n;i++){
            j[i].symAxis(i);
        }
        NGon c = new NGon(j);
        return c;
    }
    @Override
    public boolean cross(IShape i){
        boolean cross = false;
        NGon ngon = new NGon(p);
        if(i instanceof Segment){
            cross = i.cross(ngon);
        }
        if(i instanceof Polyline){
            cross = i.cross(ngon);
        }
        if(i instanceof Circle){
            for(int j = 1;j < n;j++){
                Segment segment = new Segment(p[j-1],p[j]);
                if(segment.cross(i)){cross = true; return cross;}
            }
        }
        return cross;
    }

    @Override
    public String toString() {
        return "NGon{" + "n=" + n + ", p=" + p + '}';
    }
    
}
