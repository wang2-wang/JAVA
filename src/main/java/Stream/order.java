package Stream;

public class order {
    private String name;
    private Integer num;
    private Double price;
    private Double amount;

    public order(String name, Integer num, Double price, Double amount) {
        this.name = name;
        this.num = num;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "order{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
