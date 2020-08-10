package kr.co.twocamp.camp;

public class CampBean {
	private int cno;
	private String cname;
	private String oname;
	private String ckinds;
	private String caddress;
	private String cnum;
	private int cparking;
	private String cfacility;
	private String csafety;
	private String cfacility2;
	private String cmnum;
	private String cmname;
//	private boolean cclose;
	
	private String se;

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getCkinds() {
		return ckinds;
	}

	public void setCkinds(String ckinds) {
		this.ckinds = ckinds;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public int getCparking() {
		return cparking;
	}

	public void setCparking(int cparking) {
		this.cparking = cparking;
	}

	public String getCfacility() {
		return cfacility;
	}

	public void setCfacility(String cfacility) {
		this.cfacility = cfacility;
	}

	public String getCsafety() {
		return csafety;
	}

	public void setCsafety(String csafety) {
		this.csafety = csafety;
	}

	public String getCfacility2() {
		return cfacility2;
	}

	public void setCfacility2(String cfacility2) {
		this.cfacility2 = cfacility2;
	}

	public String getCmnum() {
		return cmnum;
	}

	public void setCmnum(String cmnum) {
		this.cmnum = cmnum;
	}

	public String getCmname() {
		return cmname;
	}

	public void setCmname(String cmname) {
		this.cmname = cmname;
	}

//	public boolean isCclose() {
//		return cclose;
//	}
//
//	public void setCclose(boolean cclose) {
//		this.cclose = cclose;
//	}

	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}

	@Override
	public String toString() {
		return "campBean [cno=" + cno + ", cname=" + cname + ", oname=" + oname + ", ckinds=" + ckinds + ", caddress="
				+ caddress + ", cnum=" + cnum + ", cparking=" + cparking + ", cfacility=" + cfacility + ", csafety="
				+ csafety + ", cfacility2=" + cfacility2 + ", cmnum=" + cmnum + ", cmname=" + cmname + ", cclose="
				+ //cclose +
				", se=" + se + "]";
	}
	
	
		
}
