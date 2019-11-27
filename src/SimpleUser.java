
public class SimpleUser extends User {
    private boolean voted;
    private int id;
    public SimpleUser(int id, String FirstName,String LastName,int age,String gender){
        super(id,FirstName,LastName,age,gender);
        
    }
    
    @Override
    public String toString(){
       return super.toString()+"is a simple user."+voted();
   }
    public void markVoted(){
        voted = true;
    }
    public boolean voted(){
     return voted;
    }
}
