package com.danny.quizworld.course.study;

import com.danny.quizworld.common.response.ApiResponse;
import com.danny.quizworld.common.util.Utils;
import com.danny.quizworld.course.CourseFacade;
import com.danny.quizworld.course.chapter.ChapterRequest;
import com.danny.quizworld.course.chapter.ChapterResponse;
import com.danny.quizworld.course.subject.SubjectRequest;
import com.danny.quizworld.course.subject.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses/subjects/chapters")
public class StudyApiController {

    private final CourseFacade courseFacade;


    @PostMapping("/{chapterId}/study")
    public ResponseEntity<ApiResponse<StudyResponse>> saveStudy(@PathVariable Long chapterId, @ModelAttribute StudyRequest request) {
        courseFacade.saveStudy(chapterId, request);
        return ResponseEntity.status(201).body(new ApiResponse<>("생성 성공", 201, null));
    }

    @GetMapping("/{chapterId}/study")
    public ResponseEntity<ApiResponse<List<StudyResponse>>> findAllStudyByChapterId(@PathVariable Long chapterId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findAllStudyByChapterId(chapterId)));
    }

    @GetMapping("/study/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> findStudyById(@PathVariable Long studyId) {
        return ResponseEntity.ok(new ApiResponse<>(courseFacade.findStudyById(studyId)));
    }

    @PatchMapping("/study/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> updateStudy(@PathVariable Long studyId , @ModelAttribute StudyRequest request){
        courseFacade.updateStudy(studyId , request);
        return ResponseEntity.ok(new ApiResponse<>("변경 성공", 201, null));
    }

    @DeleteMapping("/study/{studyId}")
    public ResponseEntity<ApiResponse<StudyResponse>> deleteStudyById(@PathVariable Long studyId) {
        courseFacade.deleteStudyById(studyId);
        return ResponseEntity.status(201).body(new ApiResponse<>("삭제 완료" , 201 ,null));
    }

}
