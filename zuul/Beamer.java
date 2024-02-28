public class Beamer extends Item {

    private boolean charged;


    public Beamer(String name, String description, double weight, boolean charged) {
        super(name, description, weight);
        this.charged = charged;

    }

    public boolean isCharged() {
        return charged;
    }

    public boolean chargeBeamer() {
        if (!isCharged()) {
            System.out.println("Beamer successfully charged!");
            charged = true;
            return true;
        } else {
            System.out.println("Beamer has already been charged.");
            return false;
        }
    }

    public boolean fireBeamer() {
        if (isCharged()) {
            System.out.println("Beamer has been fired!");
            charged = false;
            return true;
        } else {
            System.out.println("Beamer is not charged.");
            return false;
        }
    }
}
