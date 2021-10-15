package infotourisme;

import java.util.Date;



public class Reclamation {
	
	private long id ;
	private String content;
	
	private Date DateReclamation ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateReclamation() {
		return DateReclamation;
	}

	public void setDateReclamation(Date dateReclamation) {
		DateReclamation = dateReclamation;
	}

	public Reclamation(long id, String content,Date date ) {
		this.content=content;
		this.id=id;
		this.DateReclamation=date;
	}

	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", content=" + content + ", DateReclamation=" + DateReclamation + "]";
	}

}
