package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.management.dto.Status.StatusCode;
import com.student.management.dto.MultipartImage;
import com.student.management.dto.RegistrationStatus;
import com.student.management.dto.StudentDto;
import com.student.management.dto.StudentRegister;
import com.student.management.dto.StudentsCount;
import com.student.management.dto.StudentsListDto;
import com.student.management.exception.ServiceException;
import com.student.management.service.SmsService;
import com.student.management.service.StudentService;
import com.student.management.entity.Sms;
import com.student.management.entity.Student;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@Autowired
	private SmsService smsService;
	
	@PostMapping(path="/register")
	public @ResponseBody RegistrationStatus register(@RequestBody StudentRegister student) {
		try {
			int referenceNo = studentService.register(student);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Registration Successful");
			status.setReferenceNo(referenceNo);
			return status;
		} catch(ServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Registration Failed");
			return status;
		}
	}
	
	@PostMapping(path="/update-student")
	public @ResponseBody RegistrationStatus update(@RequestBody Student studentr) {
		try {
			int referenceNo = studentService.update(studentr);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Update Successful");
			status.setReferenceNo(referenceNo);
			return status;
		} catch(ServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
	@PostMapping(path="/update-student-pic")
	public @ResponseBody RegistrationStatus updatePic(@RequestParam("referenceNo") String referenceNo, @RequestParam("image") MultipartFile image) {
		try {
			int referenceNoo =  Integer.parseInt(referenceNo);
			int referenceeNo = studentService.updatePic(referenceNoo,image);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Update Successful");
			status.setReferenceNo(referenceeNo);
			return status;
		} catch(ServiceException e) {
			RegistrationStatus status = new RegistrationStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
	@GetMapping(path = "/student-list")
	public StudentsListDto getStudents() {
		try {
			List<Student> students = studentService.getStudentsService();
			StudentsListDto studentsListDto = new StudentsListDto();
			studentsListDto.setStatusCode(StatusCode.SUCCESS);
			studentsListDto.setStatusMessage("Students list fetched successfully");
			studentsListDto.setStudentList(students);
			return studentsListDto;
			
		} catch(ServiceException e) {
			StudentsListDto studentsListDto = new StudentsListDto();
			studentsListDto.setStatusCode(StatusCode.FAILURE);
			studentsListDto.setStatusMessage("Students list fetch FAILED");
			return studentsListDto;
		}
	}
	
	@GetMapping(path = "/get-student")
	public StudentDto getStudent(@RequestParam("referenceNo") int referenceNo) {
		try {
			Student student = studentService.fetchStudent(referenceNo);
			StudentDto studentDto = new StudentDto();
			studentDto.setStudent(student);
			//studentDto.setImage(image);
			studentDto.setStatusCode(StatusCode.SUCCESS);
			studentDto.setStatusMessage("Student Fetched Successfully");
			return studentDto;
			
		} catch(ServiceException e) {
			StudentDto studentDto = new StudentDto();
			studentDto.setStatusCode(StatusCode.FAILURE);
			studentDto.setStatusMessage("Students fetch FAILED");
			return studentDto;
		}
	}
	
	
	@GetMapping(path = "/student-count")
	public StudentsCount allStudents() {
		try {
			StudentsCount students = new StudentsCount();
			students.setStatusCode(StatusCode.SUCCESS);
			students.setStatusMessage("Students count fetched successfully");
			students.setStudentsCount(studentService.studentsCount());
			return students;
			
		} catch(ServiceException e) {
			StudentsCount students = new StudentsCount();
			students.setStatusCode(StatusCode.FAILURE);
			students.setStatusMessage("Students count fetch FAILED");
			return students;
		}
	}
	
	/*@PostMapping(path = "/sms")
	public void smsSend(@RequestBody Sms sms) {
		try {
			smsService.send(sms);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}*/

}
