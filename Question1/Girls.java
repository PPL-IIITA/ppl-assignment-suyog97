
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Girls{
	String name;
	int intelligenceLevel;
	int attractivnessLevel;
	String status;
	int budget;
	String boyFriendName;

	Girls(){
		intelligenceLevel = 0;
		attractivnessLevel = 0;
		status = "single";
		budget = 0;
		boyFriendName = " ";
		name = " ";
	}
        /**
         * 
         * @param b
         * @return 
         */
	boolean elligibility_criteria_check(Boys b){
		if(this.budget <= b.budget && "single".equals(status))
                    return true;
                return false;
	}
        void generate(){
		try{
                    //Random randGirl = new Random();
                    //char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                    //StringBuilder sb = new StringBuilder();
                    try (FileWriter girlFile = new FileWriter("girls.csv")) {
                        //Random randGirl = new Random();
                        //char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                        //StringBuilder sb = new StringBuilder();
                        for(int k=1;k<=25;k++){
                            Random random = new Random();
                            Random randGirl = new Random();
                            /*for (int i = 0; i < 10; i++) {
                            char c = alpha[random.nextInt(alpha.length)];
                            sb.append(c);
                            }*/
                            //String outputName = sb.toString();
                            girlFile.write("girl"+k+","+randGirl.nextInt(10)+","+randGirl.nextInt(10)+","+randGirl.nextInt(10)+","+randGirl.nextInt(1000)+","+"Single"+"\n");
                            
                        }
                        
                        girlFile.close();
                    }
			}catch(IOException e){		
				
			}
	}
}	
