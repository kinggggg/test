package com.zeek.javatest.parent.build;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-10-21
 */
public class User {

    private Integer id;
    private String name;
    private String address;

    private User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    private User(User origin) {
        this.id = origin.id;
        this.name = origin.name;
        this.address = origin.address;
    }

    public static class Builder {
        private User target;

        public Builder() {
            this.target = new User();
        }

        public Builder id(Integer id) {
            target.id = id;
            return this;
        }

        public Builder name(String name) {
            target.name = name;
            return this;
        }

        public Builder address(String address) {
            target.address = address;
            return this;
        }

        public User build() {
            return new User(target);
        }
    }

    public static void main(String[] args) {
        Builder builder = new User.Builder();
        User user1 = builder.name("zhangsan")
                .address("北京")
                .build();
        System.out.println(user1);

        Builder builder2 = new User.Builder();
        User user2 = builder2.build();
        System.out.println(user2);
    }

}
