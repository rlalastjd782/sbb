package com.mysite.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//리파지토리로 만들기위해 jpa 상속
//JpaRepository<엔티티의 타입, pk 속성의 타입>
public interface QuestionRepository extends JpaRepository<Question, Integer> {
        Question findBySubject(String subject);

        Question findBySubjectAndContent(String subject, String content);

        List<Question> findBySubjectLike(String subject);
}

