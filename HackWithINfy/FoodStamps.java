package HackWithINfy;
import java.util.PriorityQueue;
import java.util.Scanner;
class Food{
    long nextGain;
    int index;
    int times;
    Food(long nextGain, int index, int times){
        this.nextGain = nextGain;
        this.index = index;
        this.times = times;
    }
}

public class FoodStamps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // number of types
        int m = sc.nextInt();   // max meals

        long[] v = new long[n];
        long[] d = new long[n];

        // v[i] in next n lines
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextLong();
        }
        // d[i] in next n lines
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextLong();
        }

        long ans = solve(n, m, v, d);
        System.out.println(ans);

        sc.close();
    }
    public static long solve(int n,int m,long[] v,long[] d){
        PriorityQueue<Food> pq=new PriorityQueue<>(
            (a,b)->Long.compare(b.nextGain,a.nextGain)
        );
        for(int i=0;i<n;i++){
            pq.add(new Food(v[i],i,0));

        }
        long totaltaste=0;
        for(int i=0;i<m;i++){
            Food best=pq.poll();
            if(best==null || best.nextGain<=0){
                break;
            }
            totaltaste+=best.nextGain;
            best.times++;
            long newGain=v[best.index]-d[best.index]*best.times;
            best.nextGain=newGain;
            pq.add(best);
        }
        return totaltaste;
    }

}
