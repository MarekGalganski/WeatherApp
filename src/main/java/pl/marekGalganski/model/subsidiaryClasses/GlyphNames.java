package pl.marekGalganski.model.subsidiaryClasses;

public class GlyphNames {

    public static String getGlyphName(String iconCode) {
        switch (iconCode) {
            case "01d":
            default:
                return "DAY_SUNNY";
            case "01n":
                return "NIGHT_CLEAR";
            case "02d":
                return "DAY_CLOUDY";
            case "02n":
                return "NIGHT_ALT_CLOUDY";
            case "03d":
            case "03n":
                return "CLOUD";
            case "04d":
            case "04n":
                return "CLOUDY";
            case "09d":
            case "09n":
                return "SHOWERS";
            case "10d":
                return "DAY_RAIN";
            case "10n":
                return "NIGHT_RAIN";
            case "11d":
            case "11n":
                return "THUNDERSTORM";
            case "13d":
            case "13n":
                return "SNOW";
            case "50d":
            case "50n":
                return "FOG";
        }
    }
}
