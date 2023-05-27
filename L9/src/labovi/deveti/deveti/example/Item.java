package labovi.deveti.deveti.example;

public class Item {
    private String name;
    private Double price, quantity, total;

    public Item(String name, Double price, Double quantity, Double total) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return this.name
                + " -  kolicina: " + this.quantity
                + ", cijena: " + this.price
                + ", ukupno: " + this.total;
    }
}
