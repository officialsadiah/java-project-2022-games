package classes;
import interfaces.*;
import java.lang.*;
class gameDetails implements game_Info{

public String gameName;
public String gameInvention;
public String gameOrigin;

gameDetails(){
}

gameDetails(String n, String Inv, String o){
	this.gameName=n;
	this.gameInvention=Inv;
	this.gameOrigin=o;
}

public void setgameName(String n) {
	this.gameName = n;}
public void setgameInvention(String Inv) {
	this.gameInvention = Inv;}
public void setgameOrigin(String o) {
	this.gameOrigin = o;}

public String getgameName() {
	return gameName;}
public String getgameInvention() {
	return gameInvention;}
public String getgameOrigin() {
	return gameOrigin;}
  
public void printInfo(){
	System.out.println("The name of the game is: "+gameName);
	System.out.println("The game was invented in: "+gameInvention);
	System.out.println("The origin of the game is: "+gameOrigin);
	System.out.println();
}

}