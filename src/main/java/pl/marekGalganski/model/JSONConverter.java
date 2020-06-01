package pl.marekGalganski.model;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;


public class JSONConverter {

    public Map<String, Integer> getCitiesFromJson(String path) throws FileNotFoundException {

        try {

            Map<String, Integer> mapOfCities = new TreeMap<>();
            JsonReader reader = new JsonReader(new InputStreamReader(getClass().getResourceAsStream(path)));
            Gson gson = new GsonBuilder().create();
            City[] cities = gson.fromJson(reader, City[].class);

            for (City city : cities) {
                mapOfCities.put(city.getName() + "," + city.getCountry(), city.getId());
            }

            return mapOfCities;
        } catch (NullPointerException | JsonSyntaxException e) {
            throw new FileNotFoundException();
        }
    }

}
