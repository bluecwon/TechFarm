package com.itbank.TechFarm.tfPlusDAO;

import java.util.List;

import com.itbank.TechFarm.tfPlusDTO.MemberProfileAddCommentDTO;
import com.itbank.TechFarm.tfPlusDTO.MemberProfileBoardDTO;
import com.itbank.TechFarm.tfPlusDTO.MemberProfileDTO;

public interface MemberProfileDAO {
	public List memberGoodList(int startRow, int endRow);
	public List memberJoinAllList();
	public int memberProfileCount();
	public List memberMyList(int startRow, int endRow, String id);
	public List memberJoinMyList(String id);
	public MemberProfileDTO memberNumList(int num);
	public List memberAddList(int ProfileBoardPK);
	public List memberProfileBoard(String profileName, String profileId);
	public boolean memberJoinIdCheck(int num, String id);
	public int memberProfileInsert(MemberProfileDTO memberProfileDTO);
	public int memberProfileBoardInsert(MemberProfileBoardDTO memberProfileBoardDTO);
	public boolean memberJoinIdSearch(int num);
	public MemberProfileDTO memberProfileCheck(String name, String profileId);
	public int memberJoinInsert(int profileNum, String id);
	public int memberJoinDelete(int memberJoinPK);
	public int memberProfileDelete(int profileNum);
	public int memberProfileJoin(int profileNum);
	public int memberProfileUnJoin(int profileNum);
	public List memberProfileTOP(int top);
	public int memberAddListInsert(MemberProfileAddCommentDTO memberProfileAddCommentDTO);
}
