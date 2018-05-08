package com.ziv.bean; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月23日   下午6:10:10 
 * 类说明 :
 * 
*/
public class Employee {
	private String name;
	private Integer age;
	private Double sto;
	private Status status;
	
	public enum Status{
		FREE,BUSY,VOCATION;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSto() {
		return sto;
	}
	public void setSto(Double sto) {
		this.sto = sto;
	}
	/**
	 * 
	 */
	public Employee() {	}
	public Employee(String name, Integer age, Double sto) {
		this.name = name;
		this.age = age;
		this.sto = sto;
	}
	public Employee(String name, Integer age, Double sto, Status status) {
		this.name = name;
		this.age = age;
		this.sto = sto;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", sto=" + sto + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sto == null) ? 0 : sto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sto == null) {
			if (other.sto != null)
				return false;
		} else if (!sto.equals(other.sto))
			return false;
		return true;
	}
	
}
 