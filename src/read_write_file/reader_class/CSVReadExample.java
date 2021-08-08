package read_write_file.reader_class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 1:11 AM
 */
public class CSVReadExample {
    private static final String COMMA_DELIMITER = ",";
    private static final String FILE_NAME = "./countries.csv";

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
            while ((line = bufferedReader.readLine()) != null) {
                printCountry(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    private static Country parseCsvLine(String csvValue) {
        Country country = null;
        if (csvValue != null) {
            String[] data = csvValue.split(COMMA_DELIMITER);
            System.out.println("data [" + data[0] + "," + data[1] + "," + data[2] + "]");
            country = new Country(Integer.parseInt(data[0]),data[1],data[2]);
        }
        return country;
    }

    private static void printCountry(Country country) {
        System.out.println(country.toString());
    }
}
