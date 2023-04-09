package streamAPI;

@FunctionalInterface
public interface Worker {
     abstract String work(int count);
}
