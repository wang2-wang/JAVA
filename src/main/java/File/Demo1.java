package File;

import java.io.File;
import java.io.IOException;

//创建文件File对象,   File对象表示路径，可以是文件也可以是文件夹
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //根据文件路径创建File对象
        String str = "C:\\Users\\...\\a.txt";
        File f1 = new File(str);

        //根据父路径和子路径名称拼接创建File对象,父路径：C:\Users\...   子路径：a.txt
        String parent = "C:\\Users\\...";
        String child = "a.txt";
        File f2= new File(parent,child);

        //将File对象表示的路径，与String表示的路径进行拼接
        File parent2 = new File("C:\\Users\\...");
        String child2 = "a.txt";
        File f4 = new File(parent2,child2);

        //File方法
        f1.isDirectory();   //是否为文件夹
        f1.isFile();    //是否为文件
        f1.exists();    //是否存在
        f1.length();    //返回文件大小（字节）,只能获取文件不能获取文件夹大小
        f1.getAbsolutePath();   //获取文件绝对路径
        f1.getPath();           //返回定义文件时路径，也就是File（）括号里的东西
        f1.getName();           //获取名称，文件：文件名+后缀名   文件夹：文件夹名
        f1.lastModified();      //文件最后修改时间，ms
        f1.createNewFile();     //创建文件，若已存在返回false。若所创建文件的父级路径不存在则报错
        f1.mkdir();     //创建文件夹，只能创建单级文件夹，  mkdirs创建多级文件夹
        f1.delete();    //删除文件，空文件夹，不经过回收站      删除有内容的文件夹则删除失败
        f1.listFiles();     //获取当前路径下所有内容，返回的是数组

    }
}
