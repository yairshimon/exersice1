public class Customers extends User{
    private boolean clubMembers;
    private double sumOfPurchases;
    private int amountOfPurchases;

    @Override
    public String toString() {
        return ( "Customers{" + super.toString() +
                "clubMembers=" + clubMembers +
                ", sumOfPurchases=" + sumOfPurchases +
                ", amountOfPurchases=" + amountOfPurchases +
                '}');
    }

    public Customers(String firstName, String lastName, String userName, String password, boolean clubMembers) {
        super(firstName,lastName,userName,password);
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

    public boolean isClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(boolean clubMembers) {
        this.clubMembers = clubMembers;
    }
}
