public class Node {

    int index;
    long cordinate_x;
    long cordinate_y;

    public Node(int index, long cordniate_x,long cordinate_y){
        this.index=index;
        this.cordinate_x=cordniate_x;
        this.cordinate_y=cordinate_y;
    }

    public long getCordinate_x() {
        return cordinate_x;
    }

    public void setCordinate_x(long cordinate_x) {
        this.cordinate_x = cordinate_x;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getCordinate_y() {
        return cordinate_y;
    }

    public void setCordinate_y(long cordinate_y) {
        this.cordinate_y = cordinate_y;
    }


}
