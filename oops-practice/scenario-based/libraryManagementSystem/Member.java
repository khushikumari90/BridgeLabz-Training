package libraryManagementSystem;

public class Member extends User {
    private String memberType; // Student / Staff

    public Member(int userId, String name, String memberType) {
        super(userId, name);
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
    }

    public String getName() {
        return name;
    }
}
