package org.sj.msfilemgmnt;

import java.util.UUID;

import javax.validation.Valid;

import org.sj.msfilemgmnt.model.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class FileStoreController {
	
		@Autowired
		FileStoreRepo fileStoreRepoObj;

				/**
		 *
		 * To be used to register interest of student, should pass { "studentId":"1",
		 * "tcId":"1", "courseSectorId":"1" }
		 *
		 */
		@PostMapping("/addFile")
		public UUID createInterest(@Valid @RequestBody FileStore fileObj) {
			fileObj.setFileSize(fileObj.getFileContent().length);
			System.out.println(System.currentTimeMillis()+"::Received a file to store with length:"+fileObj.getFileSize());
			log.debug("Received a file to store with length:"+fileObj.getFileSize());
			fileObj=fileStoreRepoObj.save(fileObj);
			UUID id=fileObj.getId();
			return (id);
		}

}
