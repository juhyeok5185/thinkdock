package com.danny.quizworld.exam.question;

import com.danny.quizworld.course.chapter.ChapterResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QuestionResponse {
    private Long questionId; // 회원 일련번호
    private ChapterResponse chapter;
    private QuestionType type;
    private String questionText;
    private String description;
}
