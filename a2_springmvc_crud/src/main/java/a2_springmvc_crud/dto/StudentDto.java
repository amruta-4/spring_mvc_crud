package a2_springmvc_crud.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDto {
	@Id
	private int sid;
	private String sname;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", sname=" + sname + "]";
	}
	

}
