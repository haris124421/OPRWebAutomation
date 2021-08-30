package SiteAdministration;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDateTime;    
public class UpdateTime { 
	
  public static void main(String[] args)
  {    
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
   LocalDateTime now = LocalDateTime.now().plusDays(1);  
   String NewDate= (dtf.format(now));
   System.out.println(NewDate); 
  }
}
  


   