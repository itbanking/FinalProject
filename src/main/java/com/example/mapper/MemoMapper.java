package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Memo;
import com.example.form.MemberForm;
import com.example.util.Pagination;

@Mapper
public interface MemoMapper {
	
	/*
	 * Select
	 */
	@Select("select count(*) from memo")
	int selectTotalCount(MemberForm memberForm);
	
	@Select("select * from memo")
	List<Memo> selectAll();
	List<Memo> selectAllWithMember();
	
	@Select({
		"select *                ",
		"  from memo             ",
		" order by mno desc         ",
		"offset #{firstItem} - 1 rows   ",
		" fetch next #{itemsPerPage} rows only"
	})
	List<Memo> selectPage(@Param("paging") Pagination paging, @Param("memberForm") MemberForm memberForm);
	List<Memo> selectPageWithMember(Pagination paging);
	
	@Select("select * from memo where mno=#{mno}")
	Memo selectByMno(int mno);
	Memo selectByMnoWithMember (int mno);
	
	/*
	 * Insert
	 */
	int insert(Memo memo);
	
	/*
	 * Update
	 */
	int updateByMno(Memo memo);
	
	/*
	 * Delete
	 */
	@Delete("delete from memo where mno=#{mno}")
	int deleteByMno(int mno);
}
