import java.util.*;
public class StringArray {

	public boolean IsUnique1(String Str) {
		int len = Str.length();
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for(int i = 0; i < len; i++) {
			if(map.containsKey(Str.charAt(i)))
				return false;
			else 
				map.put(Str.charAt(i), Str.charAt(i)); 
		}
		return true;
	}

	public boolean IsUnique2(String Str) {
		if(Str.length() > 256)
			return false;
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < Str.length(); i++) {
			int val = Str.charAt(i);
			if(char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	public boolean IsUnique3(String Str) {
		int checker = 0;
		for(int i = 0; i < Str.length(); i++) {
			int val = Str.charAt(i);
			if((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public String StringReverse(String Str) {
		char tmp;
		char[] str = Str.toCharArray();
		for(int i = 0, j = Str.length() - 1; i < j; i++, j--){
			tmp = str[i];
			str[i] = str[j];
			str[j] = tmp;
		}
		StringBuffer SB = new StringBuffer();
		for(char w : str) {
			SB.append(w);
		} 
		return SB.toString();
	}

	public boolean IsPermutation1(String s1, String s2) {
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray(); 
		Arrays.sort(a1);
		Arrays.sort(a2);
		if(a1.length != a2.length)
			return false;
		System.out.println(a1);
		System.out.println(a2);
		return Arrays.equals(a1, a2);
	} 

	public boolean IsPermutation2(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		int[] check = new int[128];
		char[] s_array = s1.toCharArray();
		for(char c : s_array) {
			check[c]++;
		}

		for(int i = 0; i < s2.length(); i++) {
			int c = (int)s2.charAt(i);
			if(--check[c] < 0)	
				return false;	
		}
		return true;
	}

	public char[] ReplaceSpace(char[] str, int length) {
		int spacecount = 0;
		for(int i = 0; i < length; i++) {
			if(str[i] == ' ')
				spacecount++;
		}

		int newlength = length + spacecount*2;
		System.out.println(newlength);
		//str[newlength] = '\0';
		char[] st = new char[newlength];
		for(int j = length-1; j >= 0; j--) {
			if(str[j] == ' ') {
				st[--newlength] = '0';
				st[--newlength] = '2';
				st[--newlength] = '%';
			} 
			else {
				st[--newlength] = str[j];
			}
		}
		return st;	
	}
	// aabcccdddeefffgg
	public String compress1(String str) {
		String myStr = "";
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;
			}	
			else {
				myStr = myStr + last + count;
				last = str.charAt(i);
				count = 1;
			}
		} 
		myStr = myStr + last + count;
		return myStr.length() < str.length() ? myStr.toString() : str;
	}

	public String compress2(String str) {
		StringBuffer myStr = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;
			} 
			else {
				myStr.append(last);
				myStr.append(count);
				count = 1;
				last = str.charAt(i);
			}
		}
		myStr = myStr.append(last);
		myStr = myStr.append(count);
		return myStr.toString();
		//return myStr.length() < str.length() ? myStr.toString() : str;
	}

	public void matrixRotate(int mat[][], int n) {
		for(int i = 0; i < n/2; ++i) {
			int head = i;
			int tail = n - 1 - i;
			for(int j = head; j < tail; ++j) {
				int offset = j - head;
				// save top
				int temp = mat[head][j];
				// right --> top
				mat[head][j] = mat[j][tail];
				// bottom --> right 
				mat[j][tail] = mat[tail][tail - offset];
				// left --> bottom
				mat[tail][tail - offset] = mat[tail - offset][head];
				// top --> left
				mat[tail - offset][head] = temp;
			}
		}
	}

	public void showMatrix(int mat[][]) {
		int n = mat.length;
		int m = mat[0].length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(mat[i][j]);
				System.out.print(' ');
			}
			System.out.print('\n');
		}
	}

	public void setZeros(int[][] matrix) {
		boolean[] row = new boolean [matrix.length];
		boolean[] column = new boolean [matrix[0].length];
		for(int i = 0; i < matrix.length; ++i) {
			for(int j = 0; j < matrix[0].length; ++j) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i = 0; i< matrix.length; ++i) {
		 	for(int j = 0; j < matrix[0].length; ++j) {
		 		if(row[i] || column[j]) 
		 			matrix[i][j] = 0;
		 	}
		}
	}

	public boolean isSubstrings(String s1, String s2) {
		boolean flag = false;
		for(int i = 0; i < s1.length() - s2.length(); ++i) {
			if(s2.charAt(0) == s1.charAt(i)) {
				flag = true;
				for(int j = 1; j < s2.length(); ++j) {
					if(s2.charAt(j) != s1.charAt(i + j))
						flag = false;
				}
			}
		}
		return flag;
	}

	public boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length()) 
			return false;

		String myStr = "";
		myStr += myStr + s1 + s1;
		System.out.println(myStr);
		return isSubstrings(myStr, s2) ;
	}
	public static void main(String[] args) {
		StringArray s = new StringArray();
		String s1 = "String";
		String s2 = "ingSto";
		System.out.println(s.isRotation(s1, s2));

	}
}


















