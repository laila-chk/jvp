import java.util.Scanner;

public class Program {

  public static int getIndex(char[] line) {
    if(line[2] == 'M' && line[3] == 'O')
      return 0;
    if(line[2] == 'T' && line[3] == 'U')
      return 1;
    if(line[2] == 'W' && line[3] == 'E')
      return 2;
    if(line[2] == 'T' && line[3] == 'H')
      return 3;
    if(line[2] == 'F' && line[3] == 'R')
      return 4;
    if(line[2] == 'S' && line[3] == 'A')
      return 5;
    return 6;
  }

  public static int getTotalClasses(int[] days){
    
    int total = 0;
    for (int i = 1; i < 31; i++){
      total += days[(i + 0) % 7];
    }
    return total;
  }

  //Mike 2 28 NOT_HERE
  //John 4 9 HERE
  public static void recordAttendance(String[][] month, String[] stds, String line){
    //get student's id..
    String std = "";

    for (char c : line.toCharArray()){
      if(c == ' ')
        break;
      std += c;
    }
    int i = 0;
    while(!std.equals(stds[i]))
      i++;
    System.out.println("we'll use student: " + std + "whos id id : " + i);

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] students = new String[10];
    String[] timetable = new String[10];
    int[] days = new int[7];
    String line = sc.nextLine();
    int i = 0;
    while (!line.equals(".")){
      students[i++] = line;
      line = sc.nextLine();
    } 
    int totStd = i;
    line = sc.nextLine();
    i = 0;
    while (!line.equals(".")){
      timetable[i++] = line; // 2 MO
      days[getIndex(line.toCharArray())]++;
      line = sc.nextLine();
    } 

    int totClasses = getTotalClasses(days);
    //create  time table using totStd & totClasses:
    String [][] attendance = new String[totStd][totClasses];
    String [][] month = new String[totStd][30][6];  // we'll need to mark days we should't print 

    line = sc.nextLine();
    while (!line.equals(".")){
      recordAttendance(month, students, line);
      line = sc.nextLine();
    } 

    // for (String ss : timetable){
    //   if(ss != null)
    //     System.out.println(ss);
    // }
    for (int d : days){
      System.out.println(d);
    }
  }
}
