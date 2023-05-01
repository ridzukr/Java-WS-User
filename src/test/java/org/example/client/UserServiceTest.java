package org.example.client;

import org.example.client.generated.Gender;
import org.example.client.generated.UserService;
import org.example.client.generated.UserServiceImplService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserServiceTest {

    static UserServiceImplService service;
    static UserService userService;

    @BeforeAll
    static void setup() {
        service = new UserServiceImplService();
        userService = service.getUserServiceImplPort();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Tom", "Bob", "Kat" })
    void givenUserService_thenNameCorrect(String value) {
        assertEquals(value, userService.findByName(value).getName());
        assertEquals(value, userService.findByName(value).getName());
        assertEquals(value, userService.findByName(value).getName());
    }


    @Test
    public void givenUserService_thenPhoneCorrect() {
        assertEquals("068 325-4455", userService.findByName("Tom").getPhone());
    }

    @Test
    public void givenUserService_thenPhoneIncorrect() {
        assertNotEquals("098 325-4455", userService.findByName("Tom").getPhone());
    }

    @Test
    public void givenUserService_thenAgeCorrect() {
        assertEquals(26, userService.findByName("Tom").getAge());
    }

    @Test
    public void givenUserService_thenAgeIncorrect() {
        assertNotEquals(26, userService.findByName("Kat").getAge());
    }

    @Test
    public void givenUserService_thenGenderCorrect() {
        assertEquals(Gender.MALE, userService.findByName("Tom").getGender());
        assertEquals(Gender.MALE, userService.findByName("Bob").getGender());
        assertEquals(Gender.FEMALE, userService.findByName("Kat").getGender());
    }

    @Test
    public void givenUserService_thenGenderIncorrect() {
        assertNotEquals(Gender.FEMALE, userService.findByName("Bob").getGender());
        assertNotEquals(Gender.MALE, userService.findByName("Kat").getGender());
    }

}
