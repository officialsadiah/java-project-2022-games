package classes;
import interfaces.*;
import java.lang.*;
public class gameAllInfo extends gameDetails implements game_Info {
public String basicInfo;
public gameDetails Info[] = new gameDetails[2];

public gameAllInfo(){}

public gameAllInfo(String x, String y, String z ,String s){
super(x,y,z);
this.basicInfo=s;
}


public void setbasicInfo(String s){
	this.basicInfo=s;}
public String getbasicInfo(){
	return basicInfo;}

public void printInfo(){System.out.println("The name of the game is: "+gameName);
	System.out.println("The game was invented in: "+gameInvention);
	System.out.println("The origin of the game is: "+gameOrigin);
	System.out.println("More information about this game: "+basicInfo);
	System.out.println();
}

}

