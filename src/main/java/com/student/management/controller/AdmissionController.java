package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.dto.AdmissionDto;
import com.student.management.dto.AdmissionDtoStatus;
import com.student.management.dto.AdmissionStatus;
import com.student.management.dto.IdDto;
import com.student.management.dto.Status;
import com.student.management.dto.StudentDto;
import com.student.management.dto.StudentsCount;
import com.student.management.dto.Status.StatusCode;
import com.student.management.entity.Admission;
import com.student.management.entity.Student;
import com.student.management.exception.ServiceException;
import com.student.management.service.AdmissionService;
import com.student.management.service.SmsService;

@RestController
@CrossOrigin
public class AdmissionController {
	
	@Autowired
	private AdmissionService admissionService;
	
	@Autowired
	private SmsService smsService;
	
	@GetMapping(path="/id-card")
	public IdDto idCardGeneration(@RequestParam("rollNo") int rollNo) {
		try {
			IdDto id = admissionService.idCard(rollNo);
			id.setStatusCode(StatusCode.SUCCESS);
			id.setStatusMessage("ID fetch Successful");
			return id;
		} catch(ServiceException e) {
			IdDto id = new IdDto();
			id.setStatusCode(StatusCode.FAILURE);
			id.setStatusMessage(e.getMessage());
			return id;
		}
	}
	
	
	@PostMapping(path="/admission")
	public AdmissionStatus admission(@RequestBody AdmissionDto admission) {
		try {
			int rollNo = admissionService.admit(admission);
			AdmissionStatus status = new AdmissionStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Admission Successful");
			status.setRollNo(rollNo);
			return status;
		} catch(ServiceException e) {
			AdmissionStatus status = new AdmissionStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Admission Failed");
			return status;
		}
	}
	
	@GetMapping(path = "/class-count")
	public StudentsCount allStudents(@RequestParam("classs") String classs) {
		try {
			StudentsCount students = new StudentsCount();
			students.setStatusCode(StatusCode.SUCCESS);
			students.setStatusMessage("Class count fetched successfully");
			students.setStudentsCount(admissionService.classCount(classs));
			return students;
			
		} catch(ServiceException e) {
			StudentsCount students = new StudentsCount();
			students.setStatusCode(StatusCode.FAILURE);
			students.setStatusMessage("Class count fetch FAILED");
			return students;
		}
	}
	
	@PostMapping(path="/update-admission")
	public AdmissionStatus updateAdmission(@RequestBody AdmissionDto admission) {
		try {
			int rollNo = admissionService.update(admission);
			AdmissionStatus status = new AdmissionStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Admission updation Successful");
			status.setRollNo(rollNo);
			return status;
		} catch(ServiceException e) {
			AdmissionStatus status = new AdmissionStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
	@GetMapping(path = "/get-admission")
	public AdmissionDtoStatus getAdmission(@RequestParam("rollNo") int rollNo) {
		try {
			AdmissionDtoStatus admissionDto = new AdmissionDtoStatus();
			admissionDto.setAdmissionDto(admissionService.getAdmission(rollNo));
			admissionDto.setStatusCode(StatusCode.SUCCESS);
			admissionDto.setStatusMessage("Admission Retrieval Successful");
			return admissionDto;
		} catch(ServiceException e) {
			AdmissionDtoStatus admissionDto = new AdmissionDtoStatus();
			admissionDto.setStatusCode(StatusCode.FAILURE);
			admissionDto.setStatusMessage(e.getMessage());
			return admissionDto;
		}
	}
	
	@GetMapping(path = "/delete-admission")
	public Status deleteAdmission(@RequestParam("rollNo") int rollNo) {
		try {
			Status status = new Status();
			admissionService.deleteAdmission(rollNo);
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Deletion Successful");
			return status;
		} catch(ServiceException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	
	@GetMapping(path = "/get-student-with-rollNo")
	public StudentDto getStudent(@RequestParam("rollNo") int rollNo) {
		try {
			Student student = admissionService.getStudent(rollNo);
			StudentDto studentDto = new StudentDto();
			studentDto.setStudent(student);
			studentDto.setStatusCode(StatusCode.SUCCESS);
			studentDto.setStatusMessage("Student Fetched Successfully");
			return studentDto;
			
		} catch(ServiceException e) {
			StudentDto studentDto = new StudentDto();
			studentDto.setStatusCode(StatusCode.FAILURE);
			studentDto.setStatusMessage("Student fetch FAILED");
			return studentDto;
		}
	}
}
