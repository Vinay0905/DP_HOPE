package java_solutions.String;

public class rotateString {
    public static  boolean rotatetring(String s, String goal) {
        if(s.length()!=goal.length())return false;
        String temp=s+s;
        return temp.contains(goal);

    }
    public static void main(String[] args) {
        System.out.println(rotatetring("rotation", "tionrota"));

    }
}
