package List;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");    list.add("bbb");    list.add("ccc");    list.add("ddd");
        //forEach：自己遍历集合得到每个元素，把得到的每个元素，传递给下面的accept方法
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        list.forEach((String s) ->{System.out.println(s);});
        }
    }

