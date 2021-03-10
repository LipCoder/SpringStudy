package org.zerock.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	// xml에서 처리
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	// INSERT
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	
	// READ
	public BoardVO read(Long bno);
	
	// DELETE
	public int delete(Long bno);
	
	// UPDATE
	public int update(BoardVO board);
	
}
