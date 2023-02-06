
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.lang.Math.*;
public class Vector {
    double x, y, z;
    public Vector() {

    }
    public Vector(double i, double j, double k) {
        x = i;
        y = j;
        z = k;
    }
    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }
    public void normalise() {
        double mag = magnitude();
        if (mag != 0) {
            x /= mag;
            y /= mag;
            z /= mag;
        }
    }
    public double dot(Vector a) {
        return x * a.x + y * a.y + z * a.z;
    }
    public Vector sub(Vector a) {
        return new Vector(x - a.x, y - a.y, z - a.z);
    }
    public Vector add(Vector a) {
        return new Vector(x + a.x, y + a.y, z + a.z);
    }
    public Vector mul(double d) {
        return new Vector(d * x, d * y, d * z);
    }
    public void print() {
        System.out.println("x=" + x + ", y=" + y + ", z=" + z);
    }
//    public void render(WritableImage image) {
//        int width = (int) image.getWidth();
//        int height = (int) image.getHeight();
//        PixelWriter imageWriter = image.getPixelWriter();
//
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                imageWriter.setColor(i, j, Color.BLACK);
//                for (Sphere sphere : sphere) {
//                    setOrigin(i, j);
//                    double col = paintSphere(sphere.getCentre(), lineDirection, origin, sphere.getRadius(), light);;
//                    if(col > 0){
//                        imageWriter.setColor(i, j, Color.color(col, col, col, 1.0));
//                    }
//
//                }
//            }
//        }
    }

