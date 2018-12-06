

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class lable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			readLables();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readLables() throws FileNotFoundException{
		JSONParser parser=new JSONParser();//
		String filename= "D:/Ava/Empirical2018/repackaging_pairs.txt";//"C:/Ava/Empirical/repackagedAppsDetailsF.csv";
		String outputfile="D:/Ava/Empirical2018/repackagedMalwareLabel-name-type-new.csv";
		
		BufferedWriter bw=null;
		BufferedReader br=null;
		String csvSplitBy=",";
		String line="";
		int LINE_NO=0;
		int count=0;
		try {
			Object object = parser.parse(new FileReader("D:/Ava/Empirical2018/journal/euphony/proposedName.json"));
			Object object1 = parser.parse(new FileReader("D:/Ava/Empirical2018/journal/euphony/proposedType.json"));
			JSONObject obj =  (JSONObject) object;
			JSONObject obj1 =  (JSONObject) object1;
			br = new BufferedReader(new FileReader(filename));
			bw= new BufferedWriter(new FileWriter(outputfile));

			line=br.readLine();//read header
			line=br.readLine();

			do{
				LINE_NO++;
				String[] pair=line.split(csvSplitBy);
				//String originalAppSHA = pair[0];
				String repackagedAppSHA = pair[1];//sha256
				String malware=(String)obj.get(repackagedAppSHA.toLowerCase());//"83f2045d9b56031dae88c01c2e2c7df159ad3c070b332ccdc25b62a134cae879");
				String type=(String)obj1.get(repackagedAppSHA.toLowerCase());
				System.out.println(repackagedAppSHA +":	"+malware+" : "+type);
				if(malware!=null && type!=null){
					//malware="";
					count++;
					System.out.println(LINE_NO+","+repackagedAppSHA+","+malware+","+type+",");
					bw.append(LINE_NO+","+repackagedAppSHA+","+malware+","+type+",");
					bw.newLine();
					bw.flush();

					}
				line=br.readLine();

			}while(line!=null);
			
			bw.close();
			System.out.println("Count:"+count);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Count:"+count);

			e.printStackTrace();
		}
		
		
	}
	public static void readLablesFile() throws FileNotFoundException{
		JSONParser parser=new JSONParser();//
		String filename= "C:/Ava/Empirical/repackaging_pairs.txt";//"C:/Ava/Empirical/repackagedAppsDetailsF.csv";
		String outputfile="C:/Ava/Empirical/repackagedMalwareLabel0.csv";
		String jfilename= "C:/Ava/labels/names/proposed.json";

		BufferedWriter bw=null;
		BufferedReader br=null;
		BufferedReader jbr=null;
		String csvSplitBy=",";
		String line="";
		int LINE_NO=0;
		try {
			//Object object = parser.parse(new FileReader("C:/Ava/labels/names/proposed.json"));
			//JSONObject obj =  (JSONObject) object;
			br = new BufferedReader(new FileReader(filename));
			bw= new BufferedWriter(new FileWriter(outputfile));
			jbr = new BufferedReader(new FileReader(jfilename));

			line=br.readLine();//read header
			line=br.readLine();
			do{
				
				LINE_NO++;
				String[] pair=line.split(csvSplitBy);
				//String originalAppSHA = pair[0];
				String repackagedAppSHA = pair[1];//sha256
				jbr = new BufferedReader(new FileReader(jfilename));
				String jLine=jbr.readLine();
				boolean found=false;
				while(jLine!=null & !found){
               		
    				if(!found && jLine!=null && jLine.contains(repackagedAppSHA.toLowerCase())){
                       	System.out.println(	LINE_NO+"*" + jLine);
                       	/*
                       	String malware=(String)obj.get(repackagedAppSHA);//"83f2045d9b56031dae88c01c2e2c7df159ad3c070b332ccdc25b62a134cae879");
        				System.out.println(repackagedAppSHA +"	"+malware);
        				if(malware==null || malware=="")
        					malware="";
        				bw.append(LINE_NO+","+repackagedAppSHA+","+malware+",");
        				bw.newLine();
                       	
                       	*/
               			found=true;
               		}
    				//System.out.println(	LINE_NO);
               		jLine=jbr.readLine();
				}
				/*
				
				String malware=(String)obj.get(repackagedAppSHA);//"83f2045d9b56031dae88c01c2e2c7df159ad3c070b332ccdc25b62a134cae879");
				System.out.println(repackagedAppSHA +"	"+malware);
				if(malware==null || malware=="")
					malware="";
				bw.append(LINE_NO+","+repackagedAppSHA+","+malware+",");
				bw.newLine();
				*/
				jbr.close();
				line=br.readLine();
				//System.out.println(	line);
			}while(line!=null);
			bw.close();
		} catch (IOException e /*| ParseException e*/) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		
		
	}

}
