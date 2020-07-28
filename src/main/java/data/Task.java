package data;
//Will be the task object for Task data
public class Task {
    int id, alertTime;
    String taskName, hexColour;
    public Task(int id, String taskName, int alertTime, String hexColour){
        this.id = id;
        this.taskName = taskName;
        this.alertTime = alertTime;
        this.hexColour = hexColour;
    }

    public void printData(){
        System.out.println(id+":"+taskName+":"+alertTime+":"+hexColour);
    }
}
