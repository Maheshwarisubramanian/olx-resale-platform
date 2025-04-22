//package com.olx.resale.app.entity;
//
//import com.olx.resale.app.entity.enums.Role;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Slf4j
//public class UserTest {
//
//    private User user;
//
//    @BeforeEach
//    public void setUp() {
//        user = new User();
//        user.setId(1L);
//        user.setName("Ajay");
//        user.setEmail("ajay@gmail.com");
//        user.setMobileNumber("8989898989");
//        user.setPassword("Ajay1234");
//        user.setConfirmPassword("Ajay1234");
//        Set<Role> roles = new HashSet<>();
//        roles.add(Role.BUYER);
//        roles.add(Role.SELLER);
//        user.setRoles(roles);
//        user.setCity("Bengaluru");
//        user.setState("Karnataka");
//        user.setCountry("India");
//        user.setPincode("560029");
//    }
//
//    @Test
//    public void testUserEntity(){
//        log.info("Testing getId()");
//        Assertions.assertEquals(1L, user.getId());
//        Assertions.assertEquals("Ajay", user.getName());
//        Assertions.assertEquals("ajay@gmail.com", user.getEmail());
//        log.info("Testing getMobileNumber()");
//        Assertions.assertEquals("8989898989", user.getMobileNumber());
//        Assertions.assertEquals("Ajay1234", user.getPassword());
//        Assertions.assertEquals("Ajay1234", user.getConfirmPassword());
//        Assertions.assertTrue(user.getRoles().contains(Role.BUYER));
//        Assertions.assertTrue(user.getRoles().contains(Role.SELLER));
//        Assertions.assertEquals("Bengaluru", user.getCity());
//        Assertions.assertEquals("Karnataka", user.getState());
//        log.info("Testing getCountry()");
//        Assertions.assertEquals("India", user.getCountry());
//        Assertions.assertEquals("560029", user.getPincode());
//        log.info("User Attributes Test Completed.");
//    }
//}
