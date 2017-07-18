package com.itbank.TechFarm.james;

import java.util.List;

import javax.mail.Message;

public interface JamesDAO {
	public List<JamesDTO> listJames(JamesDTO dto);
	public JamesDTO getJames(JamesDTO dto);
	public int sendJames(JamesDTO dto);
	public void deleteJames();
}
