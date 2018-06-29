package com.briup.apps.poll.bean.extend;

public class AnswersVM {
	private Long id;
	private String selections;
	private String checks;
	private String content;
	
	private SurveyVM survey;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSelections() {
		return selections;
	}
	public void setSelections(String selections) {
		this.selections = selections;
	}
	public String getChecks() {
		return checks;
	}
	public void setChecks(String checks) {
		this.checks = checks;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public SurveyVM getSurvey() {
		return survey;
	}
	public void setSurvey(SurveyVM survey) {
		this.survey = survey;
	}
	
	
}
