package beans;

public class Users {
	
	private int UserId;
	private String Name;
	private int Age;
	private int Sex;
	private String Area;
	private int tel;
	
	public Users(){}

	public Users(int userId, String name, int age, int sex, String area, int tel) {
		UserId = userId;
		Name = name;
		Age = age;
		Sex = sex;
		Area = area;
		this.tel = tel;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getSex() {
		return Sex;
	}

	public void setSex(int sex) {
		Sex = sex;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}
	
	
	
	
}
