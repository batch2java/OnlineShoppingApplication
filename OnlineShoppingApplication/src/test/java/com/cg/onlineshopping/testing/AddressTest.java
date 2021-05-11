package com.cg.onlineshopping.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.repository.IAddressRepository;
import com.cg.onlineshopping.service.IAdressServiceimpl;
@SpringBootTest
class AddressTest {

	 @InjectMocks
	    IAdressServiceimpl addressServiceimpl;
	    
	    @Mock
	    IAddressRepository addressRepo;
	    
	    @Test
	    public void testAddAddress()
	    {
	        Address add = new Address();
	        add.setStreetNo("131D");
	        add.setBuildingName("KrupaComplex");
	        add.setCity("Hyderabad");
	        add.setState("Telangana");
	        add.setCountry("INDIA");
	        add.setPincode("500042");

	 

	        Mockito.when(addressRepo.save(add)).thenReturn(add);
	        assertThat(addressServiceimpl.addAddress(add)).isEqualTo(add);
	    }
	    
	    
	    
	    @Test
	    public void testUpdateAddress()
	    {
	        Address add = new Address();
	        add.setStreetNo("131D");
	        add.setBuildingName("KrupaComplex");
	        add.setCity("Hyderabad");
	        add.setState("Telangana");
	        add.setCountry("INDIA");
	        add.setPincode("500042");
	        
	        
	        Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
	        
	        add.setCity("Kolkata");
	        Mockito.when(addressRepo.save(add)).thenReturn(add);
	        assertThat(addressServiceimpl.updateAddress(add)).isEqualTo(add);
	        
	    }
	    
	    
	    
	    @Test
	    public void testRemoveAddress()
	    {
	        Address add = new Address();
	        //add.setAddressId(101);
	        add.setStreetNo("131D");
	        add.setBuildingName("KrupaComplex");
	        add.setCity("Hyderabad");
	        add.setState("Telangana");
	        add.setCountry("INDIA");
	        add.setPincode("500042");
	        
	        Mockito.when(addressRepo.findById(add.getAddressId())).thenReturn(Optional.of(add));
	        Mockito.when(addressRepo.existsById(add.getAddressId())).thenReturn(false);
	        assertFalse(addressRepo.existsById(add.getAddressId()));
	    }
	    
	    

	 

	    @Test
	    public void viewAddressById()
	    {
	        Address add = new Address();
	        add.setAddressId(101);
	        add.setStreetNo("131D");
	        add.setBuildingName("KrupaComplex");
	        add.setCity("Hyderabad");
	        add.setState("Telangana");
	        add.setCountry("INDIA");
	        add.setPincode("500042");
	        
	        Mockito.when(addressRepo.findById(101)).thenReturn(Optional.of(add));
	        assertThat(addressServiceimpl.viewAddress(add.getAddressId())).isEqualTo(add);
	    }
	    
	    
	    @Test
	    public void viewAllAddress()
	    {
	        Address add1 = new Address();
	        add1.setStreetNo("131D");
	        add1.setBuildingName("KrupaComplex");
	        add1.setCity("Hyderabad");
	        add1.setState("Telangana");
	        add1.setCountry("INDIA");
	        add1.setPincode("500042");
	        
	        Address add2 = new Address();
	        add2.setStreetNo("123A");
	        add2.setBuildingName("KComplex");
	        add2.setCity("Bangalore");
	        add2.setState("Karnataka");
	        add2.setCountry("INDIA");
	        add2.setPincode("500052");
	        
	        
	        List<Address> aList = new ArrayList<>();
	        aList.add(add1); aList.add(add2);
	        
	        Mockito.when(addressRepo.findAll()).thenReturn(aList);
	        
	        assertThat(addressServiceimpl.viewAllAddress()).isEqualTo(aList);
	    }
	    
	}
	 
