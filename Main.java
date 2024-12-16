import java.util.Scanner;
import java.util.Arrays;

class Main extends Thread{
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";

  static String[][] grid = new String[31][28];
  static int playerYPos = 23;
  static int playerXPos = 13;
  static String movment = "secretStopButton";
  static int food = 0;

  static int ghost1YPos = 11;
  static int ghost1XPos = 13;
  static String ghost1Movment = "";
  boolean ghost1StepedOnFood = false;

  static int ghost2YPos = 11;
  static int ghost2XPos = 13;
  static String ghost2Movment = "";
  boolean ghost2StepedOnFood = false;

  static int ghost3YPos = 11;
  static int ghost3XPos = 13;
  static String ghost3Movment = "";
  boolean ghost3StepedOnFood = false;

  boolean ghost1SteppedOnPower = false;
  boolean ghost2SteppedOnPower = false;
  boolean ghost3SteppedOnPower = false;

  static boolean frightened = false;
  static int counting = 1;

  static int counterForGost2Activation = 0;
  static int counterForGost3Activation = 0;

  static boolean isGameRunning = true;
  static boolean youDied = false;
  
  static int timesPlayed = 0;


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        grid[i][j] = ANSI_BLUE + "▓▓";
      }
    }

    for(int i = 0; i < grid[0].length; i++){
      grid[0][i] = "🟥";
    }
    for(int i = 0; i < grid[0].length; i++){
      grid[grid.length-1][i] = "🟥";
    }
    for(int i = 0; i < grid.length; i++){
      grid[i][0] = "🟥";
    }
    for(int i = 0; i < grid.length; i++){
      grid[i][grid[0].length-1] = "🟥";
    }

    for(int i = 1; i <= 4; i++){
      grid[i][14] = "🟦";
    }
    for(int i = 1; i <= 4; i++){
      grid[i][13] = "🟦";
    }



    for(int i = 9; i <= 11; i++){
      grid[i][15] =  ANSI_PURPLE + "██";
    }
    for(int i = 9; i <= 11; i++){
      grid[i][12] =  ANSI_PURPLE + "██";
    }
    for(int i = 9; i <= 18; i++){
        grid[11][i] = ANSI_PURPLE + "██";
    }

    for(int i = 11; i <= 19; i++){
      grid[i][9] = ANSI_PURPLE + "██";
    }
    for(int i = 11; i <= 19; i++){
      grid[i][18] = ANSI_PURPLE + "██";
    }

    for(int i = 9; i <= 18; i++){
        grid[17][i] = ANSI_PURPLE + "██";
    }

    for(int i = 18; i <= grid[0].length-1; i++){
      grid[14][i] = ANSI_PURPLE + "██";
    }

    for(int i = 0; i <= 9; i++){
      grid[14][i] = ANSI_PURPLE + "██";
    }
   

    for(int i = 1; i <= 12; i++){
    grid[1][i] = "🟡";
    }
    for(int i = 1; i < grid[0].length-1; i++){
    grid[5][i] = "🟡";
    }
    for(int i = 1; i <= 8; i++){
    grid[i][1] = "🟡";
    }
    for(int i = 1; i <= 6; i++){
    grid[8][i] = "🟡";
    }
    for(int i = 1; i <= 5; i++){
      grid[i][12] = "🟡";
    }

    for(int i = 1; i < grid.length - 4; i++){
      grid[i][6] = "🟡";
    }
    for(int i = 5; i <= 8; i++){
    grid[i][9] = "🟡";
    }
    for(int i = 10; i <= 12; i++){
    grid[8][i] = "🟡";
    }

    for(int i = 1;i <= 4; i++){
      grid[i][15] = "🟡";
    }

    for(int i = 16; i < grid[0].length-1; i++){

      grid[1][i] = "🟡";

    }

    for(int i = 2; i < grid.length - 4; i++){
      grid[i][21] = "🟡";
    }

    for(int i = 2; i <= 8; i++){
      grid[i][grid[0].length-2] = "🟡";
    }

    for(int i = grid[0].length-6; i < grid[0].length - 1; i++){
        grid[8][i] = "🟡";
    }

    for(int i = 15; i <= 18; i++){
    grid[8][i] = "🟡";
    }

    for(int i = 6; i <= 8; i++){
      grid[i][18] = "🟡";
    }
   
   for(int i = 1; i <= grid[0].length - 2; i++){

     grid[grid.length-2][i] = "🟡";

   }
   
   for(int i = grid.length - 5; i <= grid.length - 3; i++){

     grid[i][1] = "🟡";

   }

   for(int i = grid.length - 5; i <= grid.length - 3; i++){

     grid[i][grid[0].length-2] = "🟡";

   }

   for(int i = 2; i <= 6; i++){

     grid[grid.length-5][i] = "🟡";

   }

   for(int i = grid[0].length-6; i <= grid[0].length-2; i++){

     grid[grid.length-5][i] = "🟡";

   }  

   for(int i = grid[0].length-5; i < grid[0].length-2; i++){
     grid[i][3] = "🟡";
   }
   for(int i = grid[0].length-5; i < grid[0].length-2; i++){
     grid[i][grid[0].length-4] = "🟡";
   }

     grid[grid[0].length-5][grid[0].length-3] = "🟡";
     grid[grid[0].length-5][grid[0].length-2] = "🟡";

     grid[grid[0].length-6][grid[0].length-2] = "🟡";
     grid[grid[0].length-7][grid[0].length-2] = "🟡";
     grid[grid[0].length-8][grid[0].length-2] = "🟡";

     grid[grid[0].length-5][2] = "🟡";
     grid[grid[0].length-5][1] = "🟡";

     grid[grid[0].length-6][1] = "🟡";
     grid[grid[0].length-7][1] = "🟡";
     grid[grid[0].length-8][1] = "🟡";

     for(int i = 1; i <= 12; i++){
       grid[grid[0].length-8][i] = "🟡";
     }

     for(int i = 15; i <= grid[0].length-2; i++){
       grid[grid[0].length-8][i] = "🟡";
     }

     for(int i = 6; i <= 21; i++){
       grid[grid.length-8][i] = "🟡";
     }
    
    for(int i = grid.length-8; i <= grid.length-5; i++){
    grid[i][9] = "🟡";
    }
    for(int i = grid.length-8; i <= grid.length-5; i++){
    grid[i][18] = "🟡";
    }
    
    for(int i = 9; i <= 12; i++){
      grid[grid.length-5][i] = "🟡";
    }

    for(int i = 15; i <= 18; i++){
      grid[grid.length-5][i] = "🟡";
    }

    grid[grid.length-4][15] = "🟡";
    grid[grid.length-3][15] = "🟡";

    grid[grid.length-4][12] = "🟡";
    grid[grid.length-3][12] = "🟡";

    grid[grid.length-10][15] = "🟡";
    grid[grid.length-9][15] = "🟡";

    grid[grid.length-10][12] = "🟡";
    grid[grid.length-9][12] = "🟡";

    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j].equals(ANSI_BLUE + "▓▓")){
          grid[i][j] = "🟦";
        }
        
        else if(grid[i][j].equals(ANSI_PURPLE + "██")){
          grid[i][j] = "  ";
        }
      }
    }

    grid[playerYPos][playerXPos] = "😀";



    grid[14][11] = "👹";
    grid[14][13] = "🧠";
    grid[14][15] = "⛄";

    grid[1][1] = "⚪";
    grid[grid.length-2][1] = "⚪";
    grid[grid.length-2][grid[0].length-2] = "⚪";
    grid[1][grid[0].length-2] = "⚪";

     System.out.println("\033[H\033[2J");
     System.out.flush();

System.out.println("__________                                      ");
System.out.println("\\______   \\_____    ____   _____ _____    ____  ");
System.out.println(" |     ___/\\__  \\ _/ ___\\ /     \\__  \\  /    \\ ");
System.out.println(" |    |     / __ \\\\  \\___|  Y Y  \\/ __ \\|   |  \\");
System.out.println(" |____|    (____  /\\___  >__|_|  (____  /___|  /");
System.out.println("                \\/     \\/      \\/     \\/     \\ ");


    System.out.print("\n\nClick [Enter] To Begin: ");
    String start = scan.nextLine();


    System.out.println("\033[H\033[2J");
    System.out.flush();
    print(grid);

if(timesPlayed == 0){
    Main something = new Main();
    something.start();
}
    while(true){
    while(isGameRunning){
      movment = scan.nextLine();

    }
    try{
      Thread.sleep(1000);
    }
    catch(Exception e){}
    }
    

    
  }

  public static void print(String[][] array){
    if(youDied == false){
    System.out.println("Food Collected: " + food + "/241");
    }
    else{
      System.out.println("\n\t\t\t\t\t\t|GAME OVER|");
    }
    for(int i = 0; i < array.length; i++){
      for(int j = 0; j < array[0].length; j++){
        System.out.print(array[i][j]);
      }
      System.out.println();
    }

    if(youDied == false){
    System.out.print("\n\t\t\t\t\t\t|CONTROLS|");
    System.out.print("\n\t\t\t  MOVMENT: [W][A][S][D] + [ENTER]");
    }
    else{
      System.out.print("\n\t\t\t\t\t\t|YOU DIED|");
    System.out.print("\n\t\t\t  Click [ENTER] Below To Reset The Game");
    }

    System.out.print("\nTYPE HERE: ");

    
  }

  public void run(){
while(true){
    while(isGameRunning){

      if(food == 241){

//you won
          System.out.println("\033[H\033[2J");
          System.out.flush();                                
                                                          
System.out.println(",--.   ,--.,-----. ,--. ,--.    ,--.   ,--.,--.,--.  ,--. ");
System.out.println(" \\  `.'  /'  .-.  '|  | |  |    |  |   |  ||  ||  ,'.|  | ");
System.out.println("  '.    / |  | |  ||  | |  |    |  |.'.|  ||  ||  |' '  | ");
System.out.println("    |  |  '  '-'  ''  '-'  '    |   ,'.   ||  ||  | `   | ");
System.out.println("    `--'   `-----'  `-----'     '--'   '--'`--'`--'  `--' ");
Scanner scan = new Scanner(System.in);

  

    System.out.print("\n\nClick [ENTER] To Play Again: ");

    while(!(movment.equals("w")) || !(movment.equals("a")) || !(movment.equals("s")) || !(movment.equals("d"))){

      if(!(movment.equals("w")) && !(movment.equals("a")) && !(movment.equals("s")) && !(movment.equals("d"))){
        isGameRunning = false;
        break;
      }


      
    }
    System.out.println("LOADING...");
    System.out.println("ERROR IN THE SYSTEM, PLEASE CLICK [ETNER AGAIN]");
    // scan.nextLine();
    // scan.nextLine();
    // scan.nextLine();

    break;



      }

      if(movment.equals("d") && playerXPos+1 < grid[0].length && !(grid[playerYPos][playerXPos+1].equals("🟦")) && !(grid[playerYPos][playerXPos+1].equals("🟥"))){
         
        grid[playerYPos][playerXPos] = "  ";
        playerXPos++;
        if(grid[playerYPos][playerXPos].equals("🟡")){
          food++;
        }
        if(grid[playerYPos][playerXPos].equals("⚪")){
          frightened = true;
        }
        if(grid[playerYPos][playerXPos].equals("💀")){

          if(playerXPos == ghost1XPos && playerYPos == ghost1YPos){
            ghost1XPos = 11;
            ghost1YPos = 14;
            grid[ghost1YPos][ghost1XPos] = "👹";
            
          }
          else if(playerXPos == ghost2XPos && playerYPos == ghost2YPos){
            ghost2XPos = 13;
            ghost2YPos = 14;
            grid[ghost2YPos][ghost2XPos] = "🧠";
          }
          else if(playerXPos == ghost3XPos && playerYPos == ghost3YPos){
            ghost3XPos = 15;
            ghost3YPos = 14;
            grid[ghost3YPos][ghost3XPos] = "⛄";
          }

        }

        grid[playerYPos][playerXPos] = "😀";

         
      }

      else if(movment.equals("d") && playerXPos+1 >= grid[0].length){

        grid[playerYPos][playerXPos] = "  ";
        playerXPos = 0;
        grid[playerYPos][playerXPos] = "😀";

      }

      else if(movment.equals("a") && playerXPos-1 >= 0 && !(grid[playerYPos][playerXPos-1].equals("🟦")) && !(grid[playerYPos][playerXPos-1].equals("🟥"))){
        //  System.out.println("\033[H\033[2J");
        grid[playerYPos][playerXPos] = "  ";
        playerXPos--;

        if(grid[playerYPos][playerXPos].equals("🟡")){
          food++;
        }
        if(grid[playerYPos][playerXPos].equals("⚪")){
          frightened = true;
        }
        if(grid[playerYPos][playerXPos].equals("💀")){

          if(playerXPos == ghost1XPos && playerYPos == ghost1YPos){
            ghost1XPos = 11;
            ghost1YPos = 14;
            grid[ghost1YPos][ghost1XPos] = "👹";
            
          }
          else if(playerXPos == ghost2XPos && playerYPos == ghost2YPos){
            ghost2XPos = 13;
            ghost2YPos = 14;
            grid[ghost2YPos][ghost2XPos] = "🧠";
          }
          else if(playerXPos == ghost3XPos && playerYPos == ghost3YPos){
            ghost3XPos = 15;
            ghost3YPos = 14;
            grid[ghost3YPos][ghost3XPos] = "⛄";
          }

        }

        grid[playerYPos][playerXPos] = "😀";

        //  print(grid);
         
      }

      else if(movment.equals("a") && playerXPos-1 < 0){
        //  System.out.println("\033[H\033[2J");
        grid[playerYPos][playerXPos] = "  ";
        playerXPos = grid[0].length-1;

        grid[playerYPos][playerXPos] = "😀";

        //  print(grid);
         
      }

      else if(movment.equals("w") && playerYPos-1 >= 0 && !(grid[playerYPos-1][playerXPos].equals("🟦")) && !(grid[playerYPos-1][playerXPos].equals("🟥"))){
        //  System.out.println("\033[H\033[2J");
        grid[playerYPos][playerXPos] = "  ";
        playerYPos--;
        if(grid[playerYPos][playerXPos].equals("🟡")){
          food++;
        }
        if(grid[playerYPos][playerXPos].equals("⚪")){
          frightened = true;
        }
        if(grid[playerYPos][playerXPos].equals("💀")){

          if(playerXPos == ghost1XPos && playerYPos == ghost1YPos){
            ghost1XPos = 11;
            ghost1YPos = 14;
            grid[ghost1YPos][ghost1XPos] = "👹";
            
          }
          else if(playerXPos == ghost2XPos && playerYPos == ghost2YPos){
            ghost2XPos = 13;
            ghost2YPos = 14;
            grid[ghost2YPos][ghost2XPos] = "🧠";
          }
          else if(playerXPos == ghost3XPos && playerYPos == ghost3YPos){
            ghost3XPos = 15;
            ghost3YPos = 14;
            grid[ghost3YPos][ghost3XPos] = "⛄";
          }

        }
        grid[playerYPos][playerXPos] = "😀";

        //  print(grid);
         
      }
      
      else if(movment.equals("s") && playerYPos+1 < grid.length && !(grid[playerYPos+1][playerXPos].equals("🟦")) && !(grid[playerYPos+1][playerXPos].equals("🟥"))){
        //  System.out.println("\033[H\033[2J");
        grid[playerYPos][playerXPos] = "  ";
        playerYPos++;
        if(grid[playerYPos][playerXPos].equals("🟡")){
          food++;
        }
        if(grid[playerYPos][playerXPos].equals("⚪")){
          frightened = true;
        }
        if(grid[playerYPos][playerXPos].equals("💀")){

          if(playerXPos == ghost1XPos && playerYPos == ghost1YPos){
            ghost1XPos = 11;
            ghost1YPos = 14;
            grid[ghost1YPos][ghost1XPos] = "👹";
            
          }
          else if(playerXPos == ghost2XPos && playerYPos == ghost2YPos){
            ghost2XPos = 13;
            ghost2YPos = 14;
            grid[ghost2YPos][ghost2XPos] = "🧠";
          }
          else if(playerXPos == ghost3XPos && playerYPos == ghost3YPos){
            ghost3XPos = 15;
            ghost3YPos = 14;
            grid[ghost3YPos][ghost3XPos] = "⛄";
          }

        }
        grid[playerYPos][playerXPos] = "😀";

        //  print(grid);
         
      }
      if(frightened == false){

        if(ghost1XPos == 11 && ghost1YPos == 14){
          grid[ghost1YPos][ghost1XPos] = "  ";
          ghost1YPos = 11;
          ghost1XPos = 14;
        }

        if(ghost2XPos == 13 && ghost2YPos == 14){
          grid[ghost2YPos][ghost2XPos] = "  ";
          ghost2YPos = 11;
          ghost2XPos = 14;
        }

        if(ghost3XPos == 15 && ghost3YPos == 14){
          grid[ghost3YPos][ghost3XPos] = "  ";
          ghost3YPos = 11;
          ghost3XPos = 14;
        }

      if(!((movment.equals("secretStopButton")))){
        grid[14][11] = "  ";

        

        counterForGost2Activation++;

        double up = 1000;
        double right = 1000;
        double left = 1000;
        double down = 1000;

        try{
        if((grid[ghost1YPos][ghost1XPos+1].equals("  ") || grid[ghost1YPos][ghost1XPos+1].equals("🟡") || grid[ghost1YPos][ghost1XPos+1].equals("😀") || grid[ghost1YPos][ghost1XPos+1].equals("⚪")) && !(ghost1Movment.equals("a"))){
          right = Math.sqrt((playerXPos-ghost1XPos-1)*(playerXPos-ghost1XPos-1)+(playerYPos-ghost1YPos)*(playerYPos-ghost1YPos));
        }
        else{
          right = 1001;
        }
        }
        catch(Exception e){
          if(!(ghost1Movment.equals("a"))){
          grid[ghost1YPos][ghost1XPos] = "  ";
          right = 0;
          }
        }

        try{
        if((grid[ghost1YPos][ghost1XPos-1].equals("  ") ||grid[ghost1YPos][ghost1XPos-1].equals("🟡") || grid[ghost1YPos][ghost1XPos-1].equals("😀") || grid[ghost1YPos][ghost1XPos-1].equals("⚪")) && !(ghost1Movment.equals("d"))){
          left = Math.sqrt((playerXPos-ghost1XPos+1)*(playerXPos-ghost1XPos+1)+(playerYPos-ghost1YPos)*(playerYPos-ghost1YPos));
        }
        else{
          left = 1001;
        }
        }
        catch(Exception e){
          if(!(ghost1Movment.equals("d"))){
          grid[ghost1YPos][ghost1XPos] = "  ";
          left = grid[0].length-1;
          }
        }

        try{
        if((grid[ghost1YPos-1][ghost1XPos].equals("  ") ||grid[ghost1YPos-1][ghost1XPos].equals("🟡") || grid[ghost1YPos-1][ghost1XPos].equals("😀")|| grid[ghost1YPos-1][ghost1XPos].equals("⚪")) && !(ghost1Movment.equals("s"))){
          up = Math.sqrt((playerXPos-ghost1XPos)*(playerXPos-ghost1XPos)+(playerYPos-ghost1YPos+1)*(playerYPos-ghost1YPos+1));
        }
        else{
          up = 1001;
        }
        }
        catch(Exception e){
          up = 1001;
        }

        try{
        if((grid[ghost1YPos+1][ghost1XPos].equals("  ") ||grid[ghost1YPos+1][ghost1XPos].equals("🟡") || grid[ghost1YPos+1][ghost1XPos].equals("😀")|| grid[ghost1YPos+1][ghost1XPos].equals("⚪")) && !(ghost1Movment.equals("w"))){
          down = Math.sqrt((playerXPos-ghost1XPos)*(playerXPos-ghost1XPos)+(playerYPos-ghost1YPos-1)*(playerYPos-ghost1YPos-1));
        }
        else{
          down = 1001;
        }
        }
        catch(Exception e){
          down = 1001;
        }

        double[] sort = {down, up, left, right};

        Arrays.sort(sort);

        // for(int i = 0; i < sort.length; i++){
        //   System.out.println(sort[i] + " ");
        // }

        if(sort[0] == down){
          ghost1Movment = "s";
          // System.out.println("answer");
          // System.out.println(down);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == up){
           ghost1Movment = "w";
          //  System.out.println("answer");
          // System.out.println(up);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == left){
           ghost1Movment = "a";
          //  System.out.println("answer");
          // System.out.println(left);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == right){
          // System.out.println("answer");
          // System.out.println(right);
          // System.out.println(sort[0]);
           ghost1Movment = "d";
        }


        // System.out.println(ghost1Movment);


        
        // if(ghost1Movment.equals("")){
        //   int randomMovment = (int) (Math.random() * 2);

        //   if(randomMovment == 0){
        //     ghost1Movment = "d";
        //   }
        //   else{
        //     ghost1Movment = "a";
        //   }
        // }

        if(ghost1Movment.equals("d") && ghost1XPos+1 < grid[0].length && !(grid[ghost1YPos][ghost1XPos+1].equals("🟦")) && !(grid[ghost1YPos][ghost1XPos+1].equals("🟥"))){

          

          if(ghost1StepedOnFood == false){
          grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "🟡";
            ghost1StepedOnFood = false;
          }

          if(ghost1SteppedOnPower == false){
            grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "⚪";
            ghost1SteppedOnPower = false;
          }

        ghost1XPos++;

        if(grid[ghost1YPos][ghost1XPos].equals("🟡")){
          ghost1StepedOnFood = true;
        }
        if(grid[ghost1YPos][ghost1XPos].equals("⚪")){
          ghost1SteppedOnPower = true;
        }
        

        grid[ghost1YPos][ghost1XPos] = "👹";

        }

        else if(ghost1Movment.equals("d") && ghost1XPos+1 >= grid[0].length-1){

        ghost1XPos = 0;

        

        grid[ghost1YPos][ghost1XPos] = "👹";

        }

        else if(ghost1Movment.equals("a") && ghost1XPos-1 >= 0 && !(grid[ghost1YPos][ghost1XPos-1].equals("🟦")) && !(grid[ghost1YPos][ghost1XPos-1].equals("🟥"))){

          

          if(ghost1StepedOnFood == false){
          grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "🟡";
            ghost1StepedOnFood = false;
          }
          if(ghost1SteppedOnPower == false){
            grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "⚪";
            ghost1SteppedOnPower = false;
          }

        ghost1XPos--;

        if(grid[ghost1YPos][ghost1XPos].equals("🟡")){
          ghost1StepedOnFood = true;
        }
        if(grid[ghost1YPos][ghost1XPos].equals("⚪")){
          ghost1SteppedOnPower = true;
        }
        

        grid[ghost1YPos][ghost1XPos] = "👹";

        }

        else if(ghost1Movment.equals("a") && ghost1XPos-1 < 0){

        ghost1XPos = grid[0].length-1;
        

        grid[ghost1YPos][ghost1XPos] = "👹";

        }

        else if(ghost1Movment.equals("w") && ghost1YPos-1 >= 0 && !(grid[ghost1YPos-1][ghost1XPos].equals("🟦")) && !(grid[ghost1YPos-1][ghost1XPos].equals("🟥"))){

          if(ghost1StepedOnFood == false){
          grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "🟡";
            ghost1StepedOnFood = false;
          }

          if(ghost1SteppedOnPower == false){
            grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "⚪";
            ghost1SteppedOnPower = false;
          }

        ghost1YPos--;

        if(grid[ghost1YPos][ghost1XPos].equals("🟡")){
          ghost1StepedOnFood = true;
        }
        if(grid[ghost1YPos][ghost1XPos].equals("⚪")){
          ghost1SteppedOnPower = true;
        }
        

        grid[ghost1YPos][ghost1XPos] = "👹";

        }

        else if(ghost1Movment.equals("s") && ghost1YPos+1 < grid.length && !(grid[ghost1YPos+1][ghost1XPos].equals("🟦")) && !(grid[ghost1YPos+1][ghost1XPos].equals("🟥"))){

          if(ghost1StepedOnFood == false){
          grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "🟡";
            ghost1StepedOnFood = false;
          }

          if(ghost1SteppedOnPower == false){
            grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "⚪";
            ghost1SteppedOnPower = false;
          }

        ghost1YPos++;

        if(grid[ghost1YPos][ghost1XPos].equals("🟡")){
          ghost1StepedOnFood = true;
        }
        if(grid[ghost1YPos][ghost1XPos].equals("⚪")){
          ghost1SteppedOnPower = true;
        }
        

        grid[ghost1YPos][ghost1XPos] = "👹";

        }

        

        System.out.println("\033[H\033[2J");
        print(grid);

        isGameRunning = false;
        for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j].equals("😀")){
              isGameRunning = true;
            }

          }
        }

      }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      if(counterForGost2Activation >= 10){
        grid[14][13] = "  ";
        counterForGost3Activation++;
        double up = 1000;
        double right = 1000;
        double left = 1000;
        double down = 1000;

        try{
        if((grid[ghost2YPos][ghost2XPos+1].equals("  ") || grid[ghost2YPos][ghost2XPos+1].equals("🟡") || grid[ghost2YPos][ghost2XPos+1].equals("😀")|| grid[ghost2YPos][ghost2XPos+1].equals("⚪")) && !(ghost2Movment.equals("a"))){
          right = Math.sqrt((playerXPos-ghost2XPos-4)*(playerXPos-ghost2XPos-4)+(playerYPos-ghost2YPos)*(playerYPos-ghost2YPos));
        }
        else{
          right = 1001;
        }
        }
        catch(Exception e){
          if(!(ghost2Movment.equals("a"))){
          grid[ghost2YPos][ghost2XPos] = "  ";
          right = 0;
          }
        }

        try{
        if((grid[ghost2YPos][ghost2XPos-1].equals("  ") ||grid[ghost2YPos][ghost2XPos-1].equals("🟡") || grid[ghost2YPos][ghost2XPos-1].equals("😀")|| grid[ghost2YPos][ghost2XPos-1].equals("⚪")) && !(ghost2Movment.equals("d"))){
          left = Math.sqrt((playerXPos-ghost2XPos+4)*(playerXPos-ghost2XPos+4)+(playerYPos-ghost2YPos)*(playerYPos-ghost2YPos));
        }
        else{
          left = 1001;
        }
        }
        catch(Exception e){
          if(!(ghost2Movment.equals("d"))){
          grid[ghost2YPos][ghost2XPos] = "  ";
          left = grid[0].length-1;
          }
        }

        try{
        if((grid[ghost2YPos-1][ghost2XPos].equals("  ") ||grid[ghost2YPos-1][ghost2XPos].equals("🟡") || grid[ghost2YPos-1][ghost2XPos].equals("😀")|| grid[ghost2YPos-1][ghost2XPos].equals("⚪")) && !(ghost2Movment.equals("s"))){
          up = Math.sqrt((playerXPos-ghost2XPos)*(playerXPos-ghost2XPos)+(playerYPos-ghost2YPos+4)*(playerYPos-ghost2YPos+4));
        }
        else{
          up = 1001;
        }
        }
        catch(Exception e){
          up = 1001;
        }

        try{
        if((grid[ghost2YPos+1][ghost2XPos].equals("  ") ||grid[ghost2YPos+1][ghost2XPos].equals("🟡") || grid[ghost2YPos+1][ghost2XPos].equals("😀")|| grid[ghost2YPos+1][ghost2XPos].equals("⚪")) && !(ghost2Movment.equals("w"))){
          down = Math.sqrt((playerXPos-ghost2XPos-4)*(playerXPos-ghost2XPos-4)+(playerYPos-ghost2YPos-4)*(playerYPos-ghost2YPos-4));
        }
        else{
          down = 1001;
        }
        }
        catch(Exception e){
          down = 1001;
        }

        double[] sort = {down, up, left, right};

        Arrays.sort(sort);

        // for(int i = 0; i < sort.length; i++){
        //   System.out.println(sort[i] + " ");
        // }

        if(sort[0] == down){
          ghost2Movment = "s";
          // System.out.println("answer");
          // System.out.println(down);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == up){
           ghost2Movment = "w";
          //  System.out.println("answer");
          // System.out.println(up);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == left){
           ghost2Movment = "a";
          //  System.out.println("answer");
          // System.out.println(left);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == right){
          // System.out.println("answer");
          // System.out.println(right);
          // System.out.println(sort[0]);
           ghost2Movment = "d";
        }


        // System.out.println(ghost1Movment);


        
        // if(ghost1Movment.equals("")){
        //   int randomMovment = (int) (Math.random() * 2);

        //   if(randomMovment == 0){
        //     ghost1Movment = "d";
        //   }
        //   else{
        //     ghost1Movment = "a";
        //   }
        // }

        if(ghost2Movment.equals("d") && ghost2XPos+1 < grid[0].length && !(grid[ghost2YPos][ghost2XPos+1].equals("🟦")) && !(grid[ghost2YPos][ghost2XPos+1].equals("🟥"))){

          

          if(ghost2StepedOnFood == false){
          grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "🟡";
            ghost2StepedOnFood = false;
          }

          if(ghost2SteppedOnPower == false){
            grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "⚪";
            ghost2SteppedOnPower = false;
          }

        ghost2XPos++;

        if(grid[ghost2YPos][ghost2XPos].equals("🟡")){
          ghost2StepedOnFood = true;
        }
        if(grid[ghost2YPos][ghost2XPos].equals("⚪")){
          ghost2SteppedOnPower = true;
        }
        

        grid[ghost2YPos][ghost2XPos] = "🧠";

        }

        else if(ghost2Movment.equals("d") && ghost2XPos+1 >= grid[0].length-1){

        ghost2XPos = 0;

        

        grid[ghost2YPos][ghost2XPos] = "🧠";

        }

        else if(ghost2Movment.equals("a") && ghost2XPos-1 >= 0 && !(grid[ghost2YPos][ghost2XPos-1].equals("🟦")) && !(grid[ghost2YPos][ghost2XPos-1].equals("🟥"))){

          

          if(ghost2StepedOnFood == false){
          grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "🟡";
            ghost2StepedOnFood = false;
          }

          if(ghost2SteppedOnPower == false){
            grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "⚪";
            ghost2SteppedOnPower = false;
          }

        ghost2XPos--;

        if(grid[ghost2YPos][ghost2XPos].equals("🟡")){
          ghost2StepedOnFood = true;
        }

        if(grid[ghost2YPos][ghost2XPos].equals("⚪")){
          ghost2SteppedOnPower = true;
        }
        

        grid[ghost2YPos][ghost2XPos] = "🧠";

        }

        else if(ghost2Movment.equals("a") && ghost2XPos-1 < 0){

        ghost2XPos = grid[0].length-1;
        

        grid[ghost2YPos][ghost2XPos] = "🧠";

        }

        else if(ghost2Movment.equals("w") && ghost2YPos-1 >= 0 && !(grid[ghost2YPos-1][ghost2XPos].equals("🟦")) && !(grid[ghost2YPos-1][ghost2XPos].equals("🟥"))){

          if(ghost2StepedOnFood == false){
          grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "🟡";
            ghost2StepedOnFood = false;
          }

          if(ghost2SteppedOnPower == false){
            grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "⚪";
            ghost2SteppedOnPower = false;
          }

        ghost2YPos--;

        if(grid[ghost2YPos][ghost2XPos].equals("🟡")){
          ghost2StepedOnFood = true;
        }
        if(grid[ghost2YPos][ghost2XPos].equals("⚪")){
          ghost2SteppedOnPower = true;
        }
        

        grid[ghost2YPos][ghost2XPos] = "🧠";

        }

        else if(ghost2Movment.equals("s") && ghost2YPos+1 < grid.length && !(grid[ghost2YPos+1][ghost2XPos].equals("🟦")) && !(grid[ghost2YPos+1][ghost2XPos].equals("🟥"))){

          if(ghost2StepedOnFood == false){
          grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "🟡";
            ghost2StepedOnFood = false;
          }

          if(ghost2SteppedOnPower == false){
            grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "⚪";
            ghost2SteppedOnPower = false;
          }

        ghost2YPos++;

        if(grid[ghost2YPos][ghost2XPos].equals("🟡")){
          ghost2StepedOnFood = true;
        }
        if(grid[ghost2YPos][ghost2XPos].equals("⚪")){
          ghost2SteppedOnPower = true;
        }
        
        

        grid[ghost2YPos][ghost2XPos] = "🧠";
        

        }

        

        System.out.println("\033[H\033[2J");
        print(grid);

        isGameRunning = false;
        for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j].equals("😀")){
              isGameRunning = true;
            }

          }
        }

      }


      

////////////////////////////////////////////////////////////////////////////////////////////////////


      if(counterForGost3Activation >= 8){
        grid[14][15] = "  ";
        double up = 1000;
        double right = 1000;
        double left = 1000;
        double down = 1000;

        try{
        if((grid[ghost3YPos][ghost3XPos+1].equals("  ") || grid[ghost3YPos][ghost3XPos+1].equals("🟡") || grid[ghost3YPos][ghost3XPos+1].equals("😀")|| grid[ghost3YPos][ghost3XPos+1].equals("⚪")) && !(ghost3Movment.equals("a"))){
          if(Math.sqrt((playerXPos-ghost3XPos-1)*(playerXPos-ghost3XPos-1)+(playerYPos-ghost3YPos)*(playerYPos-ghost3YPos)) > 5){
          right = Math.sqrt((playerXPos-ghost3XPos-1)*(playerXPos-ghost3XPos-1)+(playerYPos-ghost3YPos)*(playerYPos-ghost3YPos));
          }
          else{
            right =  Math.sqrt((0-ghost3XPos)*(0-ghost3XPos)+(grid.length-1-ghost3YPos-1)*(grid.length-1-ghost3YPos-1));
          }
        }
        else{
          right = 1001;
        }
        }
        catch(Exception e){
          if(!(ghost3Movment.equals("a"))){
          grid[ghost3YPos][ghost3XPos] = "  ";
          right = 0;
          }
        }

        try{
        if((grid[ghost3YPos][ghost3XPos-1].equals("  ") ||grid[ghost3YPos][ghost3XPos-1].equals("🟡") || grid[ghost3YPos][ghost3XPos-1].equals("😀")|| grid[ghost3YPos][ghost3XPos-1].equals("⚪")) && !(ghost3Movment.equals("d"))){
          if(Math.sqrt((playerXPos-ghost3XPos+1)*(playerXPos-ghost3XPos+1)+(playerYPos-ghost3YPos)*(playerYPos-ghost3YPos)) > 5){
          left = Math.sqrt((playerXPos-ghost3XPos+1)*(playerXPos-ghost3XPos+1)+(playerYPos-ghost3YPos)*(playerYPos-ghost3YPos));
          }
          else{
            left =  Math.sqrt((0-ghost3XPos)*(0-ghost3XPos)+(grid.length-1-ghost3YPos-1)*(grid.length-1-ghost3YPos-1));
          }
        }
        else{
          left = 1001;
        }
        }
        catch(Exception e){
          if(!(ghost3Movment.equals("d"))){
          grid[ghost3YPos][ghost3XPos] = "  ";
          left = grid[0].length-1;
          }
        }

        try{
        if((grid[ghost3YPos-1][ghost3XPos].equals("  ") ||grid[ghost3YPos-1][ghost3XPos].equals("🟡") || grid[ghost3YPos-1][ghost3XPos].equals("😀")|| grid[ghost3YPos-1][ghost3XPos].equals("⚪")) && !(ghost3Movment.equals("s"))){

          if(Math.sqrt((playerXPos-ghost3XPos)*(playerXPos-ghost3XPos)+(playerYPos-ghost3YPos+1)*(playerYPos-ghost3YPos+1)) > 5){
          up = Math.sqrt((playerXPos-ghost3XPos)*(playerXPos-ghost3XPos)+(playerYPos-ghost3YPos+1)*(playerYPos-ghost3YPos+1));
          }
          else{
            up = Math.sqrt((0-ghost3XPos)*(0-ghost3XPos)+(grid.length-1-ghost3YPos-1)*(grid.length-1-ghost3YPos-1));
          }
        }
        else{
          up = 1001;
        }
        }
        catch(Exception e){
          up = 1001;
        }

        try{
        if((grid[ghost3YPos+1][ghost3XPos].equals("  ") ||grid[ghost3YPos+1][ghost3XPos].equals("🟡") || grid[ghost3YPos+1][ghost3XPos].equals("😀")|| grid[ghost3YPos+1][ghost3XPos].equals("⚪")) && !(ghost3Movment.equals("w"))){

          if(Math.sqrt((playerXPos-ghost3XPos)*(playerXPos-ghost3XPos)+(playerYPos-ghost3YPos-1)*(playerYPos-ghost3YPos-1)) > 5){
          down = Math.sqrt((playerXPos-ghost3XPos)*(playerXPos-ghost3XPos)+(playerYPos-ghost3YPos-1)*(playerYPos-ghost3YPos-1));
          }
          else{
            down = Math.sqrt((0-ghost3XPos)*(0-ghost3XPos)+(grid.length-1-ghost3YPos-1)*(grid.length-1-ghost3YPos-1));
          }

        }
        else{
          down = 1001;
        }
        }
        catch(Exception e){
          down = 1001;
        }

        double[] sort = {down, up, left, right};

        Arrays.sort(sort);

        // for(int i = 0; i < sort.length; i++){
        //   System.out.println(sort[i] + " ");
        // }

        if(sort[0] == down){
          ghost3Movment = "s";
          // System.out.println("answer");
          // System.out.println(down);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == up){
           ghost3Movment = "w";
          //  System.out.println("answer");
          // System.out.println(up);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == left){
           ghost3Movment = "a";
          //  System.out.println("answer");
          // System.out.println(left);
          // System.out.println(sort[0]);
        }
        else if(sort[0] == right){
          // System.out.println("answer");
          // System.out.println(right);
          // System.out.println(sort[0]);
           ghost3Movment = "d";
        }


        // System.out.println(ghost1Movment);


        
        // if(ghost1Movment.equals("")){
        //   int randomMovment = (int) (Math.random() * 2);

        //   if(randomMovment == 0){
        //     ghost1Movment = "d";
        //   }
        //   else{
        //     ghost1Movment = "a";
        //   }
        // }

        if(ghost3Movment.equals("d") && ghost3XPos+1 < grid[0].length && !(grid[ghost3YPos][ghost3XPos+1].equals("🟦")) && !(grid[ghost3YPos][ghost3XPos+1].equals("🟥"))){

          

          if(ghost3StepedOnFood == false){
          grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "🟡";
            ghost3StepedOnFood = false;
          }
          if(ghost3SteppedOnPower == false){
            grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "⚪";
            ghost3SteppedOnPower = false;
          }

        ghost3XPos++;

        if(grid[ghost3YPos][ghost3XPos].equals("🟡")){
          ghost3StepedOnFood = true;
        }
        if(grid[ghost3YPos][ghost3XPos].equals("⚪")){
          ghost3SteppedOnPower = true;
        }
        

        grid[ghost3YPos][ghost3XPos] = "⛄";

        }

        else if(ghost3Movment.equals("d") && ghost3XPos+1 >= grid[0].length-1){

        ghost3XPos = 0;

        

        grid[ghost3YPos][ghost3XPos] = "⛄";

        }

        else if(ghost3Movment.equals("a") && ghost3XPos-1 >= 0 && !(grid[ghost3YPos][ghost3XPos-1].equals("🟦")) && !(grid[ghost3YPos][ghost3XPos-1].equals("🟥"))){

          

          if(ghost3StepedOnFood == false){
          grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "🟡";
            ghost3StepedOnFood = false;
          }
          if(ghost3SteppedOnPower == false){
            grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "⚪";
            ghost3SteppedOnPower = false;
          }

        ghost3XPos--;

        if(grid[ghost3YPos][ghost3XPos].equals("🟡")){
          ghost3StepedOnFood = true;
        }
        if(grid[ghost3YPos][ghost3XPos].equals("⚪")){
          ghost3SteppedOnPower = true;
        }
        

        grid[ghost3YPos][ghost3XPos] = "⛄";

        }

        else if(ghost3Movment.equals("a") && ghost3XPos-1 < 0){

        ghost3XPos = grid[0].length-1;
        

        grid[ghost3YPos][ghost3XPos] = "⛄";

        }

        else if(ghost3Movment.equals("w") && ghost3YPos-1 >= 0 && !(grid[ghost3YPos-1][ghost3XPos].equals("🟦")) && !(grid[ghost3YPos-1][ghost3XPos].equals("🟥"))){

          if(ghost3StepedOnFood == false){
          grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "🟡";
            ghost3StepedOnFood = false;
          }
          if(ghost3SteppedOnPower == false){
            grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "⚪";
            ghost3SteppedOnPower = false;
          }

        ghost3YPos--;

        if(grid[ghost3YPos][ghost3XPos].equals("🟡")){
          ghost3StepedOnFood = true;
        }
        if(grid[ghost3YPos][ghost3XPos].equals("⚪")){
          ghost3SteppedOnPower = true;
        }
        

        grid[ghost3YPos][ghost3XPos] = "⛄";

        }

        else if(ghost3Movment.equals("s") && ghost3YPos+1 < grid.length && !(grid[ghost3YPos+1][ghost3XPos].equals("🟦")) && !(grid[ghost3YPos+1][ghost3XPos].equals("🟥"))){

          if(ghost3StepedOnFood == false){
          grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "🟡";
            ghost3StepedOnFood = false;
          }
          if(ghost3SteppedOnPower == false){
            grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "⚪";
            ghost3SteppedOnPower = false;
          }

        ghost3YPos++;

        if(grid[ghost3YPos][ghost3XPos].equals("🟡")){
          ghost3StepedOnFood = true;
        }
        if(grid[ghost3YPos][ghost3XPos].equals("⚪")){
          ghost3SteppedOnPower = true;
        }
        

        grid[ghost3YPos][ghost3XPos] = "⛄";
        

        }
        

        

        System.out.println("\033[H\033[2J");
        print(grid);

        isGameRunning = false;
        for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j].equals("😀")){
              isGameRunning = true;
            }

          }
        }

      }
    }
///////////////////////////////////////////////////////////
    else{
      for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
          if(grid[i][j].equals("👹") || grid[i][j].equals("🧠") || grid[i][j].equals("⛄")){
            grid[i][j] = "💀";
          }
        }
      }

      if(counting == 1){
      //   System.out.println("DNSJANDJSADOASDLKSADLKNASDNJKSANDANSDMDAS");
      //   try{
      //     Thread.sleep(10000);
      //   }
        // catch(Exception e){}
      if(ghost1Movment.equals("d")){
        ghost1Movment = "a";
      }
      else if(ghost1Movment.equals("a")){
        ghost1Movment = "d";
      }
      else if(ghost1Movment.equals("w")){
        ghost1Movment = "s";
      }
      else if(ghost1Movment.equals("s")){
        ghost1Movment = "w";
      }

      if(ghost2Movment.equals("d")){
        ghost2Movment = "a";
      }
      else if(ghost2Movment.equals("a")){
        ghost2Movment = "d";
      }
      else if(ghost2Movment.equals("w")){
        ghost2Movment = "s";
      }
      else if(ghost2Movment.equals("s")){
        ghost2Movment = "w";
      }

      if(ghost3Movment.equals("d")){
        ghost3Movment = "a";
      }
      else if(ghost3Movment.equals("a")){
        ghost3Movment = "d";
      }
      else if(ghost3Movment.equals("w")){
        ghost3Movment = "s";
      }
      else if(ghost3Movment.equals("s")){
        ghost3Movment = "w";
      }

      }
      else{
        try{
        if((grid[ghost2YPos][ghost2XPos+1].equals("  ") || grid[ghost2YPos][ghost2XPos+1].equals("🟡") || grid[ghost2YPos][ghost2XPos+1].equals("😀")|| grid[ghost2YPos][ghost2XPos+1].equals("⚪")) && !(ghost2Movment.equals("a"))){
          ghost2Movment = "d";
        }
        
        }
        catch(Exception e){}

        try{
        if((grid[ghost2YPos][ghost2XPos-1].equals("  ") ||grid[ghost2YPos][ghost2XPos-1].equals("🟡") || grid[ghost2YPos][ghost2XPos-1].equals("😀")|| grid[ghost2YPos][ghost2XPos-1].equals("⚪")) && !(ghost2Movment.equals("d"))){
          ghost2Movment = "a";
        }
     
        }
        catch(Exception e){}

        try{
        if((grid[ghost2YPos-1][ghost2XPos].equals("  ") ||grid[ghost2YPos-1][ghost2XPos].equals("🟡") || grid[ghost2YPos-1][ghost2XPos].equals("😀")|| grid[ghost2YPos-1][ghost2XPos].equals("⚪")) && !(ghost2Movment.equals("s"))){
          ghost2Movment = "w";
        }
     
        }
        catch(Exception e){}

        try{
        if((grid[ghost2YPos+1][ghost2XPos].equals("  ") ||grid[ghost2YPos+1][ghost2XPos].equals("🟡") || grid[ghost2YPos+1][ghost2XPos].equals("😀")|| grid[ghost2YPos+1][ghost2XPos].equals("⚪")) && !(ghost2Movment.equals("w"))){
          ghost2Movment = "s";
        }
        }
        catch(Exception e){}
        ///
        try{
        if((grid[ghost1YPos][ghost1XPos+1].equals("  ") || grid[ghost1YPos][ghost1XPos+1].equals("🟡") || grid[ghost1YPos][ghost1XPos+1].equals("😀")|| grid[ghost1YPos][ghost1XPos+1].equals("⚪")) && !(ghost1Movment.equals("a"))){
          ghost1Movment = "d";
        }
        
        }
        catch(Exception e){}

        try{
        if((grid[ghost1YPos][ghost1XPos-1].equals("  ") ||grid[ghost1YPos][ghost1XPos-1].equals("🟡") || grid[ghost1YPos][ghost1XPos-1].equals("😀")|| grid[ghost1YPos][ghost1XPos-1].equals("⚪")) && !(ghost1Movment.equals("d"))){
          ghost1Movment = "a";
        }
     
        }
        catch(Exception e){}

        try{
        if((grid[ghost1YPos-1][ghost1XPos].equals("  ") ||grid[ghost1YPos-1][ghost1XPos].equals("🟡") || grid[ghost1YPos-1][ghost1XPos].equals("😀")|| grid[ghost1YPos-1][ghost1XPos].equals("⚪")) && !(ghost1Movment.equals("s"))){
          ghost1Movment = "w";
        }
     
        }
        catch(Exception e){}

        try{
        if((grid[ghost1YPos+1][ghost1XPos].equals("  ") ||grid[ghost1YPos+1][ghost1XPos].equals("🟡") || grid[ghost1YPos+1][ghost1XPos].equals("😀")|| grid[ghost1YPos+1][ghost1XPos].equals("⚪")) && !(ghost1Movment.equals("w"))){
          ghost1Movment = "s";
        }
        }
        catch(Exception e){}
        ////
        try{
        if((grid[ghost3YPos][ghost3XPos+1].equals("  ") || grid[ghost3YPos][ghost3XPos+1].equals("🟡") || grid[ghost3YPos][ghost3XPos+1].equals("😀")|| grid[ghost3YPos][ghost3XPos+1].equals("⚪")) && !(ghost3Movment.equals("a"))){
          ghost3Movment = "d";
        }
        
        }
        catch(Exception e){}

        try{
        if((grid[ghost3YPos][ghost3XPos-1].equals("  ") ||grid[ghost3YPos][ghost3XPos-1].equals("🟡") || grid[ghost3YPos][ghost3XPos-1].equals("😀")|| grid[ghost3YPos][ghost3XPos-1].equals("⚪")) && !(ghost3Movment.equals("d"))){
          ghost3Movment = "a";
        }
     
        }
        catch(Exception e){}

        try{
        if((grid[ghost3YPos-1][ghost3XPos].equals("  ") ||grid[ghost3YPos-1][ghost3XPos].equals("🟡") || grid[ghost3YPos-1][ghost3XPos].equals("😀")|| grid[ghost3YPos-1][ghost3XPos].equals("⚪")) && !(ghost3Movment.equals("s"))){
          ghost3Movment = "w";
        }
     
        }
        catch(Exception e){}

        try{
        if((grid[ghost3YPos+1][ghost3XPos].equals("  ") ||grid[ghost3YPos+1][ghost3XPos].equals("🟡") || grid[ghost3YPos+1][ghost3XPos].equals("😀")|| grid[ghost3YPos+1][ghost3XPos].equals("⚪")) && !(ghost3Movment.equals("w"))){
          ghost3Movment = "s";
        }
        }
        catch(Exception e){}
      }

        ///
if(ghost1Movment.equals("d") && ghost1XPos+1 < grid[0].length && !(grid[ghost1YPos][ghost1XPos+1].equals("🟦")) && !(grid[ghost1YPos][ghost1XPos+1].equals("🟥"))){

          

          if(ghost1StepedOnFood == false){
          grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "🟡";
            ghost1StepedOnFood = false;
          }

          if(ghost1SteppedOnPower == false){
            grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "⚪";
            ghost1SteppedOnPower = false;
          }

        ghost1XPos++;

        if(grid[ghost1YPos][ghost1XPos].equals("🟡")){
          ghost1StepedOnFood = true;
        }
        if(grid[ghost1YPos][ghost1XPos].equals("⚪")){
          ghost1SteppedOnPower = true;
        }
        

        grid[ghost1YPos][ghost1XPos] = "💀";

        }

        else if(ghost1Movment.equals("d") && ghost1XPos+1 >= grid[0].length-1){

        ghost1XPos = 0;

        

        grid[ghost1YPos][ghost1XPos] = "💀";

        }

        else if(ghost1Movment.equals("a") && ghost1XPos-1 >= 0 && !(grid[ghost1YPos][ghost1XPos-1].equals("🟦")) && !(grid[ghost1YPos][ghost1XPos-1].equals("🟥"))){

          

          if(ghost1StepedOnFood == false){
          grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "🟡";
            ghost1StepedOnFood = false;
          }
          if(ghost1SteppedOnPower == false){
            grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "⚪";
            ghost1SteppedOnPower = false;
          }

        ghost1XPos--;

        if(grid[ghost1YPos][ghost1XPos].equals("🟡")){
          ghost1StepedOnFood = true;
        }
        if(grid[ghost1YPos][ghost1XPos].equals("⚪")){
          ghost1SteppedOnPower = true;
        }
        

        grid[ghost1YPos][ghost1XPos] = "💀";

        }

        else if(ghost1Movment.equals("a") && ghost1XPos-1 < 0){

        ghost1XPos = grid[0].length-1;
        

        grid[ghost1YPos][ghost1XPos] = "💀";

        }

        else if(ghost1Movment.equals("w") && ghost1YPos-1 >= 0 && !(grid[ghost1YPos-1][ghost1XPos].equals("🟦")) && !(grid[ghost1YPos-1][ghost1XPos].equals("🟥"))){

          if(ghost1StepedOnFood == false){
          grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "🟡";
            ghost1StepedOnFood = false;
          }

          if(ghost1SteppedOnPower == false){
            grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "⚪";
            ghost1SteppedOnPower = false;
          }

        ghost1YPos--;

        if(grid[ghost1YPos][ghost1XPos].equals("🟡")){
          ghost1StepedOnFood = true;
        }
        if(grid[ghost1YPos][ghost1XPos].equals("⚪")){
          ghost1SteppedOnPower = true;
        }
        

        grid[ghost1YPos][ghost1XPos] = "💀";

        }

        else if(ghost1Movment.equals("s") && ghost1YPos+1 < grid.length && !(grid[ghost1YPos+1][ghost1XPos].equals("🟦")) && !(grid[ghost1YPos+1][ghost1XPos].equals("🟥"))){

          if(ghost1StepedOnFood == false){
          grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "🟡";
            ghost1StepedOnFood = false;
          }

          if(ghost1SteppedOnPower == false){
            grid[ghost1YPos][ghost1XPos] = "  ";
          }
          else{
            grid[ghost1YPos][ghost1XPos] = "⚪";
            ghost1SteppedOnPower = false;
          }

        ghost1YPos++;

        if(grid[ghost1YPos][ghost1XPos].equals("🟡")){
          ghost1StepedOnFood = true;
        }
        if(grid[ghost1YPos][ghost1XPos].equals("⚪")){
          ghost1SteppedOnPower = true;
        }
        

        grid[ghost1YPos][ghost1XPos] = "💀";

        }

        

        System.out.println("\033[H\033[2J");
        print(grid);

        // isGameRunning = false;
        // for(int i = 0; i < grid.length; i++){
        //   for(int j = 0; j < grid[0].length; j++){
        //     if(grid[i][j].equals("😀")){
        //       isGameRunning = true;
        //     }

        //   }
        // }
        ///
        if(ghost2Movment.equals("d") && ghost2XPos+1 < grid[0].length && !(grid[ghost2YPos][ghost2XPos+1].equals("🟦")) && !(grid[ghost2YPos][ghost2XPos+1].equals("🟥"))){

          

          if(ghost2StepedOnFood == false){
          grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "🟡";
            ghost2StepedOnFood = false;
          }

          if(ghost2SteppedOnPower == false){
            grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "⚪";
            ghost2SteppedOnPower = false;
          }

        ghost2XPos++;

        if(grid[ghost2YPos][ghost2XPos].equals("🟡")){
          ghost2StepedOnFood = true;
        }
        if(grid[ghost2YPos][ghost2XPos].equals("⚪")){
          ghost2SteppedOnPower = true;
        }
        

        grid[ghost2YPos][ghost2XPos] = "💀";

        }

        else if(ghost2Movment.equals("d") && ghost2XPos+1 >= grid[0].length-1){

        ghost2XPos = 0;

        

        grid[ghost2YPos][ghost2XPos] = "💀";

        }

        else if(ghost2Movment.equals("a") && ghost2XPos-1 >= 0 && !(grid[ghost2YPos][ghost2XPos-1].equals("🟦")) && !(grid[ghost2YPos][ghost2XPos-1].equals("🟥"))){

          

          if(ghost2StepedOnFood == false){
          grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "🟡";
            ghost2StepedOnFood = false;
          }

          if(ghost2SteppedOnPower == false){
            grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "⚪";
            ghost2SteppedOnPower = false;
          }

        ghost2XPos--;

        if(grid[ghost2YPos][ghost2XPos].equals("🟡")){
          ghost2StepedOnFood = true;
        }

        if(grid[ghost2YPos][ghost2XPos].equals("⚪")){
          ghost2SteppedOnPower = true;
        }
        

        grid[ghost2YPos][ghost2XPos] = "💀";

        }

        else if(ghost2Movment.equals("a") && ghost2XPos-1 < 0){

        ghost2XPos = grid[0].length-1;
        

        grid[ghost2YPos][ghost2XPos] = "💀";

        }

        else if(ghost2Movment.equals("w") && ghost2YPos-1 >= 0 && !(grid[ghost2YPos-1][ghost2XPos].equals("🟦")) && !(grid[ghost2YPos-1][ghost2XPos].equals("🟥"))){

          if(ghost2StepedOnFood == false){
          grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "🟡";
            ghost2StepedOnFood = false;
          }

          if(ghost2SteppedOnPower == false){
            grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "⚪";
            ghost2SteppedOnPower = false;
          }

        ghost2YPos--;

        if(grid[ghost2YPos][ghost2XPos].equals("🟡")){
          ghost2StepedOnFood = true;
        }
        if(grid[ghost2YPos][ghost2XPos].equals("⚪")){
          ghost2SteppedOnPower = true;
        }
        

        grid[ghost2YPos][ghost2XPos] = "💀";

        }

        else if(ghost2Movment.equals("s") && ghost2YPos+1 < grid.length && !(grid[ghost2YPos+1][ghost2XPos].equals("🟦")) && !(grid[ghost2YPos+1][ghost2XPos].equals("🟥"))){

          if(ghost2StepedOnFood == false){
          grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "🟡";
            ghost2StepedOnFood = false;
          }

          if(ghost2SteppedOnPower == false){
            grid[ghost2YPos][ghost2XPos] = "  ";
          }
          else{
            grid[ghost2YPos][ghost2XPos] = "⚪";
            ghost2SteppedOnPower = false;
          }

        ghost2YPos++;

        if(grid[ghost2YPos][ghost2XPos].equals("🟡")){
          ghost2StepedOnFood = true;
        }
        if(grid[ghost2YPos][ghost2XPos].equals("⚪")){
          ghost2SteppedOnPower = true;
        }
        
        

        grid[ghost2YPos][ghost2XPos] = "💀";
        

        }

        

        System.out.println("\033[H\033[2J");
        print(grid);

        // isGameRunning = false;
        // for(int i = 0; i < grid.length; i++){
        //   for(int j = 0; j < grid[0].length; j++){
        //     if(grid[i][j].equals("😀")){
        //       isGameRunning = true;
        //     }

        //   }
        // }

        ////

        if(ghost3Movment.equals("d") && ghost3XPos+1 < grid[0].length && !(grid[ghost3YPos][ghost3XPos+1].equals("🟦")) && !(grid[ghost3YPos][ghost3XPos+1].equals("🟥"))){

          

          if(ghost3StepedOnFood == false){
          grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "🟡";
            ghost3StepedOnFood = false;
          }
          if(ghost3SteppedOnPower == false){
            grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "⚪";
            ghost3SteppedOnPower = false;
          }

        ghost3XPos++;

        if(grid[ghost3YPos][ghost3XPos].equals("🟡")){
          ghost3StepedOnFood = true;
        }
        if(grid[ghost3YPos][ghost3XPos].equals("⚪")){
          ghost3SteppedOnPower = true;
        }
        

        grid[ghost3YPos][ghost3XPos] = "💀";

        }

        else if(ghost3Movment.equals("d") && ghost3XPos+1 >= grid[0].length-1){

        ghost3XPos = 0;

        

        grid[ghost3YPos][ghost3XPos] = "💀";

        }

        else if(ghost3Movment.equals("a") && ghost3XPos-1 >= 0 && !(grid[ghost3YPos][ghost3XPos-1].equals("🟦")) && !(grid[ghost3YPos][ghost3XPos-1].equals("🟥"))){

          

          if(ghost3StepedOnFood == false){
          grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "🟡";
            ghost3StepedOnFood = false;
          }
          if(ghost3SteppedOnPower == false){
            grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "⚪";
            ghost3SteppedOnPower = false;
          }

        ghost3XPos--;

        if(grid[ghost3YPos][ghost3XPos].equals("🟡")){
          ghost3StepedOnFood = true;
        }
        if(grid[ghost3YPos][ghost3XPos].equals("⚪")){
          ghost3SteppedOnPower = true;
        }
        

        grid[ghost3YPos][ghost3XPos] = "💀";

        }

        else if(ghost3Movment.equals("a") && ghost3XPos-1 < 0){

        ghost3XPos = grid[0].length-1;
        

        grid[ghost3YPos][ghost3XPos] = "💀";

        }

        else if(ghost3Movment.equals("w") && ghost3YPos-1 >= 0 && !(grid[ghost3YPos-1][ghost3XPos].equals("🟦")) && !(grid[ghost3YPos-1][ghost3XPos].equals("🟥"))){

          if(ghost3StepedOnFood == false){
          grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "🟡";
            ghost3StepedOnFood = false;
          }
          if(ghost3SteppedOnPower == false){
            grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "⚪";
            ghost3SteppedOnPower = false;
          }

        ghost3YPos--;

        if(grid[ghost3YPos][ghost3XPos].equals("🟡")){
          ghost3StepedOnFood = true;
        }
        if(grid[ghost3YPos][ghost3XPos].equals("⚪")){
          ghost3SteppedOnPower = true;
        }
        

        grid[ghost3YPos][ghost3XPos] = "💀";

        }

        else if(ghost3Movment.equals("s") && ghost3YPos+1 < grid.length && !(grid[ghost3YPos+1][ghost3XPos].equals("🟦")) && !(grid[ghost3YPos+1][ghost3XPos].equals("🟥"))){

          if(ghost3StepedOnFood == false){
          grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "🟡";
            ghost3StepedOnFood = false;
          }
          if(ghost3SteppedOnPower == false){
            grid[ghost3YPos][ghost3XPos] = "  ";
          }
          else{
            grid[ghost3YPos][ghost3XPos] = "⚪";
            ghost3SteppedOnPower = false;
          }

        ghost3YPos++;

        if(grid[ghost3YPos][ghost3XPos].equals("🟡")){
          ghost3StepedOnFood = true;
        }
        if(grid[ghost3YPos][ghost3XPos].equals("⚪")){
          ghost3SteppedOnPower = true;
        }
        

        grid[ghost3YPos][ghost3XPos] = "💀";
        

        }
        

        

        System.out.println("\033[H\033[2J");
        print(grid);

        boolean playerFound = false;
        for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j].equals("😀")){
              playerFound = true;
            }

          }
        }

        if(playerFound == false){
          grid[playerYPos][playerXPos] = "😀";
        }
      //}
      if(playerXPos == ghost1XPos && playerYPos == ghost1YPos){
            ghost1XPos = 11;
            ghost1YPos = 14;
            grid[ghost1YPos][ghost1XPos] = "👹";
            
          }
          else if(playerXPos == ghost2XPos && playerYPos == ghost2YPos){
            ghost2XPos = 13;
            ghost2YPos = 14;
            grid[ghost2YPos][ghost2XPos] = "🧠";
          }
          else if(playerXPos == ghost3XPos && playerYPos == ghost3YPos){
            ghost3XPos = 15;
            ghost3YPos = 14;
            grid[ghost3YPos][ghost3XPos] = "⛄";
          }
      // frightened = false;
      counting++;
      if(counting == 15){
        counting = 1;
        frightened = false;
        
        

          if(ghost1XPos == 14 && ghost1YPos == 11){
            grid[11][13] = "👹";
            grid[14][11] = "  ";
            ghost1XPos = 11;
            ghost1YPos = 14;
          }
          if(ghost2XPos == 14 && ghost2YPos == 13){
            grid[11][12] = "🧠";
            grid[14][11] = "  ";
            ghost2XPos = 13;
            ghost2YPos = 11;
          }
          if(ghost3XPos == 14 && ghost3YPos == 15){
            grid[11][14] = "⛄";
            grid[14][15] = "  ";
            ghost3XPos = 15;
            ghost3YPos = 14;
          }

      }
    }
      
      try{
          Thread.sleep(400); //speed of game
        }
        catch(Exception e){}
     
    }

    if(food != 241){
    System.out.println("\033[H\033[2J");
    System.out.flush();
    System.out.println("You died!");
    youDied = true;
    //death animation
    for(int i = 0; i < grid.length; i++){
          
          for(int j = 0; j < grid[0].length; j++){
            
            grid[i][j] = ANSI_PURPLE + "XX";
            

          

        
            
          }
          // System.out.println("\033[H\033[2J");
          // System.out.flush();
          //             print(grid);

        }
        int startingX;
        int startingY;

        for(int i = 0; i < grid.length-1; i++){
            
            try{
            grid[i][i] = ANSI_RED + "XX";
            }
            catch(Exception e){
              break;
            }
            

        //     print(grid);
            
  
        // System.out.println("\033[H\033[2J");
        // System.out.flush();
            
          
        }
        
        int sides = 0;
        
        for(int i = grid[0].length-1; i >= 0; i--){
            
            try{
            grid[sides][i] = ANSI_RED + "XX";
        }
        catch(Exception e){
          break;
        }
            

        //     print(grid);
        // //     try{
        // // Thread.sleep((long)100);
        // // }
        // // catch(Exception e){}
        // System.out.println("\033[H\033[2J");
        // System.out.flush();
            
          sides++;
        }
        
        // try{
        // Thread.sleep((long)100);
        // }
        
        // catch(Exception e){}
        
        for(int i = 0; i < 5; i++){
        
        for(int j = 0; j < grid.length; j++){
          
          for(int k = 0; k < grid[0].length; k++){
            
            if(grid[j][k].equals(ANSI_RED + "XX")){
              
              grid[j][k] = ANSI_PURPLE + "XX";
            }
            else if(grid[j][k].equals(ANSI_PURPLE + "XX")){
              
              grid[j][k] = ANSI_RED + "XX";
              
            }
            
            
            
          }
          
        }
        
         System.out.println("\033[H\033[2J");
        System.out.flush();
        print(grid);
        try{
        Thread.sleep((long)500);
        }
        
        catch(Exception e){}
        
        
        }
}
   playerYPos = 23;
    playerXPos = 13;
    movment = "secretStopButton";
   food = 0;

    ghost1YPos = 11;
    ghost1XPos = 13;
    ghost1Movment = "";
   ghost1StepedOnFood = false;

    ghost2YPos = 11;
    ghost2XPos = 13;
    ghost2Movment = "";
   ghost2StepedOnFood = false;

    ghost3YPos = 11;
    ghost3XPos = 13;
    ghost3Movment = "";
   ghost3StepedOnFood = false;

   ghost1SteppedOnPower = false;
   ghost2SteppedOnPower = false;
   ghost3SteppedOnPower = false;

   frightened = false;
   counting = 1;

   counterForGost2Activation = 0;
   counterForGost3Activation = 0;

   isGameRunning = true;
   youDied = false;

   for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        grid[i][j] = ANSI_BLUE + "▓▓";
      }
    }

    for(int i = 0; i < grid[0].length; i++){
      grid[0][i] = "🟥";
    }
    for(int i = 0; i < grid[0].length; i++){
      grid[grid.length-1][i] = "🟥";
    }
    for(int i = 0; i < grid.length; i++){
      grid[i][0] = "🟥";
    }
    for(int i = 0; i < grid.length; i++){
      grid[i][grid[0].length-1] = "🟥";
    }

    for(int i = 1; i <= 4; i++){
      grid[i][14] = "🟦";
    }
    for(int i = 1; i <= 4; i++){
      grid[i][13] = "🟦";
    }



    for(int i = 9; i <= 11; i++){
      grid[i][15] =  ANSI_PURPLE + "██";
    }
    for(int i = 9; i <= 11; i++){
      grid[i][12] =  ANSI_PURPLE + "██";
    }
    for(int i = 9; i <= 18; i++){
        grid[11][i] = ANSI_PURPLE + "██";
    }

    for(int i = 11; i <= 19; i++){
      grid[i][9] = ANSI_PURPLE + "██";
    }
    for(int i = 11; i <= 19; i++){
      grid[i][18] = ANSI_PURPLE + "██";
    }

    for(int i = 9; i <= 18; i++){
        grid[17][i] = ANSI_PURPLE + "██";
    }

    for(int i = 18; i <= grid[0].length-1; i++){
      grid[14][i] = ANSI_PURPLE + "██";
    }

    for(int i = 0; i <= 9; i++){
      grid[14][i] = ANSI_PURPLE + "██";
    }
   
   

    for(int i = 1; i <= 12; i++){
    grid[1][i] = "🟡";
    }
    for(int i = 1; i < grid[0].length-1; i++){
    grid[5][i] = "🟡";
    }
    for(int i = 1; i <= 8; i++){
    grid[i][1] = "🟡";
    }
    for(int i = 1; i <= 6; i++){
    grid[8][i] = "🟡";
    }
    for(int i = 1; i <= 5; i++){
      grid[i][12] = "🟡";
    }

    for(int i = 1; i < grid.length - 4; i++){
      grid[i][6] = "🟡";
    }
    for(int i = 5; i <= 8; i++){
    grid[i][9] = "🟡";
    }
    for(int i = 10; i <= 12; i++){
    grid[8][i] = "🟡";
    }

    for(int i = 1;i <= 4; i++){
      grid[i][15] = "🟡";
    }

    for(int i = 16; i < grid[0].length-1; i++){

      grid[1][i] = "🟡";

    }

    for(int i = 2; i < grid.length - 4; i++){
      grid[i][21] = "🟡";
    }

    for(int i = 2; i <= 8; i++){
      grid[i][grid[0].length-2] = "🟡";
    }

    for(int i = grid[0].length-6; i < grid[0].length - 1; i++){
        grid[8][i] = "🟡";
    }

    for(int i = 15; i <= 18; i++){
    grid[8][i] = "🟡";
    }

    for(int i = 6; i <= 8; i++){
      grid[i][18] = "🟡";
    }
   
   for(int i = 1; i <= grid[0].length - 2; i++){

     grid[grid.length-2][i] = "🟡";

   }
   
   for(int i = grid.length - 5; i <= grid.length - 3; i++){

     grid[i][1] = "🟡";

   }

   for(int i = grid.length - 5; i <= grid.length - 3; i++){

     grid[i][grid[0].length-2] = "🟡";

   }

   for(int i = 2; i <= 6; i++){

     grid[grid.length-5][i] = "🟡";

   }

   for(int i = grid[0].length-6; i <= grid[0].length-2; i++){

     grid[grid.length-5][i] = "🟡";

   }  

   for(int i = grid[0].length-5; i < grid[0].length-2; i++){
     grid[i][3] = "🟡";
   }
   for(int i = grid[0].length-5; i < grid[0].length-2; i++){
     grid[i][grid[0].length-4] = "🟡";
   }

     grid[grid[0].length-5][grid[0].length-3] = "🟡";
     grid[grid[0].length-5][grid[0].length-2] = "🟡";

     grid[grid[0].length-6][grid[0].length-2] = "🟡";
     grid[grid[0].length-7][grid[0].length-2] = "🟡";
     grid[grid[0].length-8][grid[0].length-2] = "🟡";

     grid[grid[0].length-5][2] = "🟡";
     grid[grid[0].length-5][1] = "🟡";

     grid[grid[0].length-6][1] = "🟡";
     grid[grid[0].length-7][1] = "🟡";
     grid[grid[0].length-8][1] = "🟡";

     for(int i = 1; i <= 12; i++){
       grid[grid[0].length-8][i] = "🟡";
     }

     for(int i = 15; i <= grid[0].length-2; i++){
       grid[grid[0].length-8][i] = "🟡";
     }

     for(int i = 6; i <= 21; i++){
       grid[grid.length-8][i] = "🟡";
     }
    
    for(int i = grid.length-8; i <= grid.length-5; i++){
    grid[i][9] = "🟡";
    }
    for(int i = grid.length-8; i <= grid.length-5; i++){
    grid[i][18] = "🟡";
    }
    
    for(int i = 9; i <= 12; i++){
      grid[grid.length-5][i] = "🟡";
    }

    for(int i = 15; i <= 18; i++){
      grid[grid.length-5][i] = "🟡";
    }

    grid[grid.length-4][15] = "🟡";
    grid[grid.length-3][15] = "🟡";

    grid[grid.length-4][12] = "🟡";
    grid[grid.length-3][12] = "🟡";

    grid[grid.length-10][15] = "🟡";
    grid[grid.length-9][15] = "🟡";

    grid[grid.length-10][12] = "🟡";
    grid[grid.length-9][12] = "🟡";

    for(int i = 0; i < grid.length; i++){
      for(int j = 0; j < grid[0].length; j++){
        if(grid[i][j].equals(ANSI_BLUE + "▓▓")){
          grid[i][j] = "🟦";
        }
        
        else if(grid[i][j].equals(ANSI_PURPLE + "██")){
          grid[i][j] = "  ";
        }
      }
    }

   grid[playerYPos][playerXPos] = "😀";



    grid[14][11] = "👹";
    grid[14][13] = "🧠";
    grid[14][15] = "⛄";
     grid[1][1] = "⚪";
    grid[grid.length-2][1] = "⚪";
    grid[grid.length-2][grid[0].length-2] = "⚪";
    grid[1][grid[0].length-2] = "⚪";
  }
        
        }

}