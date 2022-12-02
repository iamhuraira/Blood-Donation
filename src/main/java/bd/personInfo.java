package bd;

public class personInfo {
	
		String FirstName, LastName, UserName, Password, ConfirmPassword, Address, PhoneNumber, BloodGroup, Role;

		public personInfo(String firstName, String lastName, String userName, String password, String confirmPassword,
				String address, String phoneNumber, String bloodGroup, String role) {
			FirstName = firstName;
			LastName = lastName;
			UserName = userName;
			Password = password;
			ConfirmPassword = confirmPassword;
			Address = address;
			PhoneNumber = phoneNumber;
			BloodGroup = bloodGroup;
			Role = role;
		}

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public String getUserName() {
			return UserName;
		}

		public void setUserName(String userName) {
			UserName = userName;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public String getConfirmPassword() {
			return ConfirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			ConfirmPassword = confirmPassword;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String getPhoneNumber() {
			return PhoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			PhoneNumber = phoneNumber;
		}

		public String getBloodGroup() {
			return BloodGroup;
		}

		public void setBloodGroup(String bloodGroup) {
			BloodGroup = bloodGroup;
		}

		public String getRole() {
			return Role;
		}

		public void setRole(String role) {
			Role = role;
		}

		@Override
		public String toString() {
			return "personinfo [FirstName=" + FirstName + ", LastName=" + LastName + ", UserName=" + UserName
					+ ", Password=" + Password + ", ConfirmPassword=" + ConfirmPassword + ", Address=" + Address
					+ ", PhoneNumber=" + PhoneNumber + ", BloodGroup=" + BloodGroup + ", Role=" + Role + "]";
		}
		
		

	}


