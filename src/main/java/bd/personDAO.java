package bd;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class personDAO {

	Connection con;

	public personDAO() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/blood_donor";
			con = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public personInfo login(String u, String p, String r) {
		personInfo person = null;
		try {

			String query = "select * from information where Username = ? and password = ? and Role = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, u);
			ps.setString(2, p);
			ps.setString(3, r);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				String fn = rs.getString("FirstName");
				String ls = rs.getString("LastName");
				String un = rs.getString("Username");
				String pass = rs.getString("Password");
				String cpass = rs.getString("ConfirmPassword");
				String add = rs.getString("Address");
				String ph = rs.getString("Phone");
				String bg = rs.getString("BloodGroup");
				String role = rs.getString("Role");
				person = new personInfo(fn, ls, un, pass, cpass, add, ph, bg, role);

			}

		} catch (Exception e) {

		}
		return person;

	}

	public Boolean username(String u) {
		try {

			String query = "select Username from information where Username=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean signup(String fn, String ln, String un, String p, String cp, String add, String ph, String bg,
			String r) {
		personInfo person = null;
		try {
			Statement st = con.createStatement();

			String query = "INSERT INTO information(FirstName,LastName,Username,Password,ConfirmPassword,Address,Phone,BloodGroup,Role)VALUES('"
					+ fn + "','" + ln + "', '" + un + "','" + p + "','" + cp + "','" + add + "','" + ph + "','" + bg
					+ "','" + r + "') ";
			int rs = st.executeUpdate(query);

			if (rs == 1) {

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	public Boolean delete(String u) {
		try {

			Statement st = con.createStatement();

			String query = "DELETE FROM information WHERE Username='" + u + "';";

			System.out.println(query);

			int rs = st.executeUpdate(query);

			if (rs == 1) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public Persondata update(String u) {
		Persondata p = null;
		try {

			Statement st = con.createStatement();

			String query = "Select * FROM information WHERE Username='" + u + "'";

			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String uname1 = rs.getString("Username");
				String pass = rs.getString("Password");
				String address = rs.getString("Address");
				String phone = rs.getString("Phone");
				String blood = rs.getString("BloodGroup");

//                     System.out.print(query);
				p = new Persondata();
				p.setFirstName(fname);
				p.setLastName(lname);
				p.setUserName(uname1);
				p.setPassword(pass);
				p.setAddress(address);
				p.setPhone(phone);
				p.setBloodGroup(blood);
//                     System.out.print(fname);
//                     System.out.print(lname);
//                     System.out.print(uname1);
//                     System.out.print(pass);
//                     System.out.print(address);
//                     System.out.print(phone);
//                     System.out.print(blood);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	public boolean UpdateinDB(String fn, String ln, String un, String p, String add, String ph, String bg) {
		personInfo person = null;
		try {
			Statement st = con.createStatement();

			String query = "UPDATE information SET FirstName = '"+fn+"', LastName = '"+ln+"',Password = '"+p+"',ConfirmPassword = '"+p+"',Address = '"+add+"',Phone = '"+ph+ "',BloodGroup = '"+bg+"' WHERE Username = '"+un+"'; ";
			int rs = st.executeUpdate(query);

			if (rs == 1) {

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}
	public ArrayList  Adminview(String role) {
		ArrayList personList = new ArrayList();
		personInfo p = null;
		try {
				Statement st = con.createStatement();
				String query = "select * from information where Role = '"+role+"'";
			System.out.print(query);
            

			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String uname1 = rs.getString("Username");
				String pass = rs.getString("Password");
				String cpass = rs.getString("ConfirmPassword");
				String address = rs.getString("Address");
				String phone = rs.getString("Phone");
				String blood = rs.getString("BloodGroup");
				String rol = rs.getString("Role");
				
				
				p =  new personInfo(fname, lname, uname1, pass, cpass, address, phone, blood, rol);
				
				personList.add(p);
				

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return personList;
	}

	public ArrayList  SearchDonor(String bg) {
		ArrayList personList = new ArrayList();
		personInfo p = null;
		try {
				Statement st = con.createStatement();
//				String query = "select * from information where Role = '"+role+"'";
				String query = "select * from information where BloodGroup = '"+bg+"' and Role = 'Donor' ";
			System.out.print(query);
            

			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String uname1 = rs.getString("Username");
				String pass = rs.getString("Password");
				String cpass = rs.getString("ConfirmPassword");
				String address = rs.getString("Address");
				String phone = rs.getString("Phone");
				String blood = rs.getString("BloodGroup");
				String rol = rs.getString("Role");
				
				
				p =  new personInfo(fname, lname, uname1, pass, cpass, address, phone, blood, rol);
				
				personList.add(p);
				

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return personList;
	}
	
	public Boolean deleteuser(String u, String pass) {
		try {

			Statement st = con.createStatement();

			String query = "DELETE FROM information WHERE Username='"+u+"' and Password='"+pass+"';";

			System.out.println(query);

			int rs = st.executeUpdate(query);

			if (rs == 1) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public Persondata updateuser(String u, String pass1) {
		Persondata p = null;
		try {

			Statement st = con.createStatement();

			String query = "Select * FROM information WHERE Username='"+u+"' and Password='"+pass1+"'";

			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				String fname = rs.getString("FirstName");
				String lname = rs.getString("LastName");
				String uname1 = rs.getString("Username");
				String pass = rs.getString("Password");
				String address = rs.getString("Address");
				String phone = rs.getString("Phone");
				String blood = rs.getString("BloodGroup");

//                     System.out.print(query);
				p = new Persondata();
				p.setFirstName(fname);
				p.setLastName(lname);
				p.setUserName(uname1);
				p.setPassword(pass);
				p.setAddress(address);
				p.setPhone(phone);
				p.setBloodGroup(blood);
//                     System.out.print(fname);
//                     System.out.print(lname);
//                     System.out.print(uname1);
//                     System.out.print(pass);
//                     System.out.print(address);
//                     System.out.print(phone);
//                     System.out.print(blood);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}



}
