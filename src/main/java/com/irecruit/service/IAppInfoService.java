package com.irecruit.service;

import java.io.InputStream;
import java.util.ArrayList;

import com.irecruit.pojo.InfoEntity;

public interface IAppInfoService {
	ArrayList<InfoEntity> retrieveSkills();
	void prepareInfo(InfoEntity info);
	void updateInfo(InfoEntity info);
	void updateDesigInfo(InfoEntity info);
	void updateInterviewRoundsInfo(InfoEntity info);
	InputStream getFileData() throws Exception;
}
