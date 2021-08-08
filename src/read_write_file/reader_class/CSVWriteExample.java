package read_write_file.reader_class;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 12:56 AM
 */
public class CSVWriteExample {
    private  static  final  String COMMA_DELIMITER = ",";
    private  static  final  String NEW_LINE_SEPARATOR = "\n";

    public static void main(String[] args) {
        String fileName = "./countries.csv";
        writeCsvFile(fileName);
    }
    public static void writeCsvFile(String fileName){
        Country country1 = new Country(1,"US","United State");
        Country country2 = new Country(2,"VN","Viet Name");
        Country country3 = new Country(3,"AU","Australia");
        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            for(Country country : countries){
                fileWriter.append(String.valueOf(country.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getCode());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(country.getName());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created  successfully !!!");
        } catch (IOException ioException) {
            System.out.println("Error in CSV Writer !!!");
            ioException.printStackTrace();
        }finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
