import java.io.File;
import java.util.*;
import java.io.IOException;
class PackageClient{

	static ArrayList<Package> packages = new ArrayList<Package>();
	
	public static void main(String []args){
		//read the package information from the file
		//file format is 
		//from-address:to-address:wt:package-type
		//package-type=1 (two day) 2(overnight)
		
		String line=new String();
		try{
			//read the file and create the objects
			File textFile = new File("package-dup.txt");
			Scanner scan = new Scanner(textFile);
			while(scan.hasNextLine())
			{
				line=scan.nextLine();				
				String []tok=line.split(":");
				String fromAddress=tok[0];
				String toAddress=tok[1];
				float wt=Float.parseFloat(tok[2]);
				int type=Integer.parseInt(tok[3]);
				
				if(type == 1) {
				
					if(!isDuplicate(fromAddress, toAddress, wt)) {
					
						packages.add(new TwoDayPackage(fromAddress, toAddress, wt));					
					}
				}
				else {
				
					if(!isDuplicate(fromAddress, toAddress, wt)) {
					
						packages.add(new OvernightPackage(fromAddress, toAddress, wt));					
					}
				}		
			}
			
		}catch(IOException e){
			System.out.println("Issuse with reading the file. Aborting");
			System.out.println(e.getMessage());
		}
		
		for(Package p : packages) {
		
			System.out.println(p.printReceipt());
		}
	}
	
	public static boolean isDuplicate(String f, String t, float w) {
	
		for(Package p : packages) {
		
			if(p.getFromAddress().equals(f) && p.getToAddress().equals(t) && p.getWeight() == w) {
			
				return true;
			}
		}
		
		return false;
	}
}
