import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

class Triangle {

    private List<Double> triangleMeasurements;
    private Set<Double> sidesAsSet;
    private Double theLongestSide;
    private Double sumOfAllSides;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        this.triangleMeasurements = DoubleStream.of(new double[] {side1, side2, side3}).boxed().collect(Collectors.toList());
        this.sidesAsSet = new HashSet<>(this.triangleMeasurements);
        this.theLongestSide = Collections.max(triangleMeasurements);
        this.sumOfAllSides = triangleMeasurements.stream().reduce(Double::sum).get();

        if(sidesAsSet.size() == 1 && new ArrayList<>(sidesAsSet).get(0) == 0){
            throw new TriangleException();
        }
        if(theLongestSide > sumOfAllSides-theLongestSide){
            throw new TriangleException();
        }
    }

    /**
     * Each side is of the same length
     * @return
     */
    boolean isEquilateral() {
        return sidesAsSet.size() == 1;
    }

    /**
     * Two sides of a triangle are equal
     * @return
     */
    boolean isIsosceles() {
        return sidesAsSet.size() == 2 || sidesAsSet.size() == 1;
    }

    /**
     * Each side is of different length
     * @return
     */
    boolean isScalene() {
        return sidesAsSet.size() == 3;
    }
}
