package valutecourse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectJsonConverter<T> {
    private final Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public String convertToJson(T obj){
        return gson.toJson(obj);
    }
}
