package com.hotel.emailService.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

@RestController
public class FileUploadController {
	
	 private static String UPLOADED_FOLDER = "F://tmp//";
	 
	 @Autowired
	 AmazonS3 s3client;

//	@PostMapping("/api/upload")
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, 
    consumes = { "multipart/form-data" } ,value = "/upload")
//    // If not @RestController, uncomment this
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {

       // logger.debug("Single file upload!");

        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {

            saveUploadedFiles(Arrays.asList(uploadfile));

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }
        //save file
        private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

            for (MultipartFile file : files) {

                if (file.isEmpty()) {
                    continue; //next pls
                }

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                File awsfile = new File(path.toString());
                FileWriter fw = new FileWriter(awsfile);
                fw.write(new String(bytes));
                Files.write(path, bytes);
                saveinS3(file.getOriginalFilename(), awsfile);

            }
            


    }
        
        
  public void saveinS3(String fileName,File file) {
	  String bucketName = "filedemo-bucket";

	  if(s3client.doesBucketExist(bucketName)) {
	     // LOG.info("Bucket name is not available."
	       // + " Try again with a different Bucket name.");
	     // return;
	  } else {
		  s3client.putObject(
				  bucketName, 
				  fileName, 
				  file
				);

	  }

	 // s3client.createBucket(bucketName);
	  s3client.putObject(
			  bucketName, 
			  fileName, 
			  file
			);
  }
   
 @RequestMapping( value ="/hello")       
public String Hello() {
	 List<Bucket> buckets = s3client.listBuckets();
	 for(Bucket bucket : buckets) {
	     System.out.println(bucket.getName());
	 }
	return "HI";
	
	
}


}
