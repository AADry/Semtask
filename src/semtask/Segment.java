/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semtask;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class Segment extends OpenFigure implements Serializable {
   Point2D start;
   Point2D finish;
   public Segment(Point2D s, Point2D f){
       this.start = s;
       this.finish = f;
   }
   public Segment(){
       double[] array = new double[]{0 , 0};
       Point2D s = new Point2D(array);
       Point2D f = new Point2D(array);
       this.start = s;
       this.finish = f;
   }

    public Point2D getStart() {
        return start;
    }

    public Point2D getFinish() {
        return finish;
    }

    public void setStart(Point2D start) {
        this.start = start;
    }

    public void setFinish(Point2D finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "Segment{" + "start=" + start.toString()+","+start.toString() + ", finish=" + finish.toString()+","+finish.toString() + '}';
    }
    @Override
   public double length(){
       double l;
      l = Math.sqrt(Math.pow(finish.x[0] - start.x[0], 2) + Math.pow(finish.x[1] - start.x[1], 2));;
      return l;
   }
   @Override
   public Segment shift(Point2D a){
       double[] j = new double[2];
       double[] k = new double[2];
       j[0] = (start.x[0] + a.x[0]);
       j[1] = (start.x[1] + a.x[1]);
       k[0] = (finish.x[0] + a.x[0]);
       k[1] = (finish.x[1] + a.x[1]);
       Point2D p = new Point2D(j);
       Point2D q = new Point2D(k);
       Segment b = new Segment(p , q);
       return b;
       }
  @Override
  public Segment rot(double phi)
      {
           start.rot(start,phi);
          finish.rot(finish,phi);
          Segment b = new Segment(start,finish);
         return b;
      }
  @Override
    public Segment symAxis(int i)
    {       double[] j = new double[2];
            double[] k = new double [2];
            j[0] = start.x[0];
            j[1] = start.x[1];
            k[0] = finish.x[0];
            k[1] = finish.x[1];
        if(i == 0)
        {
        j[1] = (start.x[1] * -1);
        k[1] = (finish.x[1] * -1);
        }
        if(i == 1)
        { j[0] = (start.x[0] * -1);
        k[0] = (finish.x[0] * -1);
        }
        Point2D p = new Point2D(j);
        Point2D q = new Point2D(k);
        Segment c = new Segment(p, q);
        return c;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Segment other = (Segment) obj;
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.finish, other.finish)) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean cross(IShape i){
        boolean crossed = false;
        boolean segmentcrossed = false;
        double n = 0;
        
        if(i instanceof Segment){
          if(finish.equals(i) || (start.equals(i)) ){
           crossed = true; return crossed;
          }
        if((finish.x[1]-start.x[1]) != 0){ 
            double q = (finish.x[0]-start.x[0]) / (start.x[1]-finish.x[1]);
            double sn = (((Segment) i).start.x[0] - ((Segment) i).finish.x[0]) + (((Segment) i).start.x[1] - ((Segment) i).finish.x[1]) * q; if(sn == 0) { crossed = false;}
        double fn = (((Segment) i).start.x[0] - start.x[0]) + (((Segment) i).start.x[1] - start.x[1]) * q;
        if(sn != 0){
          n = fn/sn;  
              }
        } else{
            if((((Segment) i).start.x[1])-(((Segment) i).finish.x[1]) == 0){
                crossed = false;
        }
        }
        crossed = true; return crossed;
       }
        
       if(i instanceof Polyline){
           
           for(int j =1;j< (((Polyline) i).p.length);j++){
               Segment segment = new Segment(((Polyline) i).p[j-1],((Polyline) i).p[j]);
               if(finish.equals(segment.finish) || (start.equals(segment.start)) ){
           crossed = true; return crossed;
          }
        if((finish.x[1]-start.x[1]) != 0){ 
            double q = (finish.x[0]-start.x[0]) / (start.x[1]-finish.x[1]);
            double sn = (segment.start.x[0]) - (segment.finish.x[0]) + (segment.start.x[1] - segment.finish.x[1]) * q; if(sn == 0) { crossed = false; }
        double fn = (segment.start.x[0] - start.x[0]) + (segment.start.x[1] - start.x[1]) * q;
        if(sn != 0){
          n = fn/sn;  
              }
        } else{
            if((segment.start.x[1])-(segment.finish.x[1]) == 0){
                crossed = false; 
        }
        }
        
           }crossed = true; return crossed;
       }
        if(i instanceof Circle){
           double x1 = start.x[0];
           double x2 = start.x[1];
           double y1 = finish.x[0];
           double y2 = finish.x[1];
            
            
            
            double dx = x2 - x1;
            double dy = y2 - y1;
            
            double a = dx*dx + dy*dy;
            double b = 2.*(x1*dx + y1*dy);
            double c = x1*x1 + y1*y1 - ((Circle) i).r*((Circle) i).r;
            
            if (-b < 0)
            {
             return (c < 0);
            }
            if (-b < (2.*a))
            {
                return ((4.*a*c - b*b) < 0);
            }
 
       return (a+b+c < 0);
        }
        if(i instanceof NGon){
            for(int j = 1;j < ((NGon)i).n;j++){
               Segment segment = new Segment(((NGon) i).p[j-1],((NGon) i).p[j]);
               if(finish.equals(segment.finish) || (start.equals(segment.start)) ){
           segmentcrossed = true; 
          }
        if((finish.x[1]-start.x[1]) != 0){ 
            double q = (finish.x[0]-start.x[0]) / (start.x[1]-finish.x[1]);
            double sn = (segment.start.x[0]) - (segment.finish.x[0]) + (segment.start.x[1] - segment.finish.x[1]) * q; if(sn == 0) { segmentcrossed = false; }
        double fn = (segment.start.x[0] - start.x[0]) + (segment.start.x[1] - start.x[1]) * q;
        if(sn != 0){
          n = fn/sn;  
              }
        } else{
            if((segment.start.x[1])-(segment.finish.x[1]) == 0){
                segmentcrossed = false; 
        }
        }
            }
            Segment segment = new Segment(((NGon) i).p[((NGon) i).n-1],((NGon) i).p[0]);
            if(finish.equals(segment.finish) || (start.equals(segment.start)) ){
           segmentcrossed = true; 
          }
        if((finish.x[1]-start.x[1]) != 0){ 
            double q = (finish.x[0]-start.x[0]) / (start.x[1]-finish.x[1]);
            double sn = (segment.start.x[0]) - (segment.finish.x[0]) + (segment.start.x[1] - segment.finish.x[1]) * q; if(sn == 0) { segmentcrossed = false; }
        double fn = (segment.start.x[0] - start.x[0]) + (segment.start.x[1] - start.x[1]) * q;
        if(sn != 0){
          n = fn/sn;  
              }
        } else{
            if((segment.start.x[1])-(segment.finish.x[1]) == 0){
                segmentcrossed = false;
               crossed = segmentcrossed;
            }}
        }
        return crossed;
    }
}
