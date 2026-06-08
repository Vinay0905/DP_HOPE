package java_solutions.OOPS;

// import java.util.Arrays;

public class Start {
    

    public static void main(String[] args) {
        student ben=new student(1,"Ben Rathore",40);
        student roy=new student(2,"roy Rathore",40);
        // ben.rno=1;
        // ben.name="Ben Rathore";
        // ben.marks=40;
        // int[] arr={1,2,3,4,5};

        // System.out.println(Arrays.toString(arr));
        // System.out.println(ben.name);
        // System.out.println(ben.rno);
        // System.out.println(ben.marks);
        student doom=new student();
        doom.print();
        roy.greetings();
        ben.greetings();
        roy.print();

        Integer num=45;
        num.toString();




       
    }
    

}


class student{
    int rno;
    String name;
    float marks;

    void greetings(){
        System.out.println("Please say hi to "+name+"!");
    }


    //Function overloading. student() and student(params....) can have the same name but different functionalities.
    student(){
        this.rno=0;
        this.name="default";
        this.marks=89;
    }

    student(student other){
        this.rno=other.rno;
        this.marks=other.marks;
        this.name=other.name;
    }

    // student(){
    //     this(1,"default niga",85);
    // }

    student(int rno,String name,int marks){
        this.rno=rno;
        this.name=name;
        this.marks=marks;
    }
    void print(){
        System.out.println(this.rno);
        System.out.println(this.name);
        System.out.println(this.marks);

    }
}