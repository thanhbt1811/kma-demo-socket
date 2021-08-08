package read_write_file.reader_class;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 12:54 AM
 */
public class Country {
    private final int id;
    private final String code;
    private final String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [id= " + this.id + ", code= " + this.code + ", nam= " + this.name + "]";
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
