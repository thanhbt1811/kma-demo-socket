package tcp.sale_house_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 5:08 AM
 */
public class FileSupport {
    static final String FILE_PATH = "C:/Users/BTThanh/Documents" +
            "/DevLearn/java_socket/src/tcp/sale_house_management/students.csv";
    static final String DOT = ",";
    static final String NEW_LINE = "\n";

    static List<Student> readFile() {
        List<Student> students = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            while ((line = bufferedReader.readLine()) != null) {
                Student student = Student.parseStudent(line.split(DOT));
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert  bufferedReader != null;
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return students;
    }


    static void writeFile(List<Student> students) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_PATH);
            for (Student student : students) {
                fileWriter.append(student.getId());
                fileWriter.append(DOT);
                fileWriter.append(student.getFirstName());
                fileWriter.append(DOT);
                fileWriter.append(student.getLastName());
                fileWriter.append(DOT);
                fileWriter.append(student.getBirthDay());
                fileWriter.append(DOT);
                fileWriter.append(String.valueOf(student.getMathPoint()));
                fileWriter.append(DOT);
                fileWriter.append(String.valueOf(student.getEnglishPoint()));
                fileWriter.append(DOT);
                fileWriter.append(String.valueOf(student.getMediumPoint()));
                fileWriter.append(DOT);
                fileWriter.append(NEW_LINE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert fileWriter != null;
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
