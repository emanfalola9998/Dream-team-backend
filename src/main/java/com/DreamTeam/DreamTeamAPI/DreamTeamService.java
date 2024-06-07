package com.DreamTeam.DreamTeamAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DreamTeamService {
    @Autowired
    DreamTeamRepository dreamTeamRepository;

    // CREATE

    public void addDreamTeam(DreamTeam dreamTeam){
        dreamTeamRepository.save(dreamTeam);
    }

    // READ

    public DreamTeam getDreamTeamById(long id){
        Optional<DreamTeam> dreamTeam = dreamTeamRepository.findById(id);

        if(dreamTeam.isEmpty()){
            throw new DreamTeamNotFoundException();
        }
        return dreamTeam.get();
    }

    public DreamTeam getRandomDreamTeam(){
        return dreamTeamRepository.getRandomDreamTeam();
    }

    public List<Long> getDreamTeamIds() {
        return dreamTeamRepository.getDistinctIds();
    }

    public List<DreamTeam> getAllDreamTeams(){
        return dreamTeamRepository.findAll();
    }

    public void updateDreamTeam(DreamTeam newDreamTeam, long id) {
        if (!dreamTeamRepository.existsById(id)) {
            throw new DreamTeamNotFoundException();
        }

        newDreamTeam.setId(id);
        dreamTeamRepository.save(newDreamTeam);
    }
}
