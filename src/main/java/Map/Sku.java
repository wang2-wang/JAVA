package Map;

public class Sku {
    private String name;
    private Integer num;
    private Double price;

    public String getName() {
        return name;
    }

    public Integer getNum() {
        return num;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Sku(String name, Integer num, Double price) {
        this.name = name;
        this.num = num;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                '}';
    }
}
