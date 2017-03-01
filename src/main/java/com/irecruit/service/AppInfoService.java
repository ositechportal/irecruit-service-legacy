package com.irecruit.service;

import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.mongo.repository.InfoRepository;
import com.irecruit.pojo.InfoEntity;

@Service
public class AppInfoService implements IAppInfoService{
	
	@Autowired
	InfoRepository skillsRequired;
	
	public ArrayList<InfoEntity> retrieveSkills() {
		return (ArrayList<InfoEntity>) skillsRequired.findAll();
	}
	
	public void prepareInfo(InfoEntity info) {
		skillsRequired.insert(info);
	}

	public void updateInfo(InfoEntity info) {
		skillsRequired.insert(info);
	}

	public void updateDesigInfo(InfoEntity info) {
		skillsRequired.insert(info);
	}

	public void updateInterviewRoundsInfo(InfoEntity info) {
		skillsRequired.insert(info);
	}

    public InputStream getFileData() throws Exception {
    	InputStream in = null;
    	try {
    		in = this.getClass().getClassLoader().getResourceAsStream("OSI_Recruitment_Portal_Help_v1.0.docx");
           
         }catch(Exception ex){
        	 ex.printStackTrace();
         }
    	
		return in;
	}
}
