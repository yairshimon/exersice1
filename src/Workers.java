public class Workers extends User {
    private TypeWorker typeWorker;

    public Workers(String firstName, String lastName, String userName, String password, TypeWorker typeWorker) {
        super(firstName,lastName,userName,password);
        this.typeWorker = typeWorker;
    }


    public TypeWorker getTypeWorker() {
        return typeWorker;
    }

    public void setTypeWorker(TypeWorker typeWorker) {
        this.typeWorker = typeWorker;
    }
}
