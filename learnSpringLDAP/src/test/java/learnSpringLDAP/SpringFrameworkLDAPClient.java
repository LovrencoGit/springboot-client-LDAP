package learnSpringLDAP;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;

import it.certimeter.dao.DAOldapContact;
import it.certimeter.dao.IDAOldapContact;
import it.certimeter.pojo.Contact;

public class SpringFrameworkLDAPClient {

	public static void main(String[] args) {

		try {
//			Resource resource = new ClassPathResource("/learnSpringLDAP/src/main/webapp/WEB-INF/servlet.xml");
			//FileInputStream resource = new FileInputStream("/servlet.xml");
			//BeanFactory factory = new XmlBeanFactory(resource);
			FileSystemResource config = new FileSystemResource(new File("C:\\Users\\TOSHIBA\\Dropbox\\LAVORO\\utilities\\learnSpringLDAP\\src\\main\\webapp\\WEB-INF\\servlet.xml"));
            BeanFactory factory = new XmlBeanFactory(config);
			System.out.println(factory.toString() + "\n");
 
			IDAOldapContact ldapContact = (DAOldapContact)factory.getBean("ldapContact");	
 
			//List result1 =(List) ldapContact.getAllContactNames();
			//List result2 = ldapContact.getContactDetailsByGivenName("Loris");
			//List result3 =(List) ldapContact.getGroupInfoByName("ferraro");
			List result4 =(List) ldapContact.getAllGroupName();
			System.out.println("OUTPUT:" + result4.toString());

		} catch (Exception e) {
			System.out.println("Error occured :" + e.getMessage());
			e.printStackTrace();
		}

	}

}
