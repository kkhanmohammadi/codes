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
public class hash {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		activityHash();
		//removeAdsActivities();

	}
	public static void removeAdsActivities(){
		String dataFile= "C:/Ava/Docs/Empirical/androguardoriginal1-10.csv";
		String ofile="C:/Ava/Docs/Empirical/originalActivity-withoutAds.csv";
		ArrayList<String> Ads = new ArrayList<>(Arrays.asList("com.google.android.gms.ads","com.jirbo.adcolony","com.noqoush.adfalcon","com.google.analytics") );
		ArrayList<String> Ads1 = new ArrayList<>(Arrays.asList(	"com.flurry", "com.inmobi",	"com.tapjoy",
				"com.mobclix","com.chartboost","com.adwhirl","com.mopub","com.greystripe","com.jumptap",
				"com.admob","com.burstly","com.sponsorpay","com.cauly","com.mobfox","com.vpon",
				"com.appbrain","net.daum","com.admarvel","com.applovin","com.adfonic", "com.mdotm","com.getjar",
				"com.nexage","com.inneractive","com.pontiflex","com.zestadz","com.madhouse","net.youmi","de.madvertise",
				"cn.domob","com.revmob","com.senddroid","com.airpush","com.tapit","com.medialets","mediba.ad",
				"mediba.ad","com.papaya","com.rhythmnewmedia","com.tapfortap","com.adknowledge","net.metaps","com.wiyun","com.vdopia",
				"com.waps","com.adwo","com.mobosquare","mobi.vserv","com.wooboo","com.everbadge","com.mt.airad",
				"com.moolah","com.kuguo","com.adsmogo","com.sellaring",
				"com.startapp","com.admoda","com.mobpartner","com.quclix","com.ldevelop"));
		ArrayList<String> Ads2 = new ArrayList<>(Arrays.asList("buzzcity"));
		
	           		
		BufferedReader br=null;
		BufferedWriter obw=null;
		String line="";
		String csvSplitBy=",";
		int LINE_NO=0;
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
               	
               	
               	String activities=pair[7];
               	System.out.println("11 "+pair.length);
               	int activities_no=0;
               	List<String> actNew = null;
               	if(!activities.isEmpty()){
               		String[] a=activities.split("[|]");
               		actNew=new ArrayList<String>();
               		//if(a.length>0)
               		for(int i=0;i<a.length;i++){
               			if(!Ads2.contains(a[i].substring(0,a[i].length()-a[i].indexOf("."))) 
               					&& !Ads.contains(a[i].substring(0,a[i].length()-a[i].lastIndexOf(".")))
               					&&!Ads1.contains(a[i].substring(0,a[i].length()-a[i].indexOf(".", a[i].indexOf(".") + 1)))){//////////////////////
               				actNew.add(a[i]);
               			}
               		}
               	}
               	
               	String oLine=appSHA+","+ listString("|", actNew);
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
	public static String listString(String delimetor, List<String> actNew){
		String l="";
		if(actNew.isEmpty())
			return "";
		for (String s : actNew)
		{
		    l += s + delimetor;
		}

		System.out.println(l);
		return l;
	}
	public static void activityHash(){
		String originalHashFile="D:/Ava/Empirical2018/originalActivityHash.txt";
		String repackagedHashFile="D:/Ava/Empirical2018/repackagedActivityHash.txt";
		String outFile = "D:/Ava/Empirical2018/repackagedHashIndex-window-all-test.csv";
		int rLineNo=0;
		int oLineNo=0;
		System.out.println("Activity Hash");
		try {
			BufferedReader rbr=new BufferedReader(new FileReader(repackagedHashFile));
			BufferedWriter bw=new BufferedWriter(new FileWriter(outFile));

			BufferedReader obr=null;
			String line=rbr.readLine();//header			
			rLineNo++;
			line=rbr.readLine();
			rLineNo++;

			while(line!=null && rLineNo<3 ){
				//read first 7 character
				System.out.println("***Repackaged Line:"+line);
				String[] l=line.split(",",-1);
				String[] h=l[0].split(":",-1);
				String activityHash=h[1];
				System.out.println(activityHash);
				int length=activityHash.length();
				System.out.println(length);
				int include=0;
				Integer []includeOriginals =  new Integer[3000];;
				int top=0;
				int start=0;
				while (start+7<=length){
					String window="";
					if(start+7<length){
						window=activityHash.substring(start,start+7);
						//System.out.println(window);
					}else{
						window=activityHash.substring(start);
						//System.out.println(window);

					}
					start=start+7;//+7 is changed
					//read original lines to see if this window is exist
					obr = new BufferedReader(new FileReader(originalHashFile));
					String oLine=obr.readLine();//header			
					oLineNo=0;
					oLine=obr.readLine();
					oLineNo++;
					while(oLine!=null){
						String[] ol=oLine.split(",",-1);
						String[] oh=ol[0].split(":",-1);
						String OactivityHash=oh[1];
						//System.out.println("O:"+OactivityHash);
						int Olength=OactivityHash.length();
						//System.out.println(length);
						int ostart=0;
						while (ostart+7<=Olength){
							String owindow="";
							if(ostart+7<Olength){
								owindow=OactivityHash.substring(ostart,ostart+7);
								//System.out.println(owindow);

							}else{
								owindow=OactivityHash.substring(ostart);
								//System.out.println(owindow);

							}
							if(owindow.equals(window)){
								if(top==0){
									include++;
									includeOriginals[top]=oLineNo;
									System.out.println("oLineNo:"+oLineNo+"top:"+top+"oline:"+oLine);
									top++;
								}else{
								if(!Arrays.asList(includeOriginals).contains(oLineNo)){
									include++;
									includeOriginals[top]=oLineNo;
									System.out.println("hash:"+window+" OlineNo:"+oLineNo+" oline:"+oLine);
									top++;
								}
								}
							}
							ostart=ostart+7;//+7
						}
						oLineNo++;
						oLine=obr.readLine();
					}
					obr.close();



				}
				System.out.println("include:"+include);
				bw.write(l[1]+","+include+",");
				bw.newLine();
				bw.flush();
				include=0;
				line=rbr.readLine();
				rLineNo++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};




	}

}
