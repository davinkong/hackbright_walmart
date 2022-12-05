package com.devmountain.noteApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoteAppApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(NoteAppApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
