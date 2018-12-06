

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class repackaged {
	final static String folder_name="C:/Ava/android/Dataset/theZoo/repackagedPairs";
	private static final int BUFFER_SIZE = 4096;
    private static final String API_Key= "a222a1ac3914ff140307ad1e3b2189843e721c19920233a359d3cedad70d7ba4";
    private static int LINE_NO = 0;

	public static void main(String[] args) {
		countComponents();
		//permisssionsAdded(); // for deleted files
		
		//createFlist();
		//billingPermission();
		
		//extractaAdwaresPairs();
		//adwareNames();
		//permissionsInPairs();
		//permisssionsAdded();
		
		
		//originalAdinEachLine();
		//copyRepackagedNameTypeUnknown();
		//originalRepackagedAppName();
		//completeDataService();
		//reflectionClassification();
		//trojanClassification();
		//serviceChanged();
		//componentNameAndroguard();
		//createFlist();
		//trojanNames();
		//adwareNames();
		//marketChange();
		//nameChangeComplete();
		//reflectionComplete();
		
		//extractaAdLibrariesInAdwares();
		
		//permisssionsAdded();
		//ComponentAdded();
		//permissionsInPairs();
		//extractaAdwaresPairs();
		//nameChangeMalwareType();
		//FindRepackagedAdsInOriginals();
		//permissionsDeletedInSimilar();
		//permisssionsAdded();
		//permissionsInPairs();
		//ComponentNameSimilarAndroguard();
		//countMarket();
		//apkNameAndroguardComplete();
		//originalAndroguardComplete();--not worked
		//originalCountComponentsCompleteFinal();
		//originalCountComponentsComplete();
		//countComponenbts();
		//completeDataAds();
		//countAds();
		//copy();
		//countMarket();
		//downloadApps();
		//completeData();//3563 apps are read //3563*85715CD54BECC21EE91D95B341B41D7308749E80551A1A3F653AF1173FEB54F6,42e8211c4b7780dde1d74fcbb25da76148a14c8e,ec5bebaf344da41046e0cc073d3886f3,2014-01-13 13:24:32,25720741,"com.teamil.bankheistescape",1,8,2014-05-14 19:57:23,2145900,play.google.com
//15297*FFDD408901CC0AE02A946718F02585438D86371E391FE0A7054F898D99D9BCF1,f2b4ccc0c748397adda32bbec6987a11e4628f72,2073fc8e6e133c863b965abd73535799,2014-07-07 13:44:14,3520930,"com.chinda_property.ecmobile",20140707,0,2014-07-16 05:38:35,2175848,anzhi

		/*
		String ofile="C:/Ava/android/Dataset/theZoo/originalAppsDetails.csv";
		BufferedReader br=null;
		try{
			br = new BufferedReader(new FileReader(ofile));
			String line=br.readLine();//read header
			while(line!=null){
				System.out.println(line);
				System.out.println("*");

				line=br.readLine();//read header

			}
		}catch(Exception e){
			
		}*/



	}
/*
 * Billing permission in Original:643
Billing permission in repackaged:643
Billing permission in both:635
Billing permission in only repackaged:20
Billing permission in only Original:8
all:7912
 */
	
	public static void billingPermission(){//com.android.vending.BILLING
		String pfile="D:/Ava/Empirical2018/adware_pairs-permissions_New.csv";
		BufferedReader pbr=null;
		try{
			pbr = new BufferedReader(new FileReader(pfile));
			String line=pbr.readLine();// first line
			int oCount=0;
			int rCount=0;
			int bothCount=0;
			int onlyR=0;
			int onlyO=0;
			int all=0;

			do{
				String[] pair=line.split(",",-1);
				String oPermission=pair[2];
				String rPermission=pair[3];
				all++;
				
				System.out.println(oPermission+"*"+rPermission);
				if(oPermission.contains("com.android.vending.BILLING")){
					oCount++;
				}
				if(rPermission.contains("com.android.vending.BILLING")){
					rCount++;
				}		
				if(rPermission.contains("com.android.vending.BILLING") && oPermission.contains("com.android.vending.BILLING") ){
					bothCount++;
				}
				if(rPermission.contains("com.android.vending.BILLING") && !oPermission.contains("com.android.vending.BILLING") ){
					onlyR++;
				}	
				if(!rPermission.contains("com.android.vending.BILLING") && oPermission.contains("com.android.vending.BILLING") ){
					onlyO++;
				}
				line=pbr.readLine();
			}while(line!=null);
			System.out.println("Billing permission in Original:"+oCount);
			System.out.println("Billing permission in repackaged:"+oCount);
			System.out.println("Billing permission in both:"+bothCount);
			System.out.println("Billing permission in only repackaged:"+onlyR);
			System.out.println("Billing permission in only Original:"+onlyO);
			System.out.println("all:"+all);


		}
		catch(Exception e){
			System.out.print("Error"+e.getMessage());
			
		}
	}

	
	
	public static void originalAdinEachLine(){
		String pfile="D:/Ava/Empirical2018/originalAdlibraries.csv";
		String pwfile="D:/Ava/Empirical2018/originalAdlibraries-InEachLine.csv";

		//String pfile="C:/Ava/Docs/Empirical/pairs-permissionsChangedInSimilarNumber.csv";//pairs-permissionsAdded.csv";
		//String pwfile="C:/Ava/Docs/Empirical/pairs-permissionsChangedInSimilarNumber-InEachLine.csv";

		BufferedReader pbr=null;
		BufferedWriter pbw=null;
		try{
		pbr = new BufferedReader(new FileReader(pfile));
		pbw= new BufferedWriter(new FileWriter(pwfile));
		String line=pbr.readLine();// first line
		do{
			
			LINE_NO++;
			String[] pair=line.split(",",-1);
			String ad=pair[2];
			String[] ads=ad.split("[|]",-1);
			for(int i=0; i<ads.length;i++){
				pbw.write(ads[i]);
				pbw.newLine();
				pbw.flush();
			}
			line=pbr.readLine();// first line

		}while(line!=null);
		pbw.close();
		}catch(Exception e){
			System.out.println("Error");
			
		}
		
		
	}
	public static void originalRepackagedAppName(){
		String pairFile="D:/Ava/Empirical2018/repackaging_pairs.txt";
		String originalFile= "D:/Ava/Empirical2018/androguardoriginal#1.csv";
		String repackagedFile= "D:/Ava/Empirical2018/androguardRepackaged#1.csv";//originalCountComponents.csv";
		String ofile="D:/Ava/Empirical2018/apkNameOriginalRepackaged-New.csv";//originalCountComponentsComplete.csv";
		//String rfile="C:/Ava/Docs/Empirical/androguardRepackagedCompelete.csv";//originalCountComponentsComplete.csv";

		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter obw=null;
		//BufferedWriter rbw=null;

		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			obw= new BufferedWriter(new FileWriter(ofile));
			//rbw= new BufferedWriter(new FileWriter(rfile));

			line=pairbr.readLine();// header line 7-11
       		System.out.println(line);

			line=pairbr.readLine();// first line

			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println("Original:"+originalSHA);
               	System.out.println("Repackaged:"+repackagedSHA);

               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null && !rFound){
               		//System.out.println(line);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		}
               		if(rFound)
               			break;
               		
               		repackagedLine=rbr.readLine();
               		/*while(repackagedLine!= null && !Character.isDigit(repackagedLine.charAt(0))){
               			System.out.println(repackagedLine.charAt(0)+"is not digit!"+repackagedLine);
                   		repackagedLine=rbr.readLine();
               		}*/
               	}
               	
               	boolean oFound=false;
               	if(rFound){
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	while(originalLine!=null && !oFound){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine);
                               	System.out.println(	LINE_NO+":" +repackagedLine);
                               	
                               	String[] o=originalLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");//originalLine.split(",",-1);
                               	String[] r=repackagedLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");//repackagedLine.split(",",-1);
                               	obw.write(o[0]+","+o[1]+","+r[0]+","+r[1]);
    	               			//rbw.append("\n");
    	               			obw.newLine();
    	               			obw.flush();
    	               			oFound=true;

                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
                       		/*while(originalLine!= null && !Character.isDigit(originalLine.charAt(0))){
                       			System.out.println(originalLine.charAt(0)+"is not Digit");
                           		originalLine=obr.readLine();
                       		}*/
             			}
                     }
               		obr.close();
               		rbr.close();
                              	
               	line=pairbr.readLine();
			}while( line!=null );
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				obw.close();
				//rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void reflectionClassification(){
		String pairFile="D:/Ava/Classification2018/repackagedReflection.csv";
		String trojanFile="D:/Ava/Classification2018/pairs-servicesChanged.csv";
		String trojanTypeFile="D:/Ava/Classification2018/pairs-servicesChanged-reflection.csv";

		BufferedReader nameType=null;
		BufferedReader serviceName=null;

		BufferedWriter serviceNameType=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			serviceName = new BufferedReader(new FileReader(trojanFile));
			serviceNameType = new BufferedWriter(new FileWriter(trojanTypeFile));


          	List<String> mlist=new ArrayList<String>();
          	int trojanNumber=0;
			
			line=serviceName.readLine();// first line
			while(line!=null){
				String[] serviceinfo= line.split("", -1);
				String repackagedSHA=serviceinfo[1];

				nameType = new BufferedReader(new FileReader(pairFile));
				boolean found=false;
				String nt=nameType.readLine();

				while(!found && nt!=null){
					String[] NameTypes=nt.split(",",-1);
					if( NameTypes[1].contains(repackagedSHA)){
						found=true;
						serviceNameType.append(line+","+NameTypes[2]+","+NameTypes[3]);
						serviceNameType.newLine();
						serviceNameType.flush();
					}
					nt=nameType.readLine();
				}
				nameType.close();
				line=serviceName.readLine();
			}
			serviceName.close();

		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
		
	}
	public static void trojanClassification(){
		String pairFile="D:/Ava/Empirical2018/repackagedMalwareLabel-name-type.csv";
		String trojanFile="D:/Ava/Classification2018/pairs-servicesChanged.csv";
		String trojanTypeFile="D:/Ava/Classification2018/pairs-servicesChanged-name-type.csv";

		BufferedReader nameType=null;
		BufferedReader serviceName=null;

		BufferedWriter serviceNameType=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			serviceName = new BufferedReader(new FileReader(trojanFile));
			serviceNameType = new BufferedWriter(new FileWriter(trojanTypeFile));


          	List<String> mlist=new ArrayList<String>();
          	int trojanNumber=0;
			
			line=serviceName.readLine();// first line
			while(line!=null){
				String[] serviceinfo= line.split("", -1);
				String repackagedSHA=serviceinfo[1];

				nameType = new BufferedReader(new FileReader(pairFile));
				boolean found=false;
				String nt=nameType.readLine();

				while(!found && nt!=null){
					String[] NameTypes=nt.split(",",-1);
					if( NameTypes[1].contains(repackagedSHA)){
						found=true;
						serviceNameType.append(line+","+NameTypes[2]+","+NameTypes[3]);
						serviceNameType.newLine();
						serviceNameType.flush();
					}
					nt=nameType.readLine();
				}
				nameType.close();
				line=serviceName.readLine();
			}
			serviceName.close();

		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
		
	}
	public static void createFlist(){
		String pairFile="D:/Ava/Empirical2018/repackagedMalwareLabelNameType-All.csv";//repackagedMalwareLabel-name-type.csv";;//"C:/Ava/Docs/Empirical/repackaging_pairs.csv";
		String listFile="D:/Ava/Empirical2018/Adwares/flist_New_type.csv";//"C:/Ava/Docs/Empirical/repackaging_pairs.csv";

		BufferedReader pairbr=null;
		BufferedWriter flist=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		int count=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			flist = new BufferedWriter(new FileWriter(listFile));

          	List<String> mlist=new ArrayList<String>();
          	int trojanNumber=0;
			
			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String type=pair[3];//malware type
               	String name = pair[2];//malware name
               	String repackagedSHA=pair[1];
				//System.out.println(pair[0]+pair[1]+pair[2]+pair[3]);
               //	if(!line.contains("8BFD26A6304C1BC8DF6583D5FFB02F75462E45E034876597ADD14BD9235027A2")&&!line.contains("008A336ED32BF8B7E6C3ECE1C066642D84CB6606AAE9780CEEAB96D0A8D7F2E0")&&
               //			!line.contains("5E9ED853B790A126F14338F34898A5855771936E6DFF22E8923B114535F96F08")&& !line.contains("684B5745B0DB6DB1540D5299544917E7042737A63827BC5B212D270204F48443")
               	//		&&!line.contains("D1313B19C4545E4B6FE0CD9B60AD967E0CC39D10BD4C4F932D72F43581A23111")){
               	if(type.contains("adware") || type.contains("adsware") || type.contains("addisplay") || type.contains("adload") || type.contains("adware++adware")){
               		if(!mlist.contains(name+"-"+type)){
               			trojanNumber++;
               			mlist.add(name+"-"+type);
               			System.out.println(name+"-"+type);
               			//find original pair
               			String originalSHA=findOriginalPair(repackagedSHA);
               			System.out.println("o: "+originalSHA);
               			//copy repackaged and original to folder trojans
						//find original path
						String originalPath="";
						System.out.println("line:"+line);
						File dir = new File("E:/Ava1/original");
						File[] directoryListing = dir.listFiles();
						boolean found=false;
						if (directoryListing != null){
						    for (File child : directoryListing) {
						      // Do something with child
						    	//System.out.println("for:"+child.getName());
						    	if(child!=null && child.getName().contains(originalSHA) && !found){
						    		System.out.println("original:"+child.getName().substring(0,(child.getName().length()-4)));
						    		originalPath=child.getName().substring(0,child.getName().length()-4);
						    		found=true;
						    		break;
									//System.out.println("2");

						    	}
						    }
						}
						System.out.println("found:"+found);
						
						//find repackaged path
						//System.out.println("3");

						String repackagedPath="";
						dir = new File("E:/Ava1/repackaged");
						directoryListing = dir.listFiles();
						found=false;
						if (directoryListing != null) {
						    for (File child : directoryListing) {
						      // Do something with child
						    	if(child.getName().contains(repackagedSHA) && !found){
						    		System.out.println("repackaged:"+child.getName().substring(0,child.getName().length()-4));
						    		repackagedPath=child.getName().substring(0,child.getName().length()-4);
						    		found=true;
						    		break;
						    	}
						    }
						}
						System.out.println("found:"+found);

						System.out.println("D:/Ava/Empirical2018/Adwares/" + name+"-"+type+"/"+originalPath+"-java,"+"D:/Ava/Empirical2018/Adwares/" + name+"-"+type+"/"+repackagedPath+"-java");
						
						File theDir = new File("D:/Ava/Empirical2018/Adwares/"+name+"-"+type);

						// if the directory does not exist, create it
						
						if (!theDir.exists()) {
						    System.out.println("creating directory: " + theDir.getName());
						    try{
						        theDir.mkdir();
						    } 
						    catch(SecurityException se){
						        //handle it
						    	System.out.println("Make Dir error:"+se.getMessage());
						    } 
						}
						
						
						flist.append("D:/Ava/Empirical2018/Adwares/" + name+"-"+type+"/"+originalPath+"-java,"+"D:/Ava/Empirical2018/Adwares/" + name+"-"+type+"/"+repackagedPath+"-java");
						flist.newLine();
						flist.flush();
						Files.copy((new File("E:/Ava1/original/" +originalPath+".apk")).toPath(),(new File("D:/Ava/Empirical2018/Adwares/" + name+"-"+type+"/"+originalPath+".apk")).toPath(),StandardCopyOption.REPLACE_EXISTING);
						Files.copy((new File("E:/Ava1/repackaged/" +repackagedPath+".apk")).toPath(),(new File("D:/Ava/Empirical2018/Adwares/" + name+"-"+type+"/"+repackagedPath+".apk")).toPath(),StandardCopyOption.REPLACE_EXISTING);
						System.out.print("count:"+count);
						count++;
               		}
               //	}
               	}
               	line=pairbr.readLine();
			}while(line!=null );
			flist.close();
			System.out.println("adware number:"+mlist.size());
			System.out.println("count:"+count);
			for(int i=0;i<mlist.size();i++){
				System.out.print(mlist.get(i)+",");
			}
		}catch(Exception e){
			System.out.println("errrrrrrroorr " + e.toString()+e.fillInStackTrace());
			System.out.println(e.getMessage());
		}
               	
	}
	
	
	public static void copyRepackagedNameTypeUnknown(){
		String pairFile="D:/Ava/Empirical2018/repackagedNameTypeUnknown.csv";;//"C:/Ava/Docs/Empirical/repackaging_pairs.csv";
		BufferedReader pairbr=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
	
			line=pairbr.readLine();// first line
			for(int i=0;i<1276;i++)
				line=pairbr.readLine();
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				//String type=pair[3];//malware type
               	//String name = pair[2];//malware name
               	String repackagedSHA=pair[2];
              			//copy repackaged and original to folder trojans
               		//find repackaged path
				String repackagedPath="";
				File dir = new File("E:/Ava1/repackaged");
				File[] directoryListing = dir.listFiles();
				boolean found=false;
				if (directoryListing != null) {
					for (File child : directoryListing) {
						// Do something with child
						if(child.getName().contains(repackagedSHA) && !found){
							System.out.println(child.getName());
							repackagedPath=child.getName();
							found=true;
						}
					}
				}
				if(repackagedPath!=""){
					Files.copy((new File("E:/Ava1/repackaged/" +repackagedPath)).toPath(),(new File("E:/Ava1/RepackagedNameTypeUnknown/"+repackagedPath)).toPath(),StandardCopyOption.REPLACE_EXISTING);
					System.out.println(repackagedPath);
				}
               	line=pairbr.readLine();
			}while(line!=null);
			
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage()+"|"+e.getLocalizedMessage());
		}
               	
	}
	
	public static void trojanNames(){
		String pairFile="D:/Ava/Empirical2018/repackagedMalwareLabel-name-type.csv";;//"C:/Ava/Docs/Empirical/repackaging_pairs.csv";
		BufferedReader pairbr=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
          	List<String> mlist=new ArrayList<String>();
          	int trojanNumber=0;
			
			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String type=pair[3];//malware type
               	String name = pair[2];//malware name
               	String repackagedSHA=pair[1];
               	if(!type.contains("adware") && !type.contains("adsware")&& !type.contains("addisplay")&& !type.contains("adload")){
               		if(!mlist.contains(name+"-"+type)){
               			trojanNumber++;
               			mlist.add(name+"-"+type);
               			//find original pair
               			String originalSHA=findOriginalPair(repackagedSHA);
               			System.out.println(originalSHA);
               			//copy repackaged and original to folder trojans
						File theDir = new File("D:/Ava/Empirical2018/Trojans/"+name);

						// if the directory does not exist, create it
						
						if (!theDir.exists()) {
						    System.out.println("creating directory: " + theDir.getName());
						    try{
						        theDir.mkdir();
						    } 
						    catch(SecurityException se){
						        //handle it
						    	System.out.println("Make Dir error:"+se.getMessage());
						    } 
						}
						//find original path
						String originalPath="";
						File dir = new File("E:/Ava1/original");
						File[] directoryListing = dir.listFiles();
						boolean found=false;
						if (directoryListing != null) {
						    for (File child : directoryListing) {
						      // Do something with child
						    	if(child.getName().contains(originalSHA) && !found){
						    		System.out.println(child.getName());
						    		originalPath=child.getName();
						    		System.out.println("*"+originalPath+"*");
						    		found=true;
						    	}
						    }
						}

						//find repackaged path
						String repackagedPath="";
						dir = new File("E:/Ava1/repackaged");
						directoryListing = dir.listFiles();
						found=false;
						if (directoryListing != null) {
						    for (File child : directoryListing) {
						      // Do something with child
						    	if(child.getName().contains(repackagedSHA) && !found){
						    		System.out.println(child.getName());
						    		repackagedPath=child.getName();
						    		found=true;
						    	}
						    }
						}
						
						
						Files.copy((new File("E:/Ava1/original/" +originalPath)).toPath(),(new File("D:/Ava/Empirical2018/Trojans/" + name+"/"+originalPath)).toPath(),StandardCopyOption.REPLACE_EXISTING);
						System.out.println("copy");
						Files.copy((new File("E:/Ava1/repackaged/" +repackagedPath)).toPath(),(new File("D:/Ava/Empirical2018/Trojans/" + name+"/"+repackagedPath)).toPath(),StandardCopyOption.REPLACE_EXISTING);
						System.out.println("copy2");


               			
               		}
               	}
               	line=pairbr.readLine();
			}while(line!=null);
			System.out.println("Trojan number:"+mlist.size());
			for(int i=0;i<mlist.size();i++){
				System.out.print(mlist.get(i)+",");
			}
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
               	
	}
	public static String findOriginalPair(String repackagedSHA){
		String pairFile="D:/Ava/Empirical2018/repackaging_pairs_adware_New.csv";//repackaging_pairs_trojan.csv";;//"C:/Ava/Docs/Empirical/repackaging_pairs.csv";
		BufferedReader pairbr=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			line=pairbr.readLine();
			boolean found=false;
			while(line!=null && !found){
				if(line.contains(repackagedSHA)){
					found=true;
					String [] l=line.split(csvSplitBy);
					pairbr.close();
					return l[0];
				}
				line=pairbr.readLine();
			}
			pairbr.close();

			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static void adwareNames(){
		String pairFile="D:/Ava/Empirical2018/repackagedMalwareLabelNameType-All.csv";//"D:/Ava/Empirical2018/repackagedMalwareLabel-name-type.csv";;//
		BufferedReader pairbr=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
          	List<String> mlist=new ArrayList<String>();
          	int adwareNumber=0;
			int adwareCount=0;
			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String type=pair[3];//malware type
               	String name = pair[2];//malware name
               	if(type.contains("adware") || type.contains("adsware") || type.contains("addisplay") || type.contains("adload") || type.contains("adware++adware")){
               		
               		adwareCount++;
               		if(!mlist.contains(name+type)){
               			adwareNumber++;
               			mlist.add(name+type);
               			System.out.println(name+":"+type);
               			
               		}
               	}
               	line=pairbr.readLine();
			}while(line!=null);
			System.out.println("Adware group number:"+mlist.size()+" "+adwareNumber);
			System.out.println("Adware number:"+adwareCount);

			for(int i=0;i<mlist.size();i++){
				System.out.print(mlist.get(i)+",");
			}
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
               	
	}
	public static void reflectionComplete(){
		String pairFile="D:/Ava/Empirical2018/repackaging_pairs_trojan.csv";;//"C:/Ava/Docs/Empirical/repackaging_pairs.csv";
		String originalFile= "D:/Ava/Empirical2018/originalReflection.csv";
		String repackagedFile= "D:/Ava/Empirical2018/repackagedReflection.csv";//originalCountComponents.csv";
		String ofile="D:/Ava/Empirical2018/reflectionComplete_trojan.csv";//originalCountComponentsComplete.csv";
		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			obw= new BufferedWriter(new FileWriter(ofile));
	
			line=pairbr.readLine();// header line 7-11
			
			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println(repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(dataLine);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	//System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		}
               		if(rFound){
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine+"*"+repackagedLine);
                               	obw.append(originalLine);
                               	obw.append(",");
                               	obw.append(repackagedLine);
    	               			//rbw.append("\n");
    	               			obw.newLine();
    	               			obw.flush();
    	               			oFound=true;
                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                       	
               			
               			
               		}
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null);
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
	}	
	public static void nameChangeComplete(){
		String pairFile="D:/Ava/Empirical2018/repackaging_pairs.txt";;//"C:/Ava/Docs/Empirical/repackaging_pairs.csv";
		String originalFile= "D:/Ava/Empirical2018/NameChangeObfuscationOriginal.csv";
		String repackagedFile= "D:/Ava/Empirical2018/NameChangeObfuscationRepackaged.csv";//originalCountComponents.csv";
		String ofile="D:/Ava/Empirical2018/NameChangeComplete1.csv";//originalCountComponentsComplete.csv";
		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			obw= new BufferedWriter(new FileWriter(ofile));
	
			line=pairbr.readLine();// header line 7-11
			
			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println(repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(dataLine);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	//System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		}
               		if(rFound){
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine+"*"+repackagedLine);
                               	obw.append(originalLine);
                               	obw.append(",");
                               	obw.append(repackagedLine);
    	               			//rbw.append("\n");
    	               			obw.newLine();
    	               			obw.flush();
    	               			oFound=true;
                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                       	
               			
               			
               		}
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null);
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
	}	
	public static void extractaAdLibrariesInAdwares(){
		String pairFile="D:/Ava/Empirical2018/repackaging_pairs.txt";
		String typeFile= "D:/Ava/Empirical2018/repackagedMalwareLabelNameType-All.csv";
		String adwarePairFile= "D:/Ava/Empirical2018/repackaging_pairs_adware_New.csv";//
		String trojanPairFile="D:/Ava/Empirical2018/repackaging_pairs_trojan_New.csv";//
		

		BufferedReader pairbr=null;
		BufferedReader tbr=null;
		BufferedWriter abw=null;
		BufferedWriter tbw=null;


		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			tbr= new BufferedReader(new FileReader(typeFile));
			abw= new BufferedWriter(new FileWriter(adwarePairFile));
			tbw= new BufferedWriter(new FileWriter(trojanPairFile));
			
			line=tbr.readLine();// read type line

			do{
				pairbr = new BufferedReader(new FileReader(pairFile));

	       		System.out.println(line);

				LINE_NO++;
				String[] type=line.split(",",-1);
               	String repackagedSHA = type[1];//sha256
               	String repackagedType= type[3];

               	System.out.println("Repackaged:"+repackagedSHA);
				
               	String linePairs=pairbr.readLine();// read header line from pairs

               	linePairs=pairbr.readLine();
               	boolean rFound=false;
               	while(linePairs!=null && !rFound){
    				String[] pairs=linePairs.split(",",-1);
    				String rSHA = pairs[1];//sha256
                   	//String oSHA= pairs[0];
                   	if(rSHA.contains(repackagedSHA)){
                   		if(repackagedType.contains("adware") || repackagedType.contains("adsware") || repackagedType.contains("addisplay") || repackagedType.contains("adload")|| repackagedType.contains("adware++adware"))
                   		{//write in adwares
                   			abw.append(linePairs);
                   			abw.newLine();
                   			abw.flush();
                   		}
                   		else{//write in trojan fil
                   		tbw.append(linePairs);
                   		tbw.newLine();
                   		tbw.flush();
                   		}
                   		rFound=true;
                   	}
                   	linePairs=pairbr.readLine();

               	}
               	pairbr.close();
				line=tbr.readLine();// read type line
			}while(tbr!=null);
			tbw.close();
			abw.close();
		}catch(Exception e){
			System.out.print(e.getMessage());
			
		}
	}
	
	
	
	//extract pair of adwares and trojan from pairs.text
	
	public static void extractaAdwaresPairs(){
		String pairFile="D:/Ava/Empirical2018/repackaging_pairs.txt";
		String typeFile= "D:/Ava/Empirical2018/repackagedMalwareLabelNameType-All.csv";
		String adwarePairFile= "D:/Ava/Empirical2018/repackaging_pairs_adware_New.csv";//
		String trojanPairFile="D:/Ava/Empirical2018/repackaging_pairs_trojan_New.csv";//
		

		BufferedReader pairbr=null;
		BufferedReader tbr=null;
		BufferedWriter abw=null;
		BufferedWriter tbw=null;


		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			tbr= new BufferedReader(new FileReader(typeFile));
			abw= new BufferedWriter(new FileWriter(adwarePairFile));
			tbw= new BufferedWriter(new FileWriter(trojanPairFile));
			
			line=tbr.readLine();// read type line

			do{
				pairbr = new BufferedReader(new FileReader(pairFile));

	       		System.out.println(line);

				LINE_NO++;
				String[] type=line.split(",",-1);
               	String repackagedSHA = type[1];//sha256
               	String repackagedType= type[3];

               	System.out.println("Repackaged:"+repackagedSHA);
				
               	String linePairs=pairbr.readLine();// read header line from pairs

               	linePairs=pairbr.readLine();
               	boolean rFound=false;
               	while(linePairs!=null && !rFound){
    				String[] pairs=linePairs.split(",",-1);
    				String rSHA = pairs[1];//sha256
                   	//String oSHA= pairs[0];
                   	if(rSHA.contains(repackagedSHA)){
                   		if(repackagedType.contains("adware") || repackagedType.contains("adsware") ||
                   				repackagedType.contains("addisplay") || repackagedType.contains("adload")|| 
                   				repackagedType.contains("adware++adware"))
                   		{//write in adwares
                   			abw.append(linePairs);
                   			abw.newLine();
                   			abw.flush();
                   		}
                   		else{//write in trojan fil
                   		tbw.append(linePairs);
                   		tbw.newLine();
                   		tbw.flush();
                   		}
                   		rFound=true;
                   	}
                   	linePairs=pairbr.readLine();

               	}
               	pairbr.close();
				line=tbr.readLine();// read type line
			}while(tbr!=null);
			tbw.close();
			abw.close();
		}catch(Exception e){
			System.out.print(e.getMessage());
			
		}
	}
               		
    
	
	public static void nameChangeMalwareType(){
		String rfile="D:/Ava/Empirical2018/repackagedMalwareLabel-name-type.csv";
		String wfile="D:/Ava/Empirical2018/repackagedMalwareLabel-name-type-ChangedCol.csv";

		BufferedReader br=null;
		BufferedWriter bw=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			br = new BufferedReader(new FileReader(rfile));
			bw= new BufferedWriter(new FileWriter(wfile));
			//find it in original file
			line=br.readLine();
			while(line!=null){
				LINE_NO++;
				String[] pair=line.split(",",-1);
               	String col = pair[0]+"_"+pair[1]+"_r.apk";//sha256
               	bw.append(col+",");
               	bw.append(line);
                bw.newLine();
               	bw.flush();
    			line=br.readLine();

			}
			bw.close();

		}catch(Exception e){
			System.out.print(LINE_NO);
			System.out.println(e.getMessage());
			
		}finally{
		}
	}
	
	
	
	/*
	 * 
	 * cn.domob found!
com.admob found!
com.adwo found!
com.airpush not found!!!!!!!!!!!
com.appbrain found!
com.applovin found!
com.burstly found!
com.cauly not found!!!!!!!!!!!
com.chartboost found!
com.flurry found!
com.google.analytics found!
com.google.android.gms.ads found!
com.greystripe found!
com.inmobi found!
com.inneractive found!
com.jirbo.adcolony found!
com.jumptap found!
com.kuguo found!
com.madhouse found!
com.mdotm found!
com.mobclix found!
com.mobfox found!
com.mopub found!
com.mt.airad found!
com.nexage found!
com.revmob found!
com.startapp found!
com.tapfortap found!
com.tapit found!
com.tapjoy found!
com.vpon found!
com.waps not found!!!!!!!!!!!
com.wiyun found!
com.wooboo found!
com.zestadz found!
mobi.vserv found!
net.daum found!
net.youmi found!
	 */
	public static void FindRepackagedAdsInOriginals(){
		String[] ads= {"cn.domob","com.admob","com.adwo","com.airpush","com.appbrain","com.applovin","com.burstly",
				"com.cauly","com.chartboost","com.flurry","com.google.analytics","com.google.android.gms.ads",
				"com.greystripe","com.inmobi","com.inneractive","com.jirbo.adcolony","com.jumptap","com.kuguo",
				"com.madhouse","com.mdotm","com.mobclix","com.mobfox","com.mopub","com.mt.airad","com.nexage",
				"com.revmob","com.startapp","com.tapfortap","com.tapit","com.tapjoy","com.vpon","com.waps","com.wiyun",
				"com.wooboo","com.zestadz","mobi.vserv","net.daum","net.youmi"};
		String ofile="C:/Ava/Docs/Empirical/originalAdlibraries.csv";
		BufferedReader br=null;
		for(int i=0;i<ads.length;i++){
			//find it in original file
			try {
				br = new BufferedReader(new FileReader(ofile));
				boolean found=false;
				String line=br.readLine();
				line=br.readLine();
				do{
					
					String[] l=line.split(",");
					if(l.length>2){
						//System.out.println("EEEE");
						String[] Oads=l[2].split("[|]",-1);
						for(int j=0;j<Oads.length;j++){
							if(Oads[j].equals(ads[i])){
								found=true;
								System.out.println(ads[i]+" found!");
							}
						}
					}
					line=br.readLine();
				}while(!found && line!=null);
				if(!found){
					System.out.println(ads[i]+" not found!!!!!!!!!!!");
				}
				br.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("errrrrrrrorr");
				e.printStackTrace();
				
			}
		}

	}

	public static void copy(){
		File folder = new File("E:/Ava/original");
		File folderC = new File("E:/Ava/originalClean");
		File[] listOfFiles = folder.listFiles();
		boolean found=false;
		//try{
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		        int l=listOfFiles[i].getName().length()-50;
		        String fname=listOfFiles[i].getName().substring(l);
				File[] listOfFilesC = folderC.listFiles();
				for (int j = 0; !found && j < listOfFilesC.length; j++){
					int lC=listOfFilesC[j].getName().length()-50;
					String fnameC=listOfFilesC[j].getName().substring(lC);
					System.out.println(listOfFilesC[j].getName().length()+"*"+fnameC);
					if(fname.equals(fnameC)){
						found=true;
						//break;
					}
				}
				if(!found){
					//copy
				    try {
						Files.copy(listOfFiles[i].toPath(),(new File("E:/Ava/originalClean/" + listOfFiles[i].getName())).toPath(),StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				found=false;
		      } 
		    }
		/*}
		catch(Exception e){
			System.out.println(e.getMessage());

		}*/
	}
	
	public static void countComponents(){
		String dataFile= "D:/Ava/Empirical2018/androguardOriginalCompelete2_noName.csv";
		String ofile="D:/Ava/Empirical2018/originalCountComponents_noName.csv";
		BufferedReader br=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			br = new BufferedReader(new FileReader(dataFile));
			obw= new BufferedWriter(new FileWriter(ofile));
	
			line=br.readLine();// header line 7-11
			
			line=br.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
               	String appSHA = pair[0];//sha256
               	System.out.println(appSHA);
               	
               	System.out.println("10 "+pair.length);
               	if(pair.length==2){
               		br.readLine();
               		String nextLine=br.readLine();
               		line=line + nextLine ;
               		
               		pair=line.split(",",-1);
               		System.out.println("length "+pair.length+"line");
               	}
               	String activities=pair[6];
               	System.out.println("11 "+pair.length);

               	String services=pair[7];
               	System.out.println("12 ");
               	String receivers=pair[8];
               	System.out.println("13 ");
               	String contentProviders=pair[9];
               	System.out.println("14 ");
               	String permissions=pair[10];
               	System.out.println("15 ");

               	int activities_no=0;
               	int services_no=0;
               	int receivers_no=0;
               	int contentProviders_no=0;
               	int permissions_no=0;
               	if(!activities.isEmpty()){
               		String[] a=activities.split("[|]");
               		//if(a.length>0)
               			activities_no=a.length;
               	}
               	if( !services.isEmpty()){
               		String[] a= services.split("[|]");
               		System.out.println("s:"+services+a.length);
               		//if(a!=null ){
               		 services_no=a.length;
                		//System.out.println("s:"+services);

               		//}
               	}
               	if(!receivers.isEmpty()){
               		String[] a=receivers.split("[|]");
               		//if(a.length>0)
               			receivers_no=a.length;
               	}
               	if(!contentProviders.isEmpty()){
               		String[] a=contentProviders.split("[|]");
               		//if(a.length>0)
               			contentProviders_no=a.length;
               	}
               	if(!permissions.isEmpty()){
               		String[] a=permissions.split("[|]");
               		//if(a.length>0)
               			permissions_no=a.length;
               	}
               	String oLine=appSHA+","+activities_no+","+services_no+","+receivers_no+","+contentProviders_no+","+permissions_no+",";
               	obw.append(oLine);
               			//rbw.append("\n");
               			obw.newLine();
               			obw.flush();
               	
               	line=br.readLine();
			}while( line!=null );
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
	}

	public static void originalCountComponentsComplete(){
		String pairFile="C:/Ava/Docs/Empirical/repackaging_pairs.txt";
		String originalFile= "C:/Ava/Docs/Empirical/repackagedCountComponents.csv";//originalCountComponents.csv";
		String ofile="C:/Ava/Docs/Empirical/repackagedCountComponentsComplete1.csv";//originalCountComponentsComplete.csv";
		BufferedReader br=null;
		BufferedReader br1=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			br = new BufferedReader(new FileReader(pairFile));
			obw= new BufferedWriter(new FileWriter(ofile));
	
			line=br.readLine();// header line 7-11
			
			line=br.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
               	String appSHA = pair[1];//sha256
               	System.out.println(appSHA);
               	br1 = new BufferedReader(new FileReader(originalFile));
               	String dataLine=br1.readLine();
               	boolean rFound=false;
               	while(dataLine!=null){
               		//System.out.println(dataLine);
               		if(!rFound && dataLine!=null && dataLine.contains(appSHA)){
                       	System.out.println(	LINE_NO+"*" +dataLine);
               			obw.append(dataLine);
               			//rbw.append("\n");
               			obw.newLine();
               			obw.flush();
               			rFound=true;
               		}
               		if(rFound)
               			break;
               		dataLine=br1.readLine();
               	}
               		br1.close();
               		br1 = new BufferedReader(new FileReader(originalFile));
                              	
               	line=br.readLine();
			}while( line!=null);
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
	}
	public static void originalAndroguardComplete(){
		String pairFile="C:/Ava/Docs/Empirical/repackaging_pairs.txt";
		String originalFile= "C:/Ava/Docs/Empirical/androguardoriginal.csv";
		String repackagedFile= "C:/Ava/Docs/Empirical/androguardRepackaged-Previous.csv";//originalCountComponents.csv";
		String ofile="C:/Ava/Docs/Empirical/androguardOriginalCompelete.csv";//originalCountComponentsComplete.csv";
		String rfile="C:/Ava/Docs/Empirical/androguardRepackagedCompelete.csv";//originalCountComponentsComplete.csv";

		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter obw=null;
		BufferedWriter rbw=null;

		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			obw= new BufferedWriter(new FileWriter(ofile));
			rbw= new BufferedWriter(new FileWriter(rfile));

			line=pairbr.readLine();// header line 7-11
       		System.out.println(line);

			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println("Original:"+originalSHA);

               	System.out.println("Repackaged:"+repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(line);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		/*}
               		if(rFound){*/
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine);
                               	System.out.println(	LINE_NO+":" +repackagedLine);

                               	obw.write(originalLine);
    	               			//rbw.append("\n");
    	               			obw.newLine();
    	               			obw.flush();
    	               			
    	               			rbw.write(repackagedLine);
    	               			//rbw.append("\n");
    	               			rbw.newLine();
    	               			rbw.newLine();
    	               			rbw.flush();
    	               			
    	               			oFound=true;

                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                     }
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null && LINE_NO<10000);
			obw.close();
			rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				obw.close();
				rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void ComponentAdded(){
		String pairFile="D:/Ava/Empirical2018/repackaging_pairs_trojan.csv";
		String originalFile= "C:/Ava/Docs/Empirical/androguardoriginal.csv";
		String repackagedFile= "C:/Ava/Docs/Empirical/androguardRepackagedCompelete1.csv";//originalCountComponents.csv";
		String aofile="D:/Ava/Empirical2018/added-activityNames-trojan.csv";//originalCountComponentsComplete.csv";
		String sofile="D:/Ava/Empirical2018/added-servicesNames-trojan.csv";//originalCountComponentsComplete.csv";
		String rofile="D:/Ava/Empirical2018/added-receiversNames-trojan.csv";//originalCountComponentsComplete.csv";
		String cofile="D:/Ava/Empirical2018/added-contentProvidersNames-trojan.csv";//originalCountComponentsComplete.csv";
		String pofile="D:/Ava/Empirical2018/added-permissionsNames-trojan.csv";//originalCountComponentsComplete.csv";

		//String rfile="C:/Ava/Docs/Empirical/androguardRepackagedCompelete.csv";//originalCountComponentsComplete.csv";

		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter abw=null;
		BufferedWriter sbw=null;
		BufferedWriter rbw=null;
		BufferedWriter cbw=null;
		BufferedWriter pbw=null;

		//BufferedWriter rbw=null;

		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			abw= new BufferedWriter(new FileWriter(aofile));
			sbw= new BufferedWriter(new FileWriter(sofile));
			rbw= new BufferedWriter(new FileWriter(rofile));
			cbw= new BufferedWriter(new FileWriter(cofile));
			pbw= new BufferedWriter(new FileWriter(pofile));

			//rbw= new BufferedWriter(new FileWriter(rfile));

			line=pairbr.readLine();// header line 7-11
       		System.out.println(line);

			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println("Original:"+originalSHA);

               	System.out.println("Repackaged:"+repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(line);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		/*}
               		if(rFound){*/
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine);
                               	System.out.println(	LINE_NO+":" +repackagedLine);
                               	
                               	String[] o=originalLine.split(",",-1);
                               	String[] r=repackagedLine.split(",",-1);
                               	//check if number of activities are similar
                               	System.out.println("length:"+o.length);
                               	
                               	String activitiesO=o[7];
                               	System.out.println("o[7]");
                               	String servicesO=o[8];
                               	System.out.println("o[8]");
                               	String receiversO=o[9];
                               	System.out.println("o[9]");
                               	String contentProvidersO=o[10];
                               	System.out.println("o[10]");
                               	String permissionsO=o[11];
                               	System.out.println("o[11]");
                               	
                               	String activitiesR=r[7];
                               	System.out.println("r[7]");
                               	String servicesR=r[8];
                               	System.out.println("r[8]");
                               	String receiversR=r[9];
                               	System.out.println("r[9]");
                               	String contentProvidersR=r[10];
                               	System.out.println("r[10]");
                               	String permissionsR=r[11];
                               	System.out.println("r[11]");
                              	int activities_noO=0;
                               	int services_noO=0;
                               	int receivers_noO=0;
                               	int contentProviders_noO=0;
                               	int permissions_noO=0;
                               	
                               	int activities_noR=0;
                               	int services_noR=0;
                               	int receivers_noR=0;
                               	int contentProviders_noR=0;
                               	int permissions_noR=0;
                               	String[] aO=null;
                               	String[] sO=null;
                               	String[] cO=null;
                               	String[] pO=null;
                               	String[] rO=null;


                               	if(!activitiesO.isEmpty()){
                               		aO=activitiesO.split("[|]");
                               			activities_noO=aO.length;
                               			
                               			
                               	}
                               	if( !servicesO.isEmpty()){
                               		sO= servicesO.split("[|]");
                               		 services_noO=sO.length;
                                                     	}
                               	if(!receiversO.isEmpty()){
                               		rO=receiversO.split("[|]");
                               		//if(a.length>0)
                               			receivers_noO=rO.length;
                               	}
                               	if(!contentProvidersO.isEmpty()){
                               		cO=contentProvidersO.split("[|]");
                               			contentProviders_noO=cO.length;
                               	}
                               	if(!permissionsO.isEmpty()){
                               		 pO=permissionsO.split("[|]");
                               		//if(a.length>0)
                               			permissions_noO=pO.length;
                               	}
                               	
                               	
                               	if(!activitiesR.isEmpty()){
                               		    String[] aR=activitiesR.split("[|]");
                               			activities_noR=aR.length;
                               			abw.append(repackagedSHA+",");
                                  		 for(int i=0; i<aR.length;i++){
                                  			 
                                  			 if(!Arrays.asList( aO ).contains(aR[i])){
                                  				 //added service
                                  				 abw.append(aR[i]+"|");
                                  			 }
                                  		 }
                                  		 abw.append(",");
                                  		 abw.newLine();
                                  		 abw.flush();
                               	}
                               	if( !servicesR.isEmpty()){
                               		String[] sR= servicesR.split("[|]");
                               		 services_noR=sR.length;
                               		 sbw.append(repackagedSHA+",");
                               		 for(int i=0; i<sR.length;i++){
                               			 
                               			 if(!Arrays.asList( sO ).contains(sR[i])){
                               				 //added service
                               				 sbw.append(sR[i]+"|");
                               			 }
                               		 }
                               		 sbw.append(",");
                               		 sbw.newLine();
                               		 sbw.flush();
                               		 
                                }
                               	if(!receiversR.isEmpty()){
                               		String[] rR=receiversR.split("[|]");
                               		//if(a.length>0)
                               			receivers_noR=rR.length;
                               			rbw.append(repackagedSHA+",");
                                  		 for(int i=0; i<rR.length;i++){
                                  			 
                                  			 if(!Arrays.asList( rO ).contains(rR[i])){
                                  				 //added service
                                  				 rbw.append(rR[i]+"|");
                                  			 }
                                  		 }
                                  		 rbw.append(",");
                                  		 rbw.newLine();
                                  		 rbw.flush();
                               	}
                               	if(!contentProvidersR.isEmpty()){
                               		String[] cR=contentProvidersR.split("[|]");
                               			contentProviders_noR=cR.length;
                               			cbw.append(repackagedSHA+",");
                                  		 for(int i=0; i<cR.length;i++){
                                  			 
                                  			 if(!Arrays.asList( cO ).contains(cR[i])){
                                  				 //added service
                                  				 cbw.append(cR[i]+"|");
                                  			 }
                                  		 }
                                  		 cbw.append(",");
                                  		 cbw.newLine();
                                  		 cbw.flush();
                               	}
                               	if(!permissionsR.isEmpty()){
                               		String[] pR=permissionsR.split("[|]");
                               		//if(a.length>0)
                               			permissions_noR=pR.length;
                               			pbw.append(repackagedSHA+",");
                                  		 for(int i=0; i<pR.length;i++){
                                  			 
                                  			 if(!Arrays.asList( pO ).contains(pR[i])){
                                  				 //added service
                                  				 pbw.append(pR[i]+"|");
                                  			 }
                                  		 }
                                  		 pbw.append(",");
                                  		 pbw.newLine();
                                  		 pbw.flush();
                               	}
                               	
                               	   			
    	               			oFound=true;
                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                     }
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null );
			abw.close();
			sbw.close();
			rbw.close();
			cbw.close();
			pbw.close();

			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				abw.close();
				sbw.close();
				rbw.close();
				cbw.close();
				pbw.close();				//rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void serviceChanged(){
		String sofile="D:/Ava/Classification2018/pairs-servicesNames-Details.csv";//originalCountComponentsComplete.csv";
		String sfile="D:/Ava/Classification2018/pairs-servicesChanged.csv";//originalCountComponentsComplete.csv";
		BufferedReader sbr=null;
		BufferedWriter sbw=null;

		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			sbr = new BufferedReader(new FileReader(sofile));
			sbw = new BufferedWriter(new FileWriter(sfile));
			line=sbr.readLine();
			do{
				LINE_NO++;
				System.out.println(LINE_NO);
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
				String repackagedSHA = pair[1];//sha256
				String originalServices=pair[2];
				String repackagedServices=pair[3];
				String addedSevices="";
				if(!repackagedServices.isEmpty()){
					String[] repackagedS= repackagedServices.split("[|]");
					if(!originalServices.isEmpty()){
						String[] originalS= originalServices.split("[|]");
						for(String rs:repackagedS ){
							if (!originalServices.contains(rs)){
								addedSevices=addedSevices+rs+"|";
							}
							
						}
					}else{// all repackaged services are new
						for(String rs:repackagedS ){
							addedSevices=addedSevices+rs+"|";

						}
					}
				}
				if(addedSevices!=""){
					sbw.write(originalSHA+","+repackagedSHA+","+ addedSevices.substring(0,addedSevices.length()-1));
					sbw.newLine();
					sbw.flush();
				}
				line=sbr.readLine();
			}while(line!= null);


		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				sbr.close();
				sbw.close();
				//rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	public static void componentNameAndroguard(){
		String pairFile="C:/Ava/Docs/Empirical/repackaging_pairs.txt";
		String originalFile= "C:/Ava/Docs/Empirical/androguardoriginal.csv";
		String repackagedFile= "C:/Ava/Docs/Empirical/androguardRepackagedCompelete1.csv";//originalCountComponents.csv";
		String sofile="D:/Ava/Classification2018/pairs-servicesNames-Details.csv";//originalCountComponentsComplete.csv";
		String pofile="D:/Ava/Classification2018/pairs-permissionNames-Details.csv";//originalCountComponentsComplete.csv";
		String aofile="D:/Ava/Classification2018/pairs-activityNames-Details.csv";//originalCountComponentsComplete.csv";
		String rofile="D:/Ava/Classification2018/pairs-receiversNames-Details.csv";//originalCountComponentsComplete.csv";
		String cofile="D:/Ava/Classification2018/pairs-contentProvidersNames-Details.csv";//originalCountComponentsComplete.csv";

		//String rfile="C:/Ava/Docs/Empirical/androguardRepackagedCompelete.csv";//originalCountComponentsComplete.csv";

		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter abw=null;
		BufferedWriter sbw=null;
		BufferedWriter rbw=null;
		BufferedWriter cbw=null;
		BufferedWriter pbw=null;
		//String rfile="C:/Ava/Docs/Empirical/androguardRepackagedCompelete.csv";//originalCountComponentsComplete.csv";


		//BufferedWriter rbw=null;

		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			sbw= new BufferedWriter(new FileWriter(sofile));
			pbw= new BufferedWriter(new FileWriter(pofile));
			abw= new BufferedWriter(new FileWriter(aofile));
			rbw= new BufferedWriter(new FileWriter(rofile));
			cbw= new BufferedWriter(new FileWriter(cofile));

			line=pairbr.readLine();// header line 7-11
       		System.out.println(line);

			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println("Original:"+originalSHA);

               	System.out.println("Repackaged:"+repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(line);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		/*}
               		if(rFound){*/
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine);
                               	System.out.println(	LINE_NO+":" +repackagedLine);
                               	
                               	String[] o=originalLine.split(",",-1);
                               	String[] r=repackagedLine.split(",",-1);
                               	//check if number of activities are similar
                               	System.out.println("length:"+o.length);
                               	
                               	String activitiesO=o[7];
                               	System.out.println("o[7]");
                               	String servicesO=o[8];
                               	System.out.println("o[8]");
                               	String receiversO=o[9];
                               	System.out.println("o[9]");
                               	String contentProvidersO=o[10];
                               	System.out.println("o[10]");
                               	String permissionsO=o[11];
                               	System.out.println("o[11]");
                               	
                               	String activitiesR=r[7];
                               	System.out.println("r[7]");
                               	String servicesR=r[8];
                               	System.out.println("r[8]");
                               	String receiversR=r[9];
                               	System.out.println("r[9]");
                               	String contentProvidersR=r[10];
                               	System.out.println("r[10]");
                               	String permissionsR=r[11];
                               	System.out.println("r[11]");
                              	int activities_noO=0;
                               	int services_noO=0;
                               	int receivers_noO=0;
                               	int contentProviders_noO=0;
                               	int permissions_noO=0;
                               	
                               	int activities_noR=0;
                               	int services_noR=0;
                               	int receivers_noR=0;
                               	int contentProviders_noR=0;
                               	int permissions_noR=0;
                               	/*if(!activitiesO.isEmpty()){
                               		String[] a=activitiesO.split("[|]");
                               			activities_noO=a.length;
                               	}
                               	if( !servicesO.isEmpty()){
                               		String[] a= servicesO.split("[|]");
                               		 services_noO=a.length;
                                                     	}
                               	if(!receiversO.isEmpty()){
                               		String[] a=receiversO.split("[|]");
                               		//if(a.length>0)
                               			receivers_noO=a.length;
                               	}
                               	if(!contentProvidersO.isEmpty()){
                               		String[] a=contentProvidersO.split("[|]");
                               			contentProviders_noO=a.length;
                               	}
                               	if(!permissionsO.isEmpty()){
                               		String[] a=permissionsO.split("[|]");
                               		//if(a.length>0)
                               			permissions_noO=a.length;
                               	}
                               	if(!activitiesR.isEmpty()){
                               		String[] a=activitiesR.split("[|]");
                               			activities_noR=a.length;
                               	}
                               	if( !servicesR.isEmpty()){
                               		String[] a= servicesR.split("[|]");
                               		 services_noR=a.length;
                                                     	}
                               	if(!receiversR.isEmpty()){
                               		String[] a=receiversR.split("[|]");
                               		//if(a.length>0)
                               			receivers_noR=a.length;
                               	}
                               	if(!contentProvidersR.isEmpty()){
                               		String[] a=contentProvidersR.split("[|]");
                               			contentProviders_noR=a.length;
                               	}
                               	if(!permissionsR.isEmpty()){
                               		String[] a=permissionsR.split("[|]");
                               		//if(a.length>0)
                               			permissions_noR=a.length;
                               	}*/
                               	
                               		abw.write(originalSHA+","+repackagedSHA+","+activitiesO+","+activitiesR);
                               		abw.newLine();
                               		abw.flush();
                               	
                               		sbw.write(originalSHA+","+repackagedSHA+","+servicesO+","+servicesR);
                               		sbw.newLine();
                               		sbw.flush();
                               	
                               		rbw.write(originalSHA+","+repackagedSHA+","+receiversO+","+receiversR);
                               		rbw.newLine();
                               		rbw.flush();
                               	
                               		cbw.write(originalSHA+","+repackagedSHA+","+contentProvidersO+","+contentProvidersR);
                               		cbw.newLine();
                               		cbw.flush();
                               
                               		pbw.write(originalSHA+","+repackagedSHA+","+permissionsO+","+permissionsR);
                               		pbw.newLine();
                               		pbw.flush();
                               
    	               	   	               			
    	               			oFound=true;
                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                     }
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null );
			abw.close();
			sbw.close();
			rbw.close();
			cbw.close();
			pbw.close();

			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				abw.close();
				sbw.close();
				rbw.close();
				cbw.close();
				pbw.close();				//rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static void ComponentNameSimilarAndroguard(){
		String pairFile="C:/Ava/Docs/Empirical/repackaging_pairs.txt";
		String originalFile= "C:/Ava/Docs/Empirical/androguardoriginal.csv";
		String repackagedFile= "C:/Ava/Docs/Empirical/androguardRepackagedCompelete1.csv";//originalCountComponents.csv";
		String aofile="C:/Ava/Docs/Empirical/pairs-activityNmaes.csv";//originalCountComponentsComplete.csv";
		String sofile="C:/Ava/Docs/Empirical/pairs-servicesNmaes.csv";//originalCountComponentsComplete.csv";
		String rofile="C:/Ava/Docs/Empirical/pairs-receiversNmaes.csv";//originalCountComponentsComplete.csv";
		String cofile="C:/Ava/Docs/Empirical/pairs-contentProvidersNmaes.csv";//originalCountComponentsComplete.csv";
		String pofile="C:/Ava/Docs/Empirical/pairs-permissionsNmaes.csv";//originalCountComponentsComplete.csv";

		//String rfile="C:/Ava/Docs/Empirical/androguardRepackagedCompelete.csv";//originalCountComponentsComplete.csv";

		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter abw=null;
		BufferedWriter sbw=null;
		BufferedWriter rbw=null;
		BufferedWriter cbw=null;
		BufferedWriter pbw=null;

		//BufferedWriter rbw=null;

		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			abw= new BufferedWriter(new FileWriter(aofile));
			sbw= new BufferedWriter(new FileWriter(sofile));
			rbw= new BufferedWriter(new FileWriter(rofile));
			cbw= new BufferedWriter(new FileWriter(cofile));
			pbw= new BufferedWriter(new FileWriter(pofile));

			//rbw= new BufferedWriter(new FileWriter(rfile));

			line=pairbr.readLine();// header line 7-11
       		System.out.println(line);

			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println("Original:"+originalSHA);

               	System.out.println("Repackaged:"+repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(line);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		/*}
               		if(rFound){*/
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine);
                               	System.out.println(	LINE_NO+":" +repackagedLine);
                               	
                               	String[] o=originalLine.split(",",-1);
                               	String[] r=repackagedLine.split(",",-1);
                               	//check if number of activities are similar
                               	System.out.println("length:"+o.length);
                               	
                               	String activitiesO=o[7];
                               	System.out.println("o[7]");
                               	String servicesO=o[8];
                               	System.out.println("o[8]");
                               	String receiversO=o[9];
                               	System.out.println("o[9]");
                               	String contentProvidersO=o[10];
                               	System.out.println("o[10]");
                               	String permissionsO=o[11];
                               	System.out.println("o[11]");
                               	
                               	String activitiesR=r[7];
                               	System.out.println("r[7]");
                               	String servicesR=r[8];
                               	System.out.println("r[8]");
                               	String receiversR=r[9];
                               	System.out.println("r[9]");
                               	String contentProvidersR=r[10];
                               	System.out.println("r[10]");
                               	String permissionsR=r[11];
                               	System.out.println("r[11]");
                              	int activities_noO=0;
                               	int services_noO=0;
                               	int receivers_noO=0;
                               	int contentProviders_noO=0;
                               	int permissions_noO=0;
                               	
                               	int activities_noR=0;
                               	int services_noR=0;
                               	int receivers_noR=0;
                               	int contentProviders_noR=0;
                               	int permissions_noR=0;
                               	if(!activitiesO.isEmpty()){
                               		String[] a=activitiesO.split("[|]");
                               			activities_noO=a.length;
                               	}
                               	if( !servicesO.isEmpty()){
                               		String[] a= servicesO.split("[|]");
                               		 services_noO=a.length;
                                                     	}
                               	if(!receiversO.isEmpty()){
                               		String[] a=receiversO.split("[|]");
                               		//if(a.length>0)
                               			receivers_noO=a.length;
                               	}
                               	if(!contentProvidersO.isEmpty()){
                               		String[] a=contentProvidersO.split("[|]");
                               			contentProviders_noO=a.length;
                               	}
                               	if(!permissionsO.isEmpty()){
                               		String[] a=permissionsO.split("[|]");
                               		//if(a.length>0)
                               			permissions_noO=a.length;
                               	}
                               	if(!activitiesR.isEmpty()){
                               		String[] a=activitiesR.split("[|]");
                               			activities_noR=a.length;
                               	}
                               	if( !servicesR.isEmpty()){
                               		String[] a= servicesR.split("[|]");
                               		 services_noR=a.length;
                                                     	}
                               	if(!receiversR.isEmpty()){
                               		String[] a=receiversR.split("[|]");
                               		//if(a.length>0)
                               			receivers_noR=a.length;
                               	}
                               	if(!contentProvidersR.isEmpty()){
                               		String[] a=contentProvidersR.split("[|]");
                               			contentProviders_noR=a.length;
                               	}
                               	if(!permissionsR.isEmpty()){
                               		String[] a=permissionsR.split("[|]");
                               		//if(a.length>0)
                               			permissions_noR=a.length;
                               	}
                               	
                               	if(activities_noR==activities_noO && activities_noR!=0){
                               		abw.write(activitiesO+","+activitiesR);
                               		abw.newLine();
                               		abw.flush();
                               	}
                               	if(services_noR==services_noO && services_noR!=0){
                               		sbw.write(servicesO+","+servicesR);
                               		sbw.newLine();
                               		sbw.flush();
                               	}
                               	if(receivers_noR==receivers_noO && receivers_noR!=0){
                               		rbw.write(receiversO+","+receiversR);
                               		rbw.newLine();
                               		rbw.flush();
                               	}
                               	if(contentProviders_noR==contentProviders_noO && contentProviders_noR!=0){
                               		cbw.write(contentProvidersO+","+contentProvidersR);
                               		cbw.newLine();
                               		cbw.flush();
                               	}
                               	if(permissions_noR==permissions_noO && permissions_noR!=0){
                               		pbw.write(permissionsO+","+permissionsR);
                               		pbw.newLine();
                               		pbw.flush();
                               	}
    	               	   	               			
    	               			oFound=true;
                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                     }
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null );
			abw.close();
			sbw.close();
			rbw.close();
			cbw.close();
			pbw.close();

			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				abw.close();
				sbw.close();
				rbw.close();
				cbw.close();
				pbw.close();				//rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void permisssionsAdded(){
		String pfile="D:/Ava/Empirical2018/pairs-permissionsDeleted.csv";
		String pwfile="D:/Ava/Empirical2018/pairs-permissionsDeleted-InEachLine.csv";

		//String pfile="C:/Ava/Docs/Empirical/pairs-permissionsChangedInSimilarNumber.csv";//pairs-permissionsAdded.csv";
		//String pwfile="C:/Ava/Docs/Empirical/pairs-permissionsChangedInSimilarNumber-InEachLine.csv";

		BufferedReader pbr=null;
		BufferedWriter pbw=null;
		try{
		pbr = new BufferedReader(new FileReader(pfile));
		pbw= new BufferedWriter(new FileWriter(pwfile));
		String line=pbr.readLine();// first line
		do{
			
			LINE_NO++;
			String[] pair=line.split(",",-1);
			for(int i=0; i<pair.length;i++){
				pbw.write(pair[i]);
				pbw.newLine();
				pbw.flush();
			}
			line=pbr.readLine();// first line

		}while(line!=null);
		pbw.close();
		}catch(Exception e){
			System.out.println("Error");
			
		}
		
		
	}
	
	/*ZeroPermissions:201
	EqualNumberPermissions:14109
	LessNumberPermissions:338
	MoreNumberPermissions:663
	SimilarPermissions:14045
	MorePermissions:621
	LessPermissions:292*/
	public static void permissionsInPairs(){
		
		
		//String pairFile="C:/Ava/Docs/Empirical/repackaging_pairs.txt";
		String pairFile="D:/Ava/Empirical2018/repackaging_pairs_adware_New.csv";
		String originalFile= "C:/Ava/Docs/Empirical/androguardoriginal.csv";
		String repackagedFile= "C:/Ava/Docs/Empirical/androguardRepackagedCompelete1.csv";//originalCountComponents.csv";
		String apofileAll="D:/Ava/Empirical2018/adware_pairs-permissions_New.csv";//originalCountComponentsComplete.csv";
		String apofile="D:/Ava/Empirical2018/adware_pairs-permissionsAdded_New.csv";//originalCountComponentsComplete.csv";
		String dpofile="D:/Ava/Empirical2018/adware_pairs-permissionsDeleted_New.csv";//originalCountComponentsComplete.csv";
		String spofile="D:/Ava/Empirical2018/adware_pairs-permissionsChangedInSimilarNumber_New.csv";//it is the added one
		String sdpofile="D:/Ava/Empirical2018/adware_pairs-permissionsdeletedInSimilarNumber_New.csv";//originalCountComponentsComplete.csv";

		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter apbw=null;
		BufferedWriter dpbw=null;
		BufferedWriter spbw=null;
		BufferedWriter sdpbw=null;
		BufferedWriter pallw=null;


		//BufferedWriter rbw=null;

		String line="";
		String csvSplitBy=",";
		int ZeroPermissions=0;
		int EqualNumberPermissions=0;
		int LessNumberPermissions=0;
		int MoreNumberPermissions=0;
		int SimilarPermissions=0;
		int MorePermissions=0;
		int LessPermissions=0;
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			//abw= new BufferedWriter(new FileWriter(aofile));
			//sbw= new BufferedWriter(new FileWriter(sofile));
			//rbw= new BufferedWriter(new FileWriter(rofile));
			//cbw= new BufferedWriter(new FileWriter(cofile));
			apbw= new BufferedWriter(new FileWriter(apofile));
			dpbw= new BufferedWriter(new FileWriter(dpofile));
			spbw= new BufferedWriter(new FileWriter(spofile));
			sdpbw= new BufferedWriter(new FileWriter(sdpofile));
			pallw=new BufferedWriter(new FileWriter(apofileAll));

			line=pairbr.readLine();// header line 7-11
       		System.out.println(line);

			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println("Original:"+originalSHA);

               	System.out.println("Repackaged:"+repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(line);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine);
                               	System.out.println(	LINE_NO+":" +repackagedLine);
                               	
                               	String[] o=originalLine.split(",",-1);
                               	String[] r=repackagedLine.split(",",-1);

                               	System.out.println("length:"+o.length);
                               	
                               	
                               	String permissionsO=o[11];
                               	System.out.println("o[11]");
                               	
                               	
                               	String permissionsR=r[11];
                               	pallw.write(o[0]+","+r[0]+","+permissionsO+","+permissionsR);
                   				pallw.newLine();
                           		pallw.flush();
                           		
                               	System.out.println("r[11]");
                              	int permissions_noO=0;
                              	int permissions_noR=0;
                              	String[] permissionsListR=null;
                              	String[] permissionsListO=null;
                              	List<String> pListR=new ArrayList<String>();
                              	List<String> pListO=new ArrayList<String>();
                               	if(!permissionsO.isEmpty()){
                               		System.out.println("1");
                               		permissionsListO=permissionsO.split("[|]");
                               		System.out.println("1");

                               		pListO=Arrays.asList(permissionsListO);
                               		//if(a.length>0)
                               		System.out.println("1");

                               		permissions_noO=permissionsListO.length;
                               	}
                               	if(!permissionsR.isEmpty()){
                               		System.out.println("2");

                               		permissionsListR=permissionsR.split("[|]");
                               		System.out.println("2");
                               		pListR=Arrays.asList(permissionsListR);
                               		System.out.println("2");
                               		//if(a.length>0)
                               			permissions_noR=permissionsListR.length;
                               	}
                               	if(permissions_noR==0)
                               		ZeroPermissions++;
                               	System.out.println("3");
                               	if(permissions_noR==permissions_noO && permissions_noR!=0){
                               		EqualNumberPermissions++;
                               		//check if one is subset of the other
                               		System.out.println("3");
                               		if(pListR!=null)
                               		if(pListR.containsAll(pListO))
                               			SimilarPermissions++;
                               		else{
                               			List<String> temp=new ArrayList<String>();
                               			Iterator<String> Rp=pListR.iterator();
                                   		System.out.println("4");

                               			while(Rp.hasNext()){
                               				String p=Rp.next();
                               				if(!pListO.contains(p)){
                               					temp.add(p);
                               				}
                               					
                               			}
                               			if(temp!=null && !temp.isEmpty()){
                                       		System.out.println("4");
                               				String pLine=","+temp;//String.join(",", temp);
                               				spbw.write(pLine);
                               				spbw.newLine();
                                       		spbw.flush();
                               			}
                               			
                               			
                               			
                               		}
                               		System.out.println("3");

                               	}
                               	if(permissions_noR>permissions_noO){
                               		System.out.println("4");
                           			MoreNumberPermissions++;
                           			if(permissions_noO==0){
                           				String pLine=","+pListR;//String.join(",", pListR);
                           				apbw.write(pLine);
                           				apbw.newLine();
                                   		apbw.flush();
                           			}else
                               		if(pListR!=null && pListR.containsAll(pListO)){
                                   		System.out.println("4");
                               			MorePermissions++;
                               			List<String> temp=new ArrayList<String>();
                               			Iterator<String> Rp=pListR.iterator();
                                   		System.out.println("4");

                               			while(Rp.hasNext()){
                                       		System.out.println("14");

                               				String p=Rp.next();
                               				if(!pListO.contains(p)){
                                           		System.out.println("114");

                               					temp.add(p);
                               				}
                               					
                               			}
                               			if(temp!=null && !temp.isEmpty()){
                                       		System.out.println("4");
                               				String pLine=","+temp;//String.join(",", temp);
                               				apbw.write(pLine);
                               				apbw.newLine();
                                       		apbw.flush();
                               			}
                               				
                               			
                               		}
                               		
                               	}
                               	if(permissions_noR<permissions_noO){
                               		System.out.println("5");

                               		LessNumberPermissions++;
                               		if(permissions_noR==0){
                           				String pLine=","+pListO;//String.join(",", pListO);
                           				dpbw.write(pLine);
                           				dpbw.newLine();
                                   		dpbw.flush();
                           			}else
                               		if(pListO!=null && pListO.containsAll(pListR)){
                               			LessPermissions++;
                               			List<String> temp=new ArrayList<String>();
                               			Iterator<String> Op=pListO.iterator();
                               			while(Op.hasNext()){
                               				String p=Op.next();
                               				if(!pListR.contains(p))
                               					temp.add(p);
                               					
                               			}
                               			if(temp!=null){
                               				String pLine=","+temp;//String.join(",", temp);
                               				dpbw.write(pLine);
                               				dpbw.newLine();
                                       		dpbw.flush();
                               			}
                               				
                               		}
                               		
                               	}
    	               	   	               			
    	               			oFound=true;
                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                     }
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null );
			apbw.close();
			dpbw.close();
			spbw.close();
			
			System.out.println("ZeroPermissions:"+ZeroPermissions);
			System.out.println("EqualNumberPermissions:"+EqualNumberPermissions);
			System.out.println("LessNumberPermissions:"+LessNumberPermissions);
			System.out.println("MoreNumberPermissions:"+MoreNumberPermissions);
			System.out.println("SimilarPermissions:"+SimilarPermissions);
			System.out.println("MorePermissions:"+MorePermissions);
			System.out.println("LessPermissions:"+LessPermissions);
			
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				apbw.close();
				dpbw.close();			//rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void permissionsDeletedInSimilar(){
		String pairFile="C:/Ava/Docs/Empirical/repackaging_pairs.txt";
		String originalFile= "C:/Ava/Docs/Empirical/androguardoriginal.csv";
		String repackagedFile= "C:/Ava/Docs/Empirical/androguardRepackagedCompelete1.csv";//originalCountComponents.csv";
		//String pofile="C:/Ava/Docs/Empirical/pairs-activityNmaes.csv";//originalCountComponentsComplete.csv";
		//String sofile="C:/Ava/Docs/Empirical/pairs-servicesNmaes.csv";//originalCountComponentsComplete.csv";
		//String rofile="C:/Ava/Docs/Empirical/pairs-receiversNmaes.csv";//originalCountComponentsComplete.csv";
		//String cofile="C:/Ava/Docs/Empirical/pairs-contentProvidersNmaes.csv";//originalCountComponentsComplete.csv";
		String apofile="C:/Ava/Docs/Empirical/pairs-permissionsAdded.csv";//originalCountComponentsComplete.csv";
		String dpofile="C:/Ava/Docs/Empirical/pairs-permissionsDeleted.csv";//originalCountComponentsComplete.csv";
		String spofile="C:/Ava/Docs/Empirical/pairs-permissionsChangedInSimilarNumber.csv";//it is the added one
		String sdpofile="C:/Ava/Docs/Empirical/pairs-permissionsdeletedInSimilarNumber.csv";//originalCountComponentsComplete.csv";

		//String rfile="C:/Ava/Docs/Empirical/androguardRepackagedCompelete.csv";//originalCountComponentsComplete.csv";

		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter apbw=null;
		BufferedWriter dpbw=null;
		BufferedWriter spbw=null;
		BufferedWriter sdpbw=null;
		String line="";
		String csvSplitBy=",";
		int ZeroPermissions=0;
		int EqualNumberPermissions=0;
		int LessNumberPermissions=0;
		int MoreNumberPermissions=0;
		int SimilarPermissions=0;
		int MorePermissions=0;
		int LessPermissions=0;
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			sdpbw= new BufferedWriter(new FileWriter(sdpofile));
			line=pairbr.readLine();// header line 7-11
       		System.out.println(line);
			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println("Original:"+originalSHA);

               	System.out.println("Repackaged:"+repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(line);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine);
                               	System.out.println(	LINE_NO+":" +repackagedLine);
                               	
                               	String[] o=originalLine.split(",",-1);
                               	String[] r=repackagedLine.split(",",-1);
                               	//check if number of activities are similar
                               	System.out.println("length:"+o.length);
                               	
                               	
                               	String permissionsO=o[11];
                               	System.out.println("o[11]");
                               	
                               	
                               	String permissionsR=r[11];
                               	System.out.println("r[11]");
                              	int permissions_noO=0;
                              	int permissions_noR=0;
                              	String[] permissionsListR=null;
                              	String[] permissionsListO=null;
                              	List<String> pListR=new ArrayList<String>();
                              	List<String> pListO=new ArrayList<String>();
                               	if(!permissionsO.isEmpty()){
                               		System.out.println("1");
                               		permissionsListO=permissionsO.split("[|]");
                               		System.out.println("1");

                               		pListO=Arrays.asList(permissionsListO);
                               		//if(a.length>0)
                               		System.out.println("1");

                               		permissions_noO=permissionsListO.length;
                               	}
                               	if(!permissionsR.isEmpty()){
                               		System.out.println("2");

                               		permissionsListR=permissionsR.split("[|]");
                               		System.out.println("2");
                               		pListR=Arrays.asList(permissionsListR);
                               		System.out.println("2");
                               		//if(a.length>0)
                               			permissions_noR=permissionsListR.length;
                               	}
                               	if(permissions_noR==0)
                               		ZeroPermissions++;
                               	System.out.println("3");
                               	if(permissions_noR==permissions_noO && permissions_noR!=0){
                               		EqualNumberPermissions++;
                               		//check if one is subset of the other
                               		System.out.println("3");
                               		if(pListR!=null)
                               		if(pListR.containsAll(pListO))
                               			SimilarPermissions++;
                               		else{
                               			List<String> temp=new ArrayList<String>();
                               			Iterator<String> Rp=pListO.iterator();
                                   		System.out.println("4");

                               			while(Rp.hasNext()){
                               				String p=Rp.next();
                               				if(!pListR.contains(p)){
                               					temp.add(p);
                               				}
                               					
                               			}
                               			if(temp!=null && !temp.isEmpty()){
                                       		System.out.println("4");
                               				String pLine=","+ temp;//String.join(",", temp);
                               				sdpbw.write(pLine);
                               				sdpbw.newLine();
                                       		sdpbw.flush();
                               			}
                               		
                               		}
                               		System.out.println("3");

                               	}
                               	   	               	   	               			
    	               			oFound=true;
                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                     }
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null );
			apbw.close();
			dpbw.close();
			spbw.close();
			
			System.out.println("ZeroPermissions:"+ZeroPermissions);
			System.out.println("EqualNumberPermissions:"+EqualNumberPermissions);
			System.out.println("LessNumberPermissions:"+LessNumberPermissions);
			System.out.println("MoreNumberPermissions:"+MoreNumberPermissions);
			System.out.println("SimilarPermissions:"+SimilarPermissions);
			System.out.println("MorePermissions:"+MorePermissions);
			System.out.println("LessPermissions:"+LessPermissions);
			
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				apbw.close();
				dpbw.close();			//rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void apkNameAndroguardComplete(){
		String pairFile="C:/Ava/Docs/Empirical/repackaging_pairs.txt";
		String originalFile= "C:/Ava/Docs/Empirical/androguardoriginal.csv";
		String repackagedFile= "C:/Ava/Docs/Empirical/androguardRepackaged-Previous.csv";//originalCountComponents.csv";
		String ofile="C:/Ava/Docs/Empirical/apkNameOriginalRepackaged.csv";//originalCountComponentsComplete.csv";
		//String rfile="C:/Ava/Docs/Empirical/androguardRepackagedCompelete.csv";//originalCountComponentsComplete.csv";

		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter obw=null;
		//BufferedWriter rbw=null;

		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			obw= new BufferedWriter(new FileWriter(ofile));
			//rbw= new BufferedWriter(new FileWriter(rfile));

			line=pairbr.readLine();// header line 7-11
       		System.out.println(line);

			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println("Original:"+originalSHA);

               	System.out.println("Repackaged:"+repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(line);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		/*}
               		if(rFound){*/
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine);
                               	System.out.println(	LINE_NO+":" +repackagedLine);
                               	
                               	String[] o=originalLine.split(",");
                               	String[] r=repackagedLine.split(",");
                               	obw.write(o[1]+","+r[1]);
    	               			//rbw.append("\n");
    	               			obw.newLine();
    	               			obw.flush();
    	               			
    	               			//rbw.write(repackagedLine);
    	               			//rbw.append("\n");
    	               			//rbw.newLine();
    	               			//rbw.newLine();
    	               			//rbw.flush();
    	               			
    	               			oFound=true;

                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                     }
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null );
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}finally{
			try {
				obw.close();
				//rbw.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void originalCountComponentsCompleteFinal(){
		String pairFile="C:/Ava/Docs/Empirical/repackaging_pairs.txt";
		String originalFile= "C:/Ava/Docs/Empirical/originalCountComponentsComplete.csv";
		String repackagedFile= "C:/Ava/Docs/Empirical/repackagedCountComponentsComplete.csv";//originalCountComponents.csv";
		String ofile="C:/Ava/Docs/Empirical/originalCountComponentsCompleteFinal.csv";//originalCountComponentsComplete.csv";
		BufferedReader pairbr=null;
		BufferedReader obr=null;
		BufferedReader rbr=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		LINE_NO=0;
		try{
			pairbr = new BufferedReader(new FileReader(pairFile));
			obw= new BufferedWriter(new FileWriter(ofile));
	
			line=pairbr.readLine();// header line 7-11
			
			line=pairbr.readLine();// first line
			do{
				
				LINE_NO++;
				String[] pair=line.split(",",-1);
				String originalSHA=pair[0];
               	String repackagedSHA = pair[1];//sha256
               	System.out.println(repackagedSHA);
               	rbr = new BufferedReader(new FileReader(repackagedFile));
               	String repackagedLine=rbr.readLine();
               	boolean rFound=false;
               	while(repackagedLine!=null){
               		//System.out.println(dataLine);
               		if(!rFound && repackagedLine!=null && repackagedLine.contains(repackagedSHA)){
                       	//System.out.println(	LINE_NO+"*" +repackagedLine);
               			rFound=true;
               		}
               		if(rFound){
               			obr = new BufferedReader(new FileReader(originalFile));
                       	String originalLine=obr.readLine();
                    	boolean oFound=false;
                       	while(originalLine!=null){
                       		//System.out.println(dataLine);
                       		if(!oFound && originalLine!=null && originalLine.contains(originalSHA)){
                               	System.out.println(	LINE_NO+":" +originalLine+"*"+repackagedLine);
                               	obw.append(originalLine);
    	               			//rbw.append("\n");
    	               			obw.newLine();
    	               			obw.flush();
    	               			oFound=true;
                       		}
                       		if(oFound)
                       			break;
                       		originalLine=obr.readLine();
             			}
                       	
               			
               			
               		}
               		if(rFound)
               			break;
               		repackagedLine=rbr.readLine();
               	}
               		rbr.close();
               		rbr = new BufferedReader(new FileReader(repackagedFile));
                              	
               	line=pairbr.readLine();
			}while( line!=null);
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println("errrrrrrroorr");
			System.out.println(e.getMessage());
		}
	}
	public static void completeDataAds(){
		String dataFile= "C:/Ava/Docs/Empirical/repackagedAppsDetailsF.csv";
		String adFile="C:/Ava/Docs/Empirical/adLibrariesChangedAll.csv";
		String ofile="C:/Ava/Docs/Empirical/adLibrariesChangedDetails.csv";
		BufferedReader br=null;
		BufferedReader adbr=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		try{
			br = new BufferedReader(new FileReader(dataFile));
			adbr = new BufferedReader(new FileReader(adFile));
			obw= new BufferedWriter(new FileWriter(ofile));
	
			line=adbr.readLine();//read header
			//line=br.readLine();// first line
			/*for(int i=0;i<3563;i++)
				line=br.readLine();*/
			//line=br.readLine();// first line
			do{//the number should be changed???????????????????
				
				LINE_NO++;
				String[] pair=line.split(csvSplitBy);
               	String repackagedAppSHA = pair[0];//sha256
               	System.out.println(repackagedAppSHA);
               
               	String dataLine=br.readLine();
               	
               	boolean rFound=false;
               	while(dataLine!=null){
               		//System.out.println(dataLine);
               		if(!rFound && dataLine!=null && dataLine.contains(repackagedAppSHA)){
                       	System.out.println(	LINE_NO+"*" +dataLine);
               			obw.append(dataLine);
               			//rbw.append("\n");
               			obw.newLine();
               			obw.flush();
               			rFound=true;
               		}
               		if(rFound)
               			break;
               		dataLine=br.readLine();
               	}
               		br.close();
               		br = new BufferedReader(new FileReader(dataFile));
               		line=adbr.readLine();
               	}while( line!=null );
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void completeDataService(){
		String dataFile= "C:/Ava/Docs/Empirical/repackagedAppsDetailsF.csv";
		String adFile="D:/Ava/Classification2018/pairs-servicesChanged.csv";
		String ofile="D:/Ava/Classification2018/pairs-serviceChanged-AllDetails.csv";
		BufferedReader br=null;
		BufferedReader adbr=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		try{
			br = new BufferedReader(new FileReader(dataFile));
			adbr = new BufferedReader(new FileReader(adFile));
			obw= new BufferedWriter(new FileWriter(ofile));
	
			line=adbr.readLine();//read header
			//line=br.readLine();// first line
			/*for(int i=0;i<3563;i++)
				line=br.readLine();*/
			//line=br.readLine();// first line
			do{//the number should be changed???????????????????
				
				LINE_NO++;
				String[] pair=line.split(csvSplitBy);
               	String repackagedAppSHA = pair[1];//sha256
               	System.out.println(repackagedAppSHA);
               	String dataLine=br.readLine();
               	
               	boolean rFound=false;
               	while(dataLine!=null){
               		//System.out.println(dataLine);
               		if(!rFound && dataLine!=null && dataLine.contains(repackagedAppSHA)){
                       	System.out.println(	LINE_NO+"*" +dataLine);
               			obw.append(pair[0]+","+pair[1]+","+pair[2]+","+dataLine);
               			//rbw.append("\n");
               			obw.newLine();
               			obw.flush();
               			rFound=true;
               		}
               		if(rFound)
               			break;
               		dataLine=br.readLine();
               	}
               		br.close();
               		br = new BufferedReader(new FileReader(dataFile));
               		line=adbr.readLine();
               	}while( line!=null );
			obw.close();
			//rbw.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static void completeData(){
		String pairsFile= "C:/Ava/android/Dataset/theZoo/RePack-master/RePack-master/repackaging_pairs.txt";
		String latestFile="C:/Ava/android/Dataset/theZoo/latest.csv";
		String ofile="C:/Ava/android/Dataset/theZoo/originalAppsDetailsF1.csv";
		String rfile="C:/Ava/android/Dataset/theZoo/repackagedAppsDetailsF1.csv";
		BufferedReader br=null;
		BufferedReader lbr=null;
		BufferedWriter obw=null;
		BufferedWriter rbw=null;
		String line="";
		String csvSplitBy=",";
		try{
			br = new BufferedReader(new FileReader(pairsFile));
			lbr = new BufferedReader(new FileReader(latestFile));
			obw= new BufferedWriter(new FileWriter(ofile));
			rbw= new BufferedWriter(new FileWriter(rfile));
	
			line=br.readLine();//read header
			//line=br.readLine();// first line
			/*for(int i=0;i<3563;i++)
				line=br.readLine();*/
			line=br.readLine();// first line
			do{//the number should be changed???????????????????
				
				LINE_NO++;
				String[] pair=line.split(csvSplitBy);
				String originalAppSHA = pair[0];
               	String repackagedAppSHA = pair[1];//sha256
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

               		if(!oFound && latestLine!=null && latestLine.contains(originalAppSHA)){
                       	System.out.println(	LINE_NO+"*" + latestLine);
                       	
               			obw.append(latestLine);
               			obw.newLine();
               			obw.flush();
               			oFound=true;
               		}
               		if(!rFound && latestLine!=null && latestLine.contains(repackagedAppSHA)){
                       	System.out.println(	LINE_NO+"*" +latestLine);
               			rbw.append(latestLine);
               			//rbw.append("\n");
               			rbw.newLine();
               			rbw.flush();
               			rFound=true;
               		}
               		if(rFound && oFound)
               			break;
               	}
               		lbr.close();
               		lbr = new BufferedReader(new FileReader(latestFile));
               		line=br.readLine();
               	}while( line!=null && LINE_NO<10);
			obw.close();
			rbw.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public static class Market{
		Market(String n,int i){
			name=n;
			no=i;
		}
		String name="";
		int no=0;
	}
	
	/*
	 * repackaged
	Name:play.google.com No:9983
	Name:appchina No:656
	Name:anzhi No:4445
	Name:angeeks No:145
	Name:slideme No:84
	Name:hiapk No:12
	Name:1mobile No:227
	Name:genome No:3
	Name:apk_bang No:5
	Name:freewarelovers No:3
	Name:mi.com No:7
	Name:torrents No:9
	Name:proandroid No:6
	Name:fdroid No:5
	*/
	/*
	 * original
	Name:play.google.com No:9740
	Name:anzhi No:4422
	Name:slideme No:62
	Name:appchina No:610
	Name:1mobile No:630
	Name:angeeks No:79
	Name:proandroid No:30
	Name:fdroid No:9
	Name:hiapk No:11
	Name:torrents No:17
	Name:freewarelovers No:6
	*/
	
	
		public static void countMarket(){
			//String pairsFile= "C:/Ava/android/Dataset/theZoo/RePack-master/RePack-master/repackaging_pairs.txt";
			//String latestFile="C:/Ava/android/Dataset/theZoo/latest.csv";
			//String rfile="C:/Ava/Docs/Empirical/originalAppsDetailsClean.csv";
			String rfile="C:/Ava/android/Dataset/theZoo/repackagedAppsDetailsF.csv";
			BufferedReader br=null;
			ArrayList<Market> mlist= new ArrayList<Market>();
			String line="";
			String csvSplitBy=",";
			String marketSplitBy="[|]";
			try{
				br = new BufferedReader(new FileReader(rfile));
				line=br.readLine();//read header

				line=br.readLine();// first line
				do{//the number should be changed???????????????????
					
					LINE_NO++;
					String[] pair=line.split(csvSplitBy);
					boolean found=false;
	               	String repackagedAppmarket = pair[10];
	               	String[] markets=repackagedAppmarket.split(marketSplitBy);
	               	for(int i=0;i<markets.length;i++){
	               		//System.out.println("market:"+markets[i]);

	               		Iterator miterator=mlist.iterator();
	               		while(miterator.hasNext()){
	               			Market m=(Market) miterator.next();
	               			
	               			if(m.name.equals(markets[i])){
	               				m.no++;
	               				found=true;
	               				//System.out.println(markets[i]);
	               				break;
	               			}
	               		}
	               		if(!found){
	               			repackaged.Market m1=new repackaged.Market(markets[i],1);
	               			mlist.add(m1);
	               			//System.out.println(markets[i]+"*");
	               			found=false;
	               		}
	               	}
					line=br.readLine();
	              	}while( line!=null);
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			Iterator miterator=mlist.iterator();
       		while(miterator.hasNext()){
       			Market m=(Market) miterator.next();
       			System.out.println("Name:"+ m.name+" No:"+m.no);
       		}

	}
		
		public static void marketChange(){
			//String pairsFile= "C:/Ava/android/Dataset/theZoo/RePack-master/RePack-master/repackaging_pairs.txt";
			//String latestFile="C:/Ava/android/Dataset/theZoo/latest.csv";
			String ofile="D:/Ava/Empirical2018/originalAppsDetailsF.csv";
			String rfile="D:/Ava/Empirical2018/repackagedAppsDetailsF.csv";
			BufferedReader br=null;
			BufferedReader obr=null;

			ArrayList<Market> mlist= new ArrayList<Market>();
			String line="";
			String oline="";

			String csvSplitBy=",";
			String marketSplitBy="[|]";
			int similar=0;
			int changed=0;
			try{
				br = new BufferedReader(new FileReader(rfile));
				obr = new BufferedReader(new FileReader(ofile));

				line=br.readLine();//read header
				oline=obr.readLine();//read header

				//line=br.readLine();// first line
				do{//the number should be changed???????????????????

					LINE_NO++;
					String[] pair=line.split(csvSplitBy);
					String[] opair=oline.split(csvSplitBy);

					boolean found=false;
					String repackagedAppmarket = pair[10];
					String originalAppmarket = opair[10];

					String[] markets=repackagedAppmarket.split(marketSplitBy);
					String[] omarkets=originalAppmarket.split(marketSplitBy);
					//find number of apps have published again in the same market
					for(int i=0;i<omarkets.length;i++){
						if(Arrays.asList( markets ).contains(omarkets[i])){
							similar++;
						}
					}
					//find number of apps have published again in other markets.
					for(int i=0;i<markets.length;i++){
						if(!Arrays.asList( omarkets ).contains(markets[i])){
							changed++;
						}
					}
					line=br.readLine();
					oline=obr.readLine();//read header

				}while( line!=null );

			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			System.out.println("similar:"+ similar);
			System.out.println("changed:"+ changed);

       		

	}
		
		
		
		
		public static void countAds(){
			String pairsFile= "C:/Ava/android/Dataset/theZoo/RePack-master/RePack-master/repackaging_pairs.txt";
			//String latestFile="C:/Ava/android/Dataset/theZoo/latest.csv";
			String ofile="C:/Ava/Docs/Empirical/originalCleanAdlibraries-Double.csv";
			String rfile="C:/Ava/Docs/Empirical/repackagedAdlibrariesF.csv";
			String wfile="C:/Ava/Docs/Empirical/repackagedAdlibrariesChanged.csv";
			String wfile1="C:/Ava/Docs/Empirical/repackagedAdlibrariesChangedAddedNone.csv";
			BufferedReader pbr=null;

			BufferedReader obr=null;
			BufferedReader rbr=null;
			BufferedWriter bw=null;
			BufferedWriter bw1=null;
			String line="";
			String csvSplitBy=",";
			LINE_NO=0;
			try{
				pbr = new BufferedReader(new FileReader(pairsFile));

				bw= new BufferedWriter(new FileWriter(wfile));
				bw1= new BufferedWriter(new FileWriter(wfile1));

				line=pbr.readLine();//read header
				//System.out.println(line);
				//line=br.readLine();// first line
				/*for(int i=0;i<3563;i++)
					line=br.readLine();*/
				line=pbr.readLine();// first line
				//System.out.println(line);
				do{//the number should be changed???????????????????
					obr = new BufferedReader(new FileReader(ofile));
					rbr= new BufferedReader(new FileReader(rfile));
					LINE_NO++;
					String[] pair=line.split(csvSplitBy);
					String originalAppSHA = pair[0];
					String repackagedAppSHA = pair[1];//sha256
					//System.out.println(originalAppSHA);
					//	System.out.println("*"+repackagedAppSHA);

					//find apps in latest and copy that lines to pairesdetails.csv
					//findInLatest(originalAppSHA,repackagedAppSHA, ofile, rfile);
					//findInLatest(repackagedAppSHA, rfile);

					boolean oFound=false;
					boolean rFound=false;
					ArrayList<String> rList= new ArrayList<String>();
					ArrayList<String> oList= new ArrayList<String>();
					String oLine=obr.readLine();//header
					//System.out.println(oLine);
					oLine=obr.readLine();
					while(oLine!=null && !oFound){
						
						if(oLine.contains(originalAppSHA)){
							oFound=true;
							//System.out.println(oLine);
							//save all the adlibraries in the list
							String[] oo=oLine.split(csvSplitBy);
							//System.out.println("oo length:"+oo.length);
							if(oo.length==3){//!oo[2].equals("")){
								String[] ads=oo[2].split("[|]");
								for(int i=0;i<ads.length;i++){
									//System.out.println("ads: "+ads[i]);
									oList.add(ads[i]);
								}
							}
						}
						oLine=obr.readLine();
					}
					String rLine=rbr.readLine();//header
					rLine=rbr.readLine();
					while(rLine!=null && !rFound){
						if(rLine.contains(repackagedAppSHA)){
							rFound=true;
							//System.out.println("Repackaged: "+rLine);
							//save all the adlibraries in the list
							String[] oo=rLine.split(csvSplitBy);
							if(oo.length==3){//!oo[2].equals("")){
								String[] ads=oo[2].split("[|]");
								for(int i=0;i<ads.length;i++){
									//System.out.println("ads repackaged:"+ads[i]);
									rList.add(ads[i]);

								}
							}
						}
						rLine=rbr.readLine();
					}
					if(!rList.isEmpty()){
						//System.out.println("isEmpty");
						Iterator<String> miterator=rList.iterator();
						//System.out.println("isEmpty1");
						while(miterator.hasNext()){
							//System.out.println("isEmpty2");
							String ad=(String) miterator.next();
							if(oList.isEmpty()){
								bw1.append(repackagedAppSHA+","+ad);
								System.out.println("****"+repackagedAppSHA+","+ad);
								bw1.newLine();
								bw1.flush();
							}else{
								Iterator<String> oiterator=oList.iterator();
								//System.out.println("isEmpty3");
								boolean adFound=false;
								while(oiterator.hasNext()){
									String oAd=(String) oiterator.next();
									if(oAd.equals(ad)){
										adFound=true;
										//System.out.println("adFound:"+oAd);
										break;
									}
								}
								if(!adFound){
									bw.append(repackagedAppSHA+","+ad);
									System.out.println("**"+repackagedAppSHA+","+ad);
									bw.newLine();
									bw.flush();
								}
								adFound=false;
							}
						}
					}
					oList.clear();
					rList.clear();
					obr.close();
					rbr.close();
					line=pbr.readLine();

				}while( line!=null);
				//obw.close();
				bw.close();
				bw1.close();
			}catch(Exception e){
				System.out.println("Errrrrrrorrr");
				System.out.println(e.getMessage());
			}




	}

	public static void downloadApps(){
		String filename= "C:/Ava/android/Dataset/theZoo/RePack-master/RePack-master/repackaging_pairs.txt";
		String outputfile="C:/Ava/android/Dataset/theZoo/latest5001.csv";
		//System.out.println(args[0]+" ");
		//int r=Integer.parseInt(args[0]);
		//readLine(filename,r);
		BufferedReader br=null;
		BufferedWriter bw=null;
		String line="";
		String csvSplitBy=",";
		int filenumbers= 15297*2;
		try{
			br = new BufferedReader(new FileReader(filename));
			bw= new BufferedWriter(new FileWriter(outputfile));
			for(int i=0;i<filenumbers;i++){//the number should be changed???????????????????
				line=br.readLine();//read header
				LINE_NO++;
				String[] pair=line.split(csvSplitBy);
				String originalAppSHA = pair[0];
               	String repackagedAppSHA = pair[1];//sha256
               	String originalAppName=i+"_"+originalAppSHA+".apk";
               	String repackagedAppName=i+"_"+repackagedAppSHA+"_r.apk";

               	//System.out.println("folder_name = " + folder_name);
               	//System.out.println("apk_name = " + apk_name);
               	
            	//https://androzoo.uni.lu/api/download?apikey=${APIKEY}&sha256=${SHA256}
               	String fileURL="https://androzoo.uni.lu/api/download?apikey="+API_Key+"&sha256="+originalAppSHA;
               	downloadFile(fileURL, folder_name, originalAppName);
               	fileURL="https://androzoo.uni.lu/api/download?apikey="+API_Key+"&sha256="+repackagedAppSHA;
               	downloadFile(fileURL, folder_name, repackagedAppName);


				}
			
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

        System.out.println("done!");
		
	}
	public static void downloadFile(String fileURL, String saveDir, String fileName)
            throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
           
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();
 

            //System.out.println("Content-Type = " + contentType);
            //System.out.println("Content-Length = " + contentLength);
            //System.out.println("fileName = " + fileName);
 
            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;
             
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
 
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
 
            outputStream.close();
            inputStream.close();
 
            System.out.println("File downloaded."+ "Line number="+ LINE_NO);
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode+" in LineNumber="+ LINE_NO);
        }
        httpConn.disconnect();
    }

}
