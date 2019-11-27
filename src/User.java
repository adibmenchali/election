
public class User {
    private int id;
    private String FirstName;
    private String LastName;
    private int age;
    private String gender;
    public User(int id,String FirstName,String LastName,int age,String gender){
        this.id=id;
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.age=age;
        this.gender=gender;
    }
    public String getFN(){
        return FirstName;
    }
    public String getLN(){
        return LastName;
    }
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    @Override
   public String toString(){
       return FirstName+" "+LastName;
   }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}