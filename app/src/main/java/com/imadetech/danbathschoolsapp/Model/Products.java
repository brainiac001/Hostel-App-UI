package com.imadetech.danbathschoolsapp.Model;

public class Products {
    private String pname, pdescription, price, image, category, pid, date, time, phone, password, gender, email,
    admissionnumber, dateofbirth,  feesamount, amountpaid, feesbalance, teachercomment, headofschoolcomment,
            term, session, firstyear, secondyear, subject,teachername,
                    weight,
                        height, age,
                      noinclass,
                        nooftimesschoolopened,
                        nooftimespresent,
                        nooftimesabsent, assignedclass,
                     state, town, lga, religion, parentname, homeaddress,
            officeaddress, officephonenumber, nationalid, sessionandterm;
    private int pno;
    private long  test, exam, totalscore;
    public Products()
    {

    }
    public Products(long test, long exam, long totalscore, String pname, String image, String category,
                    String pid, String date, String time,
                    String pdescription, int pno, String phone, String password, String gender, String email,
                    String admissionnumber, String dateofbirth,  String feesamount, String amountpaid,
                    String feesbalance, String teachercomment, String headofschoolcomment, String term,
                    String session, String firstyear, String secondyear, String subject, String teachername, String weight,
                    String height, String age, String noinclass, String nooftimesschoolopened,
                    String nooftimespresent, String nooftimesabsent, String assignedclass,
                    String state,  String town,  String lga,  String religion,  String parentname,  String homeaddress,
                    String officeaddress,  String officephonenumber,  String nationalid, String sessionandterm) {
        this.pname = pname;
            this.image = image;
        this.category = category;
        this.pid = pid;
        this.date = date;
        this.time = time;
        this.pdescription = pdescription;
        this.pno = pno;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.admissionnumber = admissionnumber;
        this.dateofbirth = dateofbirth;
        this.feesamount = feesamount;
        this.amountpaid = amountpaid;
        this.feesbalance = feesbalance;
        this.teachercomment = teachercomment;
        this.headofschoolcomment = headofschoolcomment;
        this.term = term;
        this.session = session;
        this.firstyear = firstyear;
        this.secondyear = secondyear;
        this.test = test;
        this.exam = exam;
        this.totalscore = totalscore;
        this.subject = subject;
        this.teachername = teachername;
        this.age =age;
        this.weight = weight;
        this.height = height;
        this.noinclass = noinclass;
        this.nooftimesabsent = nooftimesabsent;
        this.nooftimespresent = nooftimespresent;
        this.nooftimesschoolopened = nooftimesschoolopened;
        this.assignedclass = assignedclass;
        this.state = state;
        this.town = town;
        this.lga = lga;
        this.religion = religion;
        this.parentname = parentname;
        this.homeaddress = homeaddress;
        this.officeaddress = officeaddress;
        this.officephonenumber = officephonenumber;
        this.nationalid = nationalid;
        this.sessionandterm = sessionandterm;
    }
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

     public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getPdescription() {
        return pdescription;
    }
    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public int  getPno() {
        return pno;
    }
    public void setPno(int pno) {
        this.pno= pno;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    public String  getAdmissionnumber() {
        return admissionnumber;
    }
    public void setAdmissionnumber(String admissionnumber) {
        this.admissionnumber= admissionnumber;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth= dateofbirth;
    }

    public String getFeesamount() {
        return feesamount;
    }
    public void setFeesamount(String feesamount) {
        this.feesamount = feesamount;
    }

    public String getAmountpaid() {
        return amountpaid;
    }
    public void setAmountpaid(String amountpaid) {
        this.amountpaid = amountpaid;
    }

    public String getFeesbalance() {
        return feesbalance;
    }
    public void setFeesbalance(String feesbalance) {
        this.feesbalance = feesbalance;
    }

    public String getTeachercomment() {
        return teachercomment;
    }
    public void setTeachercomment(String teachercomment) {
        this.teachercomment = teachercomment;
    }

    public String getHeadofschoolcomment() {
        return headofschoolcomment;
    }
    public void setHeadofschoolcomment(String headofschoolcomment) {
        this.headofschoolcomment = headofschoolcomment;
    }

    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }


    public String getSession() {
        return session;
    }
    public void setSession(String session) {
        this.session = session;
    }


    public String getFirstyear() {
        return firstyear;
    }
    public void setFirstyear(String firstyear) {
        this.firstyear = firstyear;
    }


    public String getSecondyear() {
        return secondyear;
    }
    public void setSecondyear(String secondyear) {
        this.secondyear = secondyear;
    }

    public long getTest() {
        return test;
    }
    public void setTest(long test) {
        this.test = test;
    }

    public long getExam() {
        return exam;
    }
    public void setExam(long exam) {
        this.exam = exam;
    }

    public long getTotalscore() {
        return totalscore;
    }
    public void setTotalscore(long totalscore) {
        this.totalscore = totalscore;
    }


    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeachername() {
        return teachername;
    }
    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNoinclass() {
        return noinclass;
    }
    public void setNoinclass(String noinclass) {
        this.noinclass = noinclass;
    }

    public String getNooftimesschoolopened() {
        return nooftimesschoolopened;
    }
    public void setNooftimesschoolopened(String nooftimesschoolopened) {
        this.nooftimesschoolopened = nooftimesschoolopened;
    }

    public String getNooftimespresent() {
        return nooftimespresent;
    }
    public void setNooftimespresent(String nooftimespresent) {
        this.nooftimespresent = nooftimespresent;
    }

    public String getNooftimesabsent() {
        return nooftimesabsent;
    }
    public void setNooftimesabsent(String nooftimesabsent) {
        this.nooftimesabsent = nooftimesabsent;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getTown() {
        return town;
    }
    public void setTown(String  town) {
        this. town =  town;
    }

    public String getLga() {
        return lga;
    }
    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getReligion() {
        return religion;
    }
    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getParentname() {
        return parentname;
    }
    public void setParentname(String parentname) {
        this.parentname = parentname;
    }


    public String getHomeaddress() {
        return homeaddress;
    }
    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getOfficeaddress() {
        return officeaddress;
    }
    public void setOfficeaddress(String  officeaddress) {
        this.officeaddress =  officeaddress;
    }

    public String getOfficephonenumber() {
        return officephonenumber;
    }
    public void setOfficephonenumber(String officephonenumber) {
        this.officephonenumber = officephonenumber;
    }

    public String getNationalid() {
        return nationalid;
    }
    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }

    public String getAssignedclass() {
        return assignedclass;
    }
    public void setAssignedclass(String assignedclass) {
        this.assignedclass = assignedclass;
    }

    public String getSessionandterm() {
        return sessionandterm;
    }
    public void setSessionandterm(String sessionandterm) {
        this.sessionandterm = sessionandterm;
    }

}
