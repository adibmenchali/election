
import java.util.ArrayList;


public class Directory {
    private ArrayList <User> List;
    public Directory(){
        List=new ArrayList<>();
    }
    public boolean exists(User x){
        return List.contains(x);
    }
    public void addUser(User x){
        List.add(x);
    }
   /* public boolean isAdmin(int id){
        boolean x=false;
        for(int i=0;i<List.size();i++){
            if(List.get(i).getId()==id){
                x = true;
            }
        }
        return x;
    }
    public boolean isSimpleUser(int id){
        boolean x=false;
        for(int i=0;i<List.size();i++){
            if(List.get(i).getId()==id){
                x = List.get(i) instanceof SimpleUser;
            }
        }
        return x;
    }
    public boolean isCandidate(int id){
        boolean x=false;
        for(int i=0;i<List.size();i++){
            if(List.get(i).getId()==id){
                x = List.get(i) instanceof Candidate;
            }
        }
        return x;
    }*/
        public int getnbCandidates(){
        int x=0;
        for(int i=0;i<List.size();i++){
             if( List.get(i) instanceof Candidate){
                    x++;
                }
            }
        return x;
        }
        
    }
    

