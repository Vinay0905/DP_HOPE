package java_solutions.Matrix;

public class Sarah_Gardening {
    
    public static void main(String[] args) {
        
        int n=21,r=5,c=5;
        if(n>(r*c)-r || n<r){
            System.out.println("Yes");
            return;
        }
        else if(n%r==1){
            System.out.println("Yes");
            return;
        }
        
        else{
            System.out.println("No");
        }
    }
}
