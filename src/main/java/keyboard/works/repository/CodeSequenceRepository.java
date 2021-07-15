package keyboard.works.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import keyboard.works.entity.CodeSequence;

@Repository
public interface CodeSequenceRepository extends JpaRepository<CodeSequence, Integer>{

	@Lock(LockModeType.PESSIMISTIC_READ)
	CodeSequence findByPrefix(String prefix);
	
}
