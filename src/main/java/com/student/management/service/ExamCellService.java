package com.student.management.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.student.management.entity.Result;

public interface ExamCellService {
	void saveResults(MultipartFile files) throws IOException;
	List<Result> getResultsByRollNo(int rollNo);
	List<Result> getResultsByTestCode(String testCode);
}
