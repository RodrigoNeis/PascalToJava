package project;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PascalOrchestrator {
	static String input="";
	static String output="";
	public static void main(String[] args) {
		System.out.println("test");
		getInput();
		generateOutput();
		System.out.println(".");
	}
	static void getInput(){
		Scanner in = new Scanner(System.in);
		System.out.println("Pascal file path:");
		//String pathname = in.nextLine();
		//just for test
		String pathname = "C:\\Users\\rneis\\workspaces\\Uni\\PascalToJava\\examples\\if.pas";
		in.close();
		try {
			input = readFile(pathname);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error found when try to read the file: " + pathname);
		}	
	}
	
	private static String readFile(String pathname) throws IOException {

	    File file = new File(pathname);
	    StringBuilder fileContents = new StringBuilder((int)file.length());
	    Scanner scanner = new Scanner(file);
	    String lineSeparator = System.getProperty("line.separator");

	    try {
	        while(scanner.hasNextLine()) {        
	            fileContents.append(scanner.nextLine() + lineSeparator);
	        }
	        return fileContents.toString();
	    } finally {
	        scanner.close();
	    }
	}
	static void generateOutput(){
		PascalLexer lexer = new PascalLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PascalParser parser = new PascalParser(tokens);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.program();
		ParseTreeWalker walker = new ParseTreeWalker();
		PascalWalker converter =  new PascalWalker();
		walker.walk( converter , tree );
		
		try {
			File file = new File("output.java");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(converter.translatedSource);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("translation:");
		System.out.println(converter.translatedSource);
		System.out.println("Pascal tree:");
		System.out.println(tree.getText());
		

	}

}
