package sut.Sprint2.Test.Sprint2Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import sut.Sprint2.Test.Sprint2Test.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class Sprint2TestApplicationTests {

	@Autowired private FoodpropertiesRepository fprop;

	@Autowired
    private TestEntityManager entityManager;
    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}

	@Test
	public void foodpropNull() {

			Foodproperties coolfood = new Foodproperties();
			coolfood.setFoodproperties(null);	
		try {
            entityManager.persist(coolfood);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

	@Test
	public void foodpropTooShort() {

			Foodproperties coolfood = new Foodproperties();
			coolfood.setFoodproperties("F");	
		try {
            entityManager.persist(coolfood);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

	@Test
	public void foodpropTooLong() {
		String prop ="";
		for(int i = 0 ; i< 51 ; i++  ) prop+="FFFFF";

			Foodproperties coolfood = new Foodproperties();
			coolfood.setFoodproperties(prop);	
		try {
            entityManager.persist(coolfood);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

	@Test
	public void foodpropNotPertern() {
		
			Foodproperties coolfood = new Foodproperties();
			coolfood.setFoodproperties("สุดยอดครับลุงโทนี่");	
		try {
            entityManager.persist(coolfood);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
	}

	@Test
	public void foodpropNoTunique() {
		
			Foodproperties coolfood = new Foodproperties();
			coolfood.setFoodproperties("สุดยอดครับ");	
			Foodproperties coolfood1 = new Foodproperties();
			coolfood.setFoodproperties("สุดยอดครับ");	


		try {
            entityManager.persist(coolfood);
			entityManager.flush();
			entityManager.persist(coolfood1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
		}
		


	}

	@Test
	public void foodpropCorrect() {
		
			Foodproperties coolfood = new Foodproperties();
			coolfood.setFoodproperties("สุดยอดครับ");	

		try {
            entityManager.persist(coolfood);
			entityManager.flush();
	
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
		}
		

		
	}










}

