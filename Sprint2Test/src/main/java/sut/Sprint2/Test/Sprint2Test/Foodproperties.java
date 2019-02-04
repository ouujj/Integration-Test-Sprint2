package sut.Sprint2.Test.Sprint2Test;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Data
public class Foodproperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private
    @NotNull(message = "กรุณากรอกชื่อและนามสกุล")
    @Size(min=2,max=250)
    @Pattern(regexp = "^((?!(ลุงโทนี่|SamuelJackson)).)*$",message = "กรุณาใช้คำที่สุภาพ")
    @Column(unique = true)
    String foodproperties;

}