package Entity;

public class Human {
    public Long getBebraSize() {
        return bebraSize;
    }

    public void setBebraSize(Long bebraSize) {
        this.bebraSize = bebraSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Long bebraSize;

    private String name;

    private int age;

    public Human(Long bebraSize, String name, int age) {
        this.bebraSize = bebraSize;
        this.name = name;
        this.age = age;
    }
}
