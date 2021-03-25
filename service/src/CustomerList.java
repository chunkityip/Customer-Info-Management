public class CustomerList {

    private Customer[] customers; //an array to store customer object
    private int total; //the number of customer

    /*
    To initialize customer array
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /*
        Adding customer into array
        true : successfully adding
        false :fail to add

     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total++] = customer;
        return true;
    }
    /*
        Replace specific customer information from the array index start from 0
        if we did found the index in the array, return true
        else , return false
     */
    public boolean replaceCustomer(int index , Customer cust) {
        if (index < 0 || index >= total) {
            return false;
        }

        customers[index] = cust;
        return true;
    }

    /**
     @Description
    Delete specific customer from by the array index

     */
    public boolean deleteCustomer(int index) {
        boolean result = true;
        if (index < 0 || index >= total) {
            result = false;
        } else {//after we remove from the array , the previous info need to move forward
            for (int i = index; i < total - 1; i++) {
                customers[i] = customers[i + 1];
            }//remove the last array
            customers[total--] = null;
        }
        return result;
    }
    /**
     @Description
    return all customer follow by the total number
     */
    public Customer[] getAllCustomers() {
        Customer[] c = new Customer[total];
        for (int i = 0; i < total; i++) {
            c[i] = customers[i];
        }
        return c;
    }

    /*
    return specific customer follow by the array index

     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /*
    retrun the number of customers from array
     */
    public int getTotal() {
        return total;
    }

}
