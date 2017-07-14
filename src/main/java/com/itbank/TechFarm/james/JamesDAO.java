package com.itbank.TechFarm.james;

import java.util.List;

import javax.mail.Message;

public interface JamesDAO {
	public List<JamesDTO> listJames(String user, String password);
	public void getJames();
	public int sendJames(JamesDTO dto);
	public void deleteJames();
}
