package com.itbank.email;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.james.domainlist.api.DomainListManagementMBean;
import org.apache.james.user.api.UsersRepositoryManagementMBean;

public class JamesUser {
	private String serverUrl;
	private String beanNameUser;
	private String beanNameDomain;
	private String host = "52.79.140.54";
	
	public JamesUser(){
		serverUrl = "service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi";
        beanNameUser = "org.apache.james:type=component,name=usersrepository";
        beanNameDomain = "org.apache.james:type=component,name=domainlist";
	}
	public void addUser(String id, String password){
	    try{
	        MBeanServerConnection server = JMXConnectorFactory.connect(new JMXServiceURL(serverUrl)).getMBeanServerConnection();
	        UsersRepositoryManagementMBean userBean =  MBeanServerInvocationHandler.newProxyInstance(server, new ObjectName(beanNameUser), UsersRepositoryManagementMBean.class, false);
	        DomainListManagementMBean domainBean =  MBeanServerInvocationHandler.newProxyInstance(server, new ObjectName(beanNameDomain), DomainListManagementMBean.class, false);
	        if(domainBean.containsDomain(host) && !userBean.verifyExists(id+"@"+host)){
	            System.out.println("creating email : "+id+"@"+host );
	            userBean.addUser(id+"@"+host, password);
	        }else{
	            System.out.println("addUser failed : domain does not exist or user already exists !!");
	        }

	    }catch (Exception e){
	        System.out.println("Something went wrong");
	    }
	}
	public void setPassword(String id, String password){
	    try{
	        MBeanServerConnection server = JMXConnectorFactory.connect(new JMXServiceURL(serverUrl)).getMBeanServerConnection();
	        UsersRepositoryManagementMBean userBean =  MBeanServerInvocationHandler.newProxyInstance(server, new ObjectName(beanNameUser), UsersRepositoryManagementMBean.class, false);
	        DomainListManagementMBean domainBean =  MBeanServerInvocationHandler.newProxyInstance(server, new ObjectName(beanNameDomain), DomainListManagementMBean.class, false);
	        if(domainBean.containsDomain(host) && !userBean.verifyExists(id+"@"+host)){
	            System.out.println("creating email : "+id+"@"+host );
	            userBean.setPassword(id+"@"+host, password);
	        }else{
	            System.out.println("setPassword failed : domain does not exist!!");
	        }

	    }catch (Exception e){
	        System.out.println("Something went wrong");
	    }
	}
	public void deleteUser(String id){
	    try{
	        MBeanServerConnection server = JMXConnectorFactory.connect(new JMXServiceURL(serverUrl)).getMBeanServerConnection();
	        UsersRepositoryManagementMBean userBean =  MBeanServerInvocationHandler.newProxyInstance(server, new ObjectName(beanNameUser), UsersRepositoryManagementMBean.class, false);
	        DomainListManagementMBean domainBean =  MBeanServerInvocationHandler.newProxyInstance(server, new ObjectName(beanNameDomain), DomainListManagementMBean.class, false);
	        if(domainBean.containsDomain(host) && !userBean.verifyExists(id+"@"+host)){
	            System.out.println("creating email : "+id+"@"+host );
	            userBean.deleteUser(id+"@"+host);
	        }else{
	            System.out.println("deleteUser failed : domain does not exist!!");
	        }

	    }catch (Exception e){
	        System.out.println("Something went wrong");
	    }
	}
}
