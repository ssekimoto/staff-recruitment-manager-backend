package com.example.staffrecruitmentmanagerbackend.repository;

import com.example.staffrecruitmentmanagerbackend.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // List をインポート

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // カスタムクエリを追加

    /**
     * タイトル、勤務地、または職種にキーワードが含まれる求人情報を検索します (大文字小文字を区別しない)。
     * @param keyword 検索キーワード
     * @return 条件に一致する求人情報のリスト
     */
    List<Job> findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCaseOrTypeContainingIgnoreCase(String keyword, String keyword2, String keyword3); // 同じキーワードを3回渡す
}
