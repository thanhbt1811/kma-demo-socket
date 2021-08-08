package tcp.sale_house_management;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 5:26 AM
 */
public class StudentClient {
    private static final String HOST = "localhost";
    private static final int PORT = 9;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT)) {
            System.out.println("Connect : " + socket);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                menu();
                switch (new Scanner(System.in).nextInt()) {
                    case 1: {
                        dataOutputStream.writeUTF("1" + ";" +"no argument");
                        printAllStudent(dataInputStream);
                        break;
                    }
                    case 2 :{
                        System.out.println("Input student name");
                        String studentName = new Scanner(System.in).nextLine();
                        String dataSend = "2" + ";" + studentName.trim();
                        dataOutputStream.writeUTF(dataSend);
                        printAllStudent(dataInputStream);
                        break;
                    }
                    case 3 : {
                        System.out.println("Input full name student");
                        String fullName = new Scanner(System.in).nextLine();
                        String dataSend = "4" + ";" + fullName;
                        boolean isExitsStudent = Boolean.parseBoolean(dataInputStream.readUTF());
                        if (isExitsStudent){
                            editStudent(dataOutputStream);
                            String data = dataInputStream.readUTF();
                            System.out.println(data);
                        }else {
                            System.out.println("Student not found");
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void editStudent(DataOutputStream dataOutputStream){
        editMenu();
        int indexEdit = new Scanner(System.in).nextInt();
        String dataSend = "3" + ";";
        switch (indexEdit){
            case 1 :{
                System.out.println("Input new first name");
                String newFirstName = new  Scanner(System.in).nextLine();
                dataSend = dataSend + "1" + "-" + newFirstName ;
                break;
            }
        }
        try {
            dataOutputStream.writeUTF(dataSend);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void editMenu(){
        System.out.println("Please Choose");
        System.out.println("1. Edit First Name");
        System.out.println("2. Edit Last Name");
        System.out.println("3. Edit Birth Day");
        System.out.println("4. Edit Math Point");
        System.out.println("5. Edit Englisht Point");
    }

    private static void  printAllStudent(DataInputStream dataInputStream){
        try {
            String data = dataInputStream.readUTF();
            if (data.isEmpty()){
                System.out.println("Student no found");
            }else {
                List<Student> students = parseListStudent(data.split(";"));
                for(Student student : students){
                    System.out.println(student.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static List<Student> parseListStudent(String[] data){
        List<Student> students = new ArrayList<>();
        for (String subData : data){
            students.add(Student.parseStudent(subData.split(",")));
        }
        return  students;
    }
    private static void menu() {
        System.out.println("Please choose");
        System.out.println("1. Print All Student");
        System.out.println("2. Find Student By Name");
        System.out.println("3. Edit Student");
    }
}
