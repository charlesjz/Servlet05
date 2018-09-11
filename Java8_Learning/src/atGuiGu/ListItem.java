package atGuiGu;

public class ListItem {
	
	private String type;
	private int position;
	private String url;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public ListItem(String type, int position, String url) {
		super();
		this.type = type;
		this.position = position;
		this.url = url;
	}
	@Override
	public String toString() {
		return "ListItem [type=" + type + ", position=" + position + ", url=" + url + "]";
	}
	public ListItem() {
		super();
		// TODO Auto-generated constructor stub
	}


}
