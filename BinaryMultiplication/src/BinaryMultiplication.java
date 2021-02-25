/*Author: Juan Antonio Sicardo Contreras
* Date: Fall of 2019
* Description: This program multiplies two binary numbers. It uses the strategy "Divide and Conquer" which also
* uses recursion.
*/

public class BinaryMultiplication{

	//Eliminates any leading zero.
	private static int[] trimCeros(int[] binary){
		int i, array[];
		for(i = 0; binary[i] == 0 && i < binary.length -1; i++);

		array = new int[binary.length - i];

		for(int j = 0; j < array.length; j++)
			array[j] = binary[j+i];

		return array;
	}

	//Transforms a String to an array of ints
	private static int[] stringToIntArray(String binary){
		int array[] = new int[binary.length()];

		for(int i = 0; i < binary.length(); i++)
			if(binary.charAt(i) == '0')
				array[i] = 0;
			else
				array[i] = 1;

		return array;
	}

	//Transforms the binary number to an String
	private static String intArrayToString(int[] array){
		String string = new String("");

		for(int i = 0; i < array.length; i++)
			if(array[i] == 0)
				string = string.concat("0");
			else
				string = string.concat("1");

		return string;
	}

	//Separated one half of a binary number with i for izquierda (left or leading side) and d for derecha
	//(right or trailing side)
	private static int[] divide(int binary[], char option){
		int n = binary.length;
		int array[] = new int[n/2];
		int offset;

		if(option == 'i')
			offset = 0;
		else
			offset = n/2;

		for(int i = 0; i < n/2; i++)
			array[i] = binary[i+offset];

		return array;
	}

	//Add n leading zeros to the binary number
	private static int[] addCerosStart(int binary[], int n){
		int array[] = new int[binary.length + n];

		for(int i = 0; i < n; i++)
			array[i] = 0;

		for(int i = n; i < array.length; i++)
			array[i] = binary[i-n];

		return array;
	}

	//Add n trailing zeros to the binary number.
	private static int[] addCerosEnd(int binary[], int n){
		int array[] = new int[binary.length + n];

		for(int i = 0; i < binary.length; i++)
			array[i] = binary[i];

		for(int i = binary.length; i < array.length; i++)
			array[i] = 0;

		return array;
	}

	//Add two binary numbers.
	private static int[] add(int binary1[], int binary2[]){
		int i, array[], carry;

		if(binary1.length - binary2.length < 0)
			binary1 = addCerosStart(binary1 ,binary2.length - binary1.length);

		if(binary2.length - binary1.length < 0)
			binary2 = addCerosStart(binary2 ,binary1.length - binary2.length);
		i = binary1.length;

		array = new int[i+1];
		carry = 0;

		for(int j = i-1; j >= 0; j--){
			int sum = binary1[j] + binary2[j] + carry;
			if(sum > 1)
				carry = 1;
			else
				carry = 0;
			array[j+1] = sum%2;
		}

		return array;
	}

	//Multiplies two binary numbers using the "Divide and Conquer" strategy.
	//binary1 and binary2 must be of the same size an have 2^x digits.
	private static int[] multiply(int n, int[] binary1, int[] binary2){
		int array[];

		//Base case: the two binary numbers have just one digit, then we make a simple multiplication.
		if(binary1.length == 1 && binary2.length == 1){
			array = new int[1];
			array[0] = binary1[0] * binary2[0];
			return array;
		}

		//We separate the binary numbers, each into two. With i for izquierda (left or leading),
		//and d for derecha (right or trailing)
		int bin1i[] = divide(binary1, 'i');
		int bin1d[] = divide(binary1, 'd');
		int bin2i[] = divide(binary2, 'i');
		int bin2d[] = divide(binary2, 'd');

		array = add(add(addCerosEnd(multiply(n/2, bin1i, bin2i), n), addCerosEnd(multiply(n/2, bin1i, bin2d), n/2)), add(addCerosEnd(multiply(n/2, bin1d, bin2i), n/2), multiply(n/2, bin1d, bin2d)));
		return array;
	}

	//Main
	public static void main(String args[]){

		if(args.length < 2) {
			System.out.println("Usage: java BinaryMultiplication binary1 binary2.");
			System.exit(1);
		}

		int aux, bin1Array[], bin2Array[];
		String bin1String, bin2String;

		bin1String = args[0].trim();
		bin2String = args[1].trim();

		//We make sure that both numbers are of the same size adding leading zeros.
		while(bin1String.length() < bin2String.length())
			bin1String = "0".concat(bin1String);

		while(bin2String.length() < bin1String.length())
			bin2String = "0".concat(bin2String);

		//We make sure that both numbers have 2^x digits so it can be divided by two recursevely.
		for(aux = 1; aux < bin1String.length(); aux*=2);

		while(bin1String.length() < aux){
			bin1String = "0".concat(bin1String);
			bin2String = "0".concat(bin2String);
		}

		bin1Array = stringToIntArray(bin1String);
		bin2Array = stringToIntArray(bin2String);

		System.out.println(intArrayToString(trimCeros(multiply(bin1Array.length, bin1Array, bin2Array))));
	}
}