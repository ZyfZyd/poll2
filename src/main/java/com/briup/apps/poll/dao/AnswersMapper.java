package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    long countByExample(AnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    int deleteByExample(AnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    int insert(Answers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    int insertSelective(Answers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    List<Answers> selectByExample(AnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    Answers selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    int updateByExampleSelective(@Param("record") Answers record, @Param("example") AnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    int updateByExample(@Param("record") Answers record, @Param("example") AnswersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    int updateByPrimaryKeySelective(Answers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_answers
     *
     * @mbg.generated Mon Jun 25 10:20:51 CST 2018
     */
    int updateByPrimaryKey(Answers record);
}