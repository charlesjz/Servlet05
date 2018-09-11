package lindaWu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeneralReport {
       static final String JDBC_DRIVER = "com.amazon.redshift.jdbc42.Driver";  
       static final String DB_URL = "jdbc:redshift://analytics.cxlxk6kx9zhu.us-east-1.redshift.amazonaws.com:5439/billingsnapshots";

       //  Database credentials
       static final String USER = "bsadm";
       static final String PASS = "f56e0DAc415a4d";
       
       @SuppressWarnings("resource")
       
       public static void main(String[] args)  throws IOException {
       Connection conn = null;
       Statement stmt = null;
       //Defile the reading file
       File file = new File ("D:\\StagWell\\PRJ_5_ HRSMOB\\Count_Modifies\\Column_Names_Wave28.xlsx");
       FileInputStream fin=new FileInputStream(file);
       
       XSSFWorkbook workbook = new XSSFWorkbook(fin);
       XSSFSheet fieldnamesheet=workbook.getSheet("Column_Names");
      
      //Defile the output file
       FileOutputStream fot=new FileOutputStream(file);
       Cell cell = null;
       
      
       
       // Get each field name
       String fn = null;
       int len = fieldnamesheet.getLastRowNum();
      
       // Define Provider
       int p_id=1;
       String[] providers = {"ATT", "Sprint", "TMobile", "Verizon"};
       
       try{
          //STEP 2: Register JDBC driver
          Class.forName(JDBC_DRIVER);

          //STEP 3: Open a connection
          System.out.println("Connecting to database...");
          conn = DriverManager.getConnection(DB_URL,USER,PASS);

          //STEP 4: Execute a query
          System.out.println("Creating statement...");
          stmt = conn.createStatement();
          ResultSet rs = null;
          String sql=null;
          int i;
          //Loop for provider
          for(p_id=1;p_id<5;p_id++) {
              
         //Loop for fields
          for (i=0; i<len; i++) {
               fn = fieldnamesheet.getRow(i).getCell(0).getStringCellValue();
          
          sql = "select count(cl.*) as " + fn + "_changes, \r\n" + 
                  "(select count(*) from billing_data where survey = 'selfserve/53d/180622' and provider ="+ p_id+") as Total_survey \r\n" + 
                  "from changes_log cl \r\n" + 
                  "join billing_data bd on cl.uuid = bd.uuid \r\n" + 
                  "where survey = 'selfserve/53d/180622' and provider = "+ p_id + "\r\n" + 
                  "and cl.field_name = " + "'" + fn + "'"+" and cl.old_value <> cl.new_value";
          
          
          rs = stmt.executeQuery(sql);
          int field_modified_numbers =0;
          int total=0;

          //STEP 5: Extract data from result set
          
          while(rs.next()){
             //Retrieve by column name
             field_modified_numbers  = rs.getInt(fn+"_changes");
             total = rs.getInt("Total_survey");

             //Display values
            /* System.out.print(fn+"_modified_numbers: " + field_modified_numbers );
             System.out.print(", " + providers[p_id-1]+"_Total: " + total);
             System.out.println(); */
             
            // cell=fieldnamesheet.createRow(i).createCell(p_id);
             cell=fieldnamesheet.getRow(i).getCell(p_id);
             cell.setCellValue(Integer.toString(field_modified_numbers));
           
          }
          }//end fields iterator
          }//end provider iterator
          workbook.write(fot);
          //STEP 6: Clean-up environment
          fin.close();
          fot.close();
          rs.close();
          stmt.close();
          conn.close();
          
       }catch(SQLException se){
          //Handle errors for JDBC
          se.printStackTrace();
       }catch(Exception e){
          //Handle errors for Class.forName
          e.printStackTrace();
       }finally{
          //finally block used to close resources
          try{
             if(stmt!=null)
                stmt.close();
          }catch(SQLException se2){
          }// nothing we can do
          try{
             if(conn!=null)
                conn.close();
          }catch(SQLException se){
             se.printStackTrace();
          }//end finally try
       }//end try 
       
       System.out.println("Goodbye!");
    }//end main
    }//end
