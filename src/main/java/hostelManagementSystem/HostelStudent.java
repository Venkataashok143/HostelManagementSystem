package hostelManagementSystem;

public class HostelStudent {
   
    private String name;
    private String phone; // Changed to String for better validation
    private String email;
    private int roomNo;
    private String joiningDate;
    private String aadharNo; // Changed to String for 12-digit validation
    private String address;

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Constructor to initialize values
    public HostelStudent(String name, String phone, String email, int roomNo, String joiningDate, String aadharNo, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.roomNo = roomNo;
        this.joiningDate = joiningDate;
        this.aadharNo = aadharNo;
        this.address = address;
    }
}