package Demo1;

public abstract class Animals { //因为要有变量所以用抽象类不用接口
    public String name;
    public Integer age;

    public Animals(){}
    public Animals(String name, Integer age) {
        this.name = name;
        this.age = age;
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
    public abstract void eat();
}
