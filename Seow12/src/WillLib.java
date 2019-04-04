
public class WillLib {

	public static void mergesort(String[] arr) {

		if (arr.length < 2) {

			return;

		}

		int middle = arr.length / 2;
		int right = arr.length - middle;

		String[] tempLeft = new String[middle];
		String[] tempRight = new String[right];

		for (int i = 0; i < middle; i++) {

			tempLeft[i] = arr[i];

		}

		for (int i = middle; i < arr.length; i++) {

			tempRight[i - middle] = arr[i];

		}

		mergesort(tempLeft);
		mergesort(tempRight);

		merge(arr, tempLeft, tempRight, middle, right);

	}

	private static void merge(String[] arr, String[] tempLeft, String[] tempRight, int middle, int right) {

		int i = 0, j = 0, k = 0;

		while (i < middle && j < right) {

			if (tempLeft[i].compareTo(tempRight[j]) < 0)
				arr[k++] = tempLeft[i++];

			else
				arr[k++] = tempRight[j++];

		}

		while (i < middle) {

			arr[k++] = tempLeft[i++];

		}

		while (j < right) {

			arr[k++] = tempRight[j++];

		}
	}

}
