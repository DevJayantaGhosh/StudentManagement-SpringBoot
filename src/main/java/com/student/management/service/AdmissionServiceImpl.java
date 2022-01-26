package com.student.management.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.student.management.dto.AdmissionDto;
import com.student.management.dto.IdDto;
import com.student.management.entity.Admission;
import com.student.management.entity.Student;
import com.student.management.exception.ServiceException;
import com.student.management.repository.AdmissionRepository;
import com.student.management.repository.StudentRepository;

@Service
public class AdmissionServiceImpl implements AdmissionService{

	
	@Autowired
	private AdmissionRepository admissionRepository;
	
	@Autowired
	private StudentRepository StudentRepository;
	
	@Override
	public int admit(AdmissionDto admission) {
		try {
			if (!admissionRepository.isReferenceNoPresent(admission.getReferenceNo())) {
				Admission saveAdmission = new Admission();
				saveAdmission.setAcademicYear(admission.getAcademicYear());
				saveAdmission.setAmountPaid(admission.getAmountPaid());
				saveAdmission.setBag(admission.getBag());
				saveAdmission.setBatch(admission.getBatch());
				saveAdmission.setClasss(admission.getClasss());
				saveAdmission.setDate(LocalDate.now());
				saveAdmission.setIdCard(admission.getIdCard());
				saveAdmission.setInstallments(admission.getInstallments());
				saveAdmission.setModule(admission.getModule());
				saveAdmission.setStudent(StudentRepository.fetchById(Student.class , admission.getReferenceNo()));
				saveAdmission.setScholarship(admission.getScholarship());
				Admission updatedAdmission = admissionRepository.save(saveAdmission);
				return updatedAdmission.getRollNo();

			} else {
				throw new ServiceException("Student already admitted");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Student already admitted");
		}catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Student reference number is invalid ");
		}
		
	}

	@Override
	public int update(AdmissionDto admission) {
		try {
			//System.out.println(admission.getRollNo());
			if (admissionRepository.isRollNoPresent(admission.getRollNo())) {
				Admission saveAdmission = admissionRepository.fetchById(Admission.class, admission.getRollNo());
				saveAdmission.setAcademicYear(admission.getAcademicYear());
				saveAdmission.setAmountPaid(admission.getAmountPaid());
				saveAdmission.setBag(admission.getBag());
				saveAdmission.setBatch(admission.getBatch());
				saveAdmission.setClasss(admission.getClasss());
				saveAdmission.setDate(admission.getDate());
				saveAdmission.setIdCard(admission.getIdCard());
				saveAdmission.setInstallments(admission.getInstallments());
				saveAdmission.setModule(admission.getModule());
				saveAdmission.setStudent(StudentRepository.fetchById(Student.class , admission.getReferenceNo()));
				saveAdmission.setScholarship(admission.getScholarship());
				Admission updatedAdmission = admissionRepository.save(saveAdmission);
				return updatedAdmission.getRollNo();

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		}catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Student roll/reference number is invalid ");
		}
	}

	@Override
	public void deleteAdmission(int rollNo) {
		try {
			if (admissionRepository.isRollNoPresent(rollNo)) {
				admissionRepository.deleteAdmission(admissionRepository.fetchById(Admission.class, rollNo));

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		}
		
	}
	
	@Override
	public AdmissionDto getAdmission(int rollNo) {
		try {
			if (admissionRepository.isRollNoPresent(rollNo)) {
				Admission admission = admissionRepository.fetchById(Admission.class, rollNo);
				AdmissionDto saveAdmission = new AdmissionDto();
				saveAdmission.setAcademicYear(admission.getAcademicYear());
				saveAdmission.setAmountPaid(admission.getAmountPaid());
				saveAdmission.setBag(admission.getBag());
				saveAdmission.setBatch(admission.getBatch());
				saveAdmission.setClasss(admission.getClasss());
				saveAdmission.setDate(admission.getDate());
				saveAdmission.setIdCard(admission.getIdCard());
				saveAdmission.setInstallments(admission.getInstallments());
				saveAdmission.setModule(admission.getModule());
				saveAdmission.setRollNo(admission.getRollNo());
				saveAdmission.setName(admission.getStudent().getName());
				saveAdmission.setScholarship(admission.getScholarship());
				saveAdmission.setReferenceNo(admission.getStudent().getReferenceNo());
				return saveAdmission;

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		}
		
	}
	
	@Override
	public Student getStudent(int rollNo) {
		try {
			if (admissionRepository.isRollNoPresent(rollNo)) {
				Admission admission = admissionRepository.fetchById(Admission.class, rollNo);
				Student student = admission.getStudent();
				return student;

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		}
		
	}
	
	@Override
	public IdDto idCard(int rollNo) {
		try {
			if (admissionRepository.isRollNoPresent(rollNo)) {
				Admission admission = admissionRepository.fetchById(Admission.class, rollNo);
				Student student = admission.getStudent();
				IdDto id = new IdDto();
				id.setRollNo(rollNo);
				id.setAcademicYear(admission.getAcademicYear());
				id.setAddress(student.getPermanentAddress());
				id.setBatch(admission.getBatch());
				id.setClasss(admission.getClasss());
				id.setFatherName(student.getFatherName());
				id.setMobileNo(student.getMobileNoStudent());
				id.setName(student.getName());
				id.setPicture(student.getPicture());
				return id;

			} else {
				throw new ServiceException("Invalid Roll Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Roll Number");
		}
		
	}
	
	@Override
	public long classCount(String classs) {
		try {
			return admissionRepository.classCount(classs);
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Class");
		}
	}
	
	
	

}
