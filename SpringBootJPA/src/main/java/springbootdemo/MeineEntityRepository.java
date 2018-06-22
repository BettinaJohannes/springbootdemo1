package springbootdemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeineEntityRepository extends CrudRepository<MeineEntity,Long>
{
   public MeineEntity findByText( String text );
}