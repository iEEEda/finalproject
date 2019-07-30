package kz.eduard.first.entity;

public class Item {
  private int price;

  public Item(int price) {
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Item{" +
        "price=" + price +
        '}';
  }
}
