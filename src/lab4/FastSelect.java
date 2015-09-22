/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author ekozi
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class FastSelect {
	ArrayList < Integer > list;
	public FastSelect() {
		list = new ArrayList < Integer > ();
	}
	public void populate(String name) {

		try {
			String dummy = " ";
			BufferedReader reader = new BufferedReader(new FileReader(name));
			while ((dummy = reader.readLine()) != null) {
				list.add(Integer.parseInt(dummy.split(" ")[1]));
			}
			reader.close();
		} catch (Exception ex) {
			System.out.print("File was not found");
		}

	}
	private int fastSelect(ArrayList < Integer > list, int number) {
		ArrayList < Integer > smallestList = new ArrayList < Integer > ();
		ArrayList < Integer > largestList = new ArrayList < Integer > ();



		while (!list.isEmpty()) {

			int pivot = list.get(list.size() / 2);
			int count = 0;
			for (Integer l: list) {
				if (pivot == l) count++;
				if (l < pivot) smallestList.add(l);
				else largestList.add(l);

			}

			if (number >= smallestList.size() && number < smallestList.size() + count) {

				return pivot;
			} else if (smallestList.size() > number) {


				list.clear();

				for (Integer l: smallestList) {
					list.add(l);

				}

				smallestList.clear();

			} else {

				number = number - smallestList.size() - count;
				list.clear();

				for (Integer i: largestList)
				list.add(i);
				largestList.clear();

			}

		}
		return 0;

	}
	public void finFastest(int number) {
		System.out.print(fastSelect(list, number));
	}
}