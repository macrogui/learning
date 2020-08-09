package datastucture.array;

public class Student {
    private String name;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Array<Student> students = new Array<>();
        students.addLast(new Student("Bob", 99));
        students.addLast(new Student("Peter", 66));
        students.addLast(new Student("Job", 80));
        System.out.println(students);
    }
}
