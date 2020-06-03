package pl.marekGalganski.model.subsidiaryClasses;

public class Formatter {

    public static Integer getRoundedNumber(double number) {
        return (int) Math.rint(number);
    }

    public static double getTwoDecimalPlacesNumber(double number) {
        return Math.round(number * 100) / 100;
    }

    public static double changeMPerStoKmPerH(double mPerS) {
        if(mPerS >= 0) {
            return getTwoDecimalPlacesNumber(mPerS * 3.6);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
