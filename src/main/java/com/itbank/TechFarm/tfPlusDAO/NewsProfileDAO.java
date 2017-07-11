package com.itbank.TechFarm.tfPlusDAO;

import java.util.List;

import com.itbank.TechFarm.tfPlusDTO.NewsProfileAddCommentDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsProfileBoardDTO;
import com.itbank.TechFarm.tfPlusDTO.NewsProfileDTO;

public interface NewsProfileDAO {
	public List newsGoodList(int startRow, int endRow); 
	public List newsMyList(int startRow, int endRow, String id); 
	public int newsProfileInsert(NewsProfileDTO newsProfileDTO); 
	public int newsProfileBoardInsert(NewsProfileBoardDTO newsProfileBoardDTO);
	public boolean newsFollowIdSearch(int num); 
	public boolean newsFollowIdCheck(int num, String id);
	public NewsProfileDTO newsProfileCheck(String name, String profileId); 
	public List newsFollowMyList(String id); 
	public NewsProfileDTO newsNumList(int num); 
	public int newsFollowInsert(int profileNum, String id); 
	public List newsFollowAllList(); 
	public int newsFollowDelete(int newsfollowPK); 
	public int newsProfileCount();
	public int newsProfileDelete(int profileNum); 
	public int newsProfileFollow(int profileNum); 
	public int newsProfileUnFollow(int profileNum); 
	public List newsProfileBoard(String profileName, String profileId);
	public List newsProfileTOP(int top);
	public List newsAddList(int profileBoardPK);
	public int newsAddListInsert(NewsProfileAddCommentDTO newsProfileAddCommentDTO);
}
