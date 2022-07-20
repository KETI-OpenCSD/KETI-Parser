package keti.opencsd.config;

public class IDGenerator {
    private int QueryID;
    private int WorkID;

    public IDGenerator(){
        this.QueryID = 0;
        this.WorkID = 0;
    }

    public String MakeSnippetUUID(int QID, int WID){
        String snippet = "Snippet";
        return snippet +QID+WID;
    }

    public int getQueryID() {
        return QueryID;
    }

    public int getWorkID() {
        return WorkID;
    }
    public void WorkDone(){
        this.WorkID++;
    }

    public void QueryDone(){
        this.WorkID = 0;
        this.QueryID++;
    }
}
