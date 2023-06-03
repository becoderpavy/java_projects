package com.enotes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enotes.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes, Long> {

	
	@Query("from Notes as n where n.UserDtls.id=:uid")
	Page<Notes> findNotesByUser(@Param("uid") long uid,Pageable p);

}
