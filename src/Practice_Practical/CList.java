package Practice_Practical;

/**
 * Created by kjeged01 on 03/06/2018.
 */
public class CList extends Thread {
    private int item;
    private CList next;
    private int updateCount=0;

    public synchronized void replace(int old, int neww, CList startedAt){
        if(item==old) {item=neww; updateCount++;
        }
        if(next!=startedAt) next.replace(old, neww, startedAt);
    }
    public void run() {
        for(int i=0; i<100; i++)
            replace(i, i-1, this);
    }

    // Constructor
    public CList(int item, CList next) {
        this.item=item;
        this.next=next;
    }

    public static void main(String args[]) {
        CList clist3 = new CList(60, null);
        CList clist2 = new CList(40, clist3);
        CList clist1 = new CList(20, clist2);
        clist3.next = clist1;
        clist1.start();
        clist2.start();
        clist3.start();
    }
}
