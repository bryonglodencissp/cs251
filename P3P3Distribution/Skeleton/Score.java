public class Score implements Comparable<Score> {
    //instance variables
    String uid;
    int score;

    //constructors
    public Score() {
        this.uid = null;
        this.score = -1;
    }

    public Score(String uid, int score) {
        this.uid = uid;
        this.score = score;
    }

    //methods
    public String getUid() { return uid; }

    public int getScore() { return score; }

    public int compareTo(Score o) {
        if(o != null) {
            return this.score - o.getScore();
        }
        return this.score;
    }

    public boolean equals(Object anObject) {
        if(anObject instanceof Score && anObject != null)
            return this.score == ((Score)anObject).getScore();
        return false;
    }

    public String toString() {
        return uid + " " + score;
    }
}