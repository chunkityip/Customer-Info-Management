import java.util.Scanner;

public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    //create a account to test
    public CustomerView() {
        Customer c = new Customer("Chunkit" , "Yip", 26 , "1111111111" , "yck11214@gmail.com");
        customerList.addCustomer(c);
    }

    /**
    @Description
    Display the interface of Customer Information Management Application
     */
    public void enterMainMenu() {

        boolean enter = true;
        while (enter) {
            System.out.println("------Customer Information Management Application------");
            System.out.println("1. Add new Customer ");
            System.out.println("2. Edit Customer info ");
            System.out.println("3. Delete Customer");
            System.out.println("4. Customer list");
            System.out.println("5. Exit");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Please choose(1 - 5): ");

            char menu = CMUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    editCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("Are you sure to exit? (Y/N): ");
                    char isExit = CMUtility. readConfirmSelection();
                    if (isExit == 'Y') {
                        System.out.println("Exiting....");
                        enter = false;
                    }
                    break;
            }
        }
    }


    //1
    private void addNewCustomer() {
        System.out.println("---------Add new Customer---------");
        System.out.println("Last Name: ");
        String lname = CMUtility.readString(10);

        System.out.println("First Name: ");
        String fname = CMUtility.readString(10);

        System.out.println("Age: ");
        int age = CMUtility.readInt();

        System.out.println("Phone number: ");
        String phone = CMUtility.readString(10);

        System.out.println("E-mail: ");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(lname , fname , age, phone , email);

        boolean added = customerList.addCustomer(customer);
        if(added) {
            System.out.println("---------Adding successful---------");
        } else {
            System.out.println("---------Adding unsuccessful---------");
        }
    }

    //2
    private void editCustomer() {
        System.out.println("---------Edit Customer Info---------");
        Customer c = null;
        int number = 0;
        while(true) {
            System.out.println("Please enter the Customer ID(-1 to exit): ");
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            c = customerList.getCustomer(number - 1);
            if (c == null) {
                System.out.println("Can't found the customer! Please make sure the info is right!");
            } else {
                break;
            }
        }

        //Found the customer info
        System.out.println("Last name (" + c.getLastName() + ")");
        String lname = CMUtility.readString(10 , c.getLastName());

        System.out.println("First name (" + c.getFirstName() + ")");
        String fname = CMUtility.readString(10 , c.getFirstName());

        System.out.println("Age (" + c.getAge() + ")");
        int age = CMUtility.readInt(c.getAge());

        System.out.println("Phone Number (" + c.getPhoneNumber() + ")");
        String phone = CMUtility.readString(10 , c.getPhoneNumber());

        System.out.println("Email (" + c.getEmail() + ")");
        String email = CMUtility.readString(30 , c.getEmail());

        Customer newCustomer = new Customer(lname , fname , age, phone , email);

        boolean isRepalaced = customerList.replaceCustomer(number - 1 , newCustomer);
        if (isRepalaced) {
            System.out.println("---------Edit Successful---------");
        } else {
            System.out.println("---------Edit Unsuccessful , Please make sure the info is correct---------");
        }
    }

    //3
    private void deleteCustomer() {
        System.out.println("---------Delete Customer---------");

        int number;
        while (true) {
            System.out.println("Please enter the Customer ID(-1 to exit): ");
            number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            Customer c = customerList.getCustomer(number - 1);
            if (c == null) {
                System.out.println("Can't found the customer!");
            } else {
                break;
            }
        }

        System.out.println("Are you sure to delete(Y/N): ");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            boolean deleteSuccess = customerList.deleteCustomer(number - 1);
            if (deleteSuccess) {
                System.out.println("---------Delete Compete---------");
            } else {
                System.out.println("---------Delete Unsuccessful , Please make sure the info is correct---------");
            }
        }
    }


    //4
    private void listAllCustomer() {
        System.out.println("---------Customer List---------");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("!!!No Customer information!!!");
            System.out.println(" ");
        } else {
            System.out.println("ID\tLName\t\tFName\tAge\t\tPhone\t\tE-mail");
            Customer[] customers = customerList.getAllCustomers();
            for (int i = 0; i < customers .length; i++) {
                Customer c = customers [i];
                System.out.println((i + 1) + "\t" + c.getLastName() + "\t\t" + c.getFirstName()
                + "\t\t" + c.getAge() + "\t\t" + c.getPhoneNumber() + "\t" + c.getEmail());
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}
