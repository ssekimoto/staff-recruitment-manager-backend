package com.example.staffrecruitmentmanagerbackend.controller;

import com.example.staffrecruitmentmanagerbackend.model.Job;
import com.example.staffrecruitmentmanagerbackend.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")


public class JobController {

    @Autowired
    private JobRepository jobRepository;

    // 全ての求人情報を取得
    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // 新しい求人情報を作成
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    // 特定の求人情報を取得
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
        return ResponseEntity.ok(job);
    }

    // 求人情報を更新
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job jobDetails) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));

        job.setTitle(jobDetails.getTitle());
        job.setType(jobDetails.getType());
        job.setSalary(jobDetails.getSalary());
        job.setLocation(jobDetails.getLocation());
        job.setDeadline(jobDetails.getDeadline());
        job.setDescription(jobDetails.getDescription());

        Job updatedJob = jobRepository.save(job);
        return ResponseEntity.ok(updatedJob);
    }

    // 給与情報のみを更新 (追加)
    @PatchMapping("/{id}/salary")
    public ResponseEntity<Job> updateJobSalary(@PathVariable Long id, @RequestBody Map<String, Double> salaryUpdate) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));

        if (salaryUpdate.containsKey("salary")) {
            job.setSalary(salaryUpdate.get("salary"));
            Job updatedJob = jobRepository.save(job);
            return ResponseEntity.ok(updatedJob); 
        } else {
            return ResponseEntity.badRequest().body("Missing 'salary' key in request body"); // "salary" キーがない場合はエラー
        }
    }


    // 求人情報を削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));

        jobRepository.delete(job);
        return ResponseEntity.noContent().build();
    }
}
