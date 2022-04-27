public class Workers extends Customers {
    private TypeWorker typeWorker;

    public Workers(String firstName, String lastName, String userName, String password, boolean clubMembers, TypeWorker typeWorker) {
        super(firstName, lastName, userName, password, clubMembers);
        this.typeWorker = typeWorker;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "typeWorker=" + typeWorker +
                '}';
    }

    public TypeWorker getTypeWorker() {
        return typeWorker;
    }

    public void setTypeWorker(TypeWorker typeWorker) {
        this.typeWorker = typeWorker;
    }
}
