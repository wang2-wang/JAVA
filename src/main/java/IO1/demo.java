package IO1;
//hutool
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        //创建File对象
        File file = FileUtil.file("文件路径");
        //根据参数创建文件，类似于File类的createNewFile，
        //与之不同的是即使父级路径不存在，其也会创建好不存在的父级路径，从而创建文件
        FileUtil.touch("bbb\\a.txt");

        //将集合中数据写入文件，覆盖模式
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");arrayList.add("aaa");arrayList.add("aaa");
        FileUtil.writeLines(arrayList,"D:\\a.txt","UTF-8");
        //将集合中数据写入文件，续写模式
        FileUtil.writeLines(arrayList,"D:\\a.txt","UTF-8",true);
        FileUtil.appendLines(arrayList,"D:\\a.txt","UTF-8");
        //指定字符编码，将文件数据读到集合中,底层会帮助创建集合
        List<String> list = FileUtil.readLines("D:\\a.txt","UTF-8");
    }
}
