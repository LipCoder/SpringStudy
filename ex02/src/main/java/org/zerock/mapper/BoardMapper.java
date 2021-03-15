package org.zerock.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	
	// xml에서 처리
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	// 페이징 처리
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	// INSERT
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	
	// READ
	public BoardVO read(Long bno);
	
	// DELETE
	public int delete(Long bno);
	
	// UPDATE
	public int update(BoardVO board);
	
	// 총 개수
	public int getTotalCount(Criteria cri);
}
