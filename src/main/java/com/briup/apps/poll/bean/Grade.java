package com.briup.apps.poll.bean;

public class Grade {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_grade.id
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_grade.name
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_grade.school_id
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    private Long schoolId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column poll_grade.descriptioin
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    private String descriptioin;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_grade.id
     *
     * @return the value of poll_grade.id
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_grade.id
     *
     * @param id the value for poll_grade.id
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_grade.name
     *
     * @return the value of poll_grade.name
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_grade.name
     *
     * @param name the value for poll_grade.name
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_grade.school_id
     *
     * @return the value of poll_grade.school_id
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    public Long getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_grade.school_id
     *
     * @param schoolId the value for poll_grade.school_id
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column poll_grade.descriptioin
     *
     * @return the value of poll_grade.descriptioin
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    public String getDescriptioin() {
        return descriptioin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column poll_grade.descriptioin
     *
     * @param descriptioin the value for poll_grade.descriptioin
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    public void setDescriptioin(String descriptioin) {
        this.descriptioin = descriptioin == null ? null : descriptioin.trim();
    }
}