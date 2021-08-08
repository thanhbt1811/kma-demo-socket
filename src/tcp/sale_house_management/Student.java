package tcp.sale_house_management;

import java.io.Serializable;

/**
 * User: Bui Tien Thanh
 * Date: 8/8/2021
 * Time: 4:56 AM
 */
public class Student  implements Serializable {
    private final String id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private double mathPoint;
    private double englishPoint;

    public Student(String id, String firstName, String lastName, String birthDay,
                   double mathPoint, double englishPoint) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.mathPoint = mathPoint;
        this.englishPoint = englishPoint;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public double getMathPoint() {
        return mathPoint;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public double getEnglishPoint() {
        return englishPoint;
    }

    public void setEnglishPoint(double englishPoint) {
        this.englishPoint = englishPoint;
    }
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
    public double getMediumPoint(){
        return  (this.mathPoint + this.englishPoint)/2;
    }
    String toStringData(){
        return this.id + "," +
                this.firstName + "," +
                this.lastName + "," +
                this.birthDay + "," +
                this.mathPoint + "," +
                this.englishPoint + ";";
    }

    @Override
    public String toString() {
        return "Student [ id :" + this.id +
                ", first name : " + this.firstName +
                ", last name : " + this.lastName +
                ", birth day : " + this.birthDay +
                ", math point : " + this.mathPoint +
                ", english point : " + this.englishPoint  +
                ", medium point : " + this.getMediumPoint() + "]"
                ;
    }
    static  public Student parseStudent(String[] data) {
        return new Student(data[0], data[1], data[2],
                data[3], Double.parseDouble(data[4]),
                Double.parseDouble(data[5]));
    }
}
