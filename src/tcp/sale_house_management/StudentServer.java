package tcp.sale_house_management;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 5:26 AM
 */
public class StudentServer {
    static  private final  int PORT = 9;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        System.out.println("Connect to sever port " + PORT +". Please waiting ....");
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server Started : " + serverSocket);
        System.out.println("Waiting for client");
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("Client accept : " + socket);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String[] data = dataInputStream.readUTF().split(";");
            int key = Integer.parseInt(data[0]);
            String argument = data[1];
            switch (key){
                case 1 : getAllStudent(dataOutputStream);break;
                case 2 : findStudent(dataOutputStream,argument,2);break;
                case 3 : editStudent(dataOutputStream,argument);break;
                case 4 : findStudent(dataOutputStream,argument,4);break;
            }
        }

    }
    private static void editStudent(DataOutputStream dataOutputStream,String argument){
        String[] data = argument.split("-");
        List<Student> students = FileSupport.readFile();
        for(Student student : students){
        }
    }
    private static void  findStudent(DataOutputStream dataOutputStream, String argument,int key){
        List<Student> students = FileSupport.readFile();
        StringBuilder dataSend = new StringBuilder();
        System.out.println("search argument : " + argument);
        for (Student student : students){
            System.out.println("full name : " + student.getFullName());
            if (student.getFullName().toLowerCase().contains(argument.toLowerCase())){
                System.out.println(student.toStringData());
                dataSend.append(student.toStringData());
            }
        }
        try {
            switch (key){
                case 2 : {
                    System.out.println("data send : " + dataSend);
                    dataOutputStream.writeUTF(dataSend.toString());
                    break;
                }
                case 4 : {
                    if (dataSend.isEmpty()){
                        dataOutputStream.writeUTF(String.valueOf(false));
                    }else {
                        dataOutputStream.writeUTF(String.valueOf(true));
                    }

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void getAllStudent(DataOutputStream dataOutputStream){
        List<Student> students = FileSupport.readFile();
        StringBuilder data = new StringBuilder();
        for (Student student : students){
            System.out.println(student.toString());
            data.append(student.toStringData());
        }
        try {
            dataOutputStream.writeUTF(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
