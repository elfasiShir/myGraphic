package unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geometrics.Plane;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
//import geometries.*;
import Primitives.*;
import Geometrics.*;
//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class testPlane{
    @Test
    public void testGetNormalPoint3D() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Plane pl = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Bad normal to plane",new Vector(sqrt3, sqrt3, sqrt3) , pl.getNormal(new Point3D(0, 0, 1)));
    }

    @Test
    public void testFindIntersectionsRay() {
        Plane pl = new Plane(new Point3D(0, 0, 1), new Vector(1, 1, 1));

        // ============ Equivalence Partitions Tests ==============
        // TC01: Ray into plane
        List<Point3D> list = new ArrayList<>();
        list.add(new Point3D(1, 0, 0));
        assertEquals("Bad plane intersection", list,
                pl.findIntersections(new Ray(new Point3D(0.5, 0, 0), new Vector(1, 0, 0))));

        // TC02: Ray out of plane
        assertNull("Must not be plane intersection",
                pl.findIntersections(new Ray(new Point3D(2, 0, 0), new Vector(1, 0, 0))));

        // =============== Boundary Values Tests ==================
        // TC11: Ray parallel to plane
        assertNull("Must not be plane intersection",
                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(0, 1, -1))));

        // TC12: Ray in plane
        assertNull("Must not be plane intersection",
                pl.findIntersections(new Ray(new Point3D(0, 0.5, .5), new Vector(0, 1, -1))));


        // TC13: Orthogonal ray into plane
        List<Point3D> list2 = new ArrayList<>();
        list2.add( new Point3D(1d / 3, 1d / 3, 1d / 3));
        assertEquals("Bad plane intersection", list2,
                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(-1, -1, -1))));

        // TC14: Orthogonal ray out of plane
        assertNull("Must not be plane intersection",
                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(1, 1, 1))));

        // TC15: Orthogonal ray out of plane
        assertNull("Must not be plane intersection",
                pl.findIntersections(new Ray(new Point3D(1, 1, 1), new Vector(1, 1, 1))));

        // TC16: Orthogonal ray from plane
        assertNull("Must not be plane intersection",
                pl.findIntersections(new Ray(new Point3D(0, 0.5, 0.5), new Vector(1, 1, 1))));

        // TC17: Ray from plane
        assertNull("Must not be plane intersection",
                pl.findIntersections(new Ray(new Point3D(0, 0.5, 0.5), new Vector(1, 1, 0))));

        // TC18: Ray from plane's Q point
        assertNull("Must not be plane intersection",
                pl.findIntersections(new Ray(new Point3D(0, 0, 1), new Vector(1, 1, 0))));

    }

}