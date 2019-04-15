public class FloorsArrayLink{
    private double key;
    private int arrSize;
    private FloorsArrayLink[] prevArr;
    private FloorsArrayLink[] nextArr;

    public FloorsArrayLink(double key, int arrSize){
        this.key = key;
        this.arrSize = arrSize;
        prevArr = new FloorsArrayLink[arrSize];
        nextArr = new FloorsArrayLink[arrSize];
        //needs definition for the arrays
    }

    public double getKey(){
        return this.key;
    }

    public FloorsArrayLink getNext(int i){
        return nextArr[i];
    }

    public FloorsArrayLink getPrev(int i){
        return prevArr[i];
    }

    private void setNext(int i, FloorsArrayLink next){
        nextArr[i] = next;
    }

    private void setPrev(int i, FloorsArrayLink prev){
        nextArr[i] = prev;
    }

    public int getArrSize(){
        return this.arrSize;
    }
}
