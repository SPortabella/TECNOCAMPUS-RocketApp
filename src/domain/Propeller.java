package domain;

import java.util.Objects;

public class Propeller {
    private double maxPower = 0;
    private double currentPower = 0;

    public Propeller(double maxPower) {
        this.maxPower = maxPower;
        this.currentPower = 0;
    }

    public void setCurrentPower(double currentPower) {
        this.currentPower = currentPower;
        if (currentPower < 0) this.currentPower = 0;
        if (currentPower > maxPower) this.currentPower = this.maxPower;
    }

    public void changeSpeedPropeller(Propeller propeller, double speed) {

        setCurrentPower(getCurrentPower() + (10 * speed));

    }

    public double getMaxPower() {
        return maxPower;
    }

    public double getCurrentPower() {
        return currentPower;
    }

    @Override
    public String toString() {
        return "MaximPower=" + maxPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propeller propeller = (Propeller) o;
        return Double.compare(propeller.maxPower, maxPower) == 0 && Double.compare(propeller.currentPower, currentPower) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxPower, currentPower);
    }
}
