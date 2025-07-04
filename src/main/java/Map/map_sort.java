package Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//排序
public class map_sort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numberCp = new ArrayList<>();
        numbers.add(3); numbers.add(1); numbers.add(4); numbers.add(2); numbers.add(5);
        //反转
        Collections.reverse(numbers);
        System.out.println(numbers);
        //自然排序
        Collections.sort(numbers);
        System.out.println(numbers);

    }

}
