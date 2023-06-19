package tw.org.iii.tutor;

public class test16 {

	public static void main(String[] args) {
		int[]a= new int[3];
		boolean[]b= new boolean[4];
		byte[]c= new byte[3];
		short[]d= new short[3];
		long[]e= new long[3];
		float[]a1= new float[3];
		char[]a2= new char[3];
		double[]a3= new double[3];

				
		System.out.println(a.length);//length陣列裡元素個數
		System.out.println(b.length);
		System.out.println(a[0]);
		a[0]=76;
		a[1]=123;
		for (int i =0;i<a.length;i++){
			System.out.println(a[i]);
		}
		for(int i :a) { //for-each 跑全部元素
			System.out.println(i);
		}

		
	}

}
