import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class Main {
	
	//dosyadaki satýrlarý bir array'e ekler ve array'i döndürür.
	public static String[] fileToArray(String dosya) throws IOException {
		File file = new File(dosya);
		
		FileReader fileReader = new FileReader(file);
		String line;

		BufferedReader br = new BufferedReader(fileReader);
		
		String[] arr1 = new String[100];

		int i = 0;
		while ((line = br.readLine()) != null) {
			arr1[i] = line;
			i++;
		    

		}

		br.close();
		
		return arr1;	
	}

	//dosyadaki satýrlarý bir linkedlist'e ekler ve linkedlist'i döndürür.
	public static LinkedList<String> fileToLinkedlist(String dosya) throws IOException {
		File file = new File(dosya);
		
		FileReader fileReader = new FileReader(file);
		String line;

		BufferedReader br = new BufferedReader(fileReader);
		
		LinkedList<String> linkedlist=new LinkedList<String>();

		while ((line = br.readLine()) != null) {
			linkedlist.add(line);

		}

		br.close();
		
		return linkedlist;
	}
	
	public static void main(String[] args) throws IOException {
		
		long startTime = System.nanoTime();
		
		String[] arr1 = fileToArray("input_one.txt");
		Arrays.sort(arr1);
		
		/*BufferedWriter writerArr1 = new BufferedWriter(new FileWriter("SortedArr1.txt"));
		for (String s: arr1) {
			writerArr1.write(s + "\n");
		}
		writerArr1.close();*/
		
		
		
		String[] arr2 = fileToArray("input_two.txt");
		Arrays.sort(arr2);
		
		/*BufferedWriter writerArr2 = new BufferedWriter(new FileWriter("SortedArr2.txt"));
		for (String s: arr2) {
			writerArr2.write(s + "\n");
		}
		writerArr2.close();*/
		
		//iki array'i karþýlaþtýrýp bulunma durumlarýný yazar.
		int i;
		BufferedWriter writerArrays = new BufferedWriter(new FileWriter("OutputArrays.txt"));
		for (i = 0; i < arr1.length; i++) {
			Boolean isExist = false;
			for (int a = 0; a < arr2.length; a++) {
				if (arr1[i].equals(arr2[a])) {
					//System.out.println(arr1[a]);
					writerArrays.write(arr1[i] + " is ***EXÝST*** in both files.\n");
					isExist = true;
				}
			}
			if (!isExist) {
				writerArrays.write(arr1[i] + "   is ---NOT--- exist in second file.\n");
			}
        }
		writerArrays.close();
		
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time for array : " + timeElapsed / 1000);
		
		
		long startTime2 = System.nanoTime();
		
		LinkedList<String> linkedlist1 = fileToLinkedlist("input_one.txt");
		Collections.sort(linkedlist1);
		
		BufferedWriter writerLinked1 = new BufferedWriter(new FileWriter("SortedLinkedlist1.txt"));
		for (String s: linkedlist1) {
			writerLinked1.write(s + "\n");
		}
		writerLinked1.close();
		
		LinkedList<String> linkedlist2 = fileToLinkedlist("input_two.txt");
		Collections.sort(linkedlist2);
		
		BufferedWriter writerLinked2 = new BufferedWriter(new FileWriter("SortedLinkedlist2.txt"));
		for (String s: linkedlist2) {
			writerLinked2.write(s + "\n");
		}
		writerLinked2.close();
		
		//iki listeyi satýr sýrasýna göre tek dosyaya yazar.
		BufferedWriter writerLinkedlists = new BufferedWriter(new FileWriter("OutputLinkedlists.txt"));
		Iterator<String> itr1=linkedlist1.iterator();
		 
		
		Boolean isExist;
		while(itr1.hasNext()) {
			String elemanList1 = itr1.next();
			
			isExist = false;
			Iterator<String> itr2=linkedlist2.iterator();
			
			while(itr2.hasNext() ) {
				String elemanList2 = itr2.next();
				if (elemanList1.equals(elemanList2)) {
					writerLinkedlists.write(elemanList1 + " is ***EXÝST*** in both files.\n");
					isExist = true;
				    }
			}
			if (!isExist) {
				writerLinkedlists.write(elemanList1 + " is ---NOT--- exist in second file.\n");
				}
			}
			writerLinkedlists.close();
		
		long endTime2 = System.nanoTime();
		long timeElapsed2 = endTime2 - startTime2;
		System.out.println("Execution time for linkedlist : " + timeElapsed2 / 1000);
	}

}