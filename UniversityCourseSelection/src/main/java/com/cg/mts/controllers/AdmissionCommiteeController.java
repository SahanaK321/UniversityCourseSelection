package com.cg.mts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.Applicant;
import com.cg.mts.service.AdmissionCommiteeServiceImpl;

@RestController
public class AdmissionCommiteeController {

	@Autowired
	private AdmissionCommiteeServiceImpl admissioncommiteeservice;

	
	@RequestMapping("/admissioncommitees")
	public List<AdmissionCommiteeMember> viewAllCommiteeMembers() {
		return admissioncommiteeservice.viewAllCommiteeMembers();
	}
	
	@RequestMapping("/admissioncommitees/{adminId}")
	public ResponseEntity<AdmissionCommiteeMember> viewCommiteeMember(@PathVariable Integer adminId)
	{
		AdmissionCommiteeMember member = admissioncommiteeservice.viewCommiteeMember(adminId);
		return new ResponseEntity<AdmissionCommiteeMember>(member,HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admissioncommitees")
	public ResponseEntity<Object> addCommiteeMember(@RequestBody AdmissionCommiteeMember member) {
		admissioncommiteeservice.addCommiteeMember(member);
		return new ResponseEntity<Object>("AdmissionCommiteeMember Added Successfully",HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/admissioncommitees/{adminId}")
	public ResponseEntity<Object> updateCommiteeMember(@RequestBody AdmissionCommiteeMember member, @PathVariable int adminId) {
		admissioncommiteeservice.updateCommiteeMember(member);
		return new ResponseEntity<Object>("AdmissionCommiteeMember Updated Successfully",HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/admissioncommitees/{adminId}")
	public ResponseEntity<Object> removeCommiteeMember(@PathVariable int adminId) {
		admissioncommiteeservice.removeCommiteeMember(adminId);
		return new ResponseEntity<Object>("AdmissionCommiteeMember Deleted Successfully",HttpStatus.ACCEPTED);
	}
	
	@RequestMapping("/admissioncommitees/result")
	public void provideAdmissionResult(@RequestBody Applicant applciant,@RequestBody Admission admission)
	{
		admissioncommiteeservice.provideAdmissionResult(applciant, admission);
	}

}