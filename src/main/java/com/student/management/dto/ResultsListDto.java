package com.student.management.dto;
import java.util.List;

import com.student.management.entity.Result;

public class ResultsListDto extends Status {
	
	private List<Result> resultsList;

	public List<Result> getResultsList() {
		return resultsList;
	}

	public void setResultsList(List<Result> resultsList) {
		this.resultsList = resultsList;
	}
	
	

}
