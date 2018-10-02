public  Integer[] digitRootSort(int[] a) {
		 List <Integer> finalList = new ArrayList<>();
		TreeMap<Integer, List<Integer>> tm = new TreeMap<Integer, List<Integer>>();
		int sum = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] / 10 == 0) {
				if (tm.containsKey(a[i])) {
					tm.get(a[i]).add(a[i]);
					Collections.sort(tm.get(a[i]));
				} else {
					tm.put(a[i], new ArrayList<Integer>());
					tm.get(a[i]).add(a[i]);
				}
			} else {
				sum = sum(a[i]);
				//System.out.println("sum is " + sum);
				if (tm.containsKey(sum)) {
					tm.get(sum).add(a[i]);
					Collections.sort(tm.get(sum));
				} else {
					tm.put(sum, new ArrayList<Integer>());
					tm.get(sum).add(a[i]);
				}
			} // else ended
		} // for ended
		for (Map.Entry<Integer, List<Integer>> e : tm.entrySet()) {
			finalList.addAll(e.getValue());
		}
		return finalList.toArray(new Integer[finalList.size()]);
	}// method ended

	static int sum(int n) {
		int root = 0;
		// Loop to do sum while
		// sum is not less than
		// or equal to 9
		while (n > 0 || root > 9) {
			if (n == 0) {
				n = root;
				root = 0;
			}
			root += n % 10;
			n /= 10;
		}
		return root;
	}