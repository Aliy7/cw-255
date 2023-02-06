public class LightRay {

        private Vector origin;
        private Vector direction;

        public LightRay(Vector origin, Vector direction) {
            origin = new Vector(0, 0, 0);
            direction = new Vector(0, 0, 1);
        }

        public Vector getPoint(double t) {
            return origin.add(direction.mul(t));
        }

        public Vector getOrigin() {
            return origin;
        }

        public Vector getDirection() {
            return direction;
        }
    }


