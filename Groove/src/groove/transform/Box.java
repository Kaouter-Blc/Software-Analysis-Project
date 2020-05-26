package groove.transform;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box {
// This class generate features associated with nodes/edges 
//and write it in a csv file
	private ArrayList<Box> contents;
	private String Name;
	static int x = 1;
	private String feature = "";
	static String fiapply = "f1";
	static int y = 1;
	static int z = 1;
//	private ArrayList<String> csvcontents;

// constructor for edge "t" and nodes "b"
	public Box(String type) {
		this.contents = new ArrayList<Box>();
		switch (type) {
		// secondly groove create t1, to name it t"1" we substract 2 to x we obtain 1
		case "t":
			int y = x - 2;
			this.Name = type + y + " ";
			break;
		// first groove create b2, knowing that b1 is already created when we run
		// groove, x = 2
		default:
			this.Name = type + x + " ";
			x += 1;// so after b2 is named b2, x=3
			break;
		}
	}

// To Modify box's feature
	public void setfeature(String feat) {
		this.feature = feat;
	}

// To obtain box's feature
	public String getfeature() {
		return this.feature;
	}

	public void addBox(Box b) {
		this.contents.add(b);
	}

// remove the last box in the list contents
	public void removeBox() {
		this.contents.remove(this.contents.size());
	}

// allocate features to every box type i.e node/edge
	public void generatefeatures() throws FileNotFoundException, IOException {
		// "this" is b1, we assign f1 as his feature
		this.setfeature("f1 ");
		String addition = "";
		// for each node(box)/edge(box) in the list, it associate a condition
		for (Box b : this.contents) {
			// if b is the first element which is "b2" of the list "contents"
			if (b == this.getBoxes().get(0)) {
				// we add to assign to it the feature f2
				this.getBoxes().get(0).setfeature("f2 ");
				// if b is the second element which is "t1" of the list "contents"
			} else if (b == this.getBoxes().get(1)) {
				// we add to assign to it the feature (and f1 f2)
				this.getBoxes().get(1).setfeature("(and f1 f2) ");

				addition = "(and " + this.getfeature() + this.getBoxes().get(0).getfeature()
						+ this.getBoxes().get(1).getfeature();
			} else {
				// To assign 2 elements by 2 elements the same value "addition"
				if (z > 2) {
					addition += addition + ")";
					z = 2;
				} else
					z++;
				// here we assign to b which is an element of the list "contents"
				b.setfeature(addition + ")");
			}

		}
		this.csvWriter();

	}

// this function write directly in the csv file to register "node/edge feature"
	public void csvWriter() throws FileNotFoundException, IOException {
		String ret = this.Name + " , " + this.feature + "\n";
		// for each element b(type Box) in the list "contents", we add his name and
		// feature in "ret" variable(which is a String type)
		for (Box b : this.contents) {
			ret += b.Name + " , " + b.feature + "\n";
		}
		System.out.println(ret);
		List<String> lignes = Arrays.asList(ret);
		// locate the file where we'll write
		Path fichier = Paths.get("mapping.csv");
		// To write in the file, use the following command
		Files.write(fichier, lignes, Charset.forName("UTF-8"));
	}

	public List<Box> getBoxes() {
		return this.contents;
	}

}
