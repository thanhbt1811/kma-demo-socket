package read_write_file.sale_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 2:46 AM
 */
public class FileSupport {
    private static final String FILEPATH = "C:/Users/BTThanh/Documents/DevLearn/java_socket/src/read_write_file/sale_management/house.csv";
    private static final String DOT = ",";
    private static final String NEW_LINE = "\n";

    public static List<House> readFile() {
        List<House> houses = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(FILEPATH));
            while ((line = bufferedReader.readLine()) != null){
                House house = parseHouse(line);
                houses.add(house);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  houses;
    }
    private  static  House parseHouse(String house){
        String [] data = house.split(DOT);
        return new House(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Boolean.parseBoolean(data[2]));
    }

    public static void writeFile(List<House> houses){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILEPATH);
            for (House house : houses){
                fileWriter.append(String.valueOf(house.getCode()));
                fileWriter.append(DOT);
                fileWriter.append(String.valueOf(house.getPrice()));
                fileWriter.append(DOT);
                fileWriter.append(String.valueOf(house.isStatus()));
                fileWriter.append(NEW_LINE);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        finally {
            try {
                assert  fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
