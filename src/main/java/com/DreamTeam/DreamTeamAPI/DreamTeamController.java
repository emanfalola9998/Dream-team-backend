package com.DreamTeam.DreamTeamAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @CrossOrigin(origins = "http://localhost:5174")
    public class DreamTeamController{

        @Autowired
        DreamTeamService dreamTeamService;



        @ExceptionHandler
        public ResponseEntity<String> handleExceptions(DreamTeamNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }

        // CREATE

        @PostMapping("/dream-team")
        public ResponseEntity<DreamTeam> createDreamTeam(@RequestBody DreamTeam dreamTeam){
            dreamTeamService.addDreamTeam(dreamTeam);
            return ResponseEntity.status(HttpStatus.CREATED).body(dreamTeam);
        }

        // READ

        @GetMapping("/dream-teams")
        public List<DreamTeam> getDreamTeams() {
            return dreamTeamService.getAllDreamTeams();
        }

        @GetMapping("/dream-team/random")
        public ResponseEntity<DreamTeam> getRandomDreamTeam() {
            return ResponseEntity.status(HttpStatus.OK).body(dreamTeamService.getRandomDreamTeam());
        }

        @GetMapping("/dream-team/ids")
        public ResponseEntity<List<Long>> getDreamTeamIds(){
            return ResponseEntity.status(HttpStatus.OK).body(dreamTeamService.getDreamTeamIds());
        }

        @GetMapping("/dream-team/{id}")
        public ResponseEntity<DreamTeam> getDreamTeamById(@PathVariable long id){
            return ResponseEntity.status(HttpStatus.OK).body(dreamTeamService.getDreamTeamById(id));
        }

        @PutMapping("/dream-team/{id}")
        public ResponseEntity<DreamTeam> updateDreamTeam(@RequestBody DreamTeam newDreamTeam, @PathVariable long id){
            newDreamTeam.setId(id);
            dreamTeamService.updateDreamTeam(newDreamTeam, id);
            return ResponseEntity.status(HttpStatus.OK).body(newDreamTeam);
        }






    }

