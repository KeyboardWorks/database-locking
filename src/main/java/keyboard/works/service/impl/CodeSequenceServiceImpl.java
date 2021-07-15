package keyboard.works.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import keyboard.works.entity.CodeSequence;
import keyboard.works.repository.CodeSequenceRepository;
import keyboard.works.service.CodeSequenceService;

@Service
@Transactional
public class CodeSequenceServiceImpl implements CodeSequenceService {

	@Autowired
	private CodeSequenceRepository codeSequenceRepository;
	
	@Override
	public CodeSequence incrementByOne(String prefix) {
		
		CodeSequence codeSequence = codeSequenceRepository.findByPrefix("test");
		
		codeSequence.setSequence(codeSequence.getSequence() + 1);
		
		codeSequence = codeSequenceRepository.save(codeSequence);
		
		return codeSequence;
	}

}
