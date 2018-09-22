package printVideoDuration;

public class FileInfo {
    String longname;
    String filename;
    long length;
	public FileInfo() {
		super();
	}
	public FileInfo(String longname, String filename, long length) {
		super();
		this.longname = longname;
		this.filename = filename;
		this.length = length;
	}
	public String getLongname() {
		return longname;
	}
	public void setLongname(String longname) {
		this.longname = longname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "FileInfo [longname=" + longname + ", filename=" + filename + ", length=" + length + "]";
	}
    
    
}
