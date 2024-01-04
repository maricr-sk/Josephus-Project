import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Jqueue {

    static Queue<Jnode> list;

    public Jqueue(int soldiers) {
        list = new PriorityQueue<>();
        for(int i = 0; i < soldiers; ++i){
            //add another node
            Jnode j = new Jnode(i);
            list.add(j);
        }
    }

    public int execute(int n) {
        int soldier = n % list.size();
        if(list.size() <= 1){
            return list.peek().getId();
        }
        list.remove(soldier + 1);
        return execute(n-1) % soldier + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int num = Integer.valueOf(scanner.next());

        for(int i = 0; i < num; i++) {
            int numSoldiers = Integer.valueOf(scanner.next());
            Jqueue flavius = new Jqueue(numSoldiers);
            System.out.println(flavius.execute(numSoldiers));
        }
    }
}