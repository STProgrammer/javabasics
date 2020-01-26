import java.io.*;

public class Test {
	public static void main(String args[]) throws IOException {
		DataOutputStream output = new DataOutputStream(
				new FileOutputStream("d.dat"));
		output.writeUTF("ABCD");
		System.out.println(output.size());
		output.close();
	}
}