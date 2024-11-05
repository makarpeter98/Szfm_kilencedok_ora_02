/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockito_test;

import com.mycompany.l6_mockito.Person;
import com.mycompany.l6_mockito.PersonDataReader;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author admin
 */
public class PersonTest {

    @Mock
    private PersonDataReader pdr;
    private Person underTest1, underTest2;

    @BeforeAll //@BeforeClass
    public static void setUpClass() {
    }

    @AfterAll //@AfterClass
    public static void tearDownClass() {
    }

    @BeforeEach //@Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        //PersonDataReader pdr = mock(PersonDataReader.class);
        given(pdr.getID()).willReturn(4, 6);
        given(pdr.getName()).willReturn("Teszt Elek", "Elektrom Ágnes");
        given(pdr.getAge()).willReturn(20, 40);

        underTest1 = Person.scannedPerson(pdr);
        underTest2 = Person.scannedPerson(pdr);
        verify(pdr, times(2)).getID();
        verify(pdr, times(2)).getName();
        verify(pdr, times(2)).getAge();

    }

    @AfterEach //@After
    public void tearDown() {
    }

    @Test
    public void scannedPersonTest() {
        PersonDataReader pdr = mock(PersonDataReader.class);

        Person pExpected = new Person(4, "Teszt Elek",20);
        assertEquals(pExpected, underTest1);

        pExpected = new Person(6, "Elektrom Ágnes", 40);
        assertEquals(pExpected, underTest2);
    }

    @Test
    public void PersonConstructorShouldThrownExceptionForWrongID() {
        Assertions.assertThrows(Exception.class, () -> {
            new Person(-10, "Adam", 20);
        });
    }

    @Test
    public void toStringShouldReurnString()
    {
        String expected = "Person{id=" + 4 + ", name=" + "'Teszt Elek', age=" + 20 + "}";
        Assertions.assertEquals(expected, underTest1.toString());
    }

    @Test
    void test_this() throws  InterruptedException
    {
        Assertions.assertTimeout(Duration.ofMillis(5000), ()-> Thread.sleep(1000));
    }

    @ParameterizedTest
    @ValueSource(chars = {'T', 'e', 's', 'z', 't'})
    void containsCharShouldReturnTrueforContainedChars(char input)
    {
        assertTrue(underTest1.nameContainsChar(input), "char: "+input);
    }

}
