package Map;

public class Student implements Comparable<Student> {
    private Integer sno;
    private String sname;
    private Double score;
    public Student(Integer sno, String sname ,Double score){
        this.sno = sno;
        this.sname = sname;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {   //根据返回值排序，大于0 this对象大于o对象 。。。
       if(this.sno > o.sno){
            return 1;
       }else if(this.sno < o.sno){
           return -1;
       }
       return 0;
    }
}
