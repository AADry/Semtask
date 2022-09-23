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
public class Point3D extends Point implements Serializable{
    Point3D(){
        super(3);
    }
    
      Point3D(double[] x)
      {
          super(3, x);
      }
      Point3D(int dim)
      {   
          super(dim);
      }
      
      Point3D(int dim, double[] x)
      {
          super(dim,x);
      }
    
  public static Point3D cross_prod(Point3D p1, Point3D p2)
        {
            Point3D a = new Point3D();
            for(int i = 0;i < 3;i++){
              a.x[i] = (p1.x[i] * p2.x[i]);
                
            }
            return a;
        }
  public Point3D cross_prod(Point3D p){
        double x = this.getX(1) * p.getX(2) - this.getX(2)*p.getX(1);
        double y = this.getX(0) * p.getX(2) - this.getX(2)*p.getX(0);
        double z = this.getX(0) * p.getX(1) - this.getX(1)*p.getX(0);
        double res[] = {x,-y,z};
        return new Point3D(res);}
  public static double mix_prod(Point3D p1, Point3D p2,Point3D p3){
      double mix = 0;
         mix += (p1.x[0]*p2.x[1]*p3.x[2])+(-1*p1.x[2]*p2.x[1]*p3.x[0]);
         mix += (p1.x[1]*p2.x[2]*p3.x[0])+(-1*p1.x[0]*p2.x[2]*p3.x[1]);
         mix += (p1.x[2]*p2.x[0]*p3.x[1])+(-1*p1.x[1]*p2.x[0]*p3.x[2]);
      return mix;
  }
  public double mix_prod(Point3D p1, Point3D p2){
      double mix = 0;
         mix += (p1.x[0]*p2.x[1]*x[2])+(-1*p1.x[2]*p2.x[1]*x[0]);
         mix += (p1.x[1]*p2.x[2]*x[0])+(-1*p1.x[0]*p2.x[2]*x[1]);
         mix += (p1.x[2]*p2.x[0]*x[1])+(-1*p1.x[1]*p2.x[0]*x[2]);
      return mix;
  }
  static public Point3D sub(Point3D a, Point3D b){
        Point c = new Point(a.dim);
        for(int i=0;i<a.dim;++i){
            c.x[i] = a.x[i] - b.x[i];
        }
        Point3D res = new Point3D(c.x);
        return res;}
  @Override
    public Point sub(Point a){
        super.sub(a);
        Point2D res = new Point2D(this.x);
        return res;}
}
