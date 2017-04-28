package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Dnl;
import com.example.util.Pagination;

@Mapper
public interface DnlMapper {
	
	@Select("select count(*) from dnl")
	int selectTotalCount();

	@Select("select * from dnl")
	List<Dnl> selectAll();
	List<Dnl> selectAllWithDnltime();
	
	@Select({
		"select * 							",
		"  from dnl							",
		" order by dnl_code					",
		"offset #{firstItem} -1 rows		",
		" fetch next #{itemsPerPage} rows only"
	})
	List<Dnl> selectPage(Pagination paging);
	List<Dnl> selectPageWithDnltime(Pagination paging);
	
	@Select("select * from dnl where dnl_code=#{dnlCode}")
	Dnl selectByDnlCode(int dnlCode);
	Dnl selectByDnlCodeWithDnltime(int dnlCode);
	
	int insert(Dnl dnl);
	
	int updateByDnlno(Dnl dnl);
	
	@Delete("delete from dnl where dnlCode=#{dnl_code}")
	int deleteByDnlno(int dnlCode);
}
