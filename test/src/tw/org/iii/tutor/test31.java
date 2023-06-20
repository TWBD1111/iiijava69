package tw.org.iii.tutor;

public class test31 {

	public static void main(String[] args) {
		String s1 = "Brad";
		String s2 =s1.concat("iii");
		System.out.println(s1);
		System.out.println(s2);
		String s3 = s1.replace('a', 'k');//replace並不會真的換掉
		System.out.println(s1);
		System.out.println(s3);
	}

}
