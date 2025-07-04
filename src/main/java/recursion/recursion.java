package recursion;

public class recursion {

    static int f(int n){
        //递归终止条件 =1
        if(n==1 || n==2 )return 1;
        return f(n-1)+f(n-2);
    }

    public static void main(String[] args) {
        int x = f(9);
        System.out.println(x);
    }
}
