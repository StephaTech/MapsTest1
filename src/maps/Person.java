package maps;

public class Person {

        private static int counter = 1001;
        private int id;
	private String name;
	private int age;
        
        public Person() {}
        
        public Person(String name, int age) {
		this.name = name;
                this.age = age;
		this.id = counter++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
        
        public int getAge(){
                return age;
        }
        
        public void setAge(){
                this.age = age;
        }
        
        public int getId(){
                return this.id;
        }

	@Override
	public String toString() {
		return "ID: " + this.id + " NAME: " + this.name + " AGE: " + this.age;
	}
	
}
