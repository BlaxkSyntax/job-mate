package za.co.wethinkcode.app.model;

/**
*/
public class Jobs {
   
    private int id;
    private String position;
    private String area;
    private String jobtype;
    private String jobDescription;
    private String responsibilities;
    private String qualifications;
    private String benefits;
    private String startDate;
    private String endDate;
    private String applicationtype;
    private String contact;

    public String getContact() {
        return contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getApplicationtype() {
        return applicationtype;
    }

    public void setApplicationtype(String applicationtype) {
        this.applicationtype = applicationtype;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override
    public String toString(){
        return "{"+
                    "\"id\" :" +"\""+ getId()+"\""+","+
                    "\"position\" :" +"\""+ getPosition()+"\""+","+
                    "\"area\" :" +"\""+ getArea()+"\""+","+
                    "\"jobtype\" :" +"\""+ getJobtype()+"\""+","+
                    "\"jobDescription\" :" +"\""+ getJobDescription()+"\""+","+
                    "\"responsibilities\" :" +"\""+ getResponsibilities()+"\""+","+
                    "\"qualifications\" :" +"\""+ getQualifications()+"\""+","+
                    "\"benefits\" :" +"\""+ getBenefits()+"\""+","+
                    "\"startDate\" :" +"\""+ getStartDate()+"\""+","+
                    "\"endDate\" :" +"\""+ getEndDate()+"\""+","+
                    "\"applicationtype\" :" +"\""+ getApplicationtype()+"\""+","+
                    "\"contact\" :" +"\""+ getContact()+"\""+
                "}";
    }
    
}
