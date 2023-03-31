import Entity.Human;
import com.google.gson.*;
public class jsonCock {
    Human human = new Human(18L, "Боб", 20);
    Gson gson = new Gson();
    GsonBuilder gsonBuilder = new GsonBuilder();




    public void show() {
        gsonBuilder.setPrettyPrinting();
        String jsonBuilderStr = gsonBuilder.create().toJson(human);
        String jsonStr = gson.toJson(human);
        System.out.println(jsonStr + "\n" + jsonBuilderStr);
    }
}
