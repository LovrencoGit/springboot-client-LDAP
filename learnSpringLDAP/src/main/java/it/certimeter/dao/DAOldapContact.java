package it.certimeter.dao;

import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.Attribute;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import it.certimeter.mapper.ContactAttributeMapper;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

@SuppressWarnings("unchecked")
public class DAOldapContact implements IDAOldapContact {

	private LdapTemplate ldapTemplate;
	 
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}
 
	
	public List getAllContactNames() {
			
		return ldapTemplate.search( 
			query().where("objectClass").is("inetOrgPerson"), 	
			new ContactAttributeMapper() );

	}
	
	public List getAllGroupName() {
		
		return ldapTemplate.search( 
			query().where("objectClass").is("groupOfNames"), new AttributesMapper<String>() {
				public String mapFromAttributes(Attributes attrs) throws NamingException {
					return (String) attrs.get("cn").get();
				}
			});
		
	}
 
	public List getContactDetailsByGivenName(String memberOf){
		AndFilter andFilter = new AndFilter();
		andFilter.and(new EqualsFilter("givenName", memberOf));
		System.out.println("[getAllGroupName] LDAP Query: " + andFilter.encode());

		return ldapTemplate.search("", andFilter.encode(), new ContactAttributeMapper() );
	}
	
	
	/*
	 LDAP Query: (&(objectClass=groupOfNames)(cn=ferraro))
	 OUTPUT:[
		description: Member of Ferraro's Business Unit
		objectClass: groupOfNames
		member: cn=simone.ferraro,ou=people,dc=certimetergroup,dc=com, cn=francesco.destino,ou=people,dc=certimetergroup,dc=com, cn=diego.cascio,ou=people,dc=certimetergroup,dc=com, cn=luca.ganau,ou=people,dc=certimetergroup,dc=com, cn=gabriele.onida,ou=people,dc=certimetergroup,dc=com, cn=loris.cernich,ou=people,dc=certimetergroup,dc=com, cn=nina.vizir,ou=people,dc=certimetergroup,dc=com
		cn: ferraro
	]
	 */
	public List getGroupInfoByName(String groupName){
		AndFilter andFilter = new AndFilter();
		andFilter.and(new EqualsFilter("objectClass", "groupOfNames"));
		//andFilter.and(new EqualsFilter("ou", "groups"));
		andFilter.and(new EqualsFilter("cn", groupName));
		System.out.println("[getGroupInfoByName] LDAP Query: " + andFilter.encode());

		return ldapTemplate.search("", andFilter.encode(), new AttributesMapper<String>() {
            public String mapFromAttributes(Attributes attrs) throws NamingException {
            	String out = "\n";
            	for (NamingEnumeration ne = attrs.getAll(); ne.hasMore();) {
            	      Attribute attr = (Attribute) ne.next();
            	      out += attr.toString() + "\n";
            	}
            	return out;
         }
      });
	}

}
