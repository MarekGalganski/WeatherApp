package pl.marekGalganski.model.subsidiaryClasses;

public class Formatter {

    public static Integer getRoundedNumber(double number) {
        return (int) Math.rint(number);
    }

    public static double getTwoDecimalPlacesNumber(double number) {
        return Math.round(number * 100) / 100;
    }

    public static double changeMPerStoKmPerH(double mPerS) {
            return getTwoDecimalPlacesNumber(mPerS * 3.6);
    }

    public static String firstLetterToUpper(String word) {
        char firstLetter = word.toUpperCase().charAt(0);
        String anotherLetters = word.substring(1).toLowerCase();

        return firstLetter + anotherLetters;
    }

    public static String stringWithoutLastChar(String word) {
        return word.substring(0, word.length() - 1);
    }
}
