import java.sql.*;
import java.util.Scanner;

public class Books {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true){
            System.out.println("Enter the option below");
            System.out.println("1 :Insert");
            System.out.println("2 :View");
            System.out.println("3 :Search");
            System.out.println("4 :Update");
            System.out.println("5 :Delete");
            System.out.println("6 :Exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Insert");
                    System.out.println("Book name");
                    String name = sc.next();
                    System.out.println("Book category");
                    String categ = sc.next();
                    System.out.println("Charge per day");
                    int charge = sc.nextInt();
                    System.out.println("Author name");
                    String Author = sc.next();
                    System.out.println("Established date");
                    String date = sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
                        String sql = "INSERT INTO `books_detail`(`book_name`, `book_categ`, `charge_p_day`, `Author_name`, `Established_date`) VALUES(?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,categ);
                        stmt.setInt(3,charge);
                        stmt.setString(4,Author);
                        stmt.setString(5,date);
                        stmt.executeUpdate();

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
                        String sql = "SELECT `book_name`, `book_categ`, `charge_p_day`, `Author_name`, `Established_date` FROM `books_detail`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            name = rs.getString("book_name");
                            categ = rs.getString("book_categ");
                            charge = rs.getInt("charge_p_day");
                            Author = rs.getString("Author_name");
                            date = rs.getString("Established_date");
                            System.out.println("name="+name);
                            System.out.println("category="+categ);
                            System.out.println("Author name ="+Author);
                            System.out.println("Established date ="+date+'\n');

                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Search");
                    System.out.println("Enter the book id");
                    int id = sc.nextInt();
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "");
                        String sql = "SELECT `book_name`, `book_categ`, `charge_p_day`, `Author_name`, `Established_date` FROM `books_detail` WHERE `id`="+id;
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            name = rs.getString("book_name");
                            categ = rs.getString("book_categ");
                            charge = rs.getInt("charge_p_day");
                            Author = rs.getString("Author_name");
                            date = rs.getString("Established_date");
                            System.out.println("name="+name);
                            System.out.println("category="+categ);
                            System.out.println("Author name ="+Author);
                            System.out.println("Established date ="+date+'\n');
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Update");
                    break;
                case 5:
                    System.out.println("Delete");
                    break;
                case 6:
                    System.exit(0);

            }

        }

    }
}
