package com.kclm.owep.entity;

import java.io.Serializable;

public class ExamPaperTopicQuesset implements Serializable {
    /*
    * 主键
    * */
    private Integer id;

    /*
    * paper_id (fk)
    * */
    private ExamPaper examPaper;

    /*
    * topic_id(fk)
    * */
    private ExamPaperTopic examPaperTopic;

    /*
    * ques_id(fk)
    * */
    private ExamQues examQues;

    /*
    * 试题题干
    * */
    private String quesContent;

    /*
    * 分值
    * */
    private double score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExamPaper getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }

    public ExamPaperTopic getExamPaperTopic() {
        return examPaperTopic;
    }

    public void setExamPaperTopic(ExamPaperTopic examPaperTopic) {
        this.examPaperTopic = examPaperTopic;
    }

    public ExamQues getExamQues() {
        return examQues;
    }

    public void setExamQues(ExamQues examQues) {
        this.examQues = examQues;
    }

    public String getQuesContent() {
        return quesContent;
    }

    public void setQuesContent(String quesContent) {
        this.quesContent = quesContent;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ExamPaperTopicQuesset{" +
                "id=" + id +
                ", examPaper=" + examPaper +
                ", examPaperTopic=" + examPaperTopic +
                ", examQues=" + examQues +
                ", quesContent='" + quesContent + '\'' +
                ", score=" + score +
                '}';
    }

    public ExamPaperTopicQuesset() {
    }
}
