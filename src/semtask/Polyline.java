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
import java.io.Serializable;
public class Polyline extends OpenFigure implements Serializable {
    protected int n;
   protected Point2D[] p;

    public Polyline(Point2D[] p) {
        this.p = p;
        n = this.p.length;
    }
    public Polyline() {
        Point2D[] array = new Point2D[2];
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D();
        array[0] = p1;
        array[1] = p2;
        this.p = array;
        n = 2;
    }
    

    public Point2D[] getP() {
        return p;
    }
    public Point2D[] getP(int i) {
        return p;
    }

    public int getN() {
        return n;
    }

    public void setP(Point2D[] p) {
        this.p = p;
    }
    public void setP(Point2D[] p, int i) {
        this.p = p;
        i = n;
    }
    @Override
    public double length()
    { double l = 0;
        for(int i = 0;i < n-1;i++){
           l += (Math.sqrt(Math.pow(p[i+1].x[0] - p[i].x[0], 2) + Math.pow(p[i+1].x[1] - p[i].x[1], 2) ));
        }
        return l;
    }
    @Override
    public Polyline shift(Point2D a)
    {
       Point2D[] j = new Point2D[this.n];
       
       for(int i = 0;i <= this.n; i++){
       p[i].x[0] = ( p[i].x[0] + a.x[0]);
       p[i].x[1] = (p[i].x[1] + a.x[1]);
       }
       n = n;
       Polyline z = new Polyline(j);
       return z;
       
    }
    @Override
    public Polyline rot(double phi){
        Point2D[] j = new Point2D[n];
        for(int i = 0;i < n;i++){
            j[i] = p[i].rot(phi); 
        }
        Polyline polyline = new Polyline(j);
        return polyline;
        
    }
    @Override
    public boolean cross(IShape i){
        boolean cross = false;
        for(int j = 1;j< n;j++){
            Segment part = new Segment(p[j-1],p[j]);
           if(part.cross(i)){return part.cross(i);}
        }
        return cross;
    }
    @Override
    public Polyline symAxis(int i){
        Polyline polyline = new Polyline(p);
        for(int j = 1;j < n;j++){
            Segment segment = new Segment(p[j-1],p[j]);
           polyline.p[j-1] = segment.symAxis(i).start;
           polyline.p[j] = segment.symAxis(i).finish;
        }return polyline;
    }

    @Override
    public String toString() {
        return "Polyline{" + "Точек=" + n + ", Точки=" + p + '}';
    }
    
}