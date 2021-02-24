package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import domain.Student;

public class StudentDao {
    public Student getStudent(int userid) throws Exception {
        Student s= new Student();
        s.userid=userid;
        Class.forName("com.mysql.jdbc.Driver");

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/example?useSSL=false","root","");


        String query="select username from student where userid="+userid;
        Statement st=con.createStatement();

        ResultSet rs=st.executeQuery(query);

        rs.next();
        s.sname=rs.getString(1);

        return s;
    }

    public void updateStudent(int userid,String name) throws Exception{
        Student st= new Student();
        st.userid=userid;
        st.sname=name;

        /**
         * For setting the query
         */
        String query="insert into student values(?,?)";

        Class.forName("com.mysql.jdbc.Driver");

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/example?useSSL=false","root","");

        PreparedStatement stt=con.prepareStatement(query);

        stt.setInt(1,st.userid);
        stt.setString(2,st.sname);

        int change=stt.executeUpdate();

        System.out.println("row affected: "+change);
    }


}
