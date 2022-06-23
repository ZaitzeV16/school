package hu.wurfel.refference.school.diary;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DiaryCrudService {
    @Autowired
    private DiaryRepository diaryRepository;

    public ArrayList<Diary> getAllDiaries() {
        return new ArrayList<Diary>(diaryRepository.findAll());
    }

    public Diary getDiaryByDiaryid(Integer Id) {
        return diaryRepository.findById(Id).get();
    }

    public ArrayList<Diary> getDiariesByScid(Long scid) {
        return diaryRepository.findAllByStudentId(scid);
    }

    public ArrayList<Diary> getDiariesByClassid(Integer cid) {
        return diaryRepository.findAllByClassID(cid);
    }

    public Diary getDiaryByScidAndClassid(Long scid, Integer cid) {
        return diaryRepository.findByStudentIdAndClassID(scid, cid).get();
    }

    public Diary saveDiary(@NotNull Diary diary) {
        diaryRepository.save(diary);
        return getDiaryByDiaryid(diary.getId());
    }

    public Diary saveDiary(Integer did, Long scid, Integer cid) {
        return saveDiary(new Diary(did, scid, cid));
    }

    public Diary setDiaryId(@NotNull Diary diary, Integer did) {
        diary.setId(did);
        return saveDiary(diary);
    }

    public Diary setDiaryScid(@NotNull Diary diary, Long scid) {
        diary.setStudentId(scid);
        return saveDiary(diary);
    }

    public Diary setDiaryCid(@NotNull Diary diary, Integer cid) {
        diary.setClassID(cid);
        return saveDiary(diary);
    }

    public void deleteDiary(@NotNull Diary diary) {
        diaryRepository.delete(diary);
    }
}
