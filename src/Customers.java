public class Customers {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean clubMembers;
    private double sumOfPurchases;
    private int amountOfPurchases;

    @Override
    public String toString() {
        return "Customers{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", clubMembers=" + clubMembers +
                ", sumOfPurchases=" + sumOfPurchases +
                ", amountOfPurchases=" + amountOfPurchases +
                '}';
    }

    public Customers(String firstName, String lastName, String userName, String password, boolean clubMembers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.clubMembers = clubMembers;
        this.sumOfPurchases = 0;
        this.amountOfPurchases = 0;
    }

    public double getSumOfPurchases() {
        return sumOfPurchases;
    }

    public void setSumOfPurchases(double sumOfPurchases) {
        this.sumOfPurchases += sumOfPurchases;
    }

    public int getAmountOfPurchases() {
        return amountOfPurchases;
    }

    public void setAmountOfPurchases() {
        this.amountOfPurchases ++;
    }



    public boolean equals (Customers other) {
        boolean equals = false;
        if (this.userName.equals(other.userName)) {
            equals = true;
        }
        return equals;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(boolean clubMembers) {
        this.clubMembers = clubMembers;
    }
}
