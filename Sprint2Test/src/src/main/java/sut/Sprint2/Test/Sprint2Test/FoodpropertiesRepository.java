package sut.Sprint2.Test.Sprint2Test;

import sut.Sprint2.Test.Sprint2Test.Foodproperties;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface FoodpropertiesRepository extends JpaRepository<Foodproperties, Long> {

}