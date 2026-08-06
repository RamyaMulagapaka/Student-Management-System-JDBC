package studentdb;

public class Student {
    private int id;
    private String name;
    private int age;
    
    public Student(int id,String name,int age){
    	this.id=id;
    	this.name=name;
    	this.age=age;
    }
    public Student(int id,String name) {
    	this.id=id;
    	this.name=name;
    }
    public Student(int id) {
    	this.id=id;
    }
    public void setAge(int age) {
    	this.age=age;
    }
    public void setId(int id) {
    	this.id=id;
    }
    public void setName(String name) {
    	this.name=name;
    }
    
    public int getAge() {
    	return this.age;
    }
    public int getId() {
    	return this.id;
    }
    public String getName() {
       	return this.name;
    }
    
}
