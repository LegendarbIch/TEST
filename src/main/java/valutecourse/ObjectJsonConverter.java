package valutecourse;

import com.google.gson.Gson;

public class ObjectJsonConverter<T> {
    private final Gson gson = new Gson();

    public String convertToJson(T obj){
        return gson.toJson(obj);
    }
}
