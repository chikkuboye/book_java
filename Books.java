import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                    break;
                case 3:
                    System.out.println("Search");
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
