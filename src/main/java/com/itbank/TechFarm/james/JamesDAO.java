package com.itbank.TechFarm.james;

import java.util.List;

import javax.mail.Message;

public interface JamesDAO {
	public Message[] listJames(String host, String storeType, String user, String password);
	public void getJames();
	public void sendJames();
	public void deleteJames();
}
