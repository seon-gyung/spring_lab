package site.metacoding.serverproject.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 생략 가능
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}