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
public class Point2D extends Point implements Serializable {
      Point2D()
      {
       double[] array = new double[]{0 , 0};
       this.dim = 2;
       this.x = array;
        }
      Point2D(double[] x)
      {
          super(2, x);
      }
      Point2D(int m)
      {   
          super(m);
      }
      
      Point2D(int p, double[] x)
      {
          super(p,x);
      }
      
      public Point2D add(Point2D b){
          Point2D c = new Point2D(2);
         c.x[0] =(x[0] + b.x[0]);
         c.x[1] =(x[1] + b.x[1]);
         return c;
      }
     public static Point2D rot(Point2D p,double phi)
      { 
         p.x[0] = (p.x[0]*Math.cos(phi) - p.x[1]*Math.sin(phi));
         p.x[1] = (p.x[0]*Math.sin(phi) - p.x[1]*Math.cos(phi));
         Point2D c = new Point2D(p.dim, p.x);
         
         return c;
      }
     public Point2D rot(double phi)
      { 
         x[0] = (x[0]*Math.cos(phi) - x[1]*Math.sin(phi));
         x[1] = (x[0]*Math.sin(phi) - x[1]*Math.cos(phi));
         Point2D c = new Point2D(dim, x);
         
         return c;
      }

    @Override
    public String toString() {
        return "Point{" + "dim=" + dim + ", x=" + x[0]+","+ x[1] + '}';
    }

     
}
