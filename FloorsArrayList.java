public class FloorsArrayList {
    FloorsArrayLink first;
    FloorsArrayLink last;

    public FloorsArrayList(int N){
        first = new FloorsArrayLink(Double.NEGATIVE_INFINITY, N+1);
        first = new FloorsArrayLink(Double.POSITIVE_INFINITY, N+1);

    }

    public FloorsArrayLink lookup(double key){

    }

    public void insert(double key, int arrSize) {
        return
    }

    public void remove (FloorsArrayLink toRemove){
        af
    }

    public double successor(FloorsArrayLink link){
        return link.getNext(0).getKey();
    }

    public double predecessor(FloorsArrayLink link){
        return link.getPrev(0).getKey();
    }

    public double minimum(){
        return this.first.getNext(0).getKey();
    }

    public double maximum(){
        return this.last.getPrev(0).getKey();
    }
}
