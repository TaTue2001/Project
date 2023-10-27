package com.example.Project.Properties;

public class ProjectEnum {
	enum PageSize{
		big(30),
		medium(50),
		small(70);
		int rowOfPage;
		PageSize(int rowOfPage) {
			this.rowOfPage=rowOfPage;
		}
	}
	
}
