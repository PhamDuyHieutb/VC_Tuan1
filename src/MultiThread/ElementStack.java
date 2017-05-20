package MultiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ElementStack implements Comparator<Word> {

	public static Stack listElement = new Stack();

	public static void AddElement(Object a) {
		listElement.push(a);
	}

	public static Object GetElement() {
		if (listElement.isEmpty()) {
			return null;
		} else {
			return listElement.pop();
		}

	}

	public static int getSize() {
		return listElement.size();
	}

	public static ArrayList<Word> SumArray() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Word> ListSort = new ArrayList();

		while (!listElement.isEmpty()) {
			HashMap<String, Integer> rawElement = (HashMap<String, Integer>) listElement.pop();

			for (Map.Entry<String, Integer> entry : rawElement.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();

				if (map.containsKey(entry.getKey())) {
					map.put(key, map.get(key) + value);
				} else {
					map.put(key, value);
				}
			}

		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			ListSort.add(new Word(entry.getKey(), entry.getValue()));

		}
		//
		// Collections.sort(ListSort,new Comparator<Word>() {
		//
		// @Override
		// public int compare(Word o1, Word o2) {
		//
		// return o1.getValue().compareTo(o2.getValue());
		// }
		// });

		ListSort.sort(Comparator.comparing(Word::getValue));

		return ListSort;
	}

	@Override
	public int compare(Word o1, Word o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
