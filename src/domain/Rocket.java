package domain;

import java.util.ArrayList;
import java.util.List;


public class Rocket {

    private int NUM_MAX_PROPELLER = 10;
    private String name;

    private List<Propeller> propellers = new ArrayList<>();

    public Rocket(String name) throws Exception {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) throws Exception {
        if (name.length() != 8) {
            throw new Exception("Incorrect name of Rocket. Must bé 8 characters");
        }
    }

    public void addPropeller(Propeller propeller) throws Exception {
        checkRocketSize();
        this.propellers.add(propeller);
    }

    private void checkRocketSize() throws Exception {
        if (propellers.size() >= NUM_MAX_PROPELLER) {
            throw new Exception("The rocket does not accept more propellers!");
        }
    }

    public static void accelerateDecelerateRocket(String nameRocket, int speed, List<Rocket> rockets) {
        for (Rocket r : rockets) {
            if (nameRocket.equals(r.getName())) {
                for (Propeller p :
                        r.propellers) {
                    p.changeSpeedPropeller(p, speed);
                }
            }

        }

    }

    public double calcCurrentSpeed(List<Propeller> propellers) {
        double currentPower = propellers.stream()
                .mapToDouble(x -> x.getCurrentPower())
                .sum();
        return (double) 100 * Math.sqrt(currentPower);
    }

    @Override
    public String toString() {
        return "Rocket:'" + name + '\'' + "  Number of propellers: " + propellers.size() +
                " " + propellers;
    }

    public String getName() {
        return name;
    }

    public List<Propeller> getPropellers() {
        return propellers;
    }
}
