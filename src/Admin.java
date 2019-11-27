
public class Admin extends User {
    public Admin(int id, String FirstName,String LastName,int age,String gender){
        super(id,FirstName,LastName,age,gender);
    }
    @Override
    public String toString(){
       return super.toString()+" is an admin.";
   }
    
}
