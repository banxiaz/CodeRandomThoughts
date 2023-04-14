package BuilderDemo;

class User {
    private final int code = 20;
    private String userName;
    private String password;

    User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public String toString() {
        return "User{" +
                "code=" + code +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    // 构建器
    public static class UserBuilder {
        private String userName;
        private String password;

        UserBuilder() {
        }

        public UserBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this.userName, this.password);
        }

        @Override
        public String toString() {
            return "UserBuilder{" +
                    "userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}

public class Test {
    public static void main(String[] args) {
        // 内部类先收集这些属性，然后它new 一个目标对象返回
        User user = User.builder().userName("myName").password("123456").build();
        System.out.println(user);
    }
}
