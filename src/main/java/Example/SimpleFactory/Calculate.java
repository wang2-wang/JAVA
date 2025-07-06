package Example.SimpleFactory;

public interface Calculate {
    int calculate(int num1,int num2);
}
//更好的
/*public interface Calculate<T> {
    T Calculate(T num1,T num2);
}
*/
