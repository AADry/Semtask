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
public class Pyramid implements IFigure{
    protected Point3D p0;
    protected int n;
    protected Point3D[] p;

    public Pyramid(Point3D p0, Point3D[] p) {
        this.p0 = p0;
        this.p = p;
    }

    public Pyramid(Point3D[] p) {
        this.p = p;
    }

    public int getN() {
        return n;
    }

    public Point3D[] getP() {
        return p;
    }
    public Point3D[] getP(int i) {
        return p;
    }

    public void setP(Point3D[] p) {
        this.p = p;
    }

    public void setP(Point3D[] p, int i) {
        this.p = p;
        i = n;
    }
    public static double baseSquare(Point3D[] p){
        double S =0;
        Point3D a = p[0], b = p[1], c = p[2];
        for(int i=2;i<p.length;++i){
            if(i%2==0){
                c = p[i];
            }
            else{
                b = p[i];
            }
            S+=Point3D.cross_prod((Point3D) Point3D.sub(b,a),(Point3D) Point3D.sub(c,a)).abs()/2;
        }
        return S;
    }
    @Override
   /* public double square(){
        double sq = 0;
        Point2D[] point2darray = new Point2D[n];
        Point2D[] point2darray2 = new Point2D[3];
        for(int i = 0; i < n;i++){
            point2darray[i].x[0] = p[i].x[0];
            point2darray[i].x[1] = p[i].x[1];
            point2darray2[i].x[0] = p[i].x[0];
            point2darray2[i].x[1] = p[i].x[1];
            point2darray2[i].x[2] = p[i].x[2];
            TGon tgon = new TGon(point2darray2);
            sq += tgon.square();
        }
        NGon ngon = new NGon(point2darray);
        sq += ngon.square();
        return sq;
    }
   /* @Override
    public double volume(){
        double v,h = 1;
        Pyramid a = new Pyramid(p0,p);
        v = (a.square()*h)/3;
        return v;
    }*/
    public double volume(){
    double V=0;
        Point3D a = p[0], b = p[1], c = p[2];
        for(int i=2;i<p.length;++i){
            if(i%2==0){
                c = p[i];
            }
            else{
                b = p[i];
            }
            V+=Math.abs(Point3D.mix_prod((Point3D) Point3D.sub(a,this.p0),(Point3D) Point3D.sub(b,this.p0), (Point3D) Point3D.sub(c,this.p0))/6);
        }
        return V;}
    @Override
    public double square(){
        double S=0;
        for(int i=1;i<n;++i){
            Point3D a = Point3D.sub(this.p[i],this.p[i-1]);
            Point3D b = Point3D.sub(this.p0,this.p[i-1]);
            S += Point3D.cross_prod(a,b).abs()/2;

        }
        S+= baseSquare(this.p);
        return S;}

    @Override
    public String toString() {
        return "Pyramid{" + "p0=" + p0 + ", n=" + n + ", p=" + p + '}';
    }
    
}
