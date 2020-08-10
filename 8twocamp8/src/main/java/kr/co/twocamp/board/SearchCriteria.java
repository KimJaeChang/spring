package kr.co.twocamp.board;

//검색처리
public class SearchCriteria extends Criteria{
	private String searchType;
	private String keywrod;
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeywrod() {
		return keywrod;
	}
	public void setKeywrod(String keywrod) {
		this.keywrod = keywrod;
	}
	
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keywrod=" + keywrod + "]";
	}
	
	
	

}
