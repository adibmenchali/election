
public class Candidate extends User {
    private int nb_Votes;
    public Candidate(int id, String FirstName,String LastName,int age,String gender,int nb_Votes){
        super(id,FirstName,LastName,age,gender);
     this.nb_Votes=nb_Votes;
    }
     public void setNbv(int nb_Votes){
        this.nb_Votes=nb_Votes;
    }
   public void add_Vote(){
       nb_Votes ++;
   }
   public int getnbVotes(){
       return nb_Votes;
   }
    @Override
   public String toString(){
       return super.toString()+"has "+nb_Votes+" votes.";
   }
}
