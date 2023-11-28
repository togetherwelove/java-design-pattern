package design.pattern.app.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
	public User() {
	}
	
	public User(long id) {
		this.id = id;
	}
	public User(long id, String name) {
		this(id);
		this.name = name;
	}
	public User(long id, String name, String birth) {
		this(id, name);
		this.birth = birth;
	}
	public User(long id, String name, String birth, String gender) {
		this(id, name, birth);
		this.gender = gender;
	}

	private Long id;
	private String name;	
	private String birth;
	private String gender;
	
//	public Long getId() {
//		return id;
//	}
//	public String getName() {
//		return name;
//	}
//	public String getBirth() {
//		return birth;
//	}
//	public String getGender() {
//		return gender;
//	}
//	
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setBirth(String birth) {
//		this.birth = birth;
//	}
//	public void setGender(String gender) {
//		this.gender = gender;
//	}
}
