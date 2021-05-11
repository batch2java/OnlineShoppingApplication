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
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.pojo.InputCustomer;
import com.cg.onlineshopping.repository.ICustomerRepository;

@SpringBootTest
class ICustomerServiceImplTest {

 

    @InjectMocks
    ICustomerServiceImpl customerServiceimpl;
    
    @Mock
    ICustomerRepository customerRepo;
    
    
    @Test
    public void addCustomerMockTest()
    {
        Customer cust1 = new Customer();
        cust1.setFirstName("Pampari");
        cust1.setLastName("Narender");
        cust1.setMobileNumber("5878455448");
        cust1.setEmail("abc@g.com");
        
        Address add = new Address();
        add.setAddressId(101);
        cust1.setAddress(add);
        
        InputCustomer ic = new InputCustomer();
        ic.setCustomerId(cust1.getCustomerId());
        
        
        Mockito.when(customerRepo.save(cust1)).thenReturn(cust1);
        assertThat(customerServiceimpl.addCustomer(ic)).isEqualTo(cust1);
    }
    
    @Test
    public void deleteCustomerMockTest()
    {
        Customer cust = new Customer();
        cust.setCustomerId(101);
        cust.setFirstName("Pampari");
        cust.setLastName("Narender");
        cust.setMobileNumber("5878455448");
        cust.setEmail("abc@g.com");
        Address add = new Address();
        add.setAddressId(101);
        cust.setAddress(add);
        
        Mockito.when(customerRepo.findById(cust.getCustomerId())).thenReturn(Optional.of(cust));
        Mockito.when(customerRepo.existsById(cust.getCustomerId())).thenReturn(false);
        assertFalse(customerRepo.existsById(cust.getCustomerId()));
    }
    
    @Test
    public void updateCustomerMockTest()
    {
        Customer cust = new Customer();
        cust.setFirstName("Pampari");
        cust.setLastName("Narender");
        cust.setMobileNumber("5878455448");
        cust.setEmail("abc@g.com");
        Address add = new Address();
        add.setAddressId(101);
        cust.setAddress(add);
        
        
        Mockito.when(customerRepo.findById(cust.getCustomerId())).thenReturn(Optional.of(cust));
        cust.setEmail("martin.s2000@gmail.com");
        Mockito.when(customerRepo.save(cust)).thenReturn(cust);
        assertThat(customerServiceimpl.updateCustomer(cust)).isEqualTo(cust);
        
    }
    
    @Test
    public void viewAllCustomersMockTest()
    {
        Customer cust1 = new Customer();
        cust1.setFirstName("xyz");
        cust1.setLastName("Narender");
        cust1.setMobileNumber("5878455448");
        cust1.setEmail("abc@g.com");
        Address add1 = new Address();
        add1.setAddressId(101);
        cust1.setAddress(add1);
        cust1.getAddress().setCity("chennai");
        
        Customer cust2 = new Customer();
        cust2.setFirstName("abc");
        cust2.setLastName("Narender");
        cust2.setMobileNumber("5878455448");
        cust2.setEmail("abc@g.com");
        Address add2 = new Address();
        add2.setAddressId(101);
        cust2.setAddress(add2);
        cust2.getAddress().setCity("Banglore");
        
        Customer cust3 = new Customer();
        cust3.setFirstName("pqr");
        cust3.setLastName("Narender");
        cust3.setMobileNumber("5878455448");
        cust3.setEmail("abc@g.com");
        Address add3 = new Address();
        add3.setAddressId(101);
        cust3.setAddress(add3);
        cust3.getAddress().setCity("Hyd");
        
        List<Customer> customer = new ArrayList<>();
        customer.add(cust1); customer.add(cust2); customer.add(cust3);
        
        Mockito.when(customerRepo.viewAllCustomer("mumbai")).thenReturn(customer);
        assertThat(customerServiceimpl.viewAllCustomers("mumbai")).isEqualTo(customer);
    }
    
    @Test
    public void viewCustomerMockTest()
    {
        Customer cust = new Customer();
        cust.setFirstName("xyz");
        cust.setLastName("Narender");
        cust.setMobileNumber("5878455448");
        cust.setEmail("abc@g.com");
        Address add = new Address();
        add.setAddressId(101);
        cust.setAddress(add);
        
        Customer cust1 = new Customer();
        cust1.setFirstName("pqr");
        cust1.setLastName("Narender");
        cust1.setMobileNumber("5878455448");
        cust1.setEmail("abc@g.com");
        Address add1 = new Address();
        add1.setAddressId(102);
        cust1.setAddress(add1);
        
        Mockito.when(customerRepo.findById(cust.getCustomerId())).thenReturn(Optional.of(cust));
        assertThat(customerServiceimpl.viewCustomer(cust)).isEqualTo(cust);    
    }
    
    
}
 