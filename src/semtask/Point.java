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
public class Point {
    protected int dim;
    protected double[] x;
    
      public int getDim()
        {
            return dim;
        }
      public Point()
      {
          double[] array = new double[]{0};
          this.dim = 1;
          this.x = array;
      }
      public Point(int dim)
        {
          this.dim = dim;
          for(int i = 0;i < dim;i++)
          {
              x[i] = 0.0;
          }
          
        }
      
      public Point(int dim , double[] x)
        {
          this.dim = dim;
          this.x = x;
         }
      
      public double[] getX()
      {
          return x;
      }
      
      public double getX(int i)
      {
          return x[i];
      }
      
      void setX(double[] x)
      {  if(x.length != dim){
          try{
              throw new AnotherException("Trying to set wrong array for this dimension value ");
          } catch(AnotherException ex){
              ex.printStackTrace();
          }
      }   
          else this.x = x;
      }
      
      void setX(double[] x, int dim)
      {    if(x.length != this.dim){
          try {
              throw new AnotherException("Trying to set wrong dimension value for this double[] x array ");
          } catch (AnotherException ex) {
              ex.printStackTrace();
          }
      } else this.x = x;
          if(this.dim <= 0){
          try {
          throw new AnotherException("Trying to set incorrect dimension value");
          } catch (AnotherException ex) {
          ex.printStackTrace();
          }
             
      } else this.dim = dim;
      }
      double abs(){
        double a = 0;
        for(int i=0;i<this.dim;++i){
            a += this.x[i]*this.x[i];
        }
        return Math.sqrt(a);
    };
      
      public static Point add(Point a, Point b)
      {   int j = a.dim;
           double[] newpointx = new double[a.x.length]; 
          for(int i = 0;i < a.x.length;i++)
          {
             newpointx[i] = (a.x[i]+b.x[i]);
          }
          Point c = new Point(j, newpointx);
          return c;
      }
      public Point add(Point b)
      {
        for(int i = 0;i <= b.x.length;i++)
            {
            x[i] = x[i] + b.x[i];
            }
       Point c = new Point(dim, x);
        return c;
      }
      
      public Point sub(Point b)
      {
          for(int i = 0;i <= b.x.length;i++)
          {
            x[i] = x[i] - b.x[i];  
          }
          Point c = new Point(dim, x);
        return c;
      }
      

      
      public static Point sub(Point a, Point b)
      {     int j = a.dim;
            double[] subpointx = new double[a.x.length];
            for(int i = 0;i <= a.x.length;i++)
            {
                subpointx[i] = (a.x[i]-b.x[i]);
            }
            Point c = new Point(j, subpointx);
            return c;
          
      }
      public static Point mult(Point a,double[] r)
      {     int j = a.dim;
            double[] multpointx = new double[a.x.length];
            for(int i = 0;i < a.x.length;i++)
            {
                multpointx[i] = (a.x[i]*r[i]);
            }
            Point c = new Point(j, multpointx);
            return c;
          
      }
      public static Point mult(Point a,Point b)
      {     int j = a.dim;
            double[] subpointx = new double[a.x.length];
            for(int i = 0;i < a.x.length;i++)
            {
                subpointx[i] = (a.x[i]-b.x[i]);
            }
            Point c = new Point(j, subpointx);
            return c;
          
      }
      public static Point symAxis(Point a, int i)
      {     int j = a.dim;
            double[] symAxisx = new double[a.x.length];
             
            if (1 == i) { symAxisx[0] = a.x[0]; }
                    else {
                        (symAxisx[1]) = (-a.x[1]);
                         }
             
            Point c = new Point(j, symAxisx);
            return c;
          
      }
      Point symAxis(int i)
      {
          double[] symAxisx = new double[x.length];
          for(int j = 0;j <= dim;j++){
         
            if (j != i) { symAxisx[j] = x[j]; }
                    else {
                        (symAxisx[j]) = (-x[j]);
                         }
             }
            Point c = new Point(x.length,symAxisx);
            return c;
      }

    @Override
    public String toString() {
        return "Point{" + "dim=" + dim + ", x=" + x + '}';
    }
      
}
      