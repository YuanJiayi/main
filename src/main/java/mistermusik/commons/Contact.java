//@@author YuanJiayi

package mistermusik.commons;


public class Contact {
    private String name;
    private String email;
    private String phoneNo;

    /**
     * Creates a new contact.
     * @param name    name to be stored
     * @param email   email to be stored
     * @param phoneNo phone number to be stored
     */
    public Contact(String name, String email, String phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
