package Models.Users;

public class User {
    private String name, nickname, password;
    private int age;
    private Boolean isMaster;

    public User(){
        this.name = "";
        this.nickname = "";
        this.age = 0;
        this.isMaster = false;
    }

    // Getters
    public int getAge() {
        return age;
    }
    public Boolean getIsMaster() {
        return isMaster;
    }
    public String getName() {
        return name;
    }
    public String getNickname() {
        return nickname;
    }
    public String getPassword() {
        return password;
    }

    // Setters
    public void setAge(int age) {
        this.age = age;
    }
    public void setIsMaster(Boolean isMaster) {
        this.isMaster = isMaster;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
