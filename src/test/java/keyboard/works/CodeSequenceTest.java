package keyboard.works;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import keyboard.works.entity.CodeSequence;
import keyboard.works.service.CodeSequenceService;

@SpringBootTest
@Sql(scripts = {"/sql/delete-code-sequence.sql", "/sql/insert-code-sequence.sql"})
public class CodeSequenceTest {

	@Autowired
	private CodeSequenceService codeSequenceService;
	
	@Test
	public void incrementCodeSequence() throws InterruptedException {
		
		for (int i = 0; i < 10; i++) {
			incrementSequenceAsync();
		}
		
		Thread.sleep(5_000);
	}
	
	private void incrementSequenceAsync() {
		new Thread(() -> {
			CodeSequence codeSequence = codeSequenceService.incrementByOne("test");
			
			System.out.println(codeSequence.getSequence());
		}).start();
	}
	
}
