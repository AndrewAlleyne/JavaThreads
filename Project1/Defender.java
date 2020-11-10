import java.util.LinkedHashMap;

public class Defender extends Thread {

    private int i;
    private Castle castle;
    private int gates;
    private int spaces;
    private int defenderAttack;
    final static LinkedHashMap<Integer, Integer> FCFS2 = new LinkedHashMap<Integer, Integer>();

    private static int totalDef;

    // Get classname
    String className = this.getClass().getName();

    private final static Object lock = new Object();

    public Defender(int i, Castle castle, int gates, int spaces, int defenderAttack) {
        this.i = i;
        this.castle = castle;
        this.gates = gates;
        this.spaces = spaces;
        this.defenderAttack = defenderAttack;
    }

    public void run() {
        // sum up total random attack for castle defense value

        generateDefenderVal();
        linkedhashfull();
        totalDef += defenderAttack;
        castle.defValue(totalDef);

    }

    private void generateDefenderVal() {

        // locking them since I may want to control order here for battle.
        synchronized (lock) {
            System.out.println(
                    "Defender " + i + " gained weapon. Attack value" + " [" + defenderAttack + "]. Head to the gate!");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            FCFS2.put(i, defenderAttack);

        }
    }

    // check if our collection is full.
    private void linkedhashfull() {

        if (FCFS2.size() == spaces) {
            castle.checkGate(FCFS2, className);

        }
    }

}
