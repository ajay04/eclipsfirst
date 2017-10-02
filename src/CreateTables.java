
import java.sql.*;

public class CreateTables extends DriverConnection {
	// public CreateTables() {
	//
	// }

	public void createDatabase() {
		Connect_Driver();
		System.out.println("tables created ");
		try {

			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sql = "CREATE TABLE `Bill_Kot_no` ( `bill_no` int(11) DEFAULT NULL,`kot_no` int(11) DEFAULT NULL , `purchase_id` int(11) DEFAULT NULL  ) ";
			stmt.executeUpdate(sql);
			System.out.println("Table created");
			sql = "insert into Bill_Kot_no values(1,1,1)";
			stmt.execute(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
		try {
			sql = "CREATE TABLE `Tmbin_Admin` ( `id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`name` varchar(20) DEFAULT NULL, `mobile` decimal(10,0) DEFAULT NULL,"
					+ "`email` varchar(30) DEFAULT NULL, `business_name` varchar(20) DEFAULT NULL,"
					+ "`address` varchar(30) DEFAULT NULL, `GST_NO` varchar(10) DEFAULT NULL,"
					+ "`description` varchar(20) DEFAULT NULL, PRIMARY KEY (`id`)\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Category` ( `id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`name` varchar(20) DEFAULT NULL, PRIMARY KEY (`id`)\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Customer` ( `id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`name` varchar(20) DEFAULT NULL, `mobile` decimal(10,0) DEFAULT NULL,"
					+ "`email` varchar(30) DEFAULT NULL, `business_name` varchar(20) DEFAULT NULL,"
					+ "`address` varchar(30) DEFAULT NULL, `GST_NO` varchar(10) DEFAULT NULL,"
					+ "`description` varchar(20) DEFAULT NULL, PRIMARY KEY (`id`)\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Raw_material_category` (" + "`id` int(11) NOT NULL AUTO_INCREMENT primary key,"
					+ " `category_name` varchar(20) DEFAULT NULL) ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Unit` (" + "`unit_id` int(11) NOT NULL AUTO_INCREMENT primary key,"
					+ " `unit` varchar(10) DEFAULT NULL) ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Rawmaterial` (\n" + 
					"  `item_id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" + 
					"  `item_name` varchar(20) DEFAULT NULL,\n" + 
					"  `item_price` decimal(10,0) DEFAULT NULL,\n" + 
					"  `qty` decimal(10,0) DEFAULT NULL,\n" + 
					"  `unit_id` int(11) DEFAULT NULL,\n" + 
					"  `cgst` decimal(10,0) DEFAULT NULL,\n" + 
					"  `igst` decimal(10,0) DEFAULT NULL,\n" + 
					"  `sgst` decimal(10,0) DEFAULT NULL,\n" + 
					"  `is_sgst` tinyint(4) NOT NULL,\n" + 
					"  `raw_material_category_id` int(11) DEFAULT NULL,\n" + 
					"  FOREIGN KEY (`unit_id`) REFERENCES `Unit` (`unit_id`) ON DELETE CASCADE,\n" + 
					"  FOREIGN KEY (`raw_material_category_id`) REFERENCES `Raw_material_category` (id) ON DELETE CASCADE\n" + 
					")";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Delivery_boy` ( `boy_id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`boy_name` varchar(20) DEFAULT NULL, `mobile` decimal(10,0) DEFAULT NULL,"
					+ "`address` varchar(30) DEFAULT NULL, `city` varchar(15) DEFAULT NULL,"
					+ "`date_of_jion` date DEFAULT NULL, `salary` int(11) DEFAULT NULL,"
					+ "`shift` varchar(20) DEFAULT NULL, `status` tinyint(4) DEFAULT NULL,"
					+ "PRIMARY KEY (`boy_id`) ) ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Discount` ( `discount_id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`discount_name` varchar(20) DEFAULT NULL, `discount_type` varchar(10) DEFAULT NULL,"
					+ "`discount` decimal(4,2) DEFAULT NULL, `min_amount` int(11) DEFAULT NULL,"
					+ "PRIMARY KEY (`discount_id`) ) ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Employee` ( `code` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`name` varchar(20) DEFAULT NULL, `address` varchar(50) DEFAULT NULL,"
					+ "`mobile` decimal(10,0) DEFAULT NULL, `shift` varchar(10) DEFAULT NULL,"
					+ "PRIMARY KEY (`code`) ) ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Table` ( `table_no` int(11) NOT NULL primary key,"
					+ "`is_available` tinyint(1) NOT NULL, `TABLE_NAME` varchar(25)) ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Tax` ( `tax_id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`tax_name` varchar(20) DEFAULT NULL, `tex_percent` decimal(4,2) DEFAULT NULL,"
					+ "`description` varchar(20) DEFAULT NULL, PRIMARY KEY (`tax_id`)\n" + ")";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Vendor` ( `id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`name` varchar(20) DEFAULT NULL, `mobile` decimal(10,0) DEFAULT NULL,"
					+ "`email` varchar(30) DEFAULT NULL, `business_name` varchar(30) DEFAULT NULL,"
					+ "`address` varchar(50) DEFAULT NULL, `GST_NO` varchar(20) DEFAULT NULL,"
					+ "`description` varchar(30) DEFAULT NULL, PRIMARY KEY (`id`)\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Purchase` ( `purchase_id` int(11) NOT NULL AUTO_INCREMENT,"
					+ " `invoice_no` int(11) NOT NULL,"
					+ "`purchase_date` date DEFAULT NULL, `total_amount` decimal(10,0) DEFAULT NULL,"
					+ " `supplier_id` int(11) DEFAULT NULL, `tax_amount` decimal(10,0) DEFAULT NULL,"
					+ " PRIMARY KEY (`purchase_id`),"
					+ "  FOREIGN KEY (`supplier_id`) REFERENCES `Tmbin_Vendor` (`id`) ON DELETE CASCADE\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sql = "CREATE TABLE `Purchase_item` (  `id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "  `purchase_id` int(11) NOT NULL,`item_id` int(11) DEFAULT NULL,"
					+ "`expiry` date DEFAULT NULL,  `qty` decimal(10,0) DEFAULT NULL,   \n"
					+ "  `base_price` decimal(10,0) DEFAULT NULL, `net_amount` decimal(10,0) DEFAULT NULL,"
					+ "   `tax_amount` decimal(10,0) DEFAULT NULL,  `total_amount` decimal(10,0) DEFAULT NULL,"
					+ "  `cgst` decimal(10,0) DEFAULT NULL,`igst` decimal(10,0) DEFAULT NULL, `sgst` decimal(10,0) DEFAULT NULL,"
					+ " PRIMARY KEY (`id`),"
					+ "  FOREIGN KEY (`purchase_id`) REFERENCES `Purchase` (`purchase_id`) ON DELETE CASCADE,"
					+ "   FOREIGN KEY (`item_id`) REFERENCES `Rawmaterial` (`item_id`) ON DELETE CASCADE\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			sql = "CREATE TABLE `Tmbin_Sub_Category` ( `id` int(11) NOT NULL AUTO_INCREMENT primary key,"
					+ "`category_id` int(11) DEFAULT NULL, `name` varchar(20) DEFAULT NULL,"

					+ " FOREIGN KEY (`category_id`) REFERENCES `Tmbin_Category` (`id`) ON DELETE CASCADE\n" + ") ";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Item` ( `code` int(11) NOT NULL AUTO_INCREMENT primary key,"
					+ "`item_name` varchar(20) DEFAULT NULL, `short_name` varchar(20) DEFAULT NULL,"
					+ "`category` int(11) DEFAULT NULL, `sub_category` int(11) DEFAULT NULL,"
					+ "`price` int(11) DEFAULT NULL, `is_active` tinyint(4) DEFAULT NULL,"

					+ "FOREIGN KEY (`category`) REFERENCES `Tmbin_Category` (`id`) ON DELETE CASCADE,"
					+ "FOREIGN KEY (`sub_category`) REFERENCES `Tmbin_Sub_Category` (`id`) ON DELETE CASCADE\n" + ") ";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_KOT` ( `kot_no` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`kot_time` time DEFAULT NULL, `kot_date` date DEFAULT NULL,"
					+ "`is_active` tinyint(1) DEFAULT NULL, `amount` int(11) NOT NULL,"
					+ "`item_id` int(11) DEFAULT NULL, `table_no` int(11) DEFAULT NULL,"
					+ "PRIMARY KEY (`kot_no`), \n"
					+ "FOREIGN KEY (`item_id`) REFERENCES `Tmbin_Item` (`code`) ON DELETE CASCADE,"
					+ "FOREIGN KEY (`table_no`) REFERENCES `Tmbin_Table` (`table_no`) ON DELETE CASCADE\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_kot_item` ( `id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`kot_no` int(11) DEFAULT NULL, `item_id` int(11) DEFAULT NULL,"
					+ "`qty` int(11) DEFAULT NULL, `amount` int(11) DEFAULT NULL," + "PRIMARY KEY (`id`), \n"
					+ "FOREIGN KEY (`kot_no`) REFERENCES `Tmbin_KOT` (`kot_no`) ON DELETE CASCADE,"
					+ "FOREIGN KEY (`item_id`) REFERENCES `Tmbin_Item` (`code`) ON DELETE CASCADE\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Recipe` (  `id` int(11) NOT NULL AUTO_INCREMENT primary key,"
					+ "`recipe_id` int(11) NOT NULL,  `rawmaterial_id` int(11) NOT NULL,`qty` decimal(10,0) DEFAULT NULL,"

					+ "   FOREIGN KEY (`recipe_id`) REFERENCES `Tmbin_Item` (`code`) ON DELETE CASCADE,"
					+ " FOREIGN KEY (`rawmaterial_id`) REFERENCES `Rawmaterial` (`item_id`) ON DELETE CASCADE\n" + ") ";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_Bill` ( `bill_no` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`total_person` int(11) DEFAULT NULL, `bill_date` date DEFAULT NULL,"
					+ "`bill_time` time DEFAULT NULL, `total_amount` decimal(8,2) DEFAULT NULL,"
					+ "`table_no` int(11) DEFAULT NULL, `discount_amount` decimal(8,2) DEFAULT NULL,"
					+ "`IGST` decimal(8,2) DEFAULT NULL, `CGST` decimal(8,2) DEFAULT NULL,"
					+ "`SGST` decimal(8,2) DEFAULT NULL, `tax_rate` decimal(8,2) DEFAULT NULL,"
					+ "`order_type` varchar(15) DEFAULT NULL, `tax_amount` int(11) DEFAULT NULL,"
					+ "`discount_id` int(11) DEFAULT NULL, `customer_id` int(11) DEFAULT NULL,"
					+ "`delivery_boy_id` int(11) DEFAULT NULL, PRIMARY KEY (`bill_no`),"
					+ "FOREIGN KEY (`table_no`) REFERENCES `Tmbin_Table` (`table_no`) ON DELETE CASCADE,"
					+ "FOREIGN KEY (`delivery_boy_id`) REFERENCES `Tmbin_Delivery_boy` (`boy_id`) ON DELETE CASCADE,"
					+ "FOREIGN KEY (`customer_id`) REFERENCES `Tmbin_Customer` (`id`) ON DELETE CASCADE,"
					+ "FOREIGN KEY (`discount_id`) REFERENCES `Tmbin_Discount` (`discount_id`) ON DELETE CASCADE\n"
					+ ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			sql = "CREATE TABLE `Tmbin_bill_item` ( `id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`bill_no` int(11) DEFAULT NULL, `item_id` int(11) DEFAULT NULL,"
					+ "`qty` int(11) DEFAULT NULL, PRIMARY KEY (`id`), "
					+ "FOREIGN KEY (`bill_no`) REFERENCES `Tmbin_Bill` (`bill_no`) ON DELETE CASCADE,"
					+ "FOREIGN KEY (`item_id`) REFERENCES `Tmbin_Item` (`code`) ON DELETE CASCADE\n" + ") ";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sql = "CREATE TABLE DemoActivate ( " + "end DATE," + "dayleft int\n" + ") ";
			stmt.executeUpdate(sql);

			sql = "insert into DemoActivate values(DATEADD(day,10,getdate()), 10)";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sql = "show tables";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void UpdateDaysLeft() {

		try {
			sql = "update DemoActivate set dayleft=DATEDIFF(day,getdate(),end) where dayleft > DATEDIFF(day,getdate(),end) ";
			int i = stmt.executeUpdate(sql);
			System.out.println("Activate updated" + i);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public boolean IsActivate() {

		try {
			sql = "select getdate()<=end, dayleft from DemoActivate";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			if (rs.getInt(1) == 1 || rs.getInt(2) >= 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.getMessage();
			return true;
		}
	}
	
	public static void main(String args[])
	{
		CreateTables c= new CreateTables();
		c.createDatabase();
	}

}
