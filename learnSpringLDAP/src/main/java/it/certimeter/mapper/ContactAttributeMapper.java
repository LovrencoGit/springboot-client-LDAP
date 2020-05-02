package it.certimeter.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import it.certimeter.pojo.Contact;

public class ContactAttributeMapper implements AttributesMapper{
	
	public Object mapFromAttributes(Attributes attributes) throws NamingException {
		Contact contact = new Contact();

		Attribute givenName = attributes.get("givenName");
		Attribute sn = attributes.get("sn");
		Attribute loginShell = attributes.get("loginShell");
		Attribute uidNumber = attributes.get("uidNumber");
		Attribute gidNumber = attributes.get("gidNumber");
		Attribute mails = attributes.get("mail");
		Attribute displayName = attributes.get("displayName");
		Attribute objectClass = attributes.get("objectClass");
		Attribute uid = attributes.get("uid");
		Attribute gecos = attributes.get("gecos");
		Attribute preferredLanguage = attributes.get("preferredLanguage");
		Attribute cn = attributes.get("cn");
		Attribute homeDirectory = attributes.get("homeDirectory");
		
		contact.setGivenName( givenName!=null ? (String)givenName.get() : null );
		contact.setSn( sn!=null ? (String)sn.get() : null );
		contact.setLoginShell( loginShell!=null ? (String)loginShell.get() : null );
		contact.setUidNumber( uidNumber!=null ? (String)uidNumber.get() : null );
		contact.setGidNumber( gidNumber!=null ? (String)gidNumber.get() : null );
		contact.setMail( mails!=null ? createListStringFrom(mails) : null );
		contact.setDisplayName( displayName!=null ? (String)displayName.get() : null );
		contact.setObjectClass( objectClass!=null ? createListStringFrom(objectClass) : null );
		contact.setUid( uid!=null ? (String)uid.get() : null );
		contact.setGecos( gecos!=null ? (String)gecos.get() : null );
		contact.setPreferredLanguage( preferredLanguage!=null ? (String)preferredLanguage.get() : null );
		contact.setCn( cn!=null ? (String)cn.get() : null);
		contact.setHomeDirectory( homeDirectory!=null ? (String)homeDirectory.get() : null );
		
		return contact;
	}
	
	
	
	
	/************************************************************************************************************/
	/*									METODI AUSILIARI														*/
	/************************************************************************************************************/
	
	private List<String> createListStringFrom( Attribute attributeLDAP ){
		List<String> attributeLDAPtoList = new ArrayList<String>();
		try{
			for (NamingEnumeration item = attributeLDAP.getAll(); item.hasMore();) {
	            String mailAddress = (String) item.next();
	            //System.out.println("### "+ mailAddress );
	            attributeLDAPtoList.add(mailAddress);
			}
		}catch(Exception exc){
			System.out.println(exc.getMessage());
			exc.printStackTrace();
		}
		return attributeLDAPtoList;
	}
	
}
