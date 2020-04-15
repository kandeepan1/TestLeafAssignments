package week1.day3;

public class Assignment1 {

	public static void main(String[] args) {
	
		// using  for loop 
         String text = "Welcome";
         String reverse ="";
         
         for(int i = text.length() - 1; i >= 0; i--)
         {
             reverse = reverse + text.charAt(i);
         }
         
        System.out.println("Reversal String:" +reverse);
	}

}

// by Replace method
//String text = "Welcome";
//String replace = text.replace("Welcome", "emocleW");
//System.out.println(replace);
