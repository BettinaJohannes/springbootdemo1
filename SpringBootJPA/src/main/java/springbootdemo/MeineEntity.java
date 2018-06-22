package springbootdemo;

import java.util.Date;
import javax.persistence.*;

@Entity
public class MeineEntity
{
   @Id @GeneratedValue
   private Long   id;
   private Date   datum;
   private String text;

   public Long   getId()    { 
		return id;   
		}
   public Date   getDatum() { 
		return datum; 
		}
   public String getText()  { 
		return text;  
		}
   public void setId(    Long id     ) {
		this.id    = id;  
		}
   public void setDatum( Date datum  ) { 
		this.datum = datum; 
		}
   public void setText(  String text ) {
		this.text  = text; 
		}

   @Override
   public String toString()
   {
      return "[id=" + id + ", datum=" + datum + ", text=" + text + "]";
   }
}