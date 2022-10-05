package za.co.wethinkcode.database.model;

import net.lemnik.eodsql.ResultColumn;

/**
*/
public class Jobs {
    
    private String id;
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

    public String getId() {
        return id;
    }

    @ResultColumn( value = "id" )
    public void setId(String id) {
        this.id = id;
    }

    @ResultColumn( value = "contact" )
    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getApplicationtype() {
        return applicationtype;
    }

    @ResultColumn( value = "applicationtype" )
    public void setApplicationtype(String applicationtype) {
        this.applicationtype = applicationtype;
    }

    public String getEndDate() {
        return endDate;
    }

    @ResultColumn( value = "endDate" )
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    @ResultColumn( value = "startDate" )
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getBenefits() {
        return benefits;
    }

    @ResultColumn( value = "benefits" )
    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getQualifications() {
        return qualifications;
    }

    @ResultColumn( value = "qualifications" )
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    @ResultColumn( value = "responsibilities" )
    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    @ResultColumn( value = "jobDescription" )
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobtype() {
        return jobtype;
    }

    @ResultColumn( value = "jobtype" )
    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    public String getArea() {
        return area;
    }

    @ResultColumn( value = "area" )
    public void setArea(String area) {
        this.area = area;
    }

    public String getPosition() {
        return position;
    }

    @ResultColumn( value = "position" )
    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override
    public String toString(){
        return "{"+
                    "\"id\" :"+"\""+getId()+"\","+
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
