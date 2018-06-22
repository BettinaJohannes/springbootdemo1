package springbootdemo;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationMain implements CommandLineRunner
{
   @Autowired
   private MeineEntityRepository repo;

   public static void main( String[] args )
   {
      SpringApplication.run( ApplicationMain.class, args );
   }

   @Override
   public void run( String... args ) throws Exception
   {
      if( args != null && args.length > 1 ) {
         if( "add".equals( args[0] ) ) {
            for( int i = 1; i < args.length; i++ ) {
               MeineEntity me = new MeineEntity();
               me.setText( args[i] );
               me.setDatum( new Date() );
               me = repo.save( me );
               System.out.println( "---- " + me + " gespeichert." );
            }
            return;
         } else if( "get".equals( args[0] ) ) {
            System.out.println( "---- " + repo.findByText( args[1] ) );
            return;
         } else {
            System.out.println( "Fehlerhafter Parameter." );
         }
      }
      System.out.println( "---- Alle Eintraege:" );
      Iterable<MeineEntity> itr = repo.findAll();
      for( MeineEntity me : itr ) {
         System.out.println( "     " + me );
      }
   }
}