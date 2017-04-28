package com.example.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Dnltime;
import com.example.form.MemberForm;
import com.example.util.Pagination;

@Mapper
public interface DnltimeMapper {
	
	@Select("select count(*) from dnltime")
	int selectTotalCount();
	
	@Select({
		"select count(*)					",
		"  from dnltime						",
		"where membersrl = #{membersrl}		",	
		" order by dnlno					"
	})
	int selectTotalUserCount(MemberForm memberForm);
	
	@Select({
		"select count(*)					",
		"  from dnltime						",
		" order by dnlno					"
	})
	int selectTotalIsAdmin();

	List<Dnltime> selectmembersrl(int membersrl);
	
	@Select("select * from dnltime order by dnlno")
	List<Dnltime> selectAll();
	List<Dnltime> selectAllWithDnl();
	
	@Select({
		"select * 							",
		"  from dnltime						",
		"where membersrl = #{memberForm.membersrl}		",	
		" order by dnlno					",
		"offset #{paging.firstItem} -1 rows		",
		" fetch next #{paging.itemsPerPage} rows only"
	})
	List<Dnltime> selectPage(@Param("paging") Pagination paging, @Param("memberForm") MemberForm memberForm);
	List<Dnltime> selectPageWithDnl(Pagination paging);
	
	@Select({
		"select * 							",
		"  from dnltime						",
		" order by dnlno					",
		"offset #{firstItem} -1 rows		",
		" fetch next #{itemsPerPage} rows only"
	})
	List<Dnltime> selectPageIsAdmin(Pagination paging);
	
	@Select("select * from dnltime where dnlno=#{dnlno} order by dnlno")
	Dnltime selectByDnlno(int dnlno);
	Dnltime selectByDnlnoWithDnl(int dnlno);
	Dnltime selectByDnlnoWithMember(int dnlno);
	
	int insert(Dnltime dnltime);
	
	int updateByDnlno(Dnltime dnltime);
	
	@Delete("delete from dnltime where dnlno=#{dnlno}")
	int deleteByDnlno(int dnlno);
	

}
