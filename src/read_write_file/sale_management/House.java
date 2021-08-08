package read_write_file.sale_management;

import java.io.Serializable;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 2:17 AM
 */
public class House implements Serializable {
    private  final int code;
    private  final int price;
    private  boolean status;

    public House(int code, int price, boolean status) {
        this.code = code;
        this.price = price;
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "House [ code = " + this.code + ", " +
                "Price = " + this.price + "$" +
                ", status = " + this.status + "]";
    }
}
