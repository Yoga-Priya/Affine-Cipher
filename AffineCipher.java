import java.util.Scanner;

public class AffineCipher {
	static int mod;
	static int temp;
	static int quotient;
		public static void main(String[] args) {
			Scanner k = new Scanner(System.in);
			System.out.println("Enter Your Choice 1.Plain text to cipher text || 2.cipher text to plain text || 3.cryptanalysis");
	int d = 0;
	int c = k.nextInt();
	switch(c)
	        {
	case 1:
	            {
	System.out.println("Enter The Plain text:");
	        String a = k.next();
	System.out.println("Enter The a and b value in (ax+b)mod n:");
	int g=k.nextInt();
	int h=k.nextInt();
	int b=26;
	try
	        {
		String ciphertext="";
		for(int i=0;i<a.length();i++){
			int n = 0;
			char decrpt = 0;
			int m=a.charAt(i);
			if(m>96&&m<123){
				
				n=m-97;
			}
			if(m>64&&m<91){
				
				n=m-65;
			}
			int mod=mod((g*n)+h,b);
			if(m>96&&m<123){
				decrpt=(char)(mod+97);
				ciphertext+=decrpt;
			}
			if(m>64&&m<91){
				decrpt=(char)(mod+65);
				ciphertext+=decrpt;
			}
	        }
		System.out.println("cipher text is "+ciphertext);
	}catch(ArithmeticException e)
	        {
	System.out.println(e);
	
	        }
	break;
	        }
	case 2:
	            {
	System.out.println("Enter The cipher text:");
	        String a = k.next();
	System.out.println("Enter The a and b value in a^-1(y-b)mod n:");
	int g=k.nextInt();
	int h=k.nextInt();
	int b=26;
	try
	        {
		String plaintext="";
		for(int i=0;i<a.length();i++){
			int n = 0;
			char decrpt = 0;
			int m=a.charAt(i);
			if(m>96&&m<123){
				
				n=m-97;
			}
if(m>64&&m<91){			
				n=m-65;
			}		
int x=0;
int inv = 0;
for(int j=0;j<26;j++){
	x=(g*j)%b;
	if(x==1){
		inv=j;
	}
}
int mod=mod((inv)*(n-h),b);
			if(m>96&&m<123){
				decrpt=(char)(mod+97);
				plaintext+=decrpt;
			}
			if(m>64&&m<91){
				decrpt=(char)(mod+65);
				plaintext+=decrpt;
			}
		}
		System.out.println("plain text is "+plaintext);
	}catch(ArithmeticException e)
	        {
	System.out.println(e);	
	        }
	break;
	        }
	case 3:
	            {
		System.out.println("Enter The plain text:");
		        String pt = k.next();
		System.out.println("Enter The cipher text:");
		        String ct = k.next();
		int i=0;
				int n = 0;
				int y=0;
				char decrpt = 0;
				int m=pt.charAt(i);
				int x=ct.charAt(i);
				if(m>96&&m<123){				
					n=m-97;
					y=x-97;
				}
	if(m>64&&m<91){			
					n=m-65;
					y=x-65;
				}
			int a=n;
			int b=y;
			m=pt.charAt(i+1);
			x=ct.charAt(i+1);
			if(m>96&&m<123){				
				n=m-97;
				y=x-97;
			}
if(m>64&&m<91){
				
				n=m-65;
				y=x-65;
			}
int a1=n;
int b1=y;
int A=0;
if(a>a1)
	A=mod(a-a1,26);
else
	A=mod(a1-a,26);
int B=mod(b-(a*A),26);
System.out.println("Key values are "+A+" "+B);
	            }
	        }
		}
		int numEqui(int x){
			int num;
			return x;
			
		}
		static int mod(int a, int n){
			int mod=0;
			if(a>=0){			//To find mod for positive integer
				mod=a%n;
					}
			else{				//To find mod for negative integer
				mod=(n+(a%n))%n;
					}
			return mod;	
		}
}
