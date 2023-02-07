package ua.com.alevel;

public class IfOrSwitch {

    public void test() {
        Student st = new Student();
        st.setAge(24);
        System.out.println("st = " + st.firstName);
        System.out.println("st = " + st.lastName);
        System.out.println("st = " + st.fullName());
        System.out.println("st = " + st.age);

        if (st.age < 19) {
            System.out.println("student is valid: < 19");
        } else if (st.age > 19) {
            System.out.println("student is valid: > 19");
        } else {
            System.out.println("student is not valid");
        }

        switch (st.age) {
            case 19, 20, 21, 22 : {
                System.out.println("student is valid: == 19");
            } break;
            case 23, 24, 25: {
                System.out.println("student is valid: == 20");
            } break;
            case 26 : {
                System.out.println("student is valid: == 26");
            } break;
        }

        switch (st.age) {
            case 19, 20, 21, 22 -> System.out.println("student is valid: == 19");
            case 23, 24, 25 -> System.out.println("student is valid: == 20");
            case 26 -> System.out.println("student is valid: == 26");
        }
    }
}
