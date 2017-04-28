package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Member;
import com.example.domain.Sal;
import com.example.form.MemberForm;
import com.example.util.Pagination;

@Mapper
public interface SalMapper {
	
	/*
	 * Select
	 */
	@Select("select count(*) from sal")
	int selectTotalCount();
	
	@Select({
		"select count(*)					",
		"  from sal							",
		" where membersrl = #{membersrl}	",	
		" order by salno					"
	})
	int selectTotalUserCount(MemberForm memberForm);
	
	@Select({
		"select count(*)					",
		"  from sal						    ",
		" order by salno					"
	})
	int selectTotalIsAdmin();
	
	@Select("select * from sal order by salno")
	List<Sal> selectAll();
	List<Sal> selectAllWithMember();
	
	@Select({
		"select * 						",
		"  from sal						",
		" where membersrl = #{memberForm.membersrl}",
		" order by salno				",
		"offset #{paging.firstItem} - 1 rows	",
		" fetch next #{paging.itemsPerPage} rows only"
	})
	List<Sal> selectPage(@Param("paging") Pagination paging, @Param("memberForm") MemberForm memberForm);
	List<Sal> selectPageWithMember(Pagination paging);
	
	@Select({
		"select * 						",
		"  from sal						",
		" order by salno				",
		"offset #{firstItem} - 1 rows	",
		" fetch next #{itemsPerPage} rows only"
	})
	List<Sal> selectPageIsAdmin(Pagination paging);
	
	@Select("select * from sal where salno=#{salno}")
	Sal selectBySalno(int salno);
	Sal selectBySalnoWithMember(int salno);
	
	/*
	 * Insert
	 */
	int insert(Sal sal);
	
	/*
	 * Update
	 */
	int updateBySalno(Sal sal);
	
	@Select("select * from member order by membersrl")
	List<Member> GetMemberInfos();
	
	/*
	 * Delete
	 */
	@Delete("delete from sal where salno=#{salno}")
	int deleteBySalno(int salno);
	
}
