package pl.marekGalganski.model;

import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;

import java.util.Map;
import java.util.stream.Collectors;

public class AutoCompleteTextField {

    public static void setAutoComplete(TextField textField, Map<String, Integer> cities) {
        TextFields.bindAutoCompletion(textField, t->{
           return cities.keySet().stream().filter(elem->{
               return elem.toLowerCase().startsWith(t.getUserText().toLowerCase());
           }).collect(Collectors.toList());
        });
    }
}
