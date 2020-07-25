package models.UserModel;

public class Person {

    private long userId;
    private String name;
    private String password;
    private String mail;

    public Person() {

    }

    public Person(String name, String password, String mail) {
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
