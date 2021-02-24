package main;

import java.util.Scanner;
import dao.StudentDao;

public class JDBCconnect {
    public static void main(String[] args) throws Exception {
        StudentDao st= new StudentDao();

        //Student s=st.getStudent(2);

        //System.out.println(s.sname);
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the id : ");
        int id=scan.nextInt();
        System.out.println("Enter the name");
        scan.nextLine();
        String name=scan.nextLine();


        st.updateStudent(id,name);

    }
}
