package sut.Sprint2.Test.Sprint2Test;

import sut.Sprint2.Test.Sprint2Test.Nutritive_value;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface NutritivevalueRepository extends JpaRepository<Nutritive_value, Long> {

   
}