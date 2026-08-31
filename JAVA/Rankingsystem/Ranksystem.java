import java.util.HashMap;
import java.util.PriorityQueue;

public class Ranksystem{

    class Pair{
        char character;
        int[] arr;
        Pair(char ch,int arr[]){
            this.arr=arr;
        }
    }


    public String rankTeam(String[] votes){

        PriorityQueue<Pair> pq= new PriorityQueue<>(
            (a,b)->{
                for(int i = 0; i<votes[0].length();i++){
                    if(a.arr[i]!=b.arr[i]){
                        return a.arr[i]-b.arr[i];
                    }
                }

                return a.character-b.character;
            }
        );

        HashMap<Character,int[]> mpp= new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char ch = vote.charAt(i) ;
                if (!mpp.containsKey(ch)) {
                     mpp.put(ch, new int[vote.length()]);
                    }
                    mpp.get(ch)[i]++;
            }
        }

        for(Character ch:mpp.keySet()){
            pq.offer(new Pair(ch, mpp.get(ch)));
        }

        String ans ="";

        while(!pq.isEmpty()){
            Pair p= pq.poll();
            ans+=p.character;
        }


        return ans;
    }
    public static void main(String[] args) {



    }   
}

