package com.example.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.Member;
import com.example.util.Pagination;

@Mapper
public interface MemberMapper {
	
	@Select("select count(*) from member")
	int CountAll();
	
	@Select("select * from member order by membersrl asc")
	List<Member> selectAll();
	
	@Select({
		"select *                             ",
		"  from member	                      ",
		" order by membersrl                  ",
		"offset #{firstItem} - 1 rows         ",
		" fetch next #{itemsPerPage} rows only"
	})
	List<Member> selectPage(Pagination page);

	@Select("select * from member where userid=#{userid}")
	Member selectById(String id);
	
	@Select("select * from member where membersrl=#{membersrl}")
	Member selectByMembersrl(BigDecimal membersrl);

	@Insert({
		"insert into ",
		"member ( membersrl, 	userid, 	email, 		username, 		password, 		isadmin,	isallowed  ) ",
		"values ( #{membersrl},	#{userid},	#{email},	#{username},	#{password},	#{isadmin}, #{isallowed} )"				
	})
	int insert(Member member);
	
	@Update({
		"update member set",
		"userid = #{userid},",
		"email = #{email},",
		"username = #{username},",
		"password = #{password},",
		"isadmin = #{isadmin},",
		"isallowed = #{isallowed}",
		"where membersrl = #{membersrl}"
	})
	int update(Member member);
	
	@Delete("delete from member where membersrl = #{membersrl}")
	int delete(Member member);

	@Select("select MemberSrl_Seq.nextval from dual")
	BigDecimal GetNextMembersrl();

}
