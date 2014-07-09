package hello;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.cuwy1.model1.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class HelloController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "/addDepartmentNewPatien", method = RequestMethod.POST)
	public @ResponseBody Department addDepartmentNewPatien(@RequestBody Department department) {
		logger.info("Start addDepartmentNewPatien.");
		logger.warn("\n department = "+department);
		writeTofile(department);
		return department;
	}

	String filePfadBase = "/home/roman/Documents/01_curepathway/work1/cuwy_sb2w_template_3/";
	String filePfad = filePfadBase + "src/main/webapp/db/";
	//surgical intensive care unit (SICU)
	String fileName = "departmentSICU.json";

	private void writeTofile(Department department) {
		File file = new File(filePfad+fileName);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writerWithDefaultPrettyPrinter = mapper.writerWithDefaultPrettyPrinter();
		try {
//			logger.warn(writerWithDefaultPrettyPrinter.writeValueAsString(department));
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			writerWithDefaultPrettyPrinter.writeValue(fileOutputStream, department);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/i", method=RequestMethod.GET)
	public String index() {
		return "index_t";
	}

}
