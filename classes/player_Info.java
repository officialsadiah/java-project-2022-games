package classes;
import java.lang.*;
public class player_Info extends Personal_Info{
public int age;
public String gender;

public player_Info(){
}
public player_Info(String n, int a, String g){
super(n);
this.age=a;
this.gender=g;
}

public void setage(int age){
this.age=age;}
public void setgender(String g){
this.gender=g;}


public int getage(){
return age;}
public String getgender(){
return gender;}
 

public void printPlayerInfo(){
System.out.println("Player: "+name+"\nage: "+age+"\ngender"+gender+"\n");

}


}
