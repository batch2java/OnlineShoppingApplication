package com.cg.onlineshopping.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.service.IAddressService;
import com.cg.onlineshopping.service.impl.IAdressServiceImpl;

@SpringBootTest
class IAddressServiceImplTest {

 

     @InjectMocks
     IAdressServiceImpl addressServiceImpl;
     
     @Mock
     IAddressRepository addressRepo;
    
        
     @Autowired
     IAddressService service;
     
      
        //Mock Test
        
        
        @Test
        public void addAddressMockTest()
        {
            Address add = new Address();
            add.setStreetNo("131D");
            add.setBuildingName("KrupaComplex");
            add.setCity("Hyderabad");
            add.setState("Telangana");
            add.setCountry("INDIA");
            add.setPincode("500042");
            Customer cust = new Customer();
            cust.setCustomerId(101);
            add.setCustomer(cust);
            
            Mockito.when(addressRepo.save(add)).thenReturn(add);
            assertThat(addressServiceImpl.addAddress(add)).isEqualTo(add);
           
        }
        
        @Test
        public void updateAddressMockTest()
        {
            Address add = new Address();
            add.setStreetNo("131D");
            add.setBuildingName("KrupaComplex");
            add.setCity("Hyderabad");
            add.setState("Telangana");
            add.setCountry("INDIA");
            add.setPincode("500042");
            Customer cust = new Customer();
            cust.setCustomerId(101);
            add.setCustomer(cust);
            
            
            Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
            
            add.setCity("Kolkata");
            Mockito.when(addressRepo.save(add)).thenReturn(add);
            assertThat(addressServiceImpl.updateAddress(add)).isEqualTo(add);
            
        }
        
        
        
        @Test
        public void removeAddressMockTest()
        {
            Address add = new Address();
            //add.setAddressId(101);
            add.setStreetNo("131D");
            add.setBuildingName("KrupaComplex");
            add.setCity("Hyderabad");
            add.setState("Telangana");
            add.setCountry("INDIA");
            add.setPincode("500042");
            Customer cust = new Customer();
            cust.setCustomerId(101);
            add.setCustomer(cust);
            
            Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
            Mockito.when(addressRepo.existsById(add.getAddressId())).thenReturn(false);
            assertFalse(addressRepo.existsById(add.getAddressId()));
        }
        
        

 

     

 

        @Test
        public void viewAddressByIdMockTest()
        {
            Address add = new Address();
            add.setAddressId(101);
            add.setStreetNo("131D");
            add.setBuildingName("KrupaComplex");
            add.setCity("Hyderabad");
            add.setState("Telangana");
            add.setCountry("INDIA");
            add.setPincode("500042");
            Customer cust = new Customer();
            cust.setCustomerId(101);
            add.setCustomer(cust);
            
            Mockito.when(addressRepo.findById(101)).thenReturn(Optional.of(add));
            assertThat(addressServiceImpl.viewAddress(add.getAddressId())).isEqualTo(add);
        }
        
        
        @Test
        public void viewAllAddressMockTest()
        {
            Address add1 = new Address();
            add1.setStreetNo("131D");
            add1.setBuildingName("KrupaComplex");
            add1.setCity("Hyderabad");
            add1.setState("Telangana");
            add1.setCountry("INDIA");
            add1.setPincode("500042");
            Customer cust1 = new Customer();
            cust1.setCustomerId(101);
            add1.setCustomer(cust1);
            
            Address add2 = new Address();
            add2.setStreetNo("123A");
            add2.setBuildingName("KComplex");
            add2.setCity("Bangalore");
            add2.setState("Karnataka");
            add2.setCountry("INDIA");
            add2.setPincode("500052");
            Customer cust2 = new Customer();
            cust2.setCustomerId(102);
            add2.setCustomer(cust2);
            
            
            List<Address> aList = new ArrayList<>();
            aList.add(add1); aList.add(add2);
            
            Mockito.when(addressRepo.findAll()).thenReturn(aList);
            
            assertThat(addressServiceImpl.viewAllAddress()).isEqualTo(aList);
        }
        
        
        //Functionality Level Test
        
        @Test
        public void addAddressUnitTest()
        {
            Address add = new Address();
            add.setStreetNo("131D");
            add.setBuildingName("SrujanaComplex");
            add.setCity("Hyderabad");
            add.setState("Telangana");
            add.setCountry("INDIA");
            add.setPincode("500042");
            Customer cust = new Customer();
            cust.setCustomerId(101);
            add.setCustomer(cust);
            
            Address add1 = new Address();
            add1=service.addAddress(add);
            
            
            assertNotNull(add1,"Address is added");
        }
        
        
        @Test
        public void updateAddressUnitTest()
        {
            Address add = new Address();
           
            
            Address add1 = new Address();
            add1.setAddressId(17);
            add1.setCity(add.getCity());
            add1.setBuildingName("KrupaComplex");
            add1=service.updateAddress(add1);
            
            
            assertNotNull(add1,"Address is Updated");
        }
        
        @Test
        public void removeAddressUnitTest()
        {
            Address add=service.removeAddress(16);
            assertNotNull(add, "Address removed !!");
        }
        
        
        @Test
        public void viewAddressByIdUnitTest()
        {
            Address add = service.viewAddress(8);
            assertNotNull(add,"Address found!");
            assertEquals("SrujanaComplex", add.getBuildingName(),"Building Name matched");
            
            
            
        }
        
        @Test
        public void viewAllAddressUnitTest()
        {
            List<Address> add=service.viewAllAddress();
            assertNotNull(add,"Address List Displayed");
            
        }
}
     
 