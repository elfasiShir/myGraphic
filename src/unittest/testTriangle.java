//package unittest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
////import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
//import Geometrics.Plane;
//import Geometrics.Triangle;
//import Primitives.Point3D;
//import Primitives.Ray;
//import Primitives.Util;
//import Primitives.Vector;
//
//class testTriangle {
//
//    @Test
//    public void testGetNormal() {
//        // ============ Equivalence Partitions Tests ==============
//        // TC01: There is a simple single test here
//        Triangle pl = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
//        double sqrt3 = Math.sqrt(1d / 3);
//        assertEquals("Bad normal to trinagle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
//    }
//    @Test
//    public void testfindIntersectionsRay() {
//        Triangle tr = new Triangle(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
//        Plane pl = new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0));
//        Ray ray;
//        // ============ Equivalence Partitions Tests ==============
//        // TC01: Inside triangle
//        ray = new Ray(new Point3D(1, 1, 1), new Vector(-1, -1, -1));
//        assertEquals("Bad intersection", Util.listOf(new Point3D(1d / 3, 1d / 3, 1d / 3)), tr.findIntersections(ray));
//
//        // TC02: Against edge
//        ray = new Ray(new Point3D(0, 0, -1), new Vector(1, 1, 0));
//        assertEquals("Wrong intersection with plane", Util.listOf(new Point3D(1, 1, -1)), pl.findIntersections(ray));
//        assertNull("Bad intersection", tr.findIntersections(ray));
//
//        // TC03: Against vertex
//        ray = new Ray(new Point3D(0, 0, 2), new Vector(-1, -1, 0));
//        assertEquals("Wrong intersection with plane", Util.listOf(new Point3D(-0.5, -0.5, 2)), pl.findIntersections(ray));
//        assertNull("Bad intersection", tr.findIntersections(ray));
//
//        // =============== Boundary Values Tests ==================
//        // TC11: In vertex
//        ray = new Ray(new Point3D(-1, 0, 0), new Vector(1, 1, 0));
//        assertEquals("Wrong intersection with plane", Util.listOf(new Point3D(0, 1, 0)), pl.findIntersections(ray));
//        assertNull("Bad intersection", tr.findIntersections(ray));
//
//        // TC12: On edge
//        ray = new Ray(new Point3D(-1, -1, 0), new Vector(1, 1, 0));
//        assertEquals("Wrong intersection with plane", Util.listOf(new Point3D(0.5, 0.5, 0)), pl.findIntersections(ray));
//        assertNull("Bad intersection", tr.findIntersections(ray));
//
//        // TC13: On edge continuation
//        ray = new Ray(new Point3D(-2, 0, 0), new Vector(1, 1, 0));
//        assertEquals("Wrong intersection with plane", Util.listOf(new Point3D(-0.5, 1.5, 0)), pl.findIntersections(ray));
//        assertNull("Bad intersection", tr.findIntersections(ray));
//    }
//
//}