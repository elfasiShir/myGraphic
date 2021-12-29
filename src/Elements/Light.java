package Elements;
import Primitives.Point3D;
import Primitives.Vector;

import java.awt.Color;

public abstract class Light {
    Color _intensity;

    public abstract Color getIntensity(Point3D p);
    public abstract Vector getL(Point3D p);

    public Color get_intensity() {
        return _intensity;
    }

    public void set_intensity(Color _intensity) {
        this._intensity = _intensity;
    }

    public static Color colorMultiplyDouble(Color c, double scale) {
        if (0 < scale)
            return new Color(
                    (int) (Math.min(c.getRed() * scale, 255)),
                    (int) (Math.min(c.getGreen() * scale, 255)),
                    (int) (Math.min(c.getBlue() * scale, 255))
            );
        else
            return new Color(0, 0, 0);
    }
    public static Color colorPlusColor(Color c1, Color c2) {
        return new Color(
                Math.min(c1.getRed() + c2.getRed(), 255),
                Math.min(c1.getGreen() + c2.getGreen(), 255),
                Math.min(c1.getBlue() + c2.getBlue(), 255)
        );
    }
}
