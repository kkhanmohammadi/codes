import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class kaggle {
	private static int LINE_NO=0;
	private static int NEXT_LINE_NO=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//downloadApps();
		completeData();
		//cleanOriginalData();
	}
	public static void cleanOriginalData(){
		String ofile= "C:/Ava/Docs/Empirical/originalAppsDetailsF.csv";
		String ofileClean="C:/Ava/Docs/Empirical/originalAppsDetailsFNo.csv";//686 //originalAppsDetailesClean 2777
		BufferedReader br=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		try{
			br = new BufferedReader(new FileReader(ofile));
			obw= new BufferedWriter(new FileWriter(ofileClean));
			line=br.readLine();//read header
			//line=br.readLine();// first line
			/*for(int i=0;i<3563;i++)
				line=br.readLine();*/
			//line=br.readLine();// first line
			//the number should be changed???????????????????
   				obw.append(line);
   				obw.newLine();
   				obw.flush();
   				NEXT_LINE_NO++;
				LINE_NO++;
				String[] pair=line.split(csvSplitBy);
				String sha = pair[0];
				System.out.println("SHA: "+sha);
				String nextline=br.readLine();//read header
				LINE_NO++;
				String[] nextPair=nextline.split(csvSplitBy);
				String nextSHA = nextPair[0];
				int APP_No=2;
				do{
	           	while(nextSHA.equals(sha)){
	           		
	           		nextline=br.readLine();
					LINE_NO++;
					
					if(nextline!=null){
						APP_No++;
						nextPair=nextline.split(csvSplitBy);
						nextSHA = nextPair[0];
					}else
						nextSHA="";
				}
	           	sha=nextSHA;
       			obw.append(sha+","+APP_No);
       			obw.newLine();
       			obw.flush();
       			NEXT_LINE_NO++;
       			APP_No=1;
	           	}while( nextline!=null );
			obw.close();
			br.close();
			System.out.println("NEXT_LINE_NO: "+NEXT_LINE_NO);
			System.out.println("LINE_NO: "+LINE_NO);
			//rbw.close();
		}catch(Exception e){
			System.out.println(e.getMessage());

		}finally{
			System.out.println("NEXT_LINE_NO: "+NEXT_LINE_NO);
			System.out.println("LINE_NO: "+LINE_NO);
			try {
				obw.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}
public static void completeData(){
	String pairsFile= "C:/Ava/android/Dataset/theZoo/repackagedAppsDetailsF.csv";
	String latestFile="C:/Ava/Docs/Empirical/apps.csv";
	String ofile="C:/Ava/Docs/Empirical/repackagedAppsDetailsKaggle.csv";
	//String rfile="C:/Ava/android/Dataset/theZoo/repackagedAppsDetailsF.csv";
	BufferedReader br=null;
	BufferedReader lbr=null;
	BufferedWriter obw=null;
	//BufferedWriter rbw=null;
	String line="";
	String csvSplitBy=",";
	try{
		br = new BufferedReader(new FileReader(pairsFile));
		lbr = new BufferedReader(new FileReader(latestFile));
		obw= new BufferedWriter(new FileWriter(ofile));
		//rbw= new BufferedWriter(new FileWriter(rfile));

		line=br.readLine();//read header
		//line=br.readLine();// first line
		/*for(int i=0;i<3563;i++)
			line=br.readLine();*/
		line=br.readLine();// first line
		do{//the number should be changed???????????????????
			
			LINE_NO++;
			String[] pair=line.split(csvSplitBy);
			String packageName = pair[5];
			System.out.println("Package Name: "+packageName);
           	//System.out.println(originalAppSHA);
           //	System.out.println("*"+repackagedAppSHA);

           	//find apps in latest and copy that lines to pairesdetails.csv
           	//findInLatest(originalAppSHA,repackagedAppSHA, ofile, rfile);
           	//findInLatest(repackagedAppSHA, rfile);
           	String latestLine=lbr.readLine();
           	boolean oFound=false;
           	boolean rFound=false;
           	while(latestLine!=null){
           		latestLine=lbr.readLine();
				//LINE_NO++;

               	//System.out.println(latestLine);

           		if(!oFound && latestLine!=null && latestLine.contains(packageName)){
                   	System.out.println(	LINE_NO + "*" + latestLine);
                   	
           			obw.append(latestLine);
           			obw.newLine();
           			obw.flush();
           			oFound=true;
           		}

           		if(oFound)
           			break;
           	}
           		lbr.close();
           		lbr = new BufferedReader(new FileReader(latestFile));
           		line=br.readLine();
           	}while( line!=null );
		obw.close();
		//rbw.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
	}


}
}