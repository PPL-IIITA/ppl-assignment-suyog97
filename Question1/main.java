import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Suyog Surana
 */
public class main{
        /**
         * 
         * @param args 
         */
	public static void main(String args[]){
		Boys b[] = new Boys[80];
		Girls g[] = new Girls[25];
	        Boys bo=new Boys();
                        bo.generate();
                Girls gi=new Girls();
                gi.generate();
		BufferedReader buffer = null;
		int i=0 ,j=0;
		String line = "";
		int k,l;
		int f = 0;
		try{
				buffer = new BufferedReader(new FileReader("boys.csv"));
				while((line = buffer.readLine() )!= null){
				String[] boys_table = line.split(",");
				b[i] = new Boys();
                                b[i].name = boys_table[0];
                                //System.out.print(b[i].name);
				b[i].intelligenceLevel= Integer.parseInt(boys_table[1]);
				b[i].attractivnessLevel= Integer.parseInt(boys_table[2]);
				b[i].minimumattr_req = Integer.parseInt(boys_table[3]);
				b[i].budget = Integer.parseInt(boys_table[4]);
				//b[i].girlFriendName="";
				b[i].status = boys_table[5];
                                i++;
                               // System.out.println(line);
			
                          }

                }catch(IOException e){

                }
                
		buffer = null;
                
		try{
			buffer= new BufferedReader(new FileReader("girls.csv"));
			while((line = buffer.readLine() )!= null){
				String[] girls_table = line.split(",");
					g[j] = new Girls();
			    g[j].name = girls_table[0];
                            //System.out.print(g[j].name);
				g[j].attractivnessLevel = Integer.parseInt(girls_table[1]);
				g[j].budget = Integer.parseInt(girls_table[4]);
				g[j].intelligenceLevel = Integer.parseInt(girls_table[3]);
				g[j].status = girls_table[5];
				g[j].boyFriendName="";
				j++;//System.out.print(g[j].status);
			}
		}
                catch(FileNotFoundException e){
		}
		catch(IOException e){
			
		}/*finally{
				if(buffer != null){
					try{
						buffer.close();
					}catch(IOException e){
					//e.printStackTrace();
					}
				}
		}*/
                
		for(l=0;l<j;l++){
			for(k=0;k<i;k++){
                            
				if(g[l].budget<=b[k].budget && g[l].status.equals("Single") && b[k].status.equals("Single") && g[l].attractivnessLevel>=b[k].minimumattr_req ){
                                       // System.out.print("fddf");
					b[k].girlFriendName = g[l].name;
					g[l].boyFriendName = b[k].name;
                                       // System.out.print(b[k].girlFriendName);
					b[k].status = "Committed";
					g[l].status = "Committed";								
				}
			}
		}
                try{
                    String log1;
                    BufferedWriter lg=new BufferedWriter(new FileWriter("log.txt"));
                    for(k=0;k<25;k++){
                        if(g[k].status.equals("Committed")){
                            String t1 = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
                            String t2=new SimpleDateFormat("hh.mm.ss").format(new Date());
                            log1=g[k].name +" is committed to "+g[k].boyFriendName+" on "+t1+" at "+t2;
                            lg.write(log1 +"\r\n");
                        } 
                    }
                    lg.close();
                }        
        catch(Exception e){
        }
    }
}
