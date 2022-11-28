package view;

import domain.Propeller;
import domain.Rocket;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String ROCKET1 = "32WESSDS";
    private static final String ROCKET2 = "LDSFJA32";

    public static void main(String[] args) throws Exception {

        List<Rocket> rockets = createRockets();
        showRockets(rockets);

        doFirstMovement(rockets);

        doSecondMovement(rockets);

        doThirdMovement(rockets);

    }

    private static void doThirdMovement(List<Rocket> rockets) {
        Rocket.accelerateDecelerateRocket(ROCKET1, 15, rockets);
        Rocket.accelerateDecelerateRocket(ROCKET2, 15, rockets);
        showCurrentSpeed(rockets);
    }

    private static void doSecondMovement(List<Rocket> rockets) {
        Rocket.accelerateDecelerateRocket(ROCKET1, -5, rockets);
        Rocket.accelerateDecelerateRocket(ROCKET2, 7, rockets);
        showCurrentSpeed(rockets);
    }

    private static void doFirstMovement(List<Rocket> rockets) {
        Rocket.accelerateDecelerateRocket(ROCKET1, 3, rockets);
        Rocket.accelerateDecelerateRocket(ROCKET2, 3, rockets);
        showCurrentSpeed(rockets);
    }

    private static void showCurrentSpeed(List<Rocket> rockets) {

        for (Rocket r : rockets) {
            double currentSpeed = r.calcCurrentSpeed(r.getPropellers());
            System.out.printf("Rocket:" + r.getName() + " Speed: " + "%.2f %n", currentSpeed);
        }
    }

    private static void showRockets(List<Rocket> rockets) {
        rockets.stream().forEach(x -> System.out.println(x));
    }

    private static List<Rocket> createRockets() throws Exception {

        List<Rocket> rockets = new ArrayList<>();

        rockets.add(0, addRocketInRockets(ROCKET1));
        rockets.add(1, addRocketInRockets(ROCKET2));

        return rockets;
    }

    private static Rocket addRocketInRockets(String name) throws Exception {
        Rocket rocket = new Rocket(name);
        if (name.equals(ROCKET1)) {
            rocket.addPropeller(new Propeller(10));
            rocket.addPropeller(new Propeller(30));
            rocket.addPropeller(new Propeller(80));
        }
        if (name.equals(ROCKET2)) {
            rocket.addPropeller(new Propeller(30));
            rocket.addPropeller(new Propeller(40));
            rocket.addPropeller(new Propeller(50));
            rocket.addPropeller(new Propeller(50));
            rocket.addPropeller(new Propeller(30));
            rocket.addPropeller(new Propeller(10));
        }
        return rocket;
    }

}