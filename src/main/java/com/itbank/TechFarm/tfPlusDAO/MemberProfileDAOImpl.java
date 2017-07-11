package com.itbank.TechFarm.tfPlusDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itbank.TechFarm.tfPlusDTO.MemberProfileAddCommentDTO;
import com.itbank.TechFarm.tfPlusDTO.MemberProfileBoardDTO;
import com.itbank.TechFarm.tfPlusDTO.MemberProfileDTO;

public class MemberProfileDAOImpl implements MemberProfileDAO {

	@Override
	public List memberGoodList(int startRow, int endRow) {
		Map mapParameter = new HashMap();
		mapParameter.put("startRow", startRow);
		mapParameter.put("endRow", endRow);
		return MemberProfileMapper.memberGoodList(mapParameter);
	}

	@Override
	public List memberJoinAllList() {
		return MemberProfileMapper.joinList();
	}

	@Override
	public int memberProfileCount() {
		return MemberProfileMapper.memberProfileCount();
	}

	@Override
	public List memberMyList(int startRow, int endRow, String id) {
		Map mapParameter = new HashMap();
		mapParameter.put("startRow", startRow);
		mapParameter.put("endRow", endRow);
		mapParameter.put("id", id);
		return MemberProfileMapper.memberMyList(mapParameter);
	}

	@Override
	public List memberJoinMyList(String id) {
		return MemberProfileMapper.memberJoinMyList(id);
	}

	@Override
	public MemberProfileDTO memberNumList(int num) {
		return MemberProfileMapper.memberNumList(num);
	}

	@Override
	public List memberAddList(int ProfileBoardPK) {
		return MemberProfileMapper.memberAddList(ProfileBoardPK);
	}

	@Override
	public List memberProfileBoard(String profileName, String profileId) {
		Map mapParameter = new HashMap();
		mapParameter.put("profileName", profileName);
		mapParameter.put("profileId", profileId);
		return MemberProfileMapper.memberProfileBoardList(mapParameter);
	}

	@Override
	public boolean memberJoinIdCheck(int num, String id) {
		Map mapParameter = new HashMap();
		mapParameter.put("memberJoinNum", num);
		mapParameter.put("memberJoinId", id);
		return MemberProfileMapper.memberJoinIdCheck(mapParameter);
	}

	@Override
	public int memberProfileInsert(MemberProfileDTO memberProfileDTO) {
		return MemberProfileMapper.memberProfileInsert(memberProfileDTO);
	}

	
	@Override
	public int memberProfileBoardInsert(MemberProfileBoardDTO memberProfileBoardDTO) {
		return MemberProfileMapper.memberProfileBoardInsert(memberProfileBoardDTO);
	}

	@Override
	public boolean memberJoinIdSearch(int num) {
		return MemberProfileMapper.memberJoinIdSearch(num);
	}

	@Override
	public MemberProfileDTO memberProfileCheck(String name, String profileId) {
		Map mapParameter = new HashMap();
		mapParameter.put("profileName", name);
		mapParameter.put("profileId", profileId);
		return MemberProfileMapper.memberProfileCheck(mapParameter);
	}

	@Override
	public int memberJoinInsert(int profileNum, String id) {
		Map mapParameter = new HashMap();
		mapParameter.put("profileNum", profileNum);
		mapParameter.put("id", id);
		return MemberProfileMapper.memberJoinInsert(mapParameter);
	}

	@Override
	public int memberJoinDelete(int memberJoinPK) {
		return MemberProfileMapper.memberJoinDelete(memberJoinPK);
	}

	@Override
	public int memberProfileDelete(int profileNum) {
		return MemberProfileMapper.memberProfileDelete(profileNum);
	}

	@Override
	public int memberProfileJoin(int profileNum) {
		return MemberProfileMapper.memberProfileJoin(profileNum);
	}

	@Override
	public int memberProfileUnJoin(int profileNum) {
		return MemberProfileMapper.memberProfileUnJoin(profileNum);
	}

	@Override
	public List memberProfileTOP(int top) {
		return MemberProfileMapper.memberProfileTOP(top);
	}

	@Override
	public int memberAddListInsert(MemberProfileAddCommentDTO memberProfileAddCommentDTO) {
		return MemberProfileMapper.memberAddListInsert(memberProfileAddCommentDTO);
	}

}
