package usyd.elec5619.ratemycourse.domain;



public class RateCoursePageInfo {
	private String id;
	private int rating;
	private int difficulty;
	private boolean textBook;
	private boolean ifCredit;
	private String tagsString;
	private String[] tags;
	private String spec;
	private int grade;
	private String major;
	
	
	public RateCoursePageInfo(String id, int rating, int difficulty, boolean textBook, boolean ifCredit, String tagsString, String spec, int grade, String major) {
		this.id = id;
		this.rating = rating;
		this.difficulty = difficulty;
		this.textBook = textBook;
		this.ifCredit = ifCredit;
		this.tagsString = tagsString;
		this.tags = toArray(tagsString);
		this.spec = spec;
		this.grade = grade;
		this.major = major;
		
	}
	private String[] toArray(String tagsString) {
		if(tagsString  == null) {
			return new String[0];
		}
		String[] ret = tagsString.split(",");
		return ret;
	}
	
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
    
    public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public boolean isIfCredit() {
		return ifCredit;
	}

	public void setIfCredit(boolean ifCredit) {
		this.ifCredit = ifCredit;
	}

	public boolean isTextBook() {
		return textBook;
	}

	public void setTextBook(boolean textBook) {
		this.textBook = textBook;
	}
	
	public String[] getTags(){
		return tags;
	}
	
	public void setTags(String[] tags) {
		this.tags = tags;
		this.tagsString = this.joinString(tags);
	}
	
	private String joinString(String[] tags) {
		if(tags == null) {
			return "";
		}
		return String.join(",", tags);
	}
	
	public String getTagsString() {
		return this.tagsString;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	
	
	
}
