package List;

public class Student1 implements Comparable<Student1>{
    public String name;
    public Integer age;
    public Integer chinese;
    public Integer math;
    public Integer english;

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                '}';
    }

    public Student1() {}
    public Student1(String name, Integer age, Integer chinese, Integer math, Integer english) {
        this.name = name;
        this.age = age;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    @Override
    public int compareTo(Student1 o) {
        int sum = this.getEnglish()+this.getChinese()+this.getEnglish();
        int sum1 = o.getEnglish()+o.getChinese()+o.getMath();
        int i = sum-sum1;
        i = i == 0 ? this.getChinese()-o.getChinese() : i;
        i = i == 0 ? this.getMath()-o.getMath() : i;
        i = i == 0 ? this.getAge()-o.getAge() : i;
        i = i == 0 ? this.getName().compareTo(o.getName()): i;
        return i;

    }
}
