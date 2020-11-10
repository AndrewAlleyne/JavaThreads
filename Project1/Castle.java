import java.util.LinkedHashMap;

public class Castle {

    int g;
    int s;
    private Gate gate1;
    private Gate gate2;

    // Castle defense value
    int castleDefVal = 0;

    // Gate has 2 sides. Side A and Side B

    private final static Object lock = new Object();

    // constuctor
    public Castle(int g, int s, Gate gate1, Gate gate2) {
        this.g = g;
        this.s = s;
        this.gate1 = gate1;
        this.gate2 = gate2;

    }

    public void defValue(int defenderVal) {
        castleDefVal = defenderVal;
        System.out.println("Castle defense is at " + castleDefVal);

    }

    public void hello() {
        System.out.println("Welcome to Talverton Stronghold! This castle has " + g + " gates. Each of gate has " + s
                + " spaces! ");
        System.out.println();

    }

    public void checkGate(LinkedHashMap<Integer, Integer> fcfs, String className) {

        System.out.println();
        // We need to check how many memembers are at the gate.
        gate1.checkSpaces(fcfs, className);
        // If number of members at the gate superseeds our spaces then we send the
        // remained
        // to the other gate.
    }

}
