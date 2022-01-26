package com.student.management.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.student.management.dto.MultipartImage;
import com.student.management.dto.StudentDto;
import com.student.management.dto.StudentRegister;
import com.student.management.entity.Admission;
import com.student.management.entity.Student;
import com.student.management.exception.ServiceException;
import com.student.management.repository.AdmissionRepository;
import com.student.management.repository.StudentRepository;
import java.io.ByteArrayOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private AdmissionRepository admissionRepository;
	@Autowired
	private EmailService emailService;

	@Override
	public byte[] writtingImage(File image) {
	        try {
	        	BufferedImage bImage = ImageIO.read(image);
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            ImageIO.write(bImage, "jpg", bos );
	            byte [] data = bos.toByteArray();
	            System.out.println(data);
	           return data;
	           
	        } catch (IOException e) {
	        }
	        return null;
	    }
	@Override
	@Transactional
	public int register(StudentRegister studentr) {
		try {
			if (!studentRepository.isStudentPresent(studentr.getAadhaarNo())) {
				Student student = new Student();
				//student.setPicture( writtingImage(studentr.getPicture()));
				student.setAadhaarNo(studentr.getAadhaarNo());
				student.setCategory(studentr.getCategory());
				student.setReferenceNo(studentr.getReferenceNo());
				student.setCounsellor(studentr.getCounsellor());
				student.setCounsellorName(studentr.getCounsellorName());
				student.setDate(studentr.getDate());
				student.setDateOfBirth(studentr.getDateOfBirth());
				student.setDemoCard(studentr.getDemoCard());
				student.setDomicileState(studentr.getDomicileState());
				student.setEmailId(studentr.getEmailId());
				student.setFatherName(studentr.getFatherName());
				student.setGradePer10(studentr.getGradePer10());

				student.setGradePer11(studentr.getGradePer11());

				student.setGradePer12(studentr.getGradePer12());
				student.setLocalAddress(studentr.getLocalAddress());
				student.setLocalAddressGuardian(studentr.getLocalAddressGuardian());
				student.setMedium(studentr.getMedium());
				student.setMobileNoFather(studentr.getMobileNoFather());
				student.setMobileNoLocalGuardian(studentr.getMobileNoLocalGuardian());
				student.setMobileNoMother(studentr.getMobileNoMother());
				student.setMobileNoSms(studentr.getMobileNoSms());
				student.setMobileNoStudent(studentr.getMobileNoStudent());
				student.setMotherName(studentr.getMotherName());
				student.setName(studentr.getName());
				student.setParentsOccupation(studentr.getParentsOccupation());
				student.setPassingOutYear10(studentr.getPassingOutYear10());
				student.setPassingOutYear11(studentr.getPassingOutYear11());
				student.setPassingOutYear12(studentr.getPassingOutYear12());
				student.setPastNeetAir(studentr.getPastNeetAir());

				student.setPastNeetAsr(studentr.getPastNeetAsr());
				student.setPastNeetAttempts(studentr.getPastNeetAttempts());
				student.setPastNeetMarks(studentr.getPastNeetMarks());
				student.setPastNeetRemarks(studentr.getPastNeetRemarks());
				student.setPermanentAddress(studentr.getPermanentAddress());
				student.setPwd(studentr.getPwd());
				student.setSchool10(studentr.getSchool10());

				student.setSchool11(studentr.getSchool11());

				student.setSchool12(studentr.getSchool12());
				student.setSchoolAddress10(studentr.getSchoolAddress10());
				student.setSchoolAddress11(studentr.getSchoolAddress11());
				student.setSchoolAddress12(studentr.getSchoolAddress12());
				int referenceNo = studentRepository.save(student);
				// emailService.registerEmail(finalStudent);
				return referenceNo;

			} else {
				throw new ServiceException("Student already registered");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Student already registered");
		}
	}
	@Override
	@Transactional
	public int updatePic(int referenceNo, MultipartFile image) {
		try {
			if (studentRepository.isReferenceNoPresent(referenceNo)) {
				Student student = studentRepository.fetchById(Student.class, referenceNo);
				student.setPicture( writtingImage(image));
				int referenceeNo = studentRepository.save(student);
				return referenceeNo;

			} else {
				throw new ServiceException("Invalid Reference Number");
			}
		} catch (Exception e) {
			throw new ServiceException("Invalid Reference Number");
		}
	}

	@Override
	@Transactional
	public int update(Student studentr) {
		try {
			System.out.println(studentr.getReferenceNo()+ "   "+studentRepository.isReferenceNoPresent(studentr.getReferenceNo()) );
			System.out.println(studentr.toString());
			if (studentRepository.isReferenceNoPresent(studentr.getReferenceNo())) {
				Student student = new Student();
				student.setAadhaarNo(studentr.getAadhaarNo());
				student.setCategory(studentr.getCategory());
				student.setReferenceNo(studentr.getReferenceNo());
				student.setCounsellor(studentr.getCounsellor());
				student.setCounsellorName(studentr.getCounsellorName());
				student.setDate(studentr.getDate());
				student.setDateOfBirth(studentr.getDateOfBirth());
				student.setDemoCard(studentr.getDemoCard());
				student.setDomicileState(studentr.getDomicileState());
				student.setEmailId(studentr.getEmailId());
				student.setFatherName(studentr.getFatherName());
				student.setGradePer10(studentr.getGradePer10());
				student.setPicture(studentr.getPicture());
				student.setGradePer11(studentr.getGradePer11());

				student.setGradePer12(studentr.getGradePer12());
				student.setLocalAddress(studentr.getLocalAddress());
				student.setLocalAddressGuardian(studentr.getLocalAddressGuardian());
				student.setMedium(studentr.getMedium());
				student.setMobileNoFather(studentr.getMobileNoFather());
				student.setMobileNoLocalGuardian(studentr.getMobileNoLocalGuardian());
				student.setMobileNoMother(studentr.getMobileNoMother());
				student.setMobileNoSms(studentr.getMobileNoSms());
				student.setMobileNoStudent(studentr.getMobileNoStudent());
				student.setMotherName(studentr.getMotherName());
				student.setName(studentr.getName());
				student.setParentsOccupation(studentr.getParentsOccupation());
				student.setPassingOutYear10(studentr.getPassingOutYear10());
				student.setPassingOutYear11(studentr.getPassingOutYear11());
				student.setPassingOutYear12(studentr.getPassingOutYear12());
				student.setPastNeetAir(studentr.getPastNeetAir());

				student.setPastNeetAsr(studentr.getPastNeetAsr());
				student.setPastNeetAttempts(studentr.getPastNeetAttempts());
				student.setPastNeetMarks(studentr.getPastNeetMarks());
				student.setPastNeetRemarks(studentr.getPastNeetRemarks());
				student.setPermanentAddress(studentr.getPermanentAddress());
				student.setPwd(studentr.getPwd());
				student.setSchool10(studentr.getSchool10());

				student.setSchool11(studentr.getSchool11());

				student.setSchool12(studentr.getSchool12());
				student.setSchoolAddress10(studentr.getSchoolAddress10());
				student.setSchoolAddress11(studentr.getSchoolAddress11());
				student.setSchoolAddress12(studentr.getSchoolAddress12());
				int referenceNo = studentRepository.save(student);
				return referenceNo;

			} else {
				throw new ServiceException("Invalid Reference Number");
			}
		} catch (Exception e) {
			throw new ServiceException("Invalid Reference Number");
		}
	}

	@Override
	@Transactional
	public void deleteStudent(int referenceNo) {
		try {
			if (studentRepository.isReferenceNoPresent(referenceNo)) {
				studentRepository.deleteStudent(studentRepository.fetchById(Student.class, referenceNo));
				if (admissionRepository.isReferenceNoPresent(referenceNo)) {
					Admission admission = admissionRepository.getAdmissionWithReferenceNo(referenceNo);
					admissionRepository
							.deleteAdmission(admissionRepository.fetchById(Admission.class, admission.getRollNo()));
				}
			} else {
				throw new ServiceException("Invalid Reference Number");
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalid Reference Number");
		}
	}

	@Override
	public Student fetchStudent(int referenceNo) {
		try {
			if (studentRepository.isReferenceNoPresent(referenceNo)) {
				Student student = studentRepository.fetchById(Student.class, referenceNo);
				return student;

			} else {
				throw new ServiceException("Invalid Reference Number");
			}
		} catch (Exception e) {
			throw new ServiceException("Some error occured while updating");
		}
	}

	@Override
	public List<Student> getStudentsService() {

		return studentRepository.getStudents();
	}

	@Override
	public long studentsCount() {
		return studentRepository.studentCount();
	}
	@Override
	public byte[] writtingImage(MultipartFile image) {
		try {
        	BufferedImage bImage = ImageIO.read(image.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            byte [] data = bos.toByteArray();
            System.out.println(data);
           return data;
           
        } catch (IOException e) {
        }
        return null;
	}
	
	public BufferedImage returnImage(byte[] data, int refNo) {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(data);
		      BufferedImage bImage2 = ImageIO.read(bis);
		      ImageIO.write(bImage2, "jpg", new File(refNo+".jpg") );
		      System.out.println("image created");
		      
			return bImage2;
           
        } catch (IOException e) {
        }
        return null;
	}

}
