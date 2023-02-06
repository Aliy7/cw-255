import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class RayTracer {
    private final Vector origin;
    private final Vector lineDirection;
    private final Vector centreSphere;
    private final Vector light;
    private final double sphereRadius;

     private ArrayList<Sphere> sphere = new ArrayList<>();

    public RayTracer() {
        origin = new Vector(0, 0, 0);
        lineDirection = new Vector(0, 0, 1);
        centreSphere = new Vector(0, 0, 0);
        this.sphere = sphere;
        sphereRadius = 100;
        light = new Vector(-250, 250, -200);
    }

    public void addSphere(){
        sphere.add(new Sphere(new Vector(0,0,-200),50));
        sphere.add(new Sphere(new Vector(200, -100, -200), 50));
        sphere.add(new Sphere(new Vector(-50, 100, -200), 50));

//       sphere.add(new Sphere (new Vector (0,0,0), 50));
    }
    public void render(WritableImage image) {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        PixelWriter imageWriter = image.getPixelWriter();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                imageWriter.setColor(i, j, Color.BLACK);
                for (Sphere sphere : sphere) {
                    setOrigin(i, j);
                    double col = paintSphere(sphere.getCentre(), lineDirection, origin, sphere.getRadius(), light);;
                    if(col > 0){
                        imageWriter.setColor(i, j, Color.color(col, col, col, 1.0));
                    }
                }
            }
        }
    }
    private void setOrigin(int i, int j) {
        origin.x = i - 250;
        origin.y = j - 250;
        origin.z = -200;
    }

    private double paintSphere(Vector centreSphere, Vector lineDirection, Vector origin, double radius, Vector light) {
        Vector v = origin.sub(centreSphere);
        double a = lineDirection.dot(lineDirection);
        double b = 2 * v.dot(lineDirection);
        double c = v.dot(v) - radius * radius;
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return 0.0;
        }

        double t = (-b - Math.sqrt(discriminant)) / 2 * a;
        Vector linePosition = origin.add(lineDirection.mul(t));

        Vector lv = light.sub(linePosition);
        lv.normalise();

        Vector n = linePosition.sub(centreSphere);
        n.normalise();

        double dp = lv.dot(n);
        if (dp < 0) return 0;
        else return dp;
    }
}



