package it.certimeter.pojo;

import java.util.List;

public class Contact {
	
	String givenName;
	String sn;
	String loginShell;
	String uidNumber;
	String gidNumber;
	List<String> mail;
	String displayName;
	List<String> objectClass;
	String uid;
	String gecos;
	String preferredLanguage;
	String cn;
	String homeDirectory;
	
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getLoginShell() {
		return loginShell;
	}
	public void setLoginShell(String loginShell) {
		this.loginShell = loginShell;
	}
	public String getUidNumber() {
		return uidNumber;
	}
	public void setUidNumber(String uidNumber) {
		this.uidNumber = uidNumber;
	}
	public String getGidNumber() {
		return gidNumber;
	}
	public void setGidNumber(String gidNumber) {
		this.gidNumber = gidNumber;
	}
	public List<String> getMail() {
		return mail;
	}
	public void setMail(List<String> mail) {
		this.mail = mail;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public List<String> getObjectClass() {
		return objectClass;
	}
	public void setObjectClass(List<String> objectClass) {
		this.objectClass = objectClass;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getGecos() {
		return gecos;
	}
	public void setGecos(String gecos) {
		this.gecos = gecos;
	}
	public String getPreferredLanguage() {
		return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getHomeDirectory() {
		return homeDirectory;
	}
	public void setHomeDirectory(String homeDirectory) {
		this.homeDirectory = homeDirectory;
	}
	
	@Override
	public String toString() {
		return "Contact {\n\tgivenName=" + givenName + ", \n\tsn=" + sn + ", \n\tloginShell=" + loginShell
				+ ", \n\tuidNumber=" + uidNumber + ", \n\tgidNumber=" + gidNumber + ", \n\tmail=" + mail
				+ ", \n\tdisplayName=" + displayName + ", \n\tobjectClass=" + objectClass + ", \n\tuid=" + uid
				+ ", \n\tgecos=" + gecos + ", \n\tpreferredLanguage=" + preferredLanguage + ", \n\tcn=" + cn
				+ ", \n\thomeDirectory=" + homeDirectory + "\n}";
	}
	
	
	
	
	
}
