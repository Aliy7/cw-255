import java.util.ArrayList;

public class Sphere {
    private final Vector centrePoint;
    private final double radius;

    private  Vector origin;
    private  Vector lineDirection;
    private  Vector centreSphere;
    private  Vector light;
    private  double sphereRadius;

    private ArrayList<Sphere> sphere;

    private  LightRay ray;
    public Sphere (Vector centrePoint, double radius){
        origin = new Vector(0, 0, 0);
        lineDirection = new Vector(0, 0, 1);
        centreSphere = new Vector(0, 0, 0);
        sphere = new ArrayList<>();

        this.radius = radius;
        this.centrePoint = centrePoint;
    }

    public Vector getCentre(){
          return centrePoint;
    }


    public double getRadius() {
        return radius;
    }



    public boolean intersects(LightRay ray) {
        Vector originToCenter = centrePoint.sub(ray.getOrigin());
        double v = originToCenter.dot(ray.getDirection());
        double discriminant = (radius * radius) - (originToCenter.dot(originToCenter) - v * v);
        return discriminant >= 0;
    }
}
