package tw.group4._18_._18_io;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

import tw.group4._18_.seller.model.Course;

public class CourseDataInputCSV {
	public static final String UTF8_BOM = "\uFEFF";

	public void execute18() {
		String line = "";
		int count = 0;
		try (Connection con = DriverManager.getConnection(Oracle.getDburlOracle(), Oracle.getUseridOracle(),
				Oracle.getPswdOracle() );
				Statement stmt = con.createStatement();) {

			try {
				stmt.executeUpdate(Oracle.getDropTableCourseCart());
				System.out.println("Drop CourseCart Table");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stmt.executeUpdate(Oracle.getCreateCourseCart());
			System.out.println("Create CourseCart Table");

			try {
				stmt.executeUpdate(Oracle.getDropTableCourse());
				System.out.println("Drop Course Table");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stmt.executeUpdate(Oracle.getCreateCourse());
			System.out.println("Create Course Table");



			try {
				stmt.executeUpdate(Oracle.getDropTableCourseOrderItems());
				System.out.println("Drop CourseOrderItems Table");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			
			try {
				stmt.executeUpdate(Oracle.getDropTableCourseOrders());
				System.out.println("Drop CourseOrders Table");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stmt.executeUpdate(Oracle.getCreateCourseOrders());
			System.out.println("Create CourseOrders Table");

			stmt.executeUpdate(Oracle.getCreateCourseOrderItems());
			System.out.println("Create CourseOrderItems Table");

			
			File file = new File("inputCSV/SearchShowAction.csv");

			try (FileInputStream fis = new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(fis, "big5");
					BufferedReader br = new BufferedReader(isr);) {
				con.setAutoCommit(false);
				String jdbc_insert_sql = "INSERT INTO Course "
						+ " (coTitle, coAct_Type,  coAct_Location, coLocation_Name, coPrice, coAct_Date, coAct_Time, coEnd_Date, coEnd_Time, coAct_Description, coNum, coAct_Image) "
						+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				try (PreparedStatement pstmt = con.prepareStatement(jdbc_insert_sql);) {

					String lineText = null;
					while ((line = br.readLine()) != null) {
						System.out.println("line=" + line);

						if (line.startsWith(UTF8_BOM)) {
							line = line.substring(1);
						}
						String[] token = line.split(",");
						Course co = new Course();
						if (token.length==0) break;
						String coId = token[0];
						String coTitle = (token[1]);
						String coAct_Type = (token[2]);
						String coAct_Location = (token[3]);
						String coLocation_Name = (token[4]);
						String coPrice = (token[5]);
						String coAct_Date = (token[6]);
						String coAct_Time = (token[7]);
						String coEnd_Date = (token[8]);
						String coEnd_Time = (token[9]);
						String coAct_Description = (token[10]);
						String coNum = (token[11]);
						String coAct_Image = (token[12]);
//						byte[] byt = ImageProcess.fileToByte(token[8].trim());
						count++;

//						pstmt.setString(1, coId);
						pstmt.setString(1, coTitle);
						pstmt.setString(2, coAct_Type);
						pstmt.setString(3, coAct_Location);
						pstmt.setString(4, coLocation_Name);
						pstmt.setInt(5, Integer.parseInt(coPrice));
						pstmt.setString(6, coAct_Date);
						pstmt.setString(7, coAct_Time);
						pstmt.setString(8, coEnd_Date);
						pstmt.setString(9, coEnd_Time);
						pstmt.setString(10, coAct_Description);
						pstmt.setString(11, coNum);
												
						byte[] bt = null ;
						bt = fileTobyte("WebContent/WEB-INF/pages/images/18/" + coAct_Image) ; //往上找
					
						pstmt.setBytes(12, bt);

						pstmt.addBatch();
						pstmt.executeBatch();
						pstmt.clearBatch();
						

						System.out.println(coId + " " + coTitle + " " + coAct_Type + " " + coAct_Location + " " + coLocation_Name + " "
								+ coPrice + " " + coAct_Date + " " + coAct_Time + " " + coEnd_Date + " " + coEnd_Time + " " + coAct_Description + " " + coNum + " ");
						System.out.println("-----");
					}

					System.out.println("--------------------------------");
					con.commit();
					System.out.println("匯入 " + count + " 筆");
				}

				System.out.println("COURSE TABLE CREATE!");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	
	public byte[] fileTobyte(String imageFileName) throws IOException, SQLException {
		
		//上方路徑
		FileInputStream fis1 = new FileInputStream(imageFileName);
		   
		   BufferedImage image1 = ImageIO.read(fis1);
		   
		//   再把BufferedImage轉為ByteArrayOutputStream (baos)
		   ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		   ImageIO.write(image1, "jpeg", baos1);
		   
		//   ByteArrayOutputStream轉ByteArray (ba)
		   byte[] ba1 = baos1.toByteArray();
		  
		return ba1;
	}
}
