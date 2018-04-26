import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/* pooya panahandeh S7RFBI, BSc student at ELTE University */


public class Heads_Or_Tails {

	//--------  Exercise-1 -------------
	// Compute and display the number of times did it occur in the trial that exactly two heads
	// were tossed after each other
	private static void exercise1(int N, String trial) {
		int countTwoHeadsTogether = 0;
		int countHeadsTogether = 0;

		for(int i = 0; i < N; i++) {
			if(trial.charAt(i) == 'H') {
				countHeadsTogether++;
			} else {
				if(countHeadsTogether == 2) {
					countTwoHeadsTogether++;
				}
				countHeadsTogether = 0;
			}
		}
		if(countHeadsTogether == 2)
			countTwoHeadsTogether++;

		System.out.println(countTwoHeadsTogether);
	}

	//----------- Exercise-2 ---------------------------------
	// Find the length of the longest subsequence that contained only heads, and the longest subsequence
	// that contained only tails. Print both lengths as integer numbers separated by a space.
	private static void exercise2(int N, String trial) {
		int currHSeqLen = 0;
		int currTSeqLen = 0;
		int longestHeadSubsequenceSize = 0;
		int longestTailSubsequenceSize = 0;
		char prevHeadOrTail = trial.charAt(0);

		for(int i=0; i < N; i++) {
			if(prevHeadOrTail != trial.charAt(i)) {
				if(prevHeadOrTail == 'H' && currHSeqLen >= longestHeadSubsequenceSize) {
					longestHeadSubsequenceSize = currHSeqLen;
					currHSeqLen = 0;
				}
				if(prevHeadOrTail == 'T' && currTSeqLen >= longestTailSubsequenceSize) {
					longestTailSubsequenceSize = currTSeqLen;
					currTSeqLen = 0;
				}
			}

			if(trial.charAt(i) == 'H')
				currHSeqLen++;
			else
				currTSeqLen++;
			prevHeadOrTail = trial.charAt(i);
		}

		if(currHSeqLen > 0 && currHSeqLen > longestHeadSubsequenceSize)
			longestHeadSubsequenceSize = currHSeqLen;

		if(currTSeqLen > 0 && currTSeqLen > longestTailSubsequenceSize)
			longestTailSubsequenceSize = currTSeqLen;

		System.out.println(longestHeadSubsequenceSize + " " +  longestTailSubsequenceSize);
	}

	//---------------------- Exercise-3 ------------------------------------------------
	// Find out which is the most frequent length for heads series. If there are more than
	// one "most frequent" heads series lengths, print the longest. If there are no heads
	// in the trial, print zero.
	private static void exercise3(int N, String trial) {
		Map<String, Integer> headSeriesFreqMap = new HashMap<String, Integer>();
		String currSeries = "";

		for(int i=0; i < N; i++) {
			if(trial.charAt(i) == 'H')
				currSeries += 'H';
			else if(currSeries.length() > 0) {
				if(headSeriesFreqMap.containsKey(currSeries)) {
					int newFreq = headSeriesFreqMap.get(currSeries) + 1;
					headSeriesFreqMap.put(currSeries, newFreq);
				} else {
					headSeriesFreqMap.put(currSeries, 1);
				}
				currSeries = "";
			}
		}
		if(currSeries.length() > 0) {
			if(headSeriesFreqMap.containsKey(currSeries)) {
				int newFreq = headSeriesFreqMap.get(currSeries) + 1;
				headSeriesFreqMap.put(currSeries, newFreq);
			} else {
				headSeriesFreqMap.put(currSeries, 1);
			}
		}
		int lenMostFreqSeries = 0;
		int mostFreq = 0;
		for(Entry<String, Integer> entry: headSeriesFreqMap.entrySet()) {
			if(entry.getValue() > mostFreq) {
				mostFreq = entry.getValue();
				lenMostFreqSeries = entry.getKey().length();
			} else if(entry.getValue() == mostFreq) {
				if(entry.getKey().length() > lenMostFreqSeries) {
					lenMostFreqSeries = entry.getKey().length();
				}
			}
		}

		System.out.println(lenMostFreqSeries);
	}

	public static void main(String[] args) {

		// create scanner to read from standard input
		Scanner input = new Scanner(System.in);

		// read N
		int N = input.nextInt();
		input.nextLine();

		// read the line containing toss trial result (N characters of T or H)
		String trial = input.nextLine();

		// run all the exercises
		exercise1(N, trial);
		exercise2(N, trial);
		exercise3(N, trial);

		// close the scanner
		input.close();
	}

}
