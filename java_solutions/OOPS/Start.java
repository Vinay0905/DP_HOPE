package java_solutions.OOPS;

import java.util.Arrays;

public class Start {
    

    public static void main(String[] args) {
        student ben=new student();
        ben.rno=1;
        ben.name="Ben Rathore";
        ben.marks=40;

        int[] arr={1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        System.out.println(ben.name);
        System.out.println(ben.rno);


    }

}


class student{
    int rno;
    String name;
    float marks;
}