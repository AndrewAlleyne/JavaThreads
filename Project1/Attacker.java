import java.util.LinkedHashMap;

public class Attacker extends Thread {

    private final static Object armory = new Object();
    final static LinkedHashMap<Integer, Integer> FCFS = new LinkedHashMap<Integer, Integer>();

    // Each thread will have a random attack number
    // private int randomAttackNumber = (int) (Math.random() * 10) + 1;
    int random;

    // an identification
    private int i;

    // Give attackers access to the castle-
    private Castle castle;

    // whether they have gained weapon
    boolean weaponGained = false;

    private static int gates;
    private static int spaces;

    // Get classname
    String className = this.getClass().getName();

    // assigned gate position
    // health points

    Attacker(int i, Castle castle, int gates, int spaces) {
        this.i = i;
        this.castle = castle;
        this.gates = gates;
        this.spaces = spaces;
    }

    public void run() {

        // They then gain a random attack number
        random = randomAttackNumber();

        // Attackers first gain a weapon and
        weaponGained = gainWeapon();
        weaponCheck();

        // Place attackers in a FCFS queue
        // Problem might occur here. If collection being worked on we might get an
        // error.
        FCFS.put(i, random);

        // Check if spaces can be occupied by the number of threads we have accumulated.
        linkedhashfull();

        

    }

    // check if our collection is full.
    private void linkedhashfull() {
        if (FCFS.size() == spaces) {

            castle.checkGate(FCFS, className);

        }
    }

    // Check if weapon gained. no interrupts.
    private boolean weaponCheck() {

        if (weaponGained == true) {
            System.out.println("Attacker " + i + " gained weapon. Attack value [" + random + "]. Head to the gate!");

            return true;
        } else {
            System.out.println("Attacker " + i + " did not gain a weapon. Attack value [" + random + "]");
            return false;
        }
    }

    public boolean gainWeapon() {

        // Only one attacker can have access to the lock
        synchronized (armory) {

            // Simulate weapon gained with a 2 second sleep
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("I didn't get a weapon someone pushed infront of me!");
                e.printStackTrace();
            }

            // Store the attackers in a first come first serve basis
            return true;
        }
    }

    public int randomAttackNumber() {

        int rando = (int) (Math.random() * 10) + 1;
        return rando;

    }

}
