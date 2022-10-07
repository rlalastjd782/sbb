package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    @Test
    void contextLoads() {
    }

/*  create 부분 테스트
    @Test
    void testJpa(){
        //1질문
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가");
        q1.setContent("sbb가 무엇인지 알고 싶다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        //2질문
        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장

    }*/
/*
Read 부분
assertEquals 를 이용하여 같은지 찾기
    @Test
    void testJpa(){
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2,all.size());

        Question q = all.get(0);
        //assertEquals 는 assertEquals(기대값, 실제값) 과 같이 사용하고
        // 기대값과 실제값이 동일하지 조사한다.
        assertEquals("sbb가 무엇인가", q.getSubject());
    }*/

/*    @Test
    void testJpa(){
        //findAll, findById 등 모드  jpaRepository 안에 들어있엇구나....
        // 왜 이게 맞는지 이제 알겟구나....
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()){
            Question q = oq.get();
            assertEquals("sbb가 무엇인가", q.getSubject());
        }
    }*/

/*findBySubject 조회
    @Test
    void testJpa() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가");
        assertEquals(1, q.getId());
    }*/

/*    @Test
    void testJpa() {
        Question q = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가", "sbb가 무엇인지 알고 싶다.");
        assertEquals(1, q.getId());
    }*/
/*
    update문
    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);

    }*/
/*
        // 삭제하기
    @Test
    void testJpa() {
        assertEquals(2, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());
    }
*/
/*
    // 답변생성하기
    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }*/

/*    답변조회하기
    @Test
    void testJpa() {
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }*/


/*
    //답변에 연결된 질문 찾기
    //@Transactional 애너테이션을 사용하면 메서드가 종료될 때까지 DB 세션이 유지된다.
    @Transactional
    @Test
    void testJpa() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
*/
    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }
    }


}