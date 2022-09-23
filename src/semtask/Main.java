
package semtask;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
        
       

public class Main {

    
   /* public static void main(String[] args) {
        double sqsum = 0;
        double lengthsum = 0;
        double sqmedium = 0;
        Scanner in = new Scanner(System.in);
        List<IShape> list = new ArrayList<>();                         //создание первой коллекции с фигурами(параметры каждой фигуры с клавиатуры) 
        System.out.print("Введите количество фигур :");
        int number = in.nextInt();
        in.nextLine();
        String[] type = new String[number];
        for(int m = 0;m < number;m++){
        type[m] = in.nextLine();}
        for(int m = 0;m < number;m++){
        if ("Circle".equals(type[m])){
            System.out.print("Введите параметры круга(радиус, координаты точки:)");
            double radius = in.nextDouble();
            double[] rad = new double[2];
            rad[0] = in.nextDouble();
            rad[1] = in.nextDouble();
            Point2D radiuspoint = new Point2D(rad);
            Circle circle = new Circle(radiuspoint,radius);
            list.add(circle);continue;
        }
        if ("Segment".equals(type[m])){
            System.out.print("Введите параметры отрезка : точка начала,точка конца:");
            double[] array1 = new double[2];
            double[] array2 = new double[2];
            array1[0] = in.nextDouble();
            array1[1] = in.nextDouble();
            Point2D point1 = new Point2D(2, array1);
            array2[0] = in.nextDouble();
            array2[1] = in.nextDouble();
            Point2D point2 = new Point2D(2, array2);
            Segment segment = new Segment(point1,point2);
            list.add(segment);continue;
        }
        if("Polyline".equals(type[m])){
            System.out.print("Введите параметры ломаной кривой(количество точек, точки) :");
            int n = in.nextInt();
            in.nextLine();   
            Point2D[] points2d = new Point2D[n];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point2d = new Point2D(array);
            points2d[j] = point2d;
            }
            Polyline polyline = new Polyline(points2d);
            list.add(polyline);continue;
            
        }
        if("NGon".equals(type[m])){
            System.out.print("Введите параметры n-угольника(количество точек, точки):");
            int n = in.nextInt();
            in.nextLine();
            Point2D[] points2d = new Point2D[n];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point2d = new Point2D(array);
            points2d[j] = point2d;
            }
            NGon ngon = new NGon(points2d);
            list.add(ngon);continue;
        }
        if("QGon".equals(type[m])){
            System.out.print("Введите параметры четырёхугольника точки:");
            int n = 4;
            Point2D[] points2d1 = new Point2D[n];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point21 = new Point2D(array);
            points2d1[j] = point21;}
            QGon qgon = new QGon(points2d1);
            list.add(qgon);continue;}
        if("Trigon".equals(type[m])){
            System.out.print("Введите параметры треугольника(точки):");
            int n = 3;
            Point2D[] points2d = new Point2D[n];
            for(int i = 0; i<n; i++){
                double[] array = new double[2];
                array[0] = in.nextDouble();
                array[1] = in.nextDouble();
                Point2D point2d = new Point2D(array);
                points2d[i] = point2d;
                }
            TGon trigon = new TGon(points2d); list.add(trigon);continue;
        }
        if("Rectangle".equals(type[m])){
            System.out.print("Введите параметры прямоугольник(точки):");
            int n = 4;
            Point2D[] points2d = new Point2D[4];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point23 = new Point2D(array);
            points2d[j] = point23;}
            Rectangle rectangle = new Rectangle(points2d); list.add(rectangle);continue;
        }
        if("Trapeze".equals(type[m])){
            System.out.print("Введите параметры трапеции(точки)(по одной точке):");
            int n = 4;
            Point2D[] points2d = new Point2D[n];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point23 = new Point2D(array);
            points2d[j] = point23;}
            Trapeze trapeze = new Trapeze(points2d); list.add(trapeze);continue;
        }
        }
            for(IShape IShape : list){
                sqsum += IShape.square();
                lengthsum += IShape.length();
                System.out.println(IShape.square());
                System.out.println(IShape.length());
                
            }
                sqmedium = sqsum/number;
            System.out.println("Суммарная площадь:"+sqsum);
            System.out.println("Суммарная длина:"+lengthsum);
            System.out.println("Средняя площадь на фигуру:"+sqmedium);
        
    List<IShape> list2 = new ArrayList<>();         //создание второй коллекции с фигурами(параметры каждой фигуры с клавиатуры)
        String[] type2 = new String[number];
        System.arraycopy(type, 0, type2, 0, number);
        for(int m = 0;m < number;m++){
        if ("Circle".equals(type[m])){
            System.out.print("Введите параметры круга(радиус, координаты точки:)");
            double radius = in.nextDouble();
            double[] rad = new double[2];
            rad[0] = in.nextDouble();
            rad[1] = in.nextDouble();
            Point2D radiuspoint = new Point2D(rad);
            Circle circle2 = new Circle(radiuspoint,radius);
            list2.add(circle2);System.out.println(list2.get(m).cross(list.get(m)));continue;
        }
        if ("Segment".equals(type[m])){
            System.out.print("Введите параметры отрезка : точка начала,точка конца:");
            double[] array1 = new double[2];
            double[] array2 = new double[2];
            array1[0] = in.nextDouble();
            array1[1] = in.nextDouble();
            Point2D point1 = new Point2D(2, array1);
            array2[0] = in.nextDouble();
            array2[1] = in.nextDouble();
            Point2D point2 = new Point2D(2, array2);
            Segment segment2 = new Segment(point1,point2);
            list2.add(segment2);System.out.println(list2.get(m).cross(list.get(m)));continue;
        }
        if("Polyline".equals(type[m])){
            System.out.print("Введите параметры ломаной кривой(количество точек, точки) :");
            int n = in.nextInt();
            in.nextLine();   
            Point2D[] points2d = new Point2D[n];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point2d = new Point2D(array);
            points2d[j] = point2d;
            }
            Polyline polyline2 = new Polyline(points2d);
            list2.add(polyline2);continue;
            
        }
        if("NGon".equals(type[m])){
            System.out.print("Введите параметры n-угольника(количество точек, точки):");
            int n = in.nextInt();
            in.nextLine();
            Point2D[] points2d = new Point2D[n];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point2d = new Point2D(array);
            points2d[j] = point2d;
            }
            NGon ngon2 = new NGon(points2d);
            list2.add(ngon2);continue;
        }
        if("QGon".equals(type[m])){
            System.out.print("Введите параметры четырёхугольника точки:");
            int n = 4;
            Point2D[] points2d = new Point2D[n];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point2d = new Point2D(array);
            points2d[j] = point2d;}
            QGon qgon2 = new QGon(points2d);
            list2.add(qgon2);continue;
        }
        if("Trigon".equals(type[m])){
            System.out.print("Введите параметры треугольника(точки):");
            int n = 3;
            Point2D[] points2d = new Point2D[n];
            for(int i = 0; i<n; i++){
                double[] array = new double[2];
                array[0] = in.nextDouble();
                array[1] = in.nextDouble();
                Point2D point2d = new Point2D(array);
                points2d[i] = point2d;
                }
            TGon trigon2 = new TGon(points2d); list2.add(trigon2);continue;
        }
        if("Rectangle".equals(type[m])){
            System.out.print("Введите параметры прямоугольник(точки):");
            int n = 4;
            Point2D[] points2d = new Point2D[4];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point2d = new Point2D(array);
            points2d[j] = point2d;}
            Rectangle rectangle2 = new Rectangle(points2d); list2.add(rectangle2);continue;
        }
        if("Trapeze".equals(type[m])){
            System.out.print("Введите параметры трапеции(точки)(по одной точке):");
            int n = 4;
            Point2D[] points2d = new Point2D[n];
            for(int j = 0;j < n;j++){
            double[] array = new double[2];
            array[0] = in.nextDouble();
            array[1] = in.nextDouble();
            Point2D point2d = new Point2D(array);
            points2d[j] = point2d;}
            Trapeze trapeze2 = new Trapeze(points2d); list.add(trapeze2);continue;
        }
        }
        
        for(int i = 0;i< list.size();i++){
            System.out.println(list2.get(i).cross(list.get(i)));    //сравнение фигур из первой и второй коллекции
        }
        
        for(int j = 0; j < number;j++){
            System.out.println("Введите угол");
            double phi;
            phi = (in.nextDouble()*Math.PI)/180;
            list2.set(j, list2.get(j).rot(phi));
            System.out.println(list.get(j).cross(list2.get(j))+"");
    
            Point2D point2dnew = new Point2D(2,somearr);
            list2.set(j, list2.get(j).shift(point2dnew));
            System.out.println(list.get(j).cross(list2.get(j))+"");
            System.out.println("Введите ось симметрии");
            int p = in.nextInt();
            list2.set(j, list2.get(j).symAxis(p));
            System.out.println(list.get(j).cross(list2.get(j))+"");
        }       List<IFigure> list3 = new ArrayList<>(); 
            System.out.print("Введите количество фигур :");
        
       int number3 = in.nextInt();
       in.nextLine();
        String[] type3 = new String[number3];
        for(int m = 0;m < number3;m++){
        type3[m] = in.nextLine();}
        for(int m = 0;m < number3;m++){
             if("Ball".equals(type3[m])){
                 System.out.print("Введите параметры шара(радиус, координаты точки:)");
            double radius = in.nextDouble();
            double[] rad = new double[3];
            rad[0] = in.nextDouble();
            rad[1] = in.nextDouble();
            rad[2] = in.nextDouble();
            Point3D radiuspoint = new Point3D(rad);
            Ball ball = new Ball(radiuspoint,radius); list3.add(ball);
             }
           
             if("Parallelepiped".equals(type3[m])){
                 System.out.print("Введите параметры параллепипеда(координаты точек):");
                 Point3D[] pipedpoints1 = new Point3D[4];
                 Point3D[] pipedpoints2 = new Point3D[4];
                 double[] arr = new double[3];
                 for(int cv = 0;cv < 4;cv++){
                     arr[0] = in.nextDouble();
                     arr[1] =in.nextDouble();
                     arr[2] =in.nextDouble();
                     Point3D pipedpoint1 = new Point3D(arr);
                     pipedpoints1[cv] = pipedpoint1;
                 }
                 for(int cv = 0;cv < 4;cv++){
                     arr[0] = in.nextDouble();
                     arr[1] =in.nextDouble();
                     arr[2] =in.nextDouble();
                     Point3D pipedpoint2 = new Point3D(arr);
                     pipedpoints2[cv] = pipedpoint2;
                 }
                 Parallelepiped piped = new Parallelepiped(pipedpoints1,pipedpoints2);list3.add(piped);
             }
        }
        double sumvolume = 0; double sqsumvol = 0; double mediumvol = 0;
         for(IFigure IFigure : list3){
                sumvolume += IFigure.volume();
                sqsumvol += IFigure.square();
                
            }
                System.out.println("Общий объем:"+sumvolume);
                System.out.println("Общая площадь:"+sqsumvol);
                System.out.println("Средний объем:"+sumvolume/number3);
                System.out.println("Средняя площадь:"+sqsumvol/number3);
}} */
public static void main(String[] args){
    MainFrame mainframe = new MainFrame();
    FlowLayout experimentLayout = new FlowLayout();
    mainframe.setLayout(experimentLayout);
    mainframe.setVisible(true);
}
}
    
