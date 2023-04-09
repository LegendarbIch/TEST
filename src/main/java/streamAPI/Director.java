package streamAPI;

public class Director {

    public String working(Worker worker, int count){
        return worker.work(count);
    }
}
