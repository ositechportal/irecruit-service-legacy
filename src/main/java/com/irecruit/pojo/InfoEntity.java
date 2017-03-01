package com.irecruit.pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "info")
public class InfoEntity {
	
	@Id
	String key;
	List<String> value;
}
