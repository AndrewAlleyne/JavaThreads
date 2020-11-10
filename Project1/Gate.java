import java.util.LinkedHashMap;

public class Gate {

    int g;
    int s;
    int availableSpaces = s;

    public Gate(int g, int s) {
        this.g = g;
        this.s = s;

    }

    public void checkSpaces(LinkedHashMap<Integer, Integer> fcfs, String className) {

        // System.out.println("There are " + availableSpaces + "spaces");
        if (s == fcfs.size()) {
            System.out.println(className + " " + fcfs.keySet() + "is at " + this.getClass());
        }
    }

}
