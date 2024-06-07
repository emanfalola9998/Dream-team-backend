package com.DreamTeam.DreamTeamAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DreamTeamRepository extends JpaRepository<DreamTeam, Long> {
    // READ
    @Query(value="SELECT DISTINCT id FROM team_data ", nativeQuery = true)
    List<Long> getDistinctIds();

    @Query(value="SELECT * FROM team_data ORDER BY RAND() LIMIT 1", nativeQuery = true)
    DreamTeam getRandomDreamTeam();

    // Custom implementation of findAll()
    @Query(value="SELECT * FROM team_data", nativeQuery = true)
    List<DreamTeam> findAll();
}
