package com.student.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.student.management.entity.Result;
import com.student.management.exception.ServiceException;
import com.student.management.repository.ResultRepository;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;

@Service
public class ExamCellServiceImpl implements ExamCellService {
	
	@Autowired
	private ResultRepository resultRepository;

	@Override
	public void saveResults(MultipartFile files) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		System.out.println(worksheet);

		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
			if (index > 0) {
				Result result = new Result();

				XSSFRow row = worksheet.getRow(index);
				result.setRollNo(Integer.parseInt(row.getCell(0).getStringCellValue()));
				result.setTestCode(row.getCell(1).getStringCellValue());
				result.setAnswers(row.getCell(2).getStringCellValue());
				result.setAnswersEdited(row.getCell(3).getStringCellValue());
				result.setAnswerConfidence(row.getCell(4).getStringCellValue());
				result.setSheetConfidence(row.getCell(5).getStringCellValue());
				result.setRectangleCount1(row.getCell(6).getStringCellValue());
				char resolutionIssue;
				if(row.getCell(7).getStringCellValue() == "No") {
					resolutionIssue = 'N' ;
				}
				else {
					resolutionIssue = 'Y' ;
				}
				result.setResolutionIssue(resolutionIssue);
				char rectangleFault;
				if(row.getCell(8).getStringCellValue() == "No") {
					rectangleFault = 'N' ;
				}
				else {
					rectangleFault = 'Y' ;
				}
				result.setRectangleFault(rectangleFault);
				char flippedImage;
				if(row.getCell(9).getStringCellValue() == "No") {
					flippedImage = 'N' ;
				}
				else {
					flippedImage = 'Y' ;
				}
				result.setFlippedImage(flippedImage);
				result.setSide1BW(row.getCell(10).getStringCellValue());
				result.setMedium(row.getCell(11).getStringCellValue());
				//(int)row.getCell(12).getNumericCellValue()
				result.setScore(Integer.parseInt(row.getCell(12).getStringCellValue()));
				result.setRight(Integer.parseInt(row.getCell(13).getStringCellValue()));
				result.setWrong(Integer.parseInt(row.getCell(14).getStringCellValue()));
				result.setBlank(Integer.parseInt(row.getCell(15).getStringCellValue()));
				result.setRank(Integer.parseInt(row.getCell(16).getStringCellValue()));
				result.setPhysics(Integer.parseInt(row.getCell(17).getStringCellValue()));
				result.setPhysicsCorrect(Integer.parseInt(row.getCell(18).getStringCellValue()));
				result.setPhysicsIncorrect(Integer.parseInt(row.getCell(19).getStringCellValue()));
				result.setPhysicsBlank(Integer.parseInt(row.getCell(20).getStringCellValue()));
				result.setPhysicsPer(Float.parseFloat(row.getCell(21).getStringCellValue()));
				result.setChemistry(Integer.parseInt(row.getCell(22).getStringCellValue()));
				result.setChemistryCorrect(Integer.parseInt(row.getCell(23).getStringCellValue()));
				result.setChemistryIncorrect(Integer.parseInt(row.getCell(24).getStringCellValue()));
				result.setChemistryBlank(Integer.parseInt(row.getCell(25).getStringCellValue()));
				result.setChemistryPer(Float.parseFloat(row.getCell(26).getStringCellValue()));
				result.setBotany(Integer.parseInt(row.getCell(27).getStringCellValue()));
				result.setBotanyCorrect(Integer.parseInt(row.getCell(28).getStringCellValue()));
				result.setBotanyIncorrect(Integer.parseInt(row.getCell(29).getStringCellValue()));
				result.setBotanyBlank(Integer.parseInt(row.getCell(30).getStringCellValue()));
				result.setBotanyPer(Float.parseFloat(row.getCell(31).getStringCellValue()));
				result.setZoology(Integer.parseInt(row.getCell(32).getStringCellValue()));
				result.setZoologyCorrect(Integer.parseInt(row.getCell(33).getStringCellValue()));
				result.setZoologyIncorrect(Integer.parseInt(row.getCell(34).getStringCellValue()));
				result.setZoologyBlank(Integer.parseInt(row.getCell(35).getStringCellValue()));
				result.setZoologyPer(Float.parseFloat(row.getCell(36).getStringCellValue()));
				Result updatedResult = resultRepository.save(result);
				System.out.println(updatedResult.toString());

			}

		}

	}

	@Override
	public List<Result> getResultsByRollNo(int rollNo) {
		try {
			List<Result> results = resultRepository.getResultsByRollNo(rollNo);
			return results;
		}catch(EmptyResultDataAccessException e) {
			throw new ServiceException("No Results Found with given Roll Number");
		}
	}

	@Override
	public List<Result> getResultsByTestCode(String testCode) {
		try {
			List<Result> results = resultRepository.getResultsByTestCode(testCode);
			return results;
		}catch(EmptyResultDataAccessException e) {
			throw new ServiceException("No Results Found with given Test Code");
		}
	}

}
