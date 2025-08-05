package Demo1;

import java.util.ArrayList;

public class Demo {
    //能养所有猫。不能养狗
    //能养所有狗。不能养猫
    //能养所有动物，不能为其他类型
    public static void main(String[] args) {
        ArrayList<PersianCat> list1 = new ArrayList<>();
        ArrayList<LiHuaCat> list2 = new ArrayList<>();
        ArrayList<Teddy> list3 = new ArrayList<>();
        ArrayList<HuskyDog> list4 = new ArrayList<>();
        keepPet(list1);
        keepPet(list2);
        keepPet1(list3);
        keepPet2(list4);
    }


        public static void keepPet(ArrayList<? extends Cat> list){
        }
        public static void keepPet1(ArrayList<? extends Dog> list){
        }
        public static void keepPet2(ArrayList<? extends Animals> list){
        }


}
