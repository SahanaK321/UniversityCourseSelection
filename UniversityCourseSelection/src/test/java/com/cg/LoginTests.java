package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.repository.ILoginRepository;
import com.cg.mts.repository.IUniversityStaffRepository;
import com.cg.mts.service.ILoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTests {
	
	@Autowired
	private ILoginService service;
	
	@MockBean
	private ILoginRepository repo;
	
	@MockBean
	private IUniversityStaffRepository staffRepo;
	
	@Test
	public void testLoginAsAdmissionCommiteeMember() {
		Mockito.when(staffRepo.findBystaffId(1))
		.thenReturn(new UniversityStaffMember(1, "laka", "commitee member"));
		
		assertEquals(true,service.loginAsAdmissionCommiteeMember(String.valueOf(1),"laka"));
	}
	
	@Test
	public void testLoginAsUniversityStaffMember() {
		Mockito.when(staffRepo.findBystaffId(1))
		.thenReturn(new UniversityStaffMember(1, "laka", "staff member"));
		
		assertEquals(true,service.loginAsUniversityStaffMember(String.valueOf(1),"laka"));
	}
	
	
	

}
