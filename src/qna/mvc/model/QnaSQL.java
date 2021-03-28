package qna.mvc.model;

class QnaSQL {
	final static String LIST="select * from pd_qna order by qna_mgrp desc, qna_mseq asc";
	final static String LIST_D="select * from pd_qna where pd_id=? order by qna_mgrp desc, qna_mseq asc";
	final static String CONTENT="select * from pd_qna where qna_id=?";
	final static String INSERT
	    =" insert into pd_qna values(pd_qna_qna_id.nextval,pd_qna_qna_mgrp.nextval,0,0,?,?,SYSDATE,1,?)";
	final static String INSERT_RE
    =" insert into pd_qna values(pd_qna_qna_id.nextval,?,1,1,?,?,SYSDATE,1,?)";
	final static String DEL= "delete from pd_qna where qna_id=?";
}
