import java.io.Serializable;

public class Guest implements Serializable {
    private String name;
    private String paymentMethod;

    public Guest(String name, String paymentMethod) {
        this.name = name;
        this.paymentMethod = paymentMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Guest: " + name + ", Payment Method: " + paymentMethod;
    }
}
