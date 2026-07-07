

import java.lang.*;
import classes.*;
import interfaces.*;
import java.util.*;
import java.io.*;

class test{
 static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
public static void main(String args[]){


gameAllInfo g1 = new gameAllInfo("tic tac toe ","1300 BC","Some ascribe the origin of Tic-Tac-Toe to the ancient Egyptians,but the most concrete ancient record we have of the game is from the Romans,and the game they referred to as terni lapilli, or three pebbles at a time.","Tic-tac-toe, noughts and crosses, or Xs and Os  is a paper-and-pencil game for two players who take turns marking the spaces in a three-by-three grid with X or O. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row is the winner. It is a solved game, with a forced draw assuming best play from both players.");


gameAllInfo g2 = new gameAllInfo("Snake","1997","Taneli Armanto","Snake is a video game genre where the player manoeuvres a growing line that becomes a primary obstacle to itself.");

Scanner input = new Scanner(System.in);

new test().welcome();
System.out.println("Enter your name please: ");
String name = input.next();
System.out.println("Enter your age please: ");
 int age = input.nextInt();
System.out.println("Enter your gender please: ");
String gender = input.next();

player_Info p = new player_Info(name,age,gender);
p.printPlayerInfo();
try {
      		File file = new File("info.txt");
			if (file.createNewFile()) 
			{
        				System.out.println("File created: " + file.getName());
     			 } 

			else {
        				System.out.println("File Exists.");
      			       }

		FileWriter w = new FileWriter(file,true);


      		w.write(p.getgender()+"\n");
		w.flush();
      		w.close();
      		System.out.println("Your gender has been written to the file!");

		
    	      } 

   	 catch (IOException e) {
      		System.out.println("An error occurred.");
     		e.printStackTrace();
  	  }
System.out.println("-----------------------------------------------------------------------");
System.out.println("----------------------------------------------------------------");
System.out.println("-------------------------------------------------------");


System.out.println("information about our games!");
System.out.println("choose a game for its information");
System.out.println("1. tic-tac-toe\n2. Snake\n");
Scanner q= new Scanner(System.in);
int w=q.nextInt();	

while(w != 1 || w != 2){
switch(w){

		case 1:
	g1.printInfo();
	break;
	case 2:
	g2.printInfo();
	break;
	 default:
System.out.println("You did not choose the correct NUMBER!");
                        break;
}
break;
}


System.out.println("\n");
System.out.println("\n");
System.out.println("--------------------------------------------------------------");





System.out.println("choose a game!");
System.out.println("1. tic-tac-toe\n2. Snake\n3.Exit\n");
int x = input.nextInt();
switch(x){

		case 1:
		  char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '},
                              {'-', '+', '-', '+', '-'},
                              {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);



        while (true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9) :");
            int playerPos = scan.nextInt();

            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions))
            {
                System.out.println("Position Taken!!! Enter a valid position");
                playerPos = scan.nextInt();
            }

            placePiece(gameBoard,playerPos,"player");

            String result = checkWinner();

            if(result.length()>0)
            {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9)+1;

            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos))
            {
                cpuPos = rand.nextInt(9) + 1;
            }

            placePiece(gameBoard,cpuPos,"cpu");

            printGameBoard(gameBoard);

            result = checkWinner();
            if(result.length()>0)
            {
                System.out.println(result);
                break;
            }

        }

			break;
		
  			case 2:
		new GameFrame();
  		
		    break;
 			 default:
 		   System.out.println("----------------------------Thanks---------------------------------");
		
}

}
 public static void printGameBoard(char [][] gameBoard){
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
                    System.out.println();
        }
            }

            public static void placePiece(char[][] gameBoard, int pos, String user)
            {
                char symbol = ' ';
                if(user.equals("player"))
                {
                    symbol ='X';
                    playerPositions.add(pos);
                }
                else if (user.equals("cpu"))
                {
                    symbol = '0';
                    cpuPositions.add(pos);
                }


                switch (pos)
                {
                    case 1: gameBoard[0][0] = symbol ;
                        break;
                    case 2: gameBoard[0][2] = symbol ;
                        break;
                    case 3: gameBoard[0][4] = symbol ;
                        break;
                    case 4: gameBoard[2][0] = symbol ;
                        break;
                    case 5: gameBoard[2][2] = symbol ;
                        break;
                    case 6: gameBoard[2][4] = symbol ;
                        break;
                    case 7: gameBoard[4][0] = symbol ;
                        break;
                    case 8: gameBoard[4][2] = symbol ;
                        break;
                    case 9: gameBoard[4][4] = symbol ;
                        break;
                    default:
                        break;
                }
            }

            public static String checkWinner()
            {
                List topRow = Arrays.asList(1,2,3);
                List midRow = Arrays.asList(4,5,6);
                List botRow = Arrays.asList(7,8,9);

                List leftCol = Arrays.asList(1,4,7);
                List midCol = Arrays.asList(2,5,8);
                List rightCol= Arrays.asList(3,6,9);

                List cross1 = Arrays.asList(1,5,9);
                List cross2 = Arrays.asList(3,5,7);

                List<List> winning = new ArrayList<List>();

                winning.add(topRow);
                winning.add(midRow);
                winning.add(botRow);
                winning.add(leftCol);
                winning.add(midCol);
                winning.add(rightCol);
                winning.add(cross1);
                winning.add(cross2);

                for(List l : winning)
                {
                    if(playerPositions.containsAll(l))
                    {
                        return "Congratulation you Won!!!";
                    }
                    else if(cpuPositions.containsAll(l))
                    {
                        return "CPU wins!!! Sorry !!! Try Again";
                    }
                    else if(playerPositions.size()+cpuPositions.size()==9)
                    {
                        return "OOPS!!! Try Again !!!";
                    }
                }


                return "";
            }
public final void welcome(){		
System.out.println("--------------------------------welcome--------------------------------");
System.out.println("----------------------------------------------------------------");
System.out.println("-------------------------------------------------------");}
}

