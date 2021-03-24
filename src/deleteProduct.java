
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class deleteProduct {
    public deleteProduct(String id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dmdatabase","root","");
            Statement st = con.createStatement();
            String q = "delete from product where productid = ?";
            PreparedStatement prepStmt = con.prepareStatement(q);
            prepStmt.setString(1,id);
            prepStmt.execute();
            JOptionPane.showMessageDialog(null,"Product Deleted Sucessful");
            prepStmt.close();
            Products p = new Products();
            p.setVisible(true);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
}
