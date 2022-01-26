package com.student.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.management.dto.RegistrationStatus;
import com.student.management.dto.ResultDto;
import com.student.management.dto.ResultsListDto;
import com.student.management.dto.Status;
import com.student.management.dto.StudentDto;
import com.student.management.dto.Status.StatusCode;
import com.student.management.entity.Student;
import com.student.management.exception.ServiceException;
import com.student.management.service.ExamCellService;

@RestController
@CrossOrigin
public class ExamCellController {
	@Autowired
	private ExamCellService examCellService;
	
	@PostMapping(path="/results-upload")
	public @ResponseBody Status resultsUpload(@RequestParam("file") MultipartFile files) throws IOException {
		try {
			examCellService.saveResults(files);
			Status status = new Status();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Results Upload Successful");
			return status;
		} catch(ServiceException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Results Upload Failed");
			return status;
		}
	}
	
	@GetMapping(path="/fetch-result-rollno")
	public ResultsListDto fetchResultsByRollNo(@RequestParam("rollNo") int rollNo) {
		try {
			ResultsListDto results = new ResultsListDto();
			results.setResultsList(examCellService.getResultsByRollNo(rollNo));
			results.setStatusCode(StatusCode.SUCCESS);
			results.setStatusMessage("Results fetched Successfully for the given Roll Number ");
			return results;
		}catch(ServiceException e) {
			ResultsListDto results = new ResultsListDto();
			results.setStatusCode(StatusCode.FAILURE);
			results.setStatusMessage("Results fetch Failed for the given Roll Number");
			return results;
		}
	}
	
	@GetMapping(path="/fetch-result-testcode")
	public ResultsListDto fetchResultsByTestCode(@RequestParam("testCode") String testCode) {
		try {
			ResultsListDto results = new ResultsListDto();
			results.setResultsList(examCellService.getResultsByTestCode(testCode));
			results.setStatusCode(StatusCode.SUCCESS);
			results.setStatusMessage("Results fetched Successfully for the given Test Code");
			return results;
		}catch(ServiceException e) {
			ResultsListDto results = new ResultsListDto();
			results.setStatusCode(StatusCode.FAILURE);
			results.setStatusMessage("Results fetch Failed for the given Test Code");
			return results;
		}
	}

}
