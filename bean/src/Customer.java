public class Customer {
    private String lastname;
    private String firstname;
    private int age;
    private String phonenumber;
    private String email;

    public Customer(String lastname, String firstname, int age, String phonenumber , String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getLastName (){
        return lastname;
    }

    public void setLastName (String lastname) {
        this.lastname = lastname;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String first_name) {
        this.firstname =  first_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return  email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Display customer information
    public String getCustomerInfo() {
        return lastname + "\t" + firstname + "\t" + age + "\t" + phonenumber + "\t" + email;
    }
}
