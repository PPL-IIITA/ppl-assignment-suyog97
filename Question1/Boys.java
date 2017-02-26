/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suyog Surana
 */
import java.io.*;
import java.util.*;
/**
 * 
 * @author Suyog Surana
 */
public class Boys {
    
	String name;
	int intelligenceLevel;
	int attractivnessLevel;
	int minimumattr_req;
	String status;
	int budget;
	String girlFriendName;
        
	Boys(){
		intelligenceLevel = 0;
		attractivnessLevel = 0;
		minimumattr_req = 0;
		status = "single";
		budget = 0;
		girlFriendName = " ";
		name = " ";
	}
        /**
         * 
         * @param g
         * @return 
         */
	boolean elligibility_criteria_check(Girls g){
		if(this.budget >= g.budget && this.minimumattr_req <= g.attractivnessLevel && "single".equals(status) && "single".equals(g.status))
                    return true;
                return false;
	}
        
	void generate(){
		try{
                    //Random randBoy = new Random();
                    //char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                    //StringBuilder sb = new StringBuilder();
                    try (FileWriter boyFile = new FileWriter("boys.csv")) {
                        //Random randBoy = new Random();
                        //char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                        //StringBuilder sb = new StringBuilder();
                        for(int k=1;k<=80;k++){
                            Random random = new Random();
                            Random randBoy = new Random();
                            /*for (int i = 0; i < 10; i++) {
                            char c = alpha[random.nextInt(alpha.length)];
                            sb.append(c);
                            }*/
                            //String outputName = sb.toString();
                            boyFile.write("boy"+k+","+randBoy.nextInt(10)+","+randBoy.nextInt(10)+","+randBoy.nextInt(10)+","+randBoy.nextInt(1000)+","+"Single"+"\n");
                          
                        }
                        boyFile.close();
                    }
			}catch(IOException e){		
				
			}
	}
}	
