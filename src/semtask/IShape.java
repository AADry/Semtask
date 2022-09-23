package semtask;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public interface IShape{
    public double square();
    public double length();
    public IShape shift(Point2D a);
    public IShape rot(double phi);
    public IShape symAxis(int i);
    public boolean cross(IShape a);
    
    
}
