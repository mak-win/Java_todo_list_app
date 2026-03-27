import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Iterator;
class Task{
    String description;

    boolean completed;
    public Task(String description, boolean completed){
this.description = description;
this.completed = completed;
    }


}
public class Main {
    public static void main(String[] args) {

Scanner input = new Scanner(System.in);

boolean addTask = true;
        ArrayList<Task> taskList = new ArrayList<>();
while (addTask){
    System.out.println("Enter a task: ");
    String description = input.nextLine();
    Task task = new Task(description, false);
    taskList.add(task);
    System.out.println("Do you want to mark a task completed? If so, Enter task number and if not, Enter 0");
    int answer1 = input.nextInt();
    input.nextLine();//consumes the leftover new line so that the next input.nextLine() works properly
    if (answer1 > 0 && answer1 <= taskList.size()){
        taskList.get(answer1-1).completed = true;//ArrayList indexing starts at 0. user is selecting a number from the ArrayList
    }else if(answer1 == 0){

    }
    for (int index=0; index< taskList.size();index++){
       task = taskList.get(index);
        if(task.completed){
            System.out.println((index + 1) + ". [x]" + task.description);
        }else{
            System.out.println((index + 1) + ". [ ]" + task.description);
        }

    }


    try(BufferedWriter output = new BufferedWriter(new FileWriter("todolist.txt", true ))){
output.write(task.description + "," + task.completed);

output.newLine();
        System.out.println("Successfully added task to file");
    }catch (IOException e){
        System.out.println("Error writing file");
    }
    System.out.println("Do you want to add another task? Yes/No");
    String answer2 = input.nextLine();
    addTask = answer2.equalsIgnoreCase("yes");

    }

}


    }
