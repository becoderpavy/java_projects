package com.enotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import com.enotes.entites.*;

public interface NotesRepository extends JpaRepository<Notes, Integer> {

	
	List<Notes> findByUserId(int id);
	
}
