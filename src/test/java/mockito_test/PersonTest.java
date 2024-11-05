package mockito_test;

import com.mycompany.l6_mockito.Person;
import com.mycompany.l6_mockito.PersonDataReader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;

public class PersonTest {

    @Mock
    private PersonDataReader pdr;
    private Person testPerson01, getTestPerson02;

    @BeforeAll
    public static void setUpClass()
    {
        System.out.println("Before all!");
    }

    @AfterAll
    public static void tearDownClass()
    {
        System.out.println("After all!");
    }

    @BeforeEach
    public void setUp()
    {
        System.out.println("Before each!");
        MockitoAnnotations.openMocks(this);
        given(pdr.getID()).willReturn(4,6);
        given(pdr.getName()).willReturn("Teszt Elek", "Elektrom Ágnes");
        given(pdr.getAge()).willReturn(20,40);
    }

    @AfterEach
    public void tearDown()
    {
        System.out.println("After Each!");
    }

}
