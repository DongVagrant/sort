
public class Students {

    private int age;
    private int score;
    private String name;
    private String template;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Students() {
        super();
    }

    public Students(int age, int score, String name) {
        super();
        this.age = age;
        this.score = score;
        this.name = name;
    }

    public Students(int age, int score){
        super();
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
