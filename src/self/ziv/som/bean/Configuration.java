package self.ziv.som.bean;

/**
 * @author 作者 E-mail: ziv 八重齿 @2374619909.com
 * @version 创建时间： 2018年4月15日 上午10:01:07 类说明 : 封裝配置文件信息
 */
public class Configuration {
	private String driver;
	private String username;
	private String password;
	private String url;
	private String usingDB;

	private String srcPath;
	private String poPackage;
	
	public Configuration() {
		super();
	}
	public Configuration(String driver, String username, String password, String url, String usingDB, String srcPath,
			String poPackage) {
		super();
		this.driver = driver;
		this.username = username;
		this.password = password;
		this.url = url;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	@Override
	public String toString() {
		return "Configuration [driver=" + driver + ", username=" + username + ", password=" + password + ", url=" + url
				+ ", usingDB=" + usingDB + ", srcPath=" + srcPath + ", poPackage=" + poPackage + "]";
	}
}
