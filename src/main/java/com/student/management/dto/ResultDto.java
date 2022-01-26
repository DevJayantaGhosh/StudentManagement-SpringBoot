package com.student.management.dto;

import org.springframework.web.multipart.MultipartFile;

public class ResultDto {
	
	private MultipartFile files;

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	
	

}
