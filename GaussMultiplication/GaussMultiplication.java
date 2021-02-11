/*Author: Juan Antonio Sicardo Contreras
* Date: Fall of 2019
* Description: This program does the multiplication of two base n, using the Gauss Multiplication Formula.
* The base of the numbers can be from binary, all the way to hexadecimal.
* Similar to BinaryMultiplication in structure.
*/

public class GaussMultiplication{



	//Main
	public static void main(String args[]){

		if(args.length < 3){
			System.out.println("Usage: java GaussMultiplication [base] [num1] [num2]");
			System.exit(1);
		}

		int base, x[], y[], result[];

		base = Integer.parseInt(args[0].trim());
		x = stringToIntArray(args[1]);
		y = stringToIntArray(args[2]);

		result = gaussMultiplication(base, x, y);
		System.out.println(intArrayToString(result));
	}



	//Does the multiplication of x and y (both in the same base or radix) using the Gauss Multiplication Formula.
	static int[] gaussMultiplication(int base, int x[], int y[]){
		int i, diference, length, np1, np2, np3, nresult, xl[], xr[], yl[], yr[], ax[], ay[], p1[], p2[], p3[], result[];

		//We make both numbers be of the same size
		diference = x.length - y.length;
		if(diference > 0)
			y = addCerosStart(diference, y);
		else if(diference < 0)
			x = addCerosStart(-diference, x);

		//We make both numbers have 2^x digits so it can be divided in halves recursevely.
		for(i = 1; i < x.length; i *= 2);

		diference = i - x.length;
		if(diference > 0){
			x = addCerosStart(diference, x);
			y = addCerosStart(diference, y);
		}
		
		length = x.length;

		//Base case: both numbers have just one digit, in wich case we just multiply them
		if(length == 1){
			return simpleProduct(base, x, y);
		}

		//We separate the numbers in halves and calculate some numbers needed for the Gauss Multiplication Formula
		xl = leftHalf(x);
		xr = rightHalf(x);
		yl = leftHalf(y);
		yr = rightHalf(y);
		ax = addition(base, xl, xr);
		ay = addition(base, yl, yr);
		p1 = gaussMultiplication(base, xl, yl);
		p2 = gaussMultiplication(base, ax, ay);
		p3 = gaussMultiplication(base, xr, yr);

		np1 = intArrayToInt(base, p1);
		np2 = intArrayToInt(base, p2);
		np3 = intArrayToInt(base, p3);

		nresult = ((int)Math.pow(base, length) * np1) + ((int)Math.pow(base, length/2) * (np2-np1-np3)) + np3;
		result = intToIntArray(base, nresult);
		return trimCeros(result);
	}



	//Multiplication between two one-digit numbers of the same base or radix
	static int[] simpleProduct(int base, int x[], int y[]){
		int newArray[];
		int result = x[0] * y[0];

		if(result > base - 1){
			newArray = new int[2];
			newArray[0] = result/base;
			newArray[1] = result%base;
		}
		else{
			newArray = new int[1];
			newArray[0] = result;
		}

		return newArray;
	}



	//Transforms an array of integers to an iteger where each element of the array is a digit of the resulting
	//integer.
	static int intArrayToInt(int base, int number[]){
		int result = 0;

		for(int i = 0; i < number.length; i++)
			result += number[i] * (int)Math.pow(base, number.length - i - 1);

		return result;
	}



	//Transforms an int to an int array where each digit of the integer is going to be an element of the array.
	static int[] intToIntArray(int base, int number){
		if(number == 0){
			int newArray[] = new int[1];
			newArray[0] = 0;
			return newArray;
		}

		if(number == 1){
			int newArray[] = new int[1];
			newArray[0] = 1;
			return newArray;
		}
		int length = (int)(Math.ceil(Math.log(number + 1)/Math.log(base)));

		int newArray[] = new int[length];
		int copy = number;

		for(int i = length - 1; i >= 0; i--){
			int digit = copy%base;
			newArray[i] = digit;
			copy -= digit;
			copy /= base;
		}

		return newArray;
	}



	//Adds two numbers of the same base or radix.
	static int[] addition(int base, int x[], int y[]){
		int diference, lengthWithCeros, carry, newArray[];
		diference = x.length - y.length;

		//Makes the two numbers have the same length
		if(diference > 0)
			y = addCerosStart(diference, y);
		else if(diference < 0)
			x = addCerosStart(-diference, x);

		lengthWithCeros = x.length;
		newArray = new int[lengthWithCeros + 1];
		carry = 0;

		for(int i = lengthWithCeros - 1; i >= 0; i--){
			int result = x[i] + y[i] + carry;
			carry = result/base;
			newArray[i + 1] = result%base;
		}
		newArray[0] = carry;

		return trimCeros(newArray);
	}



	//Returns the left (leading) half of a number.
	static int[] leftHalf(int number[]){
		int newLength = number.length/2;
		int newArray[] = new int[newLength];

		for(int i = 0; i < newLength; i++)
			newArray[i] = number[i];

		return newArray;
	}



	//Returns the right (trailing) half of a number.
	static int[] rightHalf(int number[]){
		int newLength = number.length/2;
		int newArray[] = new int[newLength];

		for(int i = 0; i < newLength; i++)
			newArray[i] = number[i + newLength];

		return newArray;
	}



	//Eliminates al leading zeros of a number.
	static int[] trimCeros(int number[]){
		//System.out.println(intArrayToString(number));
		int ceroCount = 0;
		boolean notCeroEncountered = false;

		for(int i = 0; i < number.length; i++){
			if(number[i] == 0)
				ceroCount++;
			else{
				notCeroEncountered = true;
				break;
			}
		}

		if(ceroCount == number.length){
			int newArray[] = new int[1];
			newArray[0] = 0;
			return newArray;
		}

		int length = number.length;
		int newLength = length - ceroCount;
		int newArray[] = new int[newLength];

		for(int i = 0; i < newLength; i++)
			newArray[i] = number[i + ceroCount];

		return newArray;
	}



	//Transforms a string to an integer array where each character of the string becomes a numerical element
	//of the integer array, using hexadecimal notation.
	static int[] stringToIntArray(String number){
		int numberLength = number.length();
		int newArray[] = new int[numberLength];

		for(int i = 0; i < numberLength; i++)
			switch(number.charAt(i)){
				case '0': newArray[i] = 0; break;
				case '1': newArray[i] = 1; break;
				case '2': newArray[i] = 2; break;
				case '3': newArray[i] = 3; break;
				case '4': newArray[i] = 4; break;
				case '5': newArray[i] = 5; break;
				case '6': newArray[i] = 6; break;
				case '7': newArray[i] = 7; break;
				case '8': newArray[i] = 8; break;
				case '9': newArray[i] = 9; break;
				case 'a': newArray[i] = 10; break;
				case 'b': newArray[i] = 11; break;
				case 'c': newArray[i] = 12; break;
				case 'd': newArray[i] = 13; break;
				case 'e': newArray[i] = 14; break;
				case 'f': newArray[i] = 15; break;
				case 'A': newArray[i] = 10; break;
				case 'B': newArray[i] = 11; break;
				case 'C': newArray[i] = 12; break;
				case 'D': newArray[i] = 13; break;
				case 'E': newArray[i] = 14; break;
				case 'F': newArray[i] = 15; break;
			}
		return newArray;
	}



	//Transforms an integar array to a string representation, where each integer of the array becomes one
	//character of the string, using hexadecimal notation. 
	static String intArrayToString(int number[]){
		StringBuilder newString = new StringBuilder();

		for(int i = 0; i < number.length; i++)
			switch(number[i]){
				case 0: newString.append('0'); break;
				case 1: newString.append('1'); break;
				case 2: newString.append('2'); break;
				case 3: newString.append('3'); break;
				case 4: newString.append('4'); break;
				case 5: newString.append('5'); break;
				case 6: newString.append('6'); break;
				case 7: newString.append('7'); break;
				case 8: newString.append('8'); break;
				case 9: newString.append('9'); break;
				case 10: newString.append('A'); break;
				case 11: newString.append('B'); break;
				case 12: newString.append('C'); break;
				case 13: newString.append('D'); break;
				case 14: newString.append('E'); break;
				case 15: newString.append('F'); break;
			}

		return newString.toString();
	}



	//Ataches a number of leading zeroes to a number.
	static int[] addCerosStart(int numOfCeros, int number[]){
		int newArray[] = new int[numOfCeros + number.length];

		for(int i = 0; i < numOfCeros; i++)
			newArray[i] = 0;

		for(int i = 0; i < number.length; i++)
			newArray[i + numOfCeros] = number[i];

		return newArray;
	}



	//Ataches a number of trailing zeroes to a number.
	static int[] addCerosEnd(int numOfCeros, int number[]){
		int newArray[] = new int[numOfCeros + number.length];

		for(int i = 0; i < number.length; i++)
			newArray[i] = number[i];

		for(int i = 0; i < numOfCeros; i++)
			newArray[i + number.length] = 0;

		return newArray;
	}
}