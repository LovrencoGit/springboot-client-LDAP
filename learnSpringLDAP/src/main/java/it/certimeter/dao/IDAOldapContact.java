package it.certimeter.dao;

import java.util.List;

public interface IDAOldapContact {

	public List getAllContactNames();
	
	public List getAllGroupName();
	 
	public List getContactDetailsByGivenName(String commonName);

	public List getGroupInfoByName(String groupName);
	
}
