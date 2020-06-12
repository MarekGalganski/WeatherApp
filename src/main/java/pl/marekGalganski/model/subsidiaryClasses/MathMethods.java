package pl.marekGalganski.model.subsidiaryClasses;

public class MathMethods {
    public static boolean isBetween(double value, double minValue, double maxValue) {
        if (value >= minValue && value <= maxValue)
            return true;
        else
            return false;
    }
}
