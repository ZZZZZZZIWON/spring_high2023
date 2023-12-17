package kr.ac.kopo;

import org.springframework.web.multipart.MultipartFile;

public class Image {
	private String title;
	private MultipartFile uploadFile;
	private String filename;                                                                                                                                        
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	
}
