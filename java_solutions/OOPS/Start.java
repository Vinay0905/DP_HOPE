package java_solutions.OOPS;

import java.util.Arrays;

public class Start {
    

    public static void main(String[] args) {
        student ben=new student(1,"Ben Rathore",40);
        student roy=new student(2,"roy Rathore",40);
        // ben.rno=1;
        // ben.name="Ben Rathore";
        // ben.marks=40;

        roy.greetings();
        int[] arr={1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        System.out.println(ben.name);
        System.out.println(ben.rno);
        System.out.println(ben.marks);
        ben.greetings();


    }

}


class student{
    int rno;
    String name;
    float marks;

    void greetings(){
        System.out.println("Please say hi to "+name+"!");
    }
    student(int rno,String name,int marks){
        this.rno=rno;
        this.name=name;
        this.marks=marks;
    }
}