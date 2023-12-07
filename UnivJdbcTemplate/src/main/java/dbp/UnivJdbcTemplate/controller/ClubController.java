package dbp.UnivJdbcTemplate.controller;

import dbp.UnivJdbcTemplate.entity.Club;
import dbp.UnivJdbcTemplate.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ClubController {
    @Autowired
    ClubRepository clubRepository;

    @GetMapping("/all")     //club 테이블 전체 검색
    public List<Club> getAllClubs(){
        return clubRepository.getAllClubs();
    }

    @GetMapping("/id/{id}")
    public Optional<Club> getClub(@PathVariable int id){
        return clubRepository.getClub(id);
    }

    @GetMapping("/addClub")
    public String addClub(@RequestParam("id") int id, @RequestParam("name") String name,
                          @RequestParam("category") String category){
        if (clubRepository.addClub(id, name, category) >= 1) {
            return "Club Added";
        } else {
            return "Not Added";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClub(@PathVariable int id){
        if (clubRepository.deleteClub(id) >= 1) {
            return "Club Deleted";
        } else {
            return "Not Deleted";
        }
    }
}
