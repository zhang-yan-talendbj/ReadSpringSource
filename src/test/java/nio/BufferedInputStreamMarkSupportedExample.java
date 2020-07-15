package nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/*
 * This example source code demonstrates the use of  
 * mark() method of BufferedInputStream class
 */

public class BufferedInputStreamMarkSupportedExample {

	public static void main(String[] args) {		
		
		try {
			// initialize an input stream which in this case
			// we are intended to read a file thus 
			// FileInputStream object suits it best
			FileInputStream fis = new FileInputStream(
					"/Users/yan.zhang/Downloads/OpenSource/ReadSpringSource/inputtest_file.txt");
			
			// initialize BufferedInputStream object
			BufferedInputStream buffIs = new BufferedInputStream(fis);
			
			// initialize variables
			int val; //character place holder


			printContent(buffIs);
			if(buffIs.markSupported()){
				// reset the stream
				buffIs.reset();
				// check how many available
				System.out.println("How many available after reset?:"+buffIs.available());
				printContent(buffIs);
			}
			else{
				System.out.println("Mark is not supported by this stream");
			}
			
			
			
			// reset the stream
			buffIs.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("File does not exists");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException occured");
		}				

	}

	private static void printContent(BufferedInputStream buffIs) throws IOException {
		int val;
		while((val=buffIs.read())!=-1){
			// convert the value to character
			char result = (char)val;
			System.out.println("Character read:"+result);

			// check how many available bytes on the stream
			int available = buffIs.available();
			System.out.println("How many available?:"+available);

			// if the remaining stream is 3
			// mark the stream
			if(available==3){
				// check first if mark is supported by this stream
				if(buffIs.markSupported()){
					buffIs.mark(0);
				}
			}

		}
	}

}