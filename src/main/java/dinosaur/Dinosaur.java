package dinosaur;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class DinosaurInfo implements Comparable<DinosaurInfo>{
		String name;
		double legLength;
		String diet;
		double strideLength;
		String stance;
		double speed;

		@Override
    	public int compareTo(DinosaurInfo another) {
	        if (another.speed < this.speed){
	            return -1;
	        }else{
	            return 1;
	        }
    	}
}

public class Dinosaur {

	private	List<DinosaurInfo> bipedals = new ArrayList<DinosaurInfo>();
	private	Map<String, DinosaurInfo> bipedalsMoreInfo = new HashMap<String, DinosaurInfo>();
	private static final Double G = 9.8;

	public void processDinosaurs(String patchCsv1, String patchCsv2){
		Scanner scanner = null;
        try {
            scanner = new Scanner(new File(patchCsv2));
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
            	String contentFileByLine = scanner.nextLine();
            	String[] items = contentFileByLine.split(",");
             	if("bipedal".equals(items[2])){
             		DinosaurInfo dinosaurInfo = new DinosaurInfo();
             		dinosaurInfo.name = items[0];
             		dinosaurInfo.strideLength = Double.parseDouble(items[1]);
             		dinosaurInfo.stance = items[2];

             		bipedals.add(dinosaurInfo);
             	}
            }

            scanner = new Scanner(new File(patchCsv1));
            scanner.nextLine();
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
            	String contentFileByLine = scanner.nextLine();
            	String[] items = contentFileByLine.split(",");
         		DinosaurInfo dinosaurInfo = new DinosaurInfo();
         		dinosaurInfo.name = items[0];
         		dinosaurInfo.legLength = Double.parseDouble(items[1]);
         		dinosaurInfo.diet = items[2];

         		bipedalsMoreInfo.put(dinosaurInfo.name, dinosaurInfo);
            }
            scanner.close();

            for(DinosaurInfo dinosaurInfo : bipedals){
            	if(bipedalsMoreInfo.containsKey(dinosaurInfo.name)){
            		DinosaurInfo dinosaurInfoMore = bipedalsMoreInfo.get(dinosaurInfo.name);
            		dinosaurInfo.legLength = dinosaurInfoMore.legLength;
            		dinosaurInfo.diet = dinosaurInfoMore.diet;

            		dinosaurInfo.speed = ((dinosaurInfo.strideLength / dinosaurInfo.legLength) - 1) *
            				Math.sqrt(dinosaurInfo.legLength * G);
            	}
            }

            Collections.sort(bipedals);

            for(DinosaurInfo dinosaurInfo : bipedals){
            	System.out.println(dinosaurInfo.name);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}

	
}