package com.example.hr_project.repository;

import com.example.hr_project.model.entity.MailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<MailEntity, Long>, JpaSpecificationExecutor<MailEntity> {
}
