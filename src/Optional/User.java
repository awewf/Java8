package Optional;

/**
 * @ClassName User
 * @Description TODO
 * @Author GuanLS
 * @Date 2019/8/26 17:28
 * @Version 1.0
 **/

public class User {
    private String userName;
    private String password;

    public User(String userName,String password){
        this.password = password;
        this.userName = userName;
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
}
