package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kioskapp.order.Order;
import kioskapp.ordereditem.OrderedItem;

public class OrderedItemController {

    private DatabaseConnection db;

    public OrderedItemController (){
         db=new DatabaseConnection();
    }


    public void insertOrderedItem (Order order,OrderedItem OI){
    	
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int status =0;
       
        String sql="INSERT INTO ordereditem (ItemProduct,Quantity,SubTotalAmount,`Order`) "+
        "VALUES (?,?,?,?);";

        try {
		    conn = db.getConnection();
            ps = conn.prepareStatement(sql);

            	ps.setInt(1, OI.getItemID());
            	ps.setInt(2, OI.getQuantity());
            	ps.setFloat(3, OI.getSubTotalAmount());
            	ps.setInt(4, order.getOrderId());
            	status += ps.executeUpdate();
            

            if (status != order.getOrderedItems().size())
                System.out.println("Some product is not added into database");

	    } catch (ClassNotFoundException | SQLException e) {
		
		    e.printStackTrace();
	    }
        finally{
        
				try {
                        if (ps!= null)
                            ps.close();
                        if (rs!=null)
                            rs.close();
                        if(conn!=null)
					        conn.close();
                            
				} catch (SQLException e) {
					
					e.printStackTrace();
				}  
        } 

    }

}
