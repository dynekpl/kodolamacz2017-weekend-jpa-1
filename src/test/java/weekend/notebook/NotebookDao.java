package weekend.notebook;

import org.junit.AfterClass;
import org.junit.Test;
import weekend.Notebook;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class NotebookDao {

    Notebook SUT; //System Under Test

    @Test
    public void shouldTestMaximumNotebookNameValidation() {
        // given
        SUT = new Notebook();
        SUT.setModel("Tani super model prosto z Chin");

        // when
        List<String> validationMessagesList = validateNotebookField(SUT, "model");

        // then
        assertThat(validationMessagesList).contains("size must be between 0 and 10");
    }

    @Test
    public void shouldTestNoNotebookNameValidation() {
        // given
        SUT = new Notebook();
        SUT.setModel(null);

        // when
        List<String> validationMessagesList = validateNotebookField(SUT, "model");

        // then
        assertThat(validationMessagesList).contains("may not be null");
    }

    private List<String> validateNotebookField(Notebook notebook, String field) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Notebook>> constraintViolations = validator.validateProperty(notebook, field);

        System.out.println(constraintViolations.size() + " pola nie przeszły walidacji");
        constraintViolations.stream().forEach(cv -> System.out.println("!!! " + cv.getMessage()));

        return constraintViolations
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }
    
    @Test
    public void shouldValidateWarrantyDateTest(){
       // given
       
       // when
       
       // then
       
    }
}
