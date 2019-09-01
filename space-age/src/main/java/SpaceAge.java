enum OrbitalPeriods {

    MERCURY(0.2408467),
    VENUS( 0.61519726),
    MARS(1.8808158),
    JUPITER(11.862615),
    SATURN(29.447498),
    URANUS(84.016846),
    NEPTUNE(164.79132);

    private double orbitalPeriod;

    OrbitalPeriods(double orbitalPeriod){
        this.orbitalPeriod = orbitalPeriod;
    }

    public double getOrbitalPeriod() {
        return this.orbitalPeriod;
    }
}

class SpaceAge {

    private double earthYearInSeconds = 31557600;
    private double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return this.seconds;
    }

    double onEarth() {
       return this.seconds/earthYearInSeconds;
    }

    double onMercury() {
        return calculateOrbitalPeriod(OrbitalPeriods.MERCURY);
    }

    double onVenus() {
        return calculateOrbitalPeriod(OrbitalPeriods.VENUS);
    }

    double onMars() {
        return calculateOrbitalPeriod(OrbitalPeriods.MARS);
    }

    double onJupiter() {
        return calculateOrbitalPeriod(OrbitalPeriods.JUPITER);
    }

    double onSaturn() {
        return calculateOrbitalPeriod(OrbitalPeriods.SATURN);
    }

    double onUranus() {
        return calculateOrbitalPeriod(OrbitalPeriods.URANUS);
    }

    double onNeptune() {
        return calculateOrbitalPeriod(OrbitalPeriods.NEPTUNE);
    }

    private double calculateOrbitalPeriod(OrbitalPeriods planetOrbitalPeriod){
        double yearInEarthSecondsOnAPlaner = earthYearInSeconds*planetOrbitalPeriod.getOrbitalPeriod();
        return this.seconds/yearInEarthSecondsOnAPlaner;
    }

}
