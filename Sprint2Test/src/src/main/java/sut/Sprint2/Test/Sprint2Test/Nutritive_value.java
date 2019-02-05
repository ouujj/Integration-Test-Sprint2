package sut.Sprint2.Test.Sprint2Test;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



@Entity
@Data
public class Nutritive_value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Nvalueid;

    @NotNull()@Min(0)@Max(2000)private float energy;

    @NotNull()@Min(0)@Max(70)private float sugar;

    @NotNull()@Min(0)@Max(90)private float fat;

    @NotNull()@Min(0)@Max(3000)private float sodium;

    @NotNull()@Min(0)@Max(20)private float saturates;

    @NotNull()@Min(1)@Max(500)private float amount;


}