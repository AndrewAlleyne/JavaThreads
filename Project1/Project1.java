public class Project1 {

    public static long time = System.currentTimeMillis();

    public static void main(String[] args) throws InterruptedException {

        int gates = 2;
        int spaces = 3;

        System.out.println("Welcome to the town of Grimoire!" + age());
        System.out.println();
        Thread.sleep(1000);
        System.out.println("The king raises taxes. We shall storm the castle!" + age());
        Thread.sleep(1000);

        Gate gate1 = new Gate(gates, spaces);
        Gate gate2 = new Gate(gates, spaces);

        // Castle
        Castle castle = new Castle(gates, spaces, gate1, gate2);

        castle.hello();

        // Attacker threads
        for (int i = 0; i < 3; i++) {
            Attacker attacker = new Attacker(i, castle, gates, spaces);
            attacker.start();
        }
        // Defenders load in already weaponized and with a random attack number.
        Thread.sleep(3000);
        // Defender threads
        for (int i = 0; i < 3; i++) {
            int defenderAttack = (int) (Math.random() * 10) + 1;
            Defender defender = new Defender(i, castle, gates, spaces, defenderAttack);
            defender.start();
        }

    }

    public static String age() {

        return "[" + (System.currentTimeMillis() - time) + "]";
    }

}