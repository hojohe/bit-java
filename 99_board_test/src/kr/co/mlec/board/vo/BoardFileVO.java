package kr.co.mlec.board.vo;

public class BoardFileVO {
	
	private int file_no;
	private int no;
	private String oriName;
	private String systemName;
	private String filePath;
	private int fileSize;
	
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

}
