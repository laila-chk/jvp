import java.util.Scanner;

public class Program {

  public static int getIndex(char[] line) {
    if(line[2] == 'T' && line[3] == 'U')
      return 0;
    if(line[2] == 'W' && line[3] == 'E')
      return 1;
    if(line[2] == 'T' && line[3] == 'H')
      return 2;
    if(line[2] == 'F' && line[3] == 'R')
      return 3;
    if(line[2] == 'S' && line[3] == 'A')
      return 4;
    if(line[2] == 'M' && line[3] == 'O')
      return 6;
    return 5;
  }

  public static int getTotalClasses(int[] days){
    
    int total = 0;
    for (int i = 0; i < 30; i++){
      total += days[i % 7];
    }
    return total;
  }

  public static String findDay(String[] timeTb, int dayIndex){
    String[] days = { "TU", "WE", "TH", "FR", "SA", "SU", "MO"};
    int[] foundDays = new int[10]; // 5 is the max we can have. (2-6pm)
    int j = 0;
    //timeTb ["4 MO", "2 MO"];
    for (int i = 0; i < timeTb.length; i++){
      if (!timeTb[i].equals("")){ //cuz we'll turn treated data into ""
        String tmp = "" ;
        char[] arr = timeTb[i].toCharArray();
        tmp += arr[2];
        tmp += arr[3];
        //tmp = MO
        if (tmp.equals(days[dayIndex]))
          foundDays[j++] = i; 
      }
    } //searching for days[dayIndex]!!!!
    // based on j, we can tell how many values we got
    if (j == 1){
      String ret = timeTb[foundDays[0]];
      timeTb[foundDays[0]] = "";
      return ret; 
    }
    int min = foundDays[0]; //index of earliest hour in timeTb
    for (int x = 1; x < j; x++){
        char[] arr1 = timeTb[min].toCharArray();// arr1 = {'4', ' ', 'M', 'O'}
        char[] arr2 = timeTb[foundDays[x]].toCharArray(); // arr2 = {'2', ' ', 'M', 'O'}
        if (arr1[0] > arr2[0])
          min = foundDays[x];
      }
    //eliminating the used day so we wont deal with it later or whatever
    String ret = timeTb[min];
    timeTb[min] = "";
    return ret; 
  }

  public static String[] sortTimeTb(String[] timeTb, int[] days) {
    int totCls = getTotalClasses(days);
    String[] tmp = new String[timeTb.length];
    int j = 0;
    for(int i = 0; i < 7; i++){
      while (days[i] > 0) {
        tmp[j++] = findDay(timeTb, i); // we should find the day, maybe reformat it to 2 28 format
        days[i]--;
      }
    }
    return tmp;
  }

  public static boolean sameHr(String[] timeTb, int x) {
    char[] arr = timeTb[x % timeTb.length].toCharArray();
    char[] arr1 = timeTb[(x+1) % timeTb.length].toCharArray();
    if (arr1[0] == arr[0] && arr1[1] == arr[1] && arr1[2] == arr[1] ){
      // System.out.println("TRUE!");
      return true;
    }
    return false;
  }

  public static String[] getAllClasses(int[] days, String[] timeTb) {
    //sort time table : |4 MO | 3 WE | 2 MO | ==> |3 WE |2 MO | 4 MO |     
    int[] cpOfDays = new int[7];
    for (int i = 0; i < 7; i++)
      cpOfDays[i] = days[i];
    timeTb = sortTimeTb(timeTb, cpOfDays);
    //hard coding keys: |3 WE |2 MO | 4 MO |  ==> |3:00 2 |2:00 7 | 4:00 7 | 3:00 9|    
    String[] allClasses = new String[getTotalClasses(days)];
    
    int totCls = getTotalClasses(days);
    int j = 0; 
    int x = 0;
    int tbl = timeTb.length;
    for (int i = 0; i < 30; i++){
    int k = 0;
      while(k < days[getIndex(timeTb[x % tbl].toCharArray())] && (getIndex(timeTb[x % tbl].toCharArray()) == (i%7)  && !sameHr(timeTb, x))) {
        char[] arr = timeTb[x % tbl].toCharArray();
        allClasses[j++] = arr[0] + " " + (i + 1);
        x++;
        k++;
      }
    }
    return allClasses;
  }

  public static void recordAtt(String line, String[] allCls, String[] stds, String[][] att) {
    String stdName = "";
    String classKey = "";
    for(char c: line.toCharArray()){
      if(c == ' ')
        break;
      stdName += c;
    }
    int stdIndex = 0;
    for(String std : stds){
      if (std.equals(stdName))
        break;
      stdIndex++;
    }
    int flg = 0;
    char[] data = line.toCharArray();
    int i = stdName.length()+1;
    for (; i < line.length(); i++){
      if(data[i] == ' ')
        flg++;
      if (flg == 2)
        break;
      classKey += data[i];
    }
    int clsIndx = 0;
    for(String cls : allCls){
      if (cls.equals(classKey))
        break;
      clsIndx++;
    }
    i++;
    if (data[i] == 'N')
      att[stdIndex][clsIndx] = "-1";
    else
      att[stdIndex][clsIndx] = "1";

  }

  public static void printTable(String[][] att, String[] allCls, String[] stds, int totStd, String[] tb){
//4:00 WE 2| 2:00 MO 7|4:00 WE 9|2:00 MO 14|4:00 WE 16|2:00 MO 21|4:00 WE 23|2:00 MO 28|2:00 MO 30|

    // allCls ->  4 2| 2 7 |4 9|2 14\..
    // tb     -> 4 WE| 2 MO 

    int i = 0;
    System.out.print("          |");
    for(String cls : allCls){
      char[] key = cls.toCharArray();
      char[] day = tb[i % tb.length].toCharArray();

      if(key.length == 3)
        System.out.print(" ");
      System.out.print(day[0] + ":00 " + day[2] + day[3] + " " );
      if(key.length > 3)
        System.out.print(key[key.length - 2]);
      System.out.print(key[key.length - 1] + "|");

      i++;
    }
    System.out.println("");
    i = 0;
    while (i < totStd){
      System.out.print(stds[i]);
      for (int j = stds[i].length(); j < 10; j++)
        System.out.print(" ");
      System.out.print("|");

      for (String rec : att[i]){
        System.out.print("        ");
        if (rec == null)
          System.out.print("  ");
        else {
          if (rec.equals("1"))
            System.out.print(" ");
          System.out.print(rec);
        }
        System.out.print("|");
      }
      System.out.println("");
      i++;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] students = new String[10];
    String line = sc.nextLine();
    String[] timetable = new String[10];
    int[] days = new int[7];
    int i = 0;

    try {
      while (!line.equals(".")){
        students[i++] = line;
        line = sc.nextLine();
      } 
      int totStd = i;
      line = sc.nextLine();
      i = 0;
      //reading the lines 2 MO , 4 WE ..

      while (!line.equals(".")){
        timetable[i++] = line; // 2 MO
        days[getIndex(line.toCharArray())]++;
        line = sc.nextLine();
      } 
      String[] timeTb = new String[i--];
      while (i >= 0)
        timeTb[i] = timetable[i--];

      int totCls = getTotalClasses(days);
      String[] allClasses = getAllClasses(days, timeTb);
      String[][] attendance = new String[totStd][totCls];
    
      i = 0;
      while (i < timeTb.length)
        timeTb[i] = timetable[i++];

      int[] cpOfDays = new int[7];
      for (int j = 0; j < 7; j++)
        cpOfDays[j] = days[j];
      timeTb = sortTimeTb(timeTb, cpOfDays);
      line = sc.nextLine();
      while(!line.equals(".")){
        recordAtt(line, allClasses, students, attendance);
        line = sc.nextLine();
      }
      printTable(attendance, allClasses, students, totStd, timeTb);

    } catch (Exception e) {
      System.out.println("Ops, Wrong input! The subject promised that it'll be correct though :(");
    }

  }
}
